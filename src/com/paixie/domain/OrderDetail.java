package com.paixie.domain;

/*
 * ��������ʵ��
 */
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String orderDetailId;             //������ϸ���
	private Order order;                      //����
	private GoodsListing goodsListing;        //��Ʒ
	private Integer goodsNumber;              //��Ʒ����
	private String goodsColor;                //��Ʒ��ɫ
	private Integer goodsSize;                //��Ʒ����
	private Integer orderDetailIsCom;         //�Ƿ��Ѿ���������Ʒ :0��ʾ��1��ʾ��
	private Integer isAccept;                 //�Ƿ��Ѿ��յ�����
	private String acceptTime;                //�ջ�ʱ��
	public OrderDetail() {
	}

	public OrderDetail(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public OrderDetail(String orderDetailId, Order order,
			GoodsListing goodsListing, Integer goodsNumber,
			String goodsColor ,Integer goodsSize,String acceptTime,
			Integer orderDetailIsCom,Integer isAccept) {
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.goodsListing = goodsListing;
		this.goodsNumber = goodsNumber;
		this.goodsSize = goodsSize;
		this.goodsColor = goodsColor;
		this.orderDetailIsCom = orderDetailIsCom;
		this.isAccept = isAccept;
		this.acceptTime = acceptTime;
	}

	public String getOrderDetailId() {
		return this.orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public GoodsListing getGoodsListing() {
		return this.goodsListing;
	}

	public void setGoodsListing(GoodsListing goodsListing) {
		this.goodsListing = goodsListing;
	}
	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Integer getOrderDetailIsCom() {
		return this.orderDetailIsCom;
	}

	public void setOrderDetailIsCom(Integer orderDetailIsCom) {
		this.orderDetailIsCom = orderDetailIsCom;
	}

	public Integer getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	public Integer getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(Integer goodsSize) {
		this.goodsSize = goodsSize;
	}

	public String getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(String acceptTime) {
		this.acceptTime = acceptTime;
	}
}