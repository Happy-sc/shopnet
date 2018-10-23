package com.paixie.dao;

import java.util.List;

import com.paixie.domain.GoodsColor;

public interface GoodsColorDao {

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
	List<GoodsColor> getGoodsColor(String goodsId);

	/**
	 * 根据商品颜色获取商品颜色实例
	 * @param goodsColor 商品颜色
	 * @return
	 */
	GoodsColor getGoodsColorByColor(String goodsColor);

	/**
	 * 根据颜色编号获取指定颜色实例
	 * @param color  演示编号
	 * @return
	 */
	GoodsColor getGoodsColorByColorId(String colorId);

	/**
	 * 根据颜色名称获取颜色实例
	 * @param goodsColor 颜色名称
	 * @return
	 */
	GoodsColor getGoodsColorByColorName(String goodsColor);

	/**
	 * 根据商品编号和颜色获取指定的商品颜色实例
	 * @param goodsId 商品编号
	 * @param goodsColor 商品颜色
	 * @return
	 */
	GoodsColor getGoodsColorByIdAndColor(String goodsId, String goodsColor);

}
