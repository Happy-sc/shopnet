package com.shop.service;

import java.util.List;

import com.shop.domain.Comment;

public interface CommentService {
	/**
	 * 获取商品的评价总数
	 * @param goodsId 商品编号
	 * @return
	 */
	int getCommentSumByGoods(String goodsId);

	/**
	 * 获取商品评分的数量
	 * @param goodsId 商品编号
	 * @param grade 评分
	 * @return
	 */
	int getGoodsGradeSum(String goodsId, int grade);

	/**
	 * 获取商品的评价，并进行分页处理
	 * @param goodsId 商品编号
	 * @param pageSize 页面大小
	 * @param page 页码
	 * @return
	 */
	List<Comment> getCommentByGoods(String goodsId, int pageSize, int page);

	/**
	 * 获取用户的评价
	 * @param userId 用户编号
	 * @param page 页码
	 * @return
	 */
	List<Comment> getCommentByUser(String userId,int page);
	
	/**
	 * 获取用户评价的总数量
	 * @param userId 用户编号
	 * @return
	 */
	int getCommentSumByUser(String userId);

	/**
	 * 保存用户评价信息
	 * @param comment
	 */
	void saveComment(Comment comment);
}
