package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.CategoryDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Category;

@Repository("categoryDao")
public class CategoryDaoHibernate extends BaseHibernateDaoSupport implements CategoryDao{

	/**
	 * 根据标识属性删除Category实体
	 * @param categoryId 需要删除的Category实体的标识属性值
	 */
	public void delete(String categoryId) {
		getHibernateTemplate().delete(get(categoryId));
	}

	/**
	 * 删除Category实体
	 * @param
	 */
	public void delte(Category category) {
		getHibernateTemplate().delete(category);
	}

	/**
	 * 根据标识属性获取Category实体
	 * @param categoryId 需要获取Category实体的标识属性值
	 * @return 指定标识属性值的Category实体
	 */
	public Category get(String categoryId) {
		return getHibernateTemplate().get(Category.class, categoryId);
	}

	/**
	 * 获取全部的Category实体
	 * @return 数据库中存在的全部的Category实体
	 */
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		return (List<Category>)getHibernateTemplate().find("From Category");
	}

	/**
	 * 保存Category实体
	 * @param category 需要被保存的Category实体
	 */
	public void saveOrUpdateCategory(Category category) {
		getHibernateTemplate().saveOrUpdate(category);
	}


	/**
	 * 获取最大编号的category实体
	 */
	@SuppressWarnings("unchecked")
	public Category getEndCategory() {
		String hql = "From Category as c order by c.categoryId desc";
		List<Category> categories = (List<Category>) getHibernateTemplate().find(hql);
		if(categories!=null&&categories.size()>0)
			return categories.get(0);
		else
			return null;
	}

	/**
	 * 根据品牌名称获取相应的品牌
	 * @param categoryName  品牌名称
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Category getCategoryByName(String categoryName) {
		List<Category> categories = getHibernateTemplate().find("From Category as c where c.categoryName=?",categoryName);
		if(categories!=null&&categories.size()>0)
			return categories.get(0);
		return null;
	}

}
