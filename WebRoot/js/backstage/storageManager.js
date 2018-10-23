//当鼠标放入仓库编号上时
function storageIdFocus(){
	var storageId_prompt = $("#storageId_prompt");
	storageId_prompt.html("仓库编号由6为数字组成,且第一个必须为0...");
	storageId_prompt.attr("class","tips_prompt");
}

//当鼠标离开仓库编号时
function storageIdBlur(){
	var storageId = $("#storageId").val();
	var storageId_prompt = $("#storageId_prompt");
	storageId_prompt.html("");
	var reg = /^0[0-9]{5}$/;
	if(storageId==""){
		storageId_prompt.html("仓库编号不能为空,请输入...");
		storageId_prompt.attr("class","error_prompt");
		return false;
	}
	if(reg.test(storageId)==false){
		storageId_prompt.html("仓库编号格式错误,请重新输入...");
		storageId_prompt.attr("class","error_prompt");
		return false;
	}
	//判断仓库编号是否已经存在
	storageIdIsExit(storageId);
	return true;
	$("#storageId_prompt").html(data);
	
}

//判断仓库编号是否已经存在
function storageIdIsExit(storageId){
	var url = "../systemManager/storageManager_idIsExit.action";
	$.get(url,{
		storageId:storageId
	},function(data){
		$("#storageId_prompt").html(data);
		if(data.indexOf("已经存在")==-1){
			$("#storageId_prompt").attr("class","tips_prompt");
		}
		else{
			$("#storageId_prompt").attr("class","error_prompt");
		}
	});
}

//当鼠标放入仓库名称时
function storageNameFocus(){
	var storageName_prompt = $("#storageName_prompt");
	storageName_prompt.html("仓库名称可由数字,字母，汉子组成,且大于三位...");
	storageName_prompt.attr("class","tips_prompt");
}

//当鼠标离开仓库名称时
function storageNameBlur(){
	var storageName = $("#storageName").val();
	var storageName_prompt = $("#storageName_prompt");
	storageName_prompt.html("");
	var reg = /^0[0-9]{5}$/;
	if(storageName==""){
		storageName_prompt.html("仓库名称不能为空,请输入...");
		storageName_prompt.attr("class","error_prompt");
		return false;
	}
	//判断仓库名称是否已经存在
	storageNameNameExit(storageName);
	return true;
}

//判断仓库编号是否已经存在
function storageNameIsExit(storageName){
	var url = "../systemManager/storageManager_nameIsExit.action";
	$.get(url,{
		storageName:storageName
	},function(data){
		$("#storageName_prompt").html(data);
		if(data.indexOf("已经存在")==-1){
			$("#storageName_prompt").attr("class","tips_prompt");
		}
		else{
			$("#storageName_prompt").attr("class","error_prompt");
		}
	});
}


