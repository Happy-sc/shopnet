package com.paixie.service;

import com.paixie.domain.OrderState;

public interface OrderStateService {

	/**
	 * ��ȡ����״̬ʵ��
	 * @param orderStateId �����Ǳ��
	 * @return
	 */
	OrderState getOrderState(String orderStateId);
	
}
