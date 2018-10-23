package com.paixie.dao.impl;

import org.springframework.stereotype.Repository;

import com.paixie.dao.ShoppingCarDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.ShoppingCar;

@Repository("shoppingCarDao")
public class ShoppingCarDaoHibernate extends BaseHibernateDaoSupport implements 
		ShoppingCarDao{

	/**
	 * �޸Ļ��߱��湺�ﳵ:����ù��ﳵ�������޸ģ������򱣴�
	 * @param shoppingCar ���ﳵ
	 * @return 
	 */
	public void updateOrSave(ShoppingCar shoppingCar) {
		getHibernateTemplate().saveOrUpdate(shoppingCar);
	}

	/**
	 * ɾ������
	 * @param carId ��Ҫɾ�����ﳵ���
	 */
	public void deleteCar(ShoppingCar car) {
		getHibernateTemplate().delete(car);
	}

}
