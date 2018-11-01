package com.shop.action.backstage;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.shop.action.common.BaseAction;
import com.shop.domain.Order;
import com.shop.domain.OrderDetail;
import com.shop.domain.Worker;
import com.shop.service.GoodsService;
import com.shop.service.OrderDetailService;
import com.shop.service.OrderService;

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

	public String managerOrder(){

		List<Order> orders = orderService.getOrderByState(super.getPage(),type);
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

	public String showOrderDetail(){
		Order order = orderService.getOrder(orderId);

		List<Order> orders = orderDetailService.getOrderDetailByOrderId(orderId);
		
		request.setAttribute("order", order);
		request.setAttribute("orders", orders);
		
		return "orderDeail";
		
	}

	public String fhOrder(){
		Worker worker = (Worker) session.getAttribute("worker");
		
		List<OrderDetail> orderDetails = orderService.fhOrder(orderId,worker);
		//goodsService.updateGoodsByOrder(orderDetails);
		
		setType("dfh");
		
		return "fhOrder";
		
	}
}
