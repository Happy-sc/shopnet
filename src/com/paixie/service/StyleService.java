package com.paixie.service;

import java.util.List;

import com.paixie.domain.Style;

/**
 * @Description: ��ʽ�����ҵ���ӿ�
 */
public interface StyleService {

	/**
	 * ��ȡ��ʽ�ı��
	 * @return
	 */
	String getStyleId();

	/**
	 * ���ݿ�ʽ���ƻ�ȡ��ʽʵ��
	 * @param styleName ��ʽ����
	 * @return
	 */
	Style getStyleByName(String styleName);

	/**
	 * ���ӿ�ʽ
	 * @param style   ��ʽ
	 * @param categoryId  ��ʽ������
	 * @param brandName   ��ʽƷ��
	 */
	void saveOrUpdateStyle(Style style, String categoryId, String brandName);

	/**
	 * ��ȡָ��ҳ��Ŀ�ʽ
	 * @param page ҳ��
	 * @param pageSize ҳ���С
	 * @return
	 */
	List<Style> getStyleByPage(int page,int pageSize);

	/**
	 * ɾ����ʽ
	 * @param styleId ��ʽ���
	 */
	void deleteStyle(String styleId);

	/**
	 * ��ȡ��ʽ������
	 * @return
	 */
	long getStyleCount();

	/**
	 * ��ȡ���п�ʽ
	 * @return
	 */
	List<Style> getAllStyle();
	
	/**
	 * ������Ʒ�����ȡ��Ʒ��ʽ
	 * @param categoryId ������
	 */
	List<Style> getStyleByCategoryId(String categoryId);

	/**
	 * ���ݿ�ʽ��Ż�ȡ��ʽʵ��
	 * @param styleId ��ʽ���
	 * @return
	 */
	Style getStyleById(String styleId);
}
