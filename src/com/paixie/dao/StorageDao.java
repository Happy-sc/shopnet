package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Storage;

public interface StorageDao {
	/**
	 * 根据标识属性获取Storage实例
	 * @param storageId 仓库编号
	 * @return
	 */
	Storage get(String storageId);
	
	/**
	 * 保存Storage实例
	 * @param storage
	 */
	void save(Storage storage);
	
	/**
	 * 根据标识属性删除Storage实例
	 * @param storageId
	 */
	void delete(String storageId);
	
	/**
	 * 删除Storage实例
	 * @param storage
	 */
	void delete(Storage storage);
	
	/**
	 * 修改Storage实例
	 * @param storage
	 */
	void update(Storage storage);

	/**
	 * 获取所有的仓库
	 * @return
	 */
	List<Storage> getAllStorage();

	/**
	 * 根据仓库名称获取仓库实例
	 * @param storageName
	 * @return
	 */
	Storage getStorageByName(String storageName);
}
