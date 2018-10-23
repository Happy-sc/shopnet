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
 * 商品管理
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
	
	private File goodsImage;                     //封装上传图片
	private String goodsImageFileName;           //封装上传图片名称
	private String goodsImageContentType;        //封装上传图片类型
	private GoodsListing goods;           //商品信息列表
	

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
	 * 添加商品页面
	 * @return
	 */
	public String addGoodsUI(){
		//获取商品随机编号
		String goodsId = ProduceId.getId();
		//获取所有的仓库
		List<Storage> storages = storageService.getAllStorage();
		//获取所有的商品分类
		List<Category> categories = categoryService.getAllCategory();
		
		ActionContext.getContext().put("goodsId", goodsId);
		ActionContext.getContext().put("storages", storages);
		ActionContext.getContext().put("categories", categories);
		return "addGoodsUI";
	}

	/**
	 * 添加商品列表信息
	 * 
	 */
	public String addGoodsListing(){
		//将临时文件复制到指定目录下，防止删除临时文件后，丢失文件
		String tempPath = GetSavePath.getSavePath("temp");
		String savePath = GetSavePath.getSavePath("goods");
		
		File file = new File(tempPath+"\\"+getGoodsImage().getName());
		
		try {
			FileUtil.copyFile(getGoodsImage(), file);    //复制临时文件到指定目录
			goods.setGoodsImageF(file);                  //将复制的临时文件放入到文件中
			goods.setGoodsImagePath(savePath+"\\"+getGoodsImageFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//处理商品的仓库、分类、款式、品牌
		Storage storage = storageService.getStorageById(goods.getStorage().getStorageId());
		goods.setStorage(storage);
		
		//分类
		Category category = categoryService.getCategoryById(goods.getCategory().getCategoryId());
		goods.setCategory(category);
		
		//款式
		Style style = styleService.getStyleById(goods.getStyle().getStyleId());
		goods.setStyle(style);
		
		//品牌
		Brand brand = brandService.getBrandById(goods.getBrand().getBrandId());
		goods.setBrand(brand);
		
		//处理图片路劲
		String goodsImagePath = DealString.subAndReplaceString(savePath+"\\"+getGoodsImageFileName());
		goods.setGoodsImage(goodsImagePath);
		goods.setGoodsState(1);     //标示为在售
		
		//设置商品编号
		//goods.setGoodsId(ProduceId.getId());
		
		//商品颜色
		Set<GoodsColor> goodsColorSet = new HashSet<GoodsColor>();    
		
		//将goods保存在session里面，保证和详情在一个事务里面
		session.setAttribute("goods", goods);
		session.setAttribute("goodsColorSet", goodsColorSet);    
		
		return "addGoods";
	}
	
	/**
	 * 根据商品分类编号获取所有的款式
	 */
	public void getStyle(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String categoryId = request.getParameter("categoryId");
		//获取该商品编号的所有款式
		List<Style> styles = styleService.getStyleByCategoryId(categoryId);
		
		//构建款式的下拉列表
		StringBuffer buffer = new StringBuffer("<option value='-1'>--请选择--</option>");
		for (int i = 0; i < styles.size(); i++) {
			Style style = styles.get(i);
			String string = "<option value='"+style.getStyleId()+"'>"+style.getStyleName()+"</option>";
			buffer.append(string);
		}
		
		writeToPage(buffer.toString());

	}
	
	/**
	 * 根据商品款式获取相应的品牌
	 */
	public void getBrand(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String styleId = request.getParameter("styleId");
		//获取该款式的所有品牌
		List<Brand> brands = brandService.getBrandByStyleId(styleId);
		
		//构建品牌的下拉列表
		StringBuffer buffer =new StringBuffer("<option value='-1'>--请选择--</option>");
		for (int i = 0; i < brands.size(); i++) {
			Brand brand = brands.get(i);
			String string = "<option value='"+brand.getBrandId()+"'>"+brand.getBrandName()+"</option>";
			buffer.append(string);
		}
		
		writeToPage(buffer.toString());
	}
	
	/**
	 * 保存商品信息
	 * 包括商品基本信息、商品颜色、商品尺码
	 */
	@SuppressWarnings("unchecked")
	public String saveGoods(){
		//获取商品基本信息
		GoodsListing goods1 = (GoodsListing) session.getAttribute("goods");
		Set<GoodsColor> goodsColor1 = (Set<GoodsColor>) session.getAttribute("goodsColorSet");
		//保存商品信息
		goodsService.saveGoods(goods1,goodsColor1);
		
		//商品保存成功后、删除session
		session.removeAttribute("goods");
		session.removeAttribute("goodsColorSet");
		
		ActionContext.getContext().put("type", "addGoods");
		return "saveSuccess";
	}
	
	
}

