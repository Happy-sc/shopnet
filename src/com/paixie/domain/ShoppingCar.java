package com.paixie.domain;

import java.io.Serializable;

public class ShoppingCar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String carId;                       //���ﳵ���
	private int goodsNumber;                    //��Ʒ����
	private String goodsColor;                  //��Ʒ��ɫ
	private String goodsAttr;                  //��Ʒ����
	private Users users;                        //�û�
	private GoodsListing goodsListing;          //��Ʒ
	
	public ShoppingCar(){
		
	}
	
	public ShoppingCar(String carId){
		this.carId = carId;
	}
	
	public ShoppingCar(String carId,int goodsNumber,String goodsColor,
			String goodsAttr,Users users,GoodsListing goodsListing){
		this.carId = carId;
		this.goodsNumber = goodsNumber;
		this.goodsColor = goodsColor;
		this.goodsAttr = goodsAttr;
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

	public String getGoodsAttr() {
		return goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}
}
