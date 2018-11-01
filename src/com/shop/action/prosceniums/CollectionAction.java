package com.shop.action.prosceniums;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.GetTime;
import com.shop.common.ProduceId;
import com.shop.domain.Collect;
import com.shop.domain.GoodsListing;
import com.shop.domain.Users;
import com.shop.service.CollectService;
import com.shop.service.GoodsService;

@Controller("collectionAction")
public class CollectionAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="collectService")private CollectService collectService;
	@Resource(name="goodsService")private GoodsService goodsService;
	private String goodsId;
	private String type;
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 用户收藏商品:用户已经登录
	 * @return
	 */
	public String collectGoods(){
		Users users = (Users) session.getAttribute("user");

		//获取收藏的商品
		GoodsListing goods = goodsService.getGoodsById(getGoodsId());
		//判断该商品是否已经收藏了
		Collect collect = collectService.getCollectByGoods(goodsId,users.getUserId());
		/*
		 * 如果不存在，则保存，否则返回提示信息 1:表示不存在，0：表示存在
		 */
		String flag;
		if(collect==null){
			//新建用户的收藏
			Collect collect1 = new Collect();
			collect1.setCollectId(ProduceId.getId());
			collect1.setGoodsListing(goods);
			collect1.setUsers(users);
			collect1.setCollectTime(GetTime.getTime("yyyy-MM-dd hh:mm:ss"));
			//保存
			collectService.saveCollect(collect1);
			flag = "1";
		}
		else {
			flag = "0";
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 用户查看收藏:所有商品
	 * @return
	 */
	public String seeCollection(){
		Users user = (Users) request.getSession().getAttribute("user");
	
		//获取页面
		int page = super.getPage();
		
		//获取该用户的全部收藏
		List<Collect> collects_all = collectService.getCollectsByUser(page,user.getUserId(),type);          //全部收藏
		
		//获取所有数量，设置页数
		int allSum = collectService.getAllCollectSum(user.getUserId(),type);
		
		int allPage = allSum%5==0?allSum/5:allSum/5+1;
			
		ActionContext.getContext().put("allPage", allPage);
		ActionContext.getContext().put("type",type);
		ActionContext.getContext().put("nowPage", page);
		ActionContext.getContext().put("collect", collects_all);
	
		return "seeCollect";
	}
	
	
	/**
	 * 取消收藏
	 */
	public String cancelCollect(){
		
		return null;
	}
	
}
