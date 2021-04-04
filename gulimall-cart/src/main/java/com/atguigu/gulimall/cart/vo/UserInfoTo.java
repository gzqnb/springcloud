package com.atguigu.gulimall.cart.vo;

import lombok.Data;

import javax.print.attribute.standard.OrientationRequested;

/**
 * @Auther: gzq
 * @Date: 2021/3/31 - 03 - 31 - 21:21
 * @Description: com.atguigu.gulimall.cart.vo
 */
@Data
public class UserInfoTo {
    private Long userId;
    private String userKey;

    private boolean tempUser = false;
}
