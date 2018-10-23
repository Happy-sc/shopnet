package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.NoticeDao;
import com.paixie.domain.Notice;
import com.paixie.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	@Resource(name="noticeDao")private NoticeDao noticeDao;
	
	/**
	 * ��������ȡ���桢���з�ҳ����
	 * @param type ���
	 * @param page ҳ��
	 * @return
	 */
	public List<Notice> getNoticebyType(String type, int page) {
		List<Notice> notices = noticeDao.getNoticeByType(type,page);
		
		return notices;
	}

	/**
	 * ��ȡָ����������
	 * @param type
	 * @return
	 */
	public long getNoticeCount(String type){
		long pages = noticeDao.getNoticeCount(type);
		return pages;
	}

	/**
	 * ��ȡָ�����ҳ������
	 * @param type ���
	 * @return
	 */
	public int getNoticPageSum(String type){
		long pageS = getNoticeCount(type);
		int pageSum = (int) (pageS%10==0?pageS/10:pageS/10+1);
		return pageSum;
	}

	/**
	 * ��������м򵥵Ĵ���
	 * @param notices  ��Ҫ����Ĺ���
	 * @return
	 */
	public List<Notice> dealNotice(List<Notice> notices) {
		for(int i = 0;i < notices.size();i++){
			Notice notice = notices.get(i);
			//����notice
			String noticeTitle = notice.getNoticeTitle();
			if(noticeTitle.length()>10){
				noticeTitle = noticeTitle.subSequence(0, 10)+"...";
			}
			notice.setNoticeTitle(noticeTitle);
		}
		return notices;
	}

	/**
	 * ����idɾ������
	 * @param noticeId ��Ҫɾ���Ĺ���id
	 */
	public void deleteNotice(String noticeId) {
		noticeDao.delete(noticeId);
	}

	/**
	 * ��������޸Ĺ���ʵ��
	 * @param notice ��Ҫ��������޸ĵĹ���
	 */
	public void saveOrUpdateNotice(Notice notice) {
		noticeDao.saveOrUpdateNotice(notice);
	}

	/**
	 * ��ȡ���еĹ���
	 * @param page ָ��ҳ��
	 * @return
	 */
	public List<Notice> getAllNoticee(int page) {
		List<Notice> notices = noticeDao.getAllNotice(page);
		return notices;
	}

	/**
	 * ���ݹ����Ż�ȡ����ʵ��
	 * @param noticeId ������
	 * @return
	 */
	public Notice getNoticeById(String noticeId) {
		return noticeDao.get(noticeId);
	}


}
