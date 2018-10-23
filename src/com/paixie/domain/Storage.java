package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * 仓库实体
 */
public class Storage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String storageId;               //仓库编号
	private String storageName;             //仓库名称
	private String storageAddress;          //仓库所在地址
	private Set<GoodsListing> goodsListings = new HashSet<GoodsListing>(0);        //所有商品

	public Storage() {
	}

	public Storage(String storageId) {
		this.storageId = storageId;
	}

	public Storage(String storageId, String storageName, String storageAddress, Set<GoodsListing> goodsListings) {
		this.storageId = storageId;
		this.storageName = storageName;
		this.storageAddress = storageAddress;
		this.goodsListings = goodsListings;
	}

	public String getStorageId() {
		return this.storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return this.storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getStorageAddress() {
		return this.storageAddress;
	}

	public void setStorageAddress(String storageAddress) {
		this.storageAddress = storageAddress;
	}

	public Set<GoodsListing> getGoodsListings() {
		return this.goodsListings;
	}

	public void setGoodsListings(Set<GoodsListing> goodsListings) {
		this.goodsListings = goodsListings;
	}

}