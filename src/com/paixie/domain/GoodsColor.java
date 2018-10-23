package com.paixie.domain;

import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.SearchableReference;
import org.compass.annotations.Store;

@Searchable(root=false)         //搜索实体、不是根,只作为goods的一部分
public class GoodsColor implements Serializable{

	private static final long serialVersionUID = 1L;
	private String goodsColorId;             //商品颜色编号
	private String goodsColor;               //商品颜色
	private String goodsImage;               //商品图片
	private File goodsImageFile;             //需要保存的商品图片
	private String goodsImagePath;           //需要保持的商品图片路径
	
	private Set<GoodsSize> goodsSizeSet = new HashSet<GoodsSize>(0);   //商品尺码
	private GoodsListing goodsListing = new GoodsListing();             //商品列表
	
	public GoodsColor(){
		
	}
	
	public GoodsColor(String goodsColorId){
		this.goodsColorId = goodsColorId;
	}
	
	public GoodsColor(String goodsColorId,String goodsColor,String goodsImage 
			,Set<GoodsSize> goodsSizeSet,GoodsListing goodsListing){
		this.goodsColorId = goodsColorId;
		this.goodsColor = goodsColor;
		this.goodsImage = goodsImage;
		this.goodsSizeSet = goodsSizeSet;
		this.goodsListing = goodsListing;
	}
	
	@SearchableProperty(index=Index.NO,store=Store.YES)  //需要搜索、需要存储
	public String getGoodsColorId() {
		return goodsColorId;
	}

	public void setGoodsColorId(String goodsColorId) {
		this.goodsColorId = goodsColorId;
	}
	
	@SearchableProperty(index=Index.ANALYZED,store=Store.YES) //需要搜索、需要存储
	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	@SearchableProperty(index=Index.NO,store=Store.YES,name="cGoodsImage")      //不需要搜索、需要存储
	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public Set<GoodsSize> getGoodsSizeSet() {
		return goodsSizeSet;
	}

	public void setGoodsSizeSet(Set<GoodsSize> goodsSizeSet) {
		this.goodsSizeSet = goodsSizeSet;
	}

	public File getGoodsImageFile() {
		return goodsImageFile;
	}

	public void setGoodsImageFile(File goodsImageFile) {
		this.goodsImageFile = goodsImageFile;
	}

	public String getGoodsImagePath() {
		return goodsImagePath;
	}

	public void setGoodsImagePath(String goodsImagePath) {
		this.goodsImagePath = goodsImagePath;
	}

	@SearchableReference   //引用本身
	public GoodsListing getGoodsListing() {
		return goodsListing;
	}

	public void setGoodsListing(GoodsListing goodsListing) {
		this.goodsListing = goodsListing;
	}
	
	
}
