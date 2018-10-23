$(document).ready(function(){
	//µã»÷×ó±ßµÄtap
	$("h1[class='type']").click(function(){
		var _content = $(this).parent().children(".content");
		var _id = _content.attr("id");
		if(_id=="hideDiv"){
			_content.show();
			_content.attr("id","");
		}
		else{
			_content.hide();
			_content.attr("id","hideDiv");
		}
	})
})