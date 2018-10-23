package com.paixie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.UsersDao;
import com.paixie.domain.Users;
import com.paixie.service.UsersService;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
	@Resource(name="usersDao") UsersDao usersDao;
	/**
	 * 根据用户名获取用户
	 * @param userName 用户名
	 * @return 指定用户名的用户实例
	 */
	public Users getUserByUserName(String userName) {
		return usersDao.getUsersByUserName(userName);
	}
	
	/**
	 * 根据用户邮箱获取用户
	 * @param email 用户邮箱
	 * @return 指定邮箱的用户实例
	 */
	public Users getUserByEmail(String email) {
		return usersDao.getUsersByEmail(email);
	}

	/**
	 * 用户注册
	 * @param users 需要注册的用户实例
	 * @return
	 */
	public void registUsers(Users users) {
		usersDao.save(users);
	}

	/**
	 * 用户登录
	 * @param userName 登录用户名
	 * @param password 登录密码
	 * @param type 输入的是邮箱还是用户名
	 * @return 指定用户名/邮箱和密码的用户
	 * 
	 */
	public Users userLogin(String userName, String password, String type) {
		Users users = null;
		if("userName".equals(type)){
			users = usersDao.getUsersByUserNameAndPassword(userName, password);
		}
		if("email".equals(type)){
			users = usersDao.getUsersByEmailAndPassword(userName, password);
		}
		return users;
	}

	/**
	 * 根据用户编号获取用户实例
	 * @param userid 用户编号
	 * @return 该编号的用户实例
	 */
	public Users getUserById(String userid) {
		return usersDao.get(userid);
	}

	/**
	 * 修改用户实例
	 * @param user 需要修改的用户
	 * @return
	 */
	public void updateUser(Users user) {
		usersDao.update(user);
	}
}
