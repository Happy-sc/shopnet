package com.shop.service;

import java.util.List;

import com.shop.domain.SecretSecurity;

public interface SecretSecurityService {

	/**
	 * 保存密保信息
	 * @param secretSecurity 密保
	 */
	void saveSecret(SecretSecurity secretSecurity);

	/**
	 * 获取该用户的密保
	 * @param userId 用户编号
	 * @return
	 */
	List<SecretSecurity> getSecreteSecurityByUserId(String userId);

	/**
	 * 根据密保编号获取密保
	 * @param secretId 密保编号
	 * @return
	 */
	SecretSecurity getSecretSecurityById(String secretId);

}
