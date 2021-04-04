package com.atguigu.gulimall.order.vo;

import com.atguigu.gulimall.order.entity.OrderEntity;
import lombok.Data;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 11:38
 * @Description: com.atguigu.gulimall.order.vo
 */
@Data
public class SubmitOrderResponseVo {
    private OrderEntity order;
    private Integer code;
}
