var historyp; 
//���·��ʵ���Ʒ���ID 
var nid="����Ʒ���ID"; 
//����cookie����������¼������ 
var N=5; 
var count=0; 
//�ж��Ƿ����cookie 
if($.cookie('smile1314h')==null) //cookie ������ 
{ 
	//�����µ�cookie,���������¼ 
	$.cookie('smile1314h',nid,{expires:7,path:'/'}); 
} 
else //cookies�Ѿ����� 
{ 
	//��ȡ���������Ʒ���ID 
	historyp=$.cookie('smile1314h'); 
	var check_result = $('#latestp'); 
	check_result.html('<img src=/CSS/Image/Loading.gif style=/"margin-left:40px;;/">'); 
	//ajax ���ݲ�Ʒ��Ż�ȡ��Ϣ�б� 
	$.ajax({ //һ��Ajax���� 
		type: "get", 
		url : "/Comm/getLatestProduct.ashx", 
		dataType:'html', 
		data: "P_Id="+historyp, 
		success: function(json){ 
		check_result.html(""); 
		check_result.html(json); 
}}); 
//�ֽ��ַ���Ϊ���� 
var pArray=historyp.split(','); 
//���·��ʵ���Ʒ��ŷ�������ǰ�� 
historyp=nid; 
//�ж��Ǹ���Ʒ����Ƿ������������ʵļ�¼���� 
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
//�޸�cookie��ֵ 
$.cookie('smile1314h',historyp); 
} 