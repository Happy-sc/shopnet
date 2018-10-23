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
	
	private String queryString;        //��ѯ����
	
	public String getQueryString() {
		return queryString;
	}
	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	
	/**
	 * ������Ʒ
	 * @return
	 */
	public String searchGoods(){
		System.out.println(queryString);
		int offset = (page-1)*6;
		QueryResult<GoodsListing> queryResult = searchGoodsService.queryResults(queryString, offset, 24);
		
		//��ҳ����
		int resultSize = (int) queryResult.getTotalrecord();
		pageSum = resultSize%24==0?resultSize/24:resultSize/24+1;    //��ҳ�� 
		int rows = resultSize%4==0?resultSize/4:resultSize/4+1;
		int lastNumber = resultSize%4==0?4:resultSize%4;       //���һ�и���
		
		//��ȡ���з���Ŀ�ʽ
		List<Style> sneakersStyles = styleService.getStyleByCategoryId("200001");               //�˶�Ь
		List<Style> womenShoesStyles = styleService.getStyleByCategoryId("200003");             //ŮЬ
		List<Style> menShoesStyles = styleService.getStyleByCategoryId("200002");               //��Ь
		List<Style> childrenShoeStyles = styleService.getStyleByCategoryId("200004");           //��ͯЬ
		List<Style> outdoorShoeStyles = styleService.getStyleByCategoryId("200005");            //����Ь
		
		//��ȡ5���Ƽ���Ʒ
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
