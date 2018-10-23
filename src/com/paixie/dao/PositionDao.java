package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Position;

public interface PositionDao {
	/**
	 * ���ݱ�ʶ���Բ���Positionʵ��
	 * @param positionId
	 * @return
	 */
	Position get(String positionId);
	
	/**
	 * ��ȡȫ����ְ��
	 * @return
	 */
	List<Position> getAllPosition();
}
