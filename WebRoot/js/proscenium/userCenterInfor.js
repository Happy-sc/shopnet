$(document).ready(function() {
	var provinceIndex; //����ȫ�ֱ�����¼ʡλ��
     
	//���س���
	$(".address").ProvinceCity();
	
	//ѡ���Ա�
	var sexValue =  $("#sexValue").val();
	var sexs = $("input[id=userSex]");
	for(var i=0;i<sexs.length;i++){
		if($("input[id=userSex]").eq(i).val()==sexValue){
			$("input[id=userSex]").eq(i).attr("checked",'checked');
		}
	}
	
	//ѡ��ʡ
	var province = $("#province").val();
	var provinces = $("select[name=province]").children();
	for(var i = 0;i<provinces.length;i++){
		if(provinces.eq(i).val()==province){
			provinces.eq(i).attr("selected","true");
			provinceIndex = i;
			//չ���ڶ�������
			$.each( GT[i-1] , function(index,data){
				$("select[name=city]").append("<option value='"+data+"'>"+data+"</option>");
			});
		}	
	}
	
	//ѡ����
	var city = $("#city").val();
	var cities = $("select[name=city]").children();
	for(var j = 0;j<cities.length;j++){
		if(cities.eq(j).val()==city){
			cities.eq(j).attr("selected","true");
			//չ������������
			$.each( GC[provinceIndex-1][j-1] , function(index,data){
				$("select[name=countryCity]").append("<option value='"+data+"'>"+data+"</option>");
			})
		}
	}
	
	//ѡ���ؼ�
	var country = $("#country").val();
	var countries = $("select[name=countryCity]").children();
	for(var l = 0;l<countries.length;l++){
		if(countries.eq(l).val()==country){
			countries.eq(l).attr("selected","true");
		}
	}
	
	//��������
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
				$("#userRealName_prompt").html("��������ʵ����...");
				$("#userRealName_prompt").attr("class","error_prompt");
				return false;
			}
			if(userSex==""){
				$("#userSex_prompt").html("��ѡ���Ա�...");
				$("#userSex_prompt").attr("class","error_prompt");
				return false;
			}
			if(userBirthday==""){
				$("#userBirthday_prompt").html("��ѡ���������...");
				$("#userBirthday_prompt").attr("class","error_prompt");
				return false;
			}
			if(province==""||city==""||country==""||street==""){
				$("#address_prompt").html("��ѡ��/������ϸ��ַ...");
				$("#address_prompt").attr("class","error_prompt");
				return false;
			}
			return true;
		}	
	)
	
})