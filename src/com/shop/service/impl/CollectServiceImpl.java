package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.CollectDao;
import com.shop.domain.Collect;
import com.shop.service.CollectService;

@Service("collectService")
public class CollectServiceImpl implements CollectService{
	@Resource(name="collectDao")private CollectDao collectDao;
	/**
	 * 保存收藏
	 * @param collect 需要保存的收藏
	 * @return
	 */
	public void saveCollect(Collect collect) {
		collectDao.save(collect);
	}
	
	/**
	 * 根据商品编号获取收藏
	 * @param goodsId 商品编号
	 * @param userId 用户编号
	 * @return 指定商品编号的某个用户的收藏
	 */
	public Collect getCollectByGoods(String goodsId,String userId) {
		return collectDao.getCollectByGoods(goodsId,userId);
	}

	/**
	 * 获取某个用户的收藏
	 * @param page 当前页面
	 * @return 该用户当前页面的收藏
	 */
	public List<Collect> getCollectsByUser(int page, String userId,String type) {
		int state = getCollectionState(type);
		
		return collectDao.getCollectsByUser(page,userId,state);
	}


	/**
	 * 删除某个用户的收藏
	 * @param collectId 收藏
	 * @return
	 */
	public void deleteCollect(String collectId) {
		collectDao.delete(collectId);
	}

	/**
	 * 获取用户收藏的数量
	 * @param userId 用户编号
	 * @param type 类别
	 * @return 所有收藏的总数量
	 */
	public int getAllCollectSum(String userId,String type) {
		int state = getCollectionState(type);
		
		List<Collect> collects = collectDao.getAllCollectSum(userId,state);
		return collects.size();
	}
	
	/**
	 * 根据类型设置状态
	 */
	public int getCollectionState(String type){
		int state = 0;
		if("all".equals(type)){
			state = 2;
		}
		if("zs".equals(type)){
			state = 1;
		}
		if("xj".equals(type)){
			state = 0;
		}
		
		return state;
	}
}
