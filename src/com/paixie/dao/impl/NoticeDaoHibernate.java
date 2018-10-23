package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.NoticeDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Notice;

@Repository("noticeDao")
public class NoticeDaoHibernate extends BaseHibernateDaoSupport implements NoticeDao {

	/**
	 * 根据类别获取公告、进行分页处理
	 * @param type 类别
	 * @param page 页码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Notice> getNoticeByType(String type, int page) {
		int offset = (page-1)*10;
		String hql = "from Notice n where n.noticeType=? order by n.noticeType desc";
		return findByPage(hql, type, offset, 10);
	}

	/**
	 * 获取指定类别的总量
	 * @param type
	 * @return
	 */
	public long getNoticeCount(String type) {
		String hql = "select count(*) from Notice n where n.noticeType=?";
		return (Long) getHibernateTemplate().find(hql, type).get(0);

	}

	/**
	 * 根据id删除公告
	 * @param noticeId 需要删除的公告id
	 */
	public void delete(String noticeId) {
		getHibernateTemplate().delete(get(noticeId));
	}

	/**
	 * 根据id获取公告实例
	 * @param noticeId 公告id
	 */
	public Notice get(String noticeId) {
		return getHibernateTemplate().get(Notice.class, noticeId);
	}

	/**
	 * 保存或者修改公告实例
	 * @param notice 需要保存或者修改的公告
	 */
	public void saveOrUpdateNotice(Notice notice) {
		getHibernateTemplate().saveOrUpdate(notice);
	}

	/**
	 * 获取所有的公告
	 * @param page 指定页面
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Notice> getAllNotice(int page) {
		int offset = (page-1)*10;
		String hql = "from Notice n order by n.noticeType desc";
		List<Notice> notices = findByPage(hql, offset, 10);
		return notices;
	}
}
