package com.atguigu.common.exception;

/**
 * @Auther: gzq
 * @Date: 2021/4/3 - 04 - 03 - 18:51
 * @Description: com.atguigu.gulimall.ware.exception
 */
public class NoStockException extends RuntimeException{
    private Long skuId;
    public NoStockException(Long skuId){
        super("商品id："+skuId+"没有足够的库存了");
    }

    public NoStockException(String msg) {
        super("没有足够的库存");
    }

//    public NoStockException() {
//
//    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}
