package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.GoodsSizeDao;
import com.paixie.domain.GoodsSize;
import com.paixie.service.GoodsSizeService;

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
