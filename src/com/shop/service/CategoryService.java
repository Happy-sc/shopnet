package com.shop.service;

import java.util.List;

import com.shop.domain.Category;

public interface CategoryService {

	/**
	 * 获取所有的商品分类
	 * @return
	 */
	List<Category> getAllCategory();

	/**
	 * 根据分类编号获取分类实例
	 * @param categoryId
	 * @return
	 */
	Category getCategoryById(String categoryId);

	/**
	 * 删除商品分类
	 * @param categoryId
	 */
	void delete(String categoryId);

	/**
	 * 获取分类的编号
	 * @return
	 */
	String getCategoryId();

	/**
	 * 根据品牌名称获取相应的品牌
	 * @param categoryName  品牌名称
	 * @return
	 */
	Category getCategoryByName(String categoryName);

	/**
	 * 增加或者修改商品分类
	 * @param category
	 */
	void saveOrUpdateCategory(Category category);

}
