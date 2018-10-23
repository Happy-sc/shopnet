package com.paixie.service;

import com.paixie.domain.Users;

public interface UsersService {

	/**
	 * �����û�����ȡ�û�ʵ��
	 * @param userName �û���
	 * @return
	 */
	Users getUserByUserName(String userName);

	/**
	 * ���������ȡ�û�ʵ��
	 * @param email ����
	 * @return
	 */
	Users getUserByEmail(String email);

	/**
	 * �û�ע��
	 * @param users ��Ҫ������û�
	 */
	void registUsers(Users users);

	/**
	 * �û���¼
	 * @param userName �û���
	 * @param password �û�����
	 * @param type ���ͣ��ʼ����û���
	 * @return
	 */
	Users userLogin(String userName,String password,String type);

	/**
	 * �����û���Ż�ȡ�û�ʵ��
	 * @param userid �û����
	 * @return
	 */
	Users getUserById(String userid);

	/**
	 * �޸��û�ʵ��
	 * @param user ��Ҫ���޸ĵ��û�ʵ��
	 */
	void updateUser(Users user);
}
