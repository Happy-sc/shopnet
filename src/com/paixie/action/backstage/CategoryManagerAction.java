package com.paixie.action.backstage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Category;
import com.paixie.service.CategoryService;

@Controller("categoryManagerAction")
public class CategoryManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="categoryService")private CategoryService categoryService;
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * ��Ʒ����������
	 * @return
	 */
	public String categoryManagerUI(){
		//��ȡ���еķ���
		List<Category> categories = categoryService.getAllCategory();
		ActionContext.getContext().put("categorys", categories);
		return "categoryManagerUI";
	}

	/**
	 * ��ȡ����ı��
	 * @return
	 */
	public void getCategoryId(){
		String categoryId = categoryService.getCategoryId();
		try {
			response.getWriter().print(categoryId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ж�Ʒ���Ƿ��ظ�
	 */
	public void categoryNameRep(){
		String categoryName = request.getParameter("categoryName");
		Category category1 = categoryService.getCategoryByName(categoryName);
		String flag;
		if(category1!=null){
			flag = "{\"flag\":\"�÷��������Ѿ�����\"}";
		}
		else{
			flag = "{\"flag\":\"�÷������ƿ���ʹ��\"}";
		}
		
		writeToPage(flag);
	}
	
	/**
	 * ���ӻ����޸���Ʒ����
	 */
	public String saveOrUpdateCategory(){
		categoryService.saveOrUpdateCategory(getCategory());
		return "categoryManager";
	}
	
	/**
	 * ɾ����Ʒ����
	 */
	public String deleteCategory(){
		String categoryId = request.getParameter("categoryId");
		//ɾ������Ʒ����
		categoryService.delete(categoryId);
		return "categoryManager";
	}
	
}

