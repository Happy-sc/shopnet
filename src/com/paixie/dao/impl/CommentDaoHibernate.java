package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.CommentDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Comment;

@Repository("commentDao")
public class CommentDaoHibernate extends BaseHibernateDaoSupport implements CommentDao {

	private int offset;                      //��һ����¼����
	
	/**
	 * ���ݱ�ʶ����ɾ��Commentʵ��
	 * @param commentId ��Ҫ��ɾ����Commentʵ���ı�ʶ����ֵ
	 */
	public void delete(String commentId) {
		getHibernateTemplate().delete(get(commentId));
	}

	/**
	 * ɾ��Commentʵ��
	 * @param comment ��Ҫ��ɾ����Commentʵ��
	 */
	public void delete(Comment comment) {
		getHibernateTemplate().delete(comment);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡCommentʵ��
	 * @param commentId ��Ҫ��ȡ��Commentʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Commentʵ��
	 */
	public Comment get(String commentId) {
		return getHibernateTemplate().get(Comment.class, commentId);
	}

	/**
	 * ��ȡȫ����Commentʵ��
	 * @return ���ݿ��д��ڵ�ȫ��Commentʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getAllComment() {
		return (List<Comment>)getHibernateTemplate().find("from Comment");
	}

	/**
	 * ������Ʒ��Ż�ȡ����Ʒ��Commentʵ��,�ҽ��з�ҳ����
	 * @param goodsId ��Ʒ���
	 * @param pageNo ָ��ҳ��
	 * @return ָ��ҳ��ĸ���Ʒ��ȫ��Commentʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByGoodsId(String goodsId,int pageSize,int pageNo) {
		offset = (pageNo-1)*pageSize;
		return(List<Comment>) findByPage("from Comment as c where c.goodsListing.goodsId=?",goodsId, offset,pageSize);
	}
	
	/**
	 * �����û���Ż�ȡ���û�ָ��ҳ���Commentʵ��
	 * @param usetId �û����
	 * @param pageNo ָ��ҳ��
	 * @return ָ��ҳ��ĸ��û���ȫ����Commentʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByUserId(String userId,int pageNo) {
		offset = (pageNo-1)*5;
		return (List<Comment>)findByPage("from Comment as c where c.users.userId=? order by c.commentTime desc", userId, offset,5);
	}

	/**
	 * ����Commentʵ��
	 * @param comment ��Ҫ�������commentʵ��
	 */
	public void save(Comment comment) {
		getHibernateTemplate().save(comment);
	}

	/**
	 * �޸�commentʵ��
	 * @param comment ��Ҫ���޸ĵ�commentʵ��
	 */
	public void update(Comment comment) {
		getHibernateTemplate().update(comment);
	}

	/**
	 * ��ȡ��Ʒ����������
	 * @param goodsId ��Ʒ���
	 * @return ָ����Ʒ����������
	 */
	@SuppressWarnings("unchecked")
	public int getCommentSum(String goodsId) {
		List<Object> sum = getHibernateTemplate().find("select count(*) from Comment as c where c.goodsListing.goodsId=?",goodsId);
		return Integer.valueOf(sum.get(0).toString());
	}

	/**
	 * ��ȡ��Ʒ��������
	 * @param goodsId ��Ʒ���
	 * @param grade ��Ʒ������
	 * @return ��Ʒ����������
	 */
	@SuppressWarnings("unchecked")
	public int getGoodsGradeSum(String goodsId, int grade) {
		List<Object> gradeSum = getHibernateTemplate().find("select count(*) from Comment as c where c.goodsListing.goodsId=? and c.commentGrade=?",goodsId,grade);
		return Integer.valueOf(gradeSum.get(0).toString());
	}

	/**
	 * ��ȡ�û�������
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentByUserId(String userId) {
		return getHibernateTemplate().find("from Comment as c where c.users.userId=?",userId);
	}
}
