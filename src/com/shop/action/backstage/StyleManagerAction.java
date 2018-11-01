package com.shop.action.backstage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.Brand;
import com.shop.domain.Category;
import com.shop.domain.Style;
import com.shop.service.BrandService;
import com.shop.service.CategoryService;
import com.shop.service.StyleService;

/**
 * @Description: 商品款式的处理类
 */
@Controller("styleManagerAction")
public class StyleManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="styleService")private StyleService styleService;
	@Resource(name="categoryService")private CategoryService categoryService;
	@Resource(name="brandService")private BrandService brandService;
	private Style style;
	
	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	/**
	 * 进入款式管理界面
	 */
	public String styleManagerUI(){
		//获取指定页面的款式
		List<Style> styles = styleService.getStyleByPage(super.getPage(),10);
		
		//获取款式的总数量
		long styleCount = styleService.getStyleCount();
		pageSum = (int)(styleCount%10==0?styleCount/10:styleCount/10+1);
		
		//获取分类
		List<Category> categories = categoryService.getAllCategory();
		
		//获取品牌
		List<Brand> brands = brandService.getAllBrands();
		
		int brandRow = brands.size()%6==0?brands.size()/6:brands.size()/6+1;     //品牌行数
		int endBrand = brands.size()%6==0?6:brands.size()%6;                     //品牌最后一行个数
		
		ActionContext.getContext().put("brands", brands);      
		ActionContext.getContext().put("brandRow", brandRow);
		ActionContext.getContext().put("endBrand", endBrand);
		ActionContext.getContext().put("styles", styles);
		ActionContext.getContext().put("categories", categories); 
		return "styleManagerUI";
	}
	
	/**
	 * 获取款式的编号
	 */         
	public void getStyleId(){
		String styleId = styleService.getStyleId();
		try {
			response.getWriter().print(styleId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断款式名是否重复
	 */
	public void styleNameRep(){
		response.setCharacterEncoding("utf-8");
		
		String styleName = request.getParameter("styleName");
		Style style = styleService.getStyleByName(styleName);
		//如果style!=null 则返回存在，否则返回不存在
		try {
			if(style!=null){
				response.getWriter().print("{\"content\":\"该名称已经存在..\"}");
			}
			else {
				response.getWriter().print("{\"content\":\"该名称可以使用\"}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 增加或者修改款式
	 */
	public void saveOrUpdateStyle(){
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		//获取分类
		String categoryId = request.getParameter("categoryId");
		String brandName = request.getParameter("brands");
		
		//增加款式
		styleService.saveOrUpdateStyle(getStyle(),categoryId,brandName);
		
		//重定向，如果修改则需要传递页码过去，增加则不需要
		try {
			if("add".equals(type))
				response.sendRedirect("../goodsManager/styleManager_styleManagerUI.action");
			if("update".equals(type)){
				response.sendRedirect("../goodsManager/goods/styleManager_styleManagerUI.action?page="+page);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * 删除款式
	 */
	public void deleteStyle(){
		//获取编号id
		String styleId = request.getParameter("styleId");
		String page = request.getParameter("page");
		styleService.deleteStyle(styleId);
				
		try {
			response.sendRedirect("../goodsManager/styleManager_styleManagerUI.action?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

