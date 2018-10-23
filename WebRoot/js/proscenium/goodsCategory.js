//点击分类的加号,展开或关闭款式
function showOrHideStyle(num){
	$("#style_"+num).toggleClass("hide");
	if($("#style_"+num).attr("class")!="hide"){
		$("#sortTitleImage_"+num).attr("src","../images/proscenium/-.jpg");
	}
	if($("#style_"+num).attr("class")=="hide"){
		$("#sortTitleImage_"+num).attr("src","../images/proscenium/+.jpg");
	}
}


//点击category tab
function setLable(name,num,n){
	for(var j = 1;j<=n;j++){
		var menu = $("#"+name+j);
		menu.attr("class","tabli");
		if(j==num){
			$("#"+name+j).removeAttr("a");
			$("#"+name+j).attr("class","now");
		}
	}
}

$(document).ready(function() {
	//当鼠标放在页面上面时
	$(".categoryPage a span").hover(
		function(){
			$(this).css("border","1px solid red");
		}
		,function(){
			$(this).css("border","1px solid #ccc");
		}
	)
	
	//展开分类
	var flcategoryId = $("#flcategoryId").val();
	var i = flcategoryId.substring(flcategoryId.length-1,flcategoryId.length);
	showOrHideStyle(i);
	
})
