function exitSystem(){
	var flag = confirm("��ȷ��Ҫ�˳�ϵͳ��");
	if (flag)
		location.href = "/manager/manager_exitSystem.action";
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

