package com.shop.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.GetTime;
import com.shop.common.ProduceId;
import com.shop.domain.Comment;
import com.shop.domain.GoodsListing;
import com.shop.domain.OrderDetail;
import com.shop.domain.Users;
import com.shop.service.CommentService;
import com.shop.service.GoodsService;
import com.shop.service.OrderDetailService;

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
	 * 查看商品评价
	 * 判断该用户是否购买此商品
	 * 如果购买了就跳到评价界面
	 * 否则跳到显示全部评价界面
	 * @return
	 */
	public String goodsComment(){
		String goodsId = request.getParameter("goodsId");
		
		GoodsListing goods = goodsService.getGoodsById(goodsId);
	
		//获取该类商品的评价
		List<Comment> comments = commentService.getCommentByGoods(goodsId,15,1);
		
		//获取商品的所有评价数量,进行页码控制
		int commentSum  = commentService.getCommentSumByGoods(goodsId);
		pageSum = commentSum%15==0?commentSum/15:commentSum/15+1;
		
		//商品评分处理
		int sum_5 = commentService.getGoodsGradeSum(goodsId,5);      //5分
		int sum_4 = commentService.getGoodsGradeSum(goodsId,4);      //4分
		int sum_3 = commentService.getGoodsGradeSum(goodsId,3);      //3分
		int sum_2 = commentService.getGoodsGradeSum(goodsId,2);      //2分
		int sum_1 = commentService.getGoodsGradeSum(goodsId,1);      //1分
		int sumAvg;          //平均分       
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
	 * 用户查看个人评价:待评价商品
	 */           
	public String seeDpjspComment(){
		Users users = (Users) request.getSession().getAttribute("user");

		//获取待评价商品
		List<OrderDetail> orderDetails = orderDetailService.getUserOrderDetail(users.getUserId(),page,0);
		//获取待评价商品的所有订单数量
		int sum = orderDetailService.getSumOrderDetail(users.getUserId(),0);
		pageSum = sum%5==0?sum/5:sum/5+1;
		
		ActionContext.getContext().put("orderDetails", orderDetails);
		ActionContext.getContext().put("type", "dpjsp");
		return "seeComment";
	}
	
	/**
	 * 用户查看个人评价:已评价商品
	 */
	public String seeYpjspComment(){
		Users users = (Users) request.getSession().getAttribute("user");
		//获取评价
		List<Comment> comments = commentService.getCommentByUser(users.getUserId(),page);
		//获取待评价商品的所有订单数量
		int sum = commentService.getCommentSumByUser(users.getUserId());
		pageSum= sum%5==0?sum/5:sum/5+1;
		
		ActionContext.getContext().put("comments", comments);
		ActionContext.getContext().put("type", "ypjsp");
		
		return "seeComment";
	}
	
	/**
	 * 进入用户发表评论界面
	 */
	public String commentUI(){
		//获取订单详情编号：一份订单详情对应一件商品
		String orderDetailId = request.getParameter("orderDetailId");
		//获取订单详情
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
		
		request.setAttribute("orderDetailId", orderDetailId);
		request.setAttribute("goods", orderDetail.getGoodsListing());
		
		return "commentUI";
	}
	
	/**
	 * 用户发表评价
	 */
	public String commentGoods(){
		//设置评价时间、编号
		comment.setCommentTime(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		comment.setCommentId(ProduceId.getId());
		
		//设置用户
		Users users = (Users) session.getAttribute("user");
		comment.setUsers(users);
		
		//商品
		String goodsId = request.getParameter("goodsId");
		GoodsListing goods = goodsService.getGoodsById(goodsId);
		comment.setGoodsListing(goods);
		
		//保存评价信息
		commentService.saveComment(comment);
		
		//将该订单修改已经评价
		String orderDetailId = request.getParameter("orderDetailId");
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(orderDetailId);
		orderDetail.setOrderDetailIsCom(1);
		
		//修改订单详细信息
		orderDetailService.updateOrderDetail(orderDetail);
		
		return "commentSuccess";
	}
}

