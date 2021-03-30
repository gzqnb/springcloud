package com.atguigu.gulimall.search.controller;

import com.atguigu.gulimall.search.service.MallsearchService;
import com.atguigu.gulimall.search.vo.SearchParam;
import com.atguigu.gulimall.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: gzq
 * @Date: 2021/3/27 - 03 - 27 - 10:20
 * @Description: com.atguigu.gulimall.search.controller
 */
@Controller
public class SearchController {
    @Autowired
    MallsearchService mallsearchService;
    @GetMapping("/list.html")
    public String listPage(SearchParam param, Model model, HttpServletRequest request){
        String queryString = request.getQueryString();
        param.set_queryString(queryString);
        SearchResult result = mallsearchService.search(param);
        model.addAttribute("result",result);
        return "list";
    }
}
