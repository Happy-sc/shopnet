$(document).ready(function(){
	var flag1,flag2,flag3,flag4;  //定义全局变量
	
	$("#registSubmit_btn").hover(
		function(){
			$(this).attr("src","../images/proscenium/regist_submit_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/regist_submit_01.jpg");
		}
	)
	
	//验证码
	$(".hztu").click(function(){
		var timenow = new Date().getTime();   
		$("#authImage").attr("src",$("#authImage").attr("src")+"??id="+timenow);
	})
	
	//用户名
	$("#userName").focus(function(){
		var userName_prompt = $("#userName_prompt");
		userName_prompt.html("用户名由6-16位数字、大小写字母组成...");
		userName_prompt.attr("class","tips_prompt");
	})
	
	$("#userName").blur(function(){
		var userName = $("#userName").val();
		var userName_prompt = $("#userName_prompt");
		userName_prompt.html("");
		if(userName==""){
			userName_prompt.html("用户名不能为空,请输入...");
			userName_prompt.attr("class","error_prompt");
			flag1 = false;
			return;
		}
		var reg = /^[a-zA-Z0-9_]{6,16}$/;
		if(reg.test(userName)==false){
			userName_prompt.html("用户名格式错误,请重新输入...");
			userName_prompt.attr("class","error_prompt");
			flag1 = false;
			return;
		}
		if(!$.userNameIsExit(userName)){
			flag1 = false;
			return;
		}
		userName_prompt.attr("class","ok_prompt");
		flag1 = true;
	})
	
	//密码
	$("#password").focus(function(){
		var password_prompt = $("#password_prompt");
		password_prompt.html("密码由6-16位数字、大小写字母、特殊字符组成...");
		password_prompt.attr("class","tips_prompt");
	})
	
	$("#password").blur(function(){
		var password = $("#password").val();
		var password_prompt = $("#password_prompt");
		password_prompt.html("");
		if(password==""){
			password_prompt.html("登录密码不能为空,请输入...");
			password_prompt.attr("class","error_prompt");
			flag2 = false;
			return ;
		}
		var reg = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
		if(reg.test(password)==false){
			password_prompt.html("登录密码格式错误,请重新输入...");
			password_prompt.attr("class","error_prompt");
			flag2 = false;
			return ;
		}
		password_prompt.attr("class","ok_prompt");
		flag2 = true;
	})
	
	//确认密码
	$("#repassword").focus(function(){
		var repassword_prompt = $("#repassword_prompt");
		repassword_prompt.html("请再次输入您的登录密码...");
		repassword_prompt.attr("class","tips_prompt");
	})
	
	$("#repassword").blur(function(){
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var repassword_prompt = $("#repassword_prompt");
		repassword_prompt.html("");
		if(repassword==""){
			repassword_prompt.html("确认密码不能为空,请输入...");
			repassword_prompt.attr("class","error_prompt");
			flag3 = false;
			return;
		}
		if(password!=repassword){
			repassword_prompt.html("两次输入不同,请重新输入...");
			repassword_prompt.attr("class","error_prompt");
			flag3 = false;
			return;
		}
		repassword_prompt.attr("class","ok_prompt");
		flag3 = true;
	})
	
	//验证码
	$("#autoImage").focus(function(){
		var authImage_prompt = $("#authImage_prompt");
		authImage_prompt.html("请输入正确的验证码...");
		authImage_prompt.attr("class","tips_prompt");
	})
	
	$("#autoImage").blur(function(){
		var auth = $("#autoImage").val();
		var authImage_prompt = $("#authImage_prompt");
		authImage_prompt.html("");
		if(auth==""){
			authImage_prompt.html("验证码不能为空,请输入...");
			authImage_prompt.attr("class","error_prompt");
			flag4 = false;
			return ;
		}
		if(!$.testAuth(auth)){
			flag4 = false;
			return ;
		}
		authImage_prompt.attr("class","ok_prompt");
		flag4 = true;
	})
	
	//用户点击注册
	$("#userRegistForm").submit(function(){
		$("#userName").blur();
		$("#password").blur();
		$("#repassword").blur();
		$("#autoImage").blur();
		if(!flag1||!flag2||!flag3||!flag4){
			return false;
		}
		return true;
	})
	
	//邮箱
	$("#email").focus(function(){
		var email_prompt = $("#email_prompt");
		email_prompt.html("请输入您电子邮箱...");
		email_prompt.attr("class","tips_prompt");
	})
	
	$("#email").blur(function(){
		var email = $("#email").val();
		var email_prompt = $("#email_prompt");
		email_prompt.html("");
		if(email==""){
			email_prompt.html("邮箱不能为空,请输入...");
			email_prompt.attr("class","error_prompt");
			flag = false;
			return ;
		}
		var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(reg.test(email)==false){
			email_prompt.html("邮箱格式错误,请重新输入...");
			email_prompt.attr("class","error_prompt");
			flag = false;
			return ;
		}
		if(!$.emailIsExit(email)){
			flag = false;
			return ;
		}
		email_prompt.attr("class","ok_prompt");
		flag = true;
	})
	
	//点击邮箱验证提交
	$("#checkEmailForm").submit(function(){
		$("#email").blur();
		if(!flag){
			return false;
		}
		return true;
	})
	
})

$.extend({
	//判断有户名是否重复
	userNameIsExit:function(userName){
		var flag = true;
		$.ajax({
			type:"GET",
			async:false,
			url:"../users/usersRegist_userNameIsExit.action",
			data:"userName="+userName,
			success: function(data){
				$("#userName_prompt").html(data);
				if(data.indexOf("已经存在")!=-1){
					$("#userName_prompt").attr("class","error_prompt");
					flag = false;
			}}
		})
		return flag;
	},
	
	//验证码是否正确
	testAuth:function(auth){
		var flag = true;
		$.ajax({
			type:"GET",
			async:false,
			url:"../users/usersRegist_testAuth.action",
			data:"auth="+auth,
			success: function(data){
			$("#authImage_prompt").html(data);
			if(data.indexOf("输入错误")!=-1){
				$("#authImage_prompt").attr("class","error_prompt");
				flag = false;
			}}
		})
		return flag;
	},
	
	//电子邮箱是否重复
	emailIsExit:function(email){
		var flag = true;
		$.ajax({
			type:"GET",
			async:false,
			url:"../users/usersRegist_emailIsExit.action",
			data:"email="+email,
			success: function(data){
				$("#email_prompt").html(data);
				if(data.indexOf("已经存在")!=-1){
					$("#email_prompt").attr("class","error_prompt");
					flag = false;
				}}
			})
			return flag ;
		}
})


