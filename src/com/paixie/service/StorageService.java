package com.paixie.service;

import java.util.List;

import com.paixie.domain.Storage;

public interface StorageService {
	/**
	 * 获取所有的仓库
	 */
	public List<Storage> getAllStorage();

	/**
	 * 根据仓库编号、获取仓库实例
	 * @param storageId 仓库编号
	 * @return
	 */
	public Storage getStorageById(String storageId);
}

