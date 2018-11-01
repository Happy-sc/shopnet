package com.shop.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shop.domain.Worker;

/**
 *员工权限控制
 */
public class WorkerAuthorityInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	private String autority;               //封装进入的功能模块
	public String getAutority() {
		return autority;
	}

	public void setAutority(String autority) {
		this.autority = autority;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//取出该用户
		Worker worker = (Worker) session.get("worker");
		if(worker==null){
			//没有权限登陆，则提示
			ctx.put("tips", "对不起,您没有登录,请先登录在操作....");
			ctx.put("type", "login");
		}
		else {
			String position = worker.getPosition().getPositionId();
			//如果是进入系统管理，则需要最高的权限：000001(经理) 系统管理员
			if("system".equals(autority)){
				if("100001".equals(position)){
					return invocation.invoke();
				}
			}
			//如果用户进入订单管理,则需要权限：000001(经理)、000004(订单处理员)、000005(商品配送员)
			if("order".equals(autority)){
				if("100001".equals(position)||"000004".equals(position)||"000005".equals(position)){
					return invocation.invoke();
				}
			}
			
			//如果用户进入商品管理，则需要权限：000001(经理)、000002(仓库管理员)、000003(商品管理员)
			if("goods".equals(autority)){
				if("100001".equals(position)||"000002".equals(position)||"000003".equals(position)){
					return invocation.invoke();
				}
			}
			//没有权限登陆，则提示
			ctx.put("tips", "对不起,你没有该操作的权限....");
		}
		return "login";
	}
	

}

