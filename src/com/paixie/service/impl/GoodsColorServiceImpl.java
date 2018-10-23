package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.GoodsColorDao;
import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.service.GoodsColorService;

@Service("goodsColorService")
public class GoodsColorServiceImpl implements GoodsColorService{
	@Resource(name="goodsColorDao")private GoodsColorDao goodsColorDao;
	/**
	 * ������Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫʵ��
	 */
	public void save(GoodsColor goodsColor) {
		goodsColorDao.save(goodsColor);
	}
	
	/**
	 * ������Ʒ��Ż�ȡ����Ʒ����ɫ
	 * @param goodsId ��Ʒ���
	 * @return
	 */
	public List<GoodsColor> getGoodsColorByGoodsId(String goodsId) {
		List<GoodsColor> goodsColors = goodsColorDao.getGoodsColor(goodsId);
		return goodsColors;
	}

	/**
	 * ������Ʒ��ɫ��ȡ��Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	public GoodsColor getGoodsColorByColor(String goodsColor) {
		GoodsColor goodsColor2 = goodsColorDao.getGoodsColorByColor(goodsColor);
		return goodsColor2;
	}

	/**
	 * ������Ʒ��ɫ����Ʒ������Ϣ�ж����õ�ǰ��ɫ
	 * ���color!=null,���ʾ�Ǵ���Ʒ��ϸҳ�����ӹ���,����colorId��ȡ
	 * ������Ҫ����goodsImage��ȡ
	 * @param goods
	 * @param goodsColor
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
