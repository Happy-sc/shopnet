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
	 * �޸Ļ��߱��湺�ﳵ:����ù��ﳵ�������޸ģ������򱣴�
	 * @param shoppingCar ���ﳵ
	 * @return 
	 */
	public void updateOrSave(ShoppingCar shoppingCar) {
		shoppingCarDao.updateOrSave(shoppingCar);
	}

	/**
	 * ɾ������
	 * @param carId ��Ҫɾ�����ﳵ���
	 */
	public void deleteCar(ShoppingCar car) {
		shoppingCarDao.deleteCar(car);
	}

}
