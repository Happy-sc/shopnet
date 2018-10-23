package com.paixie.dao.impl;

import org.springframework.stereotype.Repository;

import com.paixie.dao.OrderStateDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.OrderState;

@Repository("orderStateDao")
public class OrderStateDaoHibernate extends BaseHibernateDaoSupport implements OrderStateDao {

	/**
	 * ��ȡ����״̬ʵ��
	 * @param orderStateId ����״̬���
	 * @return ָ������״̬��ŵ�ʵ��
	 */
	public OrderState getOrderState(String orderStateId) {
		return getHibernateTemplate().get(OrderState.class, orderStateId);
	}

}
