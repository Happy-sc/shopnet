$(document).ready(function(){
	var flag ; //定义全局变量
	$("#passwordForm").submit(
		function(){
			var password = $("input[name=password]").val();
			if(password==""||password==null){
				$(".password_prompt").html("请输入登陆密码...");
				$(".password_prompt").css("color","red");
				return false;
			}
			return true;
		}	
	)
	
	$("#inputMailForm").submit(
		function(){
			var email = $("input[name=email]").val();
			var email_prompt = $(".email_prompt")
			var registEmail = $("#registEmail").html();
			var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(email==""||email==null){
				email_prompt.html("邮件不能为空...");
				email_prompt.css("color","red");
				return false;
			}
			if(reg.test(email)==false){
				email_prompt.html("输入邮件格式错误,请重新输入...");
				email_prompt.css("color","red");
				return false;
			}
			if(email!=registEmail){     //判断该邮箱是否已经注册了
				flag = "";
				$.ajax({
					type:"POST",
					async:false,
					url:"../users/usersRegist_emailIsExit.action",
					data:"email="+email,
					success: function(data){
						$(".email_prompt").html(data);
							if(data.indexOf("已经存在")!=-1){
							$(".email_prompt").css("color","red");
							flag = "false";
							}
						}
					})
				if(flag=="false")return false;
				}
			$("#inputMailForm").submit();    //提交表单
		}	
	)
})