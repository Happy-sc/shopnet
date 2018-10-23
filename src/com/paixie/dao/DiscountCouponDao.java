package com.paixie.dao;

import java.util.List;

import com.paixie.domain.DiscountCoupon;


public interface DiscountCouponDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡDiscountCouponʵ��
	 * @param discountCouponId
	 * @return
	 */
	DiscountCoupon get(String discountCouponId);
	
	/**
	 * ����DiscountCouponʵ��
	 * @param discountCoupon
	 */
	void save(DiscountCoupon discountCoupon);
	
	/**
	 * ���ݱ�ʶ����ֵɾ��DiscountCouponʵ��
	 * @param discountCouponId
	 */
	void delete(String discountCouponId);
	
	/**
	 * ɾ��DiscountCouponʵ��
	 * @param discountCoupon
	 */
	void delete(DiscountCoupon discountCoupon);
	
	/**
	 * �޸�DiscountCouponʵ��
	 * @param discountCoupon
	 */
	void update(DiscountCoupon discountCoupon);
	
	/**
	 * ��ȡȫ����DiscountCouponʵ��
	 * @return
	 */
	List<DiscountCoupon> getAllDiscountCoupons();
	
	/**
	 * �����û���Ż�ȡʵ��
	 * @param userId
	 * @param pageNo
	 * @return
	 */
	List<DiscountCoupon> getDiscountCouponByUserId(String userId,int pageNo);
}
