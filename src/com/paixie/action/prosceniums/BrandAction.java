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
	 * ��ȡ���õ�Ʒ��
	 * ����Ʒ��ƴ���Ŀ�ͷ������Ʒ��
	 * ���ݷ����ȡƷ��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getAllBrands(){
		List<Object> brandArray = new ArrayList<Object>();

		//��ȡ��ĸ��ͷ��Ʒ��
		for(int i = 65;i<=90;i++){
			char c = (char) i;
			List<Brand> brands = brandService.getBrandBypytb(String.valueOf(c));
			brandArray.add(brands);
			
		}
		
		//��ȡ0-9��ͷ��Ʒ��
		List<Brand> numBrands = brandService.getBrandBypytb("0-9");
		
		//���ݷ�������ȡƷ��
		List<Brand> sneakerBrands = brandService.getBrandByCategory("200001");          //��ȡ�˶�Ь��Ʒ��
		List<Brand> manBrands = brandService.getBrandByCategory("200002");              //��ȡ��Ь��Ʒ��
		List<Brand> womanBrands = brandService.getBrandByCategory("200003");            //��ȡŮЬ��Ʒ��
		List<Brand> childrenBrands = brandService.getBrandByCategory("200004");         //��ȡͯЬ��Ʒ��
		List<Brand> outdoorBrands = brandService.getBrandByCategory("200005");          //��ȡ����Ь��Ʒ��
		
		/*
		 * �����ַ�����ȡƷ��
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
