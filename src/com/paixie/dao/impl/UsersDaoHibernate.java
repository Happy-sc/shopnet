package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.UsersDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Users;

@Repository("usersDao")
public class UsersDaoHibernate extends BaseHibernateDaoSupport implements
		UsersDao {

	/**
	 * ���ݱ�ʶ����ɾ��Userʵ��
	 * @param userId ��Ҫ��ɾ����Usersʵ���ı�ʶ����ֵ
	 */
	public void delete(String userId) {
		getHibernateTemplate().delete(get(userId));
	}

	/**
	 * ɾ��Usersʵ��
	 * @param users ��Ҫ��ɾ����Usersʵ��
	 */
	public void delete(Users users) {
		getHibernateTemplate().delete(users);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡUsersʵ��
	 * @param userId ��Ҫ��ȡ��Usersʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Usersʵ��
	 */
	public Users get(String userId) {
		return getHibernateTemplate().get(Users.class, userId);
	}

	/**
	 * �����û����ơ������ȡUsersʵ��
	 * @param userName �û���
	 * @param password ����
	 * @return ָ���û����������Usersʵ��
	 */
	@SuppressWarnings("unchecked")
	public Users getUsersByUserNameAndPassword(String userName, String password) {
		List<Users> users = getHibernateTemplate().find("from Users as u where u.userName =? and u.userPassword=?"
				            ,userName ,password);
		if(users!=null&&users.size()==1){
			return users.get(0);
		}
		return null;
	}

	/**
	 * ���������ȡUsersʵ��
	 * @param email ����
	 * @return ָ�������Users ʵ��
	 */
	@SuppressWarnings("unchecked")
	public Users getUsersByEmail(String email) {
		List<Users> users = getHibernateTemplate().find("from Users as u where u.userEmail=?",email);
		if(users!=null&&users.size()==1){
			return users.get(0);
		}
		return null;
	}

	/**
	 * �������䡢�����ѯUsersʵ��
	 * @param email ����
	 * @param password ����
	 * @return ָ�����䡢�����Usersʵ��
	 */
	@SuppressWarnings("unchecked")
	public Users getUsersByEmailAndPassword(String email, String password) {
		List<Users> users = getHibernateTemplate().find("from Users as u where u.userEmail=? and u.userPassword=?",email,password);
		if(users!=null&&users.size()==1){
			return users.get(0);
		}
		return null;
	}

	/**
	 * �����û�����ѯUsersʵ��
	 * @param userName �û���
	 * @return ָ���û�����Usersʵ��
	 */
	@SuppressWarnings("unchecked")
	public Users getUsersByUserName(String userName){
		List<Users> users = getHibernateTemplate().find("from Users as u where u.userName=?",userName);
		if(users!=null&&users.size()==1){
			return users.get(0);
		}
		return null;
	}

	/**
	 * ����Usersʵ��
	 * @param users ��Ҫ�������Usersʵ��
	 */
	public void save(Users users) {
		getHibernateTemplate().save(users);
	}

	/**
	 * �޸�Usersʵ��
	 * @param users ��Ҫ���޸ĵ�Usersʵ��
	 */
	public void update(Users users) {
		getHibernateTemplate().update(users);
	}

}
