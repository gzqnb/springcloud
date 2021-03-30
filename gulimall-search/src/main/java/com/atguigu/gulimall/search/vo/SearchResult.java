package com.atguigu.gulimall.search.vo;

import com.atguigu.common.to.es.SkuEsModel;
import lombok.Data;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/27 - 03 - 27 - 11:00
 * @Description: com.atguigu.gulimall.search.vo
 */
@Data
public class SearchResult {
    private List<SkuEsModel> products;

    private Integer pageNum;

    private Long total;

    private Integer totalPages;

    private List<Integer> pageNavs;

    private List<BrandVo> brands;

    private List<CatalogVo> catalogs;

    private List<AttrVo> attrs;

    //面包屑导航数据
    private List<NavVo> navs = new ArrayList<>();
    private List<Long> attrIds = new ArrayList<>();

    @Data
    public static class NavVo{
        private String navName;
        private String navValue;
        private String link;
    }
    @Data
    public static class BrandVo {
        private Long brandId;
        private String brandName;
        private String brandImg;
    }
    @Data
    public static class CatalogVo {
        private Long catalogId;
        private String catalogName;

    }


    @Data
    public static class AttrVo {
        private Long attrId;
        private String attrName;
        private List<String> attrValue;
    }
}
