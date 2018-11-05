package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.GoodsColorDao;
import com.shop.domain.GoodsColor;
import com.shop.domain.GoodsListing;
import com.shop.service.GoodsColorService;

@Service("goodsColorService")
public class GoodsColorServiceImpl implements GoodsColorService{

	@Resource(name="goodsColorDao")
	private GoodsColorDao goodsColorDao;
	/**
	 * 保存商品颜色实例
	 * @param goodsColor 商品颜色实例
	 */
	public void save(GoodsColor goodsColor) {
		goodsColorDao.save(goodsColor);
	}
	
	/**
	 * 根据商品编号获取该商品的颜色
	 * @param goodsId 商品编号
	 * @return
	 */
	public List<GoodsColor> getGoodsColorByGoodsId(String goodsId) {
		return goodsColorDao.getGoodsColor(goodsId);
	}

	/**
	 * 根据商品颜色获取商品颜色实例
	 * @param goodsColor 商品颜色
	 * @return
	 */
	public GoodsColor getGoodsColorByColor(String goodsColor) {
		return goodsColorDao.getGoodsColorByColor(goodsColor);
	}

	/**
	 * 根据商品颜色、商品基本信息判断设置当前颜色
	 * 如果color!=null,则表示是从商品详细页面链接过来,根据colorId获取
	 * 否则需要根据goodsImage获取
	 * @param goods
	 * @param color
	 * @return
	 */
	public GoodsColor getGoodsColorByColor(GoodsListing goods, String color) {
		GoodsColor goodsColor2 = null;
		if(color!=null&&!"".equals(color)){
			goodsColor2 = goodsColorDao.getGoodsColorByColorId(color);
		}
		else {
			goodsColor2 = goodsColorDao.getGoodsColorByColor(goods.getGoodsImage());
		}

		return goodsColor2;
	}



}
