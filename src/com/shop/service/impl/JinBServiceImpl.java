package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.shop.service.JinBService;
import org.springframework.stereotype.Service;

import com.shop.dao.JinBDao;
import com.shop.domain.JinBRecord;

@Service("jinBService")
public class JinBServiceImpl implements JinBService {

	@Resource(name="jinBDao")
	private JinBDao paixieBDao;
	
	/**
	 * 获取用户金币记录，并进行分页处理
	 * @param userId 用户编号
	 * @param page 页码
	 * @param jinBState 金币状态
	 * @return 用户指定页码的金币记录
	 * 
	 */
	public List<JinBRecord> getUserJinB(String userId, int page, int jinBState) {
		return paixieBDao.getUserJinB(userId,page,jinBState);
	}
	
	/**
	 * 获取用户金币总数量
	 * @param userId 用户编号
	 * @param jinBState 金币状态
	 * @return 用户指定金币状态的总数量
	 */
	public int getJinBSum(String userId, int jinBState) {
		List<JinBRecord> paixieBRecords = paixieBDao.getUserJinB(userId,jinBState);
		return paixieBRecords.size();
	}

	/**
	 * 保存用户金币记录
	 * @param jinBRecord 金币记录
	 * @return
	 */
	public void saveJinB(JinBRecord jinBRecord) {
		paixieBDao.save(jinBRecord);
	}

}
