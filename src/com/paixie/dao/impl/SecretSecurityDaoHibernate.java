package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.SecretSecurityDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.SecretSecurity;

@Repository("secretSecurityDao")
public class SecretSecurityDaoHibernate extends BaseHibernateDaoSupport implements SecretSecurityDao {

	/**
	 * ����������Ϣ
	 * @param secretSecurity �ܱ���Ϣ
	 */
	public void save(SecretSecurity secretSecurity) {
		getHibernateTemplate().save(secretSecurity);
	}

	/**
	 * �����û���Ż�ȡ�ܱ�
	 * @param userId �û����
	 * @return ���û���ŵ��ܱ�
	 */
	@SuppressWarnings("unchecked")
	public List<SecretSecurity> getSecreteSecurityByUserId(String userId) {
		return (List<SecretSecurity>)getHibernateTemplate().find("From SecretSecurity as s where s.users.userId='"+userId+"'");
	}

	/**
	 * ���ݱ�Ż�ȡ�ܱ�
	 * @param secretId
	 * @return ָ����ŵ��ܱ�
	 */
	public SecretSecurity getSecretSecurityById(String secretId) {
		return getHibernateTemplate().get(SecretSecurity.class, secretId);
	}

}
