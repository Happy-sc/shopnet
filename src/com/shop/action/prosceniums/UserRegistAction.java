package com.shop.action.prosceniums;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.action.common.BaseAction;
import com.shop.common.MD5;
import com.shop.common.ProduceId;
import com.shop.domain.Users;
import com.shop.service.UsersService;

@Controller("userRegistAction")
public class UserRegistAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService") private UsersService usersService;
	private Users users;             //用户
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * 进入用户注册界面
	 */
	public String userRegistUI(){
		return "userRegistUI";
	}
	
	/**
	 * 判断该用户名是否已经存在
	 */
	public String userNameIsExit(){
		String userName = request.getParameter("userName");
		Users users = usersService.getUserByUserName(userName);
		String flag= "";
		if(users!=null){
			flag = "该用户名已经存在,请重新输入...";
		}
		this.writeToPage(flag);
		return null;
	}
	
	/**
	 * 判断该邮箱是否已经存在
	 * @return
	 */
	public String emailIsExit(){
		String email = request.getParameter("email");
		Users users = usersService.getUserByEmail(email);

		String flag = " ";
		if(users!=null){
			flag = "该邮箱已经存在,请重新输入...";
		}
		this.writeToPage(flag);
		return null;
	}
	
	/**
	 * 验证验证码是否输入正确
	 */
	public String testAuth(){
		String auth = request.getParameter("auth");
		String auth1 = (String) request.getSession().getAttribute("rand");
		String flag = "";
		System.out.println(auth.toLowerCase().equals(auth1.toLowerCase()));
		if(!auth.toLowerCase().equals(auth1.toLowerCase())){
			flag = "验证码输入错误,请重新输入....";
		}
		
		this.writeToPage(flag);
		return null;
	}
	
	/**
	 * 用户注册
	 */
	public String userRegist(){
		Users addusers = new Users();
		String userId = ProduceId.getId();
		addusers.setUserId(userId);
		addusers.setUserName(users.getUserName());
		addusers.setUserPassword(MD5.getMD5(users.getUserPassword()));
		usersService.registUsers(addusers);
		ActionContext.getContext().put("userId", userId);
		return "testEmail";       //注册成功验证邮箱
	}
	
	/**
	 * 向页面显示信息
	 */
	public void writeToPage(String flag){
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
