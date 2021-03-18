package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author guoziqian
 * @email guoziqian@gmail.com
 * @date 2021-03-16 22:12:53
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
