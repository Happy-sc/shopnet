package com.paixie.queryBean;

public class WorkerQueryBean {

	private String workerId;            //Ա�����
	private String positionId;			//Ա��ְ����
	private String idCard;				//Ա�����֤����
	private Integer page ;              //ҳ��
	
	public String getWorkerId() {
		return workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
}
