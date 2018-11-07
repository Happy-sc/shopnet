package com.shop.action.backstage;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.domain.Worker;
import com.shop.service.WorkerService;

@Controller("managerLoginAction")
public class ManagerLoginAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="workerService")
	private WorkerService workerService;
	
	private Worker worker ;          //员工信息

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	/**
	 * 进入管理员登陆界面
	 */
	public String enterLoginUI(){
		return "enterLoginUI";
	}
	
	/**
	 * 管理员登陆-进入管理主界面
	 * 在管理界面点击：返回主界面
	 */
	public String main(){
		/*
		 *匹配验证码是否正确
		 *如果正确，则判断用户名和密码
		 *否则返回错误信息 
		 */
		String code = request.getParameter("verifycode");
		String random = (String) session.getAttribute("rand");
		if(code.toLowerCase().equals(random.toLowerCase())){           //正确.则匹配用户名和密码
			Worker workern = workerService.getWorker(worker.getWorkerId(), worker.getWorkerPassword());
			if(workern==null){
				ActionContext.getContext().put("workerId", worker.getWorkerId());
				ActionContext.getContext().put("tips", "用户名或密码错误...");
				return "loginFail";
			} else {
				session.setAttribute("worker", workern);
				return "loginSuccess";
			}
		} else{       //错误返回错误信息
			ActionContext.getContext().put("password", worker.getWorkerPassword());
			ActionContext.getContext().put("workerId", worker.getWorkerId());
			ActionContext.getContext().put("tips", "验证码错误...");
			return "loginFail";
		}	
	}
	
	/**
	 * 管理员退出系统
	 */
	public String exitSystem(){
		Worker worker1 = (Worker) session.getAttribute("worker");
		if(worker1!=null){
			session.removeAttribute("worker");
		}
		return "exitSystem";
			
	}
	
	
	/**
	 * 进入管理系统首页
	 */
	public String toManageMain(){
		return "managerMain";
	}
}

