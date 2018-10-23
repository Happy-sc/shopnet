package com.paixie.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.compass.core.CompassCallback;
import org.compass.core.CompassException;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;

import com.paixie.domain.GoodsListing;
import com.paixie.queryBean.QueryResult;

public class QueryCallBack implements CompassCallback<QueryResult<GoodsListing>>{

	private String key;           //�ؼ���
	private int  offset;          //��ʼ����λ��
	private int  pageSize;        //ÿҳ��ʾ��
	
	public QueryCallBack(String key, int offset, int pageSize) {
		this.key = key;
		this.offset = offset;
		this.pageSize = pageSize;
	}

	@Override
	public QueryResult<GoodsListing> doInCompass(CompassSession session) throws CompassException {
		CompassHits  hits = session.find(key);
		QueryResult<GoodsListing> queryResult = new QueryResult<GoodsListing>();   //�½������
		
		queryResult.setTotalrecord(hits.length());          //��ȡƥ��ļ�¼����
		
		int lenght = offset + pageSize;
		if(lenght>hits.length()){
			lenght = hits.length();
		}
	
		//��ȡ������ҳ����
		List<GoodsListing> goodsList = new ArrayList<GoodsListing>();
		for(int i = offset; i < lenght;i++){
			GoodsListing goods = (GoodsListing) hits.data(i);
			//���������ʾ:�����Ʒ���ƴ��ڹؼ��֣��������ʾ
			if(hits.highlighter(i).fragment("goodsName")!=null){
				goods.setGoodsName(hits.highlighter(i).fragment("goodsName"));
			}
			
			goodsList.add(goods);
		}
		
		queryResult.setResultlist(goodsList);
		
		return queryResult;
	}

}
