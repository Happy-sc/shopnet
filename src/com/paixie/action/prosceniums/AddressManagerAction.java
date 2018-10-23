package com.paixie.action.prosceniums;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.paixie.action.common.BaseAction;
import com.paixie.domain.Address;
import com.paixie.domain.Users;
import com.paixie.service.AddressService;

@Controller("addressManagerAction")
public class AddressManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="addressService")private AddressService addressService;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * ���ӻ��޸��ջ���ַ
	 * @return
	 */
	public String addAddress(){
		//������ϸ��ַ
		address.setAddressDetail(getDetailAddress());

		//��ȡ�û�
		Users users = (Users) request.getSession().getAttribute("user");
	
		//��������޸��û���ַ
		addressService.saveOrUpdateAddress(getAddress(),users);
		/*
		 * ��ȡtype
		 * ��type��һ��ֵ��firmOrder���������˸������������
		 * ���ΪfirmOrder�����ʾ�ڶ�����---����null
		 * ��������ջ���ַ����  ---�ض���
		 */
		String type = request.getParameter("type");
		String flag = null;
		if(!"firmOrder".equals(type)){
			flag = "adderssUI";
		}
		return flag;	
	}
	
	/**
	 * ɾ����ַ
	 * @return
	 */
	public String deleteAddress(){
		String addressId = request.getParameter("addressId");
		//ɾ����ַ
		addressService.delete(addressId);
		return null;
	}
	
	/**
	 * ����Ĭ�ϵ�ַ
	 * @return
	 */
	public String setDefaultAddress(){
		String addressId = request.getParameter("addressId");
		//��ȡ�õ�ַ
		Address address1 = addressService.getAddressByID(addressId);
		address1.setIsDefault(1);
		
		//��ȡ���û���Ĭ�ϵ�ַ��ͬʱ��������Ϊ��Ĭ��
		Users users = (Users) request.getSession().getAttribute("user");
		Address dAddress = addressService.getUserDefaultAddress(users.getUserId());
		if(dAddress!=null){
			dAddress.setIsDefault(0);
			addressService.update(dAddress);
		}
		
		addressService.update(address1);       //�޸ĵ�ַ
		
		return "adderssUI";
	}
	
	/**
	 * ��ȡ��ϸ��ַ��Ϣ
	 */
	public String getDetailAddress(){
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String street = request.getParameter("street");
		
		//������ϸ��ַ
		String detailAddress = province+","+city+","+country+","+street;
		
		return detailAddress;
	}
	
}
