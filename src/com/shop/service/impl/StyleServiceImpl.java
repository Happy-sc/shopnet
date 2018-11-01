package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.StyleDao;
import com.shop.domain.Brand;
import com.shop.domain.Category;
import com.shop.domain.Style;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.StyleService;

@Service("styleService")
public class StyleServiceImpl implements StyleService {
	@Resource(name="styleDao")private StyleDao styleDao;
	@Resource(name="")private CategoryService categoryService;
	@Resource(name="")private BrandService brandService;
	/**
	 * 获取款式的编号
	 * 如果款式为空，则为300001
	 *styleId = maxStyleId +1
	 *
	 */
	@Override
	public String getStyleId() {
		String maxId ;
		Style style = styleDao.getEndStyle();
		if(style==null)
			maxId = "300001";
		else 
			maxId = String.valueOf(Integer.valueOf(style.getStyleId())+1);
		return maxId;
	}

	/**
	 * 根据款式名称获取款式实例
	 * @param styleName 款式名称
	 * @return
	 */
	public Style getStyleByName(String styleName) {
		Style style = styleDao.getStyleByName(styleName);
		return style;
	}

	/**
	 * 增加款式
	 * @param style   款式
	 * @param categoryId  款式分类编号
	 * @param brandId   款式品牌标号
	 */
	public void saveOrUpdateStyle(Style style, String categoryId, String brandId) {
		//获取分类
		Category category = categoryService.getCategoryById(categoryId);
		style.setCategory(category);
		Brand brand = brandService.getBrandByName(brandId);
		style.setBrand(brand);
		styleDao.saveOrUpdateStyle(style);
	}

	/**
	 * 获取指定页面的款式
	 * @param page 页面
	 * @return
	 */
	public List<Style> getStyleByPage(int page,int pageSize) {
		//获取指定页面的款式
		List<Style> styles = styleDao.getAllStyle(page, pageSize);
		return styles;
	}

	/**
	 * 删除款式
	 * @param styleId 款式编号
	 */
	public void deleteStyle(String styleId) {
		styleDao.delete(styleId);
	}

	/**
	 * 获取款式的总量
	 */
	public long getStyleCount() {
		return styleDao.getStyleCount();
	}

	/**
	 * 获取所有款式实例
	 */
	public List<Style> getAllStyle() {
		return styleDao.getAllStyle();
	}

	/**
	 * 根据商品分类编号获取商品款式
	 * @param categoryId 分类编号
	 * @return 该分类编号的所有款式
	 */
	public List<Style> getStyleByCategoryId(String categoryId) {
		return styleDao.getStyleByCategory(categoryId);
	}

	/**
	 * 根据款式编号获取款式实例
	 * @param styleId 款式编号
	 * @return
	 */
	public Style getStyleById(String styleId) {
		return styleDao.get(styleId);
	}

}
