package com.shop.dao;

import java.util.List;

import com.shop.domain.Comment;


public interface CommentDao {
	/**
	 * 根据标识属性获取Comment实例
	 * @param commentId
	 * @return
	 */
	Comment get(String commentId);
	
	/**
	 * 保存Comment实例
	 * @param comment
	 */
	void save(Comment comment);
	
	/**
	 * 根据标识属性删除Comment实例
	 * @param commentId
	 */
	void delete(String commentId);
	
	/**
	 * 删除Comment实例
	 * @param comment
	 */
	void delete(Comment comment);
	
	/**
	 * 修改Comment实例
	 * @param comment
	 */
	void update(Comment comment);
	
	/**
	 * 获取全部的Comment实例
	 * @return
	 */
	List<Comment> getAllComment();
	
	/**
	 * 根据商品编号获取Comment实例
	 * @param goodsId
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	List<Comment> getCommentByGoodsId(String goodsId,int pageSize,int pageNo);
	
	/**
	 * 根据用户名获取Comment实例
	 * @param userId
	 * @param page
	 * @return
	 */
	List<Comment> getCommentByUserId(String userId,int page);

	/**
	 * 获取商品评价的数量
	 * @param goodsId
	 * @return
	 */
	int getCommentSum(String goodsId);

	/**
	 * 获取商品评分数量
	 * @param goodsId
	 * @param grade
	 * @return
	 */
	int getGoodsGradeSum(String goodsId, int grade);

	/**
	 * 获取用户的评价
	 * @param userId
	 * @return
	 */
	List<Comment> getCommentByUserId(String userId);
	
}
