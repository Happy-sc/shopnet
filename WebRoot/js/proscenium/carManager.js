$(document).ready(function(){
	//放在-、+符号上面
	$("span[class='carNumber']").hover(
		function(){
			$(this).css("border","1px solid #999999");
		},
		function(){
			$(this).css("border","1px solid #EAE8E8");
		}
	)
	
	//点击-、+符号
	$("span[class='carNumber']").click(
		function(){
			var _this = $(this).text();
			var number = $(this).parent().parent().children("input");
			var thisNumber = 1;
			if(_this=="-"){
				if(number.val()!=1){
					thisNumber = Number(number.val())-1;
					number.val(thisNumber);
				}
			}
			else{
				thisNumber = Number(number.val())+1;
				number.val(thisNumber);
			}
			
			var _td = $(this).parent().parent().parent().children();
			var price = _td.eq(2).text().substring(1,_td.eq(2).text().length);
			var sum = (Number(price)*thisNumber).toFixed(2);
			_td.eq(4).text("￥"+sum);
			//修改购物车
			var carId = $(this).parent().parent().parent().children().eq(0).children("input").val();
			$.updateCar(carId,thisNumber);
		}	
	)
	
	//数量文本框里面的数据发生改变时
	$("input[class='carNum']").change(
		function(){
			var number = $(this).val();
			if(number==0){
				number = 1;
				$(this).val(1);
			}
			var _td = $(this).parent().parent().children();
			var price = _td.eq(2).text().substring(1,_td.eq(2).text().length);
			var sum = (Number(price)*number).toFixed(2);
			_td.eq(4).text("￥"+sum);
			var carId = $(this).parent().parent().children().eq(0).children("input").val();
			$.updateCar(carId,number);
			$.setFreight();
		}	
	)
	
	//点击删除
	$("a[id='shanchu']").click(
		function(){
			var _li = $(this).parent().parent().parent().parent().parent();
			var carId = $("#carCarId").val();
			$.deleteCar(carId);
			_li.remove();
			
		}	
	)
	
	//点击收藏
	$("a[id='shoucang']").click(
		function(e){
			var goodsId = $("#carGoodsId").val();
			//收藏商品
		    var i =	$.collectGoods(goodsId,e);
		}	
	)
	
	//点击X时
	$(".shoucang a,.yjscl a").click(
		function(){
			var _class = $(this).parent().attr("class");
			$("."+_class).hide();
		}	
	)
	
})

$.extend({
	//修改购物车
	updateCar:function(carId,number){
		var url = "../order/orderCar_updateCar.action";
		$.post(
			url,
			{
			carId:carId,
			number:number
			},
			function(data){
				var type = $("#carType").val();
				if(type=="firmOrder"){
					$("font[class='zje']").html("&yen;"+data);
					$("font[class='sfk']").html("&yen;"+data);
					$("font[class='khdpxb']").html(parseInt(data/100)+"个");
				}
				if(type=="showCar"){
					$(".car_content span[class='thisSum']").html(data);
					$(".car_bottom .right li span[class='sum']").html("&yen;"+data);
					$(".car_youhuiquan .right [class='YHQSUM']").html("商品总额:"+data);
				}
			}
		)
	},
	
	//删除购物车
	deleteCar:function(carId){
		var url = "../order/orderCar_deleteGoods.action";
		$.post(
			url,
			{
				carId:carId
			},
			function(data){
				var type = $("#carType").val();
				if(type=="firmOrder"){
					$("font[class='zje']").html("&yen;"+data);
					$("font[class='sfk']").html("&yen;"+data);
				}
				if(type=="showCar"){
					$(".car_content span[class='thisSum']").html("&yen;"+data);
					$(".car_bottom .right li span[class='sum']").html("&yen;"+data);
					$(".car_youhuiquan .right [class='YHQSUM']").html("&yen;"+data);
				}
			}
		)
	},
	
	//收藏商品
	collectGoods:function(goodsId,e){
		var url = "../userCenter/collect_collectGoods.action";
		$.post(
			url,
			{
				goodsId:goodsId
			},
			function(data){
				var y = e.originalEvent.y || e.originalEvent.layerY || 0;
				if(data=="0"){
					$(".yjscl").show();
					$(".yjscl").css("top",y-30);
					$(".yjscl").delay(3000).hide(0);          //延时函数
				}
				else{
					$(".shoucang").show();
					$(".shoucang").css("top",y-30);
					$(".shoucang").delay(3000).hide(0);      //延时函数
				}
			}
		)
	},
	
	//设置运费
	setFreight:function(){
		var sum = $(".car_content span[class='thisSum']").text();
		if(Number(sum)<229){
			$("img[class='freight']").attr("src","../images/proscenium/order_no.jpg");
			$("span[class='freight']").html("还未满229元免运费条件！(运费全国10元)");
			$("span[class='freight']").css("color","red");
			$(".car_bottom .right li .yunfei").html("运费<span style='font-size:12px;color:#FA0505'>10</span>元&nbsp;&nbsp;&nbsp;")
		}
		else{
			$("img[class='freight']").attr("src","../images/proscenium/order_yes.jpg");
			$("span[class='freight']").html("已满229元免运费条件，本订单可免运费！");
			$(".car_bottom .right li .yunfei").html("<span style='font-size:12px;color:#FA0505'>免运费&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>")
		}
	},
	
	
})