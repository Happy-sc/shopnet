/*
 * 修改员工信息
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
		div.innerHTML = "输入信息不能为空,请输入信息后提交..."
		return false;
	   }
	return true;
}

/*
 * 员工修改密码
 */
//当鼠标放入输入旧密码框时
function oldPasswordFocus(){
	    var oldPrompt = document.getElementById("oldPrompt");
		oldPrompt.innerHTML = "请输入您的正确的原始密码...";
		oldPrompt.className = "messagePrompt";
}

//当鼠标离开输入旧密码框时
function oldPasswordBlur(){
	var oldPassword = document.getElementById("oldPassword").value;
	var oldPrompt = document.getElementById("oldPrompt");
	oldPrompt.innerHTML = "";
	if(oldPassword==""){
		oldPrompt.innerHTML = "密码输入不能为空,请输入...";
		oldPrompt.className = "prompt_error";
		return false;
	}
	return false
}

//当鼠标放入输入新密码框时
function newPasswordFocus(){
		var newPrompt = document.getElementById("newPrompt");
		newPrompt.innerHTML = "新密码可由大小写英文字母、数字组成，长度6－16个字符";
		newPrompt.className = "messagePrompt";
}

//当鼠标离开输入新密码框时
function newPasswordBlur(){
	var newPassword = document.getElementById("newPassword").value;
	var newPrompt =document.getElementById("newPrompt");
	newPrompt.innerHTML = "";
	var reg=/^[a-zA-Z0-9]{6,16}$/;
	if(newPassword==""){
		newPrompt.innerHTML = "新密码输入不能空,请输入...";
		newPrompt.className = "prompt_error";
		return false;
	}
	if(reg.test(newPassword)==false){
		newPrompt.innerHTML = "新密码格式错误,请重新输入...";
		newPrompt.className = "prompt_error";
		return false;
	}
	return true;
}

//当鼠标放入再输入一次密码框时
function reNewPasswordFocus(){
	var renewPrompt = document.getElementById("reNewPrompt");
	renewPrompt.innerHTML = "请再一次输入密码.....";
	renewPrompt.className = "messagePrompt";
}

//当鼠标离开再输入一次密码框时
function reNewPasswordBlur(){
	var newPassword = document.getElementById("newPassword").value;
	var reNewPassword = document.getElementById("reNewPassword").value;
	var newPrompt = document.getElementById("reNewPrompt");
	newPrompt.innerHTML = "";
	if(reNewPassword==""){
		newPrompt.innerHTML = "密码输入不能为空,请重新输入....";
		newPrompt.className = "prompt_error";
		return false;
	}
	if(newPassword!=reNewPassword){
		newPrompt.innerHTML = "两次密码输入不同,请重新输入...";
		newPrompt.className = "prompt_error";
		return false;
	}
	return true;
}

//当点击确定修改
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
 * 搜索员工信息
 */
function checkRearchForms(){
	var workerId = document.getElementById("workerId").value;
	var workerName = document.getElementById("workerName").value;
	var positionId = document.getElementById("positionId").value;
	var message = document.getElementById("message");
	
	if(workerId==""&&workerName==""&&positionId=="-1"){
		message.innerHTML = "输入搜索条件不能为空,请输入搜索条件....";
		return false;
	}
	return true;
}

/*
 * 添加员工信息
 */
//当鼠标放在员工编号的输入框中时
function workerIdFocus(){
	var workerId_prompt = document.getElementById("workerId_prompt");
		workerId_prompt.innerHTML = "员工编号由11位的数字组成....";
		workerId_prompt.className = "addWorker_prompt";
}

//当鼠标离开员工编号的输入框中时
function workerIdBlur(){
	var workerId = document.getElementById("workerId").value;
	var workerId_prompt = document.getElementById("workerId_prompt");
	var reg = /^\d{11}$/;
	workerId_prompt.innerHTML = "";
	if(workerId==""){
		workerId_prompt.innerHTML = "员工编号不能为空,请输入....";
		workerId_prompt.className = "prompt_error";
		return false;
	}
	if(reg.test(workerId)==false){
		workerId_prompt.innerHTML = "员工编号格式错误,请重新输入...";
		workerId_prompt.className = "prompt_error";
		return false;
	}
	idIsExit(workerId);        //判断该员工编号是否存在
	return true;
}

//验证该员工是否存在
function idIsExit(workerId){
	var url = "../systemManager/systemWorkerManager_idIsExit.action";
	$.get(url,{
		workerId:workerId
	},function(data){
		document.getElementById("workerId_prompt").innerHTML = data;
		if(data.indexOf("已经存在")==-1){
			document.getElementById("workerId_prompt").className = "addWorker_prompt";
		}
		else{
			document.getElementById("workerId_prompt").className = "prompt_error";
		}
	})
}

//当鼠标放在员工姓名的输入框中时
function workerNameFocus(){
	var workerName_prompt = document.getElementById("workerName_prompt");
	workerName_prompt.innerHTML = "请输入员工姓名...";
	workerName_prompt.className = "addworker_prompt";
}

//当鼠标里离开员工姓名的输入框中时
function workerNameBlur(){
	var workerName = document.getElementById("workerName").value;
	var workerName_prompt = document.getElementById("workerName_prompt");
	workerName_prompt.innerHTML = "";
	if(workerName==""){
		workerName_prompt.innerHTML = "员工姓名不能为空,请输入...";
		workerName_prompt.className = "prompt_error";
		return false;
	}
	return true;
}

//当鼠标放在员工身份证号的输入框中时
function workerIdCardFocus(){
	var workerIdCard_prompt = document.getElementById("workerIdCard_prompt");
	workerIdCard_prompt.innerHTML = "身份证由18位的数字组成(最后一个位可为字母)....";
	workerIdCard_prompt.className = "addworker_prompt";
}

//当鼠标离开员工身份证号的输入框中时
function workerIdCardBlur(){
	var workerIdCard = document.getElementById("workerIdCard").value;
	var workerIdCard_prompt = document.getElementById("workerIdCard_prompt");
	workerIdCard_prompt.innerHTML = "";
	var reg = /^\d{17}[xyz0-9]$/;
	if(workerIdCard==""){
		workerIdCard_prompt.innerHTML = "身份证不能为空,请输入...";
		workerIdCard_prompt.className = "prompt_error";
		return false;
	}
	if(reg.test(workerIdCard)==false){
		workerIdCard_prompt.innerHTML = "身份证格式错误,请重新输入...";
		workerIdCard_prompt.className = "prompt_error";
		return false;
	}
	return true;
}

//验证职务
function checkPosition(){
	var positionId = document.getElementById("positionId").value;
	var position_prompt = document.getElementById("position_prompt");
	if(positionId=="-1"){
		position_prompt.innerHTML = "请选择员工职务...";
		position_prompt.className = "prompt_error";
		return false;
	}
	return true;
}

//当点击添加按钮时
function checkAddWorker(){
	if(workerIdBlur()&&workerNameBlur()&&workerIdCardBlur()&&checkPosition()){
		return true;
	}
	return false;
}

























