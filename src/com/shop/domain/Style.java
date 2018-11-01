package com.shop.domain;

import java.util.HashSet;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/*
 * 商品款式实体
 */
@Searchable(root=false)   //定义该类为搜索实体、不是根、只是作为goods的一部分
public class Style implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String styleId;                //款式编号
	private String styleName;              //款式名称
	private Category category;             //分类
	private Brand brand;
	private Set<GoodsListing> goods = new HashSet<GoodsListing>();     //商品

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

	@SearchableProperty(index = Index.NO,store = Store.YES)  //不需要搜索、需要存储
	public String getStyleId() {
		return this.styleId;
	}

	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)  //需要搜索、需要存储
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