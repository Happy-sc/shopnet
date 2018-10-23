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
	 * 增加或修改收货地址
	 * @return
	 */
	public String addAddress(){
		//设置详细地址
		address.setAddressDetail(getDetailAddress());

		//获取用户
		Users users = (Users) request.getSession().getAttribute("user");
	
		//保存或者修改用户地址
		addressService.saveOrUpdateAddress(getAddress(),users);
		/*
		 * 获取type
		 * 该type有一个值：firmOrder，它代表了该请求的来处，
		 * 如果为firmOrder，则表示在订单处---返回null
		 * 否则就在收货地址管理处  ---重定向
		 */
		String type = request.getParameter("type");
		String flag = null;
		if(!"firmOrder".equals(type)){
			flag = "adderssUI";
		}
		return flag;	
	}
	
	/**
	 * 删除地址
	 * @return
	 */
	public String deleteAddress(){
		String addressId = request.getParameter("addressId");
		//删除地址
		addressService.delete(addressId);
		return null;
	}
	
	/**
	 * 设置默认地址
	 * @return
	 */
	public String setDefaultAddress(){
		String addressId = request.getParameter("addressId");
		//获取该地址
		Address address1 = addressService.getAddressByID(addressId);
		address1.setIsDefault(1);
		
		//获取该用户的默认地址，同时将其设置为非默认
		Users users = (Users) request.getSession().getAttribute("user");
		Address dAddress = addressService.getUserDefaultAddress(users.getUserId());
		if(dAddress!=null){
			dAddress.setIsDefault(0);
			addressService.update(dAddress);
		}
		
		addressService.update(address1);       //修改地址
		
		return "adderssUI";
	}
	
	/**
	 * 获取详细地址信息
	 */
	public String getDetailAddress(){
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String street = request.getParameter("street");
		
		//构建详细地址
		String detailAddress = province+","+city+","+country+","+street;
		
		return detailAddress;
	}
	
}
