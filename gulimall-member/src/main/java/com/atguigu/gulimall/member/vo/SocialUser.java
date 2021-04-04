package com.atguigu.gulimall.member.vo;

import lombok.Data;

/**
 * @Auther: gzq
 * @Date: 2021/3/30 - 03 - 30 - 22:12
 * @Description: com.atguigu.gulimall.auth.vo
 */
@Data
public class SocialUser {
    /**
     * Copyright 2021 bejson.com
     */

    /**
     * Auto-generated: 2021-03-30 22:12:27
     *
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;
}

