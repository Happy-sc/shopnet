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
	 * �鿴������Ϣ
	 */
	public String managerOrder(){
		//�������ͻ�ȡ��Ӧ�Ķ���
		List<Order> orders = orderService.getOrderByState(super.getPage(),type);
		
		//��ȡ��������ҳ��
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
	 * �鿴��������
	 */
	public String showOrderDetail(){
		//���ݶ�����Ż�ȡ������Ϣ
		Order order = orderService.getOrder(orderId);
		
		//��ȡ������ϸ��Ϣ
		List<Order> orders = orderDetailService.getOrderDetailByOrderId(orderId);
		
		request.setAttribute("order", order);
		request.setAttribute("orders", orders);
		
		return "orderDeail";
		
	}
	
	/**
	 * ����������
	 */
	public String fhOrder(){
		//Ա��
		Worker worker = (Worker) session.getAttribute("worker");
		
		List<OrderDetail> orderDetails = orderService.fhOrder(orderId,worker);
		
		//�����ɹ�,�޸���Ʒ��Ϣ
		//goodsService.updateGoodsByOrder(orderDetails);
		
		setType("dfh");
		
		return "fhOrder";
		
	}
}
