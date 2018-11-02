package com.shop.domain;

import java.util.HashSet;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/*
 * 商品品牌实体
 */
@Searchable(root=false)  //定义该类为搜索、不是根、只是作为goods的一部分
public class Brand implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String brandId;               //品牌编号
	private String brandName;             //品牌名称
	private String brandImage;            //品牌图片
	private String brandSpell;            //品牌拼音
	private Set<Style> styles = new HashSet<Style>();          //款式
	private Set<GoodsListing> goods = new HashSet<GoodsListing>();   //商品
	private String styleString ;          //用于构建款式的字符
	
	public Brand() {
	}

	public Brand(String brandId) {
		this.brandId = brandId;
	}

	public Brand(String brandId, Set<Style> styles, String brandName, String brandImage,String brandSpell) {
		this.brandId = brandId;
		this.styles = styles;
		this.brandName = brandName;
		this.brandImage = brandImage;
		this.brandSpell = brandSpell;
	}

	@SearchableProperty(index=Index.NO,store=Store.YES)  //不需要搜索、需要存储
	public String getBrandId() {
		return this.brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)  //需要搜索、需要存储
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Style> getStyles() {
		return styles;
	}

	public void setStyles(Set<Style> styles) {
		this.styles = styles;
	}

	public String getBrandImage() {
		return this.brandImage;
	}

	public void setBrandImage(String brandImage) {
		this.brandImage = brandImage;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)   //需要搜索、需要存储
	public String getBrandSpell() {
		return brandSpell;
	}

	public void setBrandSpell(String brandSpell) {
		this.brandSpell = brandSpell;
	}

	public String getStyleString() {
		return styleString;
	}

	public void setStyleString(String styleString) {
		this.styleString = styleString;
	}

	public Set<GoodsListing> getGoods() {
		return goods;
	}

	public void setGoods(Set<GoodsListing> goods) {
		this.goods = goods;
	}

}