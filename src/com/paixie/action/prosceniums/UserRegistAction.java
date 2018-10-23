package com.paixie.action.prosceniums;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.MD5;
import com.paixie.common.ProduceId;
import com.paixie.domain.Users;
import com.paixie.service.UsersService;

@Controller("userRegistAction")
public class UserRegistAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService") private UsersService usersService;
	private Users users;             //�û�
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	/**
	 * �����û�ע�����
	 */
	public String userRegistUI(){
		return "userRegistUI";
	}
	
	/**
	 * �жϸ��û����Ƿ��Ѿ�����
	 */
	public String userNameIsExit(){
		String userName = request.getParameter("userName");
		Users users = usersService.getUserByUserName(userName);
		String flag= "";
		if(users!=null){
			flag = "���û����Ѿ�����,����������...";
		}
		this.writeToPage(flag);
		return null;
	}
	
	/**
	 * �жϸ������Ƿ��Ѿ�����
	 * @return
	 */
	public String emailIsExit(){
		String email = request.getParameter("email");
		Users users = usersService.getUserByEmail(email);

		String flag = " ";
		if(users!=null){
			flag = "�������Ѿ�����,����������...";
		}
		this.writeToPage(flag);
		return null;
	}
	
	/**
	 * ��֤��֤���Ƿ�������ȷ
	 */
	public String testAuth(){
		String auth = request.getParameter("auth");
		String auth1 = (String) request.getSession().getAttribute("rand");
		String flag = "";
		System.out.println(auth.toLowerCase().equals(auth1.toLowerCase()));
		if(!auth.toLowerCase().equals(auth1.toLowerCase())){
			flag = "��֤���������,����������....";
		}
		
		this.writeToPage(flag);
		return null;
	}
	
	/**
	 * �û�ע��
	 */
	public String userRegist(){
		Users addusers = new Users();
		String userId = ProduceId.getId();
		addusers.setUserId(userId);
		addusers.setUserName(users.getUserName());
		addusers.setUserPassword(MD5.getMD5(users.getUserPassword()));
		usersService.registUsers(addusers);
		ActionContext.getContext().put("userId", userId);
		return "testEmail";       //ע��ɹ���֤����
	}
	
	/**
	 * ��ҳ����ʾ��Ϣ
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
