package com.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.dao.CommentDao;
import com.shop.dao.base.BaseHibernateDaoSupport;
import com.shop.domain.Comment;

@Repository("commentDao")
public class CommentDaoHibernate extends BaseHibernateDaoSupport implements CommentDao {

	private int offset;                      //第一条记录索引
	
	/**
	 * 根据标识属性删除Comment实例
	 * @param commentId 需要被删除的Comment实例的标识属性值
	 */
	public void delete(String commentId) {
		getHibernateTemplate().delete(get(commentId));
	}

	/**
	 * 删除Comment实例
	 * @param comment 需要被删除的Comment实例
	 */
	public void delete(Comment comment) {
		getHibernateTemplate().delete(comment);
	}

	/**
	 * 根据标识属性获取Comment实例
	 * @param commentId 需要获取的Comment实例的标识属性值
	 * @return 指定标识属性值的Comment实例
	 */
	public Comment get(String commentId) {
		return getHibernateTemplate().get(Comment.class, commentId);
	}

	/**
	 * 获取全部的Comment实例
	 * @return 数据库中存在的全部Comment实例
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getAllComment() {
		return (List<Comment>)getHibernateTemplate().find("from Comment");
	}

	/**
	 * 根据商品编号获取该商品的Comment实例,且进行分页控制
	 * @param goodsId 商品编号
	 * @param pageNo 指定页码
	 * @return 指定页面的该商品的全部Comment实例
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByGoodsId(String goodsId,int pageSize,int pageNo) {
		offset = (pageNo-1)*pageSize;
		return(List<Comment>) findByPage("from Comment as c where c.goodsListing.goodsId=?",goodsId, offset,pageSize);
	}
	
	/**
	 * 根据用户编号获取该用户指定页面的Comment实例
	 * @param usetId 用户编号
	 * @param pageNo 指定页面
	 * @return 指定页面的该用户的全部的Comment实例
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByUserId(String userId,int pageNo) {
		offset = (pageNo-1)*5;
		return (List<Comment>)findByPage("from Comment as c where c.users.userId=? order by c.commentTime desc", userId, offset,5);
	}

	/**
	 * 保存Comment实例
	 * @param comment 需要被保存的comment实例
	 */
	public void save(Comment comment) {
		getHibernateTemplate().save(comment);
	}

	/**
	 * 修改comment实例
	 * @param comment 需要被修改的comment实例
	 */
	public void update(Comment comment) {
		getHibernateTemplate().update(comment);
	}

	/**
	 * 获取商品的评价数量
	 * @param goodsId 商品编号
	 * @return 指定商品的评价数量
	 */
	@SuppressWarnings("unchecked")
	public int getCommentSum(String goodsId) {
		List<Object> sum = getHibernateTemplate().find("select count(*) from Comment as c where c.goodsListing.goodsId=?",goodsId);
		return Integer.valueOf(sum.get(0).toString());
	}

	/**
	 * 获取商品评分数量
	 * @param goodsId 商品编号
	 * @param grade 商品的评分
	 * @return 商品的评分数量
	 */
	@SuppressWarnings("unchecked")
	public int getGoodsGradeSum(String goodsId, int grade) {
		List<Object> gradeSum = getHibernateTemplate().find("select count(*) from Comment as c where c.goodsListing.goodsId=? and c.commentGrade=?",goodsId,grade);
		return Integer.valueOf(gradeSum.get(0).toString());
	}

	/**
	 * 获取用户的评价
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByUserId(String userId) {
		return getHibernateTemplate().find("from Comment as c where c.users.userId=?",userId);
	}
}
