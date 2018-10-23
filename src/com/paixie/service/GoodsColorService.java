package com.paixie.service;

import java.util.List;

import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;

public interface GoodsColorService {

	/**
	 * ������Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫʵ��
	 */
	void save(GoodsColor goodsColor);

	/**
	 * ������Ʒ��Ż�ȡ����Ʒ����ɫ
	 * @param goodsId ��Ʒ���
	 * @return
	 */
	List<GoodsColor> getGoodsColorByGoodsId(String goodsId);

	/**
	 * ������Ʒ��ɫ��ȡ��Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	GoodsColor getGoodsColorByColor(String goodsColor);

	/**
	 * ������Ʒ��ɫ����Ʒ������Ϣ�ж����õ�ǰ��ɫ
	 * ���goods==null,��ǰ��ɫΪgoodsColor ���Ը���Color��ȡ��ɫʵ��
	 * ������� goods��ȡ��ɫʵ��
	 * @param goods ��Ʒʵ��
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	GoodsColor getGoodsColorByColor(GoodsListing goods, String color);

}
