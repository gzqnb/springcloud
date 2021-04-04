package com.atguigu.common.to.mq;

import lombok.Data;

/**
 * @Auther: gzq
 * @Date: 2021/4/4 - 04 - 04 - 14:56
 * @Description: com.atguigu.common.to.mq
 */
@Data
public class StockDetailTo {
    private Long id;
    /**
     * sku_id
     */
    private Long skuId;
    /**
     * sku_name
     */
    private String skuName;
    /**
     * 购买个数
     */
    private Integer skuNum;
    /**
     * 工作单id
     */
    private Long taskId;
    /**
     * 仓库id
     */
    private Long wareId;
    /**
     * 1-已锁定  2-已解锁  3-扣减
     */
    private Integer lockStatus;
}
