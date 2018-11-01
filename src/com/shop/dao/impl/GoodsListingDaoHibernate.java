package com.shop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shop.dao.GoodsListingDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.GoodsListing;

@Repository("goodsListingDao")
public class GoodsListingDaoHibernate extends BaseHibernateDaoSupport implements
		GoodsListingDao{

	private int offset; 
	
	/**
	 * 根据标识属性删除GoodsListing实例
	 * @param goodsId 需要被删除的GoodsListing实例的标识属性值
	 */
	public void delete(String goodsId) {
		getHibernateTemplate().delete(get(goodsId));
	}

	/**
	 * 删除GoodsListing实例
	 * @param goodsListing 需要被删除的GoodsListing实例
	 */
	public void delete(GoodsListing goodsListing) {
		getHibernateTemplate().delete(goodsListing);
	}

	/**
	 * 根据标识属性获取GoodsListing实例
	 * @param goodsId 需要获取的GoodsListing实例的标识属性值
	 * @return 指定标识属性值的GoodsListing实例
	 */
	public GoodsListing get(String goodsId) {
		return getHibernateTemplate().get(GoodsListing.class, goodsId);
	}

	/**
	 * 根据品牌获取GoodsListing实例，并进行分页控制
	 * @param brandId 品牌编号
	 * @param pageNo 指定页面
	 * @return 该品牌的指定页面的全部GoodsListing实例
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByBrand(String brandId, int pageSize,int pageNo) {
		offset = (pageNo-1)*pageSize;
		return (List<GoodsListing>)findByPage("from GoodsListing as g where g.category.styles.brands.brandId=?",
				brandId, offset, pageSize);
	}
	
	/**
	 * 根据商品款式获取GoodsListing实例，并且进行分页控制
	 * @param typeId 款式编号
	 * @param pageNo 指定页面
	 * @return 该商品款式的指定页面的全部Goodslisting实例
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByType(String stypeId,int pageSize, int pageNo) {
		return (List<GoodsListing>)findByPage("from GoodsListing as g where g.category.styles.styleId=?",
				stypeId, offset, pageSize);
	}

	/**
	 * 保存Goodslisting实例
	 * @param goodsListing 需要被保存的Goodslisting实例
	 */
	public void save(GoodsListing goodsListing) {
		getHibernateTemplate().save(goodsListing);      
	}

	/**
	 * 修改Goodslisting实例
	 * @param goodsListing 需要被修改的Goodslisting实例
	 */
	public void update(GoodsListing goodsListing) {
		getHibernateTemplate().update(goodsListing);
		
	}

	/**
	 * 获取指定商品分类的的指定数量的商品
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
	 * 根据特定条件获取商品并且也order排序
	 * @param string 特定条件
	 * @param order 排序条件
	 * @return 指定条件的指定排序顺序的商品
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsOrderString(String string, String order) {
		String hql = "from GoodsListing as g order by g."+string+" "+order;
		Query query = getSession().createQuery(hql);
		query.setMaxResults(10);
		return query.list();
	}

	/**
	 * 获取推荐商品
	 * @param number 推荐数量
	 * @return 指定数量的推荐商品
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByRecommend(int number) {
		String hql = "from GoodsListing as g where g.goodsIsRecommend=1 order by g.goodsGrounding desc";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(number);
		return query.list();
	}

	/**
	 * 根据商品现存量获取商品信息,并且排序
	 * @return 前10个最少现存量的商品信息
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByGoodsExitNumber() {
		String hql = "from GoodsListing as g where g.goodsExitNumber<500 order by g.goodsExitNumber asc";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(10);
		return query.list();
	}

	/**
	 * 获取该分类的推荐商品，以上架时间为标准获取前5个
	 * @param categoryId 分类编号
	 * @return 前5个推荐商品信息
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getRecommandGoodsByCategoryId(String categoryId) {
		String hql = "from GoodsListing as g where g.goodsIsRecommend=? and g.category.categoryId=? order by g.goodsGrounding desc";
		List<GoodsListing> list = getSession().createQuery(hql).
								  setParameter(0, 1).setParameter(1, categoryId).       //设置参数
								  setMaxResults(5).      //前5个
								  list();               //结果集
		
		return list;
	}

	/**
	 * 获取分类的商品
	 * @param categoryId 商品分类编号
	 * @return 该分类商品的总数量
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsSumByCategory(String categoryId) {
		return (List<GoodsListing>)getHibernateTemplate().find("From GoodsListing as g where g.category.categoryId="+categoryId);
	}

	/**
	 * 获取某个分类的商品信息，并进行分页处理
	 * @param category 商品分类编号
	 * @param pageSize 每页显示商品的数量
	 * @param page 页码
	 * @return 指定商品分类的某页的pageSize个商品信息
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByCategoryPage(String categoryId,int pageSize, int page) {
		offset = (page-1)*pageSize;
		String hql = "From GoodsListing as g where g.category.categoryId=?";
		List<GoodsListing> goods = (List<GoodsListing>)findByPage(hql, categoryId, offset, pageSize);
		return goods;
	}

	/**
	 * 根据HQL获取相应的商品信息，并进行分页处理
	 * @param hql HQL语句
	 * @param i 每页显示的数量
	 * @param page 页面
	 * @return 指定的HQL语句的某页的i个商品信息
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getGoodsByOption(String hql, int pageSize, int page) {
		offset = (page-1)*pageSize;
		List<GoodsListing> goods = findByPage(hql, offset, pageSize);
		return goods;
	}

	/**
	 * 获取同款热销商品
	 * @return styleId 款式编号
	 * @return 指定款式商品
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
	 * 获取指定数目推荐商品
	 * @param i 数目
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsListing> getRecommand(int i) {
		String hql = "from GoodsListing as g where g.goodsIsRecommend=1 order by g.goodsGrounding desc";
		List<GoodsListing> list = getSession().createQuery(hql).
		  						  setMaxResults(i).      //前5个
		  						  list();               //结果集

		return list;
	}
	
	
}
