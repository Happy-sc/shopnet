package com.shop.action.prosceniums;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.shop.domain.Category;
import com.shop.service.CategoryService;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.Brand;
import com.shop.service.BrandService;

@Controller("brandAction")
public class BrandAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="brandService")
	private BrandService brandService;
	@Resource(name = "categoryService")
	private CategoryService categoryService;
	/**
	 * 获取所用的品牌
	 * 根据品牌拼音的开头来分类品牌
	 * 根据分类获取品牌
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAllBrands(){
		List<Object> brandArray = new ArrayList<Object>();
		//获取字母开头的品牌
		for(int i = 65;i<=90;i++){
			char c = (char) i;
			List<Brand> brands = brandService.getBrandBypytb(String.valueOf(c));
			brandArray.add(brands);
		}
		//获取0-9开头的品牌
		List<Brand> numBrands = brandService.getBrandBypytb("0-9");

		//获取分类
		List<Category> categorys = categoryService.getAllCategory();
		ActionContext.getContext().put("categorys",categorys);
		
		/*
		 * 根据字符来获取品牌
		 */
		for(int i = 0;i<26;i++){                              
			char c = (char) (i+65);
			List<Brand> brandlist = (List<Brand>) brandArray.get(i);
			ActionContext.getContext().put(c+"Brands",brandlist);
			ActionContext.getContext().put(c+"Brands_rows", brandlist.size()%4==0?brandlist.size()/4:brandlist.size()/4+1);
			ActionContext.getContext().put(c+"Brands_num", brandlist.size()%4==0?4:brandlist.size()%4);
		}
		ActionContext.getContext().put("numBrands", numBrands);
		ActionContext.getContext().put("numBrands_rows", numBrands.size()%4==0?numBrands.size()/4:numBrands.size()/4+1);
		ActionContext.getContext().put("numBrands_num", numBrands.size()%4==0?4:numBrands.size()%4);

		return "showAllBrands";
	}
}
