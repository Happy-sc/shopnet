package com.shop.dao;

import com.shop.domain.ShoppingCar;

public interface ShoppingCarDao {

	/**
	 * 修改或者保存购物车
	 * @param shoppingCar
	 */
	void updateOrSave(ShoppingCar shoppingCar);

	/**
	 * 删除购物车
	 * @param car
	 */
	void deleteCar(ShoppingCar car);

}
