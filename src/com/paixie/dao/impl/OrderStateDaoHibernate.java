package com.paixie.dao.impl;

import org.springframework.stereotype.Repository;

import com.paixie.dao.OrderStateDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.OrderState;

@Repository("orderStateDao")
public class OrderStateDaoHibernate extends BaseHibernateDaoSupport implements OrderStateDao {

	/**
	 * 获取订单状态实例
	 * @param orderStateId 订单状态编号
	 * @return 指定订单状态编号的实例
	 */
	public OrderState getOrderState(String orderStateId) {
		return getHibernateTemplate().get(OrderState.class, orderStateId);
	}

}
