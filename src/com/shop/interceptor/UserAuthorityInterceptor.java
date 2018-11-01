package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shop.domain.Users;

public class UserAuthorityInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;
	

	@SuppressWarnings("static-access")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		if(users!=null){
			return invocation.invoke();
		}
		else {
			//获取相关的ActionContext对象
			ActionContext ctx = invocation.getInvocationContext();
			String url = request.getRequestURI();
			ctx.getContext().put("url", url);
			return "login";
		}
	}
}
