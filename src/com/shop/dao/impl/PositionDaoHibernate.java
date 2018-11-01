package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.PositionDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Position;

@Repository("positionDao")
public class PositionDaoHibernate extends BaseHibernateDaoSupport implements
		PositionDao {

	/**
	 * 获取全部的Position实例
	 * @return 数据库中存在的全部的Position实例
	 */
	@SuppressWarnings("unchecked")
	public List<Position> getAllPosition() {
		return (List<Position>)getHibernateTemplate().find("from Position");
	}

	/**
	 * 根据标识属性获取Position实例
	 * @param positionId 需要获取Position实例的标识属性值
	 * @return 指定标识属性值的Position实例
	 */
	public Position get(String positionId) {
		return getHibernateTemplate().get(Position.class, positionId);
	}

}
