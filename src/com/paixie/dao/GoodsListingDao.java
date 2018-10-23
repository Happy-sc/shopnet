package com.paixie.dao;

import java.util.List;

import com.paixie.domain.GoodsListing;

public interface GoodsListingDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡGoodsListingʵ��
	 * @param goodsId
	 * @return
	 */
	GoodsListing get(String goodsId);
	
	/**
	 * ����GoodsListingʵ��
	 * @param goodsListing
	 */
	void save(GoodsListing goodsListing);
	
	/**
	 * ���ݱ�ʶ����ɾ��GoodsLIstingʵ��
	 * @param goodsId
	 */
	void delete(String goodsId);
	
	/**
	 * ɾ��GoodsListingʵ��
	 * @param goodsListing
	 */
	void delete(GoodsListing goodsListing);
	
	/**
	 * �޸�GoodsListingʵ��
	 * @param goodsListing
	 */
	void update(GoodsListing goodsListing);
	
	/**
	 * ���ݿ�ʽ��ȡGoodsListingʵ��
	 * @param typeId
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	List<GoodsListing> getGoodsByType(String typeId,int pageSize,int pageNo);
	
	/**
	 * ����Ʒ�ƻ�ȡGoodsListtingʵ��
	 * @param brandId
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	List<GoodsListing> getGoodsByBrand(String brandId,int pageSize,int pageNo);
	
	/**
	 * ��ȡָ����Ʒ����ĵ�ָ����������Ʒ
	 * @param category
	 * @param count
	 * @return
	 */
	List<GoodsListing> getGoodsByCategory(String category, int count);

	/**
	 * �����ض�������ȡ��Ʒ����Ҳorder����
	 * @param string
	 * @param order
	 * @return
	 */
	List<GoodsListing> getGoodsOrderString(String string, String order);

	/**
	 * ��ȡ�Ƽ���Ʒ
	 * @param number
	 * @return
	 */
	List<GoodsListing> getGoodsByRecommend(int number);

	/**
	 * ������Ʒ�ִ�����ȡ��Ʒ��Ϣ
	 * @return
	 */
	List<GoodsListing> getGoodsByGoodsExitNumber();

	/**
	 * ������Ʒ�����ȡ�Ƽ���Ʒ
	 * @param categoryId
	 * @return
	 */
	List<GoodsListing> getRecommandGoodsByCategoryId(String categoryId);

	/**
	 * ��ȡ�������Ʒ��������
	 * @param categoryId
	 * @return
	 */
	List<GoodsListing> getGoodsSumByCategory(String categoryId);

	/**
	 * ����HQL����ȡ��Ӧ����Ʒ��Ϣ�������з�ҳ����
	 * @param hQL
	 * @param i
	 * @param page
	 * @return
	 */
	List<GoodsListing> getGoodsByOption(String hQL, int i, int page);

	/**
	 * 
	 * @param styleId
	 * @return
	 */
	List<GoodsListing> getMostSaleByStyle(String styleId);

	/**
	 * ��ȡָ����Ŀ�Ƽ���Ʒ
	 * @param i ��Ŀ
	 * @return
	 */
	List<GoodsListing> getRecommand(int i);
}
