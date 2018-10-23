package com.paixie.service;

import com.paixie.domain.OrderState;

public interface OrderStateService {

	/**
	 * 获取订单状态实例
	 * @param orderStateId 订单那编号
	 * @return
	 */
	OrderState getOrderState(String orderStateId);
	
}
