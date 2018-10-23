package com.paixie.action.backstage;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetTime;

@Controller("getTimeAction")
public class GetTimeAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	public String execute(){
		//��ȡ��ǰʱ��
		String time = GetTime.getTime("yyyy-MM-dd HH:mm:ss");
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		String string = "ʱ��:"+time+"&nbsp;&nbsp;&nbsp;&nbsp;";
		writeToPage(string);
		return null;
	}
}
