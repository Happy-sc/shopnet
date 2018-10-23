package com.paixie.service;

import java.util.List;

import com.paixie.domain.Comment;

public interface CommentService {
	/**
	 * ��ȡ��Ʒ����������
	 * @param goodsId ��Ʒ���
	 * @return
	 */
	int getCommentSumByGoods(String goodsId);

	/**
	 * ��ȡ��Ʒ���ֵ�����
	 * @param goodsId ��Ʒ���
	 * @param grade ����
	 * @return
	 */
	int getGoodsGradeSum(String goodsId, int grade);

	/**
	 * ��ȡ��Ʒ�����ۣ������з�ҳ����
	 * @param goodsId ��Ʒ���
	 * @param pageSize ҳ���С
	 * @param page ҳ��
	 * @return
	 */
	List<Comment> getCommentByGoods(String goodsId, int pageSize, int page);

	/**
	 * ��ȡ�û�������
	 * @param userId �û����
	 * @param page ҳ��
	 * @return
	 */
	List<Comment> getCommentByUser(String userId,int page);
	
	/**
	 * ��ȡ�û����۵�������
	 * @param userId �û����
	 * @return
	 */
	int getCommentSumByUser(String userId);

	/**
	 * �����û�������Ϣ
	 * @param comment
	 */
	void saveComment(Comment comment);
}
