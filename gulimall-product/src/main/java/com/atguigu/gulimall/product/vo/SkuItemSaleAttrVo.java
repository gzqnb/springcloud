package com.atguigu.gulimall.product.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/28 - 03 - 28 - 15:48
 * @Description: com.atguigu.gulimall.product.vo
 */
@Data
public class SkuItemSaleAttrVo {
    private Long attrId;
    private String attrName;
    private List<AttrValueWithSkuIdVo> attrValues;

}
