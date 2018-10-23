package com.paixie.service;

import com.paixie.domain.Users;

public interface UsersService {

	/**
	 * 根据用户名获取用户实例
	 * @param userName 用户名
	 * @return
	 */
	Users getUserByUserName(String userName);

	/**
	 * 根据邮箱获取用户实例
	 * @param email 邮箱
	 * @return
	 */
	Users getUserByEmail(String email);

	/**
	 * 用户注册
	 * @param users 需要保存的用户
	 */
	void registUsers(Users users);

	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param password 用户密码
	 * @param type 类型：邮件、用户名
	 * @return
	 */
	Users userLogin(String userName,String password,String type);

	/**
	 * 根据用户编号获取用户实例
	 * @param userid 用户编号
	 * @return
	 */
	Users getUserById(String userid);

	/**
	 * 修改用户实例
	 * @param user 需要被修改的用户实例
	 */
	void updateUser(Users user);
}
