package com.shop.domain;

public class JinBRecord implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private String jinBId;             //金币记录编号
	private String jinBTime;           //记录时间
	private int jinBNum ;              //金币数量
	private String jinBStyle;          //金币方式
	private int jinBState;             //金币状态：0：表示支出  1：表示获得
	private Users users;                  //用户
	
	public JinBRecord(){
		
	}
	
	public JinBRecord(String jinBId){
		this.jinBId = jinBId;
	}

	public JinBRecord(String jinBId, String jinBTime, int jinBNum, String jinBStyle, int jinBState, Users users) {
		this.jinBId = jinBId;
		this.jinBTime = jinBTime;
		this.jinBNum = jinBNum;
		this.jinBStyle = jinBStyle;
		this.jinBState = jinBState;
		this.users = users;
	}

	public String getJinBId() {
		return jinBId;
	}

	public void setJinBId(String jinBId) {
		this.jinBId = jinBId;
	}

	public String getJinBTime() {
		return jinBTime;
	}

	public void setJinBTime(String jinBTime) {
		this.jinBTime = jinBTime;
	}

	public int getJinBNum() {
		return jinBNum;
	}

	public void setJinBNum(int jinBNum) {
		this.jinBNum = jinBNum;
	}

	public String getJinBStyle() {
		return jinBStyle;
	}

	public void setJinBStyle(String jinBStyle) {
		this.jinBStyle = jinBStyle;
	}

	public int getJinBState() {
		return jinBState;
	}

	public void setJinBState(int jinBState) {
		this.jinBState = jinBState;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
