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
	 * 获取用户拍鞋币记录，并进行分页处理
	 * @param userId 用户编号
	 * @param page 页码
	 * @return 用户指定页码的拍鞋币记录
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
	 * 获取用户拍鞋币总数量
	 * @param userId 用户编号
	 * @param paixieBState 拍鞋币状态
	 * @return 用户指定拍鞋币状态的总数量
	 */
	@SuppressWarnings("unchecked")
	public List<PaixieBRecord> getUserPaixieB(String userId, int paixieBState) {
		String hql = "From PaixieBRecord as p where p.users.userId=? and p.paixieBState=?";
		List<PaixieBRecord> paixieBRecords = getHibernateTemplate().find(hql,userId,paixieBState);
		return paixieBRecords;
	}

	/**
	 * 保存用户拍鞋币记录
	 * @param paixieBRecord 拍鞋币记录
	 * @return
	 */
	public void save(PaixieBRecord paixieBRecord) {
		getHibernateTemplate().save(paixieBRecord);
	}

}
