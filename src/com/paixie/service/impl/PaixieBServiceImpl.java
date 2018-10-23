package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.PaixieBDao;
import com.paixie.domain.PaixieBRecord;
import com.paixie.service.PaixieBService;

@Service("paixieBService")
public class PaixieBServiceImpl implements PaixieBService {
	@Resource(name="paixieBDao")private PaixieBDao paixieBDao;
	
	/**
	 * ��ȡ�û���Ь�Ҽ�¼�������з�ҳ����
	 * @param userId �û����
	 * @param page ҳ��
	 * @param paixieBState ��Ь��״̬
	 * @return �û�ָ��ҳ�����Ь�Ҽ�¼
	 * 
	 */
	public List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState) {
		List<PaixieBRecord> paixieBRecords = paixieBDao.getUserPaixieB(userId,page,paixieBState);
		return paixieBRecords;
	}
	
	/**
	 * ��ȡ�û���Ь��������
	 * @param userId �û����
	 * @param paixieBState ��Ь��״̬
	 * @return �û�ָ����Ь��״̬��������
	 */
	public int getPaixieBSum(String userId, int paixieBState) {
		List<PaixieBRecord> paixieBRecords = paixieBDao.getUserPaixieB(userId,paixieBState);
		return paixieBRecords.size();
	}

	/**
	 * �����û���Ь�Ҽ�¼
	 * @param paixieBRecord ��Ь�Ҽ�¼
	 * @return
	 */
	public void savePaixieB(PaixieBRecord paixieBRecord) {
		paixieBDao.save(paixieBRecord);
	}

}
