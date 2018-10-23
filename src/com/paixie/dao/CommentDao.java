package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Comment;


public interface CommentDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡCommentʵ��
	 * @param commentId
	 * @return
	 */
	Comment get(String commentId);
	
	/**
	 * ����Commentʵ��
	 * @param comment
	 */
	void save(Comment comment);
	
	/**
	 * ���ݱ�ʶ����ɾ��Commentʵ��
	 * @param commentId
	 */
	void delete(String commentId);
	
	/**
	 * ɾ��Commentʵ��
	 * @param comment
	 */
	void delete(Comment comment);
	
	/**
	 * �޸�Commentʵ��
	 * @param comment
	 */
	void update(Comment comment);
	
	/**
	 * ��ȡȫ����Commentʵ��
	 * @return
	 */
	List<Comment> getAllComment();
	
	/**
	 * ������Ʒ��Ż�ȡCommentʵ��
	 * @param goodsId
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	List<Comment> getCommentByGoodsId(String goodsId,int pageSize,int pageNo);
	
	/**
	 * �����û�����ȡCommentʵ��
	 * @param userId
	 * @param page
	 * @return
	 */
	List<Comment> getCommentByUserId(String userId,int page);

	/**
	 * ��ȡ��Ʒ���۵�����
	 * @param goodsId
	 * @return
	 */
	int getCommentSum(String goodsId);

	/**
	 * ��ȡ��Ʒ��������
	 * @param goodsId
	 * @param grade
	 * @return
	 */
	int getGoodsGradeSum(String goodsId, int grade);

	/**
	 * ��ȡ�û�������
	 * @param userId
	 * @return
	 */
	List<Comment> getCommentByUserId(String userId);
	
}
