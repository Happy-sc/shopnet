/*
 * �޸�Ա����Ϣ
 */
function checkUpdateForms(){
	var workerId = document.getElementById("workerId").value;
	var workerName = document.getElementById("workerName").value;
	var workerIDCard = document.getElementById("workerIDCard").value;
	var workerBirthday = document.getElementById("workerBirthday").value;
	var workerPhone = document.getElementById("workerPhone").value;
	var workerAddress = document.getElementById("workerAddress").value;
	var div = document.getElementById("errorMessage");
	
	if(workerId==""||workerName==""||workerIDCard==""||workerBirthday==""||
	   	workerPhone==""||workerAddress==""){
		div.innerHTML = "������Ϣ����Ϊ��,��������Ϣ���ύ..."
		return false;
	   }
	return true;
}

/*
 * Ա���޸�����
 */
//������������������ʱ
function oldPasswordFocus(){
	    var oldPrompt = document.getElementById("oldPrompt");
		oldPrompt.innerHTML = "������������ȷ��ԭʼ����...";
		oldPrompt.className = "messagePrompt";
}

//������뿪����������ʱ
function oldPasswordBlur(){
	var oldPassword = document.getElementById("oldPassword").value;
	var oldPrompt = document.getElementById("oldPrompt");
	oldPrompt.innerHTML = "";
	if(oldPassword==""){
		oldPrompt.innerHTML = "�������벻��Ϊ��,������...";
		oldPrompt.className = "prompt_error";
		return false;
	}
	return false
}

//�������������������ʱ
function newPasswordFocus(){
		var newPrompt = document.getElementById("newPrompt");
		newPrompt.innerHTML = "��������ɴ�СдӢ����ĸ��������ɣ�����6��16���ַ�";
		newPrompt.className = "messagePrompt";
}

//������뿪�����������ʱ
function newPasswordBlur(){
	var newPassword = document.getElementById("newPassword").value;
	var newPrompt =document.getElementById("newPrompt");
	newPrompt.innerHTML = "";
	var reg=/^[a-zA-Z0-9]{6,16}$/;
	if(newPassword==""){
		newPrompt.innerHTML = "���������벻�ܿ�,������...";
		newPrompt.className = "prompt_error";
		return false;
	}
	if(reg.test(newPassword)==false){
		newPrompt.innerHTML = "�������ʽ����,����������...";
		newPrompt.className = "prompt_error";
		return false;
	}
	return true;
}

//��������������һ�������ʱ
function reNewPasswordFocus(){
	var renewPrompt = document.getElementById("reNewPrompt");
	renewPrompt.innerHTML = "����һ����������.....";
	renewPrompt.className = "messagePrompt";
}

//������뿪������һ�������ʱ
function reNewPasswordBlur(){
	var newPassword = document.getElementById("newPassword").value;
	var reNewPassword = document.getElementById("reNewPassword").value;
	var newPrompt = document.getElementById("reNewPrompt");
	newPrompt.innerHTML = "";
	if(reNewPassword==""){
		newPrompt.innerHTML = "�������벻��Ϊ��,����������....";
		newPrompt.className = "prompt_error";
		return false;
	}
	if(newPassword!=reNewPassword){
		newPrompt.innerHTML = "�����������벻ͬ,����������...";
		newPrompt.className = "prompt_error";
		return false;
	}
	return true;
}

//�����ȷ���޸�
function checkPasswordForms(){
	if(oldPasswordBlur()==true&&newPasswordBlur()==true&&reNewPasswordBlur()==true){
		return true;
	}
	else{
		alert("3333333333333");
		return false;
	}
}

/*
 * ����Ա����Ϣ
 */
function checkRearchForms(){
	var workerId = document.getElementById("workerId").value;
	var workerName = document.getElementById("workerName").value;
	var positionId = document.getElementById("positionId").value;
	var message = document.getElementById("message");
	
	if(workerId==""&&workerName==""&&positionId=="-1"){
		message.innerHTML = "����������������Ϊ��,��������������....";
		return false;
	}
	return true;
}

