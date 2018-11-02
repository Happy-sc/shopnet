$(document).ready(function(){
	//根据分类获取款式
	$("#category").change(function(){
		var categoryId = $("#category").val();
		var url = "../goodsManager/goodsManager_getStyle.action";
		$.get(url,{
			categoryId:categoryId
		},function(data){
			$("#style").html(data);
		})
	})
	
	//根据款式获取品牌
	$("#style").change(function(){
		var styleId = $("#style").val();
		var url = "../goodsManager/goodsManager_getBrand.action";
		$.get(url,{
			styleId:styleId
		},function(data){
			$("#brand").html(data);
		})
	})
	
	//点击添加商品
	$("#addGoodsForm").submit(function(){
		var goodsName = $("#goodsName");
		var goodsMarket = $("#goodsMarket");
		var goodsGrounding = $("#goodsGrounding");
		var storage = $("#storage");
		var goodsShjj = $("#goodsShjj");
		var goodsXmcz = $("#goodsXmcz");
		var goodsXdcz = $("#goodsXdcz");
		var goodsBhfs = $("#goodsBhfs");
		var goodsToecap = $("#goodsToecap");
		var goodsIsRecommend = $("#goodsIsRecommend");
		var goodsImage = $("#goodsImage");
		var goodsHeight = $("#goodsHeight");
		var goodsLength = $("#goodsLength");
		var goodsWeight = $("#goodsWeight");
		var goodsMarketPrice = $("#goodsMarketPrice");
		var goodsPaiPrice = $("#goodsPaiPrice");
		var goodsBid = $("#goodsBid");
		var category = $("#category");
		var style = $("#style");
		var brand = $("#brand");
		var error_prompt = $("#error_prompt");
		if(goodsName.val()==""){
			error_prompt.html("商品名称不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsName.css("border","1px solid red");
			return false;
		}
	
		if(goodsMarket.val()==""){
			error_prompt.html("上市时间不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsMarket.css("border","1px solid red");
			return false;
		}
		if(goodsGrounding.val()==""){
			error_prompt.html("上架时间不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsGrounding.css("border","1px solid red");
			return false;
		}
		if(storage.val()=="-1"){
			error_prompt.html("所在仓库不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			storage.css("border","1px solid red");
			return false;
		}	
		if(goodsShjj.val()=="-1"){
			error_prompt.html("适合季节不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsShjj.css("border","1px solid red");
			return false;
		}
		if(goodsXmcz.val()==""){
			error_prompt.html("鞋面材质不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsXmcz.css("border","1px solid red");
			return false;
		}
		if(goodsXdcz.val()==""){
			error_prompt.html("鞋底材质不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsXdcz.css("border","1px solid red");
			return false;
		}
		if(goodsBhfs.val()=="-1"){
			error_prompt.html("闭合方式不能为空,请选择....");
			error_prompt.attr("class","prompt_error");
			goodsBhfs.css("border","1px solid red");
			return false;
		}
		if(goodsToecap.val()==""){
			error_prompt.html("商品鞋头不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsToecap.css("border","1px solid red");
			return false;
		}
		if(goodsIsRecommend.val()=="-1"){
			error_prompt.html("是否推荐不能为空,请选择...");
			error_prompt.attr("class","prompt_error");
			goodsIsRecommend.css("border","1px solid red");
			return false;
		}
		if(goodsImage.val()==""){
			error_prompt.html("商品图片不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsImage.css("border","1px solid red");
			return false;
		}
		if(goodsHeight.val()==""){
			error_prompt.html("商品高度不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsHeight.css("border","1px solid red");
			return false;
		}
		if(goodsLength.val()==""){
			error_prompt.html("商品长度不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsLength.css("border","1px solid red");
			return false;
		}
		if(goodsWeight.val()==""){
			error_prompt.html("商品重量不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsWeight.css("border","1px solid red");
			return false;
		}
		if(goodsMarketPrice.val()==""){
			error_prompt.html("市场价不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsMarketPrice.css("border","1px solid red");
			return false;
		}                      
		if(goodsPaiPrice.val()==""){
			error_prompt.html("拍拍价不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsPaiPrice.css("border","1px solid red");
			return false;
		}
		if(goodsBid.val()==""){
			error_prompt.html("进价不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			goodsBid.css("border","1px solid red");
			return false;
		}
		if(category.val()=="-1"){
			error_prompt.html("商品分类不能为空,请选择...");
			error_prompt.attr("class","error_prompt");
			category.css("border","1px solid red");
			return false;
		}
		if(style.val()=="-1"){
			error_prompt.html("商品款式不能为空,请选择...");
			error_prompt.attr("class","error_prompt");
			style.css("border","1px solid red");
			return false;
		}
		if(brand.val()=="-1"){
			error_prompt.html("商品品牌不能为空,请选择...");
			error_prompt.attr("class","error_prompt");
			brand.css("border","1px solid red");
			return false;
		}
		return true;
	})
	
	//点击添加商品详情
	$("#TJSPXQ").click(function(){
		var color = $("#color").val();
		var attr = $("#attr").val();
		var number = $("#number").val();
		var error_prompt = $("#error_prompt");
		error_prompt.html("");
		if(color=="-1"){
			error_prompt.html("请选择商品颜色...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		if(attr=="-1"){
			error_prompt.html("商品属性不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		if(number==""){
			error_prompt.html("商品数量不能为空,请输入...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		var reg = /^\d+$/;
		if(reg.test(number)==false){
			error_prompt.html("商品数量格式错误,请重新输入...");
			error_prompt.attr("class","prompt_error");
			return;
		}
		var tr = $("<tr>" +                                                   
	           "<td align='center' width='40%'><input type='text' class='addInput' name='goodsColor.goodsColor' value='"+color+"' style='width:50%'></td>" +
	           "<td align='center'><input type='text' class='addInput' name='goodsSizeS.goodsAttr' value='"+attr+"'></td>" +
	           "<td align='center'><input type='text' class='addInput'  name='goodsSizeN.goodsNumber' value='"+number+"'></td>" +
	           "<td align='center'><a href='javascript:void(0);' onclick='this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode)'>删除</a></td></tr>");
	 	$("#goodsDetailTable").append(tr);
	})
	
	//点击保存商品详情
	$("#saveGoodsDetail").submit(function(){	
		var goodsImage = $("#goodsImage").val();
		var error_prompt = $("#error_prompt");
		error_prompt.html("");
		if(goodsImage==""){
			error_prompt.html("商品图片不能为空,请选择商品图片...");
			error_prompt.attr("class","prompt_error");
			return false;
		}
		return true;
	})
})


