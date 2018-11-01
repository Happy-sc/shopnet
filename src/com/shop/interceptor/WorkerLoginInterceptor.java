package com.shop.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shop.domain.Worker;

/**
 *进行登录权限控制
 */
public class WorkerLoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//取出该用户
		Worker worker = (Worker) session.get("worker");
		if(worker==null){
			ActionContext.getContext().put("tips", "您没有登录,请先登录后操作...");
			ActionContext.getContext().put("type", "login");
			return "login";
		}
		else {
			return invocation.invoke();
		}
	
	}

}

