package com.shop.dao;

import java.util.List;

import com.shop.domain.SecretSecurity;

public interface SecretSecurityDao{

	/**
	 * 保存密保信息
	 * @param secretSecurity
	 */
	void save(SecretSecurity secretSecurity);

	/**
	 * 根据用户编号获取密保
	 * @param userId
	 * @return
	 */
	List<SecretSecurity> getSecreteSecurityByUserId(String userId);

	/**
	 * 根据编号获取密保实例
	 * @param secretId
	 * @return
	 */
	SecretSecurity getSecretSecurityById(String secretId);

}
