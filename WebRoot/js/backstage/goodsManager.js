$(document).ready(function(){

	//���ݷ����ȡ��ʽ
	$("#category").change(function(){
		var categoryId = $("#category").val();
		var url = "../goodsManager/goodsManager_getStyle.action";
		$.get(url,{
			categoryId:categoryId
		},function(data){
			$("#style").html(data);
		})
	})
	
	//���ݿ�ʽ��ȡƷ��
	$("#style").change(function(){
		var styleId = $("#style").val();
		var url = "../goodsManager/goodsManager_getBrand.action";
		$.get(url,{
			styleId:styleId
		},function(data){
			$("#brand").html(data);
		})
	})
	
	//��������Ʒ
	$("#addGoodsForm").submit(function(){
		var goodsName = $("#goodsName");
		var goodsMarket = $("#goodsMarket");
		var goodsGrounding = $("#goodsGrounding");
		var storage = $("#storage");
		var goodsShjj = $("#goodsShjj");
		var goodsXmcz = $("#goodsXmcz");
		var goodsXdcz = $("#goodsXdcz");
		var goodsBhfs = $("#goodsBhfs");
		var goodsToecap = $("#goodsToecap");
		var goodsIsRecommend = $("#goodsIsRecommend");
		var goodsImage = $("#goodsImage");
		var goodsHeight = $("#goodsHeight");
		var goodsLength = $("#goodsLength");
		var goodsWeight = $("#goodsWeight");
		var goodsMarketPrice = $("#goodsMarketPrice");
		var goodsPaiPrice = $("#goodsPaiPrice");
		var goodsBid = $("#goodsBid");
		var category = $("#category");
		var style = $("#style");
		var brand = $("#brand");
		var error_prompt = $("#error_prompt");
		if(goodsName.val()==""){
			error_prompt.html("��Ʒ���Ʋ���Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsName.css("border","1px solid red");
			return false;
		}
	
		if(goodsMarket.val()==""){
			error_prompt.html("����ʱ�䲻��Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsMarket.css("border","1px solid red");
			return false;
		}
		if(goodsGrounding.val()==""){
			error_prompt.html("�ϼ�ʱ�䲻��Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsGrounding.css("border","1px solid red");
			return false;
		}
		if(storage.val()=="-1"){
			error_prompt.html("���ڲֿⲻ��Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			storage.css("border","1px solid red");
			return false;
		}	
		if(goodsShjj.val()=="-1"){
			error_prompt.html("�ʺϼ��ڲ���Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsShjj.css("border","1px solid red");
			return false;
		}
		if(goodsXmcz.val()==""){
			error_prompt.html("Ь����ʲ���Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsXmcz.css("border","1px solid red");
			return false;
		}
		if(goodsXdcz.val()==""){
			error_prompt.html("Ь�ײ��ʲ���Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsXdcz.css("border","1px solid red");
			return false;
		}
		if(goodsBhfs.val()=="-1"){
			error_prompt.html("�պϷ�ʽ����Ϊ��,��ѡ��....");
			error_prompt.attr("class","prompt_error");
			goodsBhfs.css("border","1px solid red");
			return false;
		}
		if(goodsToecap.val()==""){
			error_prompt.html("��ƷЬͷ����Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsToecap.css("border","1px solid red");
			return false;
		}
		if(goodsIsRecommend.val()=="-1"){
			error_prompt.html("�Ƿ��Ƽ�����Ϊ��,��ѡ��...");
			error_prompt.attr("class","prompt_error");
			goodsIsRecommend.css("border","1px solid red");
			return false;
		}
		if(goodsImage.val()==""){
			error_prompt.html("��ƷͼƬ����Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsImage.css("border","1px solid red");
			return false;
		}
		if(goodsHeight.val()==""){
			error_prompt.html("��Ʒ�߶Ȳ���Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsHeight.css("border","1px solid red");
			return false;
		}
		if(goodsLength.val()==""){
			error_prompt.html("��Ʒ���Ȳ���Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsLength.css("border","1px solid red");
			return false;
		}
		if(goodsWeight.val()==""){
			error_prompt.html("��Ʒ��������Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsWeight.css("border","1px solid red");
			return false;
		}
		if(goodsMarketPrice.val()==""){
			error_prompt.html("�г��۲���Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsMarketPrice.css("border","1px solid red");
			return false;
		}                      
		if(goodsPaiPrice.val()==""){
			error_prompt.html("���ļ۲���Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsPaiPrice.css("border","1px solid red");
			return false;
		}
		if(goodsBid.val()==""){
			error_prompt.html("���۲���Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			goodsBid.css("border","1px solid red");
			return false;
		}
		if(category.val()=="-1"){
			error_prompt.html("��Ʒ���಻��Ϊ��,��ѡ��...");
			error_prompt.attr("class","error_prompt");
			category.css("border","1px solid red");
			return false;
		}
		if(style.val()=="-1"){
			error_prompt.html("��Ʒ��ʽ����Ϊ��,��ѡ��...");
			error_prompt.attr("class","error_prompt");
			style.css("border","1px solid red");
			return false;
		}
		if(brand.val()=="-1"){
			error_prompt.html("��ƷƷ�Ʋ���Ϊ��,��ѡ��...");
			error_prompt.attr("class","error_prompt");
			brand.css("border","1px solid red");
			return false;
		}
		return true;
	})
	
	//��������Ʒ����
	$("#TJSPXQ").click(function(){
		var color = $("#color").val();
		var size = $("#size").val();
		var number = $("#number").val();
		var error_prompt = $("#error_prompt");
		error_prompt.html("");
		if(color=="-1"){
			error_prompt.html("��ѡ����Ʒ��ɫ...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		if(size=="-1"){
			error_prompt.html("��ѡ����Ʒ����...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		if(number==""){
			error_prompt.html("��Ʒ��������Ϊ��,������...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		var reg = /^\d+$/;
		if(reg.test(number)==false){
			error_prompt.html("��Ʒ������ʽ����,����������...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		var tr = $("<tr>" +                                                   
	           "<td align='center' width='40%'><input type='text' class='addInput' name='goodsColor.goodsColor' value='"+color+"' style='width:60%'></td>" +
	           "<td align='center'><input type='text' class='addInput' name='goodsSizeS.goodsSize' value='"+size+"'></td>" +
	           "<td align='center'><input type='text' class='addInput'  name='goodsSizeN.goodsNumber' value='"+number+"'></td>" +
	           "<td align='center'><a href='javascript:void(0);' onclick='this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)'>ɾ��</a></td></tr>");
	 	$("#goodsDetailTable").append(tr);
	})
	
	//���������Ʒ����
	$("#saveGoodsDetail").submit(function(){	
		var goodsImage = $("#goodsImage").val();
		var error_prompt = $("#error_prompt");
		error_prompt.html("");
		if(goodsImage==""){
			error_prompt.html("��ƷͼƬ����Ϊ��,��ѡ����ƷͼƬ...");
			error_prompt.attr("class","prompt_error");
			return false;
		}
		return true;
	})
})


