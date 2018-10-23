$(document).ready(function(){
	var flag = true;
	//初始化dialog
	$(".tjbjWorker").dialog({
  		bgiframe: true,
   		resizable: true,
    	width:600,
    	height:310,
  		modal: true,
  		position:[300,85],
      	autoOpen: false,
      	title: "Dialog Title", 
    })
    
    //选定select
    var positionId = $("#sposition").val() ;
    var position = $("#sPositionS").children();
    $.selectedPosition(positionId,position);
    
	//点击添加
	$("#addWorkerBtn").click(function(){
		$("#workerId").val("");
		$("#workerName").val("");
		$("#workerIdCar").val("");
		$("#entryTime").val("");
		$("#position").children().eq(0).attr("selected","selected");
	
		$("#tjbjSubmit").attr("src","../images/backstage/okAdd.jpg");
		$("#tjbjWorkerForm").attr("action","../systemManager/workerManager_saveWorker.action");
		$(".tjbjWorker").dialog("option","title", "增加员工").dialog("open");
	})
	
	//编号
	$("#workerId").focus(function(){
		$("#wokerId_prompt").html("编号由11为数字组成");
		$("#wokerId_prompt").attr("class","prompt_tips");
	})
	
	$("#workerId").blur(function(){
		var workerId = $.trim($(this).val());
		var wokerId_prompt = $("#wokerId_prompt");
		wokerId_prompt.html("");
		if(workerId==""){
			wokerId_prompt.html("编号不能为空..");
			wokerId_prompt.attr("class","prompt_error");
			flag = false;
			return ;
		}
		var reg = /^[0-9]{11}$/;
		if(!reg.test(workerId)){
			wokerId_prompt.html("编号格式错误..");
			wokerId_prompt.attr("class","prompt_error");
			flag = false;
			return ;
		}
		var workerId_1 = $(this).parent().children().eq(0).val();
		if(workerId_1!=""&&workerId_1!=workerId){
			if(!$.wokerIdIsExit(workerId)){
				flag = false;
				return ;
			}
		}
		flag = true;
	})
	
	//员工姓名
	$("#workerName").focus(function(){
		$("#workerName_prompt").html("请输入员工的正确姓名..");
		$("#workerName_prompt").attr("class","prompt_tips");
	})
	
	$("#workerName").blur(function(){
		var workerName = $.trim($(this).val());
		var workerName_prompt = $("#workerName_prompt");
		workerName_prompt.html("");
		if(workerName==""){
			workerName_prompt.html("姓名不能为空..");
			workerName_prompt.attr("class","prompt_error");
			flag = false;
			return;
		}
		flag = true;
	})
	
	//身份证号码
	$("#workerIdCar").focus(function(){
		$("#workerIdCar_prompt").html("请填写员工正确的身份证号码..");
		$("#workerIdCar_prompt").attr("class","prompt_tips");
	})
	
	$("#workerIdCar").blur(function(){
		var workerIdCar = $.trim($(this).val());
		var workerIdCar_prompt = $("#workerIdCar_prompt");
		workerIdCar_prompt.html("");
		if(workerIdCar==""){
			workerIdCar_prompt.html("身份证号码不能为空..");
			workerIdCar_prompt.attr("class","prompt_error");
			flag = false;
			return;
		}
		
		var reg1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
		var reg2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
		if(!reg1.test(workerIdCar)&&!reg2.test(workerIdCar)){
			workerIdCar_prompt.html("身份证号码格式错误..");
			workerIdCar_prompt.attr("class","prompt_error");
			flag = false;
			return ;
		}
		
		flag = true;
	})
	
	//点击确认
	$("#tjbjWorkerForm").submit(function(){
		var flag1 = $.positionSelected();
		var flag2 = $.entryTime();
		$("#workerId").blur();
		$("#workerName").blur();
		$("#workerIdCar").blur();
		if(!flag1&&!flag2&&!flag){
			return false;
		}
		return true;
	})
	
	//点击查看
	$(".ckWorker").click(function(){
		var workerId = $(this).parent().children().eq(0).val();
		location.href = "../systemManager/workerManager_showWorkerInfo.action?workerId="+workerId;
	})
	
	//点击删除
	$(".scWorker").click(function(){
		var dworkerId = $(this).parent().children().eq(0).val();
		var sworkerId = $("#sWorkerId").val();
		var sIdCard = $("#sIdCard").val();
		var sPositionId = $("#sPositionS").val();
		var page = $("#page").val();
		var query = "workerId="+dworkerId+"&workerQuery.workerId="+sworkerId+"&workerQuery.idCard="+sIdCard+"&workerQuery.positionId="+sPositionId+"&workerQuery.page="+page
		location.href = "../systemManager/workerManager_deleteWorker.action?"+query;
	})
	
	//点击编辑
	$(".bjWorker").click(function(){
		var _tr = $(this).parent().parent().children();
		var workerId = $.trim(_tr.eq(0).text());
		var workerName = $.trim(_tr.eq(1).text())
		var idCard = $.trim(_tr.eq(2).text());
		var positionId = $.trim($(this).parent().children().eq(1).val());
		var entryTime = $.trim($(this).parent().children().eq(2).val());
		//设定值
		$("#workerId").val(workerId);
		$("#workerId").attr("readonly","readonly");
		$("#workerName").val(workerName);
		$("#workerIdCar").val(idCard);
		$("#entryTime").val(entryTime);
		var position = $("#position").children();
		$.selectedPosition(positionId,position);
		
		//拼接查询条件
		var dworkerId = $(this).parent().children().eq(0).val();
		var sworkerId = $("#sWorkerId").val();
		var sIdCard = $("#sIdCard").val();
		var sPositionId = $("#sPositionS").val();
		var page = $("#page").val();
		var query = "workerId="+dworkerId+"&workerQuery.workerId="+sworkerId+"&workerQuery.idCard="+sIdCard+"&workerQuery.positionId="+sPositionId+"&workerQuery.page="+page
		
		$("#tjbjSubmit").attr("src","../images/backstage/okUpdate.jpg");
		$("#tjbjWorkerForm").attr("action","../systemManager/workerManager_updateWorker.action?"+query);
		
		$(".tjbjWorker").dialog("option","title", "增加员工").dialog("open");
	})
	
	//分页：首页
	$(".sy").click(function(){
		$("#page").val(1);
		$("#searchForm").submit();
	})
	
	//分页：上一页
	$(".syy").click(function(){
		var page = $("#page").val();
		if(page>1){
			page = parseInt(page) -1;
		}
		$("#page").val(page);
		$("#searchForm").submit();
	})
	
	//分页：下一页
	$(".xyy").click(function(){
		$("#page").val(parseInt($("#page").val())+1);
		$("#searchForm").submit();
	})
	//分页：尾页
	$(".wy").click(function(){
		$("#page").val($("#pageCount").val());
		$("#searchForm").submit();
	})

})

