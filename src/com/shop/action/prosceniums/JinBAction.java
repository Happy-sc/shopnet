package com.shop.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.JinBRecord;
import com.shop.domain.Users;
import com.shop.service.JinBService;

@Component("jinBAction")
public class JinBAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="jinBService")
	private JinBService jinBService;
	/**
	 * 查看金币记录
	 */
	public String seeJinB(){
		Users users = (Users) request.getSession().getAttribute("user");
		
		//页面处理
		String type = request.getParameter("type");
		
		int jinBState = 0;                 //初始化为金币支出记录
		if("jbhqjl".equals(type)){           //金币获取记录
			jinBState = 1;
		}
	
		//获取用户的金币记录
		System.out.println(page);
		List<JinBRecord> jinBRecords = jinBService.getUserJinB(users.getUserId(),page,jinBState);
		int paixieBSum = jinBService.getJinBSum(users.getUserId(),jinBState);
		pageSum = paixieBSum%10==0?paixieBSum/10:paixieBSum/10+1;
		
		ActionContext.getContext().put("jinBRecords", jinBRecords);
		ActionContext.getContext().put("nowPage", page);
		ActionContext.getContext().put("pageSum", pageSum);
		ActionContext.getContext().put("type",type );
		
		return "seeJinB";
	}
	
	/**
	 * 获取金币
	 */
	public String getJinB(){
		String jinBNum = request.getParameter("jinBNum");
		Users users = (Users) request.getSession().getAttribute("user");
		if(Integer.valueOf(jinBNum)>users.getJinB()){
			writeToPage("你仅有"+users.getJinB()+"个金币币,"+users.getJinB());
		}
		else {
			writeToPage("可以使用");
		}
		return null;
	}
}
