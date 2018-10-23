package com.paixie.action.backstage;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Worker;
import com.paixie.service.WorkerService;

@Controller("managerLoginAction")
public class ManagerLoginAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="workerService")
	private WorkerService workerService;
	
	private Worker worker ;          //Ա����Ϣ

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	/**
	 * �������Ա��½����
	 */
	public String enterLoginUI(){
		return "enterLoginUI";
	}
	
	/**
	 * ����Ա��½-�������������
	 * �ڹ��������������������
	 */
	public String main(){
		/*
		 *ƥ����֤���Ƿ���ȷ
		 *�����ȷ�����ж��û���������
		 *���򷵻ش�����Ϣ 
		 */
		String code = request.getParameter("verifycode");
		String random = (String) session.getAttribute("rand");
		if(code.toLowerCase().equals(random.toLowerCase())){           //��ȷ.��ƥ���û���������
			Worker workern = workerService.getWorker(worker.getWorkerId(), worker.getWorkerPassword());
			if(workern==null){
				ActionContext.getContext().put("workerId", worker.getWorkerId());
				ActionContext.getContext().put("tips", "�û������������...");
				return "loginFail";
			}
			else {
				session.setAttribute("worker", workern);
				return "loginSuccess";
			}
		}
		else{       //���󷵻ش�����Ϣ
			ActionContext.getContext().put("password", worker.getWorkerPassword());
			ActionContext.getContext().put("workerId", worker.getWorkerId());
			ActionContext.getContext().put("tips", "��֤�����...");
			return "loginFail";
		}	
	}
	
	/**
	 * ����Ա�˳�ϵͳ
	 */
	public String exitSystem(){
		Worker worker1 = (Worker) session.getAttribute("worker");
		if(worker1!=null)
			session.removeAttribute("worker");
		return "exitSystem";
			
	}
	
	
	/**
	 * �������ϵͳ��ҳ
	 */
	public String toManageMain(){
		return "managerMain";
	}
}

