package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.CollectDao;
import com.paixie.domain.Collect;
import com.paixie.service.CollectService;

@Service("collectService")
public class CollectServiceImpl implements CollectService{
	@Resource(name="collectDao")private CollectDao collectDao;
	/**
	 * �����ղ�
	 * @param collect ��Ҫ������ղ�
	 * @return
	 */
	public void saveCollect(Collect collect) {
		collectDao.save(collect);
	}
	
	/**
	 * ������Ʒ��Ż�ȡ�ղ�
	 * @param goodsId ��Ʒ���
	 * @param userId �û����
	 * @return ָ����Ʒ��ŵ�ĳ���û����ղ�
	 */
	public Collect getCollectByGoods(String goodsId,String userId) {
		return collectDao.getCollectByGoods(goodsId,userId);
	}

	/**
	 * ��ȡĳ���û����ղ�
	 * @param page ��ǰҳ��
	 * @param userName �û���
	 * @return ���û���ǰҳ����ղ�
	 */
	public List<Collect> getCollectsByUser(int page, String userId,String type) {
		int state = getCollectionState(type);
		
		return collectDao.getCollectsByUser(page,userId,state);
	}


	/**
	 * ɾ��ĳ���û����ղ�
	 * @param userId �û����
	 * @param collectId �ղ�
	 * @return
	 */
	public void deleteCollect(String collectId) {
		collectDao.delete(collectId);
	}

	/**
	 * ��ȡ�û��ղص�����
	 * @param userId �û����
	 * @param type ���
	 * @return �����ղص�������
	 */
	public int getAllCollectSum(String userId,String type) {
		int state = getCollectionState(type);
		
		List<Collect> collects = collectDao.getAllCollectSum(userId,state);
		return collects.size();
	}
	
	/**
	 * ������������״̬
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
