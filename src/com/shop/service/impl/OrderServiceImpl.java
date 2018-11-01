package com.shop.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.common.GetTime;
import com.shop.dao.OrderDao;
import com.shop.dao.OrderDetailDao;
import com.shop.dao.OrderStateDao;
import com.shop.domain.Order;
import com.shop.domain.OrderDetail;
import com.shop.domain.OrderState;
import com.shop.domain.Worker;
import com.shop.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	@Resource(name="orderDao")private OrderDao orderDao;
	@Resource(name="orderDetailDao")private OrderDetailDao orderDetailDao;
	@Resource(name="orderStateDao")private OrderStateDao orderStateDao;
	/**
	 * 保存订单信息
	 * @return
	 */
	public void saveOrder(Order order) {
		orderDao.save(order);
	}
	
	/**
	 * 获取用户的某个状态的订单
	 * @param page 页码
	 * @param userId 用户编号
	 * @return 用户的某个状态的订单
	 */
	public Map<Order, List<OrderDetail>> getOrderByUserState(int page,
			String userId, String type) {
		String state = getOrderState(type);
		List<Order> orders = orderDao.getOrderByUserState(userId, page,state);
		Map<Order,List<OrderDetail>> mapOrder = getTreeMap();
		
		for(int i = 0;i<orders.size();i++){
			Order order = orders.get(i);
			//获取该订单的订单详情
			List<OrderDetail> orderDetails = orderDetailDao.getDetailsByOrderId(order.getOrderId());
			mapOrder.put(order, orderDetails);
		}
		return mapOrder;
	}
	
	/**
	 * 获取状态
	 */
	public String getOrderState(String type){
		String state = "";
		if("all".equals(type)){     //所有
			state = "500000";
		} 
		if("dfh".equals(type)){      //待发货
			state = "500001";
		}
		if("dsh".equals(type)||"yfh".equals(type)){    //用户：待收货、管理员：已发货
			state = "500002";
		}
		if("dfk".equals(type)){     //代付款
			state = "500003";
		} 
		if("ysh".equals(type)){     //已收货
			state = "500004";
		}
		if("qx".equals(type)){      //已取消
			state = "500005";
		}
		
		return state;
	}

	/**
	 * 获取用户的订单
	 * @param userId 用户编号
	 * @return 指定用户编号的订单
	 * @return 指定用户的全部订单数量
	 */
	public int getAllOrderSum(String userId,String type) {
		String state = getOrderState(type);
		List<Order> orders = orderDao.getOrder(userId,state);
		return orders.size();
	}

	/**
	 * 获取用户的某种状态的订单数量
	 * @param userId 用户编号
	 * @param stateId 状态编号
	 * @return 某个用户指定状态的订单数量
	 */
	public int getStateOrderSum(String userId, String stateId) {
		List<Order> orders = orderDao.getStateOrder(userId,stateId);
		return orders.size();
	}

	/**
	 * 根据编号获取订单
	 * @param orderId 订单编号
	 * @return 指定编号的订单
	 */
	public Order getOrder(String orderId) {
		return orderDao.get(orderId);
	}

	/**
	 * 修改订单
	 * @param order 需要修改的订单实例
	 */
	public void updateOrder(Order order) {
		orderDao.update(order);
	}

	/**
	 * 根据订单类型获取订单
	 * @param page  页码
	 * @param type  类型
	 * @return
	 */
	public List<Order> getOrderByState(Integer page, String type) {
		String state = getOrderState(type);
		//根据订单状态获取订单
		List<Order> orders = orderDao.getOrderState(page,state);
		
		return orders;
	}

	/**
	 * 获取某中状态的订单中页数：每页10个
	 * @param type 订单状态
	 * @return
	 */
	public int getOrderPageSum(String type) {
		int sum = getOrderSum(type);
		int pageSum = sum%10==0?sum/10:sum/10+1;
		
		return pageSum;
	}

	/**
	 * 获取某种状态订单的总量
	 * @param type  订单状态
	 * @return
	 */
	public int getOrderSum(String type) {
		String state = getOrderState(type);
		List<Order> orders = orderDao.getTypeOrder(state);
		
		return orders.size();
	}

	/**
	 * 发货
	 * @param orderId 订单编号
	 * @param worker 处理员工
	 */
	public List<OrderDetail> fhOrder(String orderId,Worker worker) {
		//根据订单编号获取订单实例
		Order order = getOrder(orderId);
		//设置值
		//订单状态：该为已经发货
		OrderState orderState = orderStateDao.getOrderState("500002");
		order.setOrderState(orderState);
		//处理员工
		order.setWorker(worker);
		//处理时间
		order.setOrderSend(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		
		//保存订单信息
		orderDao.update(order);
		
		//根据订单获取订单详细编号
		List<OrderDetail> orderDetails = orderDetailDao.getDetailsByOrderId(orderId);
		
		return orderDetails;
	}

	/**
	 * 获取指定范围时间内的订单信息
	 * @param startTime  开始时间
	 * @param endTime  结束时间
	 * @param page 指定页码
	 * @return
	 */
	public Map<Order, List<OrderDetail>> getOrderByTime(String startTime, String endTime,int page,String userId) {
		//获取指定范围时间内的订单
		List<Order> orders = orderDao.getOrderByTime(startTime, endTime, page,userId);
		//根据订单信息获取订单详细信息
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
	 * 获取指定时间范围内的订单总数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public int getOrderSumByTime(String startTime, String endTime,String userId) {
		List<Order> orList = orderDao.getOrderSumByTime(startTime,endTime,userId);
		return orList.size();
	}
	
	/**
	 * 获取指定构造器的TreeMap对象
	 */
	public Map<Order, List<OrderDetail>> getTreeMap(){
		Map<Order, List<OrderDetail>> map = new TreeMap<Order, List<OrderDetail>>(
				//比较器按照降序实现
				(Comparator<? super Order>) new Comparator<Order>(){
					public int compare(Order order1, Order order2) {
						return order2.getOrderId().compareTo(order1.getOrderId());
					}
				}
		);
		return map;
	}
	
}
