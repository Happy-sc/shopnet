package com.paixie.dao;

import java.util.List;

import com.paixie.domain.DiscountCoupon;


public interface DiscountCouponDao {
	/**
	 * 根据标识属性获取DiscountCoupon实例
	 * @param discountCouponId
	 * @return
	 */
	DiscountCoupon get(String discountCouponId);
	
	/**
	 * 保存DiscountCoupon实例
	 * @param discountCoupon
	 */
	void save(DiscountCoupon discountCoupon);
	
	/**
	 * 根据标识属性值删除DiscountCoupon实例
	 * @param discountCouponId
	 */
	void delete(String discountCouponId);
	
	/**
	 * 删除DiscountCoupon实例
	 * @param discountCoupon
	 */
	void delete(DiscountCoupon discountCoupon);
	
	/**
	 * 修改DiscountCoupon实例
	 * @param discountCoupon
	 */
	void update(DiscountCoupon discountCoupon);
	
	/**
	 * 获取全部的DiscountCoupon实例
	 * @return
	 */
	List<DiscountCoupon> getAllDiscountCoupons();
	
	/**
	 * 根据用户编号获取实例
	 * @param userId
	 * @param pageNo
	 * @return
	 */
	List<DiscountCoupon> getDiscountCouponByUserId(String userId,int pageNo);
}
