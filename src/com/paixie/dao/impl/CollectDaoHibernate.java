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
	 * ���ݱ�ʶ����ɾ��Collectʵ��
	 * @param collectId ��Ҫ��ɾ����Collectʵ���ı�ʶ����ֵ
	 */
	public void delete(String collectId) {
		getHibernateTemplate().delete(get(collectId));
	}

	/**
	 * ɾ��Collectʵ��
	 * @param
	 */
	public void delete(Collect collect) {
		getHibernateTemplate().delete(collect);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡCollectʵ��
	 * @parma collectId ��Ҫ��ȡCollectʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Collectʵ��
	 */
	public Collect get(String collectId) {
		return getHibernateTemplate().get(Collect.class, collectId);
	}

	/**
	 * ��ȡȫ����Collectʵ��
	 * @return ���ݿ��е�ȫ��Collectʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Collect> getAllCollect() {
		return (List<Collect>)getHibernateTemplate().find("from Collect");
	}

	/**
	 * ����Collectʵ��
	 * @param collect ��Ҫ�������Collectʵ��
	 */
	public void save(Collect collect) {
		getHibernateTemplate().save(collect);
	}

	/**
	 * �޸�Collectʵ��
	 * @param collect��Ҫ���޸ĵ�Collectʵ��
	 */
	public void update(Collect collect) {
		getHibernateTemplate().update(collect);
	}

	/**
	 * ������Ʒ��Ż�ȡ�ղ�
	 * @param goodsId ��Ʒ���
	 * @param userId �û����
	 * @return ָ����Ʒ��ŵ�ĳ���û����ղ�
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
	 * ��ȡĳ���û����ղ�
	 * @param page ��ǰҳ��
	 * @param userName �û���
	 * @return ���û���ǰҳ����ղ�
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
	 * ��ȡ�����ղ�
	 * @param userId �û����
	 * @return �����ղص�������
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
