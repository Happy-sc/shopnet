package com.shop.service;

import java.util.List;

import com.shop.domain.JinBRecord;

public interface JinBService {

	/**
	 * 获取用户的金币记录
	 * @param userId 用户编号
	 * @param page 页码
	 * @param jinBState 状态
	 * @return
	 */
	List<JinBRecord> getUserJinB(String userId, int page, int jinBState);

	/**
	 * 获取用户金币的总数量
	 * @param userId 用户编号
	 * @param jinBState 状态
	 * @return
	 */
	int getJinBSum(String userId, int jinBState);

	/**
	 * 保存用户金币记录
	 * @param jinBRecord
	 */
	void saveJinB(JinBRecord jinBRecord);

}
