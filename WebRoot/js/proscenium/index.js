
//tab“≥√Ê«–ªª
function setTab(name, num, n) {
	for (i = 1; i <= n; i++) {
		var menu = document.getElementById(name + i);
		var con = document.getElementById(name + "_" + "con" + i);
		var tabli = "one"+i;
		tabli.className = "tabli";
		menu.className = i == num ? "now" : "";
		con.style.display = i == num ? "block" : "none";
	}
}

jQuery(document).ready(function(){
	//‘À∂Ø–¨Õº∆¨
	jQuery("#allSneakers").hover(
		//∑≈‘⁄Õº∆¨…œ
		function(){
			jQuery(this).attr("src","../images/proscenium/allSneakers_02.jpg");
		},
		//¿Îø™Õº∆¨
		function(){
			jQuery(this).attr("src","../images/proscenium/allSneakers_01.jpg");
		}
	)
	
	//≈Æ–¨Õº∆¨
	jQuery("#allWomenShoes").hover(
		function(){
			jQuery(this).attr("src","../images/proscenium/allWomenShoes_02.jpg");
		},
		function(){
			jQuery(this).attr("src","../images/proscenium/allWomenShoes_01.jpg");
		}
	),
	
	//ƒ––¨Õº∆¨
	jQuery("#allMenShoes").hover(
		function(){
			jQuery(this).attr("src","../images/proscenium/allMenShoes_02.jpg");
		},
		function(){
			jQuery(this).attr("src","../images/proscenium/allMenShoes_01.jpg");
		}
	),
	
	//∂˘ÕØ–¨
	jQuery("#allChildrenShoes").hover(
		function(){
			jQuery(this).attr("src","../images/proscenium/allChildrenShoes_02.jpg");
		},
		function(){
			jQuery(this).attr("src","../images/proscenium/allChildrenShoes_01.jpg");
		}
	),
	
	//ªßÕ‚–¨
	jQuery("#allOutdoorShoes").hover(
		function(){
			jQuery(this).attr("src","../images/proscenium/allOutdoorShoes_02.jpg");
		},
		function(){
			jQuery(this).attr("src","../images/proscenium/allOutdoorShoes_02.jpg");
		}
	),
	
	/**
	 * ”“±ﬂµƒ∑÷¿‡£∫categoty.jsp
	 */
	jQuery("#index_category_left>ul>li").hover(	
		function(){
			jQuery(this).css("background-color","#F2F2F2");
			jQuery(this).css("border-top","1px solid #CCCCCC");
			jQuery(this).css("border-bottom","1px solid #CCCCCC");
			jQuery(this).css("border-left","1px solid #CCCCCC");
			jQuery(this).children().find(".xytp").remove();
			jQuery(this).children().eq(0).css("border","0");
			jQuery(this).children().eq(1).show();
		},
		function(){
			var string = jQuery(this).attr("class");
			var length = string.length;
			var title = string.substring(14,length);
			var newTitle = title+"Detail";
			jQuery(this).css("background-color","#FFFFFF");
			jQuery(this).parent().css("border-right","1px solid #CCCCCC");
			jQuery(this).css("border-right","1px solid #CCCCCC");
			jQuery(this).css("border","0");
			jQuery(this).css("border-bottom","1px dashed #CCCCCC");
			jQuery(this).children().find(".flmcTd").after("<td align='right' class='xytp'><img src='../images/proscenium/index_category.jpg'/></td>");
			jQuery("."+newTitle).hide();
		}
	)	
})

