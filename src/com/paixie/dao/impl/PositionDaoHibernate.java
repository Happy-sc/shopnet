package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.PositionDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Position;

@Repository("positionDao")
public class PositionDaoHibernate extends BaseHibernateDaoSupport implements
		PositionDao {

	/**
	 * ��ȡȫ����Positionʵ��
	 * @return ���ݿ��д��ڵ�ȫ����Positionʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Position> getAllPosition() {
		return (List<Position>)getHibernateTemplate().find("from Position");
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡPositionʵ��
	 * @param positionId ��Ҫ��ȡPositionʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Positionʵ��
	 */
	public Position get(String positionId) {
		return getHibernateTemplate().get(Position.class, positionId);
	}

}
