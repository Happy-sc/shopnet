package com.shop.action.prosceniums;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import com.shop.domain.*;
import com.shop.service.*;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;

@Controller("goodsAction")
public class GoodsAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	@Resource(name="categoryService")
	private CategoryService categoryService;
	@Resource(name="brandService")
	private BrandService brandService;
	@Resource(name="goodsService")
	private GoodsService goodsService;
	@Resource(name="styleService")
	private StyleService styleService;
	@Resource(name="commentService")
	private CommentService commentService;
	@Resource(name="goodsColorService")
	private GoodsColorService goodsColorService;
	@Resource(name="goodsSizeService")
	private GoodsSizeService goodsSizeService;
	
	private String goodsId;           //商品编号

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	/**
	 * 进入购物网站首页
	 * @return
	 */
	public String goodsIndexUI(){
		//获取前23个品牌品牌
		List<Brand> brands = brandService.getBrand(23);
		//获取所有的分类
		List<Category> categories = categoryService.getAllCategory();

		//获取特价商品(卖出商品的前10个)
		List<GoodsListing> specialOfferGoods = goodsService.getGoodsOrderString("goodsMarketPrice","asc");
		//获取热卖商品
		List<GoodsListing> bestSellerGoods = goodsService.getGoodsOrderString("goodsMarketNumber", "asc");
		//获取新货商品
		List<GoodsListing> newestGoods = goodsService.getGoodsOrderString("goodsGrounding", "desc");
		//获取断码商品
		List<GoodsListing> lackGoods = goodsService.getgoodsByGoodsExitNumber();
		//获取推荐商品
		List<GoodsListing> recommendGoods = goodsService.getGoodsByRecommend(10);

		for (Category category : categories){
			List<GoodsListing> goodsListings = goodsService.getGoodsByCategoryOrder(category.getCategoryId(),10);
			List<Brand> brands1 = brandService.getBrandByCategory(category.getCategoryId());
			ActionContext.getContext().put("goodsListings"+category.getCategoryId(), goodsListings);
			category.setBrands(brands);
		}

		//保存数据
		ActionContext.getContext().put("specialOfferGoods", specialOfferGoods);
		ActionContext.getContext().put("recommendGoods", recommendGoods);
		ActionContext.getContext().put("bestSellerGoods", bestSellerGoods);
		ActionContext.getContext().put("newestGoods", newestGoods);
		ActionContext.getContext().put("lackGoods", lackGoods);
		ActionContext.getContext().put("categorys", categories);
		ActionContext.getContext().put("brands", brands);
		int tr = brands != null ? brands.size():0;
		ActionContext.getContext().put("brandsTr",tr/8+1);
		ActionContext.getContext().put("brandsTd",tr%8);

		return "goodsIndexUI";
	}
	
	/**
	 * 查看商品详细信息
	 */
	public String showGoods(){
		List<Category> categorys = categoryService.getAllCategory();
		//获取商品颜色
		String color  = request.getParameter("color");
		//根据商品编号获取商品基本信息
		GoodsListing goods = goodsService.getGoodsById(getGoodsId());
		
		//根据商品编号获取商品的所有颜色
		List<GoodsColor> goodsColors = goodsColorService.getGoodsColorByGoodsId(goodsId);
		
		//根据goods、color来判断该商品颜色实例
		GoodsColor goodsColor = goodsColorService.getGoodsColorByColor(goods,color);
		
		//获取该种商品颜色的尺码
		if(goodsColor != null ){
			List<GoodsSize> goodsSizes = goodsSizeService.getGoodsSize(goodsColor.getGoodsColorId());
			ActionContext.getContext().put("goodsSizes", goodsSizes);
		}
		
		//获取前5款推荐商品
		List<GoodsListing> pxwgntj = goodsService.getGoodsByRecommend(5);

		//同分类前5款热销商品
		List<GoodsListing> tkrxsp = goodsService.getMostSaleByStyle(goods.getStyle().getStyleId());
		
		//获取该类商品的评价
		List<Comment> comments = commentService.getCommentByGoods(getGoodsId(),10,1);
		
		//获取商品的所有评价数量,进行页码控制
		int commentSum  = commentService.getCommentSumByGoods(getGoodsId());
		pageSum = commentSum%10==0?commentSum/10:commentSum/10+1;
		
		//商品评分处理
		int sum_5 = commentService.getGoodsGradeSum(getGoodsId(),5);      //5分
		int sum_4 = commentService.getGoodsGradeSum(getGoodsId(),4);      //4分
		int sum_3 = commentService.getGoodsGradeSum(getGoodsId(),3);      //3分
		int sum_2 = commentService.getGoodsGradeSum(getGoodsId(),2);      //2分
		int sum_1 = commentService.getGoodsGradeSum(getGoodsId(),1);      //1分
		
		//评分总人数
		int sum = sum_1+sum_2+sum_3+sum_4+sum_5;
		
		//求评分的平均分
		String avg = getCommentAvg(sum_1, sum_2, sum_3, sum_4, sum_5,"#.0");
		
		if("".equals(color)){
			ActionContext.getContext().put("source", "image");
		}
		
		String sumA = getCommentAvg(sum_1, sum_2, sum_3, sum_4, sum_5,"#");
		
		ActionContext.getContext().put("goodsColor", goodsColor);        //商品颜色
		ActionContext.getContext().put("goodsColors", goodsColors);      //该商品的所有颜色
		ActionContext.getContext().put("goods", goods);                  //商品基本信息
		
		ActionContext.getContext().put("pxwgntj", pxwgntj);
		ActionContext.getContext().put("categorys", categorys);
		ActionContext.getContext().put("tlrxsp", tkrxsp);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("commentSum", commentSum);
		ActionContext.getContext().put("sum_1", sum_1);
		ActionContext.getContext().put("sum_2", sum_2);
		ActionContext.getContext().put("sum_3", sum_3);
		ActionContext.getContext().put("sum_4", sum_4);
		ActionContext.getContext().put("sum_5", sum_5);
		ActionContext.getContext().put("sumAvg", avg);
		ActionContext.getContext().put("sumA", sumA);
		ActionContext.getContext().put("sum", sum);
		return "showGoods";
	}
	
	/**
	 * 获取评价的平均分:保留一位小数
	 * @param sum_1  :1分的人数
	 * @param sum_2  :2分的人数
	 * @param sum_3	 :3分的人数
	 * @param sum_4  :4分的人数
	 * @param sum_5  :5分的人数
	 * @param blxs   :保留小数位数
	 * @return
	 */
	public String getCommentAvg(int sum_1,int sum_2,int sum_3,int sum_4,int sum_5,String blxs){
		double sumAvg;          //平均分       
		int sum = sum_1+sum_2+sum_3+sum_4+sum_5;
		
		if(sum_5+sum_4+sum_3+sum_2+sum_1!=0){
			sumAvg = (sum_5*5+sum_4*4+sum_3*3+sum_2*2+sum_1)*1.0/(sum);
		}
		else {
			sumAvg = 5;
		}
		DecimalFormat format = new DecimalFormat(blxs);   //保留一位小数
		
		return format.format(sumAvg);
	}

	
}
