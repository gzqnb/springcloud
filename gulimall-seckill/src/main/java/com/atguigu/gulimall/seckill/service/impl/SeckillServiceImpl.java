package com.atguigu.gulimall.seckill.service.impl;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.atguigu.common.to.mq.SeckillOrderTo;
import com.atguigu.common.utils.R;
import com.atguigu.common.vo.MemberRespVo;
import com.atguigu.gulimall.seckill.feign.CouponFeignService;
import com.atguigu.gulimall.seckill.feign.ProductFeignService;
import com.atguigu.gulimall.seckill.interceptor.LoginUserInterceptor;
import com.atguigu.gulimall.seckill.service.SeckillService;
import com.atguigu.gulimall.seckill.to.SecKillSkuRedisTo;
import com.atguigu.gulimall.seckill.vo.SeckillSessionWithSkus;
import com.atguigu.gulimall.seckill.vo.SkuInfoVo;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Auther: gzq
 * @Date: 2021/4/5 - 04 - 05 - 9:32
 * @Description: com.atguigu.gulimall.seckill.service.impl
 */
@Service
@Slf4j
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    ProductFeignService productFeignService;

    @Autowired
    CouponFeignService couponFeignService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Autowired
    RabbitTemplate rabbitTemplate;

    private final String SESSIONS_CACHE_PREFIX = "seckill:sessions:";
    private final String SKUKILL_CACHE_PREFIX = "seckill:skus:";
    private final String SKU_STOCK_SEMAPHORE = "seckill:stock:";

    @Override
    public void uploadSecKillSkuLatest3Days() {
        //1.?????????????????????????????????
        R session = couponFeignService.getLates3DaysSession();
        if (session.getCode() == 0) {
            //????????????
            List<SeckillSessionWithSkus> sessionData = session.getData(new TypeReference<List<SeckillSessionWithSkus>>() {
            });
            //?????????redis
            saveSessionInfos(sessionData);
            //?????????????????????????????????
            saveSessionSkuInfos(sessionData);
        }
    }
    public List<SecKillSkuRedisTo> blockHandler(BlockException e){
        log.info("getCurrentSeckillSkusResouce????????????");
        return null;
    }

    @SentinelResource(value = "getCurrentSeckillSkusResouce",blockHandler = "blockHandler")
    @Override
    public List<SecKillSkuRedisTo> getCurrentSeckillSkus() {
        long time = new Date().getTime();

        try (Entry entry = SphU.entry("seckillSkus")) {
            Set<String> keys = redisTemplate.keys(SESSIONS_CACHE_PREFIX + "*");
            for (String key : keys) {
                String replace = key.replace(SESSIONS_CACHE_PREFIX, "");
                String[] s = replace.split("_");
                Long start = Long.parseLong(s[0]);
                Long end = Long.parseLong(s[1]);
                if (time >= start && time <= end) {
                    List<String> range = redisTemplate.opsForList().range(key, -100, 100);
                    //?????????string????????????range???string??????????????????????????????string
                    BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(SKUKILL_CACHE_PREFIX);
                    List<String> list = hashOps.multiGet(range);
                    if (list != null) {
                        List<SecKillSkuRedisTo> collect = list.stream().map(item -> {
                            SecKillSkuRedisTo redisTo = new SecKillSkuRedisTo();
                            SecKillSkuRedisTo redis = JSON.parseObject((String) item, SecKillSkuRedisTo.class);
//                        redis.setRandomCode();
                            return redis;
                        }).collect(Collectors.toList());
                        return collect;
                    }

                    break;
                }
            }

        } catch (BlockException e) {
            log.error("???????????????{}", e.getMessage());
        }

        return null;
    }

    @Override
    public SecKillSkuRedisTo getSkuSeckillInfo(Long skuId) {
        BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(SKUKILL_CACHE_PREFIX);
        Set<String> keys = hashOps.keys();
        if (keys != null && keys.size() > 0) {
            String regx = "\\d_" + skuId;
            for (String key : keys) {
                if (Pattern.matches(regx, key)) {
                    String json = hashOps.get(key);
                    SecKillSkuRedisTo skuRedisTo = JSON.parseObject(json, SecKillSkuRedisTo.class);

                    //?????????
                    long current = new Date().getTime();
                    if (current >= skuRedisTo.getStartTime() && current <= skuRedisTo.getEndTime()) {

                    } else {
                        skuRedisTo.setRandomCode(null);
                    }
                    return skuRedisTo;
                }
            }
        }
        return null;
    }

    @Override
    public String kill(String killId, String key, Integer num) {
        long s1 = System.currentTimeMillis();
        MemberRespVo respVo = LoginUserInterceptor.loginUser.get();
        //???????????????????????????????????????
        BoundHashOperations<String, String, String> hashOps = redisTemplate.boundHashOps(SKUKILL_CACHE_PREFIX);
        String json = hashOps.get(killId);
        if (StringUtils.isEmpty(json)) {
            return null;
        } else {
            SecKillSkuRedisTo redis = JSON.parseObject(json, SecKillSkuRedisTo.class);
            //???????????????
            Long startTime = redis.getStartTime();
            Long endTime = redis.getEndTime();
            long time = new Date().getTime();
            long ttl = endTime - time;
            //?????????????????????
            if (time >= startTime && time <= endTime) {

                //????????????????????????id
                String randomCode = redis.getRandomCode();
                String skuId = redis.getPromotionSessionId() + "_" + redis.getSkuId();
                if (randomCode.equals(key) && killId.equals(skuId)) {
                    //??????????????????????????????
                    if (num <= redis.getSeckillLimit()) {
                        //??????????????????????????????????????? ????????? ??????????????????????????????
                        String redisKey = respVo.getId() + "_" + skuId;
                        //???????????? setNx
                        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(redisKey, num.toString(), ttl, TimeUnit.MILLISECONDS);
                        if (aBoolean) {
                            //??????????????????????????????????????????????????????
                            RSemaphore semaphore = redissonClient.getSemaphore(SKU_STOCK_SEMAPHORE + randomCode);

                            boolean b = semaphore.tryAcquire(num);
                            if (b) {
                                //????????????
                                //?????????????????????mq??????
                                String timeId = IdWorker.getTimeId();
                                SeckillOrderTo orderTo = new SeckillOrderTo();
                                orderTo.setOrderSn(timeId);
                                orderTo.setMemberId(respVo.getId());
                                orderTo.setNum(num);
                                orderTo.setPromotionSessionId(redis.getPromotionSessionId());
                                orderTo.setSkuId(redis.getSkuId());
                                orderTo.setSeckillPrice(redis.getSeckillPrice());
                                rabbitTemplate.convertAndSend("order-event-exchange", "order.seckill.order",
                                        orderTo);

                                long s2 = System.currentTimeMillis();
                                log.info("??????...{}", (s2 - s1));
                                return timeId;
                            }
                            return null;

                        } else {
                            //?????????
                            return null;
                        }

                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    private void saveSessionInfos(List<SeckillSessionWithSkus> sessions) {
        if (sessions != null) {
            sessions.stream().forEach(session -> {
                Long startTime = session.getStartTime().getTime();
                Long endTime = session.getEndTime().getTime();
                String key = SESSIONS_CACHE_PREFIX + startTime + "_" + endTime;
                Boolean hasKey = redisTemplate.hasKey(key);
                if (!hasKey) {
                    List<String> collect = session.getRelationSkus().stream().map(item -> item.getPromotionSessionId() + "_" + item.getSkuId().toString()).collect(Collectors.toList());
                    redisTemplate.opsForList().leftPushAll(key, collect);
                }
            });
        }
    }

    private void saveSessionSkuInfos(List<SeckillSessionWithSkus> sessions) {

        sessions.stream().forEach(session -> {
            BoundHashOperations<String, Object, Object> ops = redisTemplate.boundHashOps(SKUKILL_CACHE_PREFIX);
            session.getRelationSkus().stream().forEach(seckillSkuVo -> {
                String token = UUID.randomUUID().toString().replace("-", "");
                if (!ops.hasKey(seckillSkuVo.getPromotionSessionId().toString() + "_" + seckillSkuVo.getSkuId().toString())) {
                    SecKillSkuRedisTo redisTo = new SecKillSkuRedisTo();

                    R skuInfo = productFeignService.getSkuInfo(seckillSkuVo.getSkuId());
                    if (skuInfo.getCode() == 0) {
                        SkuInfoVo info = skuInfo.getData("skuInfo", new TypeReference<SkuInfoVo>() {
                        });
                        redisTo.setSkuInfoVo(info);
                    }

                    BeanUtils.copyProperties(seckillSkuVo, redisTo);

                    redisTo.setStartTime(session.getStartTime().getTime());
                    redisTo.setEndTime(session.getEndTime().getTime());
                    //?????????
                    redisTo.setRandomCode(token);

                    String jsonString = JSON.toJSONString(redisTo);
                    ops.put(seckillSkuVo.getPromotionSessionId().toString() + "_" + seckillSkuVo.getSkuId().toString(), jsonString);
                    RSemaphore semaphore = redissonClient.getSemaphore(SKU_STOCK_SEMAPHORE + token);
                    semaphore.trySetPermits(seckillSkuVo.getSeckillCount());
                }

            });
        });
    }
}
