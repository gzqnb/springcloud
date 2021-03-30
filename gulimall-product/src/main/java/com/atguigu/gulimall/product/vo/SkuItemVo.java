package com.atguigu.gulimall.product.vo;

import com.atguigu.gulimall.product.entity.SkuImagesEntity;
import com.atguigu.gulimall.product.entity.SkuInfoEntity;
import com.atguigu.gulimall.product.entity.SpuInfoDescEntity;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/28 - 03 - 28 - 14:27
 * @Description: com.atguigu.gulimall.product.vo
 */
@Data
public class SkuItemVo {

    SkuInfoEntity info;

    boolean hasStock = true;

    List<SkuImagesEntity> images;

    List<SkuItemSaleAttrVo> saleAttr;

    SpuInfoDescEntity desp;

    List<SpuItemAttrGroupVo> groupAttrs;





}
