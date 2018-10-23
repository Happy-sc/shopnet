package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.SecretSecurityDao;
import com.paixie.domain.SecretSecurity;
import com.paixie.service.SecretSecurityService;

@Service("secretSecurityService")
public class SecretSecurityServiceImpl implements SecretSecurityService{
	@Resource(name="secretSecurityDao")SecretSecurityDao secretSecurityDao;
	/**
	 * �����ܱ���Ϣ
	 * @param secretSecurity �ܱ�
	 * @return
	 */
	public void saveSecret(SecretSecurity secretSecurity) {
		secretSecurityDao.save(secretSecurity);
	}
	
	/**
	 * �����û���Ż�ȡ�ܱ�
	 * @param userId �û����
	 * @return ���û���ŵ��ܱ�
	 */
	public List<SecretSecurity> getSecreteSecurityByUserId(String userId) {
		return secretSecurityDao.getSecreteSecurityByUserId(userId);
	}

	/**
	 * ���ݱ�Ż�ȡ�ܱ�
	 * @param secretId
	 * @return ָ����ŵ��ܱ�
	 */
	public SecretSecurity getSecretSecurityById(String secretId) {
		return secretSecurityDao.getSecretSecurityById(secretId);
	}

}
