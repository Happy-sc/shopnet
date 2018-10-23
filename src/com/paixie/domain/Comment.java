package com.paixie.domain;

/*
 * �û�������Ʒʵ��
 */
public class Comment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private String commentId;                  //���۱��
	private Users users;                       //�û�
	private GoodsListing goodsListing;         //���۵���Ʒ
	private String commentTime;                //����ʱ��
	private String commentContent;             //��������
	private Integer commentGrade;              //���

	public Comment() {
	}

	public Comment(String commentId) {
		this.commentId = commentId;
	}

	public Comment(String commentId, Users users, GoodsListing goodsListing,
			String commentTime, String commentContent, Integer commentGrade) {
		this.commentId = commentId;
		this.users = users;
		this.goodsListing = goodsListing;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
		this.commentGrade = commentGrade;
	}

	public String getCommentId() {
		return this.commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public GoodsListing getGoodsListing() {
		return this.goodsListing;
	}

	public void setGoodsListing(GoodsListing goodsListing) {
		this.goodsListing = goodsListing;
	}

	public String getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getCommentGrade() {
		return this.commentGrade;
	}

	public void setCommentGrade(Integer commentGrade) {
		this.commentGrade = commentGrade;
	}

}