$.extend({
	//员工编号是否存在
	wokerIdIsExit:function(workerId){
		var flag ;
		var url = "../systemManager/workerManager_wokerIdIsExit.action";
		$.ajax({
			url : url,
			async  :false,
			data : "workerId="+workerId,
			dataType : "text",
			success:function(data){
				$("#wokerId_prompt").html(data);
				if(data.indexOf("存在")!=-1){
					$("#wokerId_prompt").attr("class","prompt_error");
					flag = false;
				}
				else{
					$("#wokerId_prompt").attr("class","prompt_tips");
					flag =true;
				}
				
			}
		})
		return flag;
	},
	
	//是否选择员工职务
	positionSelected:function(){
		var flag = true;
		var position = $("#position").val();
		$("wokerPosition_prompt").html("");
		if(position=="-1"){
			$("#wokerPosition_prompt").html("请选择员工职务");
			$("#wokerPosition_prompt").attr("class","prompt_error");
			flag = false;
		}
		return false;
	},
	
	//是否输入入职时间
	entryTime:function(){
		var flag = true;
		var entryTime = $("#entryTime").val();
		$("#wokerEntryTime_prompt").html("");
		if(entryTime==""){
			$("#wokerEntryTime_prompt").html("请输入入职时间");
			$("#wokerEntryTime_prompt").attr("class","prompt_error");
			flag = false;
		}
		return flag;
	},
	
	//选定职务
	selectedPosition:function(positionId,position){
   		for(var i = 0;i < position.length;i++){
   			if(positionId==position.eq(i).val()){
   				position.eq(i).attr("selected","selected");
   			}
   		}
	}
	
})
