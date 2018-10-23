package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.CommentDao;
import com.paixie.domain.Comment;
import com.paixie.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource(name="commentDao")private CommentDao commentDao;
	/**
	 * ��ȡ��Ʒ�����ۣ������з�ҳ����
	 * @param goodsId ��Ʒ���
	 * @param pageSize ҳ���С
	 * @return ��Ʒ��Ӧҳ�������
	 */
	public List<Comment> getCommentByGoods(String goodsId,int pageSize, int page) {
		return commentDao.getCommentByGoodsId(goodsId,pageSize,page);
	}
	
	/**
	 * ��ȡ��Ʒ����������
	 * @param goodsId ��Ʒ���
	 * @return ��Ʒ����������
	 */
	public int getCommentSumByGoods(String goodsId) {
		int commentSum = commentDao.getCommentSum(goodsId);
		return commentSum;
	}

	/**
	 * ��ȡ��Ʒ��������
	 * @param goodsId ��Ʒ���
	 * @param grade ��Ʒ������
	 * @return ��Ʒ����������
	 */
	public int getGoodsGradeSum(String goodsId, int grade) {
		int gradeSum = commentDao.getGoodsGradeSum(goodsId,grade);
		return gradeSum;
	}

	/**
	 * ��ȡ�û�������,�ҽ��з�ҳ����
	 * @param userId �û����
	 * @param page ҳ��
	 * @return �û���ָ��ҳ�������
	 */
	public List<Comment> getCommentByUser(String userId,int page) {
		return commentDao.getCommentByUserId(userId, page);
	}

	/**
	 * ��ȡ�û����۵�����
	 * @param userId �û����
	 * @return �û����۵�����
	 */
	public int getCommentSumByUser(String userId) {
		List<Comment> comments = commentDao.getCommentByUserId(userId);
		return comments.size();
	}

	@Override
	public void saveComment(Comment comment) {
		commentDao.save(comment);
	}

}
