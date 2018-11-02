$(document).ready(function(){
	var flag = true;        //定义全局变量
	
	//品牌名称
	$("#brandName").focus(function(){
			var brandName_prompt = $("#brandName_prompt");
			brandName_prompt.html("品牌名称数字、字母、汉字组成....");
			brandName_prompt.attr("class","prompt_tips");
		}	
	)
	
	$("#brandName").blur(function(){
			var brandName = $(this).val();
			var brandName_prompt = $("#brandName_prompt");
			brandName_prompt.html("");
			if(brandName==""){
				brandName_prompt.html("品牌名称不能为空,请重新输入...");
				brandName_prompt.attr("class","prompt_error");
				flag = false;
				return;
			}
			var type = $("#type").val();
			if(type=="add"){
				if(!$.brandIsExist(brandName,"name")){
					flag = false;
					return;
				}
			}
			if(type=="update"){
				var name1 = $("#name1").val();
				var name2 = brandName;
				if(name1!=name2){
					if(!$.brandIsExist(brandName,"name")){
						flag = false;
						return;
					}
				}
			}
			flag = true;
		}	
	)
	
	//品牌拼音
	$("#brandSpell").focus(function(){
			var brandSpell_prompt = $("#brandSpell_prompt");
			brandSpell_prompt.html("品牌拼写数字,字母组成,最少三位....");
			brandSpell_prompt.attr("class","prompt_tips");
		}
	)
	
	$("#brandSpell").blur(function(){
			var brandSpell = $("#brandSpell").val();
			var brandSpell_prompt = $("#brandSpell_prompt");
			brandSpell_prompt.html("");
			var reg = /^[-\w]*$/;
			if(brandSpell==""){
				brandSpell_prompt.html("品牌拼写不能为空,请重新输入...");
				brandSpell_prompt.attr("class","prompt_error");
				flag = false;
				return ;
			}
			if(reg.test(brandSpell)==false){
				brandSpell_prompt.html("品牌拼写格式错误,请重新输入...");
				brandSpell_prompt.attr("class","prompt_error");
				flag = false;
				return;
			}
			
			var type = $("#type").val();
			if(type=="add"){
				if(!$.brandIsExist(brandSpell,"spell")){
					flag = false;
					return;
				}
			}
			if(type=="update"){
				var name3 = $("#name3").val();
				var name4 = brandSpell;
				if(name3!=name4){
					if(!$.brandIsExist(brandSpell,"spell")){
						flag = false;
						return;
					}
				}
			}
			
			flag = true;
		}
	)
	
	//点击款式
	$("input[type='checkbox']").click(
		function(){
			var _thisV = $(this).val();
			var _styleV = $("#style");
			_styleV.val("");
			var _style = $("input[type='checkbox']");
			for(var i = 0;i<_style.length;i++){
				var _thisStyle = _style.eq(i);
				if(_thisStyle.is(":checked")){
					if(_styleV.val()==null||_styleV.val()==""){
						_styleV.val(_thisStyle.val());
					}
					else{
						_styleV.val(_styleV.val()+","+_thisStyle.val());
					}
				}
			}
		}
	)
	
	$(".zjbjBrand").dialog(
  	{
  		bgiframe: true,
   		resizable: true,
    	width:750,
    	height:525,
  		modal: true,
  		position:[250,0],
      	autoOpen: false,
      	title: "Dialog Title", 
    })
    
    //编辑
    $(".bjBrand").click(
    	function(){
    		var _tr = $(this).parent().parent().children();
    		var brandId = $.trim(_tr.eq(0).text());
    		var brandName = $.trim(_tr.eq(1).text());
    		var brandSpell=  $.trim(_tr.eq(2).text());
    		var brandStyle =  $.trim(_tr.eq(3).text());
    		var brandImage = $.trim(_tr.eq(4).children().attr("src"));
    		
    		$("#brandId").val(brandId);
    		$("#brandName").val(brandName);
    		$("#brandSpell").val(brandSpell);
    		$("#brandStyle").val(brandStyle);
    		$("#image").attr("src",brandImage);
    		$("#style").val(brandStyle);
    		$("#name1").val(brandName);
    		$("#name3").val(brandSpell);
    		//设置style选择
    		var styles = brandStyle.split(",");
    		var styleS = $(".allStyle");
    		styleS.attr("checked",null);
    		for(var i = 0;i < styles.length;i++){
    			for(var j = 0;j < styleS.length;j++){
    				if($.trim(styleS.eq(j).val())==$.trim(styles[i])){
    					styleS.eq(j).attr("checked",'checked');
    					break;
    				}
    			}
    		}
    		$("#type").val("update");
    		$("#zjbjBtn").attr("src","../images/backstage/okUpdate.jpg");
    		$(".zjbjBrand").dialog("option","title", "编辑商品品牌")
							  .dialog("open");
    	}	
    )
	
	//点击添加品牌
    $("#addBrandBtn").click(function(){
    	$("#brandName").val("");
    	$("#brandSpell").val("");
    	$("#brandStyle").val("");
    	$("#image").attr("src","");
    	$("#style").val("");
    	$(".allStyle").attr("checked",null);
    	//获取编号
    	var url = "../goodsManager/brandManager_getBrandId.action"
    	$.ajax({
    		url : url,
    		type:'GET',
			dataType:'text',
			success:function(data){
    			$("#brandId").val(data);
    			$("#type").val("add");
    			$("#zjbjBtn").attr("src","../images/backstage/okAdd.jpg");
    			$(".zjbjBrand").dialog("option","title", "增加商品品牌")
							  .dialog("open");
			}
    	})
    })
    
    //点击确认
    $("#zjbjBtn").click(function(){
    	$("#brandName").blur();
    	$("#brandSpell").blur();
    	var flag1 = $.styleIsSelected();
    	var flag2 = $.imageIsSelected();
    	if(!flag||!flag1||!flag2){
    		return false;
    	}
    	else{
    		$("#brandForm").attr("action","../goodsManager/brandManager_saveOrUpdateBrand.action");
    		$("#brandForm").submit();
    	}
    })
    
    //点击删除
    $(".scBrand").click(function(){
    	var brandId = $.trim($(this).parent().parent().children().eq(0).text());
    	var page = $("#page").val();
    	location.href = "../goodsManager/brandManager_deleteBrand.action?brandId="+brandId+"&page="+page;
    })
})

