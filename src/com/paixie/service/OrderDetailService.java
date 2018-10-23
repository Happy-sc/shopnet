package com.paixie.service;

import java.util.List;
import java.util.Map;

import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.ShoppingCar;

public interface OrderDetailService {

	/**
	 * 保存订单详情
	 * @param mapCar 购物车
	 * @param order 订单实例
	 */
	void saveOrderDetail(Map<String, ShoppingCar> mapCar, Order order);
	
	/**
	 * 获取用户的订单
	 * @param userId 用户编号
	 * @param page 页码
	 * @param state 状态
	 * @return
	 */
	List<OrderDetail> getUserOrderDetail(String userId, int page, int state);

	/**
	 * 获取用户的订单数量
	 * @param userId 用户编号
	 * @param state 状态
	 * @return
	 */
	int getSumOrderDetail(String userId, int state);

	/**
	 * 获取订单的详细信息
	 * @param orderId  订单编号
	 * @return
	 */
	List<Order> getOrderDetailByOrderId(String orderId);

	/**
	 * 获取用户的待收货订单
	 * @param page  当前页码
	 * @param userId 用户编号
	 * @param i 订单详情状态
	 * @return
	 */
	List<OrderDetail> getDSHOrderDetail(int page, String userId,int i );

	/**
	 * 获取用户的待收货的总数
	 * @param userId 用户编号
	 * @param i 订单详情编号
	 * @return
	 */
	int getDSHOrderSum(String userId,int i );

	/**
	 * 根据订单详情编号获取订单详情实例
	 * @param orderDetailId  详情编号
	 * @return
	 */
	OrderDetail getOrderDetailById(String orderDetailId);

	/**
	 * 确认收货
	 * @param orderDetail  确认收货订单详情
	 * @param orderId 订单编号
	 */
	void QRSH(OrderDetail orderDetail, String orderId);

	/**
	 * 修改订单详细信息
	 * @param orderDetail 需要修改的订单详细信息
	 */
	void updateOrderDetail(OrderDetail orderDetail);


}
