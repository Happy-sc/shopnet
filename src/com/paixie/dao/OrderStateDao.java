package com.paixie.dao;

import com.paixie.domain.OrderState;

public interface OrderStateDao {

	/**
	 * ��ȡĳ��״̬�Ķ���״̬ʵ��
	 * @param orderStateId
	 * @return
	 */
	OrderState getOrderState(String orderStateId);

}
