package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.GoodsColorDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.GoodsColor;

@Repository("goodsColorDao")
public class GoodsColorDaoHibernate extends BaseHibernateDaoSupport implements GoodsColorDao{

	/**
	 * 保存商品颜色实例
	 * @param goodsColor 商品颜色实例
	 */
	public void save(GoodsColor goodsColor) {
		getHibernateTemplate().save(goodsColor);
	}

	/**
	 * 根据商品编号获取该商品的颜色
	 * @param goodsId 商品编号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsColor> getGoodsColor(String goodsId) {
		String hql = "from GoodsColor as gc where gc.goodsListing.goodsId=?";
		List<GoodsColor> colors = getHibernateTemplate().find(hql,goodsId);
		return colors;
	}

	/**
	 * 根据商品颜色(图片)获取商品颜色实例
	 * @param goodsColor 商品颜色
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
	 * 根据颜色编号获取指定颜色实例
	 * @param color  颜色编号
	 * @return
	 */
	public GoodsColor getGoodsColorByColorId(String colorId) {
		return getHibernateTemplate().get(GoodsColor.class, colorId);
	}

	/**
	 * 根据颜色名称获取颜色实例
	 * @param goodsColor 颜色名称
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
	 * 根据商品编号和颜色获取指定的商品颜色实例
	 * @param goodsId 商品编号
	 * @param goodsColor 商品颜色
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
