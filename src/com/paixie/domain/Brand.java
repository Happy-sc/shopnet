package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/*
 * ��ƷƷ��ʵ��
 */
@Searchable(root=false)  //�������Ϊ���������Ǹ���ֻ����Ϊgoods��һ����
public class Brand implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String brandId;               //Ʒ�Ʊ��
	private String brandName;             //Ʒ������
	private String brandImage;            //Ʒ��ͼƬ
	private String brandSpell;            //Ʒ��ƴ��
	private Set<Style> styles = new HashSet<Style>();          //��ʽ
	private Set<GoodsListing> goods = new HashSet<GoodsListing>();   //��Ʒ
	private String styleString ;          //���ڹ�����ʽ���ַ�
	
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

	@SearchableProperty(index=Index.NO,store=Store.YES)  //����Ҫ��������Ҫ�洢
	public String getBrandId() {
		return this.brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)  //��Ҫ��������Ҫ�洢
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
	
	@SearchableProperty(index = Index.NOT_ANALYZED,store = Store.YES)   //��Ҫ��������Ҫ�洢
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