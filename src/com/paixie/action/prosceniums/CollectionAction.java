package com.paixie.action.prosceniums;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetTime;
import com.paixie.common.ProduceId;
import com.paixie.domain.Collect;
import com.paixie.domain.GoodsListing;
import com.paixie.domain.Users;
import com.paixie.service.CollectService;
import com.paixie.service.GoodsService;

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
	 * �û��ղ���Ʒ:�û��Ѿ���¼
	 * @return
	 */
	public String collectGoods(){
		Users users = (Users) session.getAttribute("user");

		//��ȡ�ղص���Ʒ
		GoodsListing goods = goodsService.getGoodsById(getGoodsId());
		//�жϸ���Ʒ�Ƿ��Ѿ��ղ���
		Collect collect = collectService.getCollectByGoods(goodsId,users.getUserId());
		/*
		 * ��������ڣ��򱣴棬���򷵻���ʾ��Ϣ 1:��ʾ�����ڣ�0����ʾ����
		 */
		String flag;
		if(collect==null){
			//�½��û����ղ�
			Collect collect1 = new Collect();
			collect1.setCollectId(ProduceId.getId());
			collect1.setGoodsListing(goods);
			collect1.setUsers(users);
			collect1.setCollectTime(GetTime.getTime("yyyy-MM-dd hh:mm:ss"));
			//����
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
	 * �û��鿴�ղ�:������Ʒ
	 * @return
	 */
	public String seeCollection(){
		Users user = (Users) request.getSession().getAttribute("user");
	
		//��ȡҳ��
		int page = super.getPage();
		
		//��ȡ���û���ȫ���ղ�
		List<Collect> collects_all = collectService.getCollectsByUser(page,user.getUserId(),type);          //ȫ���ղ�
		
		//��ȡ��������������ҳ��
		int allSum = collectService.getAllCollectSum(user.getUserId(),type);
		
		int allPage = allSum%5==0?allSum/5:allSum/5+1;
			
		ActionContext.getContext().put("allPage", allPage);
		ActionContext.getContext().put("type",type);
		ActionContext.getContext().put("nowPage", page);
		ActionContext.getContext().put("collect", collects_all);
	
		return "seeCollect";
	}
	
	
	/**
	 * ȡ���ղ�
	 */
	public String cancelCollect(){
		
		return null;
	}
	
}
