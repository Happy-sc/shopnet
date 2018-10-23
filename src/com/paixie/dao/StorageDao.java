package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Storage;

public interface StorageDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡStorageʵ��
	 * @param storageId �ֿ���
	 * @return
	 */
	Storage get(String storageId);
	
	/**
	 * ����Storageʵ��
	 * @param storage
	 */
	void save(Storage storage);
	
	/**
	 * ���ݱ�ʶ����ɾ��Storageʵ��
	 * @param storageId
	 */
	void delete(String storageId);
	
	/**
	 * ɾ��Storageʵ��
	 * @param storage
	 */
	void delete(Storage storage);
	
	/**
	 * �޸�Storageʵ��
	 * @param storage
	 */
	void update(Storage storage);

	/**
	 * ��ȡ���еĲֿ�
	 * @return
	 */
	List<Storage> getAllStorage();

	/**
	 * ���ݲֿ����ƻ�ȡ�ֿ�ʵ��
	 * @param storageName
	 * @return
	 */
	Storage getStorageByName(String storageName);
}
