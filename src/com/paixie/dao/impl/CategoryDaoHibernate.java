package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.CategoryDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Category;

@Repository("categoryDao")
public class CategoryDaoHibernate extends BaseHibernateDaoSupport implements CategoryDao{

	/**
	 * ���ݱ�ʶ����ɾ��Categoryʵ��
	 * @param categoryId ��Ҫɾ����Categoryʵ��ı�ʶ����ֵ
	 */
	public void delete(String categoryId) {
		getHibernateTemplate().delete(get(categoryId));
	}

	/**
	 * ɾ��Categoryʵ��
	 * @param
	 */
	public void delte(Category category) {
		getHibernateTemplate().delete(category);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡCategoryʵ��
	 * @param categoryId ��Ҫ��ȡCategoryʵ��ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Categoryʵ��
	 */
	public Category get(String categoryId) {
		return getHibernateTemplate().get(Category.class, categoryId);
	}

	/**
	 * ��ȡȫ����Categoryʵ��
	 * @return ���ݿ��д��ڵ�ȫ����Categoryʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() {
		return (List<Category>)getHibernateTemplate().find("From Category");
	}

	/**
	 * ����Categoryʵ��
	 * @param category ��Ҫ�������Categoryʵ��
	 */
	public void saveOrUpdateCategory(Category category) {
		getHibernateTemplate().saveOrUpdate(category);
	}


	/**
	 * ��ȡ����ŵ�categoryʵ��
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
	 * ����Ʒ�����ƻ�ȡ��Ӧ��Ʒ��
	 * @param categoryName  Ʒ������
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
