package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.StyleDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Style;

@Repository("styleDao")
public class StyleDaoHibernate extends BaseHibernateDaoSupport implements
		StyleDao {
		
	/**
	 * 根据标识属性删除Style实例
	 * @param styleId 需要被删除的Style实例的标识属性值
	 */
	public void delete(String styleId) {
		getHibernateTemplate().delete(get(styleId));
	}

	/**
	 * 删除Style实例
	 * @param style 需要被删的Style实例
	 */
	public void delete(Style style) {
		getHibernateTemplate().clear();
		getHibernateTemplate().delete(style);
	}

	/**
	 * 获取全部的Style实例
	 * @return 获取数据库中全部的Style实例
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getAllStyle() {
		return (List<Style>)getHibernateTemplate().find("from Style");
	}

	/**
	 * 根据标识属性获取Style实例
	 * @param styleId 需要获取的Style实例的标识属性值
	 * @return 指定标识属性值的Style实例
	 */
	public Style get(String styleId) {
		return getHibernateTemplate().get(Style.class, styleId);
	}

	/**
	 * 根据品牌获取Style实例
	 * @param brandId 品牌编号
	 * @return 指定品牌的所有Style实例
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getStyleByBrand(String brandId) {
		return (List<Style>)getHibernateTemplate().find("from Style as s where s.brands.brandId=?",brandId);
	}
	
	/**
	 * 根据分类获取Style实例
	 * @param categoryId 分类编号
	 * @return 指定分类的所有Style实例
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getStyleByCategory(String categoryId) {
		return (List<Style>)getHibernateTemplate().find("from Style as s where s.category.categoryId=?",categoryId);
	}

	/**
	 * 获取所有款式
	 * @param pageNo 当前页面
	 * @param pageSize 页面大小
	 * @return 当前页面的的所有款式
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getAllStyle(int pageNo, int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Style>)findByPage("from Style", offset, pageSize);
	}

	/**
	 * 获取所有款式的总量
	 * @return 款式的总量
	 */
	public long getCountStyle() {
		return (Long) getHibernateTemplate().find("select count(*) from Style").get(0);
	}

	/**
	 * 根据款式名称获取该款式实例
	 * @param styleName 款式名称
	 * @return 指定款式名称的款式实例
	 */
	@SuppressWarnings("unchecked")
	public Style getStyleByName(String styleName) {
		List<Style> styles = getHibernateTemplate().find("from Style as s where s.styleName=?",styleName);
		if(styles!=null&&styles.size()==1){
			return styles.get(0);
		}
		return null;
	}

	/**
	 * 获取最后一个编号的款式
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Style getEndStyle() {
		List<Style> styles = getHibernateTemplate().find("From Style as s order by s.styleId desc");
		if(styles!=null&&styles.size()>0)
			return styles.get(0);
		return null;
	}

	/**
	 * 获取款式的总量
	 */
	public long getStyleCount() {
		return (Long) getHibernateTemplate().find("select count(*) from Style").get(0);
	}

	@Override
	public void saveOrUpdateStyle(Style style) {
		getHibernateTemplate().saveOrUpdate(style);
	}

}
