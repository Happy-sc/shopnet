package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.PaixieBDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.PaixieBRecord;

@Repository("paixieBDao")
public class PaixieBDaoHibernate extends BaseHibernateDaoSupport implements
		PaixieBDao {

	/**
	 * ��ȡ�û���Ь�Ҽ�¼�������з�ҳ����
	 * @param userId �û����
	 * @param page ҳ��
	 * @return �û�ָ��ҳ�����Ь�Ҽ�¼
	 */
	@SuppressWarnings("unchecked")
	public List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState) {
		String hql = "From PaixieBRecord as p where p.users.userId=? and p.paixieBState=? order by p.paixieBTime desc";
		int offset = (page-1)*10;
		Object[] values = {userId,paixieBState};
		List<PaixieBRecord> paixieBRecords = findByPage(hql, values, offset, 10);
		return paixieBRecords;
	}

	/**
	 * ��ȡ�û���Ь��������
	 * @param userId �û����
	 * @param paixieBState ��Ь��״̬
	 * @return �û�ָ����Ь��״̬��������
	 */
	@SuppressWarnings("unchecked")
	public List<PaixieBRecord> getUserPaixieB(String userId, int paixieBState) {
		String hql = "From PaixieBRecord as p where p.users.userId=? and p.paixieBState=?";
		List<PaixieBRecord> paixieBRecords = getHibernateTemplate().find(hql,userId,paixieBState);
		return paixieBRecords;
	}

	/**
	 * �����û���Ь�Ҽ�¼
	 * @param paixieBRecord ��Ь�Ҽ�¼
	 * @return
	 */
	public void save(PaixieBRecord paixieBRecord) {
		getHibernateTemplate().save(paixieBRecord);
	}

}
