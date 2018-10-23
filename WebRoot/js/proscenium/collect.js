$(document).ready(function(){
	//判断当前的tab
	var type = $("#collectType").val();
	var _li = $(".collect_content .title li");
	if(type=="all"){
		_li.eq(0).attr("class","now");
		$(".collect_content .content .kongbai").css("left","334px");
	}
	if(type=="zs"){
		_li.eq(1).attr("class","now");
		$(".collect_content .content .kongbai").css("left","431px");
	}
	if(type=="xj"){
		_li.eq(2).attr("class","now");
		$(".collect_content .content .kongbai").css("left","528px");
	}
	
	//鼠标放在li上面
	$(".collect_content .title li").hover(
		function(){
			var _class = $(this).attr("class");
			if(_class!="now"){
				$(this).css("color","#CC0000");
			}
		},
		function(){
			var _class = $(this).attr("class");
			if(_class!="now"){
				$(this).css("color","#797979");
			}
		}
	)

	//点击tab
	$(".collect_content .title li").click(
		function(){
			var _id = $(this).attr("id");
			if("tab1"==_id){
				window.location.href = "../userCenter/collect_seeCollection.action?type=all&page=1";
			}
			if("tab2"==_id){
				window.location.href = "../userCenter/collect_seeCollection.action?type=zs&page=1";
			}
			if("tab3"==_id){
				window.location.href = "../userCenter/collect_seeCollection.action?type=xj&page=1";
			}
		}	
	)
	
	//点击全选
	$("input[class='quanxuan']").click(
		function(){
			var _checked = $(this).attr("checked");
			var _ch = $("li[class='collect'] input[type='checkbox']");
			if(_checked=="checked"){
				_ch.attr("checked","checked");
			}
			else{
				_ch.attr("checked","false");
			}
			
		}	
	)
	
	//放在页面上面时 
	$("ul[class='page'] li span").hover(
		function(){
			$(this).css("border","1px solid red");
		},
		function(){
			$(this).css("border","1px solid #DDDDDD");
		}
	)
	
})