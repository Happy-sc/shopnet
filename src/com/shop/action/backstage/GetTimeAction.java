package com.shop.action.backstage;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.GetTime;

@Controller("getTimeAction")
public class GetTimeAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	public String execute(){
		//获取当前时间
		String time = GetTime.getTime("yyyy-MM-dd HH:mm:ss");
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		String string = "时间:"+time+"&nbsp;&nbsp;&nbsp;&nbsp;";
		writeToPage(string);
		return null;
	}
}
