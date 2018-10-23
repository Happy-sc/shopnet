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
	 * ���ݷ����ȡ��Ʒ��Ϣ
	 * �����з�ҳ����
	 * @return
	 */
	public String showGoodsByCategory(){
		//��ȡ��ѯ����
		String categoryId = request.getParameter("categoryId");
		String styleId = request.getParameter("style");
		String brandId = request.getParameter("brandId");
		String size = request.getParameter("size");
		String sex = request.getParameter("sex");
		String price = request.getParameter("price");
		
		String pageString = request.getParameter("page");
		int page = pageString==null||Integer.valueOf(pageString)==0?1:Integer.valueOf(pageString);      //��ҳ
		Category category = categoryService.getCategoryById(categoryId);                             //��ȡ�÷���
		List<GoodsListing> goods = goodsService.getGoodsByCategoryPage(categoryId,styleId,brandId,size,sex,price, 24,page);         //��ȡ�÷������Ʒ��Ϣ
		List<Style> styles = styleService.getStyleByCategoryId(categoryId);                          //��ȡ�÷���Ŀ�ʽ     
		List<Brand> brands = brandService.getBrandByStyle(styles);                                   //��ȡ�÷����Ʒ��
		List<GoodsListing> recommandGoods = goodsService.getRecommandGoodsByCategory(categoryId);    //��ȡ�÷�����Ƽ���Ʒ
		
		//��ҳѡ���
		List<GoodsListing> goodsSum = goodsService.getGoodsSumByCategory(categoryId);             //��ȡ�÷��������Ʒ��
		int pageSum = goodsSum.size()%24==0?goodsSum.size()/24:goodsSum.size()/24+1;           //�ܷ�ҳ��ÿҳ24��
		
		//ҳ������
		int rows;
		if(goods.size()==0){
			rows = 0;
		}
		else {
			rows = goods.size()%4==0?goods.size()/4:goods.size()/4+1;
		}
		
		//��ȡ���з���Ŀ�ʽ
		List<Style> sneakersStyles = styleService.getStyleByCategoryId("200001");               //�˶�Ь
		List<Style> womenShoesStyles = styleService.getStyleByCategoryId("200003");             //ŮЬ
		List<Style> menShoesStyles = styleService.getStyleByCategoryId("200002");               //��Ь
		List<Style> childrenShoeStyles = styleService.getStyleByCategoryId("200004");           //��ͯЬ
		List<Style> outdoorShoeStyles = styleService.getStyleByCategoryId("200005");            //����Ь
		
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
