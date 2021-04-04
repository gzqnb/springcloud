package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: gzq
 * @Date: 2021/4/4 - 04 - 04 - 20:08
 * @Description: com.atguigu.gulimall.member.feign
 */
@FeignClient("gulimall-order")
public interface OrderFeignService {
    @PostMapping("order/order/listWithItem")
    //@RequiresPermissions("order:order:list")
    R listWithItem(@RequestBody Map<String, Object> params);
}
