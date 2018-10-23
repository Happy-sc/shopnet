$(document).ready(function() {
	//鼠标放在<上时
	$(".recommand_content .left img").hover(
		function(){
			$(this).attr("src","../images/proscenium/userCenter_left02.jpg")
		},
		function(){
			$(this).attr("src","../images/proscenium/userCenter_left01.jpg")
		}
	),
	
	//鼠标放在>上时
	$(".recommand_content .right img").hover(
		function(){
			$(this).attr("src","../images/proscenium/userCenter_right02.jpg")
		},
		function(){
			$(this).attr("src","../images/proscenium/userCenter_right01.jpg")
		}
	),
	
	//点击tab选项
	$(".recommand_title li").click(
		function(){
			var tabs = $(".recommand_title").children().children("li");
			tabs.removeClass("now");
			$(this).attr("class","now");
			var contents = $(".recommand_content").children();
			var thisId = $(this).attr("id");
			var contentId = ".tabContent_"+thisId.substring(thisId.length-1,thisId.length);
			contents.hide();
			$(contentId).show();
		}	
	)
	
	//设定安全级别
	var i = $("#aqjb").val();
	if(i==2){
		$(".aqjbz").attr("src","../images/proscenium/safeLevelzhong_02S.jpg");
	}
	if(i==3){
		$(".aqjbz").attr("src","../images/proscenium/safeLevelzhong_02.jpg");
		$(".aqjbq").attr("src","../images/proscenium/safeLevelqiang_02.jpg");
	}
})