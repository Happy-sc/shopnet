package com.paixie.action.backstage;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.DealString;
import com.paixie.common.GetSavePath;
import com.paixie.common.UploadAndDeleteImage;
import com.paixie.domain.Brand;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.StyleService;

/**
 * @Description: 品牌管理的action
 */
@Controller("brandManagerAction")
public class BrandManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="brandService")
	private BrandService brandService;
	@Resource(name="styleService")
	private StyleService styleService;
	@Resource(name="uploadAndDeleteImage")
	private UploadAndDeleteImage uploadAndDeleteImage;
	
	private Brand brand;                       //品牌
	private File brandImage;                   //上传文件域
	private String brandImageContentType;      //上传文件类型
	private String brandImageFileName;         //上传文件名
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public File getBrandImage() {
		return brandImage;
	}

	public void setBrandImage(File brandImage) {
		this.brandImage = brandImage;
	}

	public String getBrandImageContentType() {
		return brandImageContentType;
	}

	public void setBrandImageContentType(String brandImageContentType) {
		this.brandImageContentType = brandImageContentType;
	}

	public String getBrandImageFileName() {
		return brandImageFileName;
	}

	public void setBrandImageFileName(String brandImageFileName) {
		this.brandImageFileName = brandImageFileName;
	}

	/**
	 * 进入品牌管理界面
	 */
	public String brandManagerUI(){
		//获取指定页面的品牌
		List<Brand> brands = brandService.getBrandByPage(super.getPage(),8);
		//获取全部的品牌
		long brandCount = brandService.getBrandCount();
		//总页数
		pageSum = (int)(brandCount%8==0?brandCount/8:brandCount/8+1);
		
		//获取全部的款式
		List<Style> styles = styleService.getAllStyle();
		//获取款式的总数量
		int styleSum = (int)styleService.getStyleCount();
		int styleCount = styleSum%7==0?styleSum/7:styleSum/7+1;
		int styleEnd = styleSum%7==0?7:styleSum%7;
		
		ActionContext.getContext().put("brands", brands);
		ActionContext.getContext().put("styles", styles);
		ActionContext.getContext().put("styleCount", styleCount);
		ActionContext.getContext().put("styleEnd", styleEnd);
		return "brandManagerUI";
	}
	
	/**
	 * 取得品牌的编号
	 */
	public void getBrandId(){
		String id = brandService.getBrandId();
		try {
			response.getWriter().print(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断品牌是否存在
	 */
	public void brandIsExit(){
		String brandS = request.getParameter("brandName");
		String type = request.getParameter("brandType");
		Brand brand1;
		if("spell".equals(type)){     //如果为拼音,则更加拼音来获取
			//根据名称获取
			brand1 = brandService.getBrandBySpell(brandS);
		}
		else {
			brand1 = brandService.getBrandByName(brandS);
		}
		String flag ;
		if(brand1==null){
			flag = "该名称可以使用";
		}
		else {
			flag = "该名称已经存在";
		}
		
		writeToPage(flag);
	}
	
	/**
	 * 增加或者修改品牌
	 */
	public void saveOrUpdateBrand(){
		//获取参数
		
		String type = request.getParameter("type");     //类别：增加或者修改
		String page = request.getParameter("page");     //指定页面
		String style = request.getParameter("style");   //包含款式

		String savePath = GetSavePath.getSavePath("brand");
		//根据编号获取该品牌实例
		Brand brand1 = brandService.getBrandById(getBrand().getBrandId());
		//如果图片不为空，上传保存
		if(getBrandImage()!=null){
			//上传图片
			uploadAndDeleteImage.upload(getBrandImage(), savePath+"\\"+getBrandImageFileName());
			//如果以前的图片存在，则删除该图片
			
			if(brand1!=null&&brand1.getBrandImage()!=null){
				//获取文件名
				String[] fileName = brand1.getBrandImage().split("/");
				String brandImageName = fileName[fileName.length-1];
				
				uploadAndDeleteImage.delete(savePath+"\\"+brandImageName);
			}
			
			//保存用户上传的图片
			//处理图片路径
			String brandImage = DealString.subAndReplaceString(savePath+"\\"+getBrandImageFileName());
			getBrand().setBrandImage(brandImage);
		}
		else{ 
			brand.setBrandImage(brand1.getBrandImage());
		}
		//保存或者修改品牌
		brandService.saveOrUpdateBrand(getBrand(),style);
		
		//重定向
		try {
			if("add".equals(type)){
				response.sendRedirect("../goodsManager/brandManager_brandManagerUI.action");
			}
			if("update".equals(type)){
				response.sendRedirect("../goodsManager/brandManager_brandManagerUI.action?page="+page);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	/**
	 * 删除品牌
	 */
	public void deleteBrand(){
		String brandId = request.getParameter("brandId");
		String page = request.getParameter("page");
		
		//删除品牌
		brandService.deleteBrand(brandId);
		
		try {
			response.sendRedirect("../goodsManager/brandManager_brandManagerUI.action?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
