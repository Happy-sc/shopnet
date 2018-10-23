package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * ����ʵ��
 */
public class Order implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String orderId;                  //�������
	private Users users;                     //�û�
	private Worker worker;                   //����Ա
	private String orderPhone;               //��ϵ�绰
	private String orderAddress;             //��ϵ��ַ
	private String orderPostalcode;          //��������
	private String orderConsignee;           //�ջ���
	private String orderPayment;             //֧����ʽ 0:����֧����1���������2������֧��
	private float orderPrice;                //��Ʒ�ܼ۸�
	private float orderFreight;              //�˷�
	private String orderDate;                //��������
	private String orderSend;                //��������
	private String orderOver;                //�ջ�����
	private String orderUserRequire;         //�û�Ҫ��
	private int paixieBNum;                  //ʹ����Ь�Ҹ���
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);       //������ϸ���
	private OrderState orderState;           //����״̬
	
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