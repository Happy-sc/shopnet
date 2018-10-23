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
	 * ���ݱ�ʶ����ɾ��Workerʵ��
	 * @param workerId ��Ҫ��ɾ����Workerʵ���ı�ʶ����ֵ
	 */
	public void delete(String workerId) {
		getHibernateTemplate().delete(get(workerId));
	}

	/**
	 * ɾ��Workerʵ��
	 * @param worker ��Ҫ��ɾ����Workerʵ��
	 */
	public void delete(Worker worker) {
		getHibernateTemplate().delete(worker);
	}

	/**
	 * ���ݱ�ʶ���Ի�ȡWorkerʵ��
	 * @param workerId ��Ҫ��ȡ��Workerʵ���ı�ʶ����ֵ
	 * @return ָ����ʶ����ֵ��Workerʵ��
	 */
	public Worker get(String workerId) {
		return getHibernateTemplate().get(Worker.class, workerId);
	}

	/**
	 * ��ȡȫ����Workerʵ��
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ҳ���С
	 * @return ���ݿ���ȫ����Workerʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getAllWorker(int pageNo,int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Worker>)findByPage("from Worker as w ",offset,pageSize);
	}

	/**
	 * ����ְλ��ȡWorkerʵ��,���ҽ��з�ҳ����
	 * @param positionId ְλ���
	 * @param pageSize ҳ���С
	 * @return ��ְλ�ϵ�����Ա��
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerByPosition(String positionId,int pageNo,int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Worker>)findByPage("from Worker as w where w.position.positionId", positionId, offset, pageSize);
	}

	/**
	 * ����Workerʵ��
	 * @param worker ��Ҫ�������Workerʵ��
	 */
	public void save(Worker worker) {
		getHibernateTemplate().save(worker);
	}

	/**
	 * �޸�Workerʵ��
	 * @param worker ��Ҫ���޸ĵ�Workerʵ��
	 */
	public void update(Worker worker) {
		getHibernateTemplate().update(worker);
	}
	
	/**
	 * ����Ա����ź������ȡWorkerʵ��
	 * @param workerId Ա�����
	 * @param password Ա������
	 * @return ָ����ź������Workerʵ��
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
	 * ��ȡԱ����������
	 * @return Ա����������
	 */
	public long getWorkerCount() {
		return (Long)getHibernateTemplate().find("select count(*) from Worker").get(0);
	}

	/**
	 * ����HQL����ȡWorkerʵ��
	 * @param hql HQL���
	 * @param pageNo ָ��ҳ��
	 * @param pageSize ҳ���С
	 * @return ����������Workerʵ��
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerByHQL(String hql, int pageNo, int pageSize) {
		int offset = (pageNo-1)*pageSize;
		return (List<Worker>) findByPage(hql, offset, pageSize);
	}

	/**
	 * ��ȡ�������������Workerʵ����������
	 * @param hql HQL���
	 * @return ��������Workerʵ������
	 */
	public long getCountBySearch(String hQL) {
		return(Long) getHibernateTemplate().find(hQL).get(0);
	}

	/**
	 * ��ȡ���ֿ����Ա�������Ա��
	 */
	@SuppressWarnings("unchecked")
	public List<Worker> getWorkerIsNotStorage() {
		return (List<Worker>)getHibernateTemplate().find("from Worker as w where w.position.positionId !='000002'");
	}

	/**
	 * ���ݲ�ѯ������ȡԱ����Ϣ
	 * @param workerQuery ��ѯ����
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
	 * ������ѯ���
	 * @param workerQuery ��ѯ����
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
