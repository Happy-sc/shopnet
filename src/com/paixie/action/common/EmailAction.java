package com.paixie.action.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.common.GetEmailURL;
import com.paixie.common.GetTime;
import com.paixie.common.SendEmail;
import com.paixie.domain.Users;
import com.paixie.service.EmailService;
import com.paixie.service.UsersService;

/**
 *���������ʼ���֤
 */
@Controller("emailAction")
public class EmailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="sendEmail")private SendEmail sendEmail;
	@Resource(name="emailService")private EmailService emailService;
	/**
	 * �û�ע��:�����û�ע������
	 */
	public String regist(){
		String email = request.getParameter("email");
		String userid = request.getParameter("userId");
		//��ȡע���û�
		Users user = usersService.getUserById(userid);
		
		user = emailService.setUserCheckEmail(user, email,"regist");    //�趨�û���֤������Ϣ
		
		//�����û���Ϣ
		usersService.updateUser(user);       //ע���û�����

		//������֤�ʼ�
		sendEmail.sendEmail(email, "regist", user.getUserName(),user.getCheckCode());
		
		//�����û�ע����Ϣ,
		ActionContext.getContext().getSession().put("user", user);
		ActionContext.getContext().put("emailURL", GetEmailURL.getEmailURL(email));
		
		return "registEmail";
	}
	
	/**
	 *������֤����--������֤����
	 */
	public String inputEmail(){
		//��ȡemail
		String email = request.getParameter("email");
		
		Users user = (Users) request.getSession().getAttribute("user");	
		//�趨
		user = emailService.setUserCheckEmail(user, email,"updateEmail");
		
		//�����趨
		usersService.updateUser(user);
		
		//�����ʼ�����֤����
		sendEmail.sendEmail(email, "checkEmail", user.getUserName(), user.getCheckCode());
		
		//����������ַ
		ActionContext.getContext().put("emailURL", GetEmailURL.getEmailURL(email));
		ActionContext.getContext().put("email", email);
		
		return "inputEmail";
	}
	
	
	/**
	 * �������䡢�޸����䡢��֤����
	 * @return
	 */
	public String checkEmail(){
		//��ȡ����Ļ�����Ϣ
		String userName = request.getParameter("userName");
		String checkCode = request.getParameter("checkCode");
		String email = request.getParameter("email");
		String model = request.getParameter("model");
		
		//��ȡ���û�
		Users user = usersService.getUserByUserName(userName);
		//������䲻Ϊ��,���������
		if(!"".equals(email)&&email!=null)
			user.setUserEmail(email);
		
		String OldcheckCode = user.getCheckCode();
		/*
		 *��֤����
		 *1����֤ʱ�䣺ʱ�䲻�ܹ�����24Сʱ
		 *2����֤��֤�� 
		 */
		
		String thisTime = GetTime.getTime("yyyy-MM-dd HH:mm:ss");    //��֤ʱ��
		String sendTime = user.getEmailDate();                 //�ʼ�����ʱ��
		
		String flag = null;
		
		if(getTimeSubtract(thisTime, sendTime)>24){   //ʱ���ʱ
			flag = "checkFail";
		}
		else{  //ʱ��û�й�ʱƥ����֤��
			if(OldcheckCode.equals(checkCode)){       
				//��֤����ȷ������������Ϣ
				user.setCheckCode("0000");        //��֤���0
				user.setEmailDate("1997-1-1 1:1:1");    //ע��ʱ���0
				user.setIsActivate(1);            //�����Ѿ���֤
				usersService.updateUser(user);
				
				if("updateEmail".equals(model)){
					flag = "toInputEmail";
					session.setAttribute("user", user);
				}
				if("password".equals(model)){
					flag = "toInputPassword";     
					request.setAttribute("userName", userName);   //�һ����벻�Ǳ���session�����Ǳ���userName
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
	 * ����ʱ��������ж��ʼ�ʱ���Ƿ����
	 * @param firstTime   ����
	 * @param secondTime  ������
	 * @return
	 */
	public int getTimeSubtract(String firstTime,String secondTime){
		long startTime = fromDateStringToLong(firstTime);
		long endTime = fromDateStringToLong(secondTime);
		
		long ss = (startTime-endTime)/1000;        //��������
		 
		int h = (int) (ss/3600);     //ת��ΪСʱ
		
		return h;
	}
	
	/**
	 * ��ʱ��ת��Ϊ��
	 * @param time   ʱ��
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
