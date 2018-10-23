package com.paixie.service;

import java.util.List;

import com.paixie.domain.Notice;

public interface NoticeService {
	/**
	 * ��������ȡ���桢���з�ҳ����
	 * @param type ���
	 * @param page ҳ��
	 * @return
	 */
	List<Notice> getNoticebyType(String string, int page);

	/**
	 * ��ȡָ����������
	 * @param type
	 * @return
	 */
	long getNoticeCount(String type);

	/**
	 * ��ȡָ�����ҳ������
	 * @param type ���
	 * @return
	 */
	int getNoticPageSum(String string);

	/**
	 * ��������м򵥵Ĵ���
	 * @param notices  ��Ҫ����Ĺ���
	 * @return
	 */
	List<Notice> dealNotice(List<Notice> notices);

	/**
	 * ����idɾ������
	 * @param noticeId ��Ҫɾ���Ĺ���id
	 */
	void deleteNotice(String noticeId);

	/**
	 * ��������޸Ĺ���ʵ��
	 * @param notice ��Ҫ��������޸ĵĹ���
	 */
	void saveOrUpdateNotice(Notice notice);

	/**
	 * ��ȡָ��ҳ�����еĹ���
	 * @param page ָ��ҳ��
	 * @return
	 */
	List<Notice> getAllNoticee(int page);

	/**
	 * ���ݹ����Ż�ȡ����ʵ��
	 * @param noticeId ������
	 * @return
	 */
	Notice getNoticeById(String noticeId);

}