/*
 * ���Ա����Ϣ
 */
//��������Ա����ŵ��������ʱ
function workerIdFocus(){
	var workerId_prompt = document.getElementById("workerId_prompt");
		workerId_prompt.innerHTML = "Ա�������11λ���������....";
		workerId_prompt.className = "addWorker_prompt";
}

//������뿪Ա����ŵ��������ʱ
function workerIdBlur(){
	var workerId = document.getElementById("workerId").value;
	var workerId_prompt = document.getElementById("workerId_prompt");
	var reg = /^\d{11}$/;
	workerId_prompt.innerHTML = "";
	if(workerId==""){
		workerId_prompt.innerHTML = "Ա����Ų���Ϊ��,������....";
		workerId_prompt.className = "prompt_error";
		return false;
	}
	if(reg.test(workerId)==false){
		workerId_prompt.innerHTML = "Ա����Ÿ�ʽ����,����������...";
		workerId_prompt.className = "prompt_error";
		return false;
	}
	idIsExit(workerId);        //�жϸ�Ա������Ƿ����
	return true;
}

//��֤��Ա���Ƿ����
function idIsExit(workerId){
	var url = "../systemManager/systemWorkerManager_idIsExit.action";
	$.get(url,{
		workerId:workerId
	},function(data){
		document.getElementById("workerId_prompt").innerHTML = data;
		if(data.indexOf("�Ѿ�����")==-1){
			document.getElementById("workerId_prompt").className = "addWorker_prompt";
		}
		else{
			document.getElementById("workerId_prompt").className = "prompt_error";
		}
	})
}

//��������Ա���������������ʱ
function workerNameFocus(){
	var workerName_prompt = document.getElementById("workerName_prompt");
	workerName_prompt.innerHTML = "������Ա������...";
	workerName_prompt.className = "addworker_prompt";
}

//��������뿪Ա���������������ʱ
function workerNameBlur(){
	var workerName = document.getElementById("workerName").value;
	var workerName_prompt = document.getElementById("workerName_prompt");
	workerName_prompt.innerHTML = "";
	if(workerName==""){
		workerName_prompt.innerHTML = "Ա����������Ϊ��,������...";
		workerName_prompt.className = "prompt_error";
		return false;
	}
	return true;
}

//��������Ա�����֤�ŵ��������ʱ
function workerIdCardFocus(){
	var workerIdCard_prompt = document.getElementById("workerIdCard_prompt");
	workerIdCard_prompt.innerHTML = "���֤��18λ���������(���һ��λ��Ϊ��ĸ)....";
	workerIdCard_prompt.className = "addworker_prompt";
}

//������뿪Ա�����֤�ŵ��������ʱ
function workerIdCardBlur(){
	var workerIdCard = document.getElementById("workerIdCard").value;
	var workerIdCard_prompt = document.getElementById("workerIdCard_prompt");
	workerIdCard_prompt.innerHTML = "";
	var reg = /^\d{17}[xyz0-9]$/;
	if(workerIdCard==""){
		workerIdCard_prompt.innerHTML = "���֤����Ϊ��,������...";
		workerIdCard_prompt.className = "prompt_error";
		return false;
	}
	if(reg.test(workerIdCard)==false){
		workerIdCard_prompt.innerHTML = "���֤��ʽ����,����������...";
		workerIdCard_prompt.className = "prompt_error";
		return false;
	}
	return true;
}

//��ְ֤��
function checkPosition(){
	var positionId = document.getElementById("positionId").value;
	var position_prompt = document.getElementById("position_prompt");
	if(positionId=="-1"){
		position_prompt.innerHTML = "��ѡ��Ա��ְ��...";
		position_prompt.className = "prompt_error";
		return false;
	}
	return true;
}

//�������Ӱ�ťʱ
function checkAddWorker(){
	if(workerIdBlur()&&workerNameBlur()&&workerIdCardBlur()&&checkPosition()){
		return true;
	}
	return false;
}

























