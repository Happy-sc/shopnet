package com.paixie.service;

import java.util.List;

import com.paixie.domain.Notice;

public interface NoticeService {
	/**
	 * 根据类别获取公告、进行分页处理
	 * @param type 类别
	 * @param page 页码
	 * @return
	 */
	List<Notice> getNoticebyType(String string, int page);

	/**
	 * 获取指定类别的总量
	 * @param type
	 * @return
	 */
	long getNoticeCount(String type);

	/**
	 * 获取指定类别页面总数
	 * @param type 类别
	 * @return
	 */
	int getNoticPageSum(String string);

	/**
	 * 将公告进行简单的处理
	 * @param notices  需要处理的公告
	 * @return
	 */
	List<Notice> dealNotice(List<Notice> notices);

	/**
	 * 根据id删除公告
	 * @param noticeId 需要删除的公告id
	 */
	void deleteNotice(String noticeId);

	/**
	 * 保存或者修改公告实例
	 * @param notice 需要保存或者修改的公告
	 */
	void saveOrUpdateNotice(Notice notice);

	/**
	 * 获取指定页面所有的公告
	 * @param page 指定页面
	 * @return
	 */
	List<Notice> getAllNoticee(int page);

	/**
	 * 根据公告编号获取公告实例
	 * @param noticeId 公告编号
	 * @return
	 */
	Notice getNoticeById(String noticeId);

}
