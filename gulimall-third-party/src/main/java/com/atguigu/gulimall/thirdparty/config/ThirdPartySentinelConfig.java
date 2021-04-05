package com.atguigu.gulimall.thirdparty.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import com.atguigu.common.exception.BizCodeEnume;
import com.atguigu.common.utils.R;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: gzq
 * @Date: 2021/4/5 - 04 - 05 - 18:20
 * @Description: com.atguigu.gulimall.seckill.config
 */
@Configuration
public class ThirdPartySentinelConfig {
    public ThirdPartySentinelConfig(){
    WebCallbackManager.setUrlBlockHandler(new UrlBlockHandler() {
        @Override
        public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
            R error = R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(), BizCodeEnume.TO_MANY_REQUEST.getMsg());
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(JSON.toJSONString(error));
        }
    }); }
}
