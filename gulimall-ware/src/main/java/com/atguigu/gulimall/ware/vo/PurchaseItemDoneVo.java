package com.atguigu.gulimall.ware.vo;

import lombok.Data;

/**
 * @Auther: gzq
 * @Date: 2021/3/24 - 03 - 24 - 13:51
 * @Description: com.atguigu.gulimall.ware.vo
 */
@Data
public class PurchaseItemDoneVo {
    private Long itemId;
    private Integer status;
    private String reason;
}
