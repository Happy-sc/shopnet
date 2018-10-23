$(document).ready(function(){
	var flag = true;
	$(".zjbjStyle").dialog({
  		bgiframe: true,
   		resizable: true,
    	width:750,
    	height:525,
  		modal: true,
      	autoOpen: false,
      	position:[250,0],
      	title: "Dialog Title", 
    })
	
	//�����ӿ�ʽ��ť
	$("#addStyleBtn").click(function(){
		//���ֵ
		$("#styleId").val("");
		$("#styleName").val("");
		$("#category").children().eq(0).attr("selected","selected");
		$("#brand").val("");
		$(".styleBrands").attr("checked",null);
		
		var url = "../goodsManager/styleManager_getStyleId.action";
		$.ajax({
			url : url,
			type:'GET',
			dataType:'text',
			success:function(data){
				$("#styleId").val(data);
				$("#type").val("add");
				$("#qrzjbj").attr("src","../images/backstage/okAdd.jpg");
				$(".zjbjStyle").dialog("option","title", "������Ʒ��ʽ").dialog("open");
			}
		})
	})
	
	//��ʽ����
	$("#styleName").focus(
		function(){
			var styleName_prompt = $("#styleName_prompt");
			styleName_prompt.html("��ʽ����������ĸ,�������,����2λ...");
			styleName_prompt.attr("class","prompt_tips");
		}	
	)
	
	$("#styleName").blur(
		function(){
			var styleName = $("#styleName").val();
			var styleName_prompt = $("#styleName_prompt");
			var reg = /^\D{2,}$/;
			styleName_prompt.html("");
			if(styleName==""){
				styleName_prompt.html("��ʽ���Ʋ���Ϊ��,������...");
				styleName_prompt.attr("class","prompt_error");
				flag = false;
				return;
			}
			if(reg.test(styleName)==false){
				styleName_prompt.html("��ʽ���Ƹ�ʽ����,����������...");
				styleName_prompt.attr("class","prompt_error");
				flag = false;
				return;
			}
			
			var _type = $("#type").val();
			if(_type=="add"){
				if($.styleNameRep(styleName)){
					flag = false;
					return;
				}
			}
			if(_type=="update"){
				var name1 = $("#thisName").val();
				var name2 = styleName;
				if(name1!=name2){
					if($.styleNameRep(styleName)){
						flag = false;
						return;
					}
				}
					
			}
			
			flag = true;
		}	
	)
	
	
	
	//���ȷ�����ӻ���ȷ���޸�
	$("#qrzjbj").click(function(){
		
		var flag1 = $.isSelectCategory();
		var flag2 = $.isSelectBrand();
		if(!flag||!flag1||!flag2){
			return;
		}	
		else{
			$("#styleForm").attr("action","../goodsManager/styleManager_saveOrUpdateStyle.action");
			$("#styleForm").submit();
		}
	})
	
	
	
	//���Ʒ��
	$("input[type='checkbox']").click(
		function(){
			var _thisV = $(this).val();
			var brandV = $("#brand");
			brandV.val("");
			var _brand = $("input[type='checkbox']");
			for(var i = 0;i < _brand.length;i++){
				var _thisBrand = _brand.eq(i);
				if(_thisBrand.is(":checked")){
					if(brandV.val()==null||""==brandV.val()){
						brandV.val(_thisBrand.val());
					}
					else{
						brandV.val(brandV.val()+","+_thisBrand.val());
					}
				}
			}
		}	
	)
	
	//���ɾ��
	$(".scStyle").click(function(){
		var _id = $(this).parent().parent().children().eq(0).text();
		var page = $("#page").val();
		location.href = "../goodsManager/styleManager_deleteStyle.action?styleId="+$.trim(_id)+"&page="+page;
	})
	
	//����༭
	$(".bjStyle").click(function(){
		var _td = $(this).parent().parent().children();
		var _id = $.trim(_td.eq(0).text());
		var _name = $.trim(_td.eq(1).text());
		var _category = $.trim(_td.eq(2).text());
		var _brand = $.trim(_td.eq(3).text());
		
		//��ֵ
		$("#styleId").val(_id);
		$("#styleName").val(_name);
		
		//ѡ��category��ֵ
		var categorys = $("#category").children();
		for(var i = 1;i < categorys.length;i++){
			var category = $.trim(categorys.eq(i).text());
			if(_category==category){
				categorys.eq(i).attr("selected","selected");
				break;
			}	
		}
		
		//ѡ��Ʒ��
		$("#brand").val(_brand);
		var brands = $(".styleBrands");
		var _brands = _brand.split(",");
		brands.attr("checked",null);
		for(var i = 0;i < _brands.length;i++){
			var tBrand = $.trim(_brands[i]);
			for(var j = 0;j < brands.length;j++){
				var cBrand = $.trim(brands.eq(j).val());
				if(tBrand==cBrand){
					brands.eq(j).attr("checked","checked");
					break;
				}		
			}
		}
		$("#type").val("update");
		$("#thisName").val(_name);
		$("#qrzjbj").attr("src","../images/backstage/okUpdate.jpg");
		$(".zjbjStyle").dialog("option","title", "�༭��Ʒ��ʽ").dialog("open")
	})
	

})

$.extend({
	//�жϷ������Ƿ��ظ�
	styleNameRep:function(styleName){
		var isRep;
		var url = "../goodsManager/styleManager_styleNameRep.action";
		$.ajax({
			url : url,
			type: "POST",
			async:false,
			data : "styleName="+styleName,
			dataType:'json',
			success:function(msg){
				$("#styleName_prompt").html(msg.content);
				if(msg.content.indexOf("�Ѿ�����")!=-1){
					$("#styleName_prompt").attr("class","prompt_error");
					isRep = true;
				}
				else{
					$("#styleName_prompt").attr("class","prompt_tips");
					isRep = false;
				}
			}
		})
		return isRep;
	},

	//�ж��Ƿ�ѡ���˷���
	isSelectCategory:function(){
		var category = $("#category").val();
		var category_prompt = $("#category_prompt");
		category_prompt.html("");
		if(category==-1){
			category_prompt.html("��ѡ���ʽ����������...");
			category_prompt.attr("class","prompt_error");
			return false;
		}
		return true;
	},
	
	//�ж��Ƿ�ѡ���Ʒ��
	isSelectBrand:function(){
		$("#brand__prompt").html("");
		var brand = $("#brand").val();
		if(brand==null||brand==""){
			$("#brand__prompt").html("��ѡ��Ʒ��...");
			$("#brand__prompt").attr("class","prompt_error");
			return false;
		}
		return true;
	}
})
