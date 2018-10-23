package com.paixie.domain;


/*
 * �û���ӵ�е��Ż�ȯʵ��
 */
public class DiscountCoupon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String discountCouponId;             //�Ż�ȯ���
	private Users users;                         //�û�
	private String discountCouponName;           //�Ż�ȯ����
	private String discountCouponTime;           //�Ż�ȯ����ʱ��
	private String discountCouponValidity;       //�Ż�ȯ˵��
	private boolean discountCouponState;         //�Ż�ȯʹ��״̬  0:�ѹ���   1������    2����ʹ��

	public DiscountCoupon() {
	}

	public DiscountCoupon(String discountCouponId) {
		this.discountCouponId = discountCouponId;
	}

	public DiscountCoupon(String discountCouponId, Users users,
			String discountCouponName, String discountCouponTime,
			String discountCouponValidity, boolean discountCouponState) {
		this.discountCouponId = discountCouponId;
		this.users = users;
		this.discountCouponName = discountCouponName;
		this.discountCouponTime = discountCouponTime;
		this.discountCouponValidity = discountCouponValidity;
		this.discountCouponState = discountCouponState;
	}

	public String getDiscountCouponId() {
		return this.discountCouponId;
	}

	public void setDiscountCouponId(String discountCouponId) {
		this.discountCouponId = discountCouponId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDiscountCouponName() {
		return this.discountCouponName;
	}

	public void setDiscountCouponName(String discountCouponName) {
		this.discountCouponName = discountCouponName;
	}

	public String getDiscountCouponTime() {
		return discountCouponTime;
	}

	public void setDiscountCouponTime(String discountCouponTime) {
		this.discountCouponTime = discountCouponTime;
	}

	public String getDiscountCouponValidity() {
		return this.discountCouponValidity;
	}

	public void setDiscountCouponValidity(String discountCouponValidity) {
		this.discountCouponValidity = discountCouponValidity;
	}

	public boolean getDiscountCouponState() {
		return this.discountCouponState;
	}

	public void setDiscountCouponState(boolean discountCouponState) {
		this.discountCouponState = discountCouponState;
	}

}