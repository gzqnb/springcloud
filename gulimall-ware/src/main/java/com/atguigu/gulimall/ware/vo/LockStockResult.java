package com.atguigu.gulimall.ware.vo;

import lombok.Data;
import org.apache.el.parser.BooleanNode;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 18:31
 * @Description: com.atguigu.gulimall.ware.vo
 */
@Data
public class LockStockResult {
    private Long skuId;
    private Integer num;
    private Boolean locked;

}
