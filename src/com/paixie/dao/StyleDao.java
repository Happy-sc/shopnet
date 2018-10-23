package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Style;

public interface StyleDao {
	
	/**
	 * ���ݱ�ʶ���Ի�ȡStyleʵ��
	 * @param styleId ��ʽ���
	 * @return
	 */
	Style get(String styleId);
	
	/**
	 * ���ӻ����޸Ŀ�ʽ
	 * @param style
	 */
	void saveOrUpdateStyle(Style style);
	
	/**
	 * ���ݱ�ʶ����ɾ��Styleʵ��
	 * @param styleId ��Ҫ��ɾ���Ŀ�ʽ���
	 */
	void delete(String styleId);
	
	/**
	 * ɾ��Styleʵ��
	 * @param style ��Ҫ��ɾ���Ŀ�ʽʵ��
	 */
	void delete(Style style);
	
	/**
	 * ��ȡȫ����Styleʵ��
	 * @return ȫ���Ŀ�ʽʵ��
	 */
	List<Style> getAllStyle();
	
	/**
	 * ���ݷ����ȡStyleʵ��
	 * @param categoryId ������
	 * @return
	 */
	List<Style> getStyleByCategory(String categoryId);
	
	/**
	 * ����Ʒ�ƻ�ȡStyleʵ��
	 * @param brandId Ʒ�Ʊ��
	 * @return
	 */
	List<Style> getStyleByBrand(String brandId);

	/**
	 * ��ȡ��ǰҳ�������Styleʵ��
	 * @param pageNo ҳ��
	 * @param pageSize ����
	 * @return
	 */
	List<Style> getAllStyle(int pageNo, int pageSize);

	/**
	 * ��ȡ���п�ʽ������
	 * @return
	 */
	long getCountStyle();

	/**
	 * ���ݿ�ʽ���ƻ�ȡ�ÿ�ʽ
	 * @param styleName ��ʽ����
	 * @return
	 */
	Style getStyleByName(String styleName);

	/**
	 * ��ȡ���һ����ŵĿ�ʽ
	 * @return
	 */
	Style getEndStyle();

	/**
	 * ��ȡ��ʽ������
	 * @return
	 */
	long getStyleCount();


}
