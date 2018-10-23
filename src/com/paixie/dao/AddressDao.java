package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Address;


public interface AddressDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡAddressʵ��
	 * @param addressId ��ַ���
	 * @return ָ����ŵĵ�ַʵ��
	 */
	Address get(String addressId);
	
	/**
	 * ����Addressʵ��
	 * @param address ��Ҫ������ĵ�ַʵ��
	 * @return 
	 */
	void save(Address address);
	
	/**
	 * ���ݱ�ʶ����ɾ��Addressʵ��
	 * @param addressId ��Ҫ��ɾ���ĵ�ַʵ��ı��
	 * @return
	 */
	void delete(String addressId);
	
	/**
	 * ɾ��Addressʵ��
	 * @param address ��Ҫ��ɾ���ĵ�ַʵ��
	 * @return 
	 */
	void delete(Address address);
	
	/**
	 * �޸�Addressʵ��
	 * @param address ��Ҫ���޸ĵĵ�ַʵ��
	 * @return
	 */
	void update(Address address);
	
	/**
	 * ��ȡ���е�Addressʵ��
	 * @return ���еĵ�ַʵ��
	 */
	List<Address> getAllAddress();

	/**
	 * ��ȡ�û����ջ���ַ
	 * @param userId �û����
	 * @return ָ���û����ջ���ַ
	 */
	List<Address> getAddressByUser(String userId);

	/**
	 * ��ȡ�û���Ĭ�ϵ�ַ
	 * @param userId �û����
	 * @return ָ���û���Ĭ���ջ� ��ַ
	 */
	Address getUserDefaultAddress(String userId);

	/**
	 * ���ݵ�ַ��Ż�ȡ��ַ
	 * @param addressId ��ַ���
	 * @return ָ����ַ��ŵĵ�ַʵ��
	 */
	Address getAddressById(String addressId);

	/**
	 * ��������޸ĵ�ַ
	 * @param address ��Ҫ���ֻ����޸ĵĵ�ַʵ��
	 * @return
	 */
	void saveOrUpdateAddress(Address address);
}
