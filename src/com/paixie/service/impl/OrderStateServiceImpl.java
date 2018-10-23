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
	 * ��ȡ����״̬ʵ��
	 * @param orderStateId ����״̬���
	 * @return ָ������״̬��ŵ�ʵ��
	 */
	public OrderState getOrderState(String orderStateId) {
		return orderStateDao.getOrderState(orderStateId);
	}

}
