package com.paixie.service;

import com.paixie.domain.Users;

public interface EmailService {
	
	/**
	 * 设置用户验证时的邮箱信息
	 * @param users 用户
	 * @param email 邮箱
	 * @param type 类型
	 * @return 设置好信息的用户
	 */
	public Users setUserCheckEmail(Users users,String email,String type);
	
}
