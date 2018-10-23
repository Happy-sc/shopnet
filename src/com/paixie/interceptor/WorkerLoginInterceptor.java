package com.paixie.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.paixie.domain.Worker;

/**
 *���е�¼Ȩ�޿���
 */
public class WorkerLoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡ������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//ȡ�����û�
		Worker worker = (Worker) session.get("worker");
		if(worker==null){
			ActionContext.getContext().put("tips", "��û�е�¼,���ȵ�¼�����...");
			ActionContext.getContext().put("type", "login");
			return "login";
		}
		else {
			return invocation.invoke();
		}
	
	}

}

