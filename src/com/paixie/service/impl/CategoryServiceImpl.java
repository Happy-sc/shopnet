package com.paixie.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.CategoryDao;
import com.paixie.domain.Category;
import com.paixie.domain.Style;
import com.paixie.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Resource(name="categoryDao")private CategoryDao categoryDao;
	/**
	 * ���ݷ����ţ�ɾ������ʵ��
	 * @param categoryId ������
	 * @return
	 */
	public void delete(String categoryId) {
		categoryDao.delete(categoryId);
	}

	/**
	 * ��ȡ���еķ���ʵ��
	 * @return ���еķ���ʵ��
	 */
	public List<Category> getAllCategory() {
		List<Category> categories = categoryDao.getAllCategory();
		//�������Ŀ�ʽ����ʽ:111,111,111
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
	 * ���ݷ����Ż�ȡ����ʵ��
	 * @param categoryId ������
	 * @return ָ����ŵķ���ʵ��
	 */
	public Category getCategoryById(String categoryId) {
		return categoryDao.get(categoryId);
	}

	/**
	 * ��ȡ����ı��
	 * ��ȡ�������£�
	 * ��ȡ��ŵ����ֵ+1
	 * ������ֵΪ��������Ϊ200001
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
	 * ����Ʒ�����ƻ�ȡ��Ӧ��Ʒ��
	 * @param categoryName  Ʒ������
	 * @return
	 */
	public Category getCategoryByName(String categoryName) {
		return categoryDao.getCategoryByName(categoryName);
	}

	/**
	 * ��������޸���Ʒ����
	 * @param category ��Ҫ�����桢�޸ĵķ���ʵ��
	 * @return 
	 */
	public void saveOrUpdateCategory(Category category) {
		categoryDao.saveOrUpdateCategory(category);
	}

}

