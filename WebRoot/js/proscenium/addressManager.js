$(document).ready(function(){
	$("#addNewAddress").click(
		function(){
			//清空数据，保证修改后不会重新选定数据
			$("#addressId").val("");
			$("#consignee").val("");
			$("#telephone").val("");
			$("#postCode").val("");
			$("#street").val("");
			$("select[name=province]").children().eq(0).attr("selected","true");
			$("select[name=city]").children().eq(0).attr("selected","true");
			$("select[name=countryCity]").children().eq(0).attr("selected","true");
			
			$(".newAddress").dialog("open");
		}	
	),
	
	$(".newAddress").dialog(
  	{
  		bgiframe: true,
   		resizable: true,
    	height:400,
    	width:600,
    	position:[430,135],
  		modal: true,
      	autoOpen: false,
    }),
    
    //加载城市
	$(".city").ProvinceCity(),
	
	//放在新增图片上
	$("#addNewAddress").hover(
		function(){
			$(this).attr("src","/paixieNet/images/proscenium/addNewAddress_02.jpg")
		},
		function(){
			$(this).attr("src","/paixieNet/images/proscenium/addNewAddress_01.jpg")	
		}
	)
	//当放入input中时
	$(".newAddress input").focus(
		function(){
			$(this).css("border","1px solid #FFCC66");
		}	
	)
	
	$(".newAddress input").blur(
		function(){
			$(this).css("border","1px solid #7F9DB8");
		}	
	)
	

	//修改收货地址
	$(".showAddress a[class='update']").click(
		function(){
			//获取该行的数据
			var this_tr = $(this).parent().parent().children();
			var this_td = $(this).parent().children();
			
			var consignee = this_tr.eq(0).text();
			var telephone = this_tr.eq(1).text();
			var address = this_tr.eq(2).text();
			var postCode = this_tr.eq(3).text();
			var addressId = this_tr.eq(5).children("input").val();
			var isDefault = this_tr.eq(4).children("input").val();

			//处理地址
			var addresses = address.split(",");
			var province = addresses[0];
			var city = addresses[1];
			var country = addresses[2];
			var street = addresses[3];
			
			//设定值

			$(".newAddress #addressId").val(addressId);
			$(".newAddress #consignee").val(consignee);
			$(".newAddress #telephone").val(telephone);
			$(".newAddress #postCode").val(postCode);
			$(".newAddress #street").val(street);
			
			if(isDefault=="1"){
				$(".newAddress input[type='radio']").eq(0).attr("checked",'checked');
			}
			else{
				$(".newAddress input[type='radio']").eq(1).attr("checked",'checked');
			}
			//选定省
			var provinces = $("select[name=province]").children();
			for(var i = 0;i<provinces.length;i++){
				if(provinces.eq(i).val()==province){
					provinces.eq(i).attr("selected","true");
					provinceIndex = i;
					//展开第二级城市
					$.each( GT[i-1] , function(index,data){
						$("select[name=city]").append("<option value='"+data+"'>"+data+"</option>");
					});
				}	
			}
	
			//选定市
			var cities = $("select[name=city]").children();
			for(var j = 0;j<cities.length;j++){
				if(cities.eq(j).val()==city){
					cities.eq(j).attr("selected","true");
					//展开第三级城市
					$.each( GC[provinceIndex-1][j-1] , function(index,data){
						$("select[name=countryCity]").append("<option value='"+data+"'>"+data+"</option>");
					})
				}
			}
	
			//选定县级
			var countries = $("select[name=countryCity]").children();
			for(var l = 0;l<countries.length;l++){
				if(countries.eq(l).val()==country){
					countries.eq(l).attr("selected","true");
				}
			}
			
			$(".newAddress").attr("title","修改收货地址");
			$(".newAddress").dialog("open");
			}	
		)
		
		//点击删除
		$(".showAddress a[class='delete']").click(
			function(){
				var this_tr = $(this).parent().parent().children();
				this_tr.remove();
				var addressId = this_tr.eq(5).children("input").val();
				var url = "../userCenter/address_deleteAddress.action";
				$.post(
					url,
					{
						addressId:addressId
					},
					function(){
						var number = $(".addAddress span[class='number']");
						number.eq(0).text(Number(number.eq(0).text())-1);
						number.eq(1).text(Number(number.eq(1).text())+1);
					}
				);
			}	
		)
})