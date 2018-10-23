package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.NoticeDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Notice;

@Repository("noticeDao")
public class NoticeDaoHibernate extends BaseHibernateDaoSupport implements NoticeDao {

	/**
	 * ��������ȡ���桢���з�ҳ����
	 * @param type ���
	 * @param page ҳ��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Notice> getNoticeByType(String type, int page) {
		int offset = (page-1)*10;
		String hql = "from Notice n where n.noticeType=? order by n.noticeType desc";
		return findByPage(hql, type, offset, 10);
	}

	/**
	 * ��ȡָ����������
	 * @param type
	 * @return
	 */
	public long getNoticeCount(String type) {
		String hql = "select count(*) from Notice n where n.noticeType=?";
		return (Long) getHibernateTemplate().find(hql, type).get(0);

	}

	/**
	 * ����idɾ������
	 * @param noticeId ��Ҫɾ���Ĺ���id
	 */
	public void delete(String noticeId) {
		getHibernateTemplate().delete(get(noticeId));
	}

	/**
	 * ����id��ȡ����ʵ��
	 * @param noticeId ����id
	 */
	public Notice get(String noticeId) {
		return getHibernateTemplate().get(Notice.class, noticeId);
	}

	/**
	 * ��������޸Ĺ���ʵ��
	 * @param notice ��Ҫ��������޸ĵĹ���
	 */
	public void saveOrUpdateNotice(Notice notice) {
		getHibernateTemplate().saveOrUpdate(notice);
	}

	/**
	 * ��ȡ���еĹ���
	 * @param page ָ��ҳ��
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
