package com.atguigu.gulimall.order.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 18:26
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class WareSkuLockVo {
    private String orderSn;
    private List<OrderItemVo> locks;
}
