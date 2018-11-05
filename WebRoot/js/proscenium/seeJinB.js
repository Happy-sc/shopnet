$(document).ready(function(){
	//选定tab
	var _type = $("#jinBType").val();
	if("jbhqjl"==_type){
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
	$(".jinB_content .title li").hover(
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
	$(".jinB_content .title li").click(
		function(){
			var _id = $(this).attr("id");
			if(_id=="tab1"){
				window.location.href = "../userCenter/seeJinB_seeJinB.action?type=jbhqjl&page=1";
			}
			if(_id=="tab2"){
				window.location.href = "../userCenter/seeJinB_seeJinB.action?type=jbzcjl&page=1";
			}
		}	
	)
})