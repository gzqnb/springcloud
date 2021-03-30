package com.atguigu.gulimall.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Auther: gzq
 * @Date: 2021/3/25 - 03 - 25 - 21:35
 * @Description: com.atguigu.gulimall.product.vo
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Catelog2Vo {
    private String catelog1Id;
    private List<Catelog3Vo> catelog3List;
    private String id;
    private String name;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Catelog3Vo{
        private String catelog2Id;
        private String id;
        private String name;

    }
}
