package com.paixie.service;

import java.util.List;

import com.paixie.domain.Storage;

public interface StorageService {
	/**
	 * ��ȡ���еĲֿ�
	 */
	public List<Storage> getAllStorage();

	/**
	 * ���ݲֿ��š���ȡ�ֿ�ʵ��
	 * @param storageId �ֿ���
	 * @return
	 */
	public Storage getStorageById(String storageId);
}

