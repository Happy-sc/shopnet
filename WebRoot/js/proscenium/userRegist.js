$(document).ready(function(){
	var flag1,flag2,flag3,flag4;  //����ȫ�ֱ���
	
	$("#registSubmit_btn").hover(
		function(){
			$(this).attr("src","../images/proscenium/regist_submit_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/regist_submit_01.jpg");
		}
	)
	
	//��֤��
	$(".hztu").click(function(){
		var timenow = new Date().getTime();   
		$("#authImage").attr("src",$("#authImage").attr("src")+"??id="+timenow);
	})
	
	//�û���
	$("#userName").focus(function(){
		var userName_prompt = $("#userName_prompt");
		userName_prompt.html("�û�����6-16λ���֡���Сд��ĸ���...");
		userName_prompt.attr("class","tips_prompt");
	})
	
	$("#userName").blur(function(){
		var userName = $("#userName").val();
		var userName_prompt = $("#userName_prompt");
		userName_prompt.html("");
		if(userName==""){
			userName_prompt.html("�û�������Ϊ��,������...");
			userName_prompt.attr("class","error_prompt");
			flag1 = false;
			return;
		}
		var reg = /^[a-zA-Z0-9_]{6,16}$/;
		if(reg.test(userName)==false){
			userName_prompt.html("�û�����ʽ����,����������...");
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
	
	//����
	$("#password").focus(function(){
		var password_prompt = $("#password_prompt");
		password_prompt.html("������6-16λ���֡���Сд��ĸ�������ַ����...");
		password_prompt.attr("class","tips_prompt");
	})
	
	$("#password").blur(function(){
		var password = $("#password").val();
		var password_prompt = $("#password_prompt");
		password_prompt.html("");
		if(password==""){
			password_prompt.html("��¼���벻��Ϊ��,������...");
			password_prompt.attr("class","error_prompt");
			flag2 = false;
			return ;
		}
		var reg = /^[\@A-Za-z0-9\!\#\$\%\^\&\*\.\~]{6,22}$/;
		if(reg.test(password)==false){
			password_prompt.html("��¼�����ʽ����,����������...");
			password_prompt.attr("class","error_prompt");
			flag2 = false;
			return ;
		}
		password_prompt.attr("class","ok_prompt");
		flag2 = true;
	})
	
	//ȷ������
	$("#repassword").focus(function(){
		var repassword_prompt = $("#repassword_prompt");
		repassword_prompt.html("���ٴ��������ĵ�¼����...");
		repassword_prompt.attr("class","tips_prompt");
	})
	
	$("#repassword").blur(function(){
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var repassword_prompt = $("#repassword_prompt");
		repassword_prompt.html("");
		if(repassword==""){
			repassword_prompt.html("ȷ�����벻��Ϊ��,������...");
			repassword_prompt.attr("class","error_prompt");
			flag3 = false;
			return;
		}
		if(password!=repassword){
			repassword_prompt.html("�������벻ͬ,����������...");
			repassword_prompt.attr("class","error_prompt");
			flag3 = false;
			return;
		}
		repassword_prompt.attr("class","ok_prompt");
		flag3 = true;
	})
	
	//��֤��
	$("#autoImage").focus(function(){
		var authImage_prompt = $("#authImage_prompt");
		authImage_prompt.html("��������ȷ����֤��...");
		authImage_prompt.attr("class","tips_prompt");
	})
	
	$("#autoImage").blur(function(){
		var auth = $("#autoImage").val();
		var authImage_prompt = $("#authImage_prompt");
		authImage_prompt.html("");
		if(auth==""){
			authImage_prompt.html("��֤�벻��Ϊ��,������...");
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
	
	//�û����ע��
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
	
	//����
	$("#email").focus(function(){
		var email_prompt = $("#email_prompt");
		email_prompt.html("����������������...");
		email_prompt.attr("class","tips_prompt");
	})
	
	$("#email").blur(function(){
		var email = $("#email").val();
		var email_prompt = $("#email_prompt");
		email_prompt.html("");
		if(email==""){
			email_prompt.html("���䲻��Ϊ��,������...");
			email_prompt.attr("class","error_prompt");
			flag = false;
			return ;
		}
		var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(reg.test(email)==false){
			email_prompt.html("�����ʽ����,����������...");
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
	
	//���������֤�ύ
	$("#checkEmailForm").submit(function(){
		$("#email").blur();
		if(!flag){
			return false;
		}
		return true;
	})
	
})

$.extend({
	//�ж��л����Ƿ��ظ�
	userNameIsExit:function(userName){
		var flag = true;
		$.ajax({
			type:"GET",
			async:false,
			url:"../users/usersRegist_userNameIsExit.action",
			data:"userName="+userName,
			success: function(data){
				$("#userName_prompt").html(data);
				if(data.indexOf("�Ѿ�����")!=-1){
					$("#userName_prompt").attr("class","error_prompt");
					flag = false;
			}}
		})
		return flag;
	},
	
	//��֤���Ƿ���ȷ
	testAuth:function(auth){
		var flag = true;
		$.ajax({
			type:"GET",
			async:false,
			url:"../users/usersRegist_testAuth.action",
			data:"auth="+auth,
			success: function(data){
			$("#authImage_prompt").html(data);
			if(data.indexOf("�������")!=-1){
				$("#authImage_prompt").attr("class","error_prompt");
				flag = false;
			}}
		})
		return flag;
	},
	
	//���������Ƿ��ظ�
	emailIsExit:function(email){
		var flag = true;
		$.ajax({
			type:"GET",
			async:false,
			url:"../users/usersRegist_emailIsExit.action",
			data:"email="+email,
			success: function(data){
				$("#email_prompt").html(data);
				if(data.indexOf("�Ѿ�����")!=-1){
					$("#email_prompt").attr("class","error_prompt");
					flag = false;
				}}
			})
			return flag ;
		}
})


