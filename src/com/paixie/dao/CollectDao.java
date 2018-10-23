package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Collect;


public interface CollectDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡCollectʵ��
	 * @param collectId
	 * @return
	 */
	Collect get(String collectId);
	
	/**
	 * ����Collectʵ��
	 * @param collect
	 */
	void save(Collect collect);
	
	/**
	 * ���ݱ�ʶ����ɾ�� Collectʵ��
	 * @param collectId
	 */
	void delete(String collectId);
	
	/**
	 * ɾ��Collectʵ��
	 * @param collect
	 */
	void delete(Collect collect);
	
	/**
	 * �޸�Collectʵ��
	 * @param collect
	 */
	void update(Collect collect);
	
	/**
	 * ��ȡȫ����Collectʵ��
	 * @return
	 */
	List<Collect> getAllCollect();
	
	/**
	 * ������Ʒ��Ż�ȡ�ղ�
	 * @param goodsId
	 * @param userId
	 * @return
	 */
	Collect getCollectByGoods(String goodsId, String userId);
	
	/**
	 * ��ȡĳ���û����ղ�
	 * @param page
	 * @param userName
	 * @return
	 */
	List<Collect> getCollectsByUser(int page, String userId,int state);

	/**
	 * ��ȡ�����ղص�������
	 * @param userId
	 * @param type ���
	 * @return
	 */
	List<Collect> getAllCollectSum(String userId,int state);


}
