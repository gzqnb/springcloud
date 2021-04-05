package com.atguigu.common.to.mq;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: gzq
 * @Date: 2021/4/5 - 04 - 05 - 16:33
 * @Description: com.atguigu.common.to.mq
 */
@Data
public class SeckillOrderTo {
    private String orderSn;//订单号

    private Long promotionSessionId;//活动场次

    private Long skuId;

    private String randomCode;

    private BigDecimal seckillPrice;

    private Integer num;

    private Long memberId;
}
