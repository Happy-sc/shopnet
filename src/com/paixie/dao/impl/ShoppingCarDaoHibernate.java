package com.paixie.dao.impl;

import org.springframework.stereotype.Repository;

import com.paixie.dao.ShoppingCarDao;
import com.paixie.dao.base.BaseHibernateDaoSupport;
import com.paixie.domain.ShoppingCar;

@Repository("shoppingCarDao")
public class ShoppingCarDaoHibernate extends BaseHibernateDaoSupport implements 
		ShoppingCarDao{

	/**
	 * 修改或者保存购物车:如果该购物车存在则修改，否则则保存
	 * @param shoppingCar 购物车
	 * @return 
	 */
	public void updateOrSave(ShoppingCar shoppingCar) {
		getHibernateTemplate().saveOrUpdate(shoppingCar);
	}

	/**
	 * 删除购物
	 * @param carId 需要删除购物车编号
	 */
	public void deleteCar(ShoppingCar car) {
		getHibernateTemplate().delete(car);
	}

}
