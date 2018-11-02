$(document).ready(function(){
	//设置奇数行、偶数行背景颜色
	var comment = $(".comment_content");
	for(var i = 1;i<=comment.length;i++){
		if(i%2==0){
			var _div = comment.eq(i-1);
			_div.css("background-color","#F7F7F7");
			var _img = _div.children().children().children().eq(0).children().eq(0).children("img");
			_img.attr("src","../images/proscenium/commentx_02.jpg");
		}
	}
	
	//用户收藏商品
	$("#collect").click(
		function(){
			var goodsId = $("#goodsId").val();
			var url = "../userCenter/collect_collectGoods.action";
			$.post(
				url,
				{
					goodsId:goodsId
				},
				function(data){
					if(data=="1"){
						$(".sccgDIV").show();
						$(".sccgDIV").delay(3000).hide(0);          //延时函数
					}
					else{
						$(".scsbDIV").show();
						$(".scsbDIV").delay(3000).hide(0);      //延时函数
					}
				}
			)
		}	
	)
	
	//点击收藏的X时
	$(".sccgDIV a,.scsbDIV a").click(
		function(){
			var _class = $(this).parent().attr("class");
			$("."+_class).hide();
		}	
	)
})