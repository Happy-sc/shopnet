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
	 * 进入用户管理中心
	 */
	public String enterManagerCenter(){
		//判断安全级别
		int i = 1;          //默认参数为1：即已经设置了密码
		Users users = (Users) session.getAttribute("user");
		if(users.getIsActivate()==1){          //邮箱已经验证 安全级别+1
			i++;
		}
		if(users.getSecretSecurities()!=null){     //设置了密保 安全级别+
			i++;
		}
		
		//近一个月
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();      //当前时间
		calendar.add(Calendar.MONTH, -1);    //上一个月
		Date date1 = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String endTime = sdf.format(date);
		String startTime = sdf.format(date1);
		
		//获取近一个月的订单
		Map<Order, List<OrderDetail>> orderList = orderService.getOrderByTime(startTime,endTime,page,users.getUserId());
		
		//获取近一个月的订单总数
		int sum = orderService.getOrderSumByTime(startTime,endTime,users.getUserId());
		pageSum = sum%5==0?sum/5:sum/5+1;
		
		request.setAttribute("i", i);
		request.setAttribute("orders", orderList);
		return "mangerCenter";
	}
}
