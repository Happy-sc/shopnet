package com.shop.dao;

import com.shop.domain.OrderState;

public interface OrderStateDao {

	/**
	 * 获取某个状态的订单状态实例
	 * @param orderStateId
	 * @return
	 */
	OrderState getOrderState(String orderStateId);

}
