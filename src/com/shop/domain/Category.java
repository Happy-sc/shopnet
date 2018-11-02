package com.shop.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/*
 * 商品分类实体
 */
@Searchable(root=false)   //定义该类为搜索实体、不是根、只是作为goods的一部分
public class Category implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String categoryId; 							// 分类编号
	private String categoryName; 						// 分类名称
	private Set<GoodsListing> goodsListings = new HashSet<GoodsListing>();    // 商品
	private Set<Style> styles = new HashSet<Style>(); 				// 款式
	private String styleString;                         //款式

	private List<Brand> hotSellBrand = new ArrayList<>();    // 品牌,不保存数据库

	public Category() {
	}

	public Category(String categoryId, String categoryName, Set<GoodsListing> goodsListings, Set<Style> styles) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.goodsListings = goodsListings;
		this.styles = styles;
	}

	@SearchableProperty(index=Index.NO,store=Store.YES)  //不需要搜索、需要存储
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)  //需要搜索、需要存储
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<GoodsListing> getGoodsListings() {
		return goodsListings;
	}

	public void setGoodsListings(Set<GoodsListing> goodsListings) {
		this.goodsListings = goodsListings;
	}

	public Set<Style> getStyles() {
		return styles;
	}

	public void setStyles(Set<Style> styles) {
		this.styles = styles;
	}

	public String getStyleString() {
		return styleString;
	}

	public void setStyleString(String styleString) {
		this.styleString = styleString;
	}

	public List<Brand> getHotSellBrand() {
		return hotSellBrand;
	}

	public void setHotSellBrand(List<Brand> hotSellBrand) {
		this.hotSellBrand = hotSellBrand;
	}
}
