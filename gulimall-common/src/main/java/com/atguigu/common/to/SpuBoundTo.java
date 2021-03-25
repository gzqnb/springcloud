package com.atguigu.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: gzq
 * @Date: 2021/3/24 - 03 - 24 - 9:38
 * @Description: com.atguigu.common.to
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
