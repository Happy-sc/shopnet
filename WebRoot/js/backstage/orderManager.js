$(document).ready(function(){
	//����鿴����
	$(".ckOrder").click(function(){
		var orderId = $(this).parent().children().eq(0).val();
		location.href = "../orderManager/orderManager_showOrderDetail.action?orderId="+orderId;
	})
	
	//����:�鿴
	$(".fhckOrder").click(function(){
		var orderId = $(this).parent().children().eq(0).val();
		location.href = "../orderManager/orderManager_showOrderDetail.action?orderId="+orderId+"&type=ckfh"
	})
	
	//�������
	$(".fhOrder").click(function(){
		var orderId = $(this).parent().children().eq(0).val();
		location.href = "../orderManager/orderManager_showOrderDetail.action?orderId="+orderId+"&type=qrfh";
	})
	
	//���ȷ�Ϸ���������(������Ϣ)
	$(".qrfhA").click(function(){
		var orderId = $("#fhOrderId").val();
		location.href = "../orderManager/orderManager_fhOrder.action?orderId="+orderId;
	})
	
})