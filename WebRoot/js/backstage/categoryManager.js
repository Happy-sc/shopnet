$(document).ready(function(){
	var flag = true;        //ȫ�ֱ���
	
	$(".addbjDiv").dialog({
  		bgiframe: true,
   		resizable: true,
    	width:650,
  		modal: true,
      	autoOpen: false,
      	position:[260,120],
      	title: "Dialog Title", 
    })
	
	//�����ӷ���
	$("#addCategotyBtn").click(function(){
		//�������ֵ���
		$("#categoryName").val();
		var url = "../goodsManager/categoryManager_getCategoryId.action";
		$.ajax({
			url:url,
			type:'GET',
			dataType:'text',
			success:function(data){
				$("#categoryId").val(data);
				$("#quzjxg").attr("src","../images/backstage/okAdd.jpg");
				$("#categoryType").attr("class","add");
				$("#type").val("add");
				$(".addbjDiv").dialog("option","title", "������Ʒ����")
							  .dialog("open");
			}
		})
	})
	
	//������뿪��������ʱ
	$("#categoryName").blur(function(){
		var categoryName = $.trim($(this).val());
		var categoryPrompt = $("#categoryName_prompt");
		if(categoryName==""||categoryName==null){
			categoryPrompt.html("�������Ʋ���Ϊ��...");
			categoryPrompt.attr("class","prompt_error");
			flag = false;
			return;
		}
		//ֻ�����ӻ����޸�ʱ�����ֵ�ı��˲Ż���֤
		var _type = $("#type").val();
		if(_type=="update"){
			var _name1 = $.trim($("#thisName").val());
			var _name2 = $.trim($("#categoryName").val());
			if(_name1!=_name2){
				if($.categoryNameRep(categoryName)){
					flag = false;
					return;
				}
			}
		}
		if(_type=="add"){
			if($.categoryNameRep(categoryName)){
				flag = false;
				return;
			}
		}
		flag = true;
	})
	
	//���ȷ��
	$("#categoryFrom").submit(function(){
			$("#categoryName").blur();
			if(!flag){
				return false;
			}	
			else{
				$("#categoryFrom").attr("action","../goodsManager/categoryManager_saveOrUpdateCategory.action");
				return true;
			}
	})
		
	//���ɾ��
	$(".sccategory").click(function(){
		var _tr = $(this).parent().parent().children();
		var _id = $.trim(_tr.eq(0).text());
		location.href = "../goodsManager/categoryManager_deleteCategory.action?categoryId="+_id;
	})
	
	//����༭
	$(".bjcategory").click(function(){
		var _tr = $(this).parent().parent().children();
		var id = $.trim(_tr.eq(0).text());
		var name = $.trim(_tr.eq(1).text());
		$("#categoryId").val(id);
		$("#categoryName").val(name);
		$("#type").val("update");
		$("#thisName").val(name);
		$("#quzjxg").attr("src","../images/backstage/okUpdate.jpg");
		$("#categoryType").attr("class","update");
		$(".addbjDiv").dialog("option","title", "�޸���Ʒ����")
							  .dialog("open");
	})
})

//������������
$.extend({
	//�жϷ������Ƿ��ظ�
	categoryNameRep:function(categoryName){
		var isRep;
		var url = "../goodsManager/categoryManager_categoryNameRep.action";
		$.ajax({
			url : url,
			type: "POST",
			async:false,
			data : "categoryName="+categoryName,
			dataType:'json',
			success:function(data){
				var msg = data.flag;
				$("#categoryName_prompt").html(msg);
				if(msg.indexOf("�Ѿ�����")!=-1){
					$("#categoryName_prompt").attr("class","prompt_error");
					isRep = true;
				}
				else{
					$("#categoryName_prompt").attr("class","prompt_tips");
					isRep = false;
				}
			}
		})
		return isRep;
	}
})