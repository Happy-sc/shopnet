package com.paixie.queryBean;


/**
 * 商品查询条件
 */
public class GoodsQueryBean {

	private String category;           //商品分类
	private String style;              //商品款式
	private String brand;              //商品品牌
	private String goodsId;            //商品编号
	private String goodsSSSJ;          //商品上市时间
	private String goodsSJSJ;          //商品上架时间
	private String isRecommand;        //是否推荐
	private String order;              //商品排序规则
	private String goodsSize;          //商品尺码
	private String goodsPrice;         //商品价格
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsSSSJ() {
		return goodsSSSJ;
	}

	public void setGoodsSSSJ(String goodsSSSJ) {
		this.goodsSSSJ = goodsSSSJ;
	}

	public String getGoodsSJSJ() {
		return goodsSJSJ;
	}

	public void setGoodsSJSJ(String goodsSJSJ) {
		this.goodsSJSJ = goodsSJSJ;
	}

	public String getIsRecommand() {
		return isRecommand;
	}

	public void setIsRecommand(String isRecommand) {
		this.isRecommand = isRecommand;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}
