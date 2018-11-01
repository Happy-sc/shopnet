package com.shop.queryBean;

import java.util.List;

/**
 * 该类为搜索查询结果集
 */
public class QueryResult<T> {

	private List<T> resultlist;        //记录结果集
	private long totalrecord;         //记录总数

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
