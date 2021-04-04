package com.atguigu.gulimall.cart.config;

import com.atguigu.gulimall.cart.intercepter.CartInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: gzq
 * @Date: 2021/3/31 - 03 - 31 - 21:34
 * @Description: com.atguigu.gulimall.cart.config
 */
@Configuration
public class GuliMallWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CartInterceptor()).addPathPatterns("/**");
    }
}
