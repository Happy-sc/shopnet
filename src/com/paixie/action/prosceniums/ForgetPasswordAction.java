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
	
	//�����������������֤
	public String enterCheckIdentity(){
		return "checkIdentity";
	}
	
	//���������֤
	public String checkIdentity(){
		String userName = request.getParameter("userName");
		String checkCode = request.getParameter("checkCode");
		
		//��ȡ�û�
		Users users_1 = usersService.getUserByEmail(userName);
		Users users_2 = usersService.getUserByUserName(userName);
		
		Users users = users_1==null?users_2:users_1;
		if(users==null){
			ActionContext.getContext().put("userFlag", "���û�������...");
			return "checkIdentityFail";
		}
		else {
			String rand = (String) request.getSession().getAttribute("rand");
			if(!rand.toLowerCase().equals(checkCode.toLowerCase())){
				ActionContext.getContext().put("userName", userName);
				ActionContext.getContext().put("checkCodeFlag", "��֤�����...");
				return "checkIdentityFail";
			}
			else {
				ActionContext.getContext().put("cUser", users);
				return "checkIdentitySuccess";
			}
		}
	}
	
	//���������֤����
	public String sendCheckEmail(){
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
	
		//�趨����
		Users user = usersService.getUserByUserName(userName);
		
		user = emailService.setUserCheckEmail(user, email, "password");
		
		usersService.updateUser(user);
		
		//���͵����ʼ�
		sendEmail.sendEmail(email, "password_check", userName, user.getCheckCode());
		
		ActionContext.getContext().put("email", GetEmailURL.getEmailURL(email));
		return "sendCheckEmail";
	}
	
	
	//����������
	public String setNewPassword(){
		String userName = request.getParameter("userName");
		String password = request.getParameter("newPassword");

		Users user = usersService.getUserByUserName(userName);
		user.setUserPassword(MD5.getMD5(password));
		usersService.updateUser(user);
		
		return "setNewPassword";
	}
}
