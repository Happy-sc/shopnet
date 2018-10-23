package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Brand;

public interface BrandDao {
	/**
	 * 根据标识属性获取Brand实体
	 * @param brandId
	 * @return
	 */
	Brand get(String brandId);
	
	/**
	 * 保存Brand实体
	 * @param brand
	 */
	void save(Brand brand);
	
	/**
	 * 修改Brand实体
	 * @param brand
	 */
	void update(Brand brand);
	
	/**
	 * 删除Bran实体
	 * @param brand
	 */
	void delete(Brand brand);
	
	/**
	 * 根据主键删除Brand实体
	 * @param brandId 需要被删除的品牌编号
	 */
	void delete(String brandId);
	
	/**
	 * 获取全部的Brand实体
	 * @return 
	 */
	List<Brand> getAllBrand();

	/**
	 * 获取指定页面的全部Brand实例
	 * @param pageNo 页码
	 * @param pageSize 页面大小
	 * @return
	 */
	List<Brand> getAllBrand(int pageNo, int pageSize);

	/**
	 * 获取品牌的总量
	 * @return
	 */
	long getBrandCount();

	/**
	 * 根据品牌名称获取品牌实例
	 * @param brandName 品牌名称
	 * @return
	 */
	Brand getBrandByName(String brandName);

	/**
	 * 根据款式获取品牌
	 * @param styleId 款式编号
	 * @return
	 */
	List<Brand> getBrandByStyleId(String styleId);

	/**
	 * 获取指定数量的品牌
	 * @param count 数量
	 * @return
	 */
	List<Brand> getBrand(int count);

	/**
	 * 获取某个字母或者数字开头的品牌
	 * @param hql sql语句
	 * @return
	 */
	List<Brand> getBrandsBypytb(String hql);

	/**
	 * 取得最大编号的品牌
	 * @return
	 */
	Brand getMaxIdBrand();

	/**
	 * 根据品牌拼音获取 品牌实力
	 * @param brandS 品牌拼音
	 * @return
	 */
	Brand getBrandBySpell(String brandSpell);

	/**
	 * 保存或者修改品牌
	 * @param brand 品牌实例
	 */
	void saveOrUpdateBrand(Brand brand);
	
}
