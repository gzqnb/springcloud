package com.atguigu.gulimall.member.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @Auther: gzq
 * @Date: 2021/3/29 - 03 - 29 - 10:19
 * @Description: com.atguigu.gulimall.member.vo
 */
@Data
public class MemberRegistVo {

    private String userName;
    private String password;
    private String phone;
}
