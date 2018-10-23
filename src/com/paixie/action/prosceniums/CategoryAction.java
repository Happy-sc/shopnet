package com.paixie.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Brand;
import com.paixie.domain.Category;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.CategoryService;
import com.paixie.service.GoodsService;
import com.paixie.service.StyleService;

@Controller("categoryAction")
public class CategoryAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="goodsService")private GoodsService goodsService;
	@Resource(name="styleService")private StyleService styleService;
	@Resource(name="brandService")private BrandService brandService;
	@Resource(name="categoryService")private CategoryService categoryService;
	
	/**
	 * 根据分类获取商品信息
	 * 并进行分页处理
	 * @return
	 */
	public String showGoodsByCategory(){
		//获取查询条件
		String categoryId = request.getParameter("categoryId");
		String styleId = request.getParameter("style");
		String brandId = request.getParameter("brandId");
		String size = request.getParameter("size");
		String sex = request.getParameter("sex");
		String price = request.getParameter("price");
		
		String pageString = request.getParameter("page");
		int page = pageString==null||Integer.valueOf(pageString)==0?1:Integer.valueOf(pageString);      //该页
		Category category = categoryService.getCategoryById(categoryId);                             //获取该分类
		List<GoodsListing> goods = goodsService.getGoodsByCategoryPage(categoryId,styleId,brandId,size,sex,price, 24,page);         //获取该分类的商品信息
		List<Style> styles = styleService.getStyleByCategoryId(categoryId);                          //获取该分类的款式     
		List<Brand> brands = brandService.getBrandByStyle(styles);                                   //获取该分类的品牌
		List<GoodsListing> recommandGoods = goodsService.getRecommandGoodsByCategory(categoryId);    //获取该分类的推荐商品
		
		//分页选项处理
		List<GoodsListing> goodsSum = goodsService.getGoodsSumByCategory(categoryId);             //获取该分类的总商品量
		int pageSum = goodsSum.size()%24==0?goodsSum.size()/24:goodsSum.size()/24+1;           //总分页，每页24个
		
		//页数处理
		int rows;
		if(goods.size()==0){
			rows = 0;
		}
		else {
			rows = goods.size()%4==0?goods.size()/4:goods.size()/4+1;
		}
		
		//获取所有分类的款式
		List<Style> sneakersStyles = styleService.getStyleByCategoryId("200001");               //运动鞋
		List<Style> womenShoesStyles = styleService.getStyleByCategoryId("200003");             //女鞋
		List<Style> menShoesStyles = styleService.getStyleByCategoryId("200002");               //男鞋
		List<Style> childrenShoeStyles = styleService.getStyleByCategoryId("200004");           //儿童鞋
		List<Style> outdoorShoeStyles = styleService.getStyleByCategoryId("200005");            //户外鞋
		
		ActionContext.getContext().put("category", category);
		ActionContext.getContext().put("recommandGoods", recommandGoods);
		ActionContext.getContext().put("goods", goods);
		ActionContext.getContext().put("rows", rows);
		ActionContext.getContext().put("lastNumber", goods.size()%4);
		ActionContext.getContext().put("style", styles);
		ActionContext.getContext().put("brand", brands);
		ActionContext.getContext().put("brandNumber", brands.size()%6==0?brands.size()/6:brands.size()/6+1);
		ActionContext.getContext().put("page", page);
		ActionContext.getContext().put("pageSum", pageSum);
		ActionContext.getContext().put("sneakersStyles", sneakersStyles);
		ActionContext.getContext().put("womenShoesStyles", womenShoesStyles);
		ActionContext.getContext().put("menShoesStyles", menShoesStyles);
		ActionContext.getContext().put("childrenShoeStyles", childrenShoeStyles);
		ActionContext.getContext().put("outdoorShoeStyles", outdoorShoeStyles);
		return "showCategoryGoods";
	}
}
