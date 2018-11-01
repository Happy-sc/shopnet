package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.PaixieBDao;
import com.shop.domain.PaixieBRecord;
import com.shop.service.PaixieBService;

@Service("paixieBService")
public class PaixieBServiceImpl implements PaixieBService {
	@Resource(name="paixieBDao")private PaixieBDao paixieBDao;
	
	/**
	 * 获取用户拍鞋币记录，并进行分页处理
	 * @param userId 用户编号
	 * @param page 页码
	 * @param paixieBState 拍鞋币状态
	 * @return 用户指定页码的拍鞋币记录
	 * 
	 */
	public List<PaixieBRecord> getUserPaixieB(String userId, int page,int paixieBState) {
		List<PaixieBRecord> paixieBRecords = paixieBDao.getUserPaixieB(userId,page,paixieBState);
		return paixieBRecords;
	}
	
	/**
	 * 获取用户拍鞋币总数量
	 * @param userId 用户编号
	 * @param paixieBState 拍鞋币状态
	 * @return 用户指定拍鞋币状态的总数量
	 */
	public int getPaixieBSum(String userId, int paixieBState) {
		List<PaixieBRecord> paixieBRecords = paixieBDao.getUserPaixieB(userId,paixieBState);
		return paixieBRecords.size();
	}

	/**
	 * 保存用户拍鞋币记录
	 * @param paixieBRecord 拍鞋币记录
	 * @return
	 */
	public void savePaixieB(PaixieBRecord paixieBRecord) {
		paixieBDao.save(paixieBRecord);
	}

}
