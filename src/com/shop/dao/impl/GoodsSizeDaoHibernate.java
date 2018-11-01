package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.GoodsSizeDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.GoodsSize;

@Repository("goodsSizeDao")
public class GoodsSizeDaoHibernate extends BaseHibernateDaoSupport implements GoodsSizeDao{
	
	/**
	 * 保存商品尺码实例
	 * @param goodsSize
	 */
	public void save(GoodsSize goodsSize) {
		getHibernateTemplate().save(goodsSize);
	}

	/**
	 * 获取指定商品颜色的尺码
	 * @param goodsColorId 商品颜色编号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsSize> getGoodsSizeByColor(String goodsColorId) {
		String hql = "from GoodsSize as gs where gs.goodsColor.goodsColorId=?";
		return getHibernateTemplate().find(hql,goodsColorId);
	}

	/**
	 * 根据商品颜色、尺码获取尺码实例
	 * @param goodsColorId 商品颜色编号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GoodsSize getGoodsSizeByColorAndSize(String goodsColorId ) {
		String hql = "from GoodsSize as gs where gs.goodsColor.goodsColorId=?";
		List<GoodsSize> goodsSizes = getHibernateTemplate().find(hql,goodsColorId);
		if(goodsSizes.size()>0){
			return goodsSizes.get(0);
		}
		return null;
	}
	
	/**
	 * 修改尺码实例
	 * @param goodsSize 需要被修改的尺码实例
	 */
	public void update(GoodsSize goodsSize) {
		getHibernateTemplate().update(goodsSize);
	}

}
