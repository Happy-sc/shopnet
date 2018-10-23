package com.paixie.action.prosceniums;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Brand;
import com.paixie.service.BrandService;

@Controller("brandAction")
public class BrandAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="brandService")private BrandService brandService;
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
		
		//根据分类来获取品牌
		List<Brand> sneakerBrands = brandService.getBrandByCategory("200001");          //获取运动鞋的品牌
		List<Brand> manBrands = brandService.getBrandByCategory("200002");              //获取男鞋的品牌
		List<Brand> womanBrands = brandService.getBrandByCategory("200003");            //获取女鞋的品牌
		List<Brand> childrenBrands = brandService.getBrandByCategory("200004");         //获取童鞋的品牌
		List<Brand> outdoorBrands = brandService.getBrandByCategory("200005");          //获取户外鞋的品牌
		
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
		ActionContext.getContext().put("numBrands_rows", numBrands.size()%4==0?sneakerBrands.size()/4:numBrands.size()/4+1);
		ActionContext.getContext().put("numBrands_num", numBrands.size()%4==0?4:numBrands.size()%4);
		ActionContext.getContext().put("sneakerBrands", sneakerBrands);
		ActionContext.getContext().put("sneakerBrands_rows", sneakerBrands.size()%4==0?sneakerBrands.size()/4:sneakerBrands.size()/4+1);
		ActionContext.getContext().put("sneakerBrands_num", sneakerBrands.size()%4==0?4:sneakerBrands.size()%4);
		ActionContext.getContext().put("manBrands", manBrands);
		ActionContext.getContext().put("manBrands_rows", manBrands.size()%4==0?manBrands.size()/4:manBrands.size()/4+1);
		ActionContext.getContext().put("manBrands_num", manBrands.size()%4==0?4:manBrands.size()%4);
		ActionContext.getContext().put("womanBrands", womanBrands);
		ActionContext.getContext().put("womanBrands_rows", womanBrands.size()%4==0?womanBrands.size()/4:womanBrands.size()/4+1);
		ActionContext.getContext().put("womanBrands_num", womanBrands.size()%4==0?4:womanBrands.size()%4);
		ActionContext.getContext().put("childrenBrands", childrenBrands);
		ActionContext.getContext().put("childrenBrands_rows", childrenBrands.size()%4==0?childrenBrands.size()/4:childrenBrands.size()/4+1);
		ActionContext.getContext().put("childrenBrands_num", childrenBrands.size()%4==0?4:childrenBrands.size()%4);
		ActionContext.getContext().put("outdoorBrands", outdoorBrands);
		ActionContext.getContext().put("outdoorBrands_rows", outdoorBrands.size()%4==0?outdoorBrands.size()/4:outdoorBrands.size()/4+1);
		ActionContext.getContext().put("outdoorBrands_num", outdoorBrands.size()%4==0?4:outdoorBrands.size()%4);
		
		return "showAllBrands";
	}
}
