package com.shop.dao;

import java.util.List;

import com.shop.domain.Category;

public interface CategoryDao {
	/**
	 * 根据标识属性获取Category实体
	 * @param categoryId 需要获取的分类实体编号
	 * @return
	 */
	Category get(String categoryId);
	
	/**
	 * 保存或者修改Category实体
	 * @param category 需要被保存的category实体
	 */
	void saveOrUpdateCategory(Category category);
	
	/**
	 * 根据标识属性删除Category实体
	 * @param categoryId 需要被删除的category实体编号
	 */
	void delete(String categoryId);
	
	/**
	 * 删除Category实体
	 * @param category 需要删除的category实体
	 */
	void delte(Category category);

	/**
	 * 获取全部的Category实体
	 * @return
	 */
	List<Category> getAllCategory();

	/**
	 * 获取分类的最大编号
	 * @return
	 */
	Category getEndCategory();

	/**
	 * 根据品牌名称获取相应的品牌
	 * @param categoryName  品牌名称
	 * @return
	 */
	Category getCategoryByName(String categoryName);
}
