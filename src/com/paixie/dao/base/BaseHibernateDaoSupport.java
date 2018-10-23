package com.paixie.dao.base;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
  * ����Ϊһ������������ṩ��ҳ������
  * ͬʱ���е�dao��ȫ���̳и���
  */
public class BaseHibernateDaoSupport extends HibernateDaoSupport{
	/**
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List findByPage(final String hql, final int offset, final int pageSize){
		List list = getHibernateTemplate().executeFind(
			new HibernateCallback(){
				public Object doInHibernate(Session session)throws HibernateException, SQLException{
					List result = session.createQuery(hql)
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
		return list;
	}
	
	
	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param value ���hql��һ��������Ҫ���룬value���Ǵ���Ĳ���
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List findByPage(final String hql , final Object value , final int offset, final int pageSize){
		List list = getHibernateTemplate().executeFind(
			new HibernateCallback(){
				public Object doInHibernate(Session session)throws HibernateException, SQLException{
					List result = session.createQuery(hql)
						.setParameter(0, value) 
						.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
		return list;
	}
	
	
	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param values ���hql�ж����������Ҫ���룬values���Ǵ���Ĳ�������
	 * @param offset ��һ����¼����
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼
	 */
	@SuppressWarnings("unchecked")
	public List findByPage(final String hql, final Object[] values,final int offset, final int pageSize){
		List list = getHibernateTemplate().executeFind(
				new HibernateCallback(){
				public Object doInHibernate(Session session)throws HibernateException, SQLException{
					Query query = session.createQuery(hql);
					for (int i = 0 ; i < values.length ; i++){
						query.setParameter( i , values[i]);
					}
					List result = query.setFirstResult(offset)
						.setMaxResults(pageSize)
						.list();
					return result;
				}
			});
		return list;
	}
}