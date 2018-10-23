package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;

public interface OrderDetailDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡOrderDetailʵ��
	 * @param orderDetailId
	 * @return
	 */
	OrderDetail get(String orderDetailId);
	
	/**
	 * ����OrderDetailʵ��
	 * @param orderDetail
	 */
	void save(OrderDetail orderDetail);
	
	/**
	 * ���ݱ�ʶ����ɾ��OrderDetailʵ��
	 * @param orderDetailId
	 */
	void delete(String orderDetailId);
	
	/**
	 * ɾ��OrderDetailʵ��
	 * @param orderDetail
	 */
	void delete(OrderDetail orderDetail);
	
	/**
	 * �޸�OrderDetailʵ��
	 * @param orderDetail
	 */
	void update(OrderDetail orderDetail);
	
	/**
	 * ���ݶ�����Ż�ȡOrderʵ��
	 * @param orderId
	 * @param commentState
	 * @return
	 */
	List<OrderDetail> getDetailsByOrderId(String orderId, int commentState);

	/**
	 * ���ݶ�����Ż�ȡ��ϸ��Ϣ
	 * @param orderId
	 * @return
	 */
	List<OrderDetail> getDetailsByOrderId(String orderId);

	/**
	 * ��ȡ��������ϸ��Ϣ
	 * @param orderId  �������
	 * @return
	 */
	List<Order> getOrderDeail(String orderId);

	/**
	 * ���ݶ�����״̬��ȡָ��ҳ��Ķ�����Ϣ
	 * @param page  ��ǰҳ��
	 * @param userId �û����
	 * @param i ����״̬��
	 * @return
	 */
	List<OrderDetail> getDSHOrder(int page, String userId, int i);
	
	/**
	 * ��ȡ�û��Ĵ��ջ�������
	 * @param userId �û����
	 * @param i ����״̬���
	 * @return
	 */
	List<OrderDetail> getUserDSHOrder(String userId, int i);

	/**
	 * ���ݶ����Ƿ����ջ���ȡ������ϸ��Ϣ
	 * @param orderId �������
	 * @param i �Ƿ����ջ�״̬
	 * @return
	 */
	List<OrderDetail> getDSHOrderByOrder(String orderId, int i);
}
