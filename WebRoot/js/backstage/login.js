$(document).ready(function(){
	//�����¼
	$("#loginForm").submit(function(){
		var workerId = $("#workerId").val();
		var password = $("#workerPassword").val();
		var code = $("#code").val();
		var tips = $(".loginError");
		if(workerId.trim()==""){
			tips.html("�������û���...");
			return false;
		}
		else if(password.trim()==""){
			tips.html("����������...");
			return false;
		}
		else if(code.trim()==""){
			tips.html("��������֤��...")
			return false;
		}
		else{
			return true;
		}
	})
	
	//�����һ��
	$("#xyz,#authImage").click(function(){
		var nowTime = new Date().getTime();
		var _src = $("#authImage").attr("src")+"?nowTime="+nowTime;
		$("#authImage").attr("src",_src);
	})
})