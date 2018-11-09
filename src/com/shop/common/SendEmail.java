package com.shop.common;

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
	
	private String host = "smtp.qq.com";            //邮件主机
	/*
	 *这里填写你的163用户名和密码。
	 当然也可以使用其他的  但是要将host改为相应的
	 */
	private String userName = "***";
	private String password = "******";
	
	/**
	 * 发送邮件
	 * @param toEmail：收件人
	 * @param type：是验证邮箱还是修改邮箱
	 * @param username：收件人用户名
	 * @param random :产生的随机数
	 */
	public void sendEmail(String toEmail,String type,String username,String random){
		Properties props = new Properties();
		props.setProperty("mail.host",host);               //设置邮件主机
		props.setProperty("mail.smtp.auth", "true");      //设置需要验证
		props.setProperty("mail.transport.protocol", "smtp");   //设置使用协议
		Session session = Session.getDefaultInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(userName, password);         //设置用户名、密码
					}
		});
		Message msg = new MimeMessage(session);
		//设置邮件发送内容
		String content = getContent(type,username,random,toEmail);
		try {
			msg.setSubject(getEmailSubject(type));   //设置标题
			msg.setFrom(new InternetAddress("\""+MimeUtility.encodeText("--shop.net") +"\"<chenssy"));       //设置发件人
			msg.setRecipient(RecipientType.TO, new InternetAddress(toEmail));    //设置收件人
			msg.setContent(content, "text/html;charset=gbk");    //邮件内容
			Transport.send(msg);       //邮件发送
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 返回邮件内容
	 * @param type 类型
	 * @param userName   用户名
	 * @param random    随机数
	 * @return 邮件内容
	 */
	public String getContent(String type,String userName,String random,String email){
		//注册邮箱
		if("regist".equals(type)){
			return "发送的邮件内容";
		}
		
		//邮箱验证
		if("checkEmail".equals(type)){
			return "发送的邮件内容";
		}
		
		//修改验证邮箱--提醒邮件
		if("updateRemindEmail".equals(type)){
			return "发送的邮件内容";
		}
	
		if("password_check".equals(type)){
			return "发送的邮件内容";
		}
		if("updateEmail".equals(type)){
			return "发送的邮件内容";
		}
		else {
			return null;
		}
	}
	
	/**
	 * 获取邮件的标题
	 */
	public String getEmailSubject(String type){
		String subject = null;
		if("regist".equals(type)){
			subject = "感谢您注册购物网站[shop.net]";
		}
		if("checkEmail".equals(type)){
			subject = "商城--邮箱验证提醒";
		}
		if("updateRemindEmail".equals(type)){
			subject = "商城--邮箱更改提醒";
		}
		if("password_check".equals(type)){
			subject = "商城--申请找回密码";
		}
		return subject;
	}
}
