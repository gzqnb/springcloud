package com.atguigu.common.to.mq;

import lombok.Data;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/4/4 - 04 - 04 - 14:51
 * @Description: com.atguigu.common.to.mq
 */
@Data
public class StockLockedTo {
    private Long id;
    private StockDetailTo detail;
}
