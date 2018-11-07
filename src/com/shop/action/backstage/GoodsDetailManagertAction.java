package com.shop.action.backstage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aspectj.util.FileUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.DealString;
import com.shop.common.GetSavePath;
import com.shop.common.ProduceId;
import com.shop.domain.GoodsColor;
import com.shop.domain.GoodsSize;

@Controller("goodsDetailManagertAction")
@Scope("prototype")
public class GoodsDetailManagertAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private GoodsColor goodsColor;              //商品颜色
	private List<GoodsSize> goodsSizeS = new ArrayList<GoodsSize>();          //商品属性
	private List<GoodsSize> goodsSizeN = new ArrayList<GoodsSize>();          //商品数量
	private File goodsImage; 					// 封装上传图片
	private String goodsImageFileName; 			// 封装上传图片名称
	private String goodsImageContentType; 		// 封装上传图片类型

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
	
	public GoodsColor getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(GoodsColor goodsColor) {
		this.goodsColor = goodsColor;
	}

	public List<GoodsSize> getGoodsSizeS() {
		return goodsSizeS;
	}

	public void setGoodsSizeS(List<GoodsSize> goodsSizeS) {
		this.goodsSizeS = goodsSizeS;
	}

	public List<GoodsSize> getGoodsSizeN() {
		return goodsSizeN;
	}

	public void setGoodsSizeN(List<GoodsSize> goodsSizeN) {
		this.goodsSizeN = goodsSizeN;
	}

	/**
	 * 添加商品详情
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String addGoodsDetail(){
		//将临时文件复制到指定目录下，防止删除临时文件后，丢失文件
		String tempPath = GetSavePath.getSavePath("temp");
		String savePath = GetSavePath.getSavePath("goods");
		
		//获取商品颜色
		Set<GoodsColor> goodsColorSet = (Set<GoodsColor>) session.getAttribute("goodsColorSet");
		//处理商品图片
		
		//处理商品颜色
		String color = getGoodsColor().getGoodsColor().split(",")[0];    //颜色
		String colorId = ProduceId.getId();                 //商品颜色id
		GoodsColor goodsColor1 = new GoodsColor();          //商品颜色实例
		goodsColor1.setGoodsColorId(colorId);               //商品颜色id
		goodsColor1.setGoodsColor(color);                   //商品颜色
		String goodsColorImage = DealString.subAndReplaceString(savePath+"\\"+getGoodsImageFileName());
		goodsColor1.setGoodsImage(goodsColorImage);          //保存图片路径
		
		File file = new File(tempPath+"\\"+getGoodsImage().getName());
		try {
			FileUtil.copyFile(getGoodsImage(), file);    //复制临时文件到指定目录
			goodsColor1.setGoodsImageFile(file);                  //将复制的临时文件放入到文件中
			goodsColor1.setGoodsImagePath(savePath+"\\"+getGoodsImageFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		//处理商品尺码
		Set<GoodsSize> goodsSizeSet = new HashSet<GoodsSize>();    //商品数量集合
		for(int i = 0; i < goodsSizeS.size();i++){
			GoodsSize goodsSize1 = new GoodsSize();
			String goodsSizeId = ProduceId.getId();
			goodsSize1.setGoodsSizeId(goodsSizeId);      //属性编号
			goodsSize1.setGoodsAttr(goodsSizeS.get(i).getGoodsAttr());//属性
			goodsSize1.setGoodsNumber(goodsSizeN.get(i).getGoodsNumber());     //商品数量
			goodsSizeSet.add(goodsSize1);
		}
		goodsColor1.setGoodsSizeSet(goodsSizeSet);       //将尺码添加到颜色中
		goodsColorSet.add(goodsColor1);
		
		session.setAttribute("goodsColorSet", goodsColorSet);
		ActionContext.getContext().put("type", "goodsDetail");
		
		return "addGoodsDetail";
	}
	
	/**
	 * 转到添加商品详情界面
	 */
	public String addGoodsDetailUI(){
		return "addGoodsDetailUI";
	}

}
