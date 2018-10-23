package com.paixie.service.impl;

import javax.annotation.Resource;

import org.compass.core.Compass;
import org.compass.core.CompassTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paixie.domain.GoodsListing;
import com.paixie.queryBean.QueryResult;
import com.paixie.service.SearchGoodsService;

@Service("searchGoods")  @Transactional
public class SearchGoodsServiceImpl implements SearchGoodsService{
	private CompassTemplate compassTemplate ;   //Compass

	public CompassTemplate getCompassTemplate() {
		return compassTemplate;
	}

	@Resource(name="compass")
	public void setCompassTemplate(Compass compass) {
		this.compassTemplate = new CompassTemplate(compass);
	}
	
	@Override
	public QueryResult<GoodsListing> queryResults(String key, int offSet,
			int pageSize) {
		return compassTemplate.execute(new QueryCallBack(key,offSet,pageSize));
	}

}
