package com.shop.dao;

import java.util.List;

import com.shop.domain.Address;


public interface AddressDao {
	/**
	 * 根据标识属性获取Address实体
	 * @param addressId 地址编号
	 * @return 指定编号的地址实体
	 */
	Address get(String addressId);
	
	/**
	 * 保存Address实体
	 * @param address 需要被保存的地址实体
	 * @return 
	 */
	void save(Address address);
	
	/**
	 * 根据标识属性删除Address实体
	 * @param addressId 需要被删除的地址实体的编号
	 * @return
	 */
	void delete(String addressId);
	
	/**
	 * 删除Address实体
	 * @param address 需要被删除的地址实体
	 * @return 
	 */
	void delete(Address address);
	
	/**
	 * 修改Address实体
	 * @param address 需要被修改的地址实体
	 * @return
	 */
	void update(Address address);
	
	/**
	 * 获取所有的Address实体
	 * @return 所有的地址实体
	 */
	List<Address> getAllAddress();

	/**
	 * 获取用户的收货地址
	 * @param userId 用户编号
	 * @return 指定用户的收货地址
	 */
	List<Address> getAddressByUser(String userId);

	/**
	 * 获取用户的默认地址
	 * @param userId 用户编号
	 * @return 指定用户的默认收货 地址
	 */
	Address getUserDefaultAddress(String userId);

	/**
	 * 根据地址编号获取地址
	 * @param addressId 地址编号
	 * @return 指定地址编号的地址实体
	 */
	Address getAddressById(String addressId);

	/**
	 * 保存或者修改地址
	 * @param address 需要保持或者修改的地址实体
	 * @return
	 */
	void saveOrUpdateAddress(Address address);
}
