package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/*
 * ��Ʒ��ʽʵ��
 */
@Searchable(root=false)   //�������Ϊ����ʵ�塢���Ǹ���ֻ����Ϊgoods��һ����
public class Style implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String styleId;                //��ʽ���
	private String styleName;              //��ʽ����
	private Category category;             //����
	private Brand brand;
	private Set<GoodsListing> goods = new HashSet<GoodsListing>();     //��Ʒ

	public Style() {
	}

	public Style(String styleId) { 
		this.styleId = styleId;
	}

	public Style(String styleId, String styleName, Set<GoodsListing> goodsListings,Category category,Brand brand) {
		this.styleId = styleId;
		this.styleName = styleName;
		this.category = category;
		this.brand = brand;
	}

	@SearchableProperty(index = Index.NO,store = Store.YES)  //����Ҫ��������Ҫ�洢
	public String getStyleId() {
		return this.styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)  //��Ҫ��������Ҫ�洢
	public String getStyleName() {
		return this.styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public Set<GoodsListing> getGoods() {
		return goods;
	}

	public void setGoods(Set<GoodsListing> goods) {
		this.goods = goods;
	}
}