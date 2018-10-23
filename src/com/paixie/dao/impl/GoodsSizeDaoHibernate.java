package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.GoodsSizeDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.GoodsSize;

@Repository("goodsSizeDao")
public class GoodsSizeDaoHibernate extends BaseHibernateDaoSupport implements GoodsSizeDao{
	
	/**
	 * ������Ʒ����ʵ��
	 * @param goodsSize
	 */
	public void save(GoodsSize goodsSize) {
		getHibernateTemplate().save(goodsSize);
	}

	/**
	 * ��ȡָ����Ʒ��ɫ�ĳ���
	 * @param goodsColorId ��Ʒ��ɫ���
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsSize> getGoodsSizeByColor(String goodsColorId) {
		String hql = "from GoodsSize as gs where gs.goodsColor.goodsColorId=? order by gs.goodsSize asc";
		List<GoodsSize> goodsSizes = getHibernateTemplate().find(hql,goodsColorId);
		
		return goodsSizes;
	}

	/**
	 * ������Ʒ��ɫ�������ȡ����ʵ��
	 * @param goodsColorId ��Ʒ��ɫ���
	 * @param goodsSize ����
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
	 * �޸ĳ���ʵ��
	 * @param goodsSize ��Ҫ���޸ĵĳ���ʵ��
	 */
	public void update(GoodsSize goodsSize) {
		getHibernateTemplate().update(goodsSize);
	}

}
