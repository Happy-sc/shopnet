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
	 * 根据标识属性删除User实例
	 * @param userId 需要被删除的Users实例的标识属性值
	 */
	public void delete(String userId) {
		getHibernateTemplate().delete(get(userId));
	}

	/**
	 * 删除Users实例
	 * @param users 需要被删除的Users实例
	 */
	public void delete(Users users) {
		getHibernateTemplate().delete(users);
	}

	/**
	 * 根据标识属性获取Users实例
	 * @param userId 需要获取的Users实例的标识属性值
	 * @return 指定标识属性值的Users实例
	 */
	public Users get(String userId) {
		return getHibernateTemplate().get(Users.class, userId);
	}

	/**
	 * 根据用户名称、密码获取Users实例
	 * @param userName 用户名
	 * @param password 密码
	 * @return 指定用户名、密码的Users实例
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
	 * 根据邮箱获取Users实例
	 * @param email 邮箱
	 * @return 指定邮箱的Users 实例
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
	 * 根据邮箱、密码查询Users实例
	 * @param email 邮箱
	 * @param password 密码
	 * @return 指定邮箱、密码的Users实例
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
	 * 根据用户名查询Users实例
	 * @param userName 用户名
	 * @return 指定用户名的Users实例
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
	 * 保存Users实例
	 * @param users 需要被保存的Users实例
	 */
	public void save(Users users) {
		getHibernateTemplate().save(users);
	}

	/**
	 * 修改Users实例
	 * @param users 需要被修改的Users实例
	 */
	public void update(Users users) {
		getHibernateTemplate().update(users);
	}

}
