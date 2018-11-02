$(document).ready(function(){
	//确定当前tab
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
	
	//放在tab上面
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
	
	//点击tab
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
	
	//点击确认收货
	$(".qrsh").click(function(){
		if(confirm("你确认收货吗?在没有收到货物之前,不要确认收货，否则你会赔了夫人又折兵..")){
			var odId = $(this).parent().find("#qrshODId").val();
			var oId = $(this).parent().find("#qrshOId").val();
			location.href = "../userCenter/order_qrsh.action?orderId="+oId+"&orderDetailId="+odId;
		}
	})
}) 