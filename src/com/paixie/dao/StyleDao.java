package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Style;

public interface StyleDao {
	
	/**
	 * 根据标识属性获取Style实例
	 * @param styleId 款式编号
	 * @return
	 */
	Style get(String styleId);
	
	/**
	 * 增加或者修改款式
	 * @param style
	 */
	void saveOrUpdateStyle(Style style);
	
	/**
	 * 根据标识属性删除Style实例
	 * @param styleId 需要被删除的款式编号
	 */
	void delete(String styleId);
	
	/**
	 * 删除Style实例
	 * @param style 需要被删除的款式实例
	 */
	void delete(Style style);
	
	/**
	 * 获取全部的Style实例
	 * @return 全部的款式实例
	 */
	List<Style> getAllStyle();
	
	/**
	 * 根据分类获取Style实例
	 * @param categoryId 分类编号
	 * @return
	 */
	List<Style> getStyleByCategory(String categoryId);
	
	/**
	 * 根据品牌获取Style实例
	 * @param brandId 品牌编号
	 * @return
	 */
	List<Style> getStyleByBrand(String brandId);

	/**
	 * 获取当前页面的所有Style实例
	 * @param pageNo 页码
	 * @param pageSize 个数
	 * @return
	 */
	List<Style> getAllStyle(int pageNo, int pageSize);

	/**
	 * 获取所有款式的数量
	 * @return
	 */
	long getCountStyle();

	/**
	 * 根据款式名称获取该款式
	 * @param styleName 款式名称
	 * @return
	 */
	Style getStyleByName(String styleName);

	/**
	 * 获取最后一个编号的款式
	 * @return
	 */
	Style getEndStyle();

	/**
	 * 获取款式的总量
	 * @return
	 */
	long getStyleCount();


}
