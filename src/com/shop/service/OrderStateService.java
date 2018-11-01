package com.shop.service;

import com.shop.domain.OrderState;

public interface OrderStateService {

	/**
	 * 获取订单状态实例
	 * @param orderStateId 订单那编号
	 * @return
	 */
	OrderState getOrderState(String orderStateId);
	
}
