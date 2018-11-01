package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.GoodsSizeDao;
import com.shop.domain.GoodsSize;
import com.shop.service.GoodsSizeService;

@Service("goodsSizeService")
public class GoodsSizeServiceImpl implements GoodsSizeService {

	@Resource(name="goodsSizeDao")
	private GoodsSizeDao goodsSizeDao;
	/**
	 * 保存商品尺码实例
	 * @param goodsSize 商品尺码实例
	 */
	public void save(GoodsSize goodsSize) {
		goodsSizeDao.save(goodsSize);
	}
	
	@Override
	public List<GoodsSize> getGoodsSize(String goodsColorId) {
		return goodsSizeDao.getGoodsSizeByColor(goodsColorId);
	}

}
