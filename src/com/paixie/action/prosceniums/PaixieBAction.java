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
	 * �鿴��Ь�Ҽ�¼:��Ь�һ�ȡ��¼
	 */
	public String seePaixieB(){
		Users users = (Users) request.getSession().getAttribute("user");
		
		//ҳ�洦��
		String type = request.getParameter("type");
		
		int paixieBState = 0;                 //��ʼ��Ϊ��Ь��֧����¼
		if("pxbhqjl".equals(type)){           //��Ь�һ�ȡ��¼
			paixieBState = 1;
		}
	
		//��ȡ�û�����Ь�Ҽ�¼
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
	 * ��ȡ��Ь��
	 */
	public String getPaixieB(){
		String paixieBNum = request.getParameter("paixieBNum");

		Users users = (Users) request.getSession().getAttribute("user");
		if(Integer.valueOf(paixieBNum)>users.getPaixieB()){
			writeToPage("�����"+users.getPaixieB()+"����Ь��,"+users.getPaixieB());
		}
		else {
			writeToPage("����ʹ��");
		}
		return null;
	}
}
