package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * �û�ʵ��
 */
public class Users implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String userId;                    //�û����
	private String userName;                  //�û���
	private String userPassword;              //�û�����
	private String userEmail;                 //�û�����
	private int isActivate;                   //�����Ƿ��Ѿ����1�����0��û�м���
	private String emailDate;                 //���䷢������(����������֤)
	private String checkCode;                 //������֤�루�������伤�
	private String userBirthday;              //�û���������
	private String userSex;                   //�û��Ա�
	private String userRealName;              //�û���ʵ����
	private String userAddress;               //�û���ס��ַ
	private String userTelephone;             //�û���ϵ�绰
	private int paixieB;                      //��Ь��
	private Set<Collect> collects = new HashSet<Collect>(0);                             //�û��ղ�
	private Set<Address> addresses = new HashSet<Address>(0);                            //�û��ջ���ַ
	private Set<DiscountCoupon> discountCoupons = new HashSet<DiscountCoupon>(0);        //�û��Ż�ȯ
	private Set<Order> orders = new HashSet<Order>(0);                                   //�û�����
	private Set<Comment> comments = new HashSet<Comment>(0);                             //�û�����
	private Set<SecretSecurity> secretSecurities = new HashSet<SecretSecurity>(0);       //�û��ܱ�
	private Set<ShoppingCar> shoppingCars = new HashSet<ShoppingCar>(0);                 //�û����ﳵ
	private Set<PaixieBRecord> paixieBRecords = new HashSet<PaixieBRecord>();            //��Ь�Ҽ�¼
	
	public Users() {
	}

	public Users(String userId) {
		this.userId = userId;
	}

	public Users(String userId, String userName, String userPassword,String emailDate,
			String userEmail, String userBirthday,String userSex,int paixieB,
			Set<Collect> collects,String userRealName,Set<ShoppingCar> shoppingCars,
			String userAddress,String userTelephone,Set<Address> addresses, 
			Set<DiscountCoupon> discountCoupons,Set<Order> orders,Set<PaixieBRecord> paixieBRecords,
			Set<Comment> comments,Set<SecretSecurity> secretSecurities) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.emailDate = emailDate;
		this.userBirthday = userBirthday;
		this.userSex = userSex;
		this.paixieB = paixieB;
		this.userRealName = userRealName;
		this.userAddress = userAddress;
		this.userTelephone = userTelephone;
		this.collects = collects;
		this.addresses = addresses;
		this.discountCoupons = discountCoupons;
		this.orders = orders;
		this.comments = comments;
		this.secretSecurities = secretSecurities;
		this.shoppingCars = shoppingCars;
		this.paixieBRecords = paixieBRecords;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Set<Collect> getCollects() {
		return this.collects;
	}

	public void setCollects(Set<Collect> collects) {
		this.collects = collects;
	}

	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<DiscountCoupon> getDiscountCoupons() {
		return this.discountCoupons;
	}

	public void setDiscountCoupons(Set<DiscountCoupon> discountCoupons) {
		this.discountCoupons = discountCoupons;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public int getIsActivate() {
		return isActivate;
	}

	public void setIsActivate(int isActivate) {
		this.isActivate = isActivate;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public Set<SecretSecurity> getSecretSecurities() {
		return secretSecurities;
	}

	public void setSecretSecurities(Set<SecretSecurity> secretSecurities) {
		this.secretSecurities = secretSecurities;
	}

	public Set<ShoppingCar> getShoppingCars() {
		return shoppingCars;
	}

	public void setShoppingCars(Set<ShoppingCar> shoppingCars) {
		this.shoppingCars = shoppingCars;
	}

	public Set<PaixieBRecord> getPaixieBRecords() {
		return paixieBRecords;
	}

	public void setPaixieBRecords(Set<PaixieBRecord> paixieBRecords) {
		this.paixieBRecords = paixieBRecords;
	}

	public int getPaixieB() {
		return paixieB;
	}

	public void setPaixieB(int paixieB) {
		this.paixieB = paixieB;
	}

	public String getEmailDate() {
		return emailDate;
	}

	public void setEmailDate(String emailDate) {
		this.emailDate = emailDate;
	}

}