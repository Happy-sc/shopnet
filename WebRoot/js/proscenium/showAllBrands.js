$(document).ready(function() {
	//当鼠标放在品牌右边的时候
	$(".brand_category ul li div img").hover(
		function(){
			var imgsrc = $(this).attr("src");
			var length = imgsrc.length;
			var newimgsrc = imgsrc.substring(0,length-5)+"2.jpg";
			$(this).attr("src",newimgsrc);
		},
		function(){
			var _class = $(this).attr("class");
			if(_class!="clicked"){
				var imgsrc = $(this).attr("src");
				var length = imgsrc.length;
				var newimgsrc = imgsrc.substring(0,length-5)+"1.jpg";
				$(this).attr("src",newimgsrc);
			}
		}),
	
	//点击右边的品牌
	$(".brand_category ul li div img").click(function(){
		var _li = $(this).parent().parent().parent().children();
		for(var i = 0;i < _li.length;i++){
			var _img = _li.eq(i).children().children();
			var length = _img.attr("src").length;
			var newimgsrc = _img.attr("src").substring(0,length-5)+"1.jpg";
			_img.attr("src",newimgsrc);
			_img.attr("class","noClick");
		}
		var tImgSrc = $(this).attr("src");
		var tLength = tImgSrc.length;
		var tNewImgSrc = tImgSrc.substring(0,tLength-5)+"2.jpg";
		$(this).attr("src",tNewImgSrc);
		$(this).attr("class","clicked");
	})
		
	//当鼠标放在品牌拼音上时
	$(".brandsSpell .spell table td img").hover(
		function(){
			var imgsrc = $(this).attr("src");
			var length = imgsrc.length;
			var newimgsrc = imgsrc.substring(0,length-5)+"2.jpg";
			$(this).attr("src",newimgsrc);
		},
		function(){
			var imgsrc = $(this).attr("src");
			var length = imgsrc.length;
			if($(this).attr("class")!="now"){
				var newimgsrc = imgsrc.substring(0,length-5)+"1.jpg";
				$(this).attr("src",newimgsrc);
			}
		}
	),
	
	//当点击品牌的拼音时
	$(".spell table td img").click(function(){
		$(".brands").children().hide();
		var id = $(this).attr("id");
		var _img = $(".brandsSpell .spell table img");
		for(var i = 0;i<_img.length;i++){
			var _src = _img.eq(i).attr("src");
			var _newSrc = _src.substring(0,_src.length-5)+"1.jpg";
			_img.eq(i).attr("src",_newSrc);
		}
		
		if(id=="quanbu"){
			$("#quanbu").attr("src","../images/proscenium/brands/quanbu_01.jpg");
			var imgsrc = $(this).attr("src");
			var length = imgsrc.length;
			var newimgsrc = imgsrc.substring(0,length-5)+"1.jpg";
			$(this).attr("src",newimgsrc);
			$(this).attr("class","now");
			$(".brands").children().show();
		}
		else{
			$("#quanbu").attr("src","../images/proscenium/brands/quanbu_02.jpg");
			var imgsrc = $(this).attr("src");
			var length = imgsrc.length;
			var newimgsrc = imgsrc.substring(0,length-5)+"2.jpg";
			$(this).attr("src",newimgsrc);
			$(this).attr("class","now");
			$(".brands_"+id).show();
		}
		
	}),
	
	//当点击右边的分类时
	$(".brand_category li div img").click(function(){
		
		$(".brand_main").children().hide();
		var _id = $(this).parent().parent().attr("class");
		$("."+_id+"Brands").show();
	})
	
})