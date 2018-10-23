package com.paixie.action.backstage;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.DealString;
import com.paixie.common.GetSavePath;
import com.paixie.common.ProduceId;
import com.paixie.domain.Brand;
import com.paixie.domain.Category;
import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.Storage;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.CategoryService;
import com.paixie.service.GoodsService;
import com.paixie.service.StorageService;
import com.paixie.service.StyleService;

/**
 * ��Ʒ����
 */
@Controller("goodsManagerAction")
public class GoodsManagerAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="storageService")
	private StorageService storageService;
	@Resource(name="categoryService")
	private CategoryService categoryService;
	@Resource(name="styleService")
	private StyleService styleService;
	@Resource(name="brandService")
	private BrandService brandService;
	@Resource(name="goodsService")
	private GoodsService goodsService;
	
	private File goodsImage;                     //��װ�ϴ�ͼƬ
	private String goodsImageFileName;           //��װ�ϴ�ͼƬ����
	private String goodsImageContentType;        //��װ�ϴ�ͼƬ����
	private GoodsListing goods;           //��Ʒ��Ϣ�б�
	

	public File getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(File goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsImageFileName() {
		return goodsImageFileName;
	}

	public void setGoodsImageFileName(String goodsImageFileName) {
		this.goodsImageFileName = goodsImageFileName;
	}

	public String getGoodsImageContentType() {
		return goodsImageContentType;
	}

	public void setGoodsImageContentType(String goodsImageContentType) {
		this.goodsImageContentType = goodsImageContentType;
	}
	
	public GoodsListing getGoods() {
		return goods;
	}

	public void setGoods(GoodsListing goods) {
		this.goods = goods;
	}

	/**
	 * �����Ʒҳ��
	 * @return
	 */
	public String addGoodsUI(){
		//��ȡ��Ʒ������
		String goodsId = ProduceId.getId();
		//��ȡ���еĲֿ�
		List<Storage> storages = storageService.getAllStorage();
		//��ȡ���е���Ʒ����
		List<Category> categories = categoryService.getAllCategory();
		
		ActionContext.getContext().put("goodsId", goodsId);
		ActionContext.getContext().put("storages", storages);
		ActionContext.getContext().put("categories", categories);
		return "addGoodsUI";
	}

	/**
	 * �����Ʒ�б���Ϣ
	 * 
	 */
	public String addGoodsListing(){
		//����ʱ�ļ����Ƶ�ָ��Ŀ¼�£���ֹɾ����ʱ�ļ��󣬶�ʧ�ļ�
		String tempPath = GetSavePath.getSavePath("temp");
		String savePath = GetSavePath.getSavePath("goods");
		
		File file = new File(tempPath+"\\"+getGoodsImage().getName());
		
		try {
			FileUtil.copyFile(getGoodsImage(), file);    //������ʱ�ļ���ָ��Ŀ¼
			goods.setGoodsImageF(file);                  //�����Ƶ���ʱ�ļ����뵽�ļ���
			goods.setGoodsImagePath(savePath+"\\"+getGoodsImageFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//������Ʒ�Ĳֿ⡢���ࡢ��ʽ��Ʒ��
		Storage storage = storageService.getStorageById(goods.getStorage().getStorageId());
		goods.setStorage(storage);
		
		//����
		Category category = categoryService.getCategoryById(goods.getCategory().getCategoryId());
		goods.setCategory(category);
		
		//��ʽ
		Style style = styleService.getStyleById(goods.getStyle().getStyleId());
		goods.setStyle(style);
		
		//Ʒ��
		Brand brand = brandService.getBrandById(goods.getBrand().getBrandId());
		goods.setBrand(brand);
		
		//����ͼƬ·��
		String goodsImagePath = DealString.subAndReplaceString(savePath+"\\"+getGoodsImageFileName());
		goods.setGoodsImage(goodsImagePath);
		goods.setGoodsState(1);     //��ʾΪ����
		
		//������Ʒ���
		//goods.setGoodsId(ProduceId.getId());
		
		//��Ʒ��ɫ
		Set<GoodsColor> goodsColorSet = new HashSet<GoodsColor>();    
		
		//��goods������session���棬��֤��������һ����������
		session.setAttribute("goods", goods);
		session.setAttribute("goodsColorSet", goodsColorSet);    
		
		return "addGoods";
	}
	
	/**
	 * ������Ʒ�����Ż�ȡ���еĿ�ʽ
	 */
	public void getStyle(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String categoryId = request.getParameter("categoryId");
		//��ȡ����Ʒ��ŵ����п�ʽ
		List<Style> styles = styleService.getStyleByCategoryId(categoryId);
		
		//������ʽ�������б�
		StringBuffer buffer = new StringBuffer("<option value='-1'>--��ѡ��--</option>");
		for (int i = 0; i < styles.size(); i++) {
			Style style = styles.get(i);
			String string = "<option value='"+style.getStyleId()+"'>"+style.getStyleName()+"</option>";
			buffer.append(string);
		}
		
		writeToPage(buffer.toString());

	}
	
	/**
	 * ������Ʒ��ʽ��ȡ��Ӧ��Ʒ��
	 */
	public void getBrand(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String styleId = request.getParameter("styleId");
		//��ȡ�ÿ�ʽ������Ʒ��
		List<Brand> brands = brandService.getBrandByStyleId(styleId);
		
		//����Ʒ�Ƶ������б�
		StringBuffer buffer =new StringBuffer("<option value='-1'>--��ѡ��--</option>");
		for (int i = 0; i < brands.size(); i++) {
			Brand brand = brands.get(i);
			String string = "<option value='"+brand.getBrandId()+"'>"+brand.getBrandName()+"</option>";
			buffer.append(string);
		}
		
		writeToPage(buffer.toString());
	}
	
	/**
	 * ������Ʒ��Ϣ
	 * ������Ʒ������Ϣ����Ʒ��ɫ����Ʒ����
	 */
	@SuppressWarnings("unchecked")
	public String saveGoods(){
		//��ȡ��Ʒ������Ϣ
		GoodsListing goods1 = (GoodsListing) session.getAttribute("goods");
		Set<GoodsColor> goodsColor1 = (Set<GoodsColor>) session.getAttribute("goodsColorSet");
		//������Ʒ��Ϣ
		goodsService.saveGoods(goods1,goodsColor1);
		
		//��Ʒ����ɹ���ɾ��session
		session.removeAttribute("goods");
		session.removeAttribute("goodsColorSet");
		
		ActionContext.getContext().put("type", "addGoods");
		return "saveSuccess";
	}
	
	
}

