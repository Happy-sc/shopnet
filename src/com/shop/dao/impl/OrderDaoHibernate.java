
package com.shop.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.OrderDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Order;

@Repository("orderDao")
public class OrderDaoHibernate extends BaseHibernateDaoSupport implements
		OrderDao {
	private int offset ;                        //第一条记录索引
	
	/**
	 * 根据标识属性删除Order实例
	 * @param orderId 需要删除Order实例的标识属性值
	 */
	public void delete(String orderId) {
		getHibernateTemplate().delete(get(orderId));
	}

	/**
	 * 删除Order实例
	 * @param order 需要被删除的Order实例
	 */
	public void delete(Order order) {
		getHibernateTemplate().delete(order);
	}

	/**
	 * 根据表示属性获取Order实例
	 * @param orderId 需要获取的Order实例的标识属性值
	 * @return 指定标识属性的Order实例
	 */
	public Order get(String orderId) {
		return getHibernateTemplate().get(Order.class, orderId);
	}

	/**
	 * 根据管理员编号获取Order实例,并进行分页控制
	 * @param workerId 员工/管理员编号
	 * @param pageNo 指定页面
	 * @return 该员工处理的指定页面的全部Order实例
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByAdmin(String workerId,int pageNo) {
		offset = (pageNo-1)*20;
		return (List<Order>)findByPage("from Order as o where o.worker.workerId=?", workerId, offset,20);
	}

	/**
	 * 根据时间间断获取获取Order实例，并进行分页控制                                                            
	 * @param minDate 时间下限
	 * @param maxDate 时间上限
	 * @param page 指定页面
	 * @return 该时间间断中指定页面的全部Order实例
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByTime(String startTime, String endTime,int page,String userId) {
		offset =(page-1)*5;
		return (List<Order>)findByPage("from Order as o where o.users.userId=? and o.orderDate between ? and ?  order by o.orderDate desc", 
			   new Object[]{userId,startTime,endTime}, offset, 5);
	}

	/**
	 * 根据用户名获取Order实例，并进行分页控制
	 * @param userId 用户编号
	 * @param pageNo 指定页面
	 * @return 该用户的指定页面的全部Order实例
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByUser(String userId,int pageNo) {
		offset = (pageNo-1)*5;
		return (List<Order>)findByPage("from Order as o where o.users.userId=? order by o.orderDate desc", userId, offset, 5);
	}

	/**
	 * 保存Order实例
	 * @param order 需要被保存的order实例
	 */
	public void save(Order order) {
		getHibernateTemplate().save(order);
	}

	/**
	 * 修改Order实例
	 * @param order 需要被修改的Order实例
	 */
	public void update(Order order) {
		getHibernateTemplate().update(order);
	}

	/**
	 * 获取用户的某个状态的订单
	 * @param page 页码
	 * @param userId 用户编号
	 * @param state 订单状态
	 * @return 用户的某个状态的订单
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
	 * 获取用户的订单
	 * @param userId 用户编号
	 * @return 指定用户编号的订单
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
	 * 获取用户的某种状态的订单
	 * @param userId 用户编号
	 * @param stateId 状态编号
	 * @return 某个用户指定状态的订单
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getStateOrder(String userId, String stateId) {
		return getHibernateTemplate().find("From Order as o where o.users.userId=? and o.orderState.orderStateId=? order by o.orderDate  desc",userId,stateId);
	}

	/**
	 * 获取用户的订单
	 * @param userId 用户编号
	 * @return 指定用户的订单
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getOrderByUser(String userId) {
		return getHibernateTemplate().find("From Order as o where o.users.userId=? ",userId);
	}

	/**
	 * 根据订单类型获取订单
	 * @param page  页码
	 * @param type  类型
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
	 * 获取某种状态订单的总量
	 * @param type  订单状态
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
