package com.paixie.action.backstage;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.domain.Position;
import com.paixie.domain.Worker;
import com.paixie.queryBean.WorkerQueryBean;
import com.paixie.service.PositionService;
import com.paixie.service.WorkerService;

@Controller("workerManagerAction")
public class WorkerManagerAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="workerService")
	private WorkerService workerService;
	@Resource(name="positionService")
	private PositionService positionService;
	
	private Worker worker;                    //员工实例
	private WorkerQueryBean workerQuery;	  //查询条件
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	public WorkerQueryBean getWorkerQuery() {
		return workerQuery;
	}

	public void setWorkerQuery(WorkerQueryBean workerQuery) {
		this.workerQuery = workerQuery;
	}

	/**
	 * 进入员工管理界面
	 */
	public String workerManagerUI(){
		//获取员工
		List<Worker> workers = workerService.getWorkersPage(page);
		
		//员工总页数
		pageSum = workerService.getWorkerPageCount();
		
		//获取所有的职务
		List<Position> positions = positionService.getAllPosition();
		
		request.setAttribute("workers", workers);
		request.setAttribute("positions", positions);
		
		return "workerManagerUI";
	}
	
	/**
	 * 判断员工编号是否存在
	 */
	public void wokerIdIsExit(){
		String workerId = request.getParameter("workerId");
		//根据员工编号获取员工实例
		Worker worker1 = workerService.getWorkerById(workerId);
		String flag;
		if(worker1==null){
			flag = "该编号可以使用";
		}
		else{
			flag = "该编号已经存在";
		}
		writeToPage(flag);
		
	}
	
	/**
	 * 增加
	 */
	public String saveWorker(){
		//根据职务编号获取职务实例
		Position position = positionService.getPositionById(worker.getPosition().getPositionId());
		worker.setPosition(position);
		worker.setWorkerPassword("111111");       //设定初始密码
		
		workerService.saveWorker(worker);
		
		return "saveWorker";
	}
	
	/**
	 * 查看员工信息
	 */
	public String showWorkerInfo(){
		String workerId = request.getParameter("workerId");
		Worker worker1 = workerService.getWorkerById(workerId);
		request.setAttribute("worker", worker1);
		return "showWorkerInfo";
	}
	
	/**
	 * 查询员工信息
	 */
	public String searchWorker(){
		//根据查询条件获取人员信息
		List<Worker> workers = workerService.getWorkerByQuery(workerQuery);
		
		//查询所有职位
		List<Position> positions = positionService.getAllPosition();
		
		//总页数
		int pageCount = workers.size()%10==0?workers.size()/10:workers.size()/10+1;
		
		ActionContext.getContext().put("query", workerQuery);
		ActionContext.getContext().put("workers", workers);
		ActionContext.getContext().put("positions", positions);
		ActionContext.getContext().put("page", workerQuery.getPage());
		ActionContext.getContext().put("pageCount", pageCount);
		
		return "searchWorker";
	}
	
	/**
	 * 删除员工信息
	 */
	public String deleteWorker(){
		//获取编号
		String workerId = request.getParameter("workerId");
		//删除员工
		workerService.deleteWorker(workerId);
		request.setAttribute("workerQuery", workerQuery);
		return "editorWorker";
	}
	
	/**
	 * 修改员工信息
	 */
	public String updateWorker(){
		System.out.println(worker);
		System.out.println(workerQuery);
		//根据员工编号获取员工实例
		Worker worker1 = workerService.getWorkerById(worker.getWorkerId());
		//设置值。防止覆盖
		worker1.setWorkerName(worker.getWorkerName());
		worker1.setEntryTime(worker.getEntryTime());
		worker1.setWorkerIdcard(worker.getWorkerIdcard());
		Position position = positionService.getPositionById(worker.getPosition().getPositionId());
		worker1.setPosition(position);
		//修改信息
		workerService.UpdateWorker(worker1);
		//保存查询条件
		request.setAttribute("workerQuery", workerQuery);
		return "editorWorker";
	}
}
