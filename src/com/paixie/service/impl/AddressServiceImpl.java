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
	 *��ȡ�û����ջ���ַ
	 *@param userId �û����
	 *@return ָ���û����ջ���ַ
	 */
	public List<Address> getAddressByUser(String userId) {
		return addressDao.getAddressByUser(userId);
	}

	/**
	 * �����ַ��Ϣ
	 * @param address  ��ַ��Ϣ
	 */
	public void save(Address address) {
		addressDao.save(address);
	}

	/**
	 * ɾ����ַ��Ϣ
	 * @param addressId ��Ҫɾ���ĵ�ַ���
	 */
	public void delete(String addressId) {
		addressDao.delete(addressId);
	}

	/**
	 * ��ȡ�û���Ĭ�ϵ�ַ
	 * @param userId �û��ı��
	 * @return ָ���û���Ĭ�ϵ�ַ
	 */
	public Address getUserDefaultAddress(String userId) {
		return addressDao.getUserDefaultAddress(userId);
	}

	/**
	 * ���ݵ�ַ��Ż�ȡ��ַ
	 * @param addressId ��ַ���
	 * @return ָ����ַ��ŵĵ�ַ
	 */
	public Address getAddressByID(String addressId) {
		return addressDao.getAddressById(addressId);
	}

	/**
	 * ��������޸ĵ�ַ
	 * @param address ��Ҫ��������޸ĵĵ�ַ
	 * @return
	 */
	public void saveOrUpdateAddress(Address address) {
		addressDao.saveOrUpdateAddress(address);
	}

	/**
	 * �޸��û��ջ���ַ
	 * @param address ��Ҫ�޸ĵĵ�ַ
	 * @return
	 */
	public void update(Address address) {
		addressDao.update(address);
	}

	/**
	 * ��������޸��û���ַ
	 * @param address   ��ַʵ��
	 * @param users  �û�
	 */
	public void saveOrUpdateAddress(Address address, Users users) {
		//����õ�ַΪĬ�ϵ�ַ,��ȡ���û���Ĭ�ϵ�ַ��ͬʱ��������Ϊ��Ĭ��
		if(address.getIsDefault()==1){
			//��ȡ���û���Ĭ�ϵ�ַ
			Address  dAddress = getUserDefaultAddress(users.getUserId());
			if(dAddress!=null){
				dAddress.setIsDefault(0);
			}
		}
		
		/*
		 * ���addressId���ڣ����ʾ���޸ĵ�ַ��ֱ�ӻ�ȡ��ַ����
		 * ���addressIdΪnull�����ʾ������ַ����Ҫ�½�
		 */
		Address address2 = null;
		if(address.getAddressId()!=null&&!"".equals(address.getAddressId())){
			address2 = getAddressByID(address.getAddressId());
		}
		else {
			address2 = new Address();
			address2.setAddressId(ProduceId.getId());    //����id
		}
		
		//��address��ֵ
		address2.setAddressDetail(address.getAddressDetail());
		address2.setConsignee(address.getConsignee());
		address2.setAddressPhone(address.getAddressPhone());
		address2.setAddressPostalcode(address.getAddressPostalcode());
		address2.setIsDefault(address.getIsDefault());
		address2.setUsers(users);

		addressDao.saveOrUpdateAddress(address2);
	}
}
