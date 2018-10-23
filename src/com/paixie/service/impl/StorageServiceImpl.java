package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.StorageDao;
import com.paixie.domain.Storage;
import com.paixie.service.StorageService;

@Service("storageService")
public class StorageServiceImpl implements StorageService{
	@Resource(name="storageDao")private StorageDao storageDao;
	/**
	 * 获取所有的仓库
	 */
	public List<Storage> getAllStorage() {
		return storageDao.getAllStorage();
	}
	
	/**
	 * 根据仓库编号、获取仓库实例
	 * @param storageId 仓库编号
	 * @return
	 */
	public Storage getStorageById(String storageId) {
		return storageDao.get(storageId);

	}

}

