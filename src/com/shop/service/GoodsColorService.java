package com.shop.service;

import java.util.List;

import com.shop.domain.GoodsColor;
import com.shop.domain.GoodsListing;

public interface GoodsColorService {

	/**
	 * 保存商品颜色实例
	 * @param goodsColor 商品颜色实例
	 */
	void save(GoodsColor goodsColor);

	/**
	 * 根据商品编号获取该商品的颜色
	 * @param goodsId 商品编号
	 * @return
	 */
	List<GoodsColor> getGoodsColorByGoodsId(String goodsId);

	/**
	 * 根据商品颜色获取商品颜色实例
	 * @param goodsColor 商品颜色
	 * @return
	 */
	GoodsColor getGoodsColorByColor(String goodsColor);

	/**
	 * 根据商品颜色、商品基本信息判断设置当前颜色
	 * 如果goods==null,则当前颜色为goodsColor 可以根据Color获取颜色实例
	 * 否则根据 goods获取颜色实例
	 * @param goods 商品实例
	 * @return
	 */
	GoodsColor getGoodsColorByColor(GoodsListing goods, String color);

}
