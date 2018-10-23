$(document).ready(function(){
	var flag;  //定义全局变量
	
	//收货人
	$("#consignee").blur(
		function(){
			var consignee = $("#consignee").val();
			if(consignee==""||consignee==null){
				$(".consignee_prompt").html("请输入收件人姓名...");
				$(".consignee_prompt").css("color","red");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			$(this).css("border","1px solid #CECECE");
			flag = true;
			return true;
		}	
	)
	$("#consignee").focus(
		function(){
			$(".consignee_prompt").html("");
		}	
	)
	
	//所在城市
	$(".newAddress select").change(
		function(){
			$.city();
		}	
	)
	
	//所在街道
	$("#street").blur(
		function(){
			var street = $("#street").val();
			var street_prompt = $(".street_prompt");
			street_prompt.html("");
			if(street==""||street==null){
				street_prompt.html("请输入街道...");
				street_prompt.css("color","red");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			flag = true;
			$(this).css("border","1px solid #CECECE");
			return true;
		}
	)
	$("#stree").focus(
		function(){
			$("#street_prompt").html("");
		}	
	)
	
	//电话号码
	$("#telephone").blur(
		function(){
			var phone = $("#telephone").val();
			var phone_prompt = $(".phone_prompt");
			var reg = /^((\d{3,4}-)?\d{7,8})$|(1[0-9]{10})/;
			if(phone==""||phone==null){
				phone_prompt.html("请输入电话号码...");
				phone_prompt.css("color","red");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			if(reg.test(phone)==false){
				phone_prompt.html("电话号码格式错误...");
				phone_prompt.css("color","red");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			flag = true;
			$(this).css("border","1px solid #CECECE");
			return true;
		}
	)
	$("#telephone").focus(
		function(){
			$(".phone_prompt").html("");
		}	
	)
	
	//邮政编码
	$("#postCode").blur(
		function(){
			var postCode = $("#postCode").val();
			var postCode_prompt = $(".postCode_prompt");
			var reg = /^[1-9][0-9]{5}$/;
			if(postCode==""||postCode==null){
				postCode_prompt.html("请输入邮政编码...");
				postCode_prompt.css("color","red");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			if(reg.test(postCode)==false){
				postCode_prompt.html("邮政编码格式错误...");
				postCode_prompt.css("color","red");
				$(this).css("border","1px solid red");
				flag = false;
				return false;
			}
			$(this).css("border","1px solid #CECECE");
			flag = true;
			return true
		}	
	)
	$("#postCode").focus(
		function(){
			$(".postCode_prompt").html("");
		}	
	)
	
	//点击保存
	$("#saveBTN").click(
		function(){
			$("#consignee").blur();
			var s = $.city();
			$("#street").blur();
			$("#telephone").blur();
			$("#postCode").blur();
			var d = $.defaultAddress();
			var type = $("#type").val();
			if(flag==false||s==false||d==false){
				return false;
			}
			if(type=="firmOrder"){
				$.saveAddress();
			}
			else{
				//新增、修改地址
				$("#addressForm").submit();
			}
			
		}	
	)
})

$.extend({
	//判断城市
	city:function(){
		var province = $("#provinceValue").val();
		var city_prompt = $(".city_prompt");
		city_prompt.html("");
		if(province==""||province==null){
			city_prompt.html("请选择省份...");
			city_prompt.css("color","red");
			return false;
		}
		return true;	
	},

	//默认地址
	defaultAddress:function(){
		var dd = $("#isDefault:checked").val();
		var isDefaul_prompt = $(".isDefaul_prompt");
		if(dd==null){
			isDefaul_prompt.html("是否为默认地址??");
			isDefaul_prompt.css("color","red");
			return false;
		}
		return true;
	},
	
	//保存地址
	saveAddress:function(){
		var consignee = $("#consignee").val();
		var telephone = $("#telephone").val();
		var postCode = $("#postCode").val();
		var street = $("#street").val();
		var province = $("#provinceValue").val();
		var city = $("#cityValue").val();
		var country = $("#countryValue").val();
		var isDefault = $("#isDefault:checked").val();
		var addressId = $("#addressId").val();
		var type = $("#type").val();
		var url = "../userCenter/address_addAddress.action";
		var data = {"address.consignee":consignee,"address.addressPhone":telephone,
			        "address.addressPostalcode":postCode,"address.isDefault":isDefault,
			        "province":province,"city":city,"country":country,"street":street,
			        "address.addressId":addressId,"type":type};
		$.ajax({
			url:url,
			async: false,
            type: "post",
			data:data,
			success:function(){
				$(".addAddress").hide();
				//设置显示表单值
				var detailAddress = province+","+city+","+country+","+street;
				$(".ps_address .content .address .detailAddress").html(detailAddress);
				$(".ps_address .content .address .postCode").html(postCode);
				$(".ps_address .content .address .consignee").html(consignee);
				$(".ps_address .content .address .phone").html(telephone);
				$(".ps_address .content .oldAddress").show();
			}
		})
	}
	
})