jQuery(document).ready(function(){
	//µã»÷µÇÂ¼
	jQuery("#login").click(
		function(){
			var thisURL = location.href;
			var URL = jQuery(this).attr("href");
			var newURL = URL+"?myURL="+thisURL;
			jQuery(this).attr("href",newURL);
	})
})