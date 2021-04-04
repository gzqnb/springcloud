package com.atguigu.gulimall.ware.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 9:56
 * @Description: com.atguigu.gulimall.ware.feign
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {
    @RequestMapping("/member/memberreceiveaddress/info/{id}")
    //@RequiresPermissions("member:memberreceiveaddress:info")
    R addrInfo(@PathVariable("id") Long id);
}
