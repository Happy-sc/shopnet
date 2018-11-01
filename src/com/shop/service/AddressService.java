package com.shop.service;

import java.util.List;

import com.shop.domain.Address;
import com.shop.domain.Users;

public interface AddressService {

	/**
	 * 获取用户的收货地址
	 * @param userId 用户编号
	 * @return
	 */
	List<Address> getAddressByUser(String userId);

	/**
	 * 保存地址信息
	 * @param address 需要被保存的地址实例
	 */
	void save(Address address);

	/**
	 * 删除地址
	 * @param addressId 需要删除的地址实例
	 */
	void delete(String addressId);

	/**
	 * 获取用户的默认地址
	 * @param userId 用户编号
	 * @return
	 */
	Address getUserDefaultAddress(String userId);

	/**
	 * 根据地址编号获取地址
	 * @param addressId 地址编号
	 * @return
	 */
	Address getAddressByID(String addressId);

	/**
	 * 保存或者修改地址
	 * @param address2 地址实例
	 */
	void saveOrUpdateAddress(Address address2);

	/**
	 * 修改用户收货地址
	 * @param address1 地址实例
	 */
	void update(Address address1);

	/**
	 * 保存或者修改用户地址
	 * @param address   地址实例
	 * @param users  用户
	 */
	void saveOrUpdateAddress(Address address, Users users);

}
