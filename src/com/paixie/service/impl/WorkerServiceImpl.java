package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.WorkerDao;
import com.paixie.domain.Worker;
import com.paixie.queryBean.WorkerQueryBean;
import com.paixie.service.WorkerService;

/**
  * 员工接口的实现类
*/
@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	@Resource(name="workerDao")private WorkerDao workerDao;
	
	/**
	 * 根据员工编号和密码获取员工
	 * @param workerID 员工名
	 * @param workerPassword 登陆密码
	 * 
	 * @return 指定员工编号和密码的员工实例
	 */
	public Worker getWorker(String workerID, String workerPassword) {
		return workerDao.getWorkerByWorkerIdAndPassword(workerID, workerPassword);
	}

	/**
	 * 修改员工信息
	 * @param worker 需要被修改的员工信息
	 */
	public void UpdateWorker(Worker worker) {
		workerDao.update(worker);
	}

	/**
	 * 获取指定页面的员工
	 * @param page 页码
	 * @return
	 */
	public List<Worker> getWorkersPage(int page) {
		return workerDao.getAllWorker(page, 10);
	}

	/**
	 * 获取员工的总数
	 * @return
	 */
	public long getWorkerCount() {
		return workerDao.getWorkerCount();
	}

	/**
	 * 获取员工的总页数
	 * @return
	 */
	public int getWorkerPageCount() {
		long count = getWorkerCount();
		
		return (int) (count%10==0?count/10:count/10+1);
	}

	/**
	 * 根据员工编号获取员工实例
	 * @param workerId
	 * @return
	 */
	public Worker getWorkerById(String workerId) {
		return workerDao.get(workerId);
	}

	/**
	 * 保存员工信息
	 * @param worker 员工信息
	 */
	public void saveWorker(Worker worker) {
		workerDao.save(worker);
	}

	/**
	 * 根据查询条件获取员工信息
	 * @param workerQuery 查询条件
	 * @return
	 */
	public List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery) {
		List<Worker> workerList = workerDao.getWorkerByQuery(workerQuery);
		
		return workerList;
	}

	/**
	 * 删除员工信息
	 * @param workerId 需要被删除的员工编号
	 */
	public void deleteWorker(String workerId) {
		workerDao.delete(workerId);
	}
}

