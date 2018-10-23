package com.paixie.action.backstage;

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
import com.paixie.action.common.BaseAction;
import com.paixie.common.DealString;
import com.paixie.common.GetSavePath;
import com.paixie.common.ProduceId;
import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsSize;

@Controller("goodsDetailManagertAction")
@Scope("prototype")
public class GoodsDetailManagertAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	private GoodsColor goodsColor;              //��Ʒ��ɫ
	private List<GoodsSize> goodsSizeS = new ArrayList<GoodsSize>();          //��Ʒ����
	private List<GoodsSize> goodsSizeN = new ArrayList<GoodsSize>();          //��Ʒ����
	private File goodsImage; 					// ��װ�ϴ�ͼƬ
	private String goodsImageFileName; 			// ��װ�ϴ�ͼƬ����
	private String goodsImageContentType; 		// ��װ�ϴ�ͼƬ����

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
	 * �����Ʒ����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String addGoodsDetail(){
		//����ʱ�ļ����Ƶ�ָ��Ŀ¼�£���ֹɾ����ʱ�ļ��󣬶�ʧ�ļ�
		String tempPath = GetSavePath.getSavePath("temp");
		String savePath = GetSavePath.getSavePath("goods");
		
		//��ȡ��Ʒ��ɫ
		Set<GoodsColor> goodsColorSet = (Set<GoodsColor>) session.getAttribute("goodsColorSet");
		//������ƷͼƬ
		
		//������Ʒ��ɫ
		String color = getGoodsColor().getGoodsColor().split(",")[0];    //��ɫ
		String colorId = ProduceId.getId();                 //��Ʒ��ɫid
		GoodsColor goodsColor1 = new GoodsColor();          //��Ʒ��ɫʵ��
		goodsColor1.setGoodsColorId(colorId);               //��Ʒ��ɫid
		goodsColor1.setGoodsColor(color);                   //��Ʒ��ɫ
		String goodsColorImage = DealString.subAndReplaceString(savePath+"\\"+getGoodsImageFileName());
		goodsColor1.setGoodsImage(goodsColorImage);          //����ͼƬ·��
		
		File file = new File(tempPath+"\\"+getGoodsImage().getName());
		try {
			FileUtil.copyFile(getGoodsImage(), file);    //������ʱ�ļ���ָ��Ŀ¼
			goodsColor1.setGoodsImageFile(file);                  //�����Ƶ���ʱ�ļ����뵽�ļ���
			goodsColor1.setGoodsImagePath(savePath+"\\"+getGoodsImageFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		//������Ʒ����
		Set<GoodsSize> goodsSizeSet = new HashSet<GoodsSize>();    //��Ʒ��������
		for(int i = 0; i < goodsSizeS.size();i++){
			GoodsSize goodsSize1 = new GoodsSize();
			String goodsSizeId = ProduceId.getId();
			goodsSize1.setGoodsSizeId(goodsSizeId);      //������
			goodsSize1.setGoodsSize(goodsSizeS.get(i).getGoodsSize());//�����С
			goodsSize1.setGoodsNumber(goodsSizeN.get(i).getGoodsNumber());     //��Ʒ����
			goodsSizeSet.add(goodsSize1);
		}
		
		goodsColor1.setGoodsSizeSet(goodsSizeSet);       //��������ӵ���ɫ��
		goodsColorSet.add(goodsColor1);
		
		session.setAttribute("goodsColorSet", goodsColorSet);
		ActionContext.getContext().put("type", "goodsDetail");
		
		return "addGoodsDetail";
	}
	
	/**
	 * ת�������Ʒ�������
	 */
	public String addGoodsDetailUI(){
		return "addGoodsDetailUI";
	}

}
