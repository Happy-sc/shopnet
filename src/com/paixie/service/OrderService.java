package com.paixie.service;

import java.util.List;
import java.util.Map;

import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.Worker;

public interface OrderService {

	/**
	 * ���涩����Ϣ
	 * @param newOrder ������Ϣ
	 */
	void saveOrder(Order newOrder);

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ���
	 * @param page ҳ��
	 * @param userId �û����
	 * @param state ״̬
	 * @return
	 */
	Map<Order, List<OrderDetail>> getOrderByUserState(int page, String userId,String state);

	/**
	 * ��ȡ�û����ܶ�������
	 * @param userId �û����
	 * @return
	 */
	int getAllOrderSum(String userId,String type);

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ�������
	 * @param userId �û����
	 * @param string ״̬
	 * @return
	 */
	int getStateOrderSum(String userId, String string);

	/**
	 * ��ȡ����
	 * @param orderId �������
	 * @return
	 */
	Order getOrder(String orderId);

	/**
	 * �޸Ķ���
	 * @param order ����ʵ��
	 */
	void updateOrder(Order order);

	/**
	 * ���ݶ������ͻ�ȡ����
	 * @param page  ҳ��
	 * @param type  ����
	 * @return
	 */
	List<Order> getOrderByState(Integer page, String type);

	/**
	 * ��ȡĳ��״̬�Ķ�����ҳ����ÿҳ10��
	 * @param type ����״̬
	 * @return
	 */
	int getOrderPageSum(String type);
	
	/**
	 * ��ȡĳ��״̬����������
	 * @param type  ����״̬
	 * @return
	 */
	int getOrderSum(String type);

	/**
	 * ����
	 * @param orderId �������
	 * @param worker ����Ա��
	 */
	List<OrderDetail> fhOrder(String orderId,Worker worker);

	/**
	 * ��ȡָ����Χʱ���ڵĶ�����Ϣ
	 * @param startTime  ��ʼʱ��
	 * @param endTime  ����ʱ��
	 * @param page ָ��ҳ��
	 * @param userId �û����
	 * @return
	 */
	Map<Order, List<OrderDetail>> getOrderByTime(String startTime, String endTime,int page,String userId);

	/**
	 * ��ȡָ��ʱ�䷶Χ�ڵĶ�������
	 * @param startTime ��ʼʱ��
	 * @param endTime ����ʱ��
	 * @param userId �û����
	 * @return
	 */
	int getOrderSumByTime(String startTime, String endTime,String userId);

}
