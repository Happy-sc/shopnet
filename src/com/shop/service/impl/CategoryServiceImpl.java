package com.shop.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.CategoryDao;
import com.shop.domain.Category;
import com.shop.domain.Style;
import com.shop.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource(name="categoryDao")private CategoryDao categoryDao;
	/**
	 * 根据分类编号，删除分类实例
	 * @param categoryId 分类编号
	 * @return
	 */
	public void delete(String categoryId) {
		categoryDao.delete(categoryId);
	}

	/**
	 * 获取所有的分类实例
	 * @return 所有的分类实例
	 */
	public List<Category> getAllCategory() {
		List<Category> categories = categoryDao.getAllCategory();
		//处理分类的款式，格式:111,111,111
		for(int i = 0;i < categories.size();i++){
			Set<Style> styles = categories.get(i).getStyles();
			if(styles.size()>0){
				Iterator<Style> iterable = styles.iterator();
				StringBuffer styBuffer = new StringBuffer();
				while (iterable.hasNext()) {
					styBuffer.append(iterable.next().getStyleName()+",");
				}
				categories.get(i).setStyleString(styBuffer.substring(0, styBuffer.length()-1));
			}
		}
		
		return categories;
	}

	/**
	 * 根据分类编号获取分类实例
	 * @param categoryId 分类编号
	 * @return 指定编号的分类实例
	 */
	public Category getCategoryById(String categoryId) {
		return categoryDao.get(categoryId);
	}

	/**
	 * 获取分类的编号
	 * 获取规则如下：
	 * 获取编号的最大值+1
	 * 如果最大值为空则设置为200001
	 * 
	 */
	public String getCategoryId() {
		Category category = categoryDao.getEndCategory();
		if(category==null)
			return "200001";
		else {
			String maxId = String.valueOf(Integer.valueOf(category.getCategoryId())+1);
			return maxId;
		}
	}

	/**
	 * 根据品牌名称获取相应的品牌
	 * @param categoryName  品牌名称
	 * @return
	 */
	public Category getCategoryByName(String categoryName) {
		return categoryDao.getCategoryByName(categoryName);
	}

	/**
	 * 保存或者修改商品分类
	 * @param category 需要被保存、修改的分类实例
	 * @return 
	 */
	public void saveOrUpdateCategory(Category category) {
		categoryDao.saveOrUpdateCategory(category);
	}

}

