package com.atguigu.gulimall.member.exception;

/**
 * @Auther: gzq
 * @Date: 2021/3/29 - 03 - 29 - 10:38
 * @Description: com.atguigu.gulimall.member.exception
 */
public class PhoneExistException extends RuntimeException {
    public PhoneExistException(){
        super("手机号存在");
    }
}
