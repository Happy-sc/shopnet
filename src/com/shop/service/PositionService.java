package com.shop.service;

import java.util.List;

import com.shop.domain.Position;

public interface PositionService {
	/**
	 * 获取所有Position实例
	 * @return
	 */
	List<Position> getAllPosition();
	
	/**
	 * 根据编号获取Position实例
	 * @param positionId 职务编号
	 * @return
	 */
	Position getPositionById(String positionId);
}
