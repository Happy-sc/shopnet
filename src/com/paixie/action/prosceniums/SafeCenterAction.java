package com.paixie.action.prosceniums;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.paixie.action.common.BaseAction;
import com.paixie.common.GetEmailURL;
import com.paixie.common.GetTime;
import com.paixie.common.MD5;
import com.paixie.common.ProduceId;
import com.paixie.common.SendEmail;
import com.paixie.domain.SecretSecurity;
import com.paixie.domain.Users;
import com.paixie.service.SecretSecurityService;
import com.paixie.service.UsersService;

@Controller("safeCenterAction")
public class SafeCenterAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Resource(name="usersService")private UsersService usersService;
	@Resource(name="sendEmail")private SendEmail sendEmail;
	@Resource(name="secretSecurityService")private SecretSecurityService secretSecurityService;

	
	/**
	 * �����޸�����ҳ��
	 */
	public String enterPassword(){
		return "enterPassword";
	}
	
	/**
	 * �޸�����
	 */
	public String updatePassword(){
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		Users user = (Users) request.getSession().getAttribute("user");
		if(!MD5.getMD5(oldPassword).equals(user.getUserPassword())){
			ActionContext.getContext().put("tips", "�������������������...");
			return "updatePWFaile";
		}
		else {
			user.setUserPassword(MD5.getMD5(newPassword));
			usersService.updateUser(user);
			ActionContext.getContext().put("tips", "��ϲ��,�����޸ĳɹ�...");
			//�����û���Ϣ
			ActionContext.getContext().getSession().put("user", user);
			ActionContext.getContext().put("title", "�޸�����");
			return "updateSuccess";
		}
	}
	
	
	public String enterCheckIdentity(){
		return "checkIdentity";
	}
	
	
	public String checkIdentity(){
		String password = request.getParameter("password");
		Users user = (Users) request.getSession().getAttribute("user");
		if(!MD5.getMD5(password).equals(user.getUserPassword())){    //�������
			request.setAttribute("tips", "��½�����������,����������...");
			return "checkIndentityFail";
		}
		return "inputEmail";
	}

	/**
	 * �����ܱ�����
	 */
	public String enterScreteSecurity(){
		//��ȡ�û����ܱ�
		Users user = (Users) session.getAttribute("user");
		List<SecretSecurity> secretSecurities = secretSecurityService.getSecreteSecurityByUserId(user.getUserId());
		for(int i = 0;i<secretSecurities.size();i++)
			ActionContext.getContext().put("secret_"+i, secretSecurities.get(i));
		return "enterScreteSccurity";
	}
	
	/**
	 * ����������Ϣ
	 */
	public String saveScreteSecutity(){
		String userName = request.getParameter("userName");
		String secretId_01 = request.getParameter("secretId_01");
		String secretId_02 = request.getParameter("secretId_02");
		String secretId_03 = request.getParameter("secretId_03");
		String question_01 = request.getParameter("question_01");
		String question_02 = request.getParameter("question_02");
		String question_03 = request.getParameter("question_03");
		String answer_01 = request.getParameter("answer_01");
		String answer_02 = request.getParameter("answer_02");
		String answer_03 = request.getParameter("answer_03");
		Users users = usersService.getUserByUserName(userName);
		
		if(!"".equals(question_01)){       //��һ���ܱ���Ϊ��,�򱣴�
			SecretSecurity secretSecurity = getSecretSecurity(secretId_01,question_01, answer_01, users);
			secretSecurityService.saveSecret(secretSecurity);
		}
		if(!"".equals(question_02)){       //��һ���ܱ���Ϊ��,�򱣴�
			SecretSecurity secretSecurity = getSecretSecurity(secretId_02,question_02, answer_02, users);
			secretSecurityService.saveSecret(secretSecurity);
		}
		if(!"".equals(question_03)){       //��һ���ܱ���Ϊ��,�򱣴�
			SecretSecurity secretSecurity = getSecretSecurity(secretId_03,question_03, answer_03, users);
			secretSecurityService.saveSecret(secretSecurity);
		}
		ActionContext.getContext().put("tips", "��ϲ���������ܱ��ɹ�...");
		ActionContext.getContext().put("title", "�����ܱ�");
		return "secretSuccess";
	}
	
	
	/**
	 * �õ��ܱ�
	 * @param secreteId �ܱ����
	 * @param question �ܱ�����
	 * @param answer �ܱ���
	 * @param users �û�
	 * @return �ܱ�
	 */
	public SecretSecurity getSecretSecurity(String secretId,String question,String answer,Users users){
		SecretSecurity secretSecurity ;
		if(!"".equals(secretId)){
			secretSecurity = secretSecurityService.getSecretSecurityById(secretId);
		}
		else {
			secretSecurity = new SecretSecurity();
			secretSecurity.setSecretId(ProduceId.getId());
		}
		secretSecurity.setSecretQuestion(question);
		secretSecurity.setSecretAnswer(answer);
		secretSecurity.setUsers(users);
		return secretSecurity;
	}
	
	/**
	 * �޸�����--��֤��ݽ���
	 */
	public String updateEmailUI(){
		return "updateEmailUI";
	}
	
	/**
	 * �޸�����--��֤���:���������ʼ�
	 */
	public String emailIdentity(){
		String password = request.getParameter("password");
		Users user = (Users) request.getSession().getAttribute("user");		
		/*
		 * �������Ϊ�գ��������·�����֤���䣬����Ҫ����������֤
		 */
		if(!"".equals(password)&&password!=null){     
			if(!MD5.getMD5(password).equals(user.getUserPassword())){
				request.setAttribute("tips", "��½�����������,����������...");
				return "updateIndentityFail";
			}
		}
		
		//������֤�ɹ�,�����޸������ʼ�
		String random = ProduceId.getRandom();
		user.setCheckCode(random);
		user.setEmailDate(GetTime.getTime("yyyy-MM-dd HH:mm:ss"));
		usersService.updateUser(user);
		sendEmail.sendEmail(user.getUserEmail(), "updateRemindEmail", user.getUserName(), random);
		
		String email = user.getUserEmail();	
		ActionContext.getContext().put("type", "update");
		ActionContext.getContext().put("emailURL", GetEmailURL.getEmailURL(email));
		ActionContext.getContext().put("email", email);
		return "updateIndentitySuccess";
	}
	
	/**
	 * ��������--���͸�������
	 */
	public String updateSendEmail(){
		String email = request.getParameter("email");
		Users user = (Users) request.getSession().getAttribute("user");
		String random = ProduceId.getRandom();
		sendEmail.sendEmail(email, "updateEmail", user.getUserName(), random);
		
		user.setCheckCode(random);
		usersService.updateUser(user);
		
		ActionContext.getContext().put("type", "updateSend");
		ActionContext.getContext().put("emailURL", GetEmailURL.getEmailURL(email));
		ActionContext.getContext().put("email", email);
		return "updateSendEmailSuccess";
	}

}

