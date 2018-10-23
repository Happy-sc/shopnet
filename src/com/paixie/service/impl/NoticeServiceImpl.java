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
	 * 根据类别获取公告、进行分页处理
	 * @param type 类别
	 * @param page 页码
	 * @return
	 */
	public List<Notice> getNoticebyType(String type, int page) {
		List<Notice> notices = noticeDao.getNoticeByType(type,page);
		
		return notices;
	}

	/**
	 * 获取指定类别的总量
	 * @param type
	 * @return
	 */
	public long getNoticeCount(String type){
		long pages = noticeDao.getNoticeCount(type);
		return pages;
	}

	/**
	 * 获取指定类别页面总数
	 * @param type 类别
	 * @return
	 */
	public int getNoticPageSum(String type){
		long pageS = getNoticeCount(type);
		int pageSum = (int) (pageS%10==0?pageS/10:pageS/10+1);
		return pageSum;
	}

	/**
	 * 将公告进行简单的处理
	 * @param notices  需要处理的公告
	 * @return
	 */
	public List<Notice> dealNotice(List<Notice> notices) {
		for(int i = 0;i < notices.size();i++){
			Notice notice = notices.get(i);
			//处理notice
			String noticeTitle = notice.getNoticeTitle();
			if(noticeTitle.length()>10){
				noticeTitle = noticeTitle.subSequence(0, 10)+"...";
			}
			notice.setNoticeTitle(noticeTitle);
		}
		return notices;
	}

	/**
	 * 根据id删除公告
	 * @param noticeId 需要删除的公告id
	 */
	public void deleteNotice(String noticeId) {
		noticeDao.delete(noticeId);
	}

	/**
	 * 保存或者修改公告实例
	 * @param notice 需要保存或者修改的公告
	 */
	public void saveOrUpdateNotice(Notice notice) {
		noticeDao.saveOrUpdateNotice(notice);
	}

	/**
	 * 获取所有的公告
	 * @param page 指定页面
	 * @return
	 */
	public List<Notice> getAllNoticee(int page) {
		List<Notice> notices = noticeDao.getAllNotice(page);
		return notices;
	}

	/**
	 * 根据公告编号获取公告实例
	 * @param noticeId 公告编号
	 * @return
	 */
	public Notice getNoticeById(String noticeId) {
		return noticeDao.get(noticeId);
	}


}
