$(document).ready(function(){
	var flag = true;
	//��ʼ��dialog
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
    
    //ѡ��select
    var positionId = $("#sposition").val() ;
    var position = $("#sPositionS").children();
    $.selectedPosition(positionId,position);
    
	//������
	$("#addWorkerBtn").click(function(){
		$("#workerId").val("");
		$("#workerName").val("");
		$("#workerIdCar").val("");
		$("#entryTime").val("");
		$("#position").children().eq(0).attr("selected","selected");
	
		$("#tjbjSubmit").attr("src","../images/backstage/okAdd.jpg");
		$("#tjbjWorkerForm").attr("action","../systemManager/workerManager_saveWorker.action");
		$(".tjbjWorker").dialog("option","title", "����Ա��").dialog("open");
	})
	
	//���
	$("#workerId").focus(function(){
		$("#wokerId_prompt").html("�����11Ϊ�������");
		$("#wokerId_prompt").attr("class","prompt_tips");
	})
	
	$("#workerId").blur(function(){
		var workerId = $.trim($(this).val());
		var wokerId_prompt = $("#wokerId_prompt");
		wokerId_prompt.html("");
		if(workerId==""){
			wokerId_prompt.html("��Ų���Ϊ��..");
			wokerId_prompt.attr("class","prompt_error");
			flag = false;
			return ;
		}
		var reg = /^[0-9]{11}$/;
		if(!reg.test(workerId)){
			wokerId_prompt.html("��Ÿ�ʽ����..");
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
	
	//Ա������
	$("#workerName").focus(function(){
		$("#workerName_prompt").html("������Ա������ȷ����..");
		$("#workerName_prompt").attr("class","prompt_tips");
	})
	
	$("#workerName").blur(function(){
		var workerName = $.trim($(this).val());
		var workerName_prompt = $("#workerName_prompt");
		workerName_prompt.html("");
		if(workerName==""){
			workerName_prompt.html("��������Ϊ��..");
			workerName_prompt.attr("class","prompt_error");
			flag = false;
			return;
		}
		flag = true;
	})
	
	//���֤����
	$("#workerIdCar").focus(function(){
		$("#workerIdCar_prompt").html("����дԱ����ȷ�����֤����..");
		$("#workerIdCar_prompt").attr("class","prompt_tips");
	})
	
	$("#workerIdCar").blur(function(){
		var workerIdCar = $.trim($(this).val());
		var workerIdCar_prompt = $("#workerIdCar_prompt");
		workerIdCar_prompt.html("");
		if(workerIdCar==""){
			workerIdCar_prompt.html("���֤���벻��Ϊ��..");
			workerIdCar_prompt.attr("class","prompt_error");
			flag = false;
			return;
		}
		
		var reg1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
		var reg2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
		if(!reg1.test(workerIdCar)&&!reg2.test(workerIdCar)){
			workerIdCar_prompt.html("���֤�����ʽ����..");
			workerIdCar_prompt.attr("class","prompt_error");
			flag = false;
			return ;
		}
		
		flag = true;
	})
	
	//���ȷ��
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
	
	//����鿴
	$(".ckWorker").click(function(){
		var workerId = $(this).parent().children().eq(0).val();
		location.href = "../systemManager/workerManager_showWorkerInfo.action?workerId="+workerId;
	})
	
	//���ɾ��
	$(".scWorker").click(function(){
		var dworkerId = $(this).parent().children().eq(0).val();
		var sworkerId = $("#sWorkerId").val();
		var sIdCard = $("#sIdCard").val();
		var sPositionId = $("#sPositionS").val();
		var page = $("#page").val();
		var query = "workerId="+dworkerId+"&workerQuery.workerId="+sworkerId+"&workerQuery.idCard="+sIdCard+"&workerQuery.positionId="+sPositionId+"&workerQuery.page="+page
		location.href = "../systemManager/workerManager_deleteWorker.action?"+query;
	})
	
	//����༭
	$(".bjWorker").click(function(){
		var _tr = $(this).parent().parent().children();
		var workerId = $.trim(_tr.eq(0).text());
		var workerName = $.trim(_tr.eq(1).text())
		var idCard = $.trim(_tr.eq(2).text());
		var positionId = $.trim($(this).parent().children().eq(1).val());
		var entryTime = $.trim($(this).parent().children().eq(2).val());
		//�趨ֵ
		$("#workerId").val(workerId);
		$("#workerId").attr("readonly","readonly");
		$("#workerName").val(workerName);
		$("#workerIdCar").val(idCard);
		$("#entryTime").val(entryTime);
		var position = $("#position").children();
		$.selectedPosition(positionId,position);
		
		//ƴ�Ӳ�ѯ����
		var dworkerId = $(this).parent().children().eq(0).val();
		var sworkerId = $("#sWorkerId").val();
		var sIdCard = $("#sIdCard").val();
		var sPositionId = $("#sPositionS").val();
		var page = $("#page").val();
		var query = "workerId="+dworkerId+"&workerQuery.workerId="+sworkerId+"&workerQuery.idCard="+sIdCard+"&workerQuery.positionId="+sPositionId+"&workerQuery.page="+page
		
		$("#tjbjSubmit").attr("src","../images/backstage/okUpdate.jpg");
		$("#tjbjWorkerForm").attr("action","../systemManager/workerManager_updateWorker.action?"+query);
		
		$(".tjbjWorker").dialog("option","title", "����Ա��").dialog("open");
	})
	
	//��ҳ����ҳ
	$(".sy").click(function(){
		$("#page").val(1);
		$("#searchForm").submit();
	})
	
	//��ҳ����һҳ
	$(".syy").click(function(){
		var page = $("#page").val();
		if(page>1){
			page = parseInt(page) -1;
		}
		$("#page").val(page);
		$("#searchForm").submit();
	})
	
	//��ҳ����һҳ
	$(".xyy").click(function(){
		$("#page").val(parseInt($("#page").val())+1);
		$("#searchForm").submit();
	})
	//��ҳ��βҳ
	$(".wy").click(function(){
		$("#page").val($("#pageCount").val());
		$("#searchForm").submit();
	})

})

$.extend({
	//Ա������Ƿ����
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
				if(data.indexOf("����")!=-1){
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
	
	//�Ƿ�ѡ��Ա��ְ��
	positionSelected:function(){
		var flag = true;
		var position = $("#position").val();
		$("wokerPosition_prompt").html("");
		if(position=="-1"){
			$("#wokerPosition_prompt").html("��ѡ��Ա��ְ��");
			$("#wokerPosition_prompt").attr("class","prompt_error");
			flag = false;
		}
		return false;
	},
	
	//�Ƿ�������ְʱ��
	entryTime:function(){
		var flag = true;
		var entryTime = $("#entryTime").val();
		$("#wokerEntryTime_prompt").html("");
		if(entryTime==""){
			$("#wokerEntryTime_prompt").html("��������ְʱ��");
			$("#wokerEntryTime_prompt").attr("class","prompt_error");
			flag = false;
		}
		return flag;
	},
	
	//ѡ��ְ��
	selectedPosition:function(positionId,position){
   		for(var i = 0;i < position.length;i++){
   			if(positionId==position.eq(i).val()){
   				position.eq(i).attr("selected","selected");
   			}
   		}
	}
	
})
