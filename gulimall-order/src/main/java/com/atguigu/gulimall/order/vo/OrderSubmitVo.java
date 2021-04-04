package com.atguigu.gulimall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 11:10
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class OrderSubmitVo {
    private Long addrId;
    private Integer payType;

    private String orderToken;
    private BigDecimal payPrice;

    private String note;
}
