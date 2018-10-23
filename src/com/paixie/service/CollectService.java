package com.paixie.service;

import java.util.List;

import com.paixie.domain.Collect;

public interface CollectService {
	
	/**
	 * 保存收藏
	 * @param collect 
	 */
	void saveCollect(Collect collect);

	/**
	 * 根据商品编号和用户获取收藏
	 * @param goodsId 商品编号
	 * @param userId 用户编号
	 * @return
	 */
	Collect getCollectByGoods(String goodsId,String userId);

	/**
	 * 获取某个用户的收藏
	 * @param page 指定页码
	 * @param userName 用户名称
	 * @param type 类别
	 * @return
	 */
	List<Collect> getCollectsByUser(int page, String userId,String type);


	/**
	 * 删除收藏
	 * @param collectId 收藏编号
	 */
	void deleteCollect(String collectId);

	/**
	 * 获取用户收藏的总量
	 * @param userId 用户编号
	 * @param type 类别
	 * @return
	 */
	int getAllCollectSum(String userId,String type);


}
