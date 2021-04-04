package com.atguigu.gulimall.order.vo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/4/2 - 04 - 02 - 15:11
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class OrderItemVo {
    private Long skuId;
    private String title;
    private String image;
    private List<String> skuAttr;
    private BigDecimal price;
    private Integer count;
    private BigDecimal totalPrice;
//    private boolean hasStock;
    private BigDecimal weight;
}
