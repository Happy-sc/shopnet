package com.paixie.service;

import java.util.List;

import com.paixie.domain.GoodsSize;

public interface GoodsSizeService {

	/**
	 * ������Ʒ����ʵ��
	 * @param size ��Ʒ����ʵ��
	 */
	void save(GoodsSize goodsSize);
	
	/**
	 * ��ȡ��Ʒ��ǰ��ɫ�ĳ���
	 * @param goodsColorId  ��ɫ���
	 * @return
	 */
	List<GoodsSize> getGoodsSize(String goodsColorId);

}
