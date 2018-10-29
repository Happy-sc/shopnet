package com.paixie.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.StyleDao;
import com.paixie.domain.Brand;
import com.paixie.domain.Category;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.CategoryService;
import com.paixie.service.StyleService;

@Service("styleService")
public class StyleServiceImpl implements StyleService {
	@Resource(name="styleDao")private StyleDao styleDao;
	@Resource(name="")private CategoryService categoryService;
	@Resource(name="")private BrandService brandService;
	/**
	 * ��ȡ��ʽ�ı��
	 * �����ʽΪ�գ���Ϊ300001
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
	 * ���ݿ�ʽ���ƻ�ȡ��ʽʵ��
	 * @param styleName ��ʽ����
	 * @return
	 */
	public Style getStyleByName(String styleName) {
		Style style = styleDao.getStyleByName(styleName);
		return style;
	}

	/**
	 * ���ӿ�ʽ
	 * @param style   ��ʽ
	 * @param categoryId  ��ʽ������
	 * @param brandId   ��ʽƷ�Ʊ��
	 */
	public void saveOrUpdateStyle(Style style, String categoryId, String brandId) {
		//��ȡ����
		Category category = categoryService.getCategoryById(categoryId);
		style.setCategory(category);
		Brand brand = brandService.getBrandByName(brandId);
		style.setBrand(brand);
		styleDao.saveOrUpdateStyle(style);
	}

	/**
	 * ��ȡָ��ҳ��Ŀ�ʽ
	 * @param page ҳ��
	 * @return
	 */
	public List<Style> getStyleByPage(int page,int pageSize) {
		//��ȡָ��ҳ��Ŀ�ʽ
		List<Style> styles = styleDao.getAllStyle(page, pageSize);
		return styles;
	}

	/**
	 * ɾ����ʽ
	 * @param styleId ��ʽ���
	 */
	public void deleteStyle(String styleId) {
		styleDao.delete(styleId);
	}

	/**
	 * ��ȡ��ʽ������
	 */
	public long getStyleCount() {
		return styleDao.getStyleCount();
	}

	/**
	 * ��ȡ���п�ʽʵ��
	 */
	public List<Style> getAllStyle() {
		return styleDao.getAllStyle();
	}

	/**
	 * ������Ʒ�����Ż�ȡ��Ʒ��ʽ
	 * @param categoryId ������
	 * @return �÷����ŵ����п�ʽ
	 */
	public List<Style> getStyleByCategoryId(String categoryId) {
		return styleDao.getStyleByCategory(categoryId);
	}

	/**
	 * ���ݿ�ʽ��Ż�ȡ��ʽʵ��
	 * @param styleId ��ʽ���
	 * @return
	 */
	public Style getStyleById(String styleId) {
		return styleDao.get(styleId);
	}

}
