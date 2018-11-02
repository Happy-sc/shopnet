package com.shop.dao;

import java.util.List;

import com.shop.domain.JinBRecord;

public interface JinBDao {

	/**
	 * 获取用户金币记录
	 * @param userId
	 * @param page
	 * @param jinBState
	 * @return
	 */
	List<JinBRecord> getUserJinB(String userId, int page, int jinBState);

	/**
	 * 获取用户金币总数量
	 * @param userId
	 * @param jinBState
	 * @return
	 */
	List<JinBRecord> getUserJinB(String userId, int jinBState);

	/**
	 * 保存金币记录
	 * @param jinBRecord
	 */
	void save(JinBRecord jinBRecord);

}
