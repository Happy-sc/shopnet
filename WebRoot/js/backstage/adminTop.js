function exitSystem(){
	var flag = confirm("您确定要退出系统吗？");
	if (flag){
        window.top.location.href = "/manager/manager_exitSystem.action";
	}
	return false;
}

function showTime(){
	var url = "/getTime/getTime.action";
	$.get(url,
		function(data){
			$(".getTime").html(data);
		}
	)
	setTimeout("showTime();",1000);
}
window.onload = setTimeout("showTime();",1000);

