package com.paixie.dao;

import java.util.List;

import com.paixie.domain.GoodsSize;

public interface GoodsSizeDao {

	/**
	 * 保存商品尺码实例
	 * @param goodsSize
	 */
	void save(GoodsSize goodsSize);

	/**
	 * 获取指定商品颜色的尺码
	 * @param goodsColorId 商品颜色编号
	 * @return
	 */
	List<GoodsSize> getGoodsSizeByColor(String goodsColorId);

	/**
	 * 根据商品颜色、尺码获取尺码实例
	 * @param goodsColorId 商品颜色编号
	 * @return
	 */
	GoodsSize getGoodsSizeByColorAndSize(String goodsColorId);

	/**
	 * 修改尺码实例
	 * @param goodsSize 需要被修改的尺码实例
	 */
	void update(GoodsSize goodsSize);

}
