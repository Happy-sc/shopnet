package com.paixie.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.paixie.dao.GoodsListingDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.GoodsListing;

@Repository("goodsListingDao")
public class GoodsListingDaoHibernate extends BaseHibernateDaoSupport implements
		GoodsListingDao{

	private int offset; 
	
	/**
	 * ���ݱ�ʶ����ɾ��GoodsListingʵ��
	 * @param goodsId ��Ҫ��ɾ����GoodsListingʵ���ı�ʶ����ֵ
	 */
	public void delete(String goodsId) {
		getHibernateTemplate().delete(get(goodsId));
	}

	/**
	 * ɾ��GoodsListingʵ��
	 * @param goodsListing ��Ҫ��ɾ����GoodsListingʵ��
	 */
	public void delete(GoodsListing goodsListing) {
		getHibernateTemplate().delete(goodsListing);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡGoodsListingʵ��
	 * @param goodsId ��Ҫ��ȡ��GoodsListingʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��GoodsListingʵ��
	 */
	public GoodsListing get(String goodsId) {
		return getHibernateTemplate().get(GoodsListing.class, goodsId);
	}

	/**
	 * ����Ʒ�ƻ�ȡGoodsListingʵ���������з�ҳ����
	 * @param brandId Ʒ�Ʊ��
	 * @param pageNo ָ��ҳ��
	 * @return ��Ʒ�Ƶ�ָ��ҳ���ȫ��GoodsListingʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByBrand(String brandId, int pageSize,int pageNo) {
		offset = (pageNo-1)*pageSize;
		return (List<GoodsListing>)findByPage("from GoodsListing as g where g.category.styles.brands.brandId=?",
				brandId, offset, pageSize);
	}
	
	/**
	 * ������Ʒ��ʽ��ȡGoodsListingʵ�������ҽ��з�ҳ����
	 * @param typeId ��ʽ���
	 * @param pageNo ָ��ҳ��
	 * @return ����Ʒ��ʽ��ָ��ҳ���ȫ��Goodslistingʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByType(String stypeId,int pageSize, int pageNo) {
		return (List<GoodsListing>)findByPage("from GoodsListing as g where g.category.styles.styleId=?",
				stypeId, offset, pageSize);
	}

	/**
	 * ����Goodslistingʵ��
	 * @param goodsListing ��Ҫ�������Goodslistingʵ��
	 */
	public void save(GoodsListing goodsListing) {
		getHibernateTemplate().save(goodsListing);      
	}

	/**
	 * �޸�Goodslistingʵ��
	 * @param goodsListing ��Ҫ���޸ĵ�Goodslistingʵ��
	 */
	public void update(GoodsListing goodsListing) {
		getHibernateTemplate().update(goodsListing);
		
	}

	/**
	 * ��ȡָ����Ʒ����ĵ�ָ����������Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByCategory(String category, int count) {
		String hql = "from GoodsListing as g where g.category.categoryId=? order by g.goodsGrounding desc";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, category);
		query.setMaxResults(count);
		return query.list();
	}

	/**
	 * �����ض�������ȡ��Ʒ����Ҳorder����
	 * @param string �ض�����
	 * @param order ��������
	 * @return ָ��������ָ������˳�����Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsOrderString(String string, String order) {
		String hql = "from GoodsListing as g order by g."+string+" "+order;
		Query query = getSession().createQuery(hql);
		query.setMaxResults(10);
		return query.list();
	}

	/**
	 * ��ȡ�Ƽ���Ʒ
	 * @param number �Ƽ�����
	 * @return ָ���������Ƽ���Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByRecommend(int number) {
		String hql = "from GoodsListing as g where g.goodsIsRecommend=1 order by g.goodsGrounding desc";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(number);
		return query.list();
	}

	/**
	 * ������Ʒ�ִ�����ȡ��Ʒ��Ϣ,��������
	 * @return ǰ10�������ִ�������Ʒ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByGoodsExitNumber() {
		String hql = "from GoodsListing as g where g.goodsExitNumber<500 order by g.goodsExitNumber asc";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(10);
		return query.list();
	}

	/**
	 * ��ȡ�÷�����Ƽ���Ʒ�����ϼ�ʱ��Ϊ��׼��ȡǰ5��
	 * @param categoryId ������
	 * @return ǰ5���Ƽ���Ʒ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getRecommandGoodsByCategoryId(String categoryId) {
		String hql = "from GoodsListing as g where g.goodsIsRecommend=? and g.category.categoryId=? order by g.goodsGrounding desc";
		List<GoodsListing> list = getSession().createQuery(hql).
								  setParameter(0, 1).setParameter(1, categoryId).       //���ò���
								  setMaxResults(5).      //ǰ5��
								  list();               //�����
		
		return list;
	}

	/**
	 * ��ȡ�������Ʒ
	 * @param categoryId ��Ʒ������
	 * @return �÷�����Ʒ��������
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsSumByCategory(String categoryId) {
		return (List<GoodsListing>)getHibernateTemplate().find("From GoodsListing as g where g.category.categoryId="+categoryId);
	}

	/**
	 * ��ȡĳ���������Ʒ��Ϣ�������з�ҳ����
	 * @param category ��Ʒ������
	 * @param pageSize ÿҳ��ʾ��Ʒ������
	 * @param page ҳ��
	 * @return ָ����Ʒ�����ĳҳ��pageSize����Ʒ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByCategoryPage(String categoryId,int pageSize, int page) {
		offset = (page-1)*pageSize;
		String hql = "From GoodsListing as g where g.category.categoryId=?";
		List<GoodsListing> goods = (List<GoodsListing>)findByPage(hql, categoryId, offset, pageSize);
		return goods;
	}

	/**
	 * ����HQL��ȡ��Ӧ����Ʒ��Ϣ�������з�ҳ����
	 * @param hql HQL���
	 * @param i ÿҳ��ʾ������
	 * @param page ҳ��
	 * @return ָ����HQL����ĳҳ��i����Ʒ��Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByOption(String hql, int pageSize, int page) {
		offset = (page-1)*pageSize;
		List<GoodsListing> goods = findByPage(hql, offset, pageSize);
		return goods;
	}

	/**
	 * ��ȡͬ��������Ʒ
	 * @return styleId ��ʽ���
	 * @return ָ����ʽ��Ʒ
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getMostSaleByStyle(String styleId) {
		String hql = "From GoodsListing as g where g.style.styleId=? order by g.goodsMarketNumber desc";
		List<GoodsListing> list = getSession().createQuery(hql).
								  setParameter(0, styleId).
								  setMaxResults(5).list();
		return list;
	}

	/**
	 * ��ȡָ����Ŀ�Ƽ���Ʒ
	 * @param i ��Ŀ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getRecommand(int i) {
		String hql = "from GoodsListing as g where g.goodsIsRecommend=1 order by g.goodsGrounding desc";
		List<GoodsListing> list = getSession().createQuery(hql).
		  						  setMaxResults(i).      //ǰ5��
		  						  list();               //�����

		return list;
	}
	
	
}
