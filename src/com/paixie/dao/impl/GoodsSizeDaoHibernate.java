package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.GoodsSizeDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.GoodsSize;

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
		String hql = "from GoodsSize as gs where gs.goodsColor.goodsColorId=? order by gs.goodsSize asc";
		List<GoodsSize> goodsSizes = getHibernateTemplate().find(hql,goodsColorId);
		
		return goodsSizes;
	}

	/**
	 * 根据商品颜色、尺码获取尺码实例
	 * @param goodsColorId 商品颜色编号
	 * @param goodsSize 尺码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public GoodsSize getGoodsSizeByColorAndSize(String goodsColorId,
			Integer goodsSize) {
		String hql = "from GoodsSize as gs where gs.goodsColor.goodsColorId=? and gs.goodsSize=?";
		List<GoodsSize> goodsSizes = getHibernateTemplate().find(hql,goodsColorId,goodsSize);
		if(goodsSize!=null&&goodsSizes.size()>0){
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
