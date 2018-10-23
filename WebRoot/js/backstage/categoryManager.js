$(document).ready(function(){
	var flag = true;        //全局变量
	
	$(".addbjDiv").dialog({
  		bgiframe: true,
   		resizable: true,
    	width:650,
  		modal: true,
      	autoOpen: false,
      	position:[260,120],
      	title: "Dialog Title", 
    })
	
	//点击添加分类
	$("#addCategotyBtn").click(function(){
		//表单里面的值清空
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
				$(".addbjDiv").dialog("option","title", "增加商品分类")
							  .dialog("open");
			}
		})
	})
	
	//当鼠标离开分类名称时
	$("#categoryName").blur(function(){
		var categoryName = $.trim($(this).val());
		var categoryPrompt = $("#categoryName_prompt");
		if(categoryName==""||categoryName==null){
			categoryPrompt.html("分类名称不能为空...");
			categoryPrompt.attr("class","prompt_error");
			flag = false;
			return;
		}
		//只有增加或者修改时里面的值改变了才会验证
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
	
	//点击确定
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
		
	//点击删除
	$(".sccategory").click(function(){
		var _tr = $(this).parent().parent().children();
		var _id = $.trim(_tr.eq(0).text());
		location.href = "../goodsManager/categoryManager_deleteCategory.action?categoryId="+_id;
	})
	
	//点击编辑
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
		$(".addbjDiv").dialog("option","title", "修改商品分类")
							  .dialog("open");
	})
})

//定义匿名函数
$.extend({
	//判断分类名是否重复
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
				if(msg.indexOf("已经存在")!=-1){
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