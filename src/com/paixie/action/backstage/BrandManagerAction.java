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
 * @Description: Ʒ�ƹ����action
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
	
	private Brand brand;                       //Ʒ��
	private File brandImage;                   //�ϴ��ļ���
	private String brandImageContentType;      //�ϴ��ļ�����
	private String brandImageFileName;         //�ϴ��ļ���
	
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
	 * ����Ʒ�ƹ������
	 */
	public String brandManagerUI(){
		//��ȡָ��ҳ���Ʒ��
		List<Brand> brands = brandService.getBrandByPage(super.getPage(),8);
		//��ȡȫ����Ʒ��
		long brandCount = brandService.getBrandCount();
		//��ҳ��
		pageSum = (int)(brandCount%8==0?brandCount/8:brandCount/8+1);
		
		//��ȡȫ���Ŀ�ʽ
		List<Style> styles = styleService.getAllStyle();
		//��ȡ��ʽ��������
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
	 * ȡ��Ʒ�Ƶı��
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
	 * �ж�Ʒ���Ƿ����
	 */
	public void brandIsExit(){
		String brandS = request.getParameter("brandName");
		String type = request.getParameter("brandType");
		Brand brand1;
		if("spell".equals(type)){     //���Ϊƴ��,�����ƴ������ȡ
			//�������ƻ�ȡ
			brand1 = brandService.getBrandBySpell(brandS);
		}
		else {
			brand1 = brandService.getBrandByName(brandS);
		}
		String flag ;
		if(brand1==null){
			flag = "�����ƿ���ʹ��";
		}
		else {
			flag = "�������Ѿ�����";
		}
		
		writeToPage(flag);
	}
	
	/**
	 * ���ӻ����޸�Ʒ��
	 */
	public void saveOrUpdateBrand(){
		//��ȡ����
		
		String type = request.getParameter("type");     //������ӻ����޸�
		String page = request.getParameter("page");     //ָ��ҳ��
		String style = request.getParameter("style");   //������ʽ

		String savePath = GetSavePath.getSavePath("brand");
		//���ݱ�Ż�ȡ��Ʒ��ʵ��
		Brand brand1 = brandService.getBrandById(getBrand().getBrandId());
		//���ͼƬ��Ϊ�գ��ϴ�����
		if(getBrandImage()!=null){
			//�ϴ�ͼƬ
			uploadAndDeleteImage.upload(getBrandImage(), savePath+"\\"+getBrandImageFileName());
			//�����ǰ��ͼƬ���ڣ���ɾ����ͼƬ
			
			if(brand1!=null&&brand1.getBrandImage()!=null){
				//��ȡ�ļ���
				String[] fileName = brand1.getBrandImage().split("/");
				String brandImageName = fileName[fileName.length-1];
				
				uploadAndDeleteImage.delete(savePath+"\\"+brandImageName);
			}
			
			//�����û��ϴ���ͼƬ
			//����ͼƬ·��
			String brandImage = DealString.subAndReplaceString(savePath+"\\"+getBrandImageFileName());
			getBrand().setBrandImage(brandImage);
		}
		else{ 
			brand.setBrandImage(brand1.getBrandImage());
		}
		//��������޸�Ʒ��
		brandService.saveOrUpdateBrand(getBrand(),style);
		
		//�ض���
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
	 * ɾ��Ʒ��
	 */
	public void deleteBrand(){
		String brandId = request.getParameter("brandId");
		String page = request.getParameter("page");
		
		//ɾ��Ʒ��
		brandService.deleteBrand(brandId);
		
		try {
			response.sendRedirect("../goodsManager/brandManager_brandManagerUI.action?page="+page);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
