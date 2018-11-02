package com.shop.action.prosceniums;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.GetTime;
import com.shop.common.ProduceId;
import com.shop.domain.Address;
import com.shop.domain.Order;
import com.shop.domain.OrderDetail;
import com.shop.domain.OrderState;
import com.shop.domain.JinBRecord;
import com.shop.domain.ShoppingCar;
import com.shop.domain.Users;
import com.shop.service.AddressService;
import com.shop.service.OrderDetailService;
import com.shop.service.OrderService;
import com.shop.service.OrderStateService;
import com.shop.service.JinBService;
import com.shop.service.UsersService;

@Controller("orderAction")
public class OrderAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="addressService")private AddressService addressService;
	@Resource(name="orderService")private OrderService orderService;
	@Resource(name="orderDetailService")private OrderDetailService orderDetailService;
	@Resource(name="orderStateService") private OrderStateService orderStateService;
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="")private JinBService jinBService;
	private Order order;
	private String type;
	private String orderDetailId;
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	/**
	 * 确定订单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String firmOrder(){
		//获取该用户
		Users user = (Users) session.getAttribute("user");
		//获取用户的默认地址
		Address dfAddress = null;
		Address address1 = addressService.getUserDefaultAddress(user.getUserId());
		if(address1!=null){
			dfAddress = address1;
		}
		else {    //如果用户没有设置默认地址
			List<Address> addresses = addressService.getAddressByUser(user.getUserId());
			if(addresses!=null&&addresses.size()!=0)
				dfAddress = addresses.get(0);
		}
		
		//获取购物车
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) session.getAttribute("mapCar");
		//计算购物车的总金额
		float sum = 0;
		for(Entry<String, ShoppingCar> mycar:mapCar.entrySet()){
			sum = sum + mycar.getValue().getGoodsNumber()*mycar.getValue().getGoodsListing().getGoodsMarketPrice();
		}
		
		//设置运费
		float freight = 0;
		freight = sum<259?10:0;
		//保存信息
		ActionContext.getContext().put("address", dfAddress);
		ActionContext.getContext().put("mapCar", mapCar);
		ActionContext.getContext().put("sum", sum);
		ActionContext.getContext().put("freight", freight);
		ActionContext.getContext().put("type", "firmOrder");
		
		return "firmOrder";
	}
	
	/**
	 * 提交订单
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("unchecked")
	public String submitOrder(){
		Map<String, ShoppingCar> mapCar = (Map<String, ShoppingCar>) request.getSession().getAttribute("mapCar");   //购物车
		Users users = (Users) request.getSession().getAttribute("user");          //用户
		
		//新建订单
		Order newOrder = new Order();
		//设置订单值
		newOrder.setOrderId(ProduceId.getId());                        //订单编号
		newOrder.setOrderAddress(order.getOrderAddress());             //订单接收地址
		newOrder.setOrderConsignee(order.getOrderConsignee());         //订单接收人
		String orderDate = GetTime.getTime("yyyy-MM-dd HH:mm:ss");
		newOrder.setOrderDate(orderDate);                              //订单时间
		newOrder.setOrderFreight(order.getOrderFreight());             //运费
		newOrder.setOrderPayment(order.getOrderPayment());             //支付方式
		newOrder.setOrderPhone(order.getOrderPhone());                 //联系电话
		newOrder.setOrderPostalcode(order.getOrderPostalcode());       //邮政编码
		newOrder.setOrderPrice(order.getOrderPrice());                 //订单总金额
		newOrder.setJinBNum(order.getJinBNum());                 //用户使用金币
		newOrder.setUsers(users);                                      //用户
		newOrder.setOrderUserRequire(order.getOrderUserRequire());     //用户要求
		
		//处理订单状态
		//如果为货到付款，则订单状态为:待发货
		//如果为线上支付、线下支付则为代付款：只有付款后才能发货
		OrderState orderState ;
		if("1".equals(order.getOrderPayment())){
			orderState = orderStateService.getOrderState("500001");
		}
		else {
			orderState = orderStateService.getOrderState("500003");
		}
		
		newOrder.setOrderState(orderState);
		
		//保存订单,
		orderService.saveOrder(newOrder); 
		//保存订单详细,同时在数据库中删除购物车里面的这些数据
		orderDetailService.saveOrderDetail(mapCar,newOrder);
		
		/*
		 * 如果获取拍鞋币个数不为0
		 * 则保存用户获得拍鞋币记录
		 * 且修改用户金币个数
		 */
		int jinBSum = (int) (order.getOrderPrice()/100);
		//获得拍鞋币
		if(jinBSum>0){
			JinBRecord jinBRecord = new JinBRecord();
			jinBRecord.setJinBId(ProduceId.getId());
			jinBRecord.setJinBNum(jinBSum);
			jinBRecord.setJinBState(1);
			jinBRecord.setJinBTime(orderDate);
			jinBRecord.setJinBStyle("购买商品时，获取了"+jinBSum+"个金币");
			jinBRecord.setUsers(users);
			jinBService.saveJinB(jinBRecord);
		}
		
		String sypxb = request.getParameter("sypxb");
		int sypxbS = 0;
		if(sypxb!=null&&!"".equals(sypxb)){
			sypxbS = Integer.valueOf(sypxb);
		}
		
		//如果使用金币
		if(sypxbS>0){
			JinBRecord jinBRecord = new JinBRecord();
			jinBRecord.setJinBId(ProduceId.getId());
			jinBRecord.setJinBNum(sypxbS);
			jinBRecord.setJinBState(0);
			jinBRecord.setJinBTime(orderDate);
			jinBRecord.setJinBStyle("购买商品时，使用了"+sypxbS+"个拍鞋币");
			jinBRecord.setUsers(users);
			jinBService.saveJinB(jinBRecord);
		}
		
		//修改用户的拍鞋币个数
		int userPaixie = users.getJinB()+jinBSum-sypxbS;
		users.setJinB(userPaixie);
		usersService.updateUser(users);
		
		int flag = 0 ;    //标签：判断支付方式，支付方式不同，显示的界面不同
		if("货到付款".equals(order.getOrderPayment()))
			flag = 0;
		if("线下支付".equals(order.getOrderPayment()))
			flag = 1;
		if("在线支付".equals(order.getOrderPayment()))
			flag = 2;

		//清空购物车
		session.removeAttribute("mapCar");
		
		ActionContext.getContext().put("flag", flag);
		ActionContext.getContext().put("orderPrice", newOrder.getOrderPrice());
		ActionContext.getContext().put("orderId", newOrder.getOrderId());
		ActionContext.getContext().put("type", "successOrder");
		
	
		return "submitSuccess";
	}
	
	/**
	 * 查看订单
	 * @return
	 */
	public String seeOrder(){
		//用户
		Users user = (Users) request.getSession().getAttribute("user");
		//类型
		int page = super.getPage();
		Map<Order, List<OrderDetail>> AllOrders = new HashMap<Order, List<OrderDetail>>();    //订单
		List<OrderDetail> orList = new ArrayList<OrderDetail>();
		int allSum = 0 ;         //订单总数
		/*
		 * 获取订单信息
		 * 如果是待收货则需要从orderDetail中获取数据
		 * 否则是需要时order中获取数据
		 */
		if("dsh".equals(type)){
			orList = orderDetailService.getDSHOrderDetail(page,user.getUserId(),0);        //用户待收货订单
			allSum = orderDetailService.getDSHOrderSum(user.getUserId(),0);
		}
		else {
			 AllOrders = orderService.getOrderByUserState(page,user.getUserId(),type);  //所有订单
			 allSum = orderService.getAllOrderSum(user.getUserId(),type);
		}
		
		pageSum = allSum%5==0?allSum/5:allSum/5+1;        //所有订单
			
		//保存信息
		ActionContext.getContext().put("allOrders",AllOrders);
		ActionContext.getContext().put("orlist", orList);
		return "seeOrder";
	}
	

	/**
	 * 取消订单
	 * @return
	 */
	public String cancelOrder(){
		String orderId = request.getParameter("orderId");
		System.out.println(super.getPage());
		System.out.println(type);
		Order order = orderService.getOrder(orderId);
		OrderState orderState = orderStateService.getOrderState("500005");
		
		order.setOrderState(orderState);
		orderService.updateOrder(order);

		return "cancelOrder";
	}
	
	/**
	 * 确认收货
	 */
	public String qrsh(){
		//订单编号
		String orderId = request.getParameter("orderId");
		//订单详情编号
		
		//获取订单详情
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
		orderDetail.setIsAccept(1);
		orderDetail.setAcceptTime(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		
		/*
		 * 确认收货，更改orderDetail，并且查看所属订单中是否还有没有确认收货的订单
		 * 如果没有 则修改整个订单状态  ---确认收货
		 * 否则不修改
		 */
		orderDetailService.QRSH(orderDetail,orderId);

		//确认收货后，转到商品评价
		return "qrsh";    
	}
}
