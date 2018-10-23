package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.PositionDao;
import com.paixie.domain.Position;
import com.paixie.service.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Resource(name="positionDao")private PositionDao positionDao;
	
	/**
	 * ���ݱ�Ż�ȡPositionʵ��
	 * @param positionId ��Ҫ��ȡPositionʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Positionʵ��
	 */
	public Position getPositionById(String positionId) {
		return positionDao.get(positionId);
	}
	
	/**
	 * ��ȡȫ����Positionʵ��
	 * @return ���ݿ��д��ڵ�ȫ��Positionʵ��
	 */
	public List<Position> getAllPosition() {
		return positionDao.getAllPosition();
	}

}
