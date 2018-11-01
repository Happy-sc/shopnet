package com.shop.service;

import java.util.List;

import com.shop.domain.Style;

/**
 * @Description: 款式管理的业务层接口
 */
public interface StyleService {

	/**
	 * 获取款式的编号
	 * @return
	 */
	String getStyleId();

	/**
	 * 根据款式名称获取款式实例
	 * @param styleName 款式名称
	 * @return
	 */
	Style getStyleByName(String styleName);

	/**
	 * 增加款式
	 * @param style   款式
	 * @param categoryId  款式分类编号
	 * @param brandName   款式品牌
	 */
	void saveOrUpdateStyle(Style style, String categoryId, String brandName);

	/**
	 * 获取指定页面的款式
	 * @param page 页面
	 * @param pageSize 页面大小
	 * @return
	 */
	List<Style> getStyleByPage(int page,int pageSize);

	/**
	 * 删除款式
	 * @param styleId 款式编号
	 */
	void deleteStyle(String styleId);

	/**
	 * 获取款式的总数
	 * @return
	 */
	long getStyleCount();

	/**
	 * 获取所有款式
	 * @return
	 */
	List<Style> getAllStyle();
	
	/**
	 * 根据商品分类获取商品款式
	 * @param categoryId 分类编号
	 */
	List<Style> getStyleByCategoryId(String categoryId);

	/**
	 * 根据款式编号获取款式实例
	 * @param styleId 款式编号
	 * @return
	 */
	Style getStyleById(String styleId);
}