$.extend({
	brandIsExist:function(brand,types){
		var isRep;
		$.ajax({
			type : "GET",
			async : false,
			url : "../goodsManager/brandManager_brandIsExit.action",
			data : "brandName="+brand+"&brandType="+types,
			dataType : "text",
			success: function(data){
				if(types=="name"){
					$("#brandName_prompt").html(data);
				}
				if(types=="spell"){
					$("#brandSpell_prompt").html(data);
				}
				
				if(data.indexOf("已经存在")!=-1){
					if(types=="name"){
						$("#brandName_prompt").attr("class","prompt_error");
					}
					if(types=="spell"){
						$("#brandSpell_prompt").attr("class","prompt_error");
					}
					
					isRep = false;
				}
				else{
					if(types=="name"){
						$("#brandName_prompt").attr("class","prompt_tips");
					}
					if(types=="spell"){
						$("#brandSpell_prompt").attr("class","prompt_tips");
					}
					isRep = true;
				}
			}
		})
		return isRep;
	},
	
	//判断是否选择了款式
	styleIsSelected:function(){
		var style = $("#style").val();
		var style_prompt = $("#style_prompt");
		style_prompt.html("");
		if(style==""){
			style_prompt.html("请选择品牌所拥有的款式...")
			style_prompt.attr("class","prompt_error");
		}
		return true;	
	},
	
	//判断是否选择了图片
	imageIsSelected:function(){
		var image = $("#image").attr("src");
		var file = $("#brandImage").val();
		var brandImage_prompt = $("#brandImage_prompt"); 
		brandImage_prompt.html("");
		if((image==null||image=="")&&(file==""||file==null)){
			brandImage_prompt.html("品牌图片不能为空,请选择图片...");
			brandImage_prompt.attr("class","prompt_error");
			return false;
		}
		return true;
	}

})

