package com.atguigu.gulimall.member.exception;

/**
 * @Auther: gzq
 * @Date: 2021/3/29 - 03 - 29 - 10:37
 * @Description: com.atguigu.gulimall.member.exception
 */
public class UserNameExistException extends RuntimeException {
   public UserNameExistException(){
       super("用户名存在");
   }
}
