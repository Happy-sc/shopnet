package com.shop.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.common.ProduceId;
import com.shop.dao.OrderDao;
import com.shop.dao.OrderDetailDao;
import com.shop.dao.OrderStateDao;
import com.shop.dao.ShoppingCarDao;
import com.shop.domain.Order;
import com.shop.domain.OrderDetail;
import com.shop.domain.OrderState;
import com.shop.domain.ShoppingCar;
import com.shop.service.OrderDetailService;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService{

	@Resource(name="orderDetailDao")
	private OrderDetailDao orderDetailDao;
	@Resource(name="shoppingCarDao")
	private ShoppingCarDao shoppingCarDao;
	@Resource(name="orderDao")
	private OrderDao orderDao;
	@Resource(name="orderStateDao")
	private OrderStateDao orderStateDao;
	/**
	 * 保存订单详情
	 * @param mapCar 购物车
	 * @param order 订单
	 * @return
	 */
	public void saveOrderDetail(Map<String, ShoppingCar> mapCar, Order order) {
		for(Entry<String, ShoppingCar> mycar:mapCar.entrySet()){
			ShoppingCar shoppingCar = mycar.getValue();
			OrderDetail orderDetail = new OrderDetail();              //新建订单详情
			//设定值
			orderDetail.setGoodsListing(shoppingCar.getGoodsListing());       //商品
			orderDetail.setOrder(order);                                      //订单
			orderDetail.setOrderDetailId(ProduceId.getId());     //订单详情编号
			orderDetail.setOrderDetailIsCom(0);                               //是否已经评价
			orderDetail.setGoodsNumber(shoppingCar.getGoodsNumber());         //商品数量
			orderDetail.setGoodsColor(shoppingCar.getGoodsColor());           //商品颜色
			orderDetail.setGoodsAttr(shoppingCar.getGoodsAttr());             //商品尺码
			orderDetail.setIsAccept(0);                                       //没有收货
			//保存订单详情
			orderDetailDao.save(orderDetail);
			//同时删除购物车里面的信息
			shoppingCarDao.deleteCar(shoppingCar);
		}
	}
	
	/**
	 * 获取用户的详细订单
	 */
	public List<OrderDetail> getUserOrderDetail(String userId, int page, int commentState) {
		//获取用户的订单
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
	 * 获取用户订单的总数量
	 */
	public int getSumOrderDetail(String userId, int state) {
		//获取用户的订单
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
	 * 获取订单的详细信息
	 * @param orderId  订单编号
	 * @return
	 */
	public List<Order> getOrderDetailByOrderId(String orderId) {
		List<Order> orders = orderDetailDao.getOrderDeail(orderId);
		
		return orders;
	}

	/**
	 * 获取用户的待收货订单
	 * @param page  当前页码
	 * @param userId 用户编号
	 * @return
	 */
	public List<OrderDetail> getDSHOrderDetail(int page, String userId,int i ) {
		List<OrderDetail> oList = orderDetailDao.getDSHOrder(page,userId,i);
		
		return oList;
	}

	/**
	 * 获取用户的待收货的总数
	 * @param userId 用户编号
	 * @param i 订单状态编号
	 * @return
	 */
	public int getDSHOrderSum(String userId,int i ) {
		List<OrderDetail> allDetail = orderDetailDao.getUserDSHOrder(userId,i);
		
		return allDetail.size();
	}

	/**
	 * 根据订单详情编号获取订单详情实例
	 * @param orderDetailId  详情编号
	 * @return
	 */
	public OrderDetail getOrderDetailById(String orderDetailId) {
		OrderDetail orderDetail = orderDetailDao.get(orderDetailId);
		return orderDetail;
	}

	/**
	 * 确认收货
	 * @param orderDetail  确认收货订单详情
	 * @param orderId 订单编号
	 */
	public void QRSH(OrderDetail orderDetail, String orderId) {
		orderDetailDao.update(orderDetail);       //修改订单详情
		//查看该订单中是否还存在有货物没有收到
		List<OrderDetail> orList = orderDetailDao.getDSHOrderByOrder(orderId,0);
		if(orList.size()==0||orList==null){
			Order order = orderDao.get(orderId);      //获取订单
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
