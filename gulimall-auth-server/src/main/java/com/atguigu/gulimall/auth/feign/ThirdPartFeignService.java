package com.atguigu.gulimall.auth.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * @Auther: gzq
 * @Date: 2021/3/28 - 03 - 28 - 21:49
 * @Description: com.atguigu.gulimall.auth.feign
 */
@FeignClient("gulimall-third-party")
public interface ThirdPartFeignService {
    @GetMapping("/sms/sendcode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);

}
