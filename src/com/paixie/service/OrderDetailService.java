package com.paixie.service;

import java.util.List;
import java.util.Map;

import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.ShoppingCar;

public interface OrderDetailService {

	/**
	 * ���涩������
	 * @param mapCar ���ﳵ
	 * @param order ����ʵ��
	 */
	void saveOrderDetail(Map<String, ShoppingCar> mapCar, Order order);
	
	/**
	 * ��ȡ�û��Ķ���
	 * @param userId �û����
	 * @param page ҳ��
	 * @param state ״̬
	 * @return
	 */
	List<OrderDetail> getUserOrderDetail(String userId, int page, int state);

	/**
	 * ��ȡ�û��Ķ�������
	 * @param userId �û����
	 * @param state ״̬
	 * @return
	 */
	int getSumOrderDetail(String userId, int state);

	/**
	 * ��ȡ��������ϸ��Ϣ
	 * @param orderId  �������
	 * @return
	 */
	List<Order> getOrderDetailByOrderId(String orderId);

	/**
	 * ��ȡ�û��Ĵ��ջ�����
	 * @param page  ��ǰҳ��
	 * @param userId �û����
	 * @param i ��������״̬
	 * @return
	 */
	List<OrderDetail> getDSHOrderDetail(int page, String userId,int i );

	/**
	 * ��ȡ�û��Ĵ��ջ�������
	 * @param userId �û����
	 * @param i ����������
	 * @return
	 */
	int getDSHOrderSum(String userId,int i );

	/**
	 * ���ݶ��������Ż�ȡ��������ʵ��
	 * @param orderDetailId  ������
	 * @return
	 */
	OrderDetail getOrderDetailById(String orderDetailId);

	/**
	 * ȷ���ջ�
	 * @param orderDetail  ȷ���ջ���������
	 * @param orderId �������
	 */
	void QRSH(OrderDetail orderDetail, String orderId);

	/**
	 * �޸Ķ�����ϸ��Ϣ
	 * @param orderDetail ��Ҫ�޸ĵĶ�����ϸ��Ϣ
	 */
	void updateOrderDetail(OrderDetail orderDetail);


}
