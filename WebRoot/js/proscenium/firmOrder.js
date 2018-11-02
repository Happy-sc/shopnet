$(document).ready(function(){
	//判断是否使用地址
	var i = $(".ps_address .content input[id='isAdd']").val();
	if(i=="0"){
		$(".addAddress").show();
		//加载城市
		$(".city").ProvinceCity();
		//设置其他CSS
		$(".ps_address .content .title").css("background-color","red");
	}
	else{
		$(".ps_address .content .oldAddress").show();
	}	
	
	//放在新增地址上
	$(".ps_address .content .newAddress img").hover(
		function(){
			$(this).attr("src","../images/proscenium/userNewAddress_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/userNewAddress_01.jpg");
		}
	)
	
	//点击使用新地址
	$(".ps_address .content .newAddress img").click(
		function(){
			$(".ps_address .content .oldAddress").hide();
			$(".addAddress").show();
			$(".city").ProvinceCity();
		}	
	)
	
	//当放入订单补充中
	$(".car_submit textarea").focus(
		function(){
			$(this).attr("class","ddbc_1");
			$(this).val("");
		}	
	)
	
	$(".car_submit textarea").blur(
		function(){
			var _ddbc = $(this).val();
			if(_ddbc==""){
				$(this).attr("class","ddbc");
				$(this).val("选填,可以告诉我们您对订单的特殊要求");
			}
		}
	)
	
	//放在提交订单按钮上
	$(".car_submit .submit .btn img").hover(
		function(){
			$(this).attr("src","../images/proscenium/submitOrder_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/submitOrder_01.jpg");
		}
	)
	
	//点击提交订单按钮
	$(".car_submit .submit .btn img").click(
		function(){
			$(".ps_pay .title .paytype").html("");
			$(".qr_address").html("");
			var payType = $(".ps_pay .content #payStyle:checked").val();
			if(payType==""||payType==null){
				$(".ps_pay .title .paytype").html("请选择支付方式");
				var ptDiv = $(".ps_pay").offset().top;
				$("html,body").animate({ scrollTop:ptDiv},1000); 
				return false;
			}
			var address = $(".oldAddress .address li[class='detailAddress']").text();
			if(address==""||address==null){
				$(".qr_address").html("请确认收货地址");
				var qrA = $(".payStyle").offset().top;
				$("html,body").animate({ scrollTop:qrA},1000); 
				return false;
			}
			//设置值
			var postCode = $(".oldAddress .address li[class='postCode']").text();
			var consignee = $(".oldAddress .address li[class='consignee']").text();
			var phone = $(".oldAddress .address li[class='phone']").text();
			var sumS = $("font[class='sfk']").text();
			var sum = sumS.substring(1,sumS.length);
			var freightS = $("font[class='yf']").text();
			var freight = freightS.substring(1,freightS.length);
			var userRequire = $("textarea").val();
			var sypxb = $(".sypxb").val();
			
			$(".orderActoin input[id='addressDetail']").val(address);
			$(".orderActoin input[id='phone']").val(phone);
			$(".orderActoin input[id='consignee']").val(consignee);
			$(".orderActoin input[id='postalcode']").val(postCode);
			$(".orderActoin input[id='payment']").val(payType);
			$(".orderActoin input[id='sum']").val(sum);
			$(".orderActoin input[id='freight']").val(freight);
			$(".orderActoin input[id='userRequire']").val(userRequire);
			$(".orderActoin input[id='sypxb']").val(sypxb);
			$("#orderForm").submit();
		}	
	)
	
	
	//使用拍鞋币
	$(".sypxb").focus(
		function(){
			var sumS = $("font[class='sfk']").text();
			var sum = sumS.substring(1,sumS.length); 
			var _value = $(this).val();
			$("font[class='sfk']").html("&yen;"+String(Number(sum)+Number(_value)));
			$(this).val("");
		}	
	)
	
	$(".sypxb").blur(
		function(){
			var paixieBNum = $(this).val();
			var url = "../goods/paixieB_getPaixieB.action";
			$.post(
				url,
				{
					paixieBNum:paixieBNum
				},
				function(data){
					var sumS = $("font[class='sfk']").text();
					var sum = sumS.substring(1,sumS.length); 
					
					if(data.indexOf("仅有")!=-1){
						var datas = data.split(",");
						$(".jsypxb").html(datas[0]);
						$(".jsypxb").css("color","red");
						$(".sypxb").val(datas[1]);
						$("font[class='sfk']").html("&yen;"+String(Number(sum)-Number(datas[1])));
					}
					else{
						$(".jsypxb").html("你使用了"+paixieBNum+"个拍鞋币");
						$("font[class='sfk']").html("&yen;"+String(Number(sum)-Number(paixieBNum)));
					}
				}
			)
			
		}	
	)
	
})
