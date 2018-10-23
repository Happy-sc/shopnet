package com.paixie.service;

import java.util.List;

import com.paixie.domain.Brand;
import com.paixie.domain.Style;

/**
 * @Description: 品牌的业务层接口
 */
public interface BrandService {

	/**
	 * 根据品牌名称获取品牌
	 * @param brandName 品牌名称
	 * @return
	 */
	Brand getBrandByName(String brandName);

	/**
	 * 获取所有的品牌
	 * @return
	 */
	List<Brand> getAllBrands();

	/**
	 * 获取指定页码的款式
	 * @param pageNo 页码
	 * @param pageSize 页码大小
	 * @return
	 */
	List<Brand> getBrandByPage(int pageNo, int pageSize);

	/**
	 * 获取品牌的总量
	 * @return
	 */
	long getBrandCount();

	/**
	 * 取得品牌的编号
	 * @return
	 */
	String getBrandId();

	/**
	 * 根据品牌拼音获取 品牌实力
	 * @param brandSpell 品牌拼音
	 * @return
	 */
	Brand getBrandBySpell(String brandSpell);

	/**
	 * 根据品牌编号获取品牌实例
	 * @param brandId 品牌编号
	 * @return
	 */
	Brand getBrandById(String brandId);

	/**
	 * 保存或者修改品牌
	 * @param brand  品牌
	 * @param style 款式
	 * 款式需要做一些处理
	 */
	void saveOrUpdateBrand(Brand brand, String style);

	/**
	 * 根据编号删除品牌实例
	 * @param brandId
	 */
	void deleteBrand(String brandId);
	

	/**
	 * 获取某个字母开头品牌
	 * @param string 字母
	 */
	List<Brand> getBrandBypytb(String string);

	/**
	 * 根据分类来获取品牌
	 * @param categoryId 分类编号
	 */
	List<Brand> getBrandByCategory(String categoryId);
	
	/**
	 * 根据款式获取品牌
	 * @param styleId 款式编号
	 */
	List<Brand> getBrandByStyleId(String styleId);
	
	/**
	 * 获取某些款式的品牌
	 */
	List<Brand> getBrandByStyle(List<Style> styles);

	/**
	 * 获取指定数量的品牌
	 * @param count 指定数量
	 */
	List<Brand> getBrand(int count);
}
