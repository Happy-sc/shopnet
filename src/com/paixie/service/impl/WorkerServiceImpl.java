package com.paixie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.WorkerDao;
import com.paixie.domain.Worker;
import com.paixie.queryBean.WorkerQueryBean;
import com.paixie.service.WorkerService;

/**
  * Ա���ӿڵ�ʵ����
*/
@Service("workerService")
public class WorkerServiceImpl implements WorkerService {
	@Resource(name="workerDao")private WorkerDao workerDao;
	
	/**
	 * ����Ա����ź������ȡԱ��
	 * @param workerID Ա����
	 * @param workerPassword ��½����
	 * 
	 * @return ָ��Ա����ź������Ա��ʵ��
	 */
	public Worker getWorker(String workerID, String workerPassword) {
		return workerDao.getWorkerByWorkerIdAndPassword(workerID, workerPassword);
	}

	/**
	 * �޸�Ա����Ϣ
	 * @param worker ��Ҫ���޸ĵ�Ա����Ϣ
	 */
	public void UpdateWorker(Worker worker) {
		workerDao.update(worker);
	}

	/**
	 * ��ȡָ��ҳ���Ա��
	 * @param page ҳ��
	 * @return
	 */
	public List<Worker> getWorkersPage(int page) {
		return workerDao.getAllWorker(page, 10);
	}

	/**
	 * ��ȡԱ��������
	 * @return
	 */
	public long getWorkerCount() {
		return workerDao.getWorkerCount();
	}

	/**
	 * ��ȡԱ������ҳ��
	 * @return
	 */
	public int getWorkerPageCount() {
		long count = getWorkerCount();
		
		return (int) (count%10==0?count/10:count/10+1);
	}

	/**
	 * ����Ա����Ż�ȡԱ��ʵ��
	 * @param workerId
	 * @return
	 */
	public Worker getWorkerById(String workerId) {
		return workerDao.get(workerId);
	}

	/**
	 * ����Ա����Ϣ
	 * @param worker Ա����Ϣ
	 */
	public void saveWorker(Worker worker) {
		workerDao.save(worker);
	}

	/**
	 * ���ݲ�ѯ������ȡԱ����Ϣ
	 * @param workerQuery ��ѯ����
	 * @return
	 */
	public List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery) {
		List<Worker> workerList = workerDao.getWorkerByQuery(workerQuery);
		
		return workerList;
	}

	/**
	 * ɾ��Ա����Ϣ
	 * @param workerId ��Ҫ��ɾ����Ա�����
	 */
	public void deleteWorker(String workerId) {
		workerDao.delete(workerId);
	}
}

