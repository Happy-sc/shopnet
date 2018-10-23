package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.common.ProduceId;
import com.paixie.dao.AddressDao;
import com.paixie.domain.Address;
import com.paixie.domain.Users;
import com.paixie.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService{
	@Resource(name="addressDao")private AddressDao addressDao;

	/**
	 *获取用户的收货地址
	 *@param userId 用户编号
	 *@return 指定用户的收货地址
	 */
	public List<Address> getAddressByUser(String userId) {
		return addressDao.getAddressByUser(userId);
	}

	/**
	 * 保存地址信息
	 * @param address  地址信息
	 */
	public void save(Address address) {
		addressDao.save(address);
	}

	/**
	 * 删除地址信息
	 * @param addressId 需要删除的地址编号
	 */
	public void delete(String addressId) {
		addressDao.delete(addressId);
	}

	/**
	 * 获取用户的默认地址
	 * @param userId 用户的编号
	 * @return 指定用户的默认地址
	 */
	public Address getUserDefaultAddress(String userId) {
		return addressDao.getUserDefaultAddress(userId);
	}

	/**
	 * 根据地址编号获取地址
	 * @param addressId 地址编号
	 * @return 指定地址编号的地址
	 */
	public Address getAddressByID(String addressId) {
		return addressDao.getAddressById(addressId);
	}

	/**
	 * 保存或者修改地址
	 * @param address 需要保存或者修改的地址
	 * @return
	 */
	public void saveOrUpdateAddress(Address address) {
		addressDao.saveOrUpdateAddress(address);
	}

	/**
	 * 修改用户收货地址
	 * @param address 需要修改的地址
	 * @return
	 */
	public void update(Address address) {
		addressDao.update(address);
	}

	/**
	 * 保存或者修改用户地址
	 * @param address   地址实例
	 * @param users  用户
	 */
	public void saveOrUpdateAddress(Address address, Users users) {
		//如果该地址为默认地址,获取该用户的默认地址，同时将他设置为非默认
		if(address.getIsDefault()==1){
			//获取该用户的默认地址
			Address  dAddress = getUserDefaultAddress(users.getUserId());
			if(dAddress!=null){
				dAddress.setIsDefault(0);
			}
		}
		
		/*
		 * 如果addressId存在，则表示是修改地址。直接获取地址即可
		 * 如果addressId为null，则表示新增地址，需要新建
		 */
		Address address2 = null;
		if(address.getAddressId()!=null&&!"".equals(address.getAddressId())){
			address2 = getAddressByID(address.getAddressId());
		}
		else {
			address2 = new Address();
			address2.setAddressId(ProduceId.getId());    //设置id
		}
		
		//给address赋值
		address2.setAddressDetail(address.getAddressDetail());
		address2.setConsignee(address.getConsignee());
		address2.setAddressPhone(address.getAddressPhone());
		address2.setAddressPostalcode(address.getAddressPostalcode());
		address2.setIsDefault(address.getIsDefault());
		address2.setUsers(users);

		addressDao.saveOrUpdateAddress(address2);
	}
}
