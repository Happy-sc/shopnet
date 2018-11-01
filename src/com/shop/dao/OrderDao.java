package com.shop.dao;

import java.util.List;

import com.shop.domain.Order;

public interface OrderDao {
	/**
	 * 根据标识属性获取Order实例
	 * @param orderId
	 * @return
	 */
	Order get(String orderId);
	
	/**
	 * 保存Order实例
	 * @param order
	 */
	void save(Order order);
	
	/**
	 * 根据标识属性删除Order实例
	 * @param orderId
	 */
	void delete(String orderId);
	
	/**
	 * 删除Order实例
	 * @param order
	 */
	void delete(Order order);
	
	/**
	 * 修改Order实例
	 * @param order
	 */
	void update(Order order);
	
	/**
	 * 根据用户名获取Order实例,并进行分页处理
	 * @param userId
	 * @param pageNo
	 * @return
	 */
	List<Order> getOrderByUser(String userId,int pageNo);
	
	/**
	 * 根据时间获取Order实例
	 * @param minDate
	 * @param maxdDate
	 * @param pageNo
	 * @return
	 */
	List<Order> getOrderByTime(String startTime, String endTime,int pageNo,String userId);
	
	/**
	 * 根据管理员获取Order实例
	 * @param workerId 员工编号
	 * @param pageNo 指定页面
	 * @return
	 */
	List<Order> getOrderByAdmin(String workerId,int pageNo);

	/**
	 * 获取用户的某个状态的订单
	 * @param userId 用户编号
	 * @param page 指定页面
	 * @param state 状态编号
	 * @return
	 */
	List<Order> getOrderByUserState(String userId, int page, String state);

	/**
	 * 获取用户订单
	 * @param userId 用户编号
	 * @return
	 */
	List<Order> getOrder(String userId,String state);

	/**
	 * 获取用户的某种状态的订单
	 * @param userId  用户编号
	 * @param stateId 状态编号
	 * @return
	 */
	List<Order> getStateOrder(String userId, String stateId);

	/**
	 * 获取用户的订单
	 * @param userId 用户编号
	 * @return
	 */
	List<Order> getOrderByUser(String userId);

	/**
	 * 根据订单类型获取订单
	 * @param page  页码
	 * @param type  类型
	 * @return
	 */
	List<Order> getOrderState(Integer page, String state);

	/**
	 * 获取某种状态订单的总量
	 * @param type  订单状态
	 * @return
	 */
	List<Order> getTypeOrder(String state);

	/**
	 * 获取指定时间范围内的订单总数
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	List<Order> getOrderSumByTime(String startTime, String endTime,String userId);

}
