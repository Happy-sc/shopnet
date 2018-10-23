package com.paixie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.OrderStateDao;
import com.paixie.domain.OrderState;
import com.paixie.service.OrderStateService;

@Service("orderStateService")
public class OrderStateServiceImpl implements OrderStateService {
	@Resource(name="orderStateDao")private OrderStateDao orderStateDao;

	/**
	 * 获取订单状态实例
	 * @param orderStateId 订单状态编号
	 * @return 指定订单状态编号的实例
	 */
	public OrderState getOrderState(String orderStateId) {
		return orderStateDao.getOrderState(orderStateId);
	}

}
