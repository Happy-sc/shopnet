package com.paixie.domain;

import java.io.Serializable;

public class GoodsSize implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String goodsSizeId;              //商品尺码编号
	private Integer goodsSize;               //商品尺码
	private Integer goodsNumber;             //商品数量
	private GoodsColor goodsColor = new GoodsColor();           //商品颜色
	
	public GoodsSize(){
		
	}
	
	public GoodsSize(String goodsSizeId){
		this.goodsSizeId = goodsSizeId;
	}
	
	public GoodsSize(String goodsSizeId,Integer goodsSize,Integer goodsNumber,
			GoodsColor goodsColor){
		this.goodsSizeId = goodsSizeId;
		this.goodsSize = goodsSize;
		this.goodsNumber = goodsNumber;
		this.goodsColor = goodsColor;
	}

	public String getGoodsSizeId() {
		return goodsSizeId;
	}

	public void setGoodsSizeId(String goodsSizeId) {
		this.goodsSizeId = goodsSizeId;
	}

	public Integer getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(Integer goodsSize) {
		this.goodsSize = goodsSize;
	}

	public Integer getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public GoodsColor getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(GoodsColor goodsColor) {
		this.goodsColor = goodsColor;
	}

}
