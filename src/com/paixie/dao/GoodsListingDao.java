package com.paixie.dao;

import java.util.List;

import com.paixie.domain.GoodsListing;

public interface GoodsListingDao {
	/**
	 * 根据标识属性获取GoodsListing实例
	 * @param goodsId
	 * @return
	 */
	GoodsListing get(String goodsId);
	
	/**
	 * 保存GoodsListing实例
	 * @param goodsListing
	 */
	void save(GoodsListing goodsListing);
	
	/**
	 * 根据标识属性删除GoodsLIsting实例
	 * @param goodsId
	 */
	void delete(String goodsId);
	
	/**
	 * 删除GoodsListing实例
	 * @param goodsListing
	 */
	void delete(GoodsListing goodsListing);
	
	/**
	 * 修改GoodsListing实例
	 * @param goodsListing
	 */
	void update(GoodsListing goodsListing);
	
	/**
	 * 根据款式获取GoodsListing实例
	 * @param typeId
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	List<GoodsListing> getGoodsByType(String typeId,int pageSize,int pageNo);
	
	/**
	 * 根据品牌获取GoodsListting实例
	 * @param brandId
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	List<GoodsListing> getGoodsByBrand(String brandId,int pageSize,int pageNo);
	
	/**
	 * 获取指定商品分类的的指定数量的商品
	 * @param category
	 * @param count
	 * @return
	 */
	List<GoodsListing> getGoodsByCategory(String category, int count);

	/**
	 * 根据特定条件获取商品并且也order排序
	 * @param string
	 * @param order
	 * @return
	 */
	List<GoodsListing> getGoodsOrderString(String string, String order);

	/**
	 * 获取推荐商品
	 * @param number
	 * @return
	 */
	List<GoodsListing> getGoodsByRecommend(int number);

	/**
	 * 根据商品现存量获取商品信息
	 * @return
	 */
	List<GoodsListing> getGoodsByGoodsExitNumber();

	/**
	 * 根据商品分类获取推荐商品
	 * @param categoryId
	 * @return
	 */
	List<GoodsListing> getRecommandGoodsByCategoryId(String categoryId);

	/**
	 * 获取分类的商品的总数量
	 * @param categoryId
	 * @return
	 */
	List<GoodsListing> getGoodsSumByCategory(String categoryId);

	/**
	 * 根据HQL语句获取相应的商品信息，并进行分页处理
	 * @param hQL
	 * @param i
	 * @param page
	 * @return
	 */
	List<GoodsListing> getGoodsByOption(String hQL, int i, int page);

	/**
	 * 
	 * @param styleId
	 * @return
	 */
	List<GoodsListing> getMostSaleByStyle(String styleId);

	/**
	 * 获取指定数目推荐商品
	 * @param i 数目
	 * @return
	 */
	List<GoodsListing> getRecommand(int i);
}
