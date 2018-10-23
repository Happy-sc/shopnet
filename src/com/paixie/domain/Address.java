package com.paixie.domain;

/*
 * �û��Ļ���ַʵ��
 */
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String addressId;                 //��ַ���
	private Users users;                      //�û�
	private String addressDetail;             //��ַ����
	private String addressPostalcode;         //��������
	private String addressPhone;              //��ϵ����
	private String  consignee;                //�ջ���
	private Integer isDefault;               //�Ƿ�ΪĬ�ϵ�ַ��0����1����

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