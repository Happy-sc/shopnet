package com.shop.action.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.common.GetEmailURL;
import com.shop.common.GetTime;
import com.shop.common.SendEmail;
import com.shop.domain.Users;
import com.shop.service.EmailService;
import com.shop.service.UsersService;

/**
 *该类用于邮件验证
 */
@Controller("emailAction")
public class EmailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="sendEmail")private SendEmail sendEmail;
	@Resource(name="emailService")private EmailService emailService;
	/**
	 * 用户注册:发送用户注册邮箱
	 */
	public String regist(){
		String email = request.getParameter("email");
		String userid = request.getParameter("userId");
		//获取注册用户
		Users user = usersService.getUserById(userid);
		
		user = emailService.setUserCheckEmail(user, email,"regist");    //设定用户验证邮箱信息
		
		//设置用户信息
		usersService.updateUser(user);       //注册用户邮箱

		//发送验证邮件
		sendEmail.sendEmail(email, "regist", user.getUserName(),user.getCheckCode());
		
		//保存用户注册信息,
		ActionContext.getContext().getSession().put("user", user);
		ActionContext.getContext().put("emailURL", GetEmailURL.getEmailURL(email));
		
		return "registEmail";
	}
	
	/**
	 *输入验证邮箱--发送验证邮箱
	 */
	public String inputEmail(){
		//获取email
		String email = request.getParameter("email");
		
		Users user = (Users) request.getSession().getAttribute("user");	
		//设定
		user = emailService.setUserCheckEmail(user, email,"updateEmail");
		
		//保存设定
		usersService.updateUser(user);
		
		//发送邮件：验证邮箱
		sendEmail.sendEmail(email, "checkEmail", user.getUserName(), user.getCheckCode());
		
		//处理该邮箱地址
		ActionContext.getContext().put("emailURL", GetEmailURL.getEmailURL(email));
		ActionContext.getContext().put("email", email);
		
		return "inputEmail";
	}
	
	
	/**
	 * 激活邮箱、修改邮箱、验证邮箱
	 * @return
	 */
	public String checkEmail(){
		//获取激活的基本信息
		String userName = request.getParameter("userName");
		String checkCode = request.getParameter("checkCode");
		String email = request.getParameter("email");
		String model = request.getParameter("model");
		
		//获取该用户
		Users user = usersService.getUserByUserName(userName);
		//如果邮箱不为空,则更新邮箱
		if(!"".equals(email)&&email!=null)
			user.setUserEmail(email);
		
		String OldcheckCode = user.getCheckCode();
		/*
		 *验证邮箱
		 *1、验证时间：时间不能够超过24小时
		 *2、验证验证码 
		 */
		
		String thisTime = GetTime.getTime("yyyy-MM-dd HH:mm:ss");    //验证时间
		String sendTime = user.getEmailDate();                 //邮件发送时间
		
		String flag = null;
		
		if(getTimeSubtract(thisTime, sendTime)>24){   //时间过时
			flag = "checkFail";
		}
		else{  //时间没有过时匹配验证码
			if(OldcheckCode.equals(checkCode)){       
				//验证码正确、设置邮箱信息
				user.setCheckCode("0000");        //验证码归0
				user.setEmailDate("1997-1-1 1:1:1");    //注册时间归0
				user.setIsActivate(1);            //邮箱已经验证
				usersService.updateUser(user);
				
				if("updateEmail".equals(model)){
					flag = "toInputEmail";
					session.setAttribute("user", user);
				}
				if("password".equals(model)){
					flag = "toInputPassword";     
					request.setAttribute("userName", userName);   //找回密码不是保存session、而是保存userName
				}
				else{
					flag = "checkSuccess";
					session.setAttribute("user", user);
				}
			}
			else{
				flag = "checkFail";
			}
		}
		
		return flag;
	}
	
	/**
	 * 两个时间相减：判断邮件时间是否过期
	 * @param firstTime   减数
	 * @param secondTime  被减数
	 * @return
	 */
	public int getTimeSubtract(String firstTime,String secondTime){
		long startTime = fromDateStringToLong(firstTime);
		long endTime = fromDateStringToLong(secondTime);
		
		long ss = (startTime-endTime)/1000;        //共计秒数
		 
		int h = (int) (ss/3600);     //转化为小时
		
		return h;
	}
	
	/**
	 * 将时间转化为妙
	 * @param time   时间
	 * @return
	 */
	public long fromDateStringToLong(String time){
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getTime();
	}
}
