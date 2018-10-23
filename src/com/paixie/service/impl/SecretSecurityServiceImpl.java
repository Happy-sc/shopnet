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
	 * 保存密保信息
	 * @param secretSecurity 密保
	 * @return
	 */
	public void saveSecret(SecretSecurity secretSecurity) {
		secretSecurityDao.save(secretSecurity);
	}
	
	/**
	 * 根据用户编号获取密保
	 * @param userId 用户编号
	 * @return 该用户编号的密保
	 */
	public List<SecretSecurity> getSecreteSecurityByUserId(String userId) {
		return secretSecurityDao.getSecreteSecurityByUserId(userId);
	}

	/**
	 * 根据编号获取密保
	 * @param secretId
	 * @return 指定编号的密保
	 */
	public SecretSecurity getSecretSecurityById(String secretId) {
		return secretSecurityDao.getSecretSecurityById(secretId);
	}

}
