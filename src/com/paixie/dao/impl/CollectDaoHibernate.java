package com.paixie.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.CollectDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Collect;

@Repository("collectDao")
public class CollectDaoHibernate extends BaseHibernateDaoSupport implements
		CollectDao {

	/**
	 * 根据标识属性删除Collect实例
	 * @param collectId 需要被删除的Collect实例的标识属性值
	 */
	public void delete(String collectId) {
		getHibernateTemplate().delete(get(collectId));
	}

	/**
	 * 删除Collect实例
	 * @param
	 */
	public void delete(Collect collect) {
		getHibernateTemplate().delete(collect);
	}

	/**
	 * 根据标识属性获取Collect实例
	 * @parma collectId 需要获取Collect实例的标识属性值
	 * @return 指定标识属性值的Collect实例
	 */
	public Collect get(String collectId) {
		return getHibernateTemplate().get(Collect.class, collectId);
	}

	/**
	 * 获取全部的Collect实例
	 * @return 数据库中的全部Collect实例
	 */
	@SuppressWarnings("unchecked")
	public List<Collect> getAllCollect() {
		return (List<Collect>)getHibernateTemplate().find("from Collect");
	}

	/**
	 * 保存Collect实例
	 * @param collect 需要被保存的Collect实例
	 */
	public void save(Collect collect) {
		getHibernateTemplate().save(collect);
	}

	/**
	 * 修改Collect实例
	 * @param collect需要被修改的Collect实例
	 */
	public void update(Collect collect) {
		getHibernateTemplate().update(collect);
	}

	/**
	 * 根据商品编号获取收藏
	 * @param goodsId 商品编号
	 * @param userId 用户编号
	 * @return 指定商品编号的某个用户的收藏
	 */
	@SuppressWarnings("unchecked")
	public Collect getCollectByGoods(String goodsId, String userId) {
		List<Collect> collects = (List<Collect>)getHibernateTemplate().find("From Collect as c where c.users.userId=? and c.goodsListing.goodsId=?",userId,goodsId);
		if(collects!=null&&collects.size()==1){
			return collects.get(0);
		}
		return null;
	}

	/**
	 * 获取某个用户的收藏
	 * @param page 当前页面
	 * @param userName 用户名
	 * @return 该用户当前页面的收藏
	 */
	@SuppressWarnings("unchecked")
	public List<Collect> getCollectsByUser(int page, String userId,
			int state) {
		int offset = (page-1)*5;
		StringBuffer hql = new StringBuffer("From Collect as c where c.users.userId = ? ");
		List<Object> list = new ArrayList<Object>();
		list.add(userId);
		if(state!=2){
			hql.append(" and c.goodsListing.goodsState=?");
			list.add(state);
		}
		
		List<Collect> collects = findByPage(hql.toString(), list.toArray(), offset, 5);
		return collects;
	}

	/**
	 * 获取所有收藏
	 * @param userId 用户编号
	 * @return 所有收藏的总数量
	 */
	@SuppressWarnings("unchecked")
	public List<Collect> getAllCollectSum(String userId,int state) {
		StringBuffer hql = new StringBuffer("From Collect as c where c.users.userId=?");
		List<Object> list = new ArrayList<Object>();
		list.add(userId);
		if(state!=2){
			hql.append(" and c.goodsListing.goodsState=?");
			list.add(state);
		}
		List<Collect> collects = getHibernateTemplate().find(hql.toString(),list.toArray());
		
		return collects;
		
	}

}
