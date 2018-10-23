//当鼠标放在注册图标上时
function login_registOver(){
	$("#login_regist").attr("src","../images/proscenium/user_regist_02.jpg");
}

//当鼠标离开注册图标上时
function login_registOut(){
	$("#login_regist").attr("src","../images/proscenium/user_regist_01.jpg");
}

//当鼠标放入用户名的文本框中时
function userNameFocus(){
	var userName = $("#userName");
	if(userName.val() == "用户名/邮箱"){
		userName.val("");
	}
}

//当鼠标利卡用户名的文本框时
function userNameBlur(){
	var userName = $("#userName");
	if(userName.val()==""||userName==null){
		userName.val("用户名/邮箱");
	}
}

//当点击登录时
function checkLogin(){
	var userName = $("#userName").val();
	var password = $("#password").val();
	var userName_prompt = $("#userName_prompt");
	var password_prompt = $("#password_prompt");
	userName_prompt.html("");
	password_prompt.html("<a href=''>找回密码</a>");
	if(userName==""||userName==null||userName=="用户名/邮箱"){
		userName_prompt.html("请输入用户名");
		userName_prompt.attr("class","error_prompt");
		return false;
	}
	if(password==""||password==null){
		password_prompt.html("请输入密码");
		password_prompt.attr("class","error_prompt");
		return false;
	}
	return true;
}