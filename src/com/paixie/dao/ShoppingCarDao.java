package com.paixie.dao;

import com.paixie.domain.ShoppingCar;

public interface ShoppingCarDao {

	/**
	 * �޸Ļ��߱��湺�ﳵ
	 * @param shoppingCar
	 */
	void updateOrSave(ShoppingCar shoppingCar);

	/**
	 * ɾ�����ﳵ
	 * @param car
	 */
	void deleteCar(ShoppingCar car);

}
