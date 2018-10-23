package com.paixie.domain;

import java.io.Serializable;

public class ShoppingCar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String carId;                       //购物车编号
	private int goodsNumber;                    //商品数量
	private String goodsColor;                  //商品颜色
	private Integer goodsSize;                  //商品尺码 
	private Users users;                        //用户
	private GoodsListing goodsListing;          //商品
	
	public ShoppingCar(){
		
	}
	
	public ShoppingCar(String carId){
		this.carId = carId;
	}
	
	public ShoppingCar(String carId,int goodsNumber,String goodsColor,
			Integer goodsSize,Users users,GoodsListing goodsListing){
		this.carId = carId;
		this.goodsNumber = goodsNumber;
		this.goodsColor = goodsColor;
		this.goodsSize = goodsSize;
		this.users = users;
		this.goodsListing = goodsListing;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public GoodsListing getGoodsListing() {
		return goodsListing;
	}

	public void setGoodsListing(GoodsListing goodsListing) {
		this.goodsListing = goodsListing;
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
}
