package com.shop.service;

import com.shop.domain.ShoppingCar;

public interface ShoppingCarService {

	/**
	 * 修改或者保存购物车
	 * @param shoppingCar 购物车
	 */
	void updateOrSave(ShoppingCar shoppingCar);

	/**
	 * 删除购物车
	 * @param car 购物车
	 */
	void deleteCar(ShoppingCar car);

}
