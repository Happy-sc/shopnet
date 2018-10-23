package com.paixie.dao;

import java.util.List;

import com.paixie.domain.PaixieBRecord;

public interface PaixieBDao {

	/**
	 * ��ȡ�û���Ь�Ҽ�¼
	 * @param userId
	 * @param page
	 * @param paixieBState
	 * @return
	 */
	List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState);

	/**
	 * ��ȡ�û���Ь��������
	 * @param userId
	 * @param paixieBState
	 * @return
	 */
	List<PaixieBRecord> getUserPaixieB(String userId, int paixieBState);

	/**
	 * ������Ь�Ҽ�¼
	 * @param paixieBRecord
	 */
	void save(PaixieBRecord paixieBRecord);

}
