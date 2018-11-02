package com.shop.domain;

/*
 * 用户寄货地址实体
 */
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String addressId;                 //地址编号
	private Users users;                      //用户
	private String addressDetail;             //地址详情
	private String addressPostalcode;         //邮政编码
	private String addressPhone;              //联系号码
	private String  consignee;                //收货人
	private Integer isDefault;               //是否为默认地址：0：否，1：是

	public Address() {
	}

	public Address(String addressId) {
		this.addressId = addressId;
	}

	public Address(String addressId, Users users, String addressDetail,Integer isDefault,
			String addressPostalcode, String addressPhone,String  consignee) {
		this.addressId = addressId;
		this.users = users;
		this.addressDetail = addressDetail;
		this.addressPostalcode = addressPostalcode;
		this.addressPhone = addressPhone;
		this. consignee=  consignee;
		this.isDefault = isDefault;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressPostalcode() {
		return this.addressPostalcode;
	}

	public void setAddressPostalcode(String addressPostalcode) {
		this.addressPostalcode = addressPostalcode;
	}

	public String getAddressPhone() {
		return this.addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}


	
}