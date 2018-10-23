package com.paixie.action.prosceniums;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Brand;
import com.paixie.domain.Comment;
import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.GoodsSize;
import com.paixie.domain.Style;
import com.paixie.service.BrandService;
import com.paixie.service.CommentService;
import com.paixie.service.GoodsColorService;
import com.paixie.service.GoodsService;
import com.paixie.service.GoodsSizeService;
import com.paixie.service.StyleService;

@Controller("goodsAction")
public class GoodsAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="brandService") private BrandService brandService;
	@Resource(name="goodsService") private GoodsService goodsService;
	@Resource(name="styleService") private StyleService styleService;
	@Resource(name="commentService") private CommentService commentService;
	@Resource(name="goodsColorService")private GoodsColorService goodsColorService;
	@Resource(name="goodsSizeService")private GoodsSizeService goodsSizeService;
	
	private String goodsId;           //��Ʒ���

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	/**
	 * ���빺����վ��ҳ
	 * @return
	 */
	public String goodsIndexUI(){
		//��ȡǰ29��Ʒ��Ʒ��
		List<Brand> brands = brandService.getBrand(29);
		
		//��ȡ�ؼ���Ʒ(������Ʒ��ǰ10��)
		List<GoodsListing> specialOfferGoods = goodsService.getGoodsOrderString("goodsPaiPrice","asc");
		//��ȡ������Ʒ
		List<GoodsListing> bestSellerGoods = goodsService.getGoodsOrderString("goodsMarketNumber", "asc");
		//��ȡ�»���Ʒ
		List<GoodsListing> newestGoods = goodsService.getGoodsOrderString("goodsGrounding", "desc");
		//��ȡ������Ʒ
		List<GoodsListing> lackGoods = goodsService.getgoodsByGoodsExitNumber();
		//��ȡ�Ƽ���Ʒ
		List<GoodsListing> recommendGoods = goodsService.getGoodsByRecommend(10);
		
		
		//��ȡǰ��10���˶�Ь,����ʱ������
		List<GoodsListing> sneakers = goodsService.getGoodsByCategoryOrder("200001",10);        //�˶�Ь
		List<GoodsListing> womenShoes = goodsService.getGoodsByCategoryOrder("200003", 10);     //ŮЬ
		List<GoodsListing> menShoes = goodsService.getGoodsByCategoryOrder("200002", 10);       //��Ь
		List<GoodsListing> childrenShoes = goodsService.getGoodsByCategoryOrder("200004", 10);  //ͯЬ
		List<GoodsListing> outdoorShoes = goodsService.getGoodsByCategoryOrder("200005", 10);   //����Ь
		
		//��ȡ�������ؿ�ʽ
		List<Style> sneakersStyles = styleService.getStyleByCategoryId("200001");               
		List<Style> womenShoesStyles = styleService.getStyleByCategoryId("200003");             
		List<Style> menShoesStyles = styleService.getStyleByCategoryId("200002");               
		List<Style> childrenShoeStyles = styleService.getStyleByCategoryId("200004");
		List<Style> outdoorShoeStyles = styleService.getStyleByCategoryId("200005");
		
		//��ȡ�÷����Ʒ��
		List<Brand> sneakerBrands = brandService.getBrandByCategory("200001");
		List<Brand> womenBrands = brandService.getBrandByCategory("200003");
		List<Brand> menBrands = brandService.getBrandByCategory("200002");
		List<Brand> childrenBrands = brandService.getBrandByCategory("200004");
		List<Brand> outdoorBrands = brandService.getBrandByCategory("200005");
		
		//��������
		ActionContext.getContext().put("specialOfferGoods", specialOfferGoods);
		ActionContext.getContext().put("recommendGoods", recommendGoods);
		ActionContext.getContext().put("bestSellerGoods", bestSellerGoods);
		ActionContext.getContext().put("newestGoods", newestGoods);
		ActionContext.getContext().put("lackGoods", lackGoods);
		
		ActionContext.getContext().put("brands", brands);
		
		ActionContext.getContext().put("sneakers", sneakers);
		ActionContext.getContext().put("menShoes", menShoes);
		ActionContext.getContext().put("childrenShoes", childrenShoes);
		ActionContext.getContext().put("womenShoes", womenShoes);
		ActionContext.getContext().put("outdoorShoes", outdoorShoes);
		
		ActionContext.getContext().put("sneakersStyles", sneakersStyles);
		ActionContext.getContext().put("womenShoesStyles", womenShoesStyles);
		ActionContext.getContext().put("menShoesStyles", menShoesStyles);
		ActionContext.getContext().put("childrenShoeStyles", childrenShoeStyles);
		ActionContext.getContext().put("outdoorShoeStyles", outdoorShoeStyles);
		
		ActionContext.getContext().put("senakersSum",sneakersStyles.size()%2==0?sneakersStyles.size()/2:sneakersStyles.size()/2+1);
		ActionContext.getContext().put("womenSum",womenShoesStyles.size()%2==0?womenShoesStyles.size()/2:womenShoesStyles.size()/2+1);
		ActionContext.getContext().put("menSum",menShoesStyles.size()%2==0?menShoesStyles.size()/2:menShoesStyles.size()/2+1);
		ActionContext.getContext().put("chilidrenSum",childrenShoeStyles.size()%2==0?childrenShoeStyles.size()/2:childrenShoeStyles.size()/2+1);
		ActionContext.getContext().put("outdoorSum",outdoorShoeStyles.size()%2==0?outdoorShoeStyles.size()/2:outdoorShoeStyles.size()/2+1);
		
		ActionContext.getContext().put("sneakerBrands", sneakerBrands);
		ActionContext.getContext().put("womenBrands", womenBrands);
		ActionContext.getContext().put("menBrands", menBrands);
		ActionContext.getContext().put("childrenBrands", childrenBrands);
		ActionContext.getContext().put("outdoorBrands", outdoorBrands);
		return "goodsIndexUI";
	}
	
	/**
	 * �鿴��Ʒ��ϸ��Ϣ
	 */
	public String showGoods(){
		//��ȡ��Ʒ��ɫ
		String color  = request.getParameter("color");
		//������Ʒ��Ż�ȡ��Ʒ������Ϣ
		GoodsListing goods = goodsService.getGoodsById(getGoodsId());
		
		//������Ʒ��Ż�ȡ��Ʒ��������ɫ
		List<GoodsColor> goodsColors = goodsColorService.getGoodsColorByGoodsId(goodsId);
		
		//����goods��color���жϸ���Ʒ��ɫʵ��
		GoodsColor goodsColor = goodsColorService.getGoodsColorByColor(goods,color);
		
		//��ȡ������Ʒ��ɫ�ĳ���
		List<GoodsSize> goodsSizes = goodsSizeService.getGoodsSize(goodsColor.getGoodsColorId());
		
		//��ȡǰ5���Ƽ���Ʒ
		List<GoodsListing> pxwgntj = goodsService.getGoodsByRecommend(5);
		//ͬ����ǰ5��������Ʒ
		List<GoodsListing> tkrxsp = goodsService.getMostSaleByStyle(goods.getStyle().getStyleId());
		
		//��ȡ������Ʒ������
		List<Comment> comments = commentService.getCommentByGoods(getGoodsId(),10,1);
		
		//��ȡ��Ʒ��������������,����ҳ�����
		int commentSum  = commentService.getCommentSumByGoods(getGoodsId());
		pageSum = commentSum%10==0?commentSum/10:commentSum/10+1;
		
		//��Ʒ���ִ���
		int sum_5 = commentService.getGoodsGradeSum(getGoodsId(),5);      //5��
		int sum_4 = commentService.getGoodsGradeSum(getGoodsId(),4);      //4��
		int sum_3 = commentService.getGoodsGradeSum(getGoodsId(),3);      //3��
		int sum_2 = commentService.getGoodsGradeSum(getGoodsId(),2);      //2��
		int sum_1 = commentService.getGoodsGradeSum(getGoodsId(),1);      //1��
		
		//����������
		int sum = sum_1+sum_2+sum_3+sum_4+sum_5;
		
		//�����ֵ�ƽ����
		String avg = getCommentAvg(sum_1, sum_2, sum_3, sum_4, sum_5,"#.0");
		
		if("".equals(color)){
			ActionContext.getContext().put("source", "image");
		}
		
		String sumA = getCommentAvg(sum_1, sum_2, sum_3, sum_4, sum_5,"#");
		
		ActionContext.getContext().put("goodsColor", goodsColor);        //��Ʒ��ɫ
		ActionContext.getContext().put("goodsSizes", goodsSizes);        //��ǰ��ɫ�ĳ���
		ActionContext.getContext().put("goodsColors", goodsColors);      //����Ʒ��������ɫ
		ActionContext.getContext().put("goods", goods);                  //��Ʒ������Ϣ
		
		ActionContext.getContext().put("pxwgntj", pxwgntj);
		ActionContext.getContext().put("tlrxsp", tkrxsp);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("commentSum", commentSum);
		ActionContext.getContext().put("sum_1", sum_1);
		ActionContext.getContext().put("sum_2", sum_2);
		ActionContext.getContext().put("sum_3", sum_3);
		ActionContext.getContext().put("sum_4", sum_4);
		ActionContext.getContext().put("sum_5", sum_5);
		ActionContext.getContext().put("sumAvg", avg);
		ActionContext.getContext().put("sumA", sumA);
		ActionContext.getContext().put("sum", sum);
		return "showGoods";
	}
	
	/**
	 * ��ȡ���۵�ƽ����:����һλС��
	 * @param sum_1  :1�ֵ�����
	 * @param sum_2  :2�ֵ�����
	 * @param sum_3	 :3�ֵ�����
	 * @param sum_4  :4�ֵ�����
	 * @param sum_5  :5�ֵ�����
	 * @param blxs   :����С��λ��
	 * @return
	 */
	public String getCommentAvg(int sum_1,int sum_2,int sum_3,int sum_4,int sum_5,String blxs){
		double sumAvg;          //ƽ����       
		int sum = sum_1+sum_2+sum_3+sum_4+sum_5;
		
		if(sum_5+sum_4+sum_3+sum_2+sum_1!=0){
			sumAvg = (sum_5*5+sum_4*4+sum_3*3+sum_2*2+sum_1)*1.0/(sum);
		}
		else {
			sumAvg = 5;
		}
		
		DecimalFormat format = new DecimalFormat(blxs);   //����һλС��
		
		return format.format(sumAvg);
	}

	
}
