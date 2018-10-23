package com.paixie.action.prosceniums;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.paixie.action.common.BaseAction;
import com.paixie.domain.Order;
import com.paixie.domain.OrderDetail;
import com.paixie.domain.Users;
import com.paixie.service.OrderService;

@Controller("userManagerAction")
public class UserManagerAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Resource(name="orderService")private OrderService orderService;
	
	/**
	 * �����û���������
	 */
	public String enterManagerCenter(){
		//�жϰ�ȫ����
		int i = 1;          //Ĭ�ϲ���Ϊ1�����Ѿ�����������
		Users users = (Users) session.getAttribute("user");
		if(users.getIsActivate()==1){          //�����Ѿ���֤ ��ȫ����+1
			i++;
		}
		if(users.getSecretSecurities()!=null){     //�������ܱ� ��ȫ����+
			i++;
		}
		
		//��һ����
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();      //��ǰʱ��
		calendar.add(Calendar.MONTH, -1);    //��һ����
		Date date1 = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endTime = sdf.format(date);
		String startTime = sdf.format(date1);
		
		//��ȡ��һ���µĶ���
		Map<Order, List<OrderDetail>> orderList = orderService.getOrderByTime(startTime,endTime,page,users.getUserId());
		
		//��ȡ��һ���µĶ�������
		int sum = orderService.getOrderSumByTime(startTime,endTime,users.getUserId());
		pageSum = sum%5==0?sum/5:sum/5+1;
		
		request.setAttribute("i", i);
		request.setAttribute("orders", orderList);
		return "mangerCenter";
	}
}
