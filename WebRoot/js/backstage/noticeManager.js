$(document).ready(function(){
	//选择公告类别
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
	
	//点击删除
	$(".scNotice").click(function(){
		var noticeId = $(this).parent().children().eq(0).val();
		var page = $("#page").val();
		location.href = "../systemManager/noticeManager_deleteNotice.action?noticeId="+noticeId+"&page="+page;
	})
	//点击编辑
	$(".bjNotice").click(function(){
		var noticeId = $(this).parent().children().eq(0).val();
		var page = $("#page").val();
		location.href = "../systemManager/noticeManager_upodateNoticeUI.action?noticeId="+noticeId+"&page="+page;
	})

	//点击查看
	$(".ckNotice").click(function(){
		var noticeId = $(this).parent().children().eq(0).val();
		location.href = "../systemManager/noticeManager_showNotice.action?noticeId="+noticeId;
	})
	
	//点击增加
	$("#addNoticeBtn").click(function(){
		location.href = "../systemManager/noticeManager_addNoticeUI.action";
	})
	
	//点击发布公告
	$("#noticeForm").submit(function(){
		var noticeTitle = $.trim($("#noticeTitle").val());
		var noticeContent = CKEDITOR.instances.noticeContent.getData();
		var noticeType = $("#noticeType").val();
		var noticePrompt = $("#noticePrompt");
		noticePrompt.html("");
		if(noticeTitle==""){
			noticePrompt.html("请输入公告主题..");
			noticePrompt.attr("class","prompt_error");
			return false;
		}
		
		else if(noticeContent==""){
			noticePrompt.html("请输入公告内容..");
			noticePrompt.attr("class","prompt_error");
			return false;
		}
		
		else if(noticeType=="-1"){
			noticePrompt.html("请输入公告类别..");
			noticePrompt.attr("class","prompt_error");
			return false;
		}
		else{
			return true;
		}
	})
})