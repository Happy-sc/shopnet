package com.paixie.service;

import java.util.List;

import com.paixie.domain.Worker;
import com.paixie.queryBean.WorkerQueryBean;

/**
  * Ա��ҵ��ӿ�
  */
public interface WorkerService {
	
	/**
	 * ����Ա����ź������ȡԱ��
	 * @param workerId Ա����
	 * @param workerPassword ��½����
	 * 
	 * @return ָ��Ա����ź������Ա��ʵ��
	 */
	public Worker getWorker(String workerID,String workerPassword);
	
	/**
	 * �޸�Ա����Ϣ
	 * @param worker ��Ҫ���޸ĵ�Ա����Ϣ
	 */
	public void UpdateWorker(Worker worker);

	/**
	 * ��ȡָ��ҳ���Ա��
	 * @param page ҳ��
	 * @return
	 */
	public List<Worker> getWorkersPage(int page);

	/**
	 * ��ȡԱ��������
	 * @return
	 */
	public long getWorkerCount();
	
	/**
	 * ��ȡԱ������ҳ��
	 * @return
	 */
	public int getWorkerPageCount();

	/**
	 * ����Ա����Ż�ȡԱ��ʵ��
	 * @param workerId
	 * @return
	 */
	public Worker getWorkerById(String workerId);

	/**
	 * ����Ա����Ϣ
	 * @param worker Ա����Ϣ
	 */
	public void saveWorker(Worker worker);

	/**
	 * ���ݲ�ѯ������ȡԱ����Ϣ
	 * @param workerQuery ��ѯ����
	 * @return
	 */
	public List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery);

	/**
	 * ɾ��Ա����Ϣ
	 * @param workerId ��Ҫ��ɾ����Ա�����
	 */
	public void deleteWorker(String workerId);
}

