package com.atguigu.gulimall.product.vo;

import lombok.Data;

/**
 * @Auther: gzq
 * @Date: 2021/3/22 - 03 - 22 - 10:48
 * @Description: com.atguigu.gulimall.product.vo
 */
@Data
public class AttrRespVo extends AttrVo{
    private String catelogName;
    private String groupName;

    private Long[] catelogPath;
}
