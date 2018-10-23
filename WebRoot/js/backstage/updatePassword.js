$(document).ready(function(){
	var flag;
	
	//旧密码
	$("#oldPassword").focus(
		function(){
			$("#oldPrompt").html("请输入您的正确的原始密码...");
			$("#oldPrompt").attr("class","messagePrompt");
		}	
	)
	
	$("#oldPassword").blur(
		function(){
			var oldPw= $(this).val();
			var oldPw_prompt =$("#oldPrompt");
			if(oldPw==""||oldPw==null){
				oldPw_prompt.html("密码输入不能为空,请输入..");
				oldPw_prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			flag = "true";
			return true;
		}	
	)
	
	//新密码
	$("#newPassword").focus(
		function(){
			$("#newPrompt").html("新密码可由大小写英文字母、数字组成，长度6－16个字符");
			$("#newPrompt").attr("class","messagePrompt");
		}	
	)
	
	$("#newPassword").blur(
		function(){
			var newPw = $(this).val();
			var newPw_prompt = $("#newPrompt");
			newPw_prompt.html("");
			var reg=/^[a-zA-Z0-9]{6,16}$/;
			if(newPw==""||newPw==null){
				newPw_prompt.html("新密码输入不能空,请输入...");
				newPw_prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			if(reg.test(newPw)==false){
				newPw_prompt.html("新密码格式错误,请重新输入...");
				newPw_prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			flag = "true";
			return true;
		}	
	)
	
	//再一次输入密码
	$("#reNewPassword").focus(
		function(){
			$("#reNewPrompt").html("请再一次输入新密码...");
			$("#reNewPrompt").attr("class","messagePrompt");
		}	
	)
	
	$("#reNewPassword").blur(
		function(){
			var reNewPw = $(this).val();
			var newPw = $("#newPassword").val();
			var reNew_Prompt = $("#reNewPrompt");
			reNew_Prompt.html("");
			if(reNewPw==""||reNewPw==null){
				reNew_Prompt.html("不能为空,请输入...");
				reNew_Prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			if(reNewPw!=newPw){
				reNew_Prompt.html("两次密码输入不同,请重新输入...");
				reNew_Prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			flag = "true";
			return true;
		}	
	)
	
	//提交表单
	$("#updataPWForm").submit(
		function(){
			$("#oldPassword").blur();
			$("#newPassword").blur();
			$("#reNewPassword").blur();
			if(flag=="false"){
				return false;
			}
			return true;
		}	
	)

})