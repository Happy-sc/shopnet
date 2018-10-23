$(document).ready(function(){
	//选定tab
	var _type = $("#paixieBType").val();
	if("pxbhqjl"==_type){
		$("#tab1").attr("class","now");
		$(".kongbai").css("left","332px");
		$("#tab1Div").show();
	}
	if("pxbzcjl"==_type){
		$("#tab2").attr("class","now");
		$(".kongbai").css("left","474px");
		$("#tab2Div").show();
	}
	
	//放在tab上
	$(".paixieB_content .title li").hover(
		function(){
			var _class = $(this).attr("class");
			if("now"!=_class){
				$(this).css("color","#CC0000");
			}
		},
		function(){
			var _class = $(this).attr("class");
			if("now"!=_class){
				$(this).css("color","#797979");
			}
		}
	)
	
	//点击tab
	$(".paixieB_content .title li").click(
		function(){
			var _id = $(this).attr("id");
			if(_id=="tab1"){
				window.location.href = "../userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=1";
			}
			if(_id=="tab2"){
				window.location.href = "../userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=1";
			}
		}	
	)
})