package com.paixie.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.common.UploadAndDeleteImage;
import com.paixie.dao.GoodsColorDao;
import com.paixie.dao.GoodsListingDao;
import com.paixie.dao.GoodsSizeDao;
import com.paixie.domain.GoodsColor;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.GoodsSize;
import com.paixie.domain.OrderDetail;
import com.paixie.service.GoodsColorService;
import com.paixie.service.GoodsService;
import com.paixie.service.GoodsSizeService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Resource(name="goodsListingDao")private GoodsListingDao goodsListingDao;
	@Resource(name="goodsColorDao") private GoodsColorDao goodsColorDao;
	@Resource(name="goodsSizeDao")private GoodsSizeDao goodsSizeDao;
	@Resource(name="uploadAndDeleteImage")private UploadAndDeleteImage uploadAndDeleteImage;
	@Resource(name="goodsColorService")private GoodsColorService goodsColorService;
	@Resource(name="goodsSizeService")private GoodsSizeService goodsSizeService;
	/**
	 * ������Ʒ������Ϣ
	 * @param goods ��Ҫ�������Ʒ������Ϣ
	 */
	public void addGoods(GoodsListing goods) {
		goodsListingDao.save(goods);
	}
	
	/**
	 * ������Ʒ��Ż�ȡ��Ʒ
	 * @param goodsId ��Ʒ���
	 * @return ָ����Ʒ��ŵ���Ʒʵ��
	 */
	public GoodsListing getGoodsById(String goodsId) {
		return goodsListingDao.get(goodsId);
	}

	/**
	 * �޸���Ʒ��Ϣ
	 * @param goodsListing ��Ʒ��Ϣ
	 */
	public void updateGoods(GoodsListing goodsListing) {
		goodsListingDao.update(goodsListing);
	}

	/**
	 * ��ȡָ�������ָ����Ŀ����Ʒ
	 * @param category ָ������
	 * @param count ָ����Ŀ
	 * @return ָ�������ָ����������Ʒ
	 */
	public List<GoodsListing> getGoodsByCategoryOrder(String category, int count) {
		return goodsListingDao.getGoodsByCategory(category,count);
	}

	/**
	 * �����ض�������ȡ��Ʒ����Ҳorder����
	 * @param string �ض�����
	 * @param order ��������
	 * @return ָ��������ָ������˳�����Ʒ
	 */
	public List<GoodsListing> getGoodsOrderString(String string, String order) {
		return goodsListingDao.getGoodsOrderString(string,order);
	}

	/**
	 * ��ȡ�Ƽ���Ʒ
	 * @param number �Ƽ�����
	 * @return ָ���������Ƽ���Ʒ
	 */
	public List<GoodsListing> getGoodsByRecommend(int number) {
		return goodsListingDao.getGoodsByRecommend(number);
	}

	/**
	 * ������Ʒ�ִ�����ȡ��Ʒ��Ϣ
	 * @return
	 */
	public List<GoodsListing> getgoodsByGoodsExitNumber() {
		return goodsListingDao.getGoodsByGoodsExitNumber();
	}

	/**
	 * ��ȡ�÷�����Ƽ���Ʒ�����ϼ�ʱ��Ϊ��׼��ȡǰ5��
	 * @param categoryId ������
	 * @return ǰ5���Ƽ���Ʒ��Ϣ
	 */
	public List<GoodsListing> getRecommandGoodsByCategory(String categoryId) {
		return goodsListingDao.getRecommandGoodsByCategoryId(categoryId);
	}

	/**
	 * ��ȡ�������Ʒ��������
	 * @param categoryId ��Ʒ������
	 * @return �÷�����Ʒ��������
	 */
	public List<GoodsListing> getGoodsSumByCategory(String categoryId) {
		return goodsListingDao.getGoodsSumByCategory(categoryId);
	}

	/**
	 * ��ȡĳ���������Ʒ��Ϣ�������з�ҳ����
	 * @param page ҳ��
	 * @return ָ����Ʒ�����ĳҳ��pageSize����Ʒ��Ϣ
	 */
	public List<GoodsListing> getGoodsByCategoryPage(String categoryId,String styleId, 
			String brandId, String size, String sex,String price, int i, int page) {
		//����HQL���
		String HQL = this.getHQL(categoryId, styleId, brandId, size, sex, price);
		
		return goodsListingDao.getGoodsByOption(HQL,i,page);
	}
	
	/**
	 *  ������ѯ���� 
	 * @param categoryId  ������
	 * @param styleId  ��ʽ���
	 * @param brandId Ʒ�Ʊ��
	 * @param size ����
	 * @param sex ��Ь��ŮЬ
	 * @param price �۸�
	 * @return
	 */
	private String getHQL(String categoryId,String styleId, String brandId, String size, String sex,String price){
		StringBuffer HQL = new StringBuffer("From GoodsListing as g where g.category.categoryId = "+categoryId);
		if(styleId!=null){
			HQL = HQL.append(" and g.style.styleId = "+styleId);
		}
		if(brandId!=null){
			HQL = HQL.append(" and g.brand.brandId = "+brandId);
		}
		if(size!=null){
			HQL = HQL.append(" and g.");
		}
		if(sex!=null){
			HQL = HQL.append(" and g.goodsName like %"+sex+"%");
		}
		if(price!=null){
			
		}
		
		return HQL.toString();
	}

	/**
	 * ��ȡͬ��������Ʒ
	 * @return styleId ��ʽ���
	 * @return ָ����ʽ��Ʒ
	 */
	public List<GoodsListing> getMostSaleByStyle(String styleId) {
		return goodsListingDao.getMostSaleByStyle(styleId);
	}

	/**
	 * ������Ʒ��Ϣ
	 * @param goods  ��Ʒ������Ϣ
	 * @param goodsColor ��Ʒ��ɫ
	 */
	public void saveGoods(GoodsListing goods, Set<GoodsColor> goodsColor) {
		//����Ʒ��ɫ�������Ʒ������Ϣ��
		goods.setGoodsColors(goodsColor);
		
		//������ƷͼƬ
		uploadAndDeleteImage.upload(goods.getGoodsImageF(), goods.getGoodsImagePath());
		//����ʱ�ļ�ɾ��
		goods.getGoodsImageF().delete();
		//������Ʒ��ɫͼƬ
		Iterator<GoodsColor> iterator = goodsColor.iterator();
		while (iterator.hasNext()) {
			GoodsColor color = iterator.next();
			uploadAndDeleteImage.upload(color.getGoodsImageFile(), color.getGoodsImagePath());
			color.getGoodsImageFile().delete();
		}
		
		//������Ʒ��������������
		int goodsSum = getGoodsSum(goodsColor);
		goods.setGoodsExitNumber(goodsSum);    //�ִ���
		goods.setGoodsMarketNumber(0);         //������
		
		//������Ʒ������Ϣ
		goodsListingDao.save(goods);
		//������Ʒ��ɫ
		Set<GoodsColor> colorSet = goods.getGoodsColors();
		Iterator<GoodsColor> iterator1 = colorSet.iterator();
		while (iterator1.hasNext()) {
			GoodsColor color1 = iterator1.next();
			color1.setGoodsListing(goods);
			//������Ʒ��ɫ
			goodsColorService.save(color1);
			
			//������Ʒ����
			Set<GoodsSize> sizeSet = color1.getGoodsSizeSet();
			Iterator<GoodsSize> iterator2 = sizeSet.iterator();
			while(iterator2.hasNext()){
				GoodsSize size = iterator2.next();
				size.setGoodsColor(color1);
				goodsSizeService.save(size);
			}
	
		}
		
	}

	/**
	 * ��ȡ����Ʒ����
	 * @param goodsColors ��Ʒ��ɫ�������������Ʒ������
	 */
	public int getGoodsSum(Set<GoodsColor> goodsColors) {
		int goodsSum = 0;
		Iterator<GoodsColor> iterator = goodsColors.iterator();
		while(iterator.hasNext()){
			GoodsColor color = iterator.next();
			Set<GoodsSize> size = color.getGoodsSizeSet();
			Iterator<GoodsSize> iterator2 = size.iterator();
			while(iterator2.hasNext()){
				GoodsSize size2 = iterator2.next();
				goodsSum = goodsSum + size2.getGoodsNumber();
			}
		}
		return goodsSum;
	}

	/**
	 * ��ȡָ����Ŀ�Ƽ���Ʒ
	 * @param i ��Ŀ
	 * @return
	 */
	public List<GoodsListing> getRecommandGoods(int i) {
		return goodsListingDao.getRecommand(i);
	}

	/**
	 * ���ݶ����޸���Ʒ������Ϣ��������
	 * @param orderDetails ��������
	 */
	public void updateGoodsByOrder(List<OrderDetail> orderDetails) {
		if(orderDetails.size()>0&&orderDetails!=null){
			for(int i = 0;i < orderDetails.size();i++){
				OrderDetail orderDetail = orderDetails.get(i);
				//��Ʒ�ִ���--��������+
				GoodsListing goods = goodsListingDao.get(orderDetail.getGoodsListing().getGoodsId());
				int exitNumber = goods.getGoodsExitNumber()-orderDetail.getGoodsNumber();
				int marketNumber = goods.getGoodsMarketNumber()+orderDetail.getGoodsNumber();
				goods.setGoodsExitNumber(exitNumber);
				goods.setGoodsMarketNumber(marketNumber);
				//������Ʒʵ��
				goodsListingDao.update(goods);
				
				//�޸���Ʒָ�����롢��ɫ������
				//��ȡ����Ʒ��ָ����ɫ
				GoodsColor goodsColor = goodsColorDao.getGoodsColorByIdAndColor(goods.getGoodsId(),orderDetail.getGoodsColor());
				//��ȡָ����ɫ��ָ������
				//GoodsSize goodsSize = goodsSizeDao.getGoodsSizeByColorAndSize(goodsColor.getGoodsColorId(), orderDetail.getGoodsSize());
				//��ȡ���и���ɫ�����г���
				List<GoodsSize> goodsSizes = goodsSizeDao.getGoodsSizeByColor(goodsColor.getGoodsColorId());
				for(int j = 0;j < goodsSizes.size();j++){
					GoodsSize goodsSize = goodsSizes.get(i);
					if(goodsSize.getGoodsAttr()==orderDetail.getGoodsAttr()){
						int sizeNumber = goodsSize.getGoodsNumber()-orderDetail.getGoodsNumber();
						goodsSize.setGoodsNumber(sizeNumber);
						goodsSizeDao.update(goodsSize);
						break;
					}
				}
			}
		}
	}
}
