package com.paixie.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.paixie.action.common.BaseAction;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.Style;
import com.paixie.queryBean.QueryResult;
import com.paixie.service.GoodsService;
import com.paixie.service.SearchGoodsService;
import com.paixie.service.StyleService;

@Controller("searchGoodsAction")
public class SearchGoodsAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="searchGoods")private SearchGoodsService searchGoodsService;
	@Resource(name="styleService")private StyleService styleService;
	@Resource(name="goodsService")private GoodsService goodsService;
	
	private String queryString;        //查询条件
	
	public String getQueryString() {
		return queryString;
	}
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
	/**
	 * 搜索商品
	 * @return
	 */
	public String searchGoods(){
		System.out.println(queryString);
		int offset = (page-1)*6;
		QueryResult<GoodsListing> queryResult = searchGoodsService.queryResults(queryString, offset, 24);
		
		//分页处理
		int resultSize = (int) queryResult.getTotalrecord();
		pageSum = resultSize%24==0?resultSize/24:resultSize/24+1;    //总页数 
		int rows = resultSize%4==0?resultSize/4:resultSize/4+1;
		int lastNumber = resultSize%4==0?4:resultSize%4;       //最后一行个数
		
		//获取所有分类的款式
		List<Style> sneakersStyles = styleService.getStyleByCategoryId("200001");               //运动鞋
		List<Style> womenShoesStyles = styleService.getStyleByCategoryId("200003");             //女鞋
		List<Style> menShoesStyles = styleService.getStyleByCategoryId("200002");               //男鞋
		List<Style> childrenShoeStyles = styleService.getStyleByCategoryId("200004");           //儿童鞋
		List<Style> outdoorShoeStyles = styleService.getStyleByCategoryId("200005");            //户外鞋
		
		//获取5个推荐商品
		List<GoodsListing> gList = goodsService.getRecommandGoods(5);
		 
		request.setAttribute("goods", queryResult.getResultlist());
		request.setAttribute("lastNumber", lastNumber);
		request.setAttribute("rows", rows);
		request.setAttribute("sneakersStyles", sneakersStyles);
		request.setAttribute("womenShoesStyles", womenShoesStyles);
		request.setAttribute("menShoesStyles", menShoesStyles);
		request.setAttribute("childrenShoeStyles", childrenShoeStyles);
		request.setAttribute("outdoorShoeStyles", outdoorShoeStyles);
		request.setAttribute("recommandGoods", gList);
		
		return "searchResults";
	}
	
}
