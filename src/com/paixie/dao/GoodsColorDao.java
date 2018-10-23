package com.paixie.dao;

import java.util.List;

import com.paixie.domain.GoodsColor;

public interface GoodsColorDao {

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
	List<GoodsColor> getGoodsColor(String goodsId);

	/**
	 * ������Ʒ��ɫ��ȡ��Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	GoodsColor getGoodsColorByColor(String goodsColor);

	/**
	 * ������ɫ��Ż�ȡָ����ɫʵ��
	 * @param color  ��ʾ���
	 * @return
	 */
	GoodsColor getGoodsColorByColorId(String colorId);

	/**
	 * ������ɫ���ƻ�ȡ��ɫʵ��
	 * @param goodsColor ��ɫ����
	 * @return
	 */
	GoodsColor getGoodsColorByColorName(String goodsColor);

	/**
	 * ������Ʒ��ź���ɫ��ȡָ������Ʒ��ɫʵ��
	 * @param goodsId ��Ʒ���
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	GoodsColor getGoodsColorByIdAndColor(String goodsId, String goodsColor);

}
