package com.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shop.dao.ShoppingCarDao;
import com.shop.domain.ShoppingCar;
import com.shop.service.ShoppingCarService;

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
	 */
	public void deleteCar(ShoppingCar car) {
		shoppingCarDao.deleteCar(car);
	}

}
