package com.paixie.domain;

/*
 * 订单详情实体
 */
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String orderDetailId;             //订单详细编号
	private Order order;                      //订单
	private GoodsListing goodsListing;        //商品
	private Integer goodsNumber;              //商品数量
	private String goodsColor;                //商品颜色
	private Integer goodsSize;                //商品尺码
	private Integer orderDetailIsCom;         //是否已经评价了商品 :0表示否，1表示是
	private Integer isAccept;                 //是否已经收到货物
	private String acceptTime;                //收货时间
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