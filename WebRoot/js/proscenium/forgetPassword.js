$(document).ready(function(){
	var flag;   //����ȫ�ֱ���
	//��֤��
	$("#checkCode,#hyzyzm").click(
		function(){
			var timenow = new Date().getTime();   
			$("#checkCode").attr("src",$("#checkCode").attr("src")+"?id="+timenow);
		}	
	)
	
	//�������������
	$("input[type='text']").focus(
		function(){
			$(this).val("");
			$(this).css("border","1px solid #FFCC66");
		}	
	)
	
	//������뿪�����
	$("input[type='text']").blur(
		function(){
			$(this).css("border","1px solid #D7D7D7");
		}	
	)
	
	//�����һ��
	$("#checkIdentityForm").submit(
		function(){
			var userName = $("#checkIdentityForm input[name='userName']");
			var checkCode = $("#checkIdentityForm input[name='checkCode']");
			if(userName.val()==""||userName.val()==null){
				$("div[id='userName']").html("�������û���");
				return false;
			}
			if(checkCode.val()==""||checkCode.val()==null){
				$("div[id='checkCode']").html("��������֤��");
				return false;
			}
			return true;
		}	
	)
	
	//�������������
	$("input[name='newPassword']").focus(
		function(){
			$(this).css("border","1px solid #FFCC66");
			$("#newPassword_prompt").html("������6-16λ���֣���Сд��ĸ���...");
			$("#newPassword_prompt").attr("class","");
		}	
	)
	
	$("input[name='newPassword']").blur(
		function(){
			var newPassword = $(this).val();
			var newPassword_prompt = $("#newPassword_prompt")
			newPassword_prompt.html("");
			if(newPassword==""||newPassword==null){
				newPassword_prompt.html("���벻��Ϊ��...");
				newPassword_prompt.attr("class","error_prompt");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			var reg = /^[a-zA-Z0-9_]{6,16}$/;
			if(reg.test(newPassword)==false){
				newPassword_prompt.html("��¼�����ʽ����,����������...");
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
	
	//������һ������
	$("input[name='reNewPassword']").focus(
		function(){
			$(this).css("border","1px solid #FFCC66");	
			$("#reNewPassword_prompt").html("��������һ��������...");
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
				reNewPassword_prompt.html("��������һ��������...");
				reNewPassword_prompt.attr("class","error_prompt");
				flag = false;
				return false;
			}
			if(reNewPassword!=newPassword){
				reNewPassword_prompt.html("������������벻ͬ...");
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