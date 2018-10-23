package com.paixie.service;

import java.util.List;
import java.util.Map;

import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.Worker;

public interface OrderService {

	/**
	 * 保存订单信息
	 * @param newOrder 订单信息
	 */
	void saveOrder(Order newOrder);

	/**
	 * 获取用户的某个状态的订单
	 * @param page 页码
	 * @param userId 用户编号
	 * @param state 状态
	 * @return
	 */
	Map<Order, List<OrderDetail>> getOrderByUserState(int page, String userId,String state);

	/**
	 * 获取用户的总订单数量
	 * @param userId 用户编号
	 * @return
	 */
	int getAllOrderSum(String userId,String type);

	/**
	 * 获取用户的某种状态的订单数量
	 * @param userId 用户编号
	 * @param string 状态
	 * @return
	 */
	int getStateOrderSum(String userId, String string);

	/**
	 * 获取订单
	 * @param orderId 订单编号
	 * @return
	 */
	Order getOrder(String orderId);

	/**
	 * 修改订单
	 * @param order 订单实例
	 */
	void updateOrder(Order order);

	/**
	 * 根据订单类型获取订单
	 * @param page  页码
	 * @param type  类型
	 * @return
	 */
	List<Order> getOrderByState(Integer page, String type);

	/**
	 * 获取某中状态的订单中页数：每页10个
	 * @param type 订单状态
	 * @return
	 */
	int getOrderPageSum(String type);
	
	/**
	 * 获取某种状态订单的总量
	 * @param type  订单状态
	 * @return
	 */
	int getOrderSum(String type);

	/**
	 * 发货
	 * @param orderId 订单编号
	 * @param worker 处理员工
	 */
	List<OrderDetail> fhOrder(String orderId,Worker worker);

	/**
	 * 获取指定范围时间内的订单信息
	 * @param startTime  开始时间
	 * @param endTime  结束时间
	 * @param page 指定页码
	 * @param userId 用户编号
	 * @return
	 */
	Map<Order, List<OrderDetail>> getOrderByTime(String startTime, String endTime,int page,String userId);

	/**
	 * 获取指定时间范围内的订单总数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param userId 用户编号
	 * @return
	 */
	int getOrderSumByTime(String startTime, String endTime,String userId);

}
