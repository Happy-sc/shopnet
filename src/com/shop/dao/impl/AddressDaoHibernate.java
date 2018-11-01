package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.AddressDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Address;

@Repository("addressDao")
public class AddressDaoHibernate extends BaseHibernateDaoSupport implements AddressDao {

	/**
	 * 根据标识属性删除Address实体
	 * @param addressId 需要删除的Address实体的标识属性值
	 */
	public void delete(String addressId) {
		getHibernateTemplate().delete(get(addressId));
	}

	/**
	 * 删除指定的Address实体
	 * @param address 需要被删除的Address实体
	 */
	public void delete(Address address) {
		getHibernateTemplate().delete(address);
	}

	/**
	 * 根据标识属性获取Address实体
	 * @param addressId 需要获取Address实体的标识属性值
	 * @return 指定标识属性值的Address实体
	 */
	public Address get(String addressId) {
		return getHibernateTemplate().get(Address.class, addressId);
	}

	/**
	 * 获取全部的Address实体
	 * @return 数据库中全部的Address实体
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getAllAddress() {
		return (List<Address>)getHibernateTemplate().find("from Address");
	}

	/**
	 * 保存Address实体
	 * @param address 需要保存的address实体
	 */
	public void save(Address address) {
		getHibernateTemplate().save(address);
	}

	/**
	 * 修改Address实体
	 * @param
	 */
	public void update(Address address) {
		getHibernateTemplate().update(address);
	}

	/**
	 *获取用户的收货地址
	 *@param userId 用户编号
	 *@return 指定用户的收货地址
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getAddressByUser(String userId) {
		return (List<Address>)getHibernateTemplate().find("From Address as a where a.users.userId='"+userId+"'");
	}

	/**
	 * 获取用户的默认地址
	 * @param userId 用户的编号
	 * @return 指定用户的默认地址
	 */
	@SuppressWarnings("unchecked")
	public Address getUserDefaultAddress(String userId) {
		List<Address> addresses = (List<Address>) getHibernateTemplate().find("From Address as a where a.users.userId=? and a.isDefault=?",userId,1);
		if(addresses!=null&&addresses.size()!=0){
			return addresses.get(0);
		}
		return null;
	}

	/**
	 * 根据地址编号获取地址
	 * @param addressId 地址编号
	 * @return 指定地址编号的地址
	 */
	public Address getAddressById(String addressId) {
		return getHibernateTemplate().get(Address.class, addressId);
	}

	/**
	 * 保存或者修改地址
	 * @param address 需要保存或者需该的地址
	 * @return
	 */
	public void saveOrUpdateAddress(Address address) {
		getHibernateTemplate().saveOrUpdate(address);
	}

}
