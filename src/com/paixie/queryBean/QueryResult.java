package com.paixie.queryBean;

import java.util.List;

/**
 * ����Ϊ������ѯ�����
 */
public class QueryResult<T> {

	private List<T> resultlist;        //��¼�����
	private long totalrecord;         //��¼����

	public List<T> getResultlist() {
		return resultlist;
	}

	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}

	public long getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}

}
