$(document).ready(function(){
	var flag;
	
	//������
	$("#oldPassword").focus(
		function(){
			$("#oldPrompt").html("������������ȷ��ԭʼ����...");
			$("#oldPrompt").attr("class","messagePrompt");
		}	
	)
	
	$("#oldPassword").blur(
		function(){
			var oldPw= $(this).val();
			var oldPw_prompt =$("#oldPrompt");
			if(oldPw==""||oldPw==null){
				oldPw_prompt.html("�������벻��Ϊ��,������..");
				oldPw_prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			flag = "true";
			return true;
		}	
	)
	
	//������
	$("#newPassword").focus(
		function(){
			$("#newPrompt").html("��������ɴ�СдӢ����ĸ��������ɣ�����6��16���ַ�");
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
				newPw_prompt.html("���������벻�ܿ�,������...");
				newPw_prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			if(reg.test(newPw)==false){
				newPw_prompt.html("�������ʽ����,����������...");
				newPw_prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			flag = "true";
			return true;
		}	
	)
	
	//��һ����������
	$("#reNewPassword").focus(
		function(){
			$("#reNewPrompt").html("����һ������������...");
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
				reNew_Prompt.html("����Ϊ��,������...");
				reNew_Prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			if(reNewPw!=newPw){
				reNew_Prompt.html("�����������벻ͬ,����������...");
				reNew_Prompt.attr("class","prompt_error");
				flag = "false";
				return false;
			}
			flag = "true";
			return true;
		}	
	)
	
	//�ύ��
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