package com.shop.service;

import java.util.List;

import com.shop.domain.PaixieBRecord;

public interface PaixieBService {

	/**
	 * 获取用户的拍鞋币记录
	 * @param userId 用户编号
	 * @param page 页码
	 * @param paixieBState 状态
	 * @return
	 */
	List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState);

	/**
	 * 获取用户拍鞋币的总数量
	 * @param userId 用户编号
	 * @param paixieBState 状态
	 * @return
	 */
	int getPaixieBSum(String userId, int paixieBState);

	/**
	 * 保存用户拍鞋币记录
	 * @param paixieBRecord
	 */
	void savePaixieB(PaixieBRecord paixieBRecord);

}
