package com.atguigu.gulimall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 14:05
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}
