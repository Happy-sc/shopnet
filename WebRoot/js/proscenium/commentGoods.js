$(document).ready(function(){
	//放在打分上面
	$(".dafenA").hover(
		function(){
			grade($(this));
		},
		function(){
			var _grade = $("#commentGrade").val();
			if(_grade==0){
				$(".dafenA").children().attr("src","../images/proscenium/dafen_11.jpg");
			}
		}
	)
	
	//点击打分
	$(".dafenA").click(function(){
		var num = grade($(this));
		$("#commentGrade").val(num);
	})
	
	//发表评价按钮
	$("#fbpjImg").hover(
		function(){
			$(this).attr("src","../images/proscenium/fbpl_02.jpg");
		},
		function(){
			$(this).attr("src","../images/proscenium/fbpl_01.jpg");
		}
	)
	
})

function grade(_this){
	$(".dafenA").children().attr("src","../images/proscenium/dafen_11.jpg");
	var _img = _this.children();
	var _imgClass = _img.attr("class");
	var _num = _imgClass.substring(_imgClass.length-1,_imgClass.length);
	for(var i = 1;i <= _num;i++){
		$(".daFenImg_"+i).attr("src","../images/proscenium/dafen_12.jpg");
	}
	return _num;
}