package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Order;

public interface OrderDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡOrderʵ��
	 * @param orderId
	 * @return
	 */
	Order get(String orderId);
	
	/**
	 * ����Orderʵ��
	 * @param order
	 */
	void save(Order order);
	
	/**
	 * ���ݱ�ʶ����ɾ��Orderʵ��
	 * @param orderId
	 */
	void delete(String orderId);
	
	/**
	 * ɾ��Orderʵ��
	 * @param order
	 */
	void delete(Order order);
	
	/**
	 * �޸�Orderʵ��
	 * @param order
	 */
	void update(Order order);
	
	/**
	 * �����û�����ȡOrderʵ��,�����з�ҳ����
	 * @param userId
	 * @param pageNo
	 * @return
	 */
	List<Order> getOrderByUser(String userId,int pageNo);
	
	/**
	 * ����ʱ���ȡOrderʵ��
	 * @param minDate
	 * @param maxdDate
	 * @param pageNo
	 * @return
	 */
	List<Order> getOrderByTime(String startTime, String endTime,int pageNo,String userId);
	
	/**
	 * ���ݹ���Ա��ȡOrderʵ��
	 * @param workerId Ա�����
	 * @param pageNo ָ��ҳ��
	 * @return
	 */
	List<Order> getOrderByAdmin(String workerId,int pageNo);

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ���
	 * @param userId �û����
	 * @param page ָ��ҳ��
	 * @param state ״̬���
	 * @return
	 */
	List<Order> getOrderByUserState(String userId, int page, String state);

	/**
	 * ��ȡ�û�����
	 * @param userId �û����
	 * @return
	 */
	List<Order> getOrder(String userId,String state);

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ���
	 * @param userId  �û����
	 * @param stateId ״̬���
	 * @return
	 */
	List<Order> getStateOrder(String userId, String stateId);

	/**
	 * ��ȡ�û��Ķ���
	 * @param userId �û����
	 * @return
	 */
	List<Order> getOrderByUser(String userId);

	/**
	 * ���ݶ������ͻ�ȡ����
	 * @param page  ҳ��
	 * @param type  ����
	 * @return
	 */
	List<Order> getOrderState(Integer page, String state);

	/**
	 * ��ȡĳ��״̬����������
	 * @param type  ����״̬
	 * @return
	 */
	List<Order> getTypeOrder(String state);

	/**
	 * ��ȡָ��ʱ�䷶Χ�ڵĶ�������
	 * @param startTime ��ʼʱ��
	 * @param endTime ����ʱ��
	 * @return
	 */
	List<Order> getOrderSumByTime(String startTime, String endTime,String userId);

}
