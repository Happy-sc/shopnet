package com.paixie.service;

import com.paixie.domain.Users;

public interface EmailService {
	
	/**
	 * �����û���֤ʱ��������Ϣ
	 * @param users �û�
	 * @param email ����
	 * @param type ����
	 * @return ���ú���Ϣ���û�
	 */
	public Users setUserCheckEmail(Users users,String email,String type);
	
}
