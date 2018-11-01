package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.CommentDao;
import com.shop.domain.Comment;
import com.shop.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource(name="commentDao")private CommentDao commentDao;
	/**
	 * 获取商品的评价，并进行分页处理
	 * @param goodsId 商品编号
	 * @param pageSize 页面大小
	 * @return 商品相应页面的评价
	 */
	public List<Comment> getCommentByGoods(String goodsId,int pageSize, int page) {
		return commentDao.getCommentByGoodsId(goodsId,pageSize,page);
	}
	
	/**
	 * 获取商品的评价数量
	 * @param goodsId 商品编号
	 * @return 商品的评价数量
	 */
	public int getCommentSumByGoods(String goodsId) {
		int commentSum = commentDao.getCommentSum(goodsId);
		return commentSum;
	}

	/**
	 * 获取商品评分数量
	 * @param goodsId 商品编号
	 * @param grade 商品的评分
	 * @return 商品的评分数量
	 */
	public int getGoodsGradeSum(String goodsId, int grade) {
		int gradeSum = commentDao.getGoodsGradeSum(goodsId,grade);
		return gradeSum;
	}

	/**
	 * 获取用户的评价,且进行分页处理
	 * @param userId 用户编号
	 * @param page 页码
	 * @return 用户的指定页码的评价
	 */
	public List<Comment> getCommentByUser(String userId,int page) {
		return commentDao.getCommentByUserId(userId, page);
	}

	/**
	 * 获取用户评价的数量
	 * @param userId 用户编号
	 * @return 用户评价的数量
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
