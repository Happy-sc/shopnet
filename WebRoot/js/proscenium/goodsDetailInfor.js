//tab页面切换
function setTab(name, num, n) {
	for (i = 1; i <= n; i++) {
		var menu = document.getElementById(name + i);
		var con = document.getElementById(name + "_" + "con" + i);
		var tabli = "one"+i;
		tabli.className = "tabli";
		menu.className = i == num ? "now" : "";
		con.style.display = i == num ? "block" : "none";
	}
}

$(document).ready(function(){
	//初始化dialog
	$(".userLogin").dialog(
  	{
  		bgiframe: true,
   		resizable: true,
    	height:330,
    	width:500,
  		modal: true,
      	autoOpen: false,
    })
    
	//选定当前颜色
	var thisColor = $("#choosedImg").val();
	var imgs = $("#goods_infor_detail img[id='goodsColor']");
	for(var i = 0;i<imgs.length;i++){
		if(imgs.eq(i).attr("src")==thisColor){
			imgs.eq(i).css("border","1px solid red");
			imgs.eq(i).attr("class","this");
		}
	}
	
	//是否显示jQuery dialog
	var _url = location.search;
	var param = _url.split("&");
	for(var i = 0;i<param.length;i++){
		var _param = param[i];
		var paramValue = _param.split("=")[1];
		if(paramValue=="show"){
			$(".userLogin .password_prompt").html("用户名或密码错误,请重新输入...");
			$(".userLogin").dialog("open");
		}
			
	}
	
	//鼠标放在颜色上
	$("#goods_infor_detail img[id='goodsColor']").hover(
		function(){
			$(this).css("border","1px solid red");
		},
		function(){
			var class_ = $(this).attr("class");
			if(class_!="this")
				$(this).css("border","1px solid #DEDEDE");
		}
	)

	$("#goods_infor_detail span[class='size']").click(
		function(){
			var buyColor = $(this).parent().parent().children();
			buyColor.children().css("border","1px solid #DDDDDD");
			buyColor.children().attr("id","");
			$(this).css("border","1px solid red");
			$(this).attr("id","nowSize");
			$("#qxzcm").css("border","0px");
			$("#goods_infor_detail").css("height","200px");
			$("#tjdtr").remove();
		}
	)
	
	//点击-,+号时
	$("#goods_infor_detail span[class='number']").click(
		function(){
			var id = $(this).attr("id");
			var numberValue = $("#buyNumber").val();
			if(id=="number_"||id=="cnumber_"){
				if(numberValue!=1){
					$("#buyNumber").val(parseInt(numberValue)-1);
				}
				else{
					$("#buyNumber").val(1);
				}
			}
			else{
				$("#buyNumber").val(parseInt(numberValue)+1);
			}
		}	
	)
	
	//放在购买的div上时
	$("#goods_infor_detail").hover(
		function(){
			$(this).css("border","1px solid #FFCC7F");
			$(this).css("background-color","#FFFFE5");
		},
		function(){
			$(this).css("border","1px solid #E5E5E5");
			$(this).css("background-color","#F7F7F7");
		}
	)
	
	//放在购买按钮上
	$("#goods_infor_detail img[class='goumai']").hover(
		function(){
			$(this).attr("src","../images/proscenium/goumai_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/goumai_01.jpg");
		}
	)
	
	//放在加入购物车上
	$("#goods_infor_detail img[class='addCar']").hover(
		function(){
			$(this).attr("src","../images/proscenium/addcar_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/addcar_01.jpg");
		}
	)

	//点击购物车、立即购买--分开做
	$("#goods_infor_detail img[class='addCar']").click(
		function(){
			var flag = "false";
			var class_ = $(this).attr("class");
			//获取所有的属性
			var size = $("#goods_infor_detail span[class='size']");
			for(var i = 0;i<size.length;i++){
				var id = size.eq(i).attr("id");
				if(id=="nowSize"){
					flag = "true";
					break;
				}
			}
			if(flag=="false"){
				$("#qxzcm").css("border","1px solid red");
				$("#goods_infor_detail").css("height","230px");
				$("#tjdtr").remove();
				$("#qxzcm").after("<tr id='tjdtr'><td clospan='2' style='font-size:12px;color:red'>请选择属性</td></tr>");
			}
			else{
				var goodsId = $("#choosedGoodsId").val();
				var goodsSize = $("#goods_infor_detail span[id='nowSize']").html();
				var goodsColor = $("#choosedColor").val();
				var goodsNumber = $("#buyNumber").val();
 				$.addCar(goodsId,goodsSize,goodsColor,goodsNumber);
				$(".addCarSuccess").show();
				$("#sfyjysp").val("yjyl");
			}

		}
	)
	
	//点击立即购买
    $("#goods_infor_detail img[class='goumai']").click(
    	function(){
		var sfyjysp = $("#sfyjysp").val();      //判断是否已经加入购物车了
		if(sfyjysp!="yjyl"){
			var flag = "false";
			var class_ = $(this).attr("class");
			//获取所有的属性
			var size = $("#goods_infor_detail span[class='size']");
			for(var i = 0;i<size.length;i++){
				var id = size.eq(i).attr("id");
				if(id=="nowSize"){
					flag = "true";
					break;
				}
			}
			if(flag=="false"){
				$("#qxzcm").css("border","1px solid red");
				$("#goods_infor_detail").css("height","230px");
                $("#tjdtr").remove();
				$("#qxzcm").after("<tr id='tjdtr'><td clospan='2' style='font-size:12px;color:red'>请选择属性</td></tr>");
			} else{
				var goodsId = $("#choosedGoodsId").val();
				var goodsSize = $("#goods_infor_detail span[id='nowSize']").html();
				var goodsColor = $("#choosedColor").val();
				var goodsNumber = $("#buyNumber").val();
 				setTimeout(function(){$.addCar(goodsId,goodsSize,goodsColor,goodsNumber);},2000);
 				window.location.href = "../order/orderCar_showCar.action";
 			}
		}
		else{
			window.location.href = "../order/orderCar_showCar.action";
		}
	})
	
	//点击X时
	$(".chooseSize_title img").click(
		function(){
			$(".chooseSize").hide();
		}	
	)
	
	//点击X或者再逛逛链接时
	$(".addCarSuccess img[class='x'],a[class='zaikan']").click(
		function(){
			$(".addCarSuccess").hide();
		}	
	)
	
	//点击收藏
	$("img[class='shoucang']").click(
		function(){
			var userName = $("#topUserName").val();
			if(userName==""){
				$(".userLogin #type").val("collect");
				$(".userLogin").dialog("open");
			}
			else{
				var goodsId = $("#choosedGoodsId").val();
				var url = "../userCenter/collect_collectGoods.action";
				$.post(
					url,
					{
						goodsId:goodsId
					},
					function(data){
						if(data=="1"){
							$(".sccgDIV").show();
							$(".sccgDIV").delay(2000).hide(0);          //延时函数
						}
						
						else{
							$(".scsbDIV").show();
							$(".scsbDIV").delay(2000).hide(0);      //延时函数
						}
					})
				}
			}	
		)
	
	//点击收藏的X时
	$(".sccgDIV a,.scsbDIV a").click(
		function(){
			var _class = $(this).parent().attr("class");
			$("."+_class).hide();
		}	
	)

	//点击我要评价
    $("#wypj").click(
    	function(){
    		var userName = $("#topUserName").val();
    		var goodsId = $("#choosedGoodsId").val();
			if(userName==""){
				$(".userLogin #type").val("comment");
				$(".userLogin").dialog("open");
			}
			else{
				window.location.href = "../goods/comment_goodsComment.action?goodsId="+goodsId;
			}
    	}	
    )
    
 	var flag;
    //用户名输入框
    $(".userLogin #userName").focus(
    	function(){
    		$(this).css("border","1px solid #FFCC66");
    		$(".userLogin .userName_prompt").html("");
    	}	
    )
    $(".userLogin #userName").blur(
    	function(){
    		var userName = $(this).val();
    		var userName_prompt = $(".userLogin .userName_prompt");
    		userName_prompt.css("color","red");
    		if(userName==""||userName==null){
    			userName_prompt.html("请输入用户名...");
    			$(this).css("border","1px solid red");
    			flag = false;
    			return false;
    		}
    		var reg = /^[a-zA-Z0-9_]{6,16}$/;
    		if(reg.test(userName)==false){
    			userName_prompt.html("用户名格式错误,请重新输入...")
    			$(this).css("border","1px solid red");
    			flag = false;
    			return false;
    		}
    		$(this).css("border","1px solid #CECECE");
    		flag = true;
    		return true;
    	}	
    )
    
    //密码文本框
    $(".userLogin #password").focus(
    	function(){
    		$(this).css("border","1px solid #FFCC66");
    		$(".userLogin .password_prompt").html("");
    	}	
    )
    $(".userLogin #password").blur(
    	function(){
    		var password = $(this).val();
    		var password_prompt = $(".userLogin .password_prompt");
    		password_prompt.css("color","red");
    		if(password==""||password==null){
    			password_prompt.html("请输入登录密码...");
    			$(this).css("border","1px solid red");
    			flag = false;
    			return false;
    		}
    		var reg = /^[a-zA-Z0-9_]{6,16}$/;
    		if(reg.test(password)==false){
    			password_prompt.html("登录密码格式错误,请重新输入...")
    			$(this).css("border","1px solid red");
    			flag = false;
    			return false;
    		}
    		$(this).css("border","1px solid #CECECE");
    		flag = true;
    		return true;
    	}	
    )
    
    //登录按钮
    $(".userLogin img").hover(
    	function(){
    		$(this).attr("src","../images/proscenium/userLogin_02.jpg");
    	},
    	function(){
    		$(this).attr("src","../images/proscenium/userLogin_01.jpg");
    	}
    )
	
    //点击登录按钮
    $(".userLogin .userLoginGD").click(
    	function(){
    		 $(".userLogin #userName").blur();
    		 $(".userLogin #password").blur();
    		 if(flag==false)
    			 return false;
    		 else{
    			 var userName = $(".userLogin #userName").val();
    			 var password = $(".userLogin #password").val();
    			 var type = $(".userLogin #type").val();
    			 var goodsId = $("#choosedGoodsId").val();
    			 var url = "../users/usersLogin_dialogUserLogin.action";
    			$.post(
    				url,
    				{
    					userName:userName,
    					password:password,
    					type:type,
    					goodsId :goodsId
    				},
    				function(data){
    					$("#topUserName").val("userName");
    					if(data.indexOf("错误")!=-1){
    						$(".userLogin .password_prompt").html(data);
    					}
    					if(data.indexOf("收藏过该商品")!=-1){
    						$(".userLogin").dialog("close");
    						$(".scsbDIV").show();
    					}
    					if(data.indexOf("收藏成功")!=-1){
    						$(".userLogin").dialog("close");
    						$(".sccgDIV").show();
    					}
    					if(data.indexOf("评价")!=-1){
    						window.location.href = "../goods/comment_goodsComment.action?goodsId="+goodsId;
    					}
    				}
    			)
    		 }
    	}	
    )
})

//定义匿名函数
$.extend({
	//加入购物车
	addCar:function(goodsId,goodsAttr,goodsColor,goodsNumber){
		var url = "../goods/car_addGoods.action";
		$.ajax({
			url:url,
			data:{
				goodsId:goodsId,
                goodsAttr:goodsAttr,
				goodsColor:goodsColor,
				goodsNumber:goodsNumber
			},
			type:"POST",
			success:function(data){
				var datas = data.split(",");
				$(".addCarSuccess span[class='number']").html(datas[0]);
				$(".addCarSuccess span[class='price']").html(datas[1]);
				$(".mycar_title span[class='topNumber']").html(datas[0]);
			}
		})
	}
})
