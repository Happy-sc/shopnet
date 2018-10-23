$(document).ready(function(){
	var flag = true;        //����ȫ�ֱ���
	
	//Ʒ������
	$("#brandName").focus(function(){
			var brandName_prompt = $("#brandName_prompt");
			brandName_prompt.html("Ʒ���������֡���ĸ���������....");
			brandName_prompt.attr("class","prompt_tips");
		}	
	)
	
	$("#brandName").blur(function(){
			var brandName = $(this).val();
			var brandName_prompt = $("#brandName_prompt");
			brandName_prompt.html("");
			if(brandName==""){
				brandName_prompt.html("Ʒ�����Ʋ���Ϊ��,����������...");
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
	
	//Ʒ��ƴ��
	$("#brandSpell").focus(function(){
			var brandSpell_prompt = $("#brandSpell_prompt");
			brandSpell_prompt.html("Ʒ��ƴд����,��ĸ���,������λ....");
			brandSpell_prompt.attr("class","prompt_tips");
		}
	)
	
	$("#brandSpell").blur(function(){
			var brandSpell = $("#brandSpell").val();
			var brandSpell_prompt = $("#brandSpell_prompt");
			brandSpell_prompt.html("");
			var reg = /^[-\w]*$/;
			if(brandSpell==""){
				brandSpell_prompt.html("Ʒ��ƴд����Ϊ��,����������...");
				brandSpell_prompt.attr("class","prompt_error");
				flag = false;
				return ;
			}
			if(reg.test(brandSpell)==false){
				brandSpell_prompt.html("Ʒ��ƴд��ʽ����,����������...");
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
	
	//�����ʽ
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
    
    //�༭
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
    		//����styleѡ��
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
    		$(".zjbjBrand").dialog("option","title", "�༭��ƷƷ��")
							  .dialog("open");
    	}	
    )
	
	//������Ʒ��
    $("#addBrandBtn").click(function(){
    	$("#brandName").val("");
    	$("#brandSpell").val("");
    	$("#brandStyle").val("");
    	$("#image").attr("src","");
    	$("#style").val("");
    	$(".allStyle").attr("checked",null);
    	//��ȡ���
    	var url = "../goodsManager/brandManager_getBrandId.action"
    	$.ajax({
    		url : url,
    		type:'GET',
			dataType:'text',
			success:function(data){
    			$("#brandId").val(data);
    			$("#type").val("add");
    			$("#zjbjBtn").attr("src","../images/backstage/okAdd.jpg");
    			$(".zjbjBrand").dialog("option","title", "������ƷƷ��")
							  .dialog("open");
			}
    	})
    })
    
    //���ȷ��
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
    
    //���ɾ��
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
				
				if(data.indexOf("�Ѿ�����")!=-1){
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
	
	//�ж��Ƿ�ѡ���˿�ʽ
	styleIsSelected:function(){
		var style = $("#style").val();
		var style_prompt = $("#style_prompt");
		style_prompt.html("");
		if(style==""){
			style_prompt.html("��ѡ��Ʒ����ӵ�еĿ�ʽ...")
			style_prompt.attr("class","prompt_error");
			return false;
		}
		return true;	
	},
	
	//�ж��Ƿ�ѡ����ͼƬ
	imageIsSelected:function(){
		var image = $("#image").attr("src");
		var file = $("#brandImage").val();
		var brandImage_prompt = $("#brandImage_prompt"); 
		brandImage_prompt.html("");
		if((image==null||image=="")&&(file==""||file==null)){
			brandImage_prompt.html("Ʒ��ͼƬ����Ϊ��,��ѡ��ͼƬ...");
			brandImage_prompt.attr("class","prompt_error");
			return false;
		}
		return true;
	}

})

