package com.shop.service;

import java.util.List;

import com.shop.domain.Worker;
import com.shop.queryBean.WorkerQueryBean;

/**
  * 员工业务接口
  */
public interface WorkerService {
	
	/**
	 * 根据员工编号和密码获取员工
	 * @param workerPassword 登陆密码
	 * 
	 * @return 指定员工编号和密码的员工实例
	 */
	public Worker getWorker(String workerID,String workerPassword);
	
	/**
	 * 修改员工信息
	 * @param worker 需要被修改的员工信息
	 */
	public void UpdateWorker(Worker worker);

	/**
	 * 获取指定页面的员工
	 * @param page 页码
	 * @return
	 */
	public List<Worker> getWorkersPage(int page);

	/**
	 * 获取员工的总数
	 * @return
	 */
	public long getWorkerCount();
	
	/**
	 * 获取员工的总页数
	 * @return
	 */
	public int getWorkerPageCount();

	/**
	 * 根据员工编号获取员工实例
	 * @param workerId
	 * @return
	 */
	public Worker getWorkerById(String workerId);

	/**
	 * 保存员工信息
	 * @param worker 员工信息
	 */
	public void saveWorker(Worker worker);

	/**
	 * 根据查询条件获取员工信息
	 * @param workerQuery 查询条件
	 * @return
	 */
	public List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery);

	/**
	 * 删除员工信息
	 * @param workerId 需要被删除的员工编号
	 */
	public void deleteWorker(String workerId);
}

