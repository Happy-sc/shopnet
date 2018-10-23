$(document).ready(function() {
	$("#newPassword").keyup(
		function(){
			$.passwordStrength();
		}
	)
	var flag = false;
	//������
	$("#oldPassword").blur(
		function(){
			var oldPassword = $("#oldPassword").val();
			if(oldPassword==""||oldPassword==null){
				$("#oldPW_prompt").html("�����������...");
				$("#oldPW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			$("#oldPW_prompt").html("");
			flag = true;
			return true
		}	
	)
	
	//������
	$("#newPassword").blur(
		function(){
			var newPassword = $("#newPassword").val();
			$("#newPW_prompt").html("");
			if(newPassword==""||newPassword==null){
				$("#newPW_prompt").html("������������...");
				$("#newPW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			var reg = /^[0-9a-zA-Z]{6,16}$/;
			if(reg.test(newPassword)==false){
				$("#newPW_prompt").html("�����ʽ����ȷ,����������...");
				$("#newPW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			$("#newPW_prompt").html("");
			flag = true;
			return true;
		}	
	)
	
	//��������������
	$("#newRePassword").blur(
		function(){
			var newRePassword = $("#newRePassword").val();
			var newPassword = $("#newPassword").val();
			if(newRePassword==""||newRePassword==null){
				$("#newRePW_prompt").html("����һ������������...");
				$("#newRePW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			if(newRePassword!=newPassword){
				$("#newRePW_prompt").html("���벻һ��,����������...");
				$("#newRePW_prompt").attr("class","error_prompt");
				flag = false;
				return false;
			}
			$("#newRePW_prompt").html("");
			flag = true;
			return true;
		}	
	)
	
	//��֤��
	$("#updatePW").submit(
		function(){
		$("#oldPassword").blur();
		$("#newPassword").blur();
		$("#newRePassword").blur();
		return flag;
	})
})