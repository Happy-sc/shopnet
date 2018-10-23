$(document).ready(function(){
	//点击查看订单
	$(".ckOrder").click(function(){
		var orderId = $(this).parent().children().eq(0).val();
		location.href = "../orderManager/orderManager_showOrderDetail.action?orderId="+orderId;
	})
	
	//发货:查看
	$(".fhckOrder").click(function(){
		var orderId = $(this).parent().children().eq(0).val();
		location.href = "../orderManager/orderManager_showOrderDetail.action?orderId="+orderId+"&type=ckfh"
	})
	
	//点击发货
	$(".fhOrder").click(function(){
		var orderId = $(this).parent().children().eq(0).val();
		location.href = "../orderManager/orderManager_showOrderDetail.action?orderId="+orderId+"&type=qrfh";
	})
	
	//点击确认发货、返货(订单消息)
	$(".qrfhA").click(function(){
		var orderId = $("#fhOrderId").val();
		location.href = "../orderManager/orderManager_fhOrder.action?orderId="+orderId;
	})
	
})