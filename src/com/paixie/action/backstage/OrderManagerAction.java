package com.paixie.action.backstage;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.paixie.action.common.BaseAction;
import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.Worker;
import com.paixie.service.GoodsService;
import com.paixie.service.OrderDetailService;
import com.paixie.service.OrderService;

@Controller("orderManagerAction")
public class OrderManagerAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	@Resource(name="orderService") private OrderService orderService;
	@Resource(name="orderDetailService")private OrderDetailService orderDetailService;
	@Resource(name="goodsService")private GoodsService goodsService;
	
	private String type;
	private String orderId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 查看订单信息
	 */
	public String managerOrder(){
		//根据类型获取相应的订单
		List<Order> orders = orderService.getOrderByState(super.getPage(),type);
		
		//获取订单的总页数
		pageSum = orderService.getOrderPageSum(type);
		
		request.setAttribute("orders", orders);
		
		String typeString = null;
		if("dfk".equals(type)){
			typeString = "dfkOrder";
		}
		if("dfh".equals(type)){
			typeString = "dfhOrder";
		}
		if("yfh".equals(type)){
			typeString = "yfhOrder";
		}
		if("ysh".equals(type)){
			typeString = "yshOrder";
		}
		return typeString;
	}
	
	/**
	 * 查看订单详情
	 */
	public String showOrderDetail(){
		//根据订单编号获取订单信息
		Order order = orderService.getOrder(orderId);
		
		//获取订单详细信息
		List<Order> orders = orderDetailService.getOrderDetailByOrderId(orderId);
		
		request.setAttribute("order", order);
		request.setAttribute("orders", orders);
		
		return "orderDeail";
		
	}
	
	/**
	 * 订单：发货
	 */
	public String fhOrder(){
		//员工
		Worker worker = (Worker) session.getAttribute("worker");
		
		List<OrderDetail> orderDetails = orderService.fhOrder(orderId,worker);
		
		//发货成功,修改商品信息
		//goodsService.updateGoodsByOrder(orderDetails);
		
		setType("dfh");
		
		return "fhOrder";
		
	}
}
