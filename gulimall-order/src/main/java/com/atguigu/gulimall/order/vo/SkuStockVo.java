package com.atguigu.gulimall.order.vo;

import lombok.Data;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 9:18
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class SkuStockVo {
    private Long skuId;
    private Boolean hasStock;
}
