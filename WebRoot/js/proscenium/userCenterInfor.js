$(document).ready(function() {
	var provinceIndex; //定义全局变量记录省位置
     
	//加载城市
	$(".address").ProvinceCity();
	
	//选定性别
	var sexValue =  $("#sexValue").val();
	var sexs = $("input[id=userSex]");
	for(var i=0;i<sexs.length;i++){
		if($("input[id=userSex]").eq(i).val()==sexValue){
			$("input[id=userSex]").eq(i).attr("checked",'checked');
		}
	}
	
	//选定省
	var province = $("#province").val();
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
	var city = $("#city").val();
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
	var country = $("#country").val();
	var countries = $("select[name=countryCity]").children();
	for(var l = 0;l<countries.length;l++){
		if(countries.eq(l).val()==country){
			countries.eq(l).attr("selected","true");
		}
	}
	
	//检验数据
	$("#userCenterForm").submit(
		
		function(){
			var userRealName = $("#userRealName").val();
			var userSex = $("#userSex").val();
			var userBirthday = $("#userBirthday").val();
			var province = $("#provinceValue").val();
			var city = $("#cityValue").val();
			var country = $("#countryValue").val();
			var street = $("#street").val();

			if(userRealName==""){
				$("#userRealName_prompt").html("请输入真实姓名...");
				$("#userRealName_prompt").attr("class","error_prompt");
				return false;
			}
			if(userSex==""){
				$("#userSex_prompt").html("请选择性别...");
				$("#userSex_prompt").attr("class","error_prompt");
				return false;
			}
			if(userBirthday==""){
				$("#userBirthday_prompt").html("请选择出身日期...");
				$("#userBirthday_prompt").attr("class","error_prompt");
				return false;
			}
			if(province==""||city==""||country==""||street==""){
				$("#address_prompt").html("请选择/输入详细地址...");
				$("#address_prompt").attr("class","error_prompt");
				return false;
			}
			return true;
		}	
	)
	
})