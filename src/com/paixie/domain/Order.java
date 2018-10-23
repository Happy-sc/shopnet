package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * 订单实体
 */
public class Order implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String orderId;                  //订单编号
	private Users users;                     //用户
	private Worker worker;                   //管理员
	private String orderPhone;               //联系电话
	private String orderAddress;             //联系地址
	private String orderPostalcode;          //邮政编码
	private String orderConsignee;           //收货人
	private String orderPayment;             //支付方式 0:在线支付、1：货到付款、2：线下支付
	private float orderPrice;                //商品总价格
	private float orderFreight;              //运费
	private String orderDate;                //订单日期
	private String orderSend;                //发货日期
	private String orderOver;                //收货日期
	private String orderUserRequire;         //用户要求
	private int paixieBNum;                  //使用拍鞋币个数
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);       //订单详细情况
	private OrderState orderState;           //订单状态
	
	public Order() {
	}

	public Order(String orderId) {
		this.orderId = orderId;
	}

	public Order(String orderId, Users users, Worker worker,int paixieBNum,
			OrderState orderState,String orderPhone, String orderAddress,
			float orderPrice, String orderDate, String orderConsignee,String orderOver,
			String orderPostalcode, String orderSend,Set<OrderDetail> orderDetails,
			String orderPayment,String orderUserRequire,float orderFreight) {
		this.orderId = orderId;
		this.users = users;
		this.paixieBNum = paixieBNum;
		this.worker = worker;
		this.orderPhone = orderPhone;
		this.orderAddress = orderAddress;
		this.orderPrice = orderPrice;
		this.orderDate = orderDate;
		this.orderConsignee = orderConsignee;
		this.orderOver = orderOver;
		this.orderPostalcode = orderPostalcode;
		this.orderSend = orderSend;
		this.orderDetails = orderDetails;
		this.orderPayment = orderPayment;
		this.orderUserRequire = orderUserRequire;
		this.orderFreight = orderFreight;
		this.orderState = orderState;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	public String getOrderPhone() {
		return this.orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderAddress() {
		return this.orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public float getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPostalcode() {
		return this.orderPostalcode;
	}

	public void setOrderPostalcode(String orderPostalcode) {
		this.orderPostalcode = orderPostalcode;
	}

	public String getOrderSend() {
		return this.orderSend;
	}

	public void setOrderSend(String orderSend) {
		this.orderSend = orderSend;
	}

	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}

	public String getOrderUserRequire() {
		return orderUserRequire;
	}

	public void setOrderUserRequire(String orderUserRequire) {
		this.orderUserRequire = orderUserRequire;
	}

	public String getOrderConsignee() {
		return orderConsignee;
	}

	public void setOrderConsignee(String orderConsignee) {
		this.orderConsignee = orderConsignee;
	}

	public float getOrderFreight() {
		return orderFreight;
	}

	public void setOrderFreight(float orderFreight) {
		this.orderFreight = orderFreight;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public int getPaixieBNum() {
		return paixieBNum;
	}

	public void setPaixieBNum(int paixieBNum) {
		this.paixieBNum = paixieBNum;
	}

	public String getOrderOver() {
		return orderOver;
	}

	public void setOrderOver(String orderOver) {
		this.orderOver = orderOver;
	}
}