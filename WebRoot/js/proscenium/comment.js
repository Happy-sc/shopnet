$(document).ready(function(){
	//���������С�ż���б�����ɫ
	var comment = $(".comment_content");
	for(var i = 1;i<=comment.length;i++){
		if(i%2==0){
			var _div = comment.eq(i-1);
			_div.css("background-color","#F7F7F7");
			var _img = _div.children().children().children().eq(0).children().eq(0).children("img");
			_img.attr("src","../images/proscenium/commentx_02.jpg");
		}
	}
	
	//�û��ղ���Ʒ
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
						$(".sccgDIV").delay(3000).hide(0);          //��ʱ����
					}
					else{
						$(".scsbDIV").show();
						$(".scsbDIV").delay(3000).hide(0);      //��ʱ����
					}
				}
			)
		}	
	)
	
	//����ղص�Xʱ
	$(".sccgDIV a,.scsbDIV a").click(
		function(){
			var _class = $(this).parent().attr("class");
			$("."+_class).hide();
		}	
	)
})