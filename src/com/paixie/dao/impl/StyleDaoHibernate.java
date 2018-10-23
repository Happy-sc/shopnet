package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.StyleDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Style;

@Repository("styleDao")
public class StyleDaoHibernate extends BaseHibernateDaoSupport implements
		StyleDao {
		
	/**
	 * ���ݱ�ʶ����ɾ��Styleʵ��
	 * @param styleId ��Ҫ��ɾ����Styleʵ���ı�ʶ����ֵ
	 */
	public void delete(String styleId) {
		getHibernateTemplate().delete(get(styleId));
	}

	/**
	 * ɾ��Styleʵ��
	 * @param style ��Ҫ��ɾ��Styleʵ��
	 */
	public void delete(Style style) {
		getHibernateTemplate().clear();
		getHibernateTemplate().delete(style);
	}

	/**
	 * ��ȡȫ����Styleʵ��
	 * @return ��ȡ���ݿ���ȫ����Styleʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getAllStyle() {
		return (List<Style>)getHibernateTemplate().find("from Style");
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡStyleʵ��
	 * @param styleId ��Ҫ��ȡ��Styleʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Styleʵ��
	 */
	public Style get(String styleId) {
		return getHibernateTemplate().get(Style.class, styleId);
	}

	/**
	 * ����Ʒ�ƻ�ȡStyleʵ��
	 * @param brandId Ʒ�Ʊ��
	 * @return ָ��Ʒ�Ƶ�����Styleʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getStyleByBrand(String brandId) {
		return (List<Style>)getHibernateTemplate().find("from Style as s where s.brands.brandId=?",brandId);
	}
	
	/**
	 * ���ݷ����ȡStyleʵ��
	 * @param categoryId ������
	 * @return ָ�����������Styleʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getStyleByCategory(String categoryId) {
		return (List<Style>)getHibernateTemplate().find("from Style as s where s.category.categoryId=?",categoryId);
	}

	/**
	 * ��ȡ���п�ʽ
	 * @param pageNo ��ǰҳ��
	 * @param pageSize ҳ���С
	 * @return ��ǰҳ��ĵ����п�ʽ
	 */
	@SuppressWarnings("unchecked")
	public List<Style> getAllStyle(int pageNo, int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Style>)findByPage("from Style", offset, pageSize);
	}

	/**
	 * ��ȡ���п�ʽ������
	 * @return ��ʽ������
	 */
	public long getCountStyle() {
		return (Long) getHibernateTemplate().find("select count(*) from Style").get(0);
	}

	/**
	 * ���ݿ�ʽ���ƻ�ȡ�ÿ�ʽʵ��
	 * @param styleName ��ʽ����
	 * @return ָ����ʽ���ƵĿ�ʽʵ��
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
	 * ��ȡ���һ����ŵĿ�ʽ
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
	 * ��ȡ��ʽ������
	 */
	public long getStyleCount() {
		return (Long) getHibernateTemplate().find("select count(*) from Style").get(0);
	}

	@Override
	public void saveOrUpdateStyle(Style style) {
		getHibernateTemplate().saveOrUpdate(style);
	}

}
