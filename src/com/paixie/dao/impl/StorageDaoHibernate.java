package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.StorageDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Storage;

@Repository("storageDao")
public class StorageDaoHibernate extends BaseHibernateDaoSupport implements
		StorageDao {

	/**
	 * ���ݱ�ʶ����ɾ��Storageʵ��
	 * @param storageId ��Ҫɾ����Storageʵ���ı�ʶ����ֵ
	 */
	public void delete(String storageId) {
		getHibernateTemplate().delete(get(storageId));
	}

	/**
	 * ɾ��Storageʵ��
	 * @param storage ��Ҫ��ɾ����Storageʵ��
	 */
	public void delete(Storage storage) {
		getHibernateTemplate().delete(storage);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡStorageʵ��
	 * @param storageId ��Ҫ��ȡ��Storageʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Storageʵ��
	 */
	public Storage get(String storageId) {
		return getHibernateTemplate().get(Storage.class, storageId);
	}

	/**
	 * ����Storageʵ��
	 * @param storage ��Ҫ�������Storageʵ��
	 */
	public void save(Storage storage) {
		getHibernateTemplate().save(storage);
	}

	/**
	 * �޸�Storageʵ��
	 * @param storage ��Ҫ���޸ĵ�Storageʵ��
	 */
	public void update(Storage storage) {
		getHibernateTemplate().update(storage);
	}

	/**
	 * ��ȡ���еĲֿ���Ϣ
	 * @return ���ݿ��д��ڵ����вֿ���Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<Storage> getAllStorage() {
		return (List<Storage>)getHibernateTemplate().find("from Storage");
	}

	/**
	 * ���ݲֿ����ƻ�ȡ�ֿ�ʵ��
	 * @param sotrageName �ֿ�����
	 * @return ָ���ֿ����ƵĲֿ�ʵ��
	 */
	@SuppressWarnings("unchecked")
	public Storage getStorageByName(String storageName) {
		List<Storage> storages  = (List<Storage>)getHibernateTemplate().find("from Storage as s where s.storageName=?",storageName);
		if(storages!=null&&storages.size()==1){
			return storages.get(0);
		}
		return null;
	}

}
