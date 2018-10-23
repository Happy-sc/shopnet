$(document).ready(function(){
	//����-��+��������
	$("span[class='carNumber']").hover(
		function(){
			$(this).css("border","1px solid #999999");
		},
		function(){
			$(this).css("border","1px solid #EAE8E8");
		}
	)
	
	//���-��+����
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
			_td.eq(4).text("��"+sum);
			//�޸Ĺ��ﳵ
			var carId = $(this).parent().parent().parent().children().eq(0).children("input").val();
			$.updateCar(carId,thisNumber);
		}	
	)
	
	//�����ı�����������ݷ����ı�ʱ
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
			_td.eq(4).text("��"+sum);
			var carId = $(this).parent().parent().children().eq(0).children("input").val();
			$.updateCar(carId,number);
			$.setFreight();
		}	
	)
	
	//���ɾ��
	$("a[id='shanchu']").click(
		function(){
			var _li = $(this).parent().parent().parent().parent().parent();
			var carId = $("#carCarId").val();
			$.deleteCar(carId);
			_li.remove();
			
		}	
	)
	
	//����ղ�
	$("a[id='shoucang']").click(
		function(e){
			var goodsId = $("#carGoodsId").val();
			//�ղ���Ʒ
		    var i =	$.collectGoods(goodsId,e);
		}	
	)
	
	//���Xʱ
	$(".shoucang a,.yjscl a").click(
		function(){
			var _class = $(this).parent().attr("class");
			$("."+_class).hide();
		}	
	)
	
})

$.extend({
	//�޸Ĺ��ﳵ
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
					$("font[class='khdpxb']").html(parseInt(data/100)+"��");
				}
				if(type=="showCar"){
					$(".car_content span[class='thisSum']").html(data);
					$(".car_bottom .right li span[class='sum']").html("&yen;"+data);
					$(".car_youhuiquan .right [class='YHQSUM']").html("��Ʒ�ܶ�:"+data);
				}
			}
		)
	},
	
	//ɾ�����ﳵ
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
	
	//�ղ���Ʒ
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
					$(".yjscl").delay(3000).hide(0);          //��ʱ����
				}
				else{
					$(".shoucang").show();
					$(".shoucang").css("top",y-30);
					$(".shoucang").delay(3000).hide(0);      //��ʱ����
				}
			}
		)
	},
	
	//�����˷�
	setFreight:function(){
		var sum = $(".car_content span[class='thisSum']").text();
		if(Number(sum)<229){
			$("img[class='freight']").attr("src","../images/proscenium/order_no.jpg");
			$("span[class='freight']").html("��δ��229Ԫ���˷�������(�˷�ȫ��10Ԫ)");
			$("span[class='freight']").css("color","red");
			$(".car_bottom .right li .yunfei").html("�˷�<span style='font-size:12px;color:#FA0505'>10</span>Ԫ&nbsp;&nbsp;&nbsp;")
		}
		else{
			$("img[class='freight']").attr("src","../images/proscenium/order_yes.jpg");
			$("span[class='freight']").html("����229Ԫ���˷������������������˷ѣ�");
			$(".car_bottom .right li .yunfei").html("<span style='font-size:12px;color:#FA0505'>���˷�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>")
		}
	},
	
	
})