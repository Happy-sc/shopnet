package com.paixie.service;

import java.util.List;

import com.paixie.domain.Category;

public interface CategoryService {

	/**
	 * ��ȡ���е���Ʒ����
	 * @return
	 */
	List<Category> getAllCategory();

	/**
	 * ���ݷ����Ż�ȡ����ʵ��
	 * @param categoryId
	 * @return
	 */
	Category getCategoryById(String categoryId);

	/**
	 * ɾ����Ʒ����
	 * @param categoryId
	 */
	void delete(String categoryId);

	/**
	 * ��ȡ����ı��
	 * @return
	 */
	String getCategoryId();

	/**
	 * ����Ʒ�����ƻ�ȡ��Ӧ��Ʒ��
	 * @param categoryName  Ʒ������
	 * @return
	 */
	Category getCategoryByName(String categoryName);

	/**
	 * ���ӻ����޸���Ʒ����
	 * @param category
	 */
	void saveOrUpdateCategory(Category category);

}
