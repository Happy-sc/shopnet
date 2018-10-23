package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;

public interface OrderDetailDao {
	/**
	 * 根据标识属性获取OrderDetail实例
	 * @param orderDetailId
	 * @return
	 */
	OrderDetail get(String orderDetailId);
	
	/**
	 * 保存OrderDetail实例
	 * @param orderDetail
	 */
	void save(OrderDetail orderDetail);
	
	/**
	 * 根据标识属性删除OrderDetail实例
	 * @param orderDetailId
	 */
	void delete(String orderDetailId);
	
	/**
	 * 删除OrderDetail实例
	 * @param orderDetail
	 */
	void delete(OrderDetail orderDetail);
	
	/**
	 * 修改OrderDetail实例
	 * @param orderDetail
	 */
	void update(OrderDetail orderDetail);
	
	/**
	 * 根据订单编号获取Order实例
	 * @param orderId
	 * @param commentState
	 * @return
	 */
	List<OrderDetail> getDetailsByOrderId(String orderId, int commentState);

	/**
	 * 根据订单编号获取详细信息
	 * @param orderId
	 * @return
	 */
	List<OrderDetail> getDetailsByOrderId(String orderId);

	/**
	 * 获取订单的详细信息
	 * @param orderId  订单编号
	 * @return
	 */
	List<Order> getOrderDeail(String orderId);

	/**
	 * 根据订单的状态获取指定页面的订单信息
	 * @param page  当前页码
	 * @param userId 用户编号
	 * @param i 订单状态码
	 * @return
	 */
	List<OrderDetail> getDSHOrder(int page, String userId, int i);
	
	/**
	 * 获取用户的待收货的总数
	 * @param userId 用户编号
	 * @param i 订单状态编号
	 * @return
	 */
	List<OrderDetail> getUserDSHOrder(String userId, int i);

	/**
	 * 根据订单是否已收货获取订单详细信息
	 * @param orderId 订单编号
	 * @param i 是否已收货状态
	 * @return
	 */
	List<OrderDetail> getDSHOrderByOrder(String orderId, int i);
}
