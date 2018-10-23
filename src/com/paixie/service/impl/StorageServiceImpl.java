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
	 * ��ȡ���еĲֿ�
	 */
	public List<Storage> getAllStorage() {
		return storageDao.getAllStorage();
	}
	
	/**
	 * ���ݲֿ��š���ȡ�ֿ�ʵ��
	 * @param storageId �ֿ���
	 * @return
	 */
	public Storage getStorageById(String storageId) {
		return storageDao.get(storageId);

	}

}

