package com.atguigu.gulimall.auth.feign;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.auth.vo.SocialUser;
import com.atguigu.gulimall.auth.vo.UserLoginVo;
import com.atguigu.gulimall.auth.vo.UserRegistVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Auther: gzq
 * @Date: 2021/3/29 - 03 - 29 - 11:08
 * @Description: com.atguigu.gulimall.auth.feign
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {
    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegistVo vo);
    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);
    @PostMapping("/member/member/oauth/login")
    R oauthlogin(@RequestBody SocialUser vo) throws Exception;
}
