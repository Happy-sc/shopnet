package com.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.compass.core.CompassCallback;
import org.compass.core.CompassException;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;

import com.shop.domain.GoodsListing;
import com.shop.queryBean.QueryResult;

public class QueryCallBack implements CompassCallback<QueryResult<GoodsListing>>{

	private String key;           //关键字
	private int  offset;          //开始索引位置
	private int  pageSize;        //每页显示数
	
	public QueryCallBack(String key, int offset, int pageSize) {
		this.key = key;
		this.offset = offset;
		this.pageSize = pageSize;
	}

	@Override
	public QueryResult<GoodsListing> doInCompass(CompassSession session) throws CompassException {
		CompassHits  hits = session.find(key);
		QueryResult<GoodsListing> queryResult = new QueryResult<GoodsListing>();   //新建结果集
		
		queryResult.setTotalrecord(hits.length());          //获取匹配的记录总数
		
		int lenght = offset + pageSize;
		if(lenght>hits.length()){
			lenght = hits.length();
		}
	
		//获取索引分页数据
		List<GoodsListing> goodsList = new ArrayList<GoodsListing>();
		for(int i = offset; i < lenght;i++){
			GoodsListing goods = (GoodsListing) hits.data(i);
			//处理高亮显示:如果产品名称存在关键字，则高亮显示
			if(hits.highlighter(i).fragment("goodsName")!=null){
				goods.setGoodsName(hits.highlighter(i).fragment("goodsName"));
			}
			
			goodsList.add(goods);
		}
		
		queryResult.setResultlist(goodsList);
		
		return queryResult;
	}

}
