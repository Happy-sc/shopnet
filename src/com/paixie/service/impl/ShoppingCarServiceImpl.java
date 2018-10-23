package com.paixie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.paixie.dao.ShoppingCarDao;
import com.paixie.domain.ShoppingCar;
import com.paixie.service.ShoppingCarService;

@Service("shoppingCarService")
public class ShoppingCarServiceImpl implements ShoppingCarService{

	@Resource(name="shoppingCarDao")ShoppingCarDao shoppingCarDao;
	
	/**
	 * 修改或者保存购物车:如果该购物车存在则修改，否则则保存
	 * @param shoppingCar 购物车
	 * @return 
	 */
	public void updateOrSave(ShoppingCar shoppingCar) {
		shoppingCarDao.updateOrSave(shoppingCar);
	}

	/**
	 * 删除购物
	 * @param carId 需要删除购物车编号
	 */
	public void deleteCar(ShoppingCar car) {
		shoppingCarDao.deleteCar(car);
	}

}
