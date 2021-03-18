package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author guoziqian
 * @email guoziqian@gmail.com
 * @date 2021-03-16 21:51:33
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
