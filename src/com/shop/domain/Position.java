package com.shop.domain;

import java.util.HashSet;
import java.util.Set;

/*
 * 员工职务实体
 */
public class Position implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String positionId;                             //职位编号
	private String positionName;                           //职位名称
	private Set<Worker> workers = new HashSet<Worker>(0);  //员工


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