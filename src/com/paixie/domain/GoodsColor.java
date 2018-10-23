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

@Searchable(root=false)         //����ʵ�塢���Ǹ�,ֻ��Ϊgoods��һ����
public class GoodsColor implements Serializable{

	private static final long serialVersionUID = 1L;
	private String goodsColorId;             //��Ʒ��ɫ���
	private String goodsColor;               //��Ʒ��ɫ
	private String goodsImage;               //��ƷͼƬ
	private File goodsImageFile;             //��Ҫ�������ƷͼƬ
	private String goodsImagePath;           //��Ҫ���ֵ���ƷͼƬ·��
	
	private Set<GoodsSize> goodsSizeSet = new HashSet<GoodsSize>(0);   //��Ʒ����
	private GoodsListing goodsListing = new GoodsListing();             //��Ʒ�б�
	
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
	
	@SearchableProperty(index=Index.NO,store=Store.YES)  //��Ҫ��������Ҫ�洢
	public String getGoodsColorId() {
		return goodsColorId;
	}

	public void setGoodsColorId(String goodsColorId) {
		this.goodsColorId = goodsColorId;
	}
	
	@SearchableProperty(index=Index.ANALYZED,store=Store.YES) //��Ҫ��������Ҫ�洢
	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	@SearchableProperty(index=Index.NO,store=Store.YES,name="cGoodsImage")      //����Ҫ��������Ҫ�洢
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

	@SearchableReference   //���ñ���
	public GoodsListing getGoodsListing() {
		return goodsListing;
	}

	public void setGoodsListing(GoodsListing goodsListing) {
		this.goodsListing = goodsListing;
	}
	
	
}
