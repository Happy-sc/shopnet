package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.AddressDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Address;

@Repository("addressDao")
public class AddressDaoHibernate extends BaseHibernateDaoSupport implements AddressDao {

	/**
	 * ���ݱ�ʶ����ɾ��Addressʵ��
	 * @param addressId ��Ҫɾ����Addressʵ��ı�ʶ����ֵ
	 */
	public void delete(String addressId) {
		getHibernateTemplate().delete(get(addressId));
	}

	/**
	 * ɾ��ָ����Addressʵ��
	 * @param address ��Ҫ��ɾ����Addressʵ��
	 */
	public void delete(Address address) {
		getHibernateTemplate().delete(address);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡAddressʵ��
	 * @param addressId ��Ҫ��ȡAddressʵ��ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Addressʵ��
	 */
	public Address get(String addressId) {
		return getHibernateTemplate().get(Address.class, addressId);
	}

	/**
	 * ��ȡȫ����Addressʵ��
	 * @return ���ݿ���ȫ����Addressʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getAllAddress() {
		return (List<Address>)getHibernateTemplate().find("from Address");
	}

	/**
	 * ����Addressʵ��
	 * @param address ��Ҫ�����addressʵ��
	 */
	public void save(Address address) {
		getHibernateTemplate().save(address);
	}

	/**
	 * �޸�Addressʵ��
	 * @param
	 */
	public void update(Address address) {
		getHibernateTemplate().update(address);
	}

	/**
	 *��ȡ�û����ջ���ַ
	 *@param userId �û����
	 *@return ָ���û����ջ���ַ
	 */
	@SuppressWarnings("unchecked")
	public List<Address> getAddressByUser(String userId) {
		return (List<Address>)getHibernateTemplate().find("From Address as a where a.users.userId='"+userId+"'");
	}

	/**
	 * ��ȡ�û���Ĭ�ϵ�ַ
	 * @param userId �û��ı��
	 * @return ָ���û���Ĭ�ϵ�ַ
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
	 * ���ݵ�ַ��Ż�ȡ��ַ
	 * @param addressId ��ַ���
	 * @return ָ����ַ��ŵĵ�ַ
	 */
	public Address getAddressById(String addressId) {
		return getHibernateTemplate().get(Address.class, addressId);
	}

	/**
	 * ��������޸ĵ�ַ
	 * @param address ��Ҫ���������õĵ�ַ
	 * @return
	 */
	public void saveOrUpdateAddress(Address address) {
		getHibernateTemplate().saveOrUpdate(address);
	}

}
