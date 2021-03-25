package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/24 - 03 - 24 - 13:06
 * @Description: com.atguigu.gulimall.ware
 */
@Data
public class MergeVo {
    private Long purchaseId;
    private List<Long> items;

}
