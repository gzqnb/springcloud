package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 10:16
 * @Description: com.atguigu.gulimall.ware.vo
 */
@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}
