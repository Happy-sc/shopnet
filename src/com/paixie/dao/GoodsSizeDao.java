package com.paixie.dao;

import java.util.List;

import com.paixie.domain.GoodsSize;

public interface GoodsSizeDao {

	/**
	 * ������Ʒ����ʵ��
	 * @param goodsSize
	 */
	void save(GoodsSize goodsSize);

	/**
	 * ��ȡָ����Ʒ��ɫ�ĳ���
	 * @param goodsColorId ��Ʒ��ɫ���
	 * @return
	 */
	List<GoodsSize> getGoodsSizeByColor(String goodsColorId);

	/**
	 * ������Ʒ��ɫ�������ȡ����ʵ��
	 * @param goodsColorId ��Ʒ��ɫ���
	 * @param goodsSize ����
	 * @return
	 */
	GoodsSize getGoodsSizeByColorAndSize(String goodsColorId, Integer goodsSize);

	/**
	 * �޸ĳ���ʵ��
	 * @param goodsSize ��Ҫ���޸ĵĳ���ʵ��
	 */
	void update(GoodsSize goodsSize);

}
