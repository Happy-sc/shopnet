package com.paixie.service;

import java.util.List;
import java.util.Set;

import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.OrderDetail;

public interface GoodsService {

	/**
	 * 根据商品编号获取商品实例
	 * @param goodsId 商品编号
	 */
	GoodsListing getGoodsById(String goodsId);

	/**
	 * 根据分类获取i个商品
	 * @param category 商品分类
	 * @param i 获取商品的数量
	 */
	List<GoodsListing> getGoodsByCategoryOrder(String category, int i);

	/**
	 * 根据特定排序获取商品
	 * @param string 特定条件
	 * @param order 排序条件
	 */
	List<GoodsListing> getGoodsOrderString(String string, String order);

	/**
	 * 获取推荐商品
	 * @param number 推荐数量
	 * @return 指定数量的推荐商品
	 */
	List<GoodsListing> getGoodsByRecommend(int number);

	/**
	 * 根据商品现存量获取商品信息
	 * @return
	 */
	List<GoodsListing> getgoodsByGoodsExitNumber();

	/**
	 * 获取该分类的推荐商品，以上架时间为标准获取前5个
	 * @param categoryId 分类编号
	 * @return 前5个推荐商品信息
	 */
	List<GoodsListing> getRecommandGoodsByCategory(String categoryId);

	/**
	 * 获取分类的商品的总数量
	 * @param categoryId 商品分类编号
	 * @return 该分类商品的总数量
	 */
	List<GoodsListing> getGoodsSumByCategory(String categoryId);
	
	/**
	 * 获取某个分类的商品信息，并进行分页处理
	 * @param category 商品分类编号
	 * @param pageSize 每页显示商品的数量
	 * @param page 页码
	 * @return 指定商品分类的某页的pageSize个商品信息
	 */
	List<GoodsListing> getGoodsByCategoryPage(String categoryId,
			String styleId, String brandId, String size, String sex,
			String price, int i, int page);

	/**
	 * 获取同款热销商品
	 * @return styleId 款式编号
	 * @return 指定款式商品
	 */
	List<GoodsListing> getMostSaleByStyle(String styleId);


	/**
	 * 保存商品信息
	 * @param goods  商品基本信息
	 * @param goodsColor 商品颜色
	 */
	void saveGoods(GoodsListing goods, Set<GoodsColor> goodsColor);
	
	/**
	 * 获取的商品总量
	 * @param goodsColors 商品颜色：里面包含了商品的数量
	 */
	public int getGoodsSum(Set<GoodsColor> goodsColors);

	/**
	 * 获取指定数目推荐商品
	 * @param i 数目
	 * @return
	 */
	List<GoodsListing> getRecommandGoods(int i);

	/**
	 * 根据订单修改商品数量信息：即发货
	 * @param orderDetails 订单详情
	 */
	void updateGoodsByOrder(List<OrderDetail> orderDetails);

}
