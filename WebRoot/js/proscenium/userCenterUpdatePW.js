$(document).ready(function() {
	$("#newPassword").keyup(
		function(){
			$.passwordStrength();
		}
	)
	var flag = false;
	//旧密码
	$("#oldPassword").blur(
		function(){
			var oldPassword = $("#oldPassword").val();
			if(oldPassword==""||oldPassword==null){
				$("#oldPW_prompt").html("请输入旧密码...");
				$("#oldPW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			$("#oldPW_prompt").html("");
			flag = true;
			return true
		}	
	)
	
	//新密码
	$("#newPassword").blur(
		function(){
			var newPassword = $("#newPassword").val();
			$("#newPW_prompt").html("");
			if(newPassword==""||newPassword==null){
				$("#newPW_prompt").html("请输入新密码...");
				$("#newPW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			var reg = /^[0-9a-zA-Z]{6,16}$/;
			if(reg.test(newPassword)==false){
				$("#newPW_prompt").html("密码格式不正确,请重新输入...");
				$("#newPW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			$("#newPW_prompt").html("");
			flag = true;
			return true;
		}	
	)
	
	//重新输入新密码
	$("#newRePassword").blur(
		function(){
			var newRePassword = $("#newRePassword").val();
			var newPassword = $("#newPassword").val();
			if(newRePassword==""||newRePassword==null){
				$("#newRePW_prompt").html("请再一次输入新密码...");
				$("#newRePW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			if(newRePassword!=newPassword){
				$("#newRePW_prompt").html("密码不一致,请重新输入...");
				$("#newRePW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			$("#newRePW_prompt").html("");
			flag = true;
			return true;
		}	
	)
	
	//验证表单
	$("#updatePW").submit(
		function(){
		$("#oldPassword").blur();
		$("#newPassword").blur();
		$("#newRePassword").blur();
		return flag;
	})
})