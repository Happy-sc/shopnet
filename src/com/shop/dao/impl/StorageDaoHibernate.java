package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.StorageDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Storage;

@Repository("storageDao")
public class StorageDaoHibernate extends BaseHibernateDaoSupport implements
		StorageDao {

	/**
	 * 根据标识属性删除Storage实例
	 * @param storageId 需要删除的Storage实例的标识属性值
	 */
	public void delete(String storageId) {
		getHibernateTemplate().delete(get(storageId));
	}

	/**
	 * 删除Storage实例
	 * @param storage 需要被删除的Storage实例
	 */
	public void delete(Storage storage) {
		getHibernateTemplate().delete(storage);
	}

	/**
	 * 根据标识属性获取Storage实例
	 * @param storageId 需要获取的Storage实例的标识属性值
	 * @return 指定标识属性值的Storage实例
	 */
	public Storage get(String storageId) {
		return getHibernateTemplate().get(Storage.class, storageId);
	}

	/**
	 * 保存Storage实例
	 * @param storage 需要被保存的Storage实例
	 */
	public void save(Storage storage) {
		getHibernateTemplate().save(storage);
	}

	/**
	 * 修改Storage实例
	 * @param storage 需要被修改的Storage实例
	 */
	public void update(Storage storage) {
		getHibernateTemplate().update(storage);
	}

	/**
	 * 获取所有的仓库信息
	 * @return 数据库中存在的所有仓库信息
	 */
	@SuppressWarnings("unchecked")
	public List<Storage> getAllStorage() {
		return (List<Storage>)getHibernateTemplate().find("from Storage");
	}

	/**
	 * 根据仓库名称获取仓库实例
	 * @param sotrageName 仓库名称
	 * @return 指定仓库名称的仓库实例
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
