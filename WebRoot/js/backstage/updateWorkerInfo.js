$(document).ready(function(){
	//���ȷ���޸�
	$("#updateWorkerInfoForm").submit(function(){
		var workerName = $("#workerName").val();
		var idCard = $("#workerIDCard").val();
		var birthday = $("#workerBirthday").val();
		var phone = $("#workerPhone").val();
		var address = $("#workerAddress").val();
		var error = $(".errorMessage");
		
		if(workerName.trim()==""){
			error.html("��������Ϊ��...");
			return false;
		}
		if(idCard.trim()==""){
			error.html("���֤����Ϊ��...");
			return false;
		}
		var idExp = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
		if(idExp.test(idCard)==false){
			error.html("���֤��ʽ����...");
			return false;
		}
		if(birthday.trim()==""){
			error.html("�������ڲ���Ϊ��...");
			return false;
		}
		if(phone.trim()==""){
			error.html("�绰���벻��Ϊ��...");
			return false;
		}
		var phoneExp_01 = /^1[0-9]{10}/;    //�ֻ�����
		var phoneExp_02 = /^\(?\\d{3,4}[-\\)]?\\d{7,8}$/;    //�̶��绰
		if(phoneExp_01.test(phone)==false&&phoneExp_02.test(phone)==false){
			error.html("��ϵ�绰��ʽ����...");
			return false;
		}
		if(address.trim()==""){
			error.html("סַ����Ϊ��...");
			return false;
		}
		else{
			return true;
		}
	})
	
})