package com.paixie.service;

import java.util.List;
import java.util.Set;

import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.OrderDetail;

public interface GoodsService {

	/**
	 * ������Ʒ��Ż�ȡ��Ʒʵ��
	 * @param goodsId ��Ʒ���
	 */
	GoodsListing getGoodsById(String goodsId);

	/**
	 * ���ݷ����ȡi����Ʒ
	 * @param category ��Ʒ����
	 * @param i ��ȡ��Ʒ������
	 */
	List<GoodsListing> getGoodsByCategoryOrder(String category, int i);

	/**
	 * �����ض������ȡ��Ʒ
	 * @param string �ض�����
	 * @param order ��������
	 */
	List<GoodsListing> getGoodsOrderString(String string, String order);

	/**
	 * ��ȡ�Ƽ���Ʒ
	 * @param number �Ƽ�����
	 * @return ָ���������Ƽ���Ʒ
	 */
	List<GoodsListing> getGoodsByRecommend(int number);

	/**
	 * ������Ʒ�ִ�����ȡ��Ʒ��Ϣ
	 * @return
	 */
	List<GoodsListing> getgoodsByGoodsExitNumber();

	/**
	 * ��ȡ�÷�����Ƽ���Ʒ�����ϼ�ʱ��Ϊ��׼��ȡǰ5��
	 * @param categoryId ������
	 * @return ǰ5���Ƽ���Ʒ��Ϣ
	 */
	List<GoodsListing> getRecommandGoodsByCategory(String categoryId);

	/**
	 * ��ȡ�������Ʒ��������
	 * @param categoryId ��Ʒ������
	 * @return �÷�����Ʒ��������
	 */
	List<GoodsListing> getGoodsSumByCategory(String categoryId);
	
	/**
	 * ��ȡĳ���������Ʒ��Ϣ�������з�ҳ����
	 * @param category ��Ʒ������
	 * @param pageSize ÿҳ��ʾ��Ʒ������
	 * @param page ҳ��
	 * @return ָ����Ʒ�����ĳҳ��pageSize����Ʒ��Ϣ
	 */
	List<GoodsListing> getGoodsByCategoryPage(String categoryId,
			String styleId, String brandId, String size, String sex,
			String price, int i, int page);

	/**
	 * ��ȡͬ��������Ʒ
	 * @return styleId ��ʽ���
	 * @return ָ����ʽ��Ʒ
	 */
	List<GoodsListing> getMostSaleByStyle(String styleId);


	/**
	 * ������Ʒ��Ϣ
	 * @param goods  ��Ʒ������Ϣ
	 * @param goodsColor ��Ʒ��ɫ
	 */
	void saveGoods(GoodsListing goods, Set<GoodsColor> goodsColor);
	
	/**
	 * ��ȡ����Ʒ����
	 * @param goodsColors ��Ʒ��ɫ�������������Ʒ������
	 */
	public int getGoodsSum(Set<GoodsColor> goodsColors);

	/**
	 * ��ȡָ����Ŀ�Ƽ���Ʒ
	 * @param i ��Ŀ
	 * @return
	 */
	List<GoodsListing> getRecommandGoods(int i);

	/**
	 * ���ݶ����޸���Ʒ������Ϣ��������
	 * @param orderDetails ��������
	 */
	void updateGoodsByOrder(List<OrderDetail> orderDetails);

}
