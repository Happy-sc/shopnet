//��������ֿ�����ʱ
function storageIdFocus(){
	var storageId_prompt = $("#storageId_prompt");
	storageId_prompt.html("�ֿ�����6Ϊ�������,�ҵ�һ������Ϊ0...");
	storageId_prompt.attr("class","tips_prompt");
}

//������뿪�ֿ���ʱ
function storageIdBlur(){
	var storageId = $("#storageId").val();
	var storageId_prompt = $("#storageId_prompt");
	storageId_prompt.html("");
	var reg = /^0[0-9]{5}$/;
	if(storageId==""){
		storageId_prompt.html("�ֿ��Ų���Ϊ��,������...");
		storageId_prompt.attr("class","error_prompt");
		return false;
	}
	if(reg.test(storageId)==false){
		storageId_prompt.html("�ֿ��Ÿ�ʽ����,����������...");
		storageId_prompt.attr("class","error_prompt");
		return false;
	}
	//�жϲֿ����Ƿ��Ѿ�����
	storageIdIsExit(storageId);
	return true;
	$("#storageId_prompt").html(data);
	
}

//�жϲֿ����Ƿ��Ѿ�����
function storageIdIsExit(storageId){
	var url = "../systemManager/storageManager_idIsExit.action";
	$.get(url,{
		storageId:storageId
	},function(data){
		$("#storageId_prompt").html(data);
		if(data.indexOf("�Ѿ�����")==-1){
			$("#storageId_prompt").attr("class","tips_prompt");
		}
		else{
			$("#storageId_prompt").attr("class","error_prompt");
		}
	});
}

//��������ֿ�����ʱ
function storageNameFocus(){
	var storageName_prompt = $("#storageName_prompt");
	storageName_prompt.html("�ֿ����ƿ�������,��ĸ���������,�Ҵ�����λ...");
	storageName_prompt.attr("class","tips_prompt");
}

//������뿪�ֿ�����ʱ
function storageNameBlur(){
	var storageName = $("#storageName").val();
	var storageName_prompt = $("#storageName_prompt");
	storageName_prompt.html("");
	var reg = /^0[0-9]{5}$/;
	if(storageName==""){
		storageName_prompt.html("�ֿ����Ʋ���Ϊ��,������...");
		storageName_prompt.attr("class","error_prompt");
		return false;
	}
	//�жϲֿ������Ƿ��Ѿ�����
	storageNameNameExit(storageName);
	return true;
}

//�жϲֿ����Ƿ��Ѿ�����
function storageNameIsExit(storageName){
	var url = "../systemManager/storageManager_nameIsExit.action";
	$.get(url,{
		storageName:storageName
	},function(data){
		$("#storageName_prompt").html(data);
		if(data.indexOf("�Ѿ�����")==-1){
			$("#storageName_prompt").attr("class","tips_prompt");
		}
		else{
			$("#storageName_prompt").attr("class","error_prompt");
		}
	});
}


