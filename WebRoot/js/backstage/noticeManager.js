$(document).ready(function(){
	//ѡ�񹫸����
	var _type = $("#_type").val();
	if(_type!=""){
		var noticeType = $("#noticeType").children();
		for(var i = 0;i < noticeType.length;i++){
			var _typeVal = noticeType.eq(i).val();
			if(_type==_typeVal){
				noticeType.eq(i).attr("selected","selected");
			}
		}
	}
	
	//���ɾ��
	$(".scNotice").click(function(){
		var noticeId = $(this).parent().children().eq(0).val();
		var page = $("#page").val();
		location.href = "../systemManager/noticeManager_deleteNotice.action?noticeId="+noticeId+"&page="+page;
	})
	//����༭
	$(".bjNotice").click(function(){
		var noticeId = $(this).parent().children().eq(0).val();
		var page = $("#page").val();
		location.href = "../systemManager/noticeManager_upodateNoticeUI.action?noticeId="+noticeId+"&page="+page;
	})

	//����鿴
	$(".ckNotice").click(function(){
		var noticeId = $(this).parent().children().eq(0).val();
		location.href = "../systemManager/noticeManager_showNotice.action?noticeId="+noticeId;
	})
	
	//�������
	$("#addNoticeBtn").click(function(){
		location.href = "../systemManager/noticeManager_addNoticeUI.action";
	})
	
	//�����������
	$("#noticeForm").submit(function(){
		var noticeTitle = $.trim($("#noticeTitle").val());
		var noticeContent = CKEDITOR.instances.noticeContent.getData();
		var noticeType = $("#noticeType").val();
		var noticePrompt = $("#noticePrompt");
		noticePrompt.html("");
		if(noticeTitle==""){
			noticePrompt.html("�����빫������..");
			noticePrompt.attr("class","prompt_error");
			return false;
		}
		
		else if(noticeContent==""){
			noticePrompt.html("�����빫������..");
			noticePrompt.attr("class","prompt_error");
			return false;
		}
		
		else if(noticeType=="-1"){
			noticePrompt.html("�����빫�����..");
			noticePrompt.attr("class","prompt_error");
			return false;
		}
		else{
			return true;
		}
	})
})