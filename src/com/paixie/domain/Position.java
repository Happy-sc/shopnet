package com.paixie.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * Ա��ְ��ʵ��
 */
public class Position implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String positionId;                             //ְλ���
	private String positionName;                           //ְλ����
	private Set<Worker> workers = new HashSet<Worker>(0);  //Ա��


	public Position() {
	}

	public Position(String positionId) {
		this.positionId = positionId;
	}


	public Position(String positionId, String positionName, Set<Worker> workers) {
		this.positionId = positionId;
		this.positionName = positionName;
		this.workers = workers;
	}


	public String getPositionId() {
		return this.positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Set<Worker> getWorkers() {
		return this.workers;
	}

	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	}

}