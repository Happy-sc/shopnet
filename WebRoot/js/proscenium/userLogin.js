//��������ע��ͼ����ʱ
function login_registOver(){
	$("#login_regist").attr("src","../images/proscenium/user_regist_02.jpg");
}

//������뿪ע��ͼ����ʱ
function login_registOut(){
	$("#login_regist").attr("src","../images/proscenium/user_regist_01.jpg");
}

//���������û������ı�����ʱ
function userNameFocus(){
	var userName = $("#userName");
	if(userName.val() == "�û���/����"){
		userName.val("");
	}
}

//����������û������ı���ʱ
function userNameBlur(){
	var userName = $("#userName");
	if(userName.val()==""||userName==null){
		userName.val("�û���/����");
	}
}

//�������¼ʱ
function checkLogin(){
	var userName = $("#userName").val();
	var password = $("#password").val();
	var userName_prompt = $("#userName_prompt");
	var password_prompt = $("#password_prompt");
	userName_prompt.html("");
	password_prompt.html("<a href=''>�һ�����</a>");
	if(userName==""||userName==null||userName=="�û���/����"){
		userName_prompt.html("�������û���");
		userName_prompt.attr("class","error_prompt");
		return false;
	}
	if(password==""||password==null){
		password_prompt.html("����������");
		password_prompt.attr("class","error_prompt");
		return false;
	}
	return true;
}