
package com.paixie.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.OrderDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Order;

@Repository("orderDao")
public class OrderDaoHibernate extends BaseHibernateDaoSupport implements
		OrderDao {
	private int offset ;                        //��һ����¼����
	
	/**
	 * ���ݱ�ʶ����ɾ��Orderʵ��
	 * @param orderId ��Ҫɾ��Orderʵ���ı�ʶ����ֵ
	 */
	public void delete(String orderId) {
		getHibernateTemplate().delete(get(orderId));
	}

	/**
	 * ɾ��Orderʵ��
	 * @param order ��Ҫ��ɾ����Orderʵ��
	 */
	public void delete(Order order) {
		getHibernateTemplate().delete(order);
	}

	/**
	 * ���ݱ�ʾ���Ի�ȡOrderʵ��
	 * @param orderId ��Ҫ��ȡ��Orderʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ���Ե�Orderʵ��
	 */
	public Order get(String orderId) {
		return getHibernateTemplate().get(Order.class, orderId);
	}

	/**
	 * ���ݹ���Ա��Ż�ȡOrderʵ��,�����з�ҳ����
	 * @param workerId Ա��/����Ա���
	 * @param pageNo ָ��ҳ��
	 * @return ��Ա�������ָ��ҳ���ȫ��Orderʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByAdmin(String workerId,int pageNo) {
		offset = (pageNo-1)*20;
		return (List<Order>)findByPage("from Order as o where o.worker.workerId=?", workerId, offset,20);
	}

	/**
	 * ����ʱ���ϻ�ȡ��ȡOrderʵ���������з�ҳ����                                                            
	 * @param minDate ʱ������
	 * @param maxDate ʱ������
	 * @param page ָ��ҳ��
	 * @return ��ʱ������ָ��ҳ���ȫ��Orderʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByTime(String startTime, String endTime,int page,String userId) {
		offset =(page-1)*5;
		return (List<Order>)findByPage("from Order as o where o.users.userId=? and o.orderDate between ? and ?  order by o.orderDate desc", 
			   new Object[]{userId,startTime,endTime}, offset, 5);
	}

	/**
	 * �����û�����ȡOrderʵ���������з�ҳ����
	 * @param userId �û����
	 * @param pageNo ָ��ҳ��
	 * @return ���û���ָ��ҳ���ȫ��Orderʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByUser(String userId,int pageNo) {
		offset = (pageNo-1)*5;
		return (List<Order>)findByPage("from Order as o where o.users.userId=? order by o.orderDate desc", userId, offset, 5);
	}

	/**
	 * ����Orderʵ��
	 * @param order ��Ҫ�������orderʵ��
	 */
	public void save(Order order) {
		getHibernateTemplate().save(order);
	}

	/**
	 * �޸�Orderʵ��
	 * @param order ��Ҫ���޸ĵ�Orderʵ��
	 */
	public void update(Order order) {
		getHibernateTemplate().update(order);
	}

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ���
	 * @param page ҳ��
	 * @param userId �û����
	 * @param state ����״̬
	 * @return �û���ĳ��״̬�Ķ���
	 * 500000
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByUserState(String userId, int page, String state) {
		int offset = (page-1)*5;
		StringBuffer hql = new StringBuffer("From Order as o where o.users.userId=?");
		List<Object> list = new ArrayList<Object>();
		list.add(userId);
		
		if(!"500000".equals(state)){
			hql.append("and o.orderState.orderStateId=? ");
			list.add(state);
		}
		
		hql.append(" order by o.orderDate desc");

		return findByPage(hql.toString(),list.toArray(), offset, 5);
	}

	/**
	 * ��ȡ�û��Ķ���
	 * @param userId �û����
	 * @return ָ���û���ŵĶ���
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrder(String userId,String state) {
		StringBuffer hql = new StringBuffer("From Order as o where o.users.userId=?");
		List<Object> list = new ArrayList<Object>();
		list.add(userId);
		
		if(!"500000".equals(state)){
			hql.append("and o.orderState.orderStateId=? ");
			list.add(state);
		}
		
		hql.append(" order by o.orderDate desc");
		
		List<Order> oList = getHibernateTemplate().find(hql.toString(),list.toArray());
		
		return oList;
	}

	/**
	 * ��ȡ�û���ĳ��״̬�Ķ���
	 * @param userId �û����
	 * @param stateId ״̬���
	 * @return ĳ���û�ָ��״̬�Ķ���
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getStateOrder(String userId, String stateId) {
		return getHibernateTemplate().find("From Order as o where o.users.userId=? and o.orderState.orderStateId=? order by o.orderDate  desc",userId,stateId);
	}

	/**
	 * ��ȡ�û��Ķ���
	 * @param userId �û����
	 * @return ָ���û��Ķ���
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByUser(String userId) {
		return getHibernateTemplate().find("From Order as o where o.users.userId=? ",userId);
	}

	/**
	 * ���ݶ������ͻ�ȡ����
	 * @param page  ҳ��
	 * @param type  ����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderState(Integer page, String state) {
		int offset = (page-1)*10;
		StringBuffer hql = new StringBuffer("from Order as o ");
		List<Object> list = new ArrayList<Object>();
		if(!"500000".equals(state)){
			hql.append(" where o.orderState.orderStateId=? ");
			list.add(state);
		}
		
		hql.append(" order by o.orderDate desc");
		
		List<Order> orders = findByPage(hql.toString(), list.toArray(), offset, 10);
		
		return orders;
	}

	/**
	 * ��ȡĳ��״̬����������
	 * @param type  ����״̬
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getTypeOrder(String state) {
		StringBuffer hql = new StringBuffer("from Order as o ");
		List<Object> list = new ArrayList<Object>();
		if(!"500000".equals(state)){
			hql.append(" where o.orderState.orderStateId=? ");
			list.add(state);
		}
		List<Order> orders = getHibernateTemplate().find(hql.toString(),list.toArray());
		
		return orders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderSumByTime(String startTime, String endTime,String userId) {
		String hql = "from Order as o where o.users.userId=? and  o.orderDate between ? and ? order by o.orderDate desc ";
		return getHibernateTemplate().find(hql,userId,startTime,endTime);
	}
}
