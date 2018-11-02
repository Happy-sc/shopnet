$(document).ready(function(){
	//点击登录
	$("#loginForm").submit(function(){
		var workerId = $("#workerId").val();
		var password = $("#workerPassword").val();
		var code = $("#code").val();
		var tips = $(".loginError");
		if(workerId.trim()==""){
			tips.html("请输入用户名...");
			return false;
		}
		else if(password.trim()==""){
			tips.html("请输入密码...");
			return false;
		}
		else if(code.trim()==""){
			tips.html("请输入验证码...")
			return false;
		}
		else{
			return true;
		}
	})
	
	//点击下一张
	$("#xyz,#authImage").click(function(){
		var nowTime = new Date().getTime();
		var _src = $("#authImage").attr("src")+"?nowTime="+nowTime;
		$("#authImage").attr("src",_src);
	})
})