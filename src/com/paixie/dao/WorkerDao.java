package com.paixie.dao;

import java.util.List;

import com.paixie.domain.Worker;
import com.paixie.queryBean.WorkerQueryBean;

public interface WorkerDao {
	/**
	 * ���ݱ�ʶ���Ի�ȡWorkerʵ��
	 * @param workerId
	 * @return
	 */
	Worker get(String workerId);
	
	/**
	 * ����Workerʵ��
	 * @param worker
	 */
	void save(Worker worker);
	
	/**
	 * ���ݱ�ʶ����ɾ��Workerʵ��
	 * @param workerId
	 */
	void delete(String workerId);
	
	/**
	 * ɾ��Workerʵ��
	 * @param worker
	 */
	void delete(Worker worker);
	
	/**
	 * �޸�Workerʵ��
	 * @param worker
	 */
	void update(Worker worker);
	
	/**
	 * ��ȡȫ����Workerʵ��
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Worker> getAllWorker(int pageNo ,int pageSize);
	
	/**
	 * ����ְ���ȡWorkerʵ��
	 * @param positionId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Worker> getWorkerByPosition(String positionId ,int pageNo,int pageSize);
	
	/**
	 * �����û������������Workerʵ��
	 * @param workerId
	 * @param password
	 * @return
	 */
	Worker getWorkerByWorkerIdAndPassword(String workerId,String password);
	
	/**
	 * ��ȡԱ����������
	 * @return
	 */
	long getWorkerCount();
	
	/**
	 * ��������������ȡWorkerʵ��
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Worker> getWorkerByHQL(String hql,int pageNo,int pageSize);

	/**
	 * ��ȡ�������������Workerʵ����������
	 * @param hQL
	 * @return
	 */
	long getCountBySearch(String hQL);

	
	/**
	 * ��ȡ���ֿ����Ա�������Ա��
	 * @return
	 */
	List<Worker> getWorkerIsNotStorage();
	
	/**
	 * ���ݲ�ѯ������ȡԱ����Ϣ
	 * @param workerQuery ��ѯ����
	 * @return
	 */
	 List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery);

	
}
