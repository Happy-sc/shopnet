$(document).ready(function(){
	//�����˷�
	$.setFreight();

	//����ʹ��ͼ����
	$(".car_youhuiquan .left img[class='shiyong']").hover(
		function(){
			$(this).attr("src","../images/proscenium/shiyong_02.jpg")
		},
		function(){
			$(this).attr("src","../images/proscenium/shiyong_01.jpg")
		}
	)
	
	//������ȥ����ͼ����
	$(".car_bottom .left img").hover(
		function(){
			$(this).attr("src","../images/proscenium/jixugouwu_02.jpg")
		},
		function(){
			$(this).attr("src","../images/proscenium/jixugouwu_01.jpg")
		}
	)
	
	//����ȥ����ͼ����
	$(".car_bottom .right li img").hover(
		function(){
			$(this).attr("src","../images/proscenium/qujiesuan_12.jpg")
		},
		function(){
			$(this).attr("src","../images/proscenium/qujiesuan_11.jpg")
		}
	)
	
	$("a[class='rhsyyhq']").hover(
		function(e){
			var y = e.originalEvent.y || e.originalEvent.layerY || 0;
			$(".rhsyyhqDIV").show();
			$(".rhsyyhqDIV").css("top",y+15);
		},
		function(){
			$(".rhsyyhqDIV").hide();
		}
	)
	
	$("a[class='rhsyyjbddyhq']").hover(
		function(e){
			var y = e.originalEvent.y || e.originalEvent.layerY || 0;
			$(".rhsyyjbddyhqDIV").show();
			$(".rhsyyjbddyhqDIV").css("top",y+15);
		},
		function(){
			$(".rhsyyjbddyhqDIV").hide();
		}
	)
	
})

