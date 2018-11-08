package com.shop.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.common.UploadAndDeleteImage;
import com.shop.dao.GoodsColorDao;
import com.shop.dao.GoodsListingDao;
import com.shop.dao.GoodsSizeDao;
import com.shop.domain.GoodsColor;
import com.shop.domain.GoodsListing;
import com.shop.domain.GoodsSize;
import com.shop.domain.OrderDetail;
import com.shop.service.GoodsColorService;
import com.shop.service.GoodsService;
import com.shop.service.GoodsSizeService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource(name="goodsListingDao")
	private GoodsListingDao goodsListingDao;
	@Resource(name="goodsColorDao")
	private GoodsColorDao goodsColorDao;
	@Resource(name="goodsSizeDao")
	private GoodsSizeDao goodsSizeDao;
	@Resource(name="uploadAndDeleteImage")
	private UploadAndDeleteImage uploadAndDeleteImage;
	@Resource(name="goodsColorService")
	private GoodsColorService goodsColorService;
	@Resource(name="goodsSizeService")
	private GoodsSizeService goodsSizeService;
	/**
	 * 增加商品基本信息
	 * @param goods 需要保存的商品基本信息
	 */
	public void addGoods(GoodsListing goods) {
		goodsListingDao.save(goods);
	}
	
	/**
	 * 根据商品编号获取商品
	 * @param goodsId 商品编号
	 * @return 指定商品编号的商品实例
	 */
	public GoodsListing getGoodsById(String goodsId) {
		return goodsListingDao.get(goodsId);
	}

	/**
	 * 修改商品信息
	 * @param goodsListing 商品信息
	 */
	public void updateGoods(GoodsListing goodsListing) {
		goodsListingDao.update(goodsListing);
	}

	/**
	 * 获取指定分类的指定数目的商品
	 * @param category 指定分类
	 * @param count 指定数目
	 * @return 指定分类的指定数量的商品
	 */
	public List<GoodsListing> getGoodsByCategoryOrder(String category, int count) {
		return goodsListingDao.getGoodsByCategory(category,count);
	}

	/**
	 * 根据特定条件获取商品并且也order排序
	 * @param string 特定条件
	 * @param order 排序条件
	 * @return 指定条件的指定排序顺序的商品
	 */
	public List<GoodsListing> getGoodsOrderString(String string, String order) {
		return goodsListingDao.getGoodsOrderString(string,order);
	}

	/**
	 * 获取推荐商品
	 * @param number 推荐数量
	 * @return 指定数量的推荐商品
	 */
	public List<GoodsListing> getGoodsByRecommend(int number) {
		return goodsListingDao.getGoodsByRecommend(number);
	}

	/**
	 * 根据商品现存量获取商品信息
	 * @return
	 */
	public List<GoodsListing> getgoodsByGoodsExitNumber() {
		return goodsListingDao.getGoodsByGoodsExitNumber();
	}

	/**
	 * 获取该分类的推荐商品，以上架时间为标准获取前5个
	 * @param categoryId 分类编号
	 * @return 前5个推荐商品信息
	 */
	public List<GoodsListing> getRecommandGoodsByCategory(String categoryId) {
		return goodsListingDao.getRecommandGoodsByCategoryId(categoryId);
	}

	/**
	 * 获取分类的商品的总数量
	 * @param categoryId 商品分类编号
	 * @return 该分类商品的总数量
	 */
	public List<GoodsListing> getGoodsSumByCategory(String categoryId) {
		return goodsListingDao.getGoodsSumByCategory(categoryId);
	}

	/**
	 * 获取某个分类的商品信息，并进行分页处理
	 * @param page 页码
	 * @return 指定商品分类的某页的pageSize个商品信息
	 */
	public List<GoodsListing> getGoodsByCategoryPage(String categoryId,String styleId, 
			String brandId, String size, String sex,String price, int i, int page) {
		//构建HQL语句
		String HQL = this.getHQL(categoryId, styleId, brandId, size, sex, price);
		
		return goodsListingDao.getGoodsByOption(HQL,i,page);
	}
	
	/**
	 *  构建查询条件 
	 * @param categoryId  分类编号
	 * @param styleId  款式编号
	 * @param brandId 品牌编号
	 * @param size 尺码
	 * @param sex 男鞋？女鞋
	 * @param price 价格
	 * @return
	 */
	private String getHQL(String categoryId,String styleId, String brandId, String size, String sex,String price){
		StringBuffer HQL = new StringBuffer("From GoodsListing as g where g.category.categoryId = "+categoryId);
		if(styleId!=null){
			HQL = HQL.append(" and g.style.styleId = "+styleId);
		}
		if(brandId!=null){
			HQL = HQL.append(" and g.brand.brandId = "+brandId);
		}
		if(size!=null){
			HQL = HQL.append(" and g.");
		}
		if(sex!=null){
			HQL = HQL.append(" and g.goodsName like %"+sex+"%");
		}
		if(price!=null){
			
		}
		return HQL.toString();
	}

	/**
	 * 获取同款热销商品
	 * @return styleId 款式编号
	 * @return 指定款式商品
	 */
	public List<GoodsListing> getMostSaleByStyle(String styleId) {
		return goodsListingDao.getMostSaleByStyle(styleId);
	}

	/**
	 * 保存商品信息
	 * @param goods  商品基本信息
	 * @param goodsColor 商品颜色
	 */
	public void saveGoods(GoodsListing goods, Set<GoodsColor> goodsColor) {
		//将商品颜色放入的商品基本信息中
		goods.setGoodsColors(goodsColor);
		//保存商品图片
		uploadAndDeleteImage.upload(goods.getGoodsImageF(), goods.getGoodsImagePath());
		//将临时文件删除
		goods.getGoodsImageF().delete();
		//保存商品颜色图片
		Iterator<GoodsColor> iterator = goodsColor.iterator();
		while (iterator.hasNext()) {
			GoodsColor color = iterator.next();
			uploadAndDeleteImage.upload(color.getGoodsImageFile(), color.getGoodsImagePath());
			color.getGoodsImageFile().delete();
		}
		
		//设置商品的总量和销售量
		int goodsSum = getGoodsSum(goodsColor);
		goods.setGoodsExitNumber(goodsSum);    //现存量
		goods.setGoodsMarketNumber(0);         //销售量
		
		//保存商品基本信息
		goodsListingDao.save(goods);
		//保持商品颜色
		Set<GoodsColor> colorSet = goods.getGoodsColors();
		Iterator<GoodsColor> iterator1 = colorSet.iterator();
		while (iterator1.hasNext()) {
			GoodsColor color1 = iterator1.next();
			color1.setGoodsListing(goods);
			//保存商品颜色
			goodsColorService.save(color1);
			
			//保存商品尺码
			Set<GoodsSize> sizeSet = color1.getGoodsSizeSet();
			Iterator<GoodsSize> iterator2 = sizeSet.iterator();
			while(iterator2.hasNext()){
				GoodsSize size = iterator2.next();
				size.setGoodsColor(color1);
				goodsSizeService.save(size);
			}
	
		}
		
	}

	/**
	 * 获取的商品总量
	 * @param goodsColors 商品颜色：里面包含了商品的数量
	 */
	public int getGoodsSum(Set<GoodsColor> goodsColors) {
		int goodsSum = 0;
		Iterator<GoodsColor> iterator = goodsColors.iterator();
		while(iterator.hasNext()){
			GoodsColor color = iterator.next();
			Set<GoodsSize> size = color.getGoodsSizeSet();
			Iterator<GoodsSize> iterator2 = size.iterator();
			while(iterator2.hasNext()){
				GoodsSize size2 = iterator2.next();
				goodsSum = goodsSum + size2.getGoodsNumber();
			}
		}
		return goodsSum;
	}

	/**
	 * 获取指定数目推荐商品
	 * @param i 数目
	 * @return
	 */
	public List<GoodsListing> getRecommandGoods(int i) {
		return goodsListingDao.getRecommand(i);
	}

	/**
	 * 根据订单修改商品数量信息：即发货
	 * @param orderDetails 订单详情
	 */
	public void updateGoodsByOrder(List<OrderDetail> orderDetails) {
		if(orderDetails.size()>0&&orderDetails!=null){
			for(int i = 0;i < orderDetails.size();i++){
				OrderDetail orderDetail = orderDetails.get(i);
				//商品现存量--，销售量+
				GoodsListing goods = goodsListingDao.get(orderDetail.getGoodsListing().getGoodsId());
				int exitNumber = goods.getGoodsExitNumber()-orderDetail.getGoodsNumber();
				int marketNumber = goods.getGoodsMarketNumber()+orderDetail.getGoodsNumber();
				goods.setGoodsExitNumber(exitNumber);
				goods.setGoodsMarketNumber(marketNumber);
				//保存商品实例
				goodsListingDao.update(goods);
				//获取该商品的指定颜色
				GoodsColor goodsColor = goodsColorDao.getGoodsColorByIdAndColor(goods.getGoodsId(),orderDetail.getGoodsColor());
				List<GoodsSize> goodsSizes = goodsSizeDao.getGoodsSizeByColor(goodsColor.getGoodsColorId());
				for(int j = 0;j < goodsSizes.size();j++){
					GoodsSize goodsSize = goodsSizes.get(i);
					if(goodsSize.getGoodsAttr()==orderDetail.getGoodsAttr()){
						int sizeNumber = goodsSize.getGoodsNumber()-orderDetail.getGoodsNumber();
						goodsSize.setGoodsNumber(sizeNumber);
						goodsSizeDao.update(goodsSize);
						break;
					}
				}
			}
		}
	}

	@Override
	public List<GoodsListing> getGoodsByAll() {
		return goodsListingDao.getAll();
	}
}
