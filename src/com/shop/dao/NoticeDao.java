package com.shop.dao;

import java.util.List;

import com.shop.domain.Notice;

public interface NoticeDao {

	/**
	 * 根据类别获取公告、进行分页处理
	 * @param type 类别
	 * @param page 页码
	 * @return
	 */
	List<Notice> getNoticeByType(String type, int page);

	/**
	 * 获取指定类别的总量
	 * @param type
	 * @return
	 */
	long getNoticeCount(String type);

	/**
	 * 根据id删除公告
	 * @param noticeId 需要删除的公告id
	 */
	void delete(String noticeId);
	
	/**
	 * 根据id获取公告实例
	 * @param noticeId 公告id
	 */
	Notice get(String noticeId);

	/**
	 * 保存或者修改公告实例
	 * @param notice 需要保存或者修改的公告
	 */
	void saveOrUpdateNotice(Notice notice);
	
	/**
	 * 获取所有的公告
	 * @param page 指定页面
	 * @return
	 */
	List<Notice> getAllNotice(int page);

}
