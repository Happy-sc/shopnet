package com.shop.domain;


/*
 * 用户所拥有的优惠券实体
 */
public class DiscountCoupon implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String discountCouponId;             //优惠券编号
	private Users users;                         //用户
	private String discountCouponName;           //优惠券名称
	private String discountCouponTime;           //优惠券过期时间
	private String discountCouponValidity;       //优惠券说明
	private boolean discountCouponState;         //优惠券使用状态  0:已过期   1：可用    2：已使用

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