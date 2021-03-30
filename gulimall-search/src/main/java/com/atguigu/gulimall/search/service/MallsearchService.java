package com.atguigu.gulimall.search.service;

import com.atguigu.gulimall.search.vo.SearchParam;
import com.atguigu.gulimall.search.vo.SearchResult;

/**
 * @Auther: gzq
 * @Date: 2021/3/27 - 03 - 27 - 10:48
 * @Description: com.atguigu.gulimall.search.controller
 */
public interface MallsearchService {
    SearchResult search(SearchParam param);
}
