package com.paixie.service;

import java.util.List;

import com.paixie.domain.Position;

public interface PositionService {
	/**
	 * ��ȡ����Positionʵ��
	 * @return
	 */
	List<Position> getAllPosition();
	
	/**
	 * ���ݱ�Ż�ȡPositionʵ��
	 * @param positionId ְ����
	 * @return
	 */
	Position getPositionById(String positionId);
}
