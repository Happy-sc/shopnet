package com.paixie.service.impl;

import org.springframework.stereotype.Service;

import com.paixie.common.GetTime;
import com.paixie.common.ProduceId;
import com.paixie.domain.Users;
import com.paixie.service.EmailService;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	/**
	 * �����û���֤ʱ��������Ϣ
	 * @param users �û�
	 * @param email ����
	 * @param type ����
	 * @return ���ú���Ϣ���û�
	 */
	public Users setUserCheckEmail(Users users,String email,String type) {
		String random = ProduceId.getRandom();
		users.setUserEmail(email);             //�����û�����
		users.setCheckCode(random);            //������֤��
		users.setEmailDate(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));    //������֤ʱ��:ֻ��Ҫ��ȷ��Сʱ
		//��֤
		if("regist".equals(type)){
			users.setIsActivate(0);
		}
	
		return users;
	}

}
