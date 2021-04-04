package com.atguigu.gulimall.order.vo;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/4/2 - 04 - 02 - 15:07
 * @Description: com.atguigu.gulimall.order.vo
 */
@ToString
public class OrderConfirmVo {
    @Setter
    @Getter
    List<MemberAddressVo> address;
    @Setter
    @Getter
    List<OrderItemVo> items;
    @Setter
    @Getter
    Integer integration;

    @Setter
    @Getter
    String orderToken;

    BigDecimal total;

    @Setter
    @Getter
    Map<Long,Boolean> stocks;

    public Integer getCount() {
        Integer i = 0;
        if (items != null) {
            for (OrderItemVo item : items) {
                i+=item.getCount();
            }
        }
        return i;
    }

    public BigDecimal getTotal() {
        BigDecimal sum = new BigDecimal("0");
        if (items != null) {
            for (OrderItemVo item : items) {
                BigDecimal multiply = item.getPrice().multiply(new BigDecimal(item.getCount().toString()));
                sum = sum.add(multiply);
            }
        }

        return sum;
    }


//    BigDecimal payPrice;

    public BigDecimal getPayPrice() {
        return getTotal();
    }
}
