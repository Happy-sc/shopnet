package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Collect;


public interface CollectDao {
	/**
	 * 根据标识属性获取Collect实例
	 * @param collectId
	 * @return
	 */
	Collect get(String collectId);
	
	/**
	 * 保存Collect实例
	 * @param collect
	 */
	void save(Collect collect);
	
	/**
	 * 根据标识属性删除 Collect实例
	 * @param collectId
	 */
	void delete(String collectId);
	
	/**
	 * 删除Collect实例
	 * @param collect
	 */
	void delete(Collect collect);
	
	/**
	 * 修改Collect实例
	 * @param collect
	 */
	void update(Collect collect);
	
	/**
	 * 获取全部的Collect实例
	 * @return
	 */
	List<Collect> getAllCollect();
	
	/**
	 * 根据商品编号获取收藏
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	Collect getCollectByGoods(String goodsId, String userId);
	
	/**
	 * 获取某个用户的收藏
	 * @param page
	 * @param userName
	 * @return
	 */
	List<Collect> getCollectsByUser(int page, String userId,int state);

	/**
	 * 获取所有收藏的总数量
	 * @param userId
	 * @param type 类别
	 * @return
	 */
	List<Collect> getAllCollectSum(String userId,int state);


}
