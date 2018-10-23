$(document).ready(function(){
	//选定tab
	var _type = $("#commentType").val();
	if(_type=="dpjsp"){
		$("#tab1").attr("class","now");
		$(".kongbai").css("left","332px");
		$("#tab1Div").show();
	}
	if(_type=="ypjsp"){
		$("#tab2").attr("class","now");
		$(".kongbai").css("left","444");
		$("#tab2Div").show();
	}
	
	//放在li上
	$(".comment_content .title li").hover(
		function(){
			var _class = $(this).attr("class");
			if(_class!="now")
				$(this).css("color","#CC0000");
		},
		function(){
			var _class = $(this).attr("class");
			if(_class!="now")
				$(this).css("color","#797979");
		}
	)
	
	//点击li
	$(".comment_content .title li").click(
		function(){
			var _id = $(this).attr("id");
			if("tab1"==_id){
				window.location.href = "../userCenter/comment_seeDpjspComment.action?page=1";
			}
			if("tab2"==_id){
				window.location.href = "../userCenter/comment_seeYpjspComment.action?&page=1";
			}
				
		}	
	)
})