$(document).ready(function(){
	var flag ; //����ȫ�ֱ���
	$("#passwordForm").submit(
		function(){
			var password = $("input[name=password]").val();
			if(password==""||password==null){
				$(".password_prompt").html("�������½����...");
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
				email_prompt.html("�ʼ�����Ϊ��...");
				email_prompt.css("color","red");
				return false;
			}
			if(reg.test(email)==false){
				email_prompt.html("�����ʼ���ʽ����,����������...");
				email_prompt.css("color","red");
				return false;
			}
			if(email!=registEmail){     //�жϸ������Ƿ��Ѿ�ע����
				flag = "";
				$.ajax({
					type:"POST",
					async:false,
					url:"../users/usersRegist_emailIsExit.action",
					data:"email="+email,
					success: function(data){
						$(".email_prompt").html(data);
							if(data.indexOf("�Ѿ�����")!=-1){
							$(".email_prompt").css("color","red");
							flag = "false";
							}
						}
					})
				if(flag=="false")return false;
				}
			$("#inputMailForm").submit();    //�ύ��
		}	
	)
})