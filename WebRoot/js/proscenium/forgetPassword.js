$(document).ready(function(){
	var flag;   //定义全局变量
	//验证码
	$("#checkCode,#hyzyzm").click(
		function(){
			var timenow = new Date().getTime();   
			$("#checkCode").attr("src",$("#checkCode").attr("src")+"?id="+timenow);
		}	
	)
	
	//鼠标放入输入框中
	$("input[type='text']").focus(
		function(){
			$(this).val("");
			$(this).css("border","1px solid #FFCC66");
		}	
	)
	
	//当鼠标离开输入框
	$("input[type='text']").blur(
		function(){
			$(this).css("border","1px solid #D7D7D7");
		}	
	)
	
	//点击下一步
	$("#checkIdentityForm").submit(
		function(){
			var userName = $("#checkIdentityForm input[name='userName']");
			var checkCode = $("#checkIdentityForm input[name='checkCode']");
			if(userName.val()==""||userName.val()==null){
				$("div[id='userName']").html("请输入用户名");
				return false;
			}
			if(checkCode.val()==""||checkCode.val()==null){
				$("div[id='checkCode']").html("请输入验证码");
				return false;
			}
			return true;
		}	
	)
	
	//放入输入密码框
	$("input[name='newPassword']").focus(
		function(){
			$(this).css("border","1px solid #FFCC66");
			$("#newPassword_prompt").html("密码由6-16位数字，大小写字母组成...");
			$("#newPassword_prompt").attr("class","");
		}	
	)
	
	$("input[name='newPassword']").blur(
		function(){
			var newPassword = $(this).val();
			var newPassword_prompt = $("#newPassword_prompt")
			newPassword_prompt.html("");
			if(newPassword==""||newPassword==null){
				newPassword_prompt.html("密码不能为空...");
				newPassword_prompt.attr("class","error_prompt");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			var reg = /^[a-zA-Z0-9_]{6,16}$/;
			if(reg.test(newPassword)==false){
				newPassword_prompt.html("登录密码格式错误,请重新输入...");
				newPassword_prompt.attr("class","error_prompt");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			$(this).css("border","1px solid D7D7D7");
			flag = true;
			return true;
		}	
	)
	
	//再输入一次密码
	$("input[name='reNewPassword']").focus(
		function(){
			$(this).css("border","1px solid #FFCC66");	
			$("#reNewPassword_prompt").html("请再输入一次新密码...");
			$("#reNewPassword_prompt").attr("class","");
		}	
	)
	
	$("input[name='reNewPassword']").blur(
		function(){
			var newPassword = $("input[name='newPassword']").val();
			var reNewPassword = $("input[name='reNewPassword']").val();
			var reNewPassword_prompt = $("#reNewPassword_prompt");
			reNewPassword_prompt.html("");
			if(reNewPassword==""||reNewPassword==null){
				reNewPassword_prompt.html("请再输入一次新密码...");
				reNewPassword_prompt.attr("class","error_prompt");
				flag = false;
				return false;
			}
			if(reNewPassword!=newPassword){
				reNewPassword_prompt.html("两次输入的密码不同...");
				reNewPassword_prompt.attr("class","error_prompt");
				flag = false;
				return false;
			}
			$(this).css("border","1px solid D7D7D7");
			flag = true;
			return true;
		}	
	)
	
	
})