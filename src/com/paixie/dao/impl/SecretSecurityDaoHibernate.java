package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.SecretSecurityDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.SecretSecurity;

@Repository("secretSecurityDao")
public class SecretSecurityDaoHibernate extends BaseHibernateDaoSupport implements SecretSecurityDao {

	/**
	 * 保存密码信息
	 * @param secretSecurity 密保信息
	 */
	public void save(SecretSecurity secretSecurity) {
		getHibernateTemplate().save(secretSecurity);
	}

	/**
	 * 根据用户编号获取密保
	 * @param userId 用户编号
	 * @return 该用户编号的密保
	 */
	@SuppressWarnings("unchecked")
	public List<SecretSecurity> getSecreteSecurityByUserId(String userId) {
		return (List<SecretSecurity>)getHibernateTemplate().find("From SecretSecurity as s where s.users.userId='"+userId+"'");
	}

	/**
	 * 根据编号获取密保
	 * @param secretId
	 * @return 指定编号的密保
	 */
	public SecretSecurity getSecretSecurityById(String secretId) {
		return getHibernateTemplate().get(SecretSecurity.class, secretId);
	}

}
