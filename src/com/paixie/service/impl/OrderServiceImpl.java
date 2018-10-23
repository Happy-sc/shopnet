package com.paixie.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.common.GetTime;
import com.paixie.dao.OrderDao;
import com.paixie.dao.OrderDetailDao;
import com.paixie.dao.OrderStateDao;
import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.OrderState;
import com.paixie.domain.Worker;
import com.paixie.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Resource(name="orderDao")private OrderDao orderDao;
	@Resource(name="orderDetailDao")private OrderDetailDao orderDetailDao;
	@Resource(name="orderStateDao")private OrderStateDao orderStateDao;
	/**
	 * ���涩����Ϣ
	 * @param order��Ҫ����Ķ���
	 * @return
	 */
	public void saveOrder(Order order) {
		orderDao.save(order);
	}
	
	/**
	 * ��ȡ�û���ĳ��״̬�Ķ���
	 * @param page ҳ��
	 * @param userId �û����
	 * @param state ����״̬
	 * @return �û���ĳ��״̬�Ķ���
	 */
	public Map<Order, List<OrderDetail>> getOrderByUserState(int page,
			String userId, String type) {
		String state = getOrderState(type);
		List<Order> orders = orderDao.getOrderByUserState(userId, page,state);
		Map<Order,List<OrderDetail>> mapOrder = getTreeMap();
		
		for(int i = 0;i<orders.size();i++){
			Order order = orders.get(i);
			//��ȡ�ö����Ķ�������
			List<OrderDetail> orderDetails = orderDetailDao.getDetailsByOrderId(order.getOrderId());
			mapOrder.put(order, orderDetails);
		}
		return mapOrder;
	}
	
	/**
	 * ��ȡ״̬
	 */
	public String getOrderState(String type){
		String state = "";
		if("all".equals(type)){     //����
			state = "500000";
		} 
		if("dfh".equals(type)){      //������
			state = "500001";
		}
		if("dsh".equals(type)||"yfh".equals(type)){    //�û������ջ�������Ա���ѷ���
			state = "500002";
		}
		if("dfk".equals(type)){     //������
			state = "500003";
		} 
		if("ysh".equals(type)){     //���ջ�
			state = "500004";
		}
		if("qx".equals(type)){      //��ȡ��
			state = "500005";
		}
		
		return state;
	}

	/**
	 * ��ȡ�û��Ķ���
	 * @param userId �û����
	 * @return ָ���û���ŵĶ���
	 * @return ָ���û���ȫ����������
	 */
	public int getAllOrderSum(String userId,String type) {
		String state = getOrderState(type);
		List<Order> orders = orderDao.getOrder(userId,state);
		return orders.size();
	}

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ�������
	 * @param userId �û����
	 * @param stateId ״̬���
	 * @return ĳ���û�ָ��״̬�Ķ�������
	 */
	public int getStateOrderSum(String userId, String stateId) {
		List<Order> orders = orderDao.getStateOrder(userId,stateId);
		return orders.size();
	}

	/**
	 * ���ݱ�Ż�ȡ����
	 * @param orderId �������
	 * @return ָ����ŵĶ���
	 */
	public Order getOrder(String orderId) {
		return orderDao.get(orderId);
	}

	/**
	 * �޸Ķ���
	 * @param order ��Ҫ�޸ĵĶ���ʵ��
	 */
	public void updateOrder(Order order) {
		orderDao.update(order);
	}

	/**
	 * ���ݶ������ͻ�ȡ����
	 * @param page  ҳ��
	 * @param type  ����
	 * @return
	 */
	public List<Order> getOrderByState(Integer page, String type) {
		String state = getOrderState(type);
		//���ݶ���״̬��ȡ����
		List<Order> orders = orderDao.getOrderState(page,state);
		
		return orders;
	}

	/**
	 * ��ȡĳ��״̬�Ķ�����ҳ����ÿҳ10��
	 * @param type ����״̬
	 * @return
	 */
	public int getOrderPageSum(String type) {
		int sum = getOrderSum(type);
		int pageSum = sum%10==0?sum/10:sum/10+1;
		
		return pageSum;
	}

	/**
	 * ��ȡĳ��״̬����������
	 * @param type  ����״̬
	 * @return
	 */
	public int getOrderSum(String type) {
		String state = getOrderState(type);
		List<Order> orders = orderDao.getTypeOrder(state);
		
		return orders.size();
	}

	/**
	 * ����
	 * @param orderId �������
	 * @param worker ����Ա��
	 */
	public List<OrderDetail> fhOrder(String orderId,Worker worker) {
		//���ݶ�����Ż�ȡ����ʵ��
		Order order = getOrder(orderId);
		//����ֵ
		//����״̬����Ϊ�Ѿ�����
		OrderState orderState = orderStateDao.getOrderState("500002");
		order.setOrderState(orderState);
		//����Ա��
		order.setWorker(worker);
		//����ʱ��
		order.setOrderSend(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		
		//���涩����Ϣ
		orderDao.update(order);
		
		//���ݶ�����ȡ������ϸ���
		List<OrderDetail> orderDetails = orderDetailDao.getDetailsByOrderId(orderId);
		
		return orderDetails;
	}

	/**
	 * ��ȡָ����Χʱ���ڵĶ�����Ϣ
	 * @param startTime  ��ʼʱ��
	 * @param endTime  ����ʱ��
	 * @param page ָ��ҳ��
	 * @return
	 */
	public Map<Order, List<OrderDetail>> getOrderByTime(String startTime, String endTime,int page,String userId) {
		//��ȡָ����Χʱ���ڵĶ���
		List<Order> orders = orderDao.getOrderByTime(startTime, endTime, page,userId);
		//���ݶ�����Ϣ��ȡ������ϸ��Ϣ
		Map<Order, List<OrderDetail>> maps =getTreeMap();
		if(orders.size()>0&&orders!=null){
			for(int i = 0; i< orders.size();i++){
				Order order = orders.get(i);
				List<OrderDetail> orderDetailS = orderDetailDao.getDetailsByOrderId(order.getOrderId());
				maps.put(order, orderDetailS);
			}
		}
		return maps;
	}

	/**
	 * ��ȡָ��ʱ�䷶Χ�ڵĶ�������
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int getOrderSumByTime(String startTime, String endTime,String userId) {
		List<Order> orList = orderDao.getOrderSumByTime(startTime,endTime,userId);
		return orList.size();
	}
	
	/**
	 * ��ȡָ����������TreeMap����
	 */
	public Map<Order, List<OrderDetail>> getTreeMap(){
		Map<Order, List<OrderDetail>> map = new TreeMap<Order, List<OrderDetail>>(
				//�Ƚ������ս���ʵ��
				(Comparator<? super Order>) new Comparator<Order>(){
					public int compare(Order order1, Order order2) {
						return order2.getOrderId().compareTo(order1.getOrderId());
					}
				}
		);
		return map;
	}
	
}
