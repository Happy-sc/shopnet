package com.paixie.domain;

/*
 * �û��ղ���Ʒʵ��
 */
public class Collect implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String collectId;              //�û��ղر��
	private Users users;                   //�û�
	private String collectTime;            //�ղ�ʱ��
	private GoodsListing goodsListing;     //�ղص���Ʒ

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