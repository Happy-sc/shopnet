package com.paixie.service;

import java.util.List;

import com.paixie.domain.PaixieBRecord;

public interface PaixieBService {

	/**
	 * ��ȡ�û�����Ь�Ҽ�¼
	 * @param userId �û����
	 * @param page ҳ��
	 * @param paixieBState ״̬
	 * @return
	 */
	List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState);

	/**
	 * ��ȡ�û���Ь�ҵ�������
	 * @param userId �û����
	 * @param paixieBState ״̬
	 * @return
	 */
	int getPaixieBSum(String userId, int paixieBState);

	/**
	 * �����û���Ь�Ҽ�¼
	 * @param paixieBRecord
	 */
	void savePaixieB(PaixieBRecord paixieBRecord);

}
