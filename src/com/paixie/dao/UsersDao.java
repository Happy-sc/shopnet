package com.paixie.dao;

import com.paixie.domain.Users;

public interface UsersDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡUsersʵ��
	 * @param userid
	 * @return
	 */
	Users get(String userid);
	
	/**
	 * ����Usersʵ��
	 * @param users
	 */
	void save(Users users);
	
	/**
	 * ���ݱ�ʶ����ɾ��Usersʵ��
	 * @param userId
	 */
	void delete(String userId);
	
	/**
	 * ɾ��Usersʵ��
	 * @param users
	 */
	void delete(Users users);
	
	/**
	 * �޸�Usersʵ��
	 * @param users
	 */
	void update(Users users);
	/**
	 * �����û���ѯ�û�
	 * @param userName
	 * @return
	 */
	Users getUsersByUserName(String userName);
	
	/**
	 * ���������ѯ�û�
	 * @param email
	 * @return
	 */
	Users getUsersByEmail(String email);
	
	/**
	 * �����û�������������û�
	 * @param userName
	 * @param password
	 * @return
	 */
	Users getUsersByUserNameAndPassword(String userName,String password);
	
	/**
	 * �������䡢��������û�
	 * @param email
	 * @param password
	 * @return
	 */
	Users getUsersByEmailAndPassword(String email,String password);
}
