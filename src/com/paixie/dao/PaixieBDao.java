package com.paixie.dao;

import java.util.List;

import com.paixie.domain.PaixieBRecord;

public interface PaixieBDao {

	/**
	 * 获取用户拍鞋币记录
	 * @param userId
	 * @param page
	 * @param paixieBState
	 * @return
	 */
	List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState);

	/**
	 * 获取用户拍鞋币总数量
	 * @param userId
	 * @param paixieBState
	 * @return
	 */
	List<PaixieBRecord> getUserPaixieB(String userId, int paixieBState);

	/**
	 * 保存拍鞋币记录
	 * @param paixieBRecord
	 */
	void save(PaixieBRecord paixieBRecord);

}
