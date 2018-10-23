package com.paixie.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.paixie.domain.Worker;

/**
 *Ա��Ȩ�޿���
 */
public class WorkerAuthorityInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	private String autority;               //��װ����Ĺ���ģ��
	public String getAutority() {
		return autority;
	}

	public void setAutority(String autority) {
		this.autority = autority;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//��ȡ������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//ȡ�����û�
		Worker worker = (Worker) session.get("worker");
		if(worker==null){
			//û��Ȩ�޵�½������ʾ
			ctx.put("tips", "�Բ���,��û�е�¼,���ȵ�¼�ڲ���....");
			ctx.put("type", "login");
		}
		else {
			String position = worker.getPosition().getPositionId();
			//����ǽ���ϵͳ��������Ҫ��ߵ�Ȩ�ޣ�000001(����) ϵͳ����Ա
			if("system".equals(autority)){
				if("100001".equals(position)){
					return invocation.invoke();
				}
			}
			//����û����붩������,����ҪȨ�ޣ�000001(����)��000004(��������Ա)��000005(��Ʒ����Ա)
			if("order".equals(autority)){
				if("100001".equals(position)||"000004".equals(position)||"000005".equals(position)){
					return invocation.invoke();
				}
			}
			
			//����û�������Ʒ��������ҪȨ�ޣ�000001(����)��000002(�ֿ����Ա)��000003(��Ʒ����Ա)
			if("goods".equals(autority)){
				if("100001".equals(position)||"000002".equals(position)||"000003".equals(position)){
					return invocation.invoke();
				}
			}
			//û��Ȩ�޵�½������ʾ
			ctx.put("tips", "�Բ���,��û�иò�����Ȩ��....");
		}
		return "login";
	}
	

}

