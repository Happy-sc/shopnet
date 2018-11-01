package com.shop.domain;

/*
 * 用户收藏商品实体
 */
public class Collect implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String collectId;              //用户收藏编号
	private Users users;                   //用户
	private String collectTime;            //收藏时间
	private GoodsListing goodsListing;     //收藏的商品

	public Collect() {
	}

	public Collect(String collectId) {
		this.collectId = collectId;
	}

	public Collect(String collectId, Users users, GoodsListing goodsListing,String collectTime) {
		this.collectId = collectId;
		this.users = users;
		this.goodsListing = goodsListing;
		this.collectTime = collectTime;
	}

	public String getCollectId() {
		return this.collectId;
	}

	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public GoodsListing getGoodsListing() {
		return this.goodsListing;
	}

	public void setGoodsListing(GoodsListing goodsListing) {
		this.goodsListing = goodsListing;
	}

	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
}