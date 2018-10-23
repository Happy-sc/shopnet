package com.paixie.service;

import com.paixie.domain.GoodsListing;
import com.paixie.queryBean.QueryResult;

public interface SearchGoodsService {

	/**
	 * ������Ʒ
	 * @param key  �ؼ���
	 * @param offset  ��ʼ����
	 * @param pageSize  ÿҳ��ȡ��¼��
	 * @return
	 */
	public QueryResult<GoodsListing> queryResults(String key,int offset ,int pageSize);
}
