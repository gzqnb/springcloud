package com.atguigu.gulimall.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 14:38
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class SpuInfoVo {
    private Long id;
    /**
     * 商品名称
     */
    private String spuName;
    /**
     * 商品描述
     */
    private String spuDescription;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     *
     */
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    private Integer publishStatus;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
}
