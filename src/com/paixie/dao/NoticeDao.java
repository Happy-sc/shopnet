package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Notice;

public interface NoticeDao {

	/**
	 * ��������ȡ���桢���з�ҳ����
	 * @param type ���
	 * @param page ҳ��
	 * @return
	 */
	List<Notice> getNoticeByType(String type, int page);

	/**
	 * ��ȡָ����������
	 * @param type
	 * @return
	 */
	long getNoticeCount(String type);

	/**
	 * ����idɾ������
	 * @param noticeId ��Ҫɾ���Ĺ���id
	 */
	void delete(String noticeId);
	
	/**
	 * ����id��ȡ����ʵ��
	 * @param noticeId ����id
	 */
	Notice get(String noticeId);

	/**
	 * ��������޸Ĺ���ʵ��
	 * @param notice ��Ҫ��������޸ĵĹ���
	 */
	void saveOrUpdateNotice(Notice notice);
	
	/**
	 * ��ȡ���еĹ���
	 * @param page ָ��ҳ��
	 * @return
	 */
	List<Notice> getAllNotice(int page);

}
