package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * Ա��ʵ��
 */
public class Worker implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String workerId;                   //Ա�����
	private String workerPassword;             //��¼����
	private Position position;                 //�û�ְ��
	private String workerName;                 //�û�����
	private String workerIdcard;               //Ա�����֤����
	private String workerPhone;                //Ա����ϵ�绰
	private String workerAddress;              //Ա����ַ
	private String workerImage;                //Ա����Ƭ
	private String workerBirthday;             //Ա����������
	private String entryTime;                  //Ա����ְʱ��
	private String userJG;                     //Ա������
	private Set<Order> orders = new HashSet<Order>(0);         //������
	private Set<Notice> notices = new HashSet<Notice>(0);      //ϵͳ����
	
	public Worker() {
	}

	public Worker(String workerId) {
		this.workerId = workerId;
	}

	public Worker(String workerId, Position position, String workerName,String entryTime,
			String workerIdcard, String workerPhone, String workerAddress,String workerBirthday,
			Set<Order> orders,String workerPassword,String workerImage,Set<Notice> notices,
			String userJG) {
		this.workerId = workerId;
		this.position = position;
		this.entryTime = entryTime;
		this.workerName = workerName;
		this.workerIdcard = workerIdcard;
		this.workerPhone = workerPhone;
		this.workerAddress = workerAddress;
		this.workerPassword = workerPassword;
		this.orders = orders;
		this.workerImage = workerImage;
		this.workerBirthday = workerBirthday;
		this.notices = notices;
		this.userJG = userJG;
	}

	public String getWorkerId() {
		return this.workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getWorkerName() {
		return this.workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getWorkerIdcard() {
		return this.workerIdcard;
	}

	public void setWorkerIdcard(String workerIdcard) {
		this.workerIdcard = workerIdcard;
	}

	public String getWorkerPhone() {
		return this.workerPhone;
	}

	public void setWorkerPhone(String workerPhone) {
		this.workerPhone = workerPhone;
	}

	public String getWorkerAddress() {
		return this.workerAddress;
	}

	public void setWorkerAddress(String workerAddress) {
		this.workerAddress = workerAddress;
	}

	public Set<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getWorkerPassword() {
		return workerPassword;
	}

	public void setWorkerPassword(String workerPassword) {
		this.workerPassword = workerPassword;
	}

	public String getWorkerImage() {
		return workerImage;
	}

	public void setWorkerImage(String workerImage) {
		this.workerImage = workerImage;
	}

	public String getWorkerBirthday() {
		return workerBirthday;
	}

	public void setWorkerBirthday(String workerBirthday) {
		this.workerBirthday = workerBirthday;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public Set<Notice> getNotices() {
		return notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

	public String getUserJG() {
		return userJG;
	}

	public void setUserJG(String userJG) {
		this.userJG = userJG;
	}
}