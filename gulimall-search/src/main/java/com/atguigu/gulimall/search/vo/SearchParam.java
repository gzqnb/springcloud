package com.atguigu.gulimall.search.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/27 - 03 - 27 - 10:45
 * @Description: com.atguigu.gulimall.search.vo
 */
@Data
public class SearchParam {

    private String keyword;

    private Long catalog3Id;
    //saleCount_asc/desc
    private String sort;

    private Integer hasStock;

    private String skuPrice;

    private List<Long> brandId;

    private List<String> attrs;

    private Integer pageNum = 1;

    private String _queryString;
}
