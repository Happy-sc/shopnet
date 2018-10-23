package com.paixie.action.prosceniums;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetEmailURL;
import com.paixie.common.MD5;
import com.paixie.common.SendEmail;
import com.paixie.domain.Users;
import com.paixie.service.EmailService;
import com.paixie.service.UsersService;

@Controller("forgetPasswordAction")
public class ForgetPasswordAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="sendEmail")private SendEmail sendEmail;
	@Resource(name="emailService")private EmailService emailService;
	
	//进入忘记密码身份验证
	public String enterCheckIdentity(){
		return "checkIdentity";
	}
	
	//进行身份验证
	public String checkIdentity(){
		String userName = request.getParameter("userName");
		String checkCode = request.getParameter("checkCode");
		
		//获取用户
		Users users_1 = usersService.getUserByEmail(userName);
		Users users_2 = usersService.getUserByUserName(userName);
		
		Users users = users_1==null?users_2:users_1;
		if(users==null){
			ActionContext.getContext().put("userFlag", "该用户不存在...");
			return "checkIdentityFail";
		}
		else {
			String rand = (String) request.getSession().getAttribute("rand");
			if(!rand.toLowerCase().equals(checkCode.toLowerCase())){
				ActionContext.getContext().put("userName", userName);
				ActionContext.getContext().put("checkCodeFlag", "验证码错误...");
				return "checkIdentityFail";
			}
			else {
				ActionContext.getContext().put("cUser", users);
				return "checkIdentitySuccess";
			}
		}
	}
	
	//发送身份验证邮箱
	public String sendCheckEmail(){
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
	
		//设定邮箱
		Users user = usersService.getUserByUserName(userName);
		
		user = emailService.setUserCheckEmail(user, email, "password");
		
		usersService.updateUser(user);
		
		//发送电子邮件
		sendEmail.sendEmail(email, "password_check", userName, user.getCheckCode());
		
		ActionContext.getContext().put("email", GetEmailURL.getEmailURL(email));
		return "sendCheckEmail";
	}
	
	
	//设置新密码
	public String setNewPassword(){
		String userName = request.getParameter("userName");
		String password = request.getParameter("newPassword");

		Users user = usersService.getUserByUserName(userName);
		user.setUserPassword(MD5.getMD5(password));
		usersService.updateUser(user);
		
		return "setNewPassword";
	}
}
