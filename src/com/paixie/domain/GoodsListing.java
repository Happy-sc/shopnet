package com.paixie.domain;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

/*
 * ��Ʒ�б�ʵ��
 */
@Searchable         //����Ϊ����ʵ��
public class GoodsListing implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String goodsId;                 //��Ʒ���
	private Storage storage;                //��Ʒ���ڲֿ�
	private Category category;              //��Ʒ����
	private Style style;                    //��Ʒ��ʽ
	private Brand brand;                    //��ƷƷ��
	private String goodsName;               //��Ʒ����
	private String goodsImage;              //��ƷͼƬ
	private String goodsGrounding;          //��Ʒ�ϼ�ʱ��
	private int goodsIsRecommend;           //�Ƿ��Ƽ�  (1:�Ƽ� 0:���Ƽ�)
	private int goodsMarketNumber;          //��Ʒ������
	private int goodsExitNumber;            //��Ʒ�ִ���
	private String goodsMarket;             //��Ʒ����ʱ��
	private float goodsWeight;              //��Ʒ����
	private float goodsMarketPrice;         //��Ʒ�г���
	private float goodsBid;                 //��Ʒ����
	private int goodsState;                 //��Ʒ״̬  ��1������   0�����¼�
	private Set<Comment> comments = new HashSet<Comment>(0);                     //��Ʒ����
	private Set<Collect> collects = new HashSet<Collect>(0);                     //�ղ���Ʒ
	private Set<GoodsColor> goodsColors = new HashSet<GoodsColor>(0);          //��Ʒ��ɫ 
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);         //��Ʒ��ϸ��Ϣ
	private Set<ShoppingCar> shoppingCars = new HashSet<ShoppingCar>(0);         //�û����ﳵ
	
	private File goodsImageF;                //Ҫ�ϴ�����ƷͼƬ
	private String goodsImagePath ;           //ͼƬ�ϴ�·��
	
	public GoodsListing() {
	}

	public GoodsListing(String goodsId) {
		this.goodsId = goodsId;
	}

	public GoodsListing(String goodsId, Storage storage, Category category,Style style,
			String goodsName, String goodsGrounding,String goodsImage, Brand brand,int goodsMarketNumber,int goodsExitNumber,
			String goodsMarket,int goodsIsRecommend, Set<ShoppingCar> shoppingCars,float goodsWeight, float goodsMarketPrice,Integer goodsState,
			 float goodsBid, Set<Comment> comments, Set<Collect> collects, Set<OrderDetail> orderDetails, Set<GoodsColor> goodsColors) {
		this.goodsId = goodsId;
		this.storage = storage;
		this.category = category;
		this.style = style;
		this.brand = brand;
		this.goodsName = goodsName;
		this.goodsGrounding = goodsGrounding;
		this.goodsImage = goodsImage;
		this.goodsIsRecommend = goodsIsRecommend;
		this.goodsMarketNumber = goodsMarketNumber;
		this.goodsExitNumber = goodsExitNumber;
		this.goodsMarket = goodsMarket;
		this.goodsWeight = goodsWeight;
		this.goodsMarketPrice = goodsMarketPrice;
		this.goodsBid = goodsBid;
		this.comments = comments;
		this.collects = collects;
		this.orderDetails = orderDetails;
		this.goodsColors = goodsColors;
		this.shoppingCars = shoppingCars;
		this.goodsState = goodsState;
	}

	@SearchableId  //���������Ϊ����ʵ��ı�ʶ����
	public String getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Storage getStorage() {
		return this.storage;
	}
	
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@SearchableComponent
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@SearchableComponent
	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@SearchableComponent
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@SearchableProperty(boost=2)        //ʹ��Ĭ��ֵ��ʹ�������ֶΣ����ҷ��������ļ���
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsGrounding() {
		return this.goodsGrounding;
	}

	public void setGoodsGrounding(String goodsGrounding) {
		this.goodsGrounding = goodsGrounding;
	}

	@SearchableProperty(index=Index.NO,store=Store.YES,name="goodsImage")  //����Ҫ��������Ҫ�洢
	public String getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	
	public int getGoodsIsRecommend() {
		return goodsIsRecommend;
	}

	public void setGoodsIsRecommend(int goodsIsRecommend) {
		this.goodsIsRecommend = goodsIsRecommend;
	}

	public int getGoodsMarketNumber() {
		return goodsMarketNumber;
	}

	public void setGoodsMarketNumber(int goodsMarketNumber) {
		this.goodsMarketNumber = goodsMarketNumber;
	}

	public int getGoodsExitNumber() {
		return goodsExitNumber;
	}

	public void setGoodsExitNumber(int goodsExitNumber) {
		this.goodsExitNumber = goodsExitNumber;
	}

	public String getGoodsMarket() {
		return this.goodsMarket;
	}

	public void setGoodsMarket(String goodsMarket) {
		this.goodsMarket = goodsMarket;
	}

	public float getGoodsWeight() {
		return this.goodsWeight;
	}

	public void setGoodsWeight(float goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	@SearchableProperty(index=Index.NO,store=Store.YES)   //����Ҫ��������Ҫ�洢
	public float getGoodsMarketPrice() {
		return this.goodsMarketPrice;
	}

	public void setGoodsMarketPrice(float goodsMarketPrice) {
		this.goodsMarketPrice = goodsMarketPrice;
	}

	public float getGoodsBid() {
		return this.goodsBid;
	}

	public void setGoodsBid(float goodsBid) {
		this.goodsBid = goodsBid;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Collect> getCollects() {
		return this.collects;
	}

	public void setCollects(Set<Collect> collects) {
		this.collects = collects;
	}
	public Set<ShoppingCar> getShoppingCars() {
		return shoppingCars;
	}

	public void setShoppingCars(Set<ShoppingCar> shoppingCars) {
		this.shoppingCars = shoppingCars;
	}

	public int getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(int goodsState) {
		this.goodsState = goodsState;
	}

	public File getGoodsImageF() {
		return goodsImageF;
	}

	public void setGoodsImageF(File goodsImageF) {
		this.goodsImageF = goodsImageF;
	}

	public String getGoodsImagePath() {
		return goodsImagePath;
	}

	public void setGoodsImagePath(String goodsImagePath) {
		this.goodsImagePath = goodsImagePath;
	}

	@SearchableComponent   //����ʵ��
	public Set<GoodsColor> getGoodsColors() {
		return goodsColors;
	}

	public void setGoodsColors(Set<GoodsColor> goodsColors) {
		this.goodsColors = goodsColors;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}