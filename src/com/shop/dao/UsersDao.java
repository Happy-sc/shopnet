package com.shop.dao;

import com.shop.domain.Users;

public interface UsersDao {
	/**
	 * 根据标识属性获取Users实例
	 * @param userid
	 * @return
	 */
	Users get(String userid);
	
	/**
	 * 保存Users实例
	 * @param users
	 */
	void save(Users users);
	
	/**
	 * 根据标识属性删除Users实例
	 * @param userId
	 */
	void delete(String userId);
	
	/**
	 * 删除Users实例
	 * @param users
	 */
	void delete(Users users);
	
	/**
	 * 修改Users实例
	 * @param users
	 */
	void update(Users users);
	/**
	 * 根据用户查询用户
	 * @param userName
	 * @return
	 */
	Users getUsersByUserName(String userName);
	
	/**
	 * 根据邮箱查询用户
	 * @param email
	 * @return
	 */
	Users getUsersByEmail(String email);
	
	/**
	 * 根据用户名、密码查找用户
	 * @param userName
	 * @param password
	 * @return
	 */
	Users getUsersByUserNameAndPassword(String userName,String password);
	
	/**
	 * 根据邮箱、密码查找用户
	 * @param email
	 * @param password
	 * @return
	 */
	Users getUsersByEmailAndPassword(String email,String password);
}
