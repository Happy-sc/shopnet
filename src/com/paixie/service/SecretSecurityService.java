package com.paixie.service;

import java.util.List;

import com.paixie.domain.SecretSecurity;

public interface SecretSecurityService {

	/**
	 * �����ܱ���Ϣ
	 * @param secretSecurity �ܱ�
	 */
	void saveSecret(SecretSecurity secretSecurity);

	/**
	 * ��ȡ���û����ܱ�
	 * @param userId �û����
	 * @return
	 */
	List<SecretSecurity> getSecreteSecurityByUserId(String userId);

	/**
	 * �����ܱ���Ż�ȡ�ܱ�
	 * @param secretId �ܱ����
	 * @return
	 */
	SecretSecurity getSecretSecurityById(String secretId);

}
