package com.shop.service.impl;

import org.springframework.stereotype.Service;

import com.shop.common.GetTime;
import com.shop.common.ProduceId;
import com.shop.domain.Users;
import com.shop.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	/**
	 * 设置用户验证时的邮箱信息
	 * @param users 用户
	 * @param email 邮箱
	 * @param type 类型
	 * @return 设置好信息的用户
	 */
	public Users setUserCheckEmail(Users users,String email,String type) {
		String random = ProduceId.getRandom();
		users.setUserEmail(email);             //设置用户邮箱
		users.setCheckCode(random);            //邮箱验证码
		users.setEmailDate(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));    //邮箱验证时间:只需要精确到小时
		//验证
		if("regist".equals(type)){
			users.setIsActivate(0);
		}
	
		return users;
	}

}
