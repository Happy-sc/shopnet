package com.paixie.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.paixie.dao.WorkerDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.Worker;
import com.paixie.queryBean.WorkerQueryBean;

@Repository("workerDao")
public class WorkerDaoHibernate extends BaseHibernateDaoSupport implements WorkerDao {
	/**
	 * 根据标识属性删除Worker实例
	 * @param workerId 需要被删除的Worker实例的标识属性值
	 */
	public void delete(String workerId) {
		getHibernateTemplate().delete(get(workerId));
	}

	/**
	 * 删除Worker实例
	 * @param worker 需要被删除的Worker实例
	 */
	public void delete(Worker worker) {
		getHibernateTemplate().delete(worker);
	}

	/**
	 * 根据标识属性获取Worker实例
	 * @param workerId 需要获取的Worker实例的标识属性值
	 * @return 指定标识属性值的Worker实例
	 */
	public Worker get(String workerId) {
		return getHibernateTemplate().get(Worker.class, workerId);
	}

	/**
	 * 获取全部的Worker实例
	 * @param pageNo 指定页码
	 * @param pageSize 页面大小
	 * @return 数据库中全部的Worker实例
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getAllWorker(int pageNo,int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Worker>)findByPage("from Worker as w ",offset,pageSize);
	}

	/**
	 * 根据职位获取Worker实例,并且进行分页控制
	 * @param positionId 职位编号
	 * @param pageSize 页面大小
	 * @return 该职位上的所有员工
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerByPosition(String positionId,int pageNo,int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Worker>)findByPage("from Worker as w where w.position.positionId", positionId, offset, pageSize);
	}

	/**
	 * 保存Worker实例
	 * @param worker 需要被保存的Worker实例
	 */
	public void save(Worker worker) {
		getHibernateTemplate().save(worker);
	}

	/**
	 * 修改Worker实例
	 * @param worker 需要被修改的Worker实例
	 */
	public void update(Worker worker) {
		getHibernateTemplate().update(worker);
	}
	
	/**
	 * 根据员工编号和密码获取Worker实例
	 * @param workerId 员工编号
	 * @param password 员工密码
	 * @return 指定编号和密码的Worker实例
	 */
	@SuppressWarnings("unchecked")
	public Worker getWorkerByWorkerIdAndPassword(String workerId,String password){
		List<Worker> workers = getHibernateTemplate().find("from Worker as w where w.workerId=? and w.workerPassword=?",workerId,password);
		if(workers!=null&&workers.size()==1){
			return workers.get(0);
		}
		return null;
	}

	/**
	 * 获取员工的总数量
	 * @return 员工的总数量
	 */
	public long getWorkerCount() {
		return (Long)getHibernateTemplate().find("select count(*) from Worker").get(0);
	}

	/**
	 * 根据HQL语句获取Worker实例
	 * @param hql HQL语句
	 * @param pageNo 指定页面
	 * @param pageSize 页面大小
	 * @return 符合条件的Worker实例
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerByHQL(String hql, int pageNo, int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Worker>) findByPage(hql, offset, pageSize);
	}

	/**
	 * 获取如何搜索条件的Worker实例的总数量
	 * @param hql HQL语句
	 * @return 符合条件Worker实例数量
	 */
	public long getCountBySearch(String hQL) {
		return(Long) getHibernateTemplate().find(hQL).get(0);
	}

	/**
	 * 获取除仓库管理员外的所有员工
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerIsNotStorage() {
		return (List<Worker>)getHibernateTemplate().find("from Worker as w where w.position.positionId !='000002'");
	}

	/**
	 * 根据查询条件获取员工信息
	 * @param workerQuery 查询条件
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerByQuery(WorkerQueryBean workerQuery) {
		String hql = getQuerySql(workerQuery);
		int offset = (workerQuery.getPage()-1)*10;
		List<Worker> workerList = findByPage(hql, offset, 10);
		
		return workerList;
	}

	/**
	 * 构建查询语句
	 * @param workerQuery 查询条件
	 */
	public String getQuerySql(WorkerQueryBean workerQuery){
		StringBuffer sql = new StringBuffer("from Worker as w where '1'='1'");
		if(!"".equals(workerQuery.getWorkerId())&&workerQuery.getWorkerId()!=null){
			sql.append(" and w.workerId like '"+workerQuery.getWorkerId()+"%'");
		}
		if(!"".equals(workerQuery.getIdCard())&&workerQuery.getIdCard()!=null){
			sql.append(" and w.workerIdcard like '"+workerQuery.getIdCard()+"%'");
		}
		if(!"-1".equals(workerQuery.getPositionId())&&workerQuery.getPositionId()!=null){
			sql.append(" and w.position.positionId='"+workerQuery.getPositionId()+"'");
		}
		return sql.toString();
	}
}
