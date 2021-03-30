package com.atguigu.gulimall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/28 - 03 - 28 - 15:46
 * @Description: com.atguigu.gulimall.product.vo
 */
@ToString
@Data
public class SpuItemAttrGroupVo {
    private String groupName;
    private List<Attr> attrs;
}
