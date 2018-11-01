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
	
	private String host = "smtp.163.com";            //邮件主机
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
		Session session = Session.getDefaultInstance(props, 
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(userName, password);         //设置用户名、密码
					}
		});

		Message msg = new MimeMessage(session);
		//设置邮件发送内容
		String content = getContent(type,username,random,toEmail);
		try {
			msg.setSubject(getEmailSubject(type));   //设置标题
			msg.setFrom(new InternetAddress("\""+MimeUtility.encodeText("拍鞋网--shop.net")
					 +"\"<chenssy"));       //设置发件人
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
			return "<span style='font-size:16px;font-weight:bold;'>尊敬的用户:</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您好：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>欢迎加入中国最大品牌鞋购物商城--拍鞋网（shop.net）大家庭。您已经于"+
            GetTime.getTime("yyyy年MM月dd日")+"申请了用户注册<Br><Br>" +
            "&nbsp;&nbsp;&nbsp;&nbsp;（注册用户名为："+userName+"），<Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;为确保您的注册信息安全，请点击以下链接进行激活：</span> <Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+
            "&email='>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&email=</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(如果上面不是链接形式，请将地址手工粘贴到浏览器地址栏再访问)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>为保障您的帐号安全，请在24小时内点击该链接.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>感谢您的注册，祝您使用愉快.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>请勿回复本邮件，谢谢!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>拍鞋网客户服务</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy年MM月dd日")+"</span>";
		}
		
		//邮箱验证
		if("checkEmail".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>尊敬的"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您好：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您于"+
            GetTime.getTime("yyyy年MM月dd日")+"申请验证邮箱，点击以下链接，即可完成验证：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+
            "&email="+email+"'>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&email="+email+"</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(如果上面不是链接形式，请将地址手工粘贴到浏览器地址栏再访问)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>为保障您的帐号安全，请在24小时内点击该链接.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>请勿回复本邮件，谢谢!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>拍鞋网客户服务</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy年MM月dd日")+"</span>";
		}
		
		//修改验证邮箱--提醒邮件
		if("updateRemindEmail".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>尊敬的"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您好：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您于"+
            GetTime.getTime("yyyy年MM月dd日")+"申请验证邮箱更改服务，点击以下链接，即可进行更改验证邮箱：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&model=updateEmail"+
            "'>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&model=updateEmail</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(如果上面不是链接形式，请将地址手工粘贴到浏览器地址栏再访问)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>为保障您的帐号安全，请在24小时内点击该链接.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>请勿回复本邮件，谢谢!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>拍鞋网客户服务</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy年MM月dd日")+"</span>";
		}
	
		if("password_check".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>尊敬的"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您好：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您于"+
            GetTime.getTime("yyyy年MM月dd日")+"申请找回密码服务，点击以下链接，进行密码更改服务：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+
            "&model=password'>http://localhost:8080/paixieNet/email/checkEmail_checkEmail.action?userName="+userName+"&checkCode="+random+"&model=password</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(如果上面不是链接形式，请将地址手工粘贴到浏览器地址栏再访问)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>为保障您的帐号安全，请在24小时内点击该链接.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>请勿回复本邮件，谢谢!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>拍鞋网客户服务</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy年MM月dd日")+"</span>";
		}
		
		if("updateEmail".equals(type)){
			return "<span style='font-size:16px;font-weight:bold;'>尊敬的"+userName+":</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您好：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>您于"+
            GetTime.getTime("yyyy年MM月dd日")+"申请邮箱更改服务，点击以下链接，即可链接到邮箱更改界面：</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>"+
            "<a href='http://localhost:8080/shop/checkEmail/checkEmail.action?userName="+userName+"&checkCode="+random+
            "&email="+email+"'>http://localhost:8080/shop/checkEmail/checkEmail.action?userName="+userName+"&checkCode="+random+"&email=</a></span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>(如果上面不是链接形式，请将地址手工粘贴到浏览器地址栏再访问)</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>为保障您的帐号安全，请在24小时内点击该链接.</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;<span style='font-size:16px;font-weight:bold;'>请勿回复本邮件，谢谢!!</span><br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>拍鞋网客户服务</span><Br><br>"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
            "<span style='font-size:16px;font-weight:bold;'>"+GetTime.getTime("yyyy年MM月dd日")+"</span>";
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
			subject = "感谢您注册拍鞋购物网站[shop.net]";
		}
		if("checkEmail".equals(type)){
			subject = "拍鞋网上商城--邮箱验证提醒";
		}
		if("updateRemindEmail".equals(type)){
			subject = "拍鞋网商城--邮箱更改提醒";
		}
		if("password_check".equals(type)){
			subject = "拍鞋网商城--申请找回密码";
		}
		return subject;
	}
}
