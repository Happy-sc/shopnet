package com.paixie.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paixie.dao.BrandDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Brand;

@Repository("brandDao")
public class BrandDaoHibernate extends BaseHibernateDaoSupport implements BrandDao {

	/**
	 * ɾ��brandʵ��
	 * @param brand ��Ҫɾ����Brandʵ��
	 */
	public void delete(Brand brand) {
		getHibernateTemplate().delete(brand);
	}

	/**
	 * ���ݱ�ʶ����ɾ��Brandʵ��
	 * @param brandId ��Ҫɾ����brandʵ��ı�ʶ����ֵ
	 */
	public void delete(String brandId) {
		getHibernateTemplate().delete(get(brandId));
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡBrandʵ��
	 * @param brandId ��Ҫ��ȡBrandʵ��ı�ʶ����ֵ 
	 * @return ָ����ʶ����ֵ��Brandʵ��
	 */
	public Brand get(String brandId) {
		return getHibernateTemplate().get(Brand.class, brandId);
	}

	/**
	 * ��ȡ���е�Brandʵ��
	 * @return ���ݿ����ִ����е�Brandʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getAllBrand() {
		return (List<Brand>) getHibernateTemplate().find("from Brand");
	}

	/**
	 * ����brandʵ��
	 * @param brand ��Ҫ�������Brandʵ��
	 */
	public void save(Brand brand) {
		getHibernateTemplate().save(brand);
	}

	/**
	 * �޸�Brandʵ��
	 * @param brand ��Ҫ���޸ĵ�Brandʵ��
	 */
	public void update(Brand brand) {
		getHibernateTemplate().update(brand);
	}

	/**
	 * ��ȡָ��ҳ���ȫ��Ʒ��
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ҳ���С
	 * @return ָ��ҳ���ȫ��Ʒ��
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getAllBrand(int pageNo, int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Brand>)findByPage("from Brand", offset, pageSize);
	}

	/**
	 * ����Ʒ�����ƻ�ȡƷ��
	 * @param brandName Ʒ������
	 * @return ָ��Ʒ�ƻ�ȡƷ��
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
	 * ���ݿ�ʽ��ȡƷ��
	 * @param styleId ��ʽ���
	 * @return �ÿ�ʽ������Ʒ��
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrandByStyleId(String styleId) {
		return (List<Brand>)getHibernateTemplate().find("from Brand as b inner join fetch b.styles as s where s.styleId=?",styleId);
	}

	/**
	 * ��ȡָ��������Ʒ����Ϣ
	 * @param count ָ������
	 * @return ָ��������Ʒ����Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrand(int count) {
		Query query = getSession().createQuery("from Brand");
		query.setMaxResults(count);
		return query.list();
	}

	/**
	 * ��ȡĳ����ĸ�������ֿ�ͷ��Ʒ��
	 * @param hql hql���
	 * @return ָ����ĸ�������ֵ�Ʒ��
	 */
	@SuppressWarnings("unchecked")
	public List<Brand> getBrandsBypytb(String hql) {
		return getHibernateTemplate().find(hql);
	}

	/**
	 * ��ȡƷ�Ƶ�����
	 * @return
	 */
	public long getBrandCount() {
		return (Long) getHibernateTemplate().find("select count(*) from Brand").get(0);
	}

	/**
	 * ȡ������ŵ�Ʒ��
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
	 * ����Ʒ��ƴ����ȡ Ʒ��ʵ��
	 * @param brandSpell Ʒ��ƴ��
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
	 * �޸Ļ��߱����ʽ
	 */
	public void saveOrUpdateBrand(Brand brand) {
		getHibernateTemplate().saveOrUpdate(brand);
	}

}
