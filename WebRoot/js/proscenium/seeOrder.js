$(document).ready(function(){
	//ȷ����ǰtab
	var type = $("#orderType").val()
	if("all"==type){
		$("#tab1").attr("class","now");
		$(".order_content .content .kongbai").css("left","339px");
		$(".content_dsh").hide();
		$(".content_syhsfk").show();
		
	}
	if("dfk"==type){
		$("#tab2").attr("class","now");
		$(".order_content .content .kongbai").css("left","436px");
		$(".content_dsh").hide();
		$(".content_syhsfk").show();
	}
	if("dsh"==type){
		$("#tab3").attr("class","now");
		$(".order_content .content .kongbai").css("left","533px");
		$(".content_dsh").show();
		$(".content_syhsfk").hide();
	}
	
	//����tab����
	$(".order_content .title li").hover(
		function(){
			var _class = $(this).attr("class");
			if(_class!="now"){
				$(this).css("color","#CC0000");
			}
		},
		function(){
			var _class = $(this).attr("class");
			if(_class!="now"){
				$(this).css("color","#797979");
			}
		}
	)
	
	//���tab
	$(".order_content .title li").click(function(){
			var _id = $(this).attr("id");
			if(_id=="tab1"){
				window.location.href = "../userCenter/order_seeOrder.action?type=all&page=1";
			}
			if(_id=="tab2"){
				window.location.href = "../userCenter/order_seeOrder.action?type=dfk&page=1";
			}
			if(_id=="tab3"){
				window.location.href = "../userCenter/order_seeOrder.action?type=dsh&page=1";
			}
		}	
	)
	
	//���ȷ���ջ�
	$(".qrsh").click(function(){
		if(confirm("��ȷ���ջ���?��û���յ�����֮ǰ,��Ҫȷ���ջ�������������˷������۱�..")){
			var odId = $(this).parent().find("#qrshODId").val();
			var oId = $(this).parent().find("#qrshOId").val();
			location.href = "../userCenter/order_qrsh.action?orderId="+oId+"&orderDetailId="+odId;
		}
	})
}) 