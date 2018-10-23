package com.paixie.domain;

public class PaixieBRecord implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String paixieBId;             //��Ь�Ҽ�¼���
	private String paixieBTime;           //��¼ʱ��
	private int paixieBNum ;              //��Ь������
	private String paixieBStyle;          //��Ь�ҷ�ʽ
	private int paixieBState;             //��Ь��״̬��0����ʾ֧��  1����ʾ���
	private Users users;                  //�û�
	
	public PaixieBRecord(){
		
	}
	
	public PaixieBRecord(String paixieBId){
		this.paixieBId = paixieBId;
	}
	
	public PaixieBRecord(String paixieBId,String paixieBTime,
			int paixieBNum,String paixieBStyle,Users users,int paixieBState){
		this.paixieBId = paixieBId;
		this.paixieBTime = paixieBTime;
		this.paixieBNum = paixieBNum;
		this.paixieBStyle = paixieBStyle;
		this.paixieBState = paixieBState;
		this.users = users;
	}

	public String getPaixieBId() {
		return paixieBId;
	}

	public void setPaixieBId(String paixieBId) {
		this.paixieBId = paixieBId;
	}

	public String getPaixieBTime() {
		return paixieBTime;
	}

	public void setPaixieBTime(String paixieBTime) {
		this.paixieBTime = paixieBTime;
	}

	public int getPaixieBNum() {
		return paixieBNum;
	}

	public void setPaixieBNum(int paixieBNum) {
		this.paixieBNum = paixieBNum;
	}

	public String getPaixieBStyle() {
		return paixieBStyle;
	}

	public void setPaixieBStyle(String paixieBStyle) {
		this.paixieBStyle = paixieBStyle;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getPaixieBState() {
		return paixieBState;
	}

	public void setPaixieBState(int paixieBState) {
		this.paixieBState = paixieBState;
	}

	
}
