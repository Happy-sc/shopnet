package com.paixie.service;

import com.paixie.domain.ShoppingCar;

public interface ShoppingCarService {

	/**
	 * �޸Ļ��߱��湺�ﳵ
	 * @param shoppingCar ���ﳵ
	 */
	void updateOrSave(ShoppingCar shoppingCar);

	/**
	 * ɾ�����ﳵ
	 * @param car ���ﳵ
	 */
	void deleteCar(ShoppingCar car);

}
