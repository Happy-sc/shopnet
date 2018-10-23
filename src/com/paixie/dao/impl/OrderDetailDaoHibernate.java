package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.OrderDetailDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;

@Repository("orderDetailDao")
public class OrderDetailDaoHibernate extends BaseHibernateDaoSupport implements
		OrderDetailDao {

	/**
	 * ���ݱ�ʶ����ɾ��OrderDetailʵ��
	 * @param orderDetailId ��Ҫɾ����OrderDetailʵ���ı�ʶ���Ժ���
	 */
	public void delete(String orderDetailId) {
		getHibernateTemplate().delete(get(orderDetailId));
	}

	/**
	 * ɾ��OrderDetailʵ��
	 * @param orderDetail ��Ҫ��ɾ����OrderDetailʵ��
	 */
	public void delete(OrderDetail orderDetail) {
		getHibernateTemplate().delete(orderDetail);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡOrderDetailʵ��
	 * @param orderDetailId ��Ҫ��ȡOrderDetailʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��OrderDetailʵ��
	 */
	public OrderDetail get(String orderDetailId) {
		return getHibernateTemplate().get(OrderDetail.class, orderDetailId);
	}

	/**
	 * ���ݶ�����Ż�ȡOrderDetailʵ��
	 * @param orderId �������
	 * @return ָ��������ŵ�ȫ��OrderDetailʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDetailsByOrderId(String orderId) {
		return (List<OrderDetail>)getHibernateTemplate().find("from OrderDetail as o where o.order.orderId=?",orderId);
	}

	/**
	 * ����OrderDetailʵ��
	 * @param orderDetail ��Ҫ�������OrderDetailʵ��
	 */
	public void save(OrderDetail orderDetail) {
		getHibernateTemplate().save(orderDetail);
	}

	/**
	 * �޸�OrderDetailʵ��
	 * @param orderDetail ��Ҫ���޸ĵ�OrderDetailʵ��
	 */
	public void update(OrderDetail orderDetail) {
		getHibernateTemplate().update(orderDetail);
	}

	/**
	 * ���ݶ�����Ż�ȡOrderDetailʵ��
	 * @param orderId �������
	 * @param commentState �Ƿ��Ѿ�����
	 * @return ָ��������ŵ�ȫ��OrderDetailʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDetailsByOrderId(String orderId,
			int commentState) {
		return (List<OrderDetail>)getHibernateTemplate().find("from OrderDetail as o where o.order.orderId=? and o.orderDetailIsCom=?",
				orderId,commentState);
	}

	/**
	 * ��ȡ��������ϸ��Ϣ
	 * @param orderId  �������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderDeail(String orderId) {
		String hql = "from OrderDetail as o where o.order.orderId=?";
		List<Order> orders = getHibernateTemplate().find(hql,orderId);
		
		return orders;
	}
	
	/**
	 * ���ݶ�����״̬��ȡָ��ҳ��Ķ�����Ϣ
	 * @param page  ��ǰҳ��
	 * @param userId �û����
	 * @param i ����״̬��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDSHOrder(int page, String userId, int i) {
		String hql = "from OrderDetail od left join od.order o where o.users.userId=? and od.isAccept=? order by o.orderDate desc";
		Object[] values = {userId,i};
		int offset = (page-1)*5;
		List<OrderDetail> list = findByPage(hql, values, offset, 5);
		
		return list;
	}

	/**
	 * ��ȡ�û��Ĵ��ջ�������
	 * @param userId �û����
	 * @param i ����״̬���
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getUserDSHOrder(String userId, int i) {
		String hql = "from OrderDetail od left join od.order o where o.users.userId=? and od.isAccept=?";
		List<OrderDetail> oList = getHibernateTemplate().find(hql,userId,i);
		
		return oList;
	}

	/**
	 * ���ݶ����Ƿ����ջ���ȡ������ϸ��Ϣ
	 * @param orderId �������
	 * @param i �Ƿ����ջ�״̬
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDSHOrderByOrder(String orderId, int i) {
		String hql = "from OrderDetail od left join od.order o where o.orderId=? and od.isAccept=?";
		return getHibernateTemplate().find(hql,orderId,i);
	}
}
