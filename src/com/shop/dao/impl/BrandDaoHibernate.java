package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shop.dao.BrandDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Brand;

@Repository("brandDao")
public class BrandDaoHibernate extends BaseHibernateDaoSupport implements BrandDao {

	/**
	 * 删除brand实体
	 * @param brand 需要删除的Brand实体
	 */
	public void delete(Brand brand) {
		getHibernateTemplate().delete(brand);
	}

	/**
	 * 根据标识属性删除Brand实体
	 * @param brandId 需要删除的brand实体的标识属性值
	 */
	public void delete(String brandId) {
		getHibernateTemplate().delete(get(brandId));
	}

	/**
	 * 根据标识属性获取Brand实体
	 * @param brandId 需要获取Brand实体的标识属性值 
	 * @return 指定标识属性值的Brand实体
	 */
	public Brand get(String brandId) {
		return getHibernateTemplate().get(Brand.class, brandId);
	}

	/**
	 * 获取所有的Brand实体
	 * @return 数据库中现存所有的Brand实体
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getAllBrand() {
		return (List<Brand>) getHibernateTemplate().find("from Brand");
	}

	/**
	 * 保存brand实体
	 * @param brand 需要被保存的Brand实体
	 */
	public void save(Brand brand) {
		getHibernateTemplate().save(brand);
	}

	/**
	 * 修改Brand实体
	 * @param brand 需要被修改的Brand实体
	 */
	public void update(Brand brand) {
		getHibernateTemplate().update(brand);
	}

	/**
	 * 获取指定页面的全部品牌
	 * @param pageNo 指定页面
	 * @param pageSize 页面大小
	 * @return 指定页面的全部品牌
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getAllBrand(int pageNo, int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Brand>)findByPage("from Brand", offset, pageSize);
	}

	/**
	 * 根据品牌名称获取品牌
	 * @param brandName 品牌名称
	 * @return 指定品牌获取品牌
	 */
	@SuppressWarnings("unchecked")
	public Brand getBrandByName(String brandName) {
		List<Brand> brands = getHibernateTemplate().find("from Brand as b where b.brandName=?",brandName);
		if(brands!=null&&brands.size()==1){
			return brands.get(0);
		}
		return null;
	}

	/**
	 * 根据款式获取品牌
	 * @param styleId 款式编号
	 * @return 该款式的所有品牌
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrandByStyleId(String styleId) {
		return (List<Brand>)getHibernateTemplate().find("from Brand as b inner join fetch b.styles as s where s.styleId=?",styleId);
	}

	/**
	 * 获取指定数量的品牌信息
	 * @param count 指定数量
	 * @return 指定数量的品牌信息
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrand(int count) {
		Query query = getSession().createQuery("from Brand");
		query.setMaxResults(count);
		return query.list();
	}

	/**
	 * 获取某个字母或者数字开头的品牌
	 * @param hql hql语句
	 * @return 指定字母或者数字的品牌
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrandsBypytb(String hql) {
		return getHibernateTemplate().find(hql);
	}

	/**
	 * 获取品牌的总量
	 * @return
	 */
	public long getBrandCount() {
		return (Long) getHibernateTemplate().find("select count(*) from Brand").get(0);
	}

	/**
	 * 取得最大编号的品牌
	 */
	@SuppressWarnings("unchecked")
	public Brand getMaxIdBrand() {
		String hql = "From Brand as b order by b.brandId desc";
		List<Brand> brands = getHibernateTemplate().find(hql);
		if(brands!=null&&brands.size()>0)
			return brands.get(0);
		return null;
	}

	/**
	 * 根据品牌拼音获取 品牌实力
	 * @param brandSpell 品牌拼音
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Brand getBrandBySpell(String brandSpell) {
		List<Brand> brands = getHibernateTemplate().find("from Brand as b where b.brandSpell=?",brandSpell);
		if(brands!=null&&brands.size()==1){
			return brands.get(0);
		}
		return null;
	}

	/**
	 * 修改或者保存款式
	 */
	public void saveOrUpdateBrand(Brand brand) {
		getHibernateTemplate().saveOrUpdate(brand);
	}

}
