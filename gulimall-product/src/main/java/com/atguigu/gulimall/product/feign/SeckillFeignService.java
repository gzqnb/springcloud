package com.atguigu.gulimall.product.feign;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.feign.fallback.SeckillFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: gzq
 * @Date: 2021/4/5 - 04 - 05 - 14:09
 * @Description: com.atguigu.gulimall.product.feign
 */
@FeignClient(value = "gulimall-seckill",fallback = SeckillFeignServiceFallBack.class)
public interface SeckillFeignService {
    @GetMapping("/sku/seckill/{skuId}")
    R skuSeckillInfo(@PathVariable("skuId") Long skuId);
}
