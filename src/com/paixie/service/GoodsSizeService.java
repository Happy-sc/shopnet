package com.paixie.service;

import java.util.List;

import com.paixie.domain.GoodsSize;

public interface GoodsSizeService {

	/**
	 * 保存商品尺码实例
	 * @param size 商品尺码实例
	 */
	void save(GoodsSize goodsSize);
	
	/**
	 * 获取商品当前颜色的尺码
	 * @param goodsColorId  颜色编号
	 * @return
	 */
	List<GoodsSize> getGoodsSize(String goodsColorId);

}
