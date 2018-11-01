package com.shop.dao;

import java.util.List;

import com.shop.domain.Worker;
import com.shop.queryBean.WorkerQueryBean;

public interface WorkerDao {
	/**
	 * 根据标识属性获取Worker实例
	 * @param workerId
	 * @return
	 */
	Worker get(String workerId);
	
	/**
	 * 保存Worker实例
	 * @param worker
	 */
	void save(Worker worker);
	
	/**
	 * 根据标识属性删除Worker实例
	 * @param workerId
	 */
	void delete(String workerId);
	
	/**
	 * 删除Worker实例
	 * @param worker
	 */
	void delete(Worker worker);
	
	/**
	 * 修改Worker实例
	 * @param worker
	 */
	void update(Worker worker);
	
	/**
	 * 获取全部的Worker实例
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Worker> getAllWorker(int pageNo ,int pageSize);
	
	/**
	 * 根据职务获取Worker实例
	 * @param positionId
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Worker> getWorkerByPosition(String positionId ,int pageNo,int pageSize);
	
	/**
	 * 根据用户名和密码查找Worker实例
	 * @param workerId
	 * @param password
	 * @return
	 */
	Worker getWorkerByWorkerIdAndPassword(String workerId,String password);
	
	/**
	 * 获取员工的总数量
	 * @return
	 */
	long getWorkerCount();
	
	/**
	 * 根据搜索条件获取Worker实例
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Worker> getWorkerByHQL(String hql,int pageNo,int pageSize);

	/**
	 * 获取如何搜索条件的Worker实例的总数量
	 * @param hQL
	 * @return
	 */
	long getCountBySearch(String hQL);

	
	/**
	 * 获取除仓库管理员外的所有员工
	 * @return
	 */
	List<Worker> getWorkerIsNotStorage();
	
	/**
	 * 根据查询条件获取员工信息
	 * @param workerQuery 查询条件
	 * @return
	 */
	 List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery);

	
}
