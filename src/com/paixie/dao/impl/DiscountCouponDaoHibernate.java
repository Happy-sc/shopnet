package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.DiscountCouponDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.DiscountCoupon;

@Repository("discountCouponDao")
public class DiscountCouponDaoHibernate extends BaseHibernateDaoSupport
		implements DiscountCouponDao {
	private int pageSize = 10;
	
	/**
	 * ���ݱ�ʶ����ɾ��DiscountCouponʵ��
	 * @param discountCouponId ��Ҫɾ��DiscountCouponʵ���ı�ʶ����ֵ
	 */
	public void delete(String discountCouponId) {
		getHibernateTemplate().delete(get(discountCouponId));
	}

	/**
	 * ɾ��DiscountCouponʵ��
	 * @param discountCoupon ��Ҫ��ɾ����DiscountCouponʵ��
	 */
	public void delete(DiscountCoupon discountCoupon) {
		getHibernateTemplate().delete(discountCoupon);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡDiscountCouponʵ��
	 * @param discountCouponId ��Ҫ��ɾ����DiscountCouponʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��DiscountCouponʵ��
	 */
	public DiscountCoupon get(String discountCouponId) {
		return getHibernateTemplate().get(DiscountCoupon.class,discountCouponId);
	}

	/**
	 * ��ȡȫ����DiscountCouponʵ��
	 * @return ���ݿ���ȫ����DiscountCouponʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<DiscountCoupon> getAllDiscountCoupons() {
		return (List<DiscountCoupon>)getHibernateTemplate().find("from DiscountCoupon");
	}

	/**
	 * �����û���Ż�ȡDiscountCouponʵ��
	 * @param userId �û����
	 * @return ָ���û����
	 */
	@SuppressWarnings("unchecked")
	public List<DiscountCoupon> getDiscountCouponByUserId(String userId,int pageNo) {
		int offset = (pageNo-1)*pageSize;
		return (List<DiscountCoupon>)findByPage("from DiscountCoupon as d where d.users.userId=?", userId, offset, pageNo);
	}

	/**
	 * ����DiscountCouponʵ��
	 * @param discountCoupon ��Ҫ�������DiscountCouponʵ��
	 */
	public void save(DiscountCoupon discountCoupon) {
		getHibernateTemplate().save(discountCoupon);
	}

	/**
	 * �޸�DiscountCouponʵ��
	 * @param discountCoupon ��Ҫ���޸ĵ�DiscountCouponʵ��
	 */
	public void update(DiscountCoupon discountCoupon) {
		getHibernateTemplate().update(discountCoupon);
	}

}
