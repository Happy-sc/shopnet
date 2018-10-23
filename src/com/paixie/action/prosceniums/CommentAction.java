package com.paixie.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetTime;
import com.paixie.common.ProduceId;
import com.paixie.domain.Comment;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.Users;
import com.paixie.service.CommentService;
import com.paixie.service.GoodsService;
import com.paixie.service.OrderDetailService;

@Controller("commentAction")
public class CommentAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="goodsService")private GoodsService goodsService;
	@Resource(name="commentService")private CommentService commentService;
	@Resource(name="")private OrderDetailService orderDetailService;
	
	private String orderDetailId;
	private Comment comment;
	
	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * �鿴��Ʒ����
	 * �жϸ��û��Ƿ������Ʒ
	 * ��������˾��������۽���
	 * ����������ʾȫ�����۽���
	 * @return
	 */
	public String goodsComment(){
		String goodsId = request.getParameter("goodsId");
		
		GoodsListing goods = goodsService.getGoodsById(goodsId);
	
		//��ȡ������Ʒ������
		List<Comment> comments = commentService.getCommentByGoods(goodsId,15,1);
		
		//��ȡ��Ʒ��������������,����ҳ�����
		int commentSum  = commentService.getCommentSumByGoods(goodsId);
		pageSum = commentSum%15==0?commentSum/15:commentSum/15+1;
		
		//��Ʒ���ִ���
		int sum_5 = commentService.getGoodsGradeSum(goodsId,5);      //5��
		int sum_4 = commentService.getGoodsGradeSum(goodsId,4);      //4��
		int sum_3 = commentService.getGoodsGradeSum(goodsId,3);      //3��
		int sum_2 = commentService.getGoodsGradeSum(goodsId,2);      //2��
		int sum_1 = commentService.getGoodsGradeSum(goodsId,1);      //1��
		int sumAvg;          //ƽ����       
		int sum = sum_1+sum_2+sum_3+sum_4+sum_5;
		if(sum_5+sum_4+sum_3+sum_2+sum_1!=0){
			sumAvg = (sum_5*5+sum_4*4+sum_3*3+sum_2*2+sum_1)/(sum);
		}
		else {
			sumAvg = 5;
		}
		
		ActionContext.getContext().put("goods", goods);
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("commentSum", commentSum);
		ActionContext.getContext().put("sum_1", sum_1);
		ActionContext.getContext().put("sum_2", sum_2);
		ActionContext.getContext().put("sum_3", sum_3);
		ActionContext.getContext().put("sum_4", sum_4);
		ActionContext.getContext().put("sum_5", sum_5);
		ActionContext.getContext().put("sumAvg", sumAvg);
		ActionContext.getContext().put("sum", sum);
		return "goodsComment";
	}
	
	/**
	 * �û��鿴��������:��������Ʒ
	 */           
	public String seeDpjspComment(){
		Users users = (Users) request.getSession().getAttribute("user");

		//��ȡ��������Ʒ
		List<OrderDetail> orderDetails = orderDetailService.getUserOrderDetail(users.getUserId(),page,0);
		//��ȡ��������Ʒ�����ж�������
		int sum = orderDetailService.getSumOrderDetail(users.getUserId(),0);
		pageSum = sum%5==0?sum/5:sum/5+1;
		
		ActionContext.getContext().put("orderDetails", orderDetails);
		ActionContext.getContext().put("type", "dpjsp");
		return "seeComment";
	}
	
	/**
	 * �û��鿴��������:��������Ʒ
	 */
	public String seeYpjspComment(){
		Users users = (Users) request.getSession().getAttribute("user");
		//��ȡ����
		List<Comment> comments = commentService.getCommentByUser(users.getUserId(),page);
		//��ȡ��������Ʒ�����ж�������
		int sum = commentService.getCommentSumByUser(users.getUserId());
		pageSum= sum%5==0?sum/5:sum/5+1;
		
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("type", "ypjsp");
		
		return "seeComment";
	}
	
	/**
	 * �����û��������۽���
	 */
	public String commentUI(){
		//��ȡ���������ţ�һ�ݶ��������Ӧһ����Ʒ
		String orderDetailId = request.getParameter("orderDetailId");
		//��ȡ��������
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
		
		request.setAttribute("orderDetailId", orderDetailId);
		request.setAttribute("goods", orderDetail.getGoodsListing());
		
		return "commentUI";
	}
	
	/**
	 * �û���������
	 */
	public String commentGoods(){
		//��������ʱ�䡢���
		comment.setCommentTime(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		comment.setCommentId(ProduceId.getId());
		
		//�����û�
		Users users = (Users) session.getAttribute("user");
		comment.setUsers(users);
		
		//��Ʒ
		String goodsId = request.getParameter("goodsId");
		GoodsListing goods = goodsService.getGoodsById(goodsId);
		comment.setGoodsListing(goods);
		
		//����������Ϣ
		commentService.saveComment(comment);
		
		//���ö����޸��Ѿ�����
		String orderDetailId = request.getParameter("orderDetailId");
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
		orderDetail.setOrderDetailIsCom(1);
		
		//�޸Ķ�����ϸ��Ϣ
		orderDetailService.updateOrderDetail(orderDetail);
		
		return "commentSuccess";
	}
}

