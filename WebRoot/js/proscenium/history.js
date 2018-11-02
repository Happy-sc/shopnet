var historyp; 
//最新访问的商品编号ID 
var nid="新商品编号ID"; 
//设置cookie保存的浏览记录的条数 
var N=5; 
var count=0; 
//判断是否存在cookie 
if($.cookie('smile1314h')==null) //cookie 不存在 
{ 
	//创建新的cookie,保存浏览记录 
	$.cookie('smile1314h',nid,{expires:7,path:'/'}); 
} 
else //cookies已经存在 
{ 
	//获取浏览过的商品编号ID 
	historyp=$.cookie('smile1314h'); 
	var check_result = $('#latestp'); 
	check_result.html('<img src=/CSS/Image/Loading.gif style=/"margin-left:40px;;/">'); 
	//ajax 根据产品编号获取信息列表 
	$.ajax({ //一个Ajax过程 
		type: "get", 
		url : "/Comm/getLatestProduct.ashx", 
		dataType:'html', 
		data: "P_Id="+historyp, 
		success: function(json){ 
		check_result.html(""); 
		check_result.html(json); 
}}); 
//分解字符串为数组 
var pArray=historyp.split(','); 
//最新访问的商品编号放置载最前面 
historyp=nid; 
//判断是该商品编号是否存在于最近访问的记录里面 
for(var i=0;i<pArray.length;i++) 
{ 
if(pArray[i]!=nid) 
{ 
historyp=historyp+","+pArray[i]; 
count++; 
if(count==N-1) 
{ 
break; 
} 
} 
} 
//修改cookie的值 
$.cookie('smile1314h',historyp); 
} 