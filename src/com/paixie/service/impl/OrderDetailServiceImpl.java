package com.paixie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.common.ProduceId;
import com.paixie.dao.OrderDao;
import com.paixie.dao.OrderDetailDao;
import com.paixie.dao.OrderStateDao;
import com.paixie.dao.ShoppingCarDao;
import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.OrderState;
import com.paixie.domain.ShoppingCar;
import com.paixie.service.OrderDetailService;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService{
	@Resource(name="orderDetailDao")private OrderDetailDao orderDetailDao;
	@Resource(name="shoppingCarDao")private ShoppingCarDao shoppingCarDao;
	@Resource(name="orderDao")private OrderDao orderDao;
	@Resource(name="orderStateDao")private OrderStateDao orderStateDao;
	/**
	 * ���涩������
	 * @param mapCar ���ﳵ
	 * @param order ����
	 * @return
	 */
	public void saveOrderDetail(Map<String, ShoppingCar> mapCar, Order order) {
		for(Entry<String, ShoppingCar> mycar:mapCar.entrySet()){
			ShoppingCar shoppingCar = mycar.getValue();
			OrderDetail orderDetail = new OrderDetail();              //�½���������
			//�趨ֵ
			orderDetail.setGoodsListing(shoppingCar.getGoodsListing());       //��Ʒ
			orderDetail.setOrder(order);                                      //����
			orderDetail.setOrderDetailId(ProduceId.getId());     //����������
			orderDetail.setOrderDetailIsCom(0);                               //�Ƿ��Ѿ�����
			orderDetail.setGoodsNumber(shoppingCar.getGoodsNumber());         //��Ʒ����
			orderDetail.setGoodsColor(shoppingCar.getGoodsColor());           //��Ʒ��ɫ
			orderDetail.setGoodsAttr(shoppingCar.getGoodsAttr());             //��Ʒ����
			orderDetail.setIsAccept(0);                                       //û���ջ�
			//���涩������
			orderDetailDao.save(orderDetail);
			//ͬʱɾ�����ﳵ�������Ϣ
			shoppingCarDao.deleteCar(shoppingCar);
		}
	}
	
	/**
	 * ��ȡ�û�����ϸ����
	 */
	public List<OrderDetail> getUserOrderDetail(String userId, int page, int commentState) {
		//��ȡ�û��Ķ���
		List<Order> orders = orderDao.getOrderByUser(userId);
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		if(orders!=null){
			for(int i = 0;i<orders.size();i++){
				List<OrderDetail> orderDetails2 = orderDetailDao.getDetailsByOrderId(orders.get(i).getOrderId(),commentState);
				orderDetails.addAll(orderDetails2);
			}
		}
		int begin = (page-1)*5;
		int end = page*5;
		List<OrderDetail> resultsList = new ArrayList<OrderDetail>();
		if(end>orderDetails.size()){
			resultsList = orderDetails.subList(begin, orderDetails.size());
		}
		else{
			resultsList = orderDetails.subList(begin, end);
		}
		return resultsList;
	}

	/**
	 * ��ȡ�û�������������
	 */
	public int getSumOrderDetail(String userId, int state) {
		//��ȡ�û��Ķ���
		List<Order> orders = orderDao.getOrderByUser(userId);
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		if(orders!=null){
			for(int i = 0;i<orders.size();i++){
				List<OrderDetail> orderDetails2 = orderDetailDao.getDetailsByOrderId(orders.get(i).getOrderId(),state);
				orderDetails.addAll(orderDetails2);
			}
		}
		
		return orderDetails.size();
	}

	/**
	 * ��ȡ��������ϸ��Ϣ
	 * @param orderId  �������
	 * @return
	 */
	public List<Order> getOrderDetailByOrderId(String orderId) {
		List<Order> orders = orderDetailDao.getOrderDeail(orderId);
		
		return orders;
	}

	/**
	 * ��ȡ�û��Ĵ��ջ�����
	 * @param page  ��ǰҳ��
	 * @param userId �û����
	 * @return
	 */
	public List<OrderDetail> getDSHOrderDetail(int page, String userId,int i ) {
		List<OrderDetail> oList = orderDetailDao.getDSHOrder(page,userId,i);
		
		return oList;
	}

	/**
	 * ��ȡ�û��Ĵ��ջ�������
	 * @param userId �û����
	 * @param i ����״̬���
	 * @return
	 */
	public int getDSHOrderSum(String userId,int i ) {
		List<OrderDetail> allDetail = orderDetailDao.getUserDSHOrder(userId,i);
		
		return allDetail.size();
	}

	/**
	 * ���ݶ��������Ż�ȡ��������ʵ��
	 * @param orderDetailId  ������
	 * @return
	 */
	public OrderDetail getOrderDetailById(String orderDetailId) {
		OrderDetail orderDetail = orderDetailDao.get(orderDetailId);
		return orderDetail;
	}

	/**
	 * ȷ���ջ�
	 * @param orderDetail  ȷ���ջ���������
	 * @param orderId �������
	 */
	public void QRSH(OrderDetail orderDetail, String orderId) {
		orderDetailDao.update(orderDetail);       //�޸Ķ�������
		//�鿴�ö������Ƿ񻹴����л���û���յ�
		List<OrderDetail> orList = orderDetailDao.getDSHOrderByOrder(orderId,0);
		if(orList.size()==0||orList==null){
			Order order = orderDao.get(orderId);      //��ȡ����
			OrderState orderState = orderStateDao.getOrderState("500004");
			order.setOrderState(orderState);
			orderDao.update(order);
		}
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		orderDetailDao.update(orderDetail);
	}
	
}
