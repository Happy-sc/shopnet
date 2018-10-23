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
	
	private Worker worker;                    //Ա��ʵ��
	private WorkerQueryBean workerQuery;	  //��ѯ����
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
	 * ����Ա���������
	 */
	public String workerManagerUI(){
		//��ȡԱ��
		List<Worker> workers = workerService.getWorkersPage(page);
		
		//Ա����ҳ��
		pageSum = workerService.getWorkerPageCount();
		
		//��ȡ���е�ְ��
		List<Position> positions = positionService.getAllPosition();
		
		request.setAttribute("workers", workers);
		request.setAttribute("positions", positions);
		
		return "workerManagerUI";
	}
	
	/**
	 * �ж�Ա������Ƿ����
	 */
	public void wokerIdIsExit(){
		String workerId = request.getParameter("workerId");
		//����Ա����Ż�ȡԱ��ʵ��
		Worker worker1 = workerService.getWorkerById(workerId);
		String flag;
		if(worker1==null){
			flag = "�ñ�ſ���ʹ��";
		}
		else{
			flag = "�ñ���Ѿ�����";
		}
		writeToPage(flag);
		
	}
	
	/**
	 * ����
	 */
	public String saveWorker(){
		//����ְ���Ż�ȡְ��ʵ��
		Position position = positionService.getPositionById(worker.getPosition().getPositionId());
		worker.setPosition(position);
		worker.setWorkerPassword("111111");       //�趨��ʼ����
		
		workerService.saveWorker(worker);
		
		return "saveWorker";
	}
	
	/**
	 * �鿴Ա����Ϣ
	 */
	public String showWorkerInfo(){
		String workerId = request.getParameter("workerId");
		Worker worker1 = workerService.getWorkerById(workerId);
		request.setAttribute("worker", worker1);
		return "showWorkerInfo";
	}
	
	/**
	 * ��ѯԱ����Ϣ
	 */
	public String searchWorker(){
		//���ݲ�ѯ������ȡ��Ա��Ϣ
		List<Worker> workers = workerService.getWorkerByQuery(workerQuery);
		
		//��ѯ����ְλ
		List<Position> positions = positionService.getAllPosition();
		
		//��ҳ��
		int pageCount = workers.size()%10==0?workers.size()/10:workers.size()/10+1;
		
		ActionContext.getContext().put("query", workerQuery);
		ActionContext.getContext().put("workers", workers);
		ActionContext.getContext().put("positions", positions);
		ActionContext.getContext().put("page", workerQuery.getPage());
		ActionContext.getContext().put("pageCount", pageCount);
		
		return "searchWorker";
	}
	
	/**
	 * ɾ��Ա����Ϣ
	 */
	public String deleteWorker(){
		//��ȡ���
		String workerId = request.getParameter("workerId");
		//ɾ��Ա��
		workerService.deleteWorker(workerId);
		request.setAttribute("workerQuery", workerQuery);
		return "editorWorker";
	}
	
	/**
	 * �޸�Ա����Ϣ
	 */
	public String updateWorker(){
		System.out.println(worker);
		System.out.println(workerQuery);
		//����Ա����Ż�ȡԱ��ʵ��
		Worker worker1 = workerService.getWorkerById(worker.getWorkerId());
		//����ֵ����ֹ����
		worker1.setWorkerName(worker.getWorkerName());
		worker1.setEntryTime(worker.getEntryTime());
		worker1.setWorkerIdcard(worker.getWorkerIdcard());
		Position position = positionService.getPositionById(worker.getPosition().getPositionId());
		worker1.setPosition(position);
		//�޸���Ϣ
		workerService.UpdateWorker(worker1);
		//�����ѯ����
		request.setAttribute("workerQuery", workerQuery);
		return "editorWorker";
	}
}
