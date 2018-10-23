package com.paixie.service;

import java.util.List;

import com.paixie.domain.Collect;

public interface CollectService {
	
	/**
	 * �����ղ�
	 * @param collect 
	 */
	void saveCollect(Collect collect);

	/**
	 * ������Ʒ��ź��û���ȡ�ղ�
	 * @param goodsId ��Ʒ���
	 * @param userId �û����
	 * @return
	 */
	Collect getCollectByGoods(String goodsId,String userId);

	/**
	 * ��ȡĳ���û����ղ�
	 * @param page ָ��ҳ��
	 * @param userName �û�����
	 * @param type ���
	 * @return
	 */
	List<Collect> getCollectsByUser(int page, String userId,String type);


	/**
	 * ɾ���ղ�
	 * @param collectId �ղر��
	 */
	void deleteCollect(String collectId);

	/**
	 * ��ȡ�û��ղص�����
	 * @param userId �û����
	 * @param type ���
	 * @return
	 */
	int getAllCollectSum(String userId,String type);


}
