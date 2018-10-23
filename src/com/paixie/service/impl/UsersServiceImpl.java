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
	 * �����û�����ȡ�û�
	 * @param userName �û���
	 * @return ָ���û������û�ʵ��
	 */
	public Users getUserByUserName(String userName) {
		return usersDao.getUsersByUserName(userName);
	}
	
	/**
	 * �����û������ȡ�û�
	 * @param email �û�����
	 * @return ָ��������û�ʵ��
	 */
	public Users getUserByEmail(String email) {
		return usersDao.getUsersByEmail(email);
	}

	/**
	 * �û�ע��
	 * @param users ��Ҫע����û�ʵ��
	 * @return
	 */
	public void registUsers(Users users) {
		usersDao.save(users);
	}

	/**
	 * �û���¼
	 * @param userName ��¼�û���
	 * @param password ��¼����
	 * @param type ����������仹���û���
	 * @return ָ���û���/�����������û�
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
	 * �����û���Ż�ȡ�û�ʵ��
	 * @param userid �û����
	 * @return �ñ�ŵ��û�ʵ��
	 */
	public Users getUserById(String userid) {
		return usersDao.get(userid);
	}

	/**
	 * �޸��û�ʵ��
	 * @param user ��Ҫ�޸ĵ��û�
	 * @return
	 */
	public void updateUser(Users user) {
		usersDao.update(user);
	}
}
