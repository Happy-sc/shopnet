//�������ļӺ�,չ����رտ�ʽ
function showOrHideStyle(num){
	$("#style_"+num).toggleClass("hide");
	if($("#style_"+num).attr("class")!="hide"){
		$("#sortTitleImage_"+num).attr("src","../images/proscenium/-.jpg");
	}
	if($("#style_"+num).attr("class")=="hide"){
		$("#sortTitleImage_"+num).attr("src","../images/proscenium/+.jpg");
	}
}


//���category tab
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
	//��������ҳ������ʱ
	$(".categoryPage a span").hover(
		function(){
			$(this).css("border","1px solid red");
		}
		,function(){
			$(this).css("border","1px solid #ccc");
		}
	)
	
	//չ������
	var flcategoryId = $("#flcategoryId").val();
	var i = flcategoryId.substring(flcategoryId.length-1,flcategoryId.length);
	showOrHideStyle(i);
	
})
