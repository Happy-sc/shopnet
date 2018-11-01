package com.shop.action.backstage;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.Category;
import com.shop.service.CategoryService;

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
	 * 商品分类管理界面
	 * @return
	 */
	public String categoryManagerUI(){
		//获取所有的分类
		List<Category> categories = categoryService.getAllCategory();
		ActionContext.getContext().put("categorys", categories);
		return "categoryManagerUI";
	}

	/**
	 * 获取分类的编号
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
	 * 判断品牌是否重复
	 */
	public void categoryNameRep(){
		String categoryName = request.getParameter("categoryName");
		Category category1 = categoryService.getCategoryByName(categoryName);
		String flag;
		if(category1!=null){
			flag = "{\"flag\":\"该分类名称已经存在\"}";
		}
		else{
			flag = "{\"flag\":\"该分类名称可以使用\"}";
		}
		
		writeToPage(flag);
	}
	
	/**
	 * 增加或者修改商品分类
	 */
	public String saveOrUpdateCategory(){
		categoryService.saveOrUpdateCategory(getCategory());
		return "categoryManager";
	}
	
	/**
	 * 删除商品分类
	 */
	public String deleteCategory(){
		String categoryId = request.getParameter("categoryId");
		//删除该商品分类
		categoryService.delete(categoryId);
		return "categoryManager";
	}
	
}

