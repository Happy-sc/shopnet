package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Position;

public interface PositionDao {
	/**
	 * 根据标识属性查找Position实例
	 * @param positionId
	 * @return
	 */
	Position get(String positionId);
	
	/**
	 * 获取全部的职务
	 * @return
	 */
	List<Position> getAllPosition();
}
