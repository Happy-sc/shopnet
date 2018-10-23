package com.paixie.dao;

import java.util.List;

import com.paixie.domain.SecretSecurity;

public interface SecretSecurityDao{

	/**
	 * �����ܱ���Ϣ
	 * @param secretSecurity
	 */
	void save(SecretSecurity secretSecurity);

	/**
	 * �����û���Ż�ȡ�ܱ�
	 * @param userId
	 * @return
	 */
	List<SecretSecurity> getSecreteSecurityByUserId(String userId);

	/**
	 * ���ݱ�Ż�ȡ�ܱ�ʵ��
	 * @param secretId
	 * @return
	 */
	SecretSecurity getSecretSecurityById(String secretId);

}
