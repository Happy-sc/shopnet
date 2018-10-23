package com.paixie.service;

import com.paixie.domain.GoodsListing;
import com.paixie.queryBean.QueryResult;

public interface SearchGoodsService {

	/**
	 * 搜索商品
	 * @param key  关键字
	 * @param offset  开始索引
	 * @param pageSize  每页获取记录数
	 * @return
	 */
	public QueryResult<GoodsListing> queryResults(String key,int offset ,int pageSize);
}
