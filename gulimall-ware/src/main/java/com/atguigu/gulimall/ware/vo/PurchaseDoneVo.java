package com.atguigu.gulimall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/24 - 03 - 24 - 13:50
 * @Description: com.atguigu.gulimall.ware.vo
 */
@Data
public class PurchaseDoneVo {
    @NotNull
    private Long id;
    private List<PurchaseItemDoneVo> items;

}
