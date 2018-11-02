package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.JinBDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.JinBRecord;

@Repository("jinBDao")
public class JinBDaoHibernate extends BaseHibernateDaoSupport implements JinBDao {

	/**
	 * 获取用户金币记录，并进行分页处理
	 * @param userId 用户编号
	 * @param page 页码
	 * @return 用户指定页码的金币记录
	 */
	@SuppressWarnings("unchecked")
	public List<JinBRecord> getUserJinB(String userId, int page, int jinBState) {
		String hql = "From JinBRecord as p where p.users.userId=? and p.jinBState=? order by p.jinBTime desc";
		int offset = (page-1)*10;
		Object[] values = {userId,jinBState};
		return findByPage(hql, values, offset, 10);
	}

	/**
	 * 获取用户金币总数量
	 * @param userId 用户编号
	 * @param jinBState 金币状态
	 * @return 用户指定金币状态的总数量
	 */
	@SuppressWarnings("unchecked")
	public List<JinBRecord> getUserJinB(String userId, int jinBState) {
		String hql = "From JinBRecord as p where p.users.userId=? and p.jinBState=?";
		List<JinBRecord> paixieBRecords = getHibernateTemplate().find(hql,userId,jinBState);
		return paixieBRecords;
	}

	/**
	 * 保存用户金币记录
	 * @param jinBRecord 金币记录
	 * @return
	 */
	public void save(JinBRecord jinBRecord) {
		getHibernateTemplate().save(jinBRecord);
	}

}
