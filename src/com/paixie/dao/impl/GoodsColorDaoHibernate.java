package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.GoodsColorDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.GoodsColor;

@Repository("goodsColorDao")
public class GoodsColorDaoHibernate extends BaseHibernateDaoSupport implements GoodsColorDao{

	/**
	 * ������Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫʵ��
	 */
	public void save(GoodsColor goodsColor) {
		getHibernateTemplate().save(goodsColor);
	}

	/**
	 * ������Ʒ��Ż�ȡ����Ʒ����ɫ
	 * @param goodsId ��Ʒ���
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsColor> getGoodsColor(String goodsId) {
		String hql = "from GoodsColor as gc where gc.goodsListing.goodsId=?";
		List<GoodsColor> colors = getHibernateTemplate().find(hql,goodsId);
		return colors;
	}

	/**
	 * ������Ʒ��ɫ(ͼƬ)��ȡ��Ʒ��ɫʵ��
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GoodsColor getGoodsColorByColor(String goodsColor) {
		String hql = "From GoodsColor as gc where gc.goodsImage=?";
		List<GoodsColor> goodsColors = getHibernateTemplate().find(hql,goodsColor);
		if(goodsColors!=null&&goodsColors.size()>0){
			return goodsColors.get(0);
		}
		return null;
	}

	/**
	 * ������ɫ��Ż�ȡָ����ɫʵ��
	 * @param color  ��ɫ���
	 * @return
	 */
	public GoodsColor getGoodsColorByColorId(String colorId) {
		return getHibernateTemplate().get(GoodsColor.class, colorId);
	}

	/**
	 * ������ɫ���ƻ�ȡ��ɫʵ��
	 * @param goodsColor ��ɫ����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GoodsColor getGoodsColorByColorName(String goodsColor) {
		String hql = "from GoodsColor as gc where gc.goodsColor=?";
		List<GoodsColor> goodsColors = getHibernateTemplate().find(hql,goodsColor);
		if(goodsColors!=null&&goodsColors.size()>0){
			return goodsColors.get(0);
		}
		return null;
	}

	/**
	 * ������Ʒ��ź���ɫ��ȡָ������Ʒ��ɫʵ��
	 * @param goodsId ��Ʒ���
	 * @param goodsColor ��Ʒ��ɫ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GoodsColor getGoodsColorByIdAndColor(String goodsId,
			String goodsColor) {
		String hql = "from GoodsColor as gc where gc.goodsColor=? and gc.goodsListing.goodsId=?";
		List<GoodsColor> goodsColors = getHibernateTemplate().find(hql,goodsColor,goodsId);
		if(goodsColors!=null&&goodsColors.size()>0){
			return goodsColors.get(0);
		}
		return null;
	}
}
