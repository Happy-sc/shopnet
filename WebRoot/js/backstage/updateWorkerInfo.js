$(document).ready(function(){
	//点击确认修改
	$("#updateWorkerInfoForm").submit(function(){
		var workerName = $("#workerName").val();
		var idCard = $("#workerIDCard").val();
		var birthday = $("#workerBirthday").val();
		var phone = $("#workerPhone").val();
		var address = $("#workerAddress").val();
		var error = $(".errorMessage");
		
		if(workerName.trim()==""){
			error.html("姓名不能为空...");
			return false;
		}
		if(idCard.trim()==""){
			error.html("身份证不能为空...");
			return false;
		}
		var idExp = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
		if(idExp.test(idCard)==false){
			error.html("身份证格式错误...");
			return false;
		}
		if(birthday.trim()==""){
			error.html("出生日期不能为空...");
			return false;
		}
		if(phone.trim()==""){
			error.html("电话号码不能为空...");
			return false;
		}
		var phoneExp_01 = /^1[0-9]{10}/;    //手机号码
		var phoneExp_02 = /^\(?\\d{3,4}[-\\)]?\\d{7,8}$/;    //固定电话
		if(phoneExp_01.test(phone)==false&&phoneExp_02.test(phone)==false){
			error.html("联系电话格式错误...");
			return false;
		}
		if(address.trim()==""){
			error.html("住址不能为空...");
			return false;
		}
		else{
			return true;
		}
	})
	
})