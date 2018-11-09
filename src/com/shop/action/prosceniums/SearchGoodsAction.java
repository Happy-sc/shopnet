package com.shop.action.prosceniums;

import com.shop.action.common.BaseAction;
import com.shop.domain.GoodsListing;
import com.shop.queryBean.QueryResult;
import com.shop.service.GoodsService;
import com.shop.service.SearchGoodsService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("searchGoodsAction")
public class SearchGoodsAction extends BaseAction {
    private static final long serialVersionUID = 1L;

    @Resource(name = "searchGoods")
    private SearchGoodsService searchGoodsService;
    @Resource(name = "goodsService")
    private GoodsService goodsService;

    private String queryString;        //查询条件

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     * 搜索商品
     *
     * @return
     */
    public String searchGoods() {
        System.out.println(queryString);
        int offset = (page - 1) * 6;
        QueryResult<GoodsListing> queryResult = searchGoodsService.queryResults(queryString, offset, 24);

        //分页处理
        int resultSize = (int) queryResult.getTotalrecord();
        pageSum = resultSize % 24 == 0 ? resultSize / 24 : resultSize / 24 + 1;    //总页数
        int rows = resultSize % 4 == 0 ? resultSize / 4 : resultSize / 4 + 1;
        int lastNumber = resultSize % 4 == 0 ? 4 : resultSize % 4;       //最后一行个数

        //获取5个推荐商品
        List<GoodsListing> gList = goodsService.getRecommandGoods(5);
        request.setAttribute("goods", queryResult.getResultlist());
        request.setAttribute("lastNumber", lastNumber);
        request.setAttribute("rows", rows);
        request.setAttribute("recommandGoods", gList);

        return "searchResults";
    }

}
