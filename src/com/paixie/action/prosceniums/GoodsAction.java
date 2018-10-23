package com.paixie.action.prosceniums;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Brand;
import com.paixie.domain.Comment;
import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.GoodsSize;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.CommentService;
import com.paixie.service.GoodsColorService;
import com.paixie.service.GoodsService;
import com.paixie.service.GoodsSizeService;
import com.paixie.service.StyleService;

@Controller("goodsAction")
public class GoodsAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="brandService") private BrandService brandService;
	@Resource(name="goodsService") private GoodsService goodsService;
	@Resource(name="styleService") private StyleService styleService;
	@Resource(name="commentService") private CommentService commentService;
	@Resource(name="goodsColorService")private GoodsColorService goodsColorService;
	@Resource(name="goodsSizeService")private GoodsSizeService goodsSizeService;
	
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
		//获取前29个品牌品牌
		List<Brand> brands = brandService.getBrand(29);
		
		//获取特价商品(卖出商品的前10个)
		List<GoodsListing> specialOfferGoods = goodsService.getGoodsOrderString("goodsPaiPrice","asc");
		//获取热卖商品
		List<GoodsListing> bestSellerGoods = goodsService.getGoodsOrderString("goodsMarketNumber", "asc");
		//获取新货商品
		List<GoodsListing> newestGoods = goodsService.getGoodsOrderString("goodsGrounding", "desc");
		//获取断码商品
		List<GoodsListing> lackGoods = goodsService.getgoodsByGoodsExitNumber();
		//获取推荐商品
		List<GoodsListing> recommendGoods = goodsService.getGoodsByRecommend(10);
		
		
		//获取前面10个运动鞋,根据时间排序
		List<GoodsListing> sneakers = goodsService.getGoodsByCategoryOrder("200001",10);        //运动鞋
		List<GoodsListing> womenShoes = goodsService.getGoodsByCategoryOrder("200003", 10);     //女鞋
		List<GoodsListing> menShoes = goodsService.getGoodsByCategoryOrder("200002", 10);       //男鞋
		List<GoodsListing> childrenShoes = goodsService.getGoodsByCategoryOrder("200004", 10);  //童鞋
		List<GoodsListing> outdoorShoes = goodsService.getGoodsByCategoryOrder("200005", 10);   //户外鞋
		
		//获取分类的相关款式
		List<Style> sneakersStyles = styleService.getStyleByCategoryId("200001");               
		List<Style> womenShoesStyles = styleService.getStyleByCategoryId("200003");             
		List<Style> menShoesStyles = styleService.getStyleByCategoryId("200002");               
		List<Style> childrenShoeStyles = styleService.getStyleByCategoryId("200004");
		List<Style> outdoorShoeStyles = styleService.getStyleByCategoryId("200005");
		
		//获取该分类的品牌
		List<Brand> sneakerBrands = brandService.getBrandByCategory("200001");
		List<Brand> womenBrands = brandService.getBrandByCategory("200003");
		List<Brand> menBrands = brandService.getBrandByCategory("200002");
		List<Brand> childrenBrands = brandService.getBrandByCategory("200004");
		List<Brand> outdoorBrands = brandService.getBrandByCategory("200005");
		
		//保存数据
		ActionContext.getContext().put("specialOfferGoods", specialOfferGoods);
		ActionContext.getContext().put("recommendGoods", recommendGoods);
		ActionContext.getContext().put("bestSellerGoods", bestSellerGoods);
		ActionContext.getContext().put("newestGoods", newestGoods);
		ActionContext.getContext().put("lackGoods", lackGoods);
		
		ActionContext.getContext().put("brands", brands);
		
		ActionContext.getContext().put("sneakers", sneakers);
		ActionContext.getContext().put("menShoes", menShoes);
		ActionContext.getContext().put("childrenShoes", childrenShoes);
		ActionContext.getContext().put("womenShoes", womenShoes);
		ActionContext.getContext().put("outdoorShoes", outdoorShoes);
		
		ActionContext.getContext().put("sneakersStyles", sneakersStyles);
		ActionContext.getContext().put("womenShoesStyles", womenShoesStyles);
		ActionContext.getContext().put("menShoesStyles", menShoesStyles);
		ActionContext.getContext().put("childrenShoeStyles", childrenShoeStyles);
		ActionContext.getContext().put("outdoorShoeStyles", outdoorShoeStyles);
		
		ActionContext.getContext().put("senakersSum",sneakersStyles.size()%2==0?sneakersStyles.size()/2:sneakersStyles.size()/2+1);
		ActionContext.getContext().put("womenSum",womenShoesStyles.size()%2==0?womenShoesStyles.size()/2:womenShoesStyles.size()/2+1);
		ActionContext.getContext().put("menSum",menShoesStyles.size()%2==0?menShoesStyles.size()/2:menShoesStyles.size()/2+1);
		ActionContext.getContext().put("chilidrenSum",childrenShoeStyles.size()%2==0?childrenShoeStyles.size()/2:childrenShoeStyles.size()/2+1);
		ActionContext.getContext().put("outdoorSum",outdoorShoeStyles.size()%2==0?outdoorShoeStyles.size()/2:outdoorShoeStyles.size()/2+1);
		
		ActionContext.getContext().put("sneakerBrands", sneakerBrands);
		ActionContext.getContext().put("womenBrands", womenBrands);
		ActionContext.getContext().put("menBrands", menBrands);
		ActionContext.getContext().put("childrenBrands", childrenBrands);
		ActionContext.getContext().put("outdoorBrands", outdoorBrands);
		return "goodsIndexUI";
	}
	
	/**
	 * 查看商品详细信息
	 */
	public String showGoods(){
		//获取商品颜色
		String color  = request.getParameter("color");
		//根据商品编号获取商品基本信息
		GoodsListing goods = goodsService.getGoodsById(getGoodsId());
		
		//根据商品编号获取商品的所有颜色
		List<GoodsColor> goodsColors = goodsColorService.getGoodsColorByGoodsId(goodsId);
		
		//根据goods、color来判断该商品颜色实例
		GoodsColor goodsColor = goodsColorService.getGoodsColorByColor(goods,color);
		
		//获取该种商品颜色的尺码
		List<GoodsSize> goodsSizes = goodsSizeService.getGoodsSize(goodsColor.getGoodsColorId());
		
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
		ActionContext.getContext().put("goodsSizes", goodsSizes);        //当前颜色的尺码
		ActionContext.getContext().put("goodsColors", goodsColors);      //该商品的所有颜色
		ActionContext.getContext().put("goods", goods);                  //商品基本信息
		
		ActionContext.getContext().put("pxwgntj", pxwgntj);
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
