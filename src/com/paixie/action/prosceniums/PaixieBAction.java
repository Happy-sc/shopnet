package com.paixie.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.PaixieBRecord;
import com.paixie.domain.Users;
import com.paixie.service.PaixieBService;

@Component("paixieBAction")
public class PaixieBAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="paixieBService")private PaixieBService paixieBService;
	/**
	 * 查看拍鞋币记录:拍鞋币获取记录
	 */
	public String seePaixieB(){
		Users users = (Users) request.getSession().getAttribute("user");
		
		//页面处理
		String type = request.getParameter("type");
		
		int paixieBState = 0;                 //初始化为拍鞋币支出记录
		if("pxbhqjl".equals(type)){           //拍鞋币获取记录
			paixieBState = 1;
		}
	
		//获取用户的拍鞋币记录
		System.out.println(page);
		List<PaixieBRecord> paixieBRecords = paixieBService.getUserPaixieB(users.getUserId(),page,paixieBState);
		int paixieBSum = paixieBService.getPaixieBSum(users.getUserId(),paixieBState);
		pageSum = paixieBSum%10==0?paixieBSum/10:paixieBSum/10+1;
		
		ActionContext.getContext().put("paixieBRecords", paixieBRecords);
		ActionContext.getContext().put("nowPage", page);
		ActionContext.getContext().put("pageSum", pageSum);
		ActionContext.getContext().put("type",type );
		
		return "seePaixieB";
	}
	
	/**
	 * 获取拍鞋币
	 */
	public String getPaixieB(){
		String paixieBNum = request.getParameter("paixieBNum");

		Users users = (Users) request.getSession().getAttribute("user");
		if(Integer.valueOf(paixieBNum)>users.getPaixieB()){
			writeToPage("你仅有"+users.getPaixieB()+"个拍鞋币,"+users.getPaixieB());
		}
		else {
			writeToPage("可以使用");
		}
		return null;
	}
}
