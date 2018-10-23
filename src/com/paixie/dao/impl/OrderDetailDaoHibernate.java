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
	 * 根据标识属性删除OrderDetail实例
	 * @param orderDetailId 需要删除的OrderDetail实例的标识属性好自
	 */
	public void delete(String orderDetailId) {
		getHibernateTemplate().delete(get(orderDetailId));
	}

	/**
	 * 删除OrderDetail实例
	 * @param orderDetail 需要被删除的OrderDetail实例
	 */
	public void delete(OrderDetail orderDetail) {
		getHibernateTemplate().delete(orderDetail);
	}

	/**
	 * 根据标识属性获取OrderDetail实例
	 * @param orderDetailId 需要获取OrderDetail实例的标识属性值
	 * @return 指定标识属性值的OrderDetail实例
	 */
	public OrderDetail get(String orderDetailId) {
		return getHibernateTemplate().get(OrderDetail.class, orderDetailId);
	}

	/**
	 * 根据订单编号获取OrderDetail实例
	 * @param orderId 订单编号
	 * @return 指定订单编号的全部OrderDetail实例
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDetailsByOrderId(String orderId) {
		return (List<OrderDetail>)getHibernateTemplate().find("from OrderDetail as o where o.order.orderId=?",orderId);
	}

	/**
	 * 保存OrderDetail实例
	 * @param orderDetail 需要被保存的OrderDetail实例
	 */
	public void save(OrderDetail orderDetail) {
		getHibernateTemplate().save(orderDetail);
	}

	/**
	 * 修改OrderDetail实例
	 * @param orderDetail 需要被修改的OrderDetail实例
	 */
	public void update(OrderDetail orderDetail) {
		getHibernateTemplate().update(orderDetail);
	}

	/**
	 * 根据订单编号获取OrderDetail实例
	 * @param orderId 订单编号
	 * @param commentState 是否已经评价
	 * @return 指定订单编号的全部OrderDetail实例
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDetailsByOrderId(String orderId,
			int commentState) {
		return (List<OrderDetail>)getHibernateTemplate().find("from OrderDetail as o where o.order.orderId=? and o.orderDetailIsCom=?",
				orderId,commentState);
	}

	/**
	 * 获取订单的详细信息
	 * @param orderId  订单编号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderDeail(String orderId) {
		String hql = "from OrderDetail as o where o.order.orderId=?";
		List<Order> orders = getHibernateTemplate().find(hql,orderId);
		
		return orders;
	}
	
	/**
	 * 根据订单的状态获取指定页面的订单信息
	 * @param page  当前页码
	 * @param userId 用户编号
	 * @param i 订单状态码
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
	 * 获取用户的待收货的总数
	 * @param userId 用户编号
	 * @param i 订单状态编号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getUserDSHOrder(String userId, int i) {
		String hql = "from OrderDetail od left join od.order o where o.users.userId=? and od.isAccept=?";
		List<OrderDetail> oList = getHibernateTemplate().find(hql,userId,i);
		
		return oList;
	}

	/**
	 * 根据订单是否已收货获取订单详细信息
	 * @param orderId 订单编号
	 * @param i 是否已收货状态
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDSHOrderByOrder(String orderId, int i) {
		String hql = "from OrderDetail od left join od.order o where o.orderId=? and od.isAccept=?";
		return getHibernateTemplate().find(hql,orderId,i);
	}
}
