package com.atguigu.gulimall.seckill.service;

import com.atguigu.gulimall.seckill.to.SecKillSkuRedisTo;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/4/5 - 04 - 05 - 9:32
 * @Description: com.atguigu.gulimall.seckill.service
 */
public interface SeckillService {
    void uploadSecKillSkuLatest3Days();

    List<SecKillSkuRedisTo> getCurrentSeckillSkus();


    SecKillSkuRedisTo getSkuSeckillInfo(Long skuId);

    String kill(String killId, String key, Integer num);
}
