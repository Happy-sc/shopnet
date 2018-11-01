package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.PositionDao;
import com.shop.domain.Position;
import com.shop.service.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Resource(name="positionDao")private PositionDao positionDao;
	
	/**
	 * 根据编号获取Position实例
	 * @param positionId 需要获取Position实例的标识属性值
	 * @return 指定标识属性值的Position实例
	 */
	public Position getPositionById(String positionId) {
		return positionDao.get(positionId);
	}
	
	/**
	 * 获取全部的Position实例
	 * @return 数据库中存在的全部Position实例
	 */
	public List<Position> getAllPosition() {
		return positionDao.getAllPosition();
	}

}
