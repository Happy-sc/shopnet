package com.paixie.common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sendEmail")
@Scope("singleton")
public class SendEmail {
	
	private String host = "smtp.163.com";            //�ʼ�����
	/*
	 *������д���163�û��������롣
	 ��ȻҲ����ʹ��������  ����Ҫ��host��Ϊ��Ӧ��
	 */
	private String userName = "***";
	private String password = "******";
	
	/**
	 * �����ʼ�
	 * @param toEmail���ռ���
	 * @param type������֤���仹���޸�����
	 * @param username���ռ����û���
	 * @param random :�����������
	 */
	public void sendEmail(String toEmail,String type,String username,String random){
		Properties props = new Properties();
		props.setProperty("mail.host",host);               //�����ʼ�����
		props.setProperty("mail.smtp.auth", "true");      //������Ҫ��֤
		props.setProperty("mail.transport.protocol", "smtp");   //����ʹ��Э��
		Session session = Session.getDefaultInstance(props, 
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(userName, password);         //�����û���������
					}
		});

		Message msg = new MimeMessage(session);
		//�����ʼ���������
		String content = getContent(type,username,random,toEmail);
		try {
			msg.setSubject(getEmailSubject(type));   //���ñ���
			msg.setFrom(new InternetAddress("\""+MimeUtility.encodeText("��Ь��--paixie.net")
					 +"\"<chenssy"));       //���÷�����
			msg.setRecipient(RecipientType.TO, new InternetAddress(toEmail));    //�����ռ���
			msg.setContent(content, "text/html;charset=gbk");    //�ʼ�����
			
			Transport.send(msg);       //�ʼ�����
		} catch (Exception e) {
			e.printStackTrace();
		}          
		
	}
	
	/**
	 * �����ʼ�����
	 * @param type ����
	 * @param userName   �û���
	 * @param random    �����
	 * @return �ʼ�����
	 */
	public String getContent(String type,String userName,String random,String email){
		//ע������
		if("regist".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>�𾴵��û�:</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>���ã�</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>��ӭ�����й����Ʒ��Ь�����̳�--��Ь����paixie.net�����ͥ�����Ѿ���"+
            GetTime.getTime("yyyy��MM��dd��")+"�������û�ע��<Br><Br>" +
            "&nbsp;&nbsp;&nbsp;&nbsp;��ע���û���Ϊ��"+userName+"����<Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;Ϊȷ������ע����Ϣ��ȫ�������������ӽ��м��</span> <Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+
            "&email='>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&email=</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(������治��������ʽ���뽫��ַ�ֹ�ճ�����������ַ���ٷ���)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>Ϊ���������ʺŰ�ȫ������24Сʱ�ڵ��������.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>��л����ע�ᣬף��ʹ�����.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����ظ����ʼ���лл!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>��Ь���ͻ�����</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy��MM��dd��")+"</span>";
		}
		
		//������֤
		if("checkEmail".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>�𾴵�"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>���ã�</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����"+
            GetTime.getTime("yyyy��MM��dd��")+"������֤���䣬����������ӣ����������֤��</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+
            "&email="+email+"'>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&email="+email+"</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(������治��������ʽ���뽫��ַ�ֹ�ճ�����������ַ���ٷ���)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>Ϊ���������ʺŰ�ȫ������24Сʱ�ڵ��������.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����ظ����ʼ���лл!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>��Ь���ͻ�����</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy��MM��dd��")+"</span>";
		}
		
		//�޸���֤����--�����ʼ�
		if("updateRemindEmail".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>�𾴵�"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>���ã�</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����"+
            GetTime.getTime("yyyy��MM��dd��")+"������֤������ķ��񣬵���������ӣ����ɽ��и�����֤���䣺</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&model=updateEmail"+
            "'>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&model=updateEmail</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(������治��������ʽ���뽫��ַ�ֹ�ճ�����������ַ���ٷ���)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>Ϊ���������ʺŰ�ȫ������24Сʱ�ڵ��������.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����ظ����ʼ���лл!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>��Ь���ͻ�����</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy��MM��dd��")+"</span>";
		}
	
		if("password_check".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>�𾴵�"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>���ã�</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����"+
            GetTime.getTime("yyyy��MM��dd��")+"�����һ�������񣬵���������ӣ�����������ķ���</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+
            "&model=password'>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&model=password</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(������治��������ʽ���뽫��ַ�ֹ�ճ�����������ַ���ٷ���)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>Ϊ���������ʺŰ�ȫ������24Сʱ�ڵ��������.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����ظ����ʼ���лл!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>��Ь���ͻ�����</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy��MM��dd��")+"</span>";
		}
		
		if("updateEmail".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>�𾴵�"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>���ã�</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����"+
            GetTime.getTime("yyyy��MM��dd��")+"����������ķ��񣬵���������ӣ��������ӵ�������Ľ��棺</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixie/checkEmail/checkEmail.action?userName="+userName+"&checkCode="+random+
            "&email="+email+"'>http://localhost:8080/paixie/checkEmail/checkEmail.action?userName="+userName+"&checkCode="+random+"&email=</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(������治��������ʽ���뽫��ַ�ֹ�ճ�����������ַ���ٷ���)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>Ϊ���������ʺŰ�ȫ������24Сʱ�ڵ��������.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>����ظ����ʼ���лл!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>��Ь���ͻ�����</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy��MM��dd��")+"</span>";
		}
		else {
			return null;
		}
	}
	
	/**
	 * ��ȡ�ʼ��ı���
	 */
	public String getEmailSubject(String type){
		String subject = null;
		if("regist".equals(type)){
			subject = "��л��ע����Ь������վ[paixie.net]";
		}
		if("checkEmail".equals(type)){
			subject = "��Ь�����̳�--������֤����";
		}
		if("updateRemindEmail".equals(type)){
			subject = "��Ь���̳�--�����������";
		}
		if("password_check".equals(type)){
			subject = "��Ь���̳�--�����һ�����";
		}
		return subject;
	}
}
