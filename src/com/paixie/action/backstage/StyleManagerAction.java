package com.paixie.action.backstage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Brand;
import com.paixie.domain.Category;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.CategoryService;
import com.paixie.service.StyleService;

/**
 * @Description: ��Ʒ��ʽ�Ĵ�����
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
	 * �����ʽ�������
	 */
	public String styleManagerUI(){
		//��ȡָ��ҳ��Ŀ�ʽ
		List<Style> styles = styleService.getStyleByPage(super.getPage(),10);
		
		//��ȡ��ʽ��������
		long styleCount = styleService.getStyleCount();
		pageSum = (int)(styleCount%10==0?styleCount/10:styleCount/10+1);
		
		//��ȡ����
		List<Category> categories = categoryService.getAllCategory();
		
		//��ȡƷ��
		List<Brand> brands = brandService.getAllBrands();
		
		int brandRow = brands.size()%6==0?brands.size()/6:brands.size()/6+1;     //Ʒ������
		int endBrand = brands.size()%6==0?6:brands.size()%6;                     //Ʒ�����һ�и���
		
		ActionContext.getContext().put("brands", brands);      
		ActionContext.getContext().put("brandRow", brandRow);
		ActionContext.getContext().put("endBrand", endBrand);
		ActionContext.getContext().put("styles", styles);
		ActionContext.getContext().put("categories", categories); 
		return "styleManagerUI";
	}
	
	/**
	 * ��ȡ��ʽ�ı��
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
	 * �жϿ�ʽ���Ƿ��ظ�
	 */
	public void styleNameRep(){
		response.setCharacterEncoding("utf-8");
		
		String styleName = request.getParameter("styleName");
		Style style = styleService.getStyleByName(styleName);
		//���style!=null �򷵻ش��ڣ����򷵻ز�����
		try {
			if(style!=null){
				response.getWriter().print("{\"content\":\"�������Ѿ�����..\"}");
			}
			else {
				response.getWriter().print("{\"content\":\"�����ƿ���ʹ��\"}");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ӻ����޸Ŀ�ʽ
	 */
	public void saveOrUpdateStyle(){
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		//��ȡ����
		String categoryId = request.getParameter("categoryId");
		String brandName = request.getParameter("brands");
		
		//���ӿ�ʽ
		styleService.saveOrUpdateStyle(getStyle(),categoryId,brandName);
		
		//�ض�������޸�����Ҫ����ҳ���ȥ����������Ҫ
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
	 * ɾ����ʽ
	 */
	public void deleteStyle(){
		//��ȡ���id
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

