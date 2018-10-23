<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/noticeManager.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage/noticeManager.js" charset="GBK"></script>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">公告管理</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div id="main_content_top"> 
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增加公告 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</div>
    		<div id="main_content_main">
    			<form action="${pageContext.request.contextPath}/systemManager/noticeManager_saveUpdateNotice.action" method="post" id="noticeForm">
    			<div id="editorNotice">
    				<ul class="noticeUL">
    					<li class="title">公告主题</li>
    					<li>
    						<input type="hidden" value="${type}" name="type"/>
    						<input type="hidden" value="${notice.noticeId}" name="notice.noticeId"/>
    						<input type="hidden" value="${notice.noticeType}" id="_type"/>
    						<input type="hidden" value="${page}" name="page"/>
    						<input type="text" id="noticeTitle" class="noticeTitle" name="notice.noticeTitle" value="${notice.noticeTitle}">&nbsp;&nbsp;&nbsp;&nbsp;
    						<font>发布时间：</font><input type="text" value="${nowTime }" name="notice.noticeTime" readonly="readonly">	
    						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    						<font>发布人：</font>${worker.workerName }
    					</li>
    					<li class="title">公告内容</li>
    					<li>
    						<textarea rows="12" cols="112" name="noticeContent">${notice.noticeContent}</textarea>
    					</li>
    					<li class="title">
    						公告类型
    						<select name="notice.noticeType" id="noticeType">
    							<option value="-1">--请选择--</option>
    							<option value="1">--站内--</option>
    							<option value="2">--站外--</option>
    						</select>
    						<div id="noticePrompt"></div>
    					</li>
    					<li style="text-align:center;">
    						<input type="image" src="${pageContext.request.contextPath}/images/backstage/fbgg.jpg" id="fbggBtn"/>
    					</li>
    				</ul>
    			</div>
    			</form>
    		</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
<script type="text/javascript">
	window.onload =function(){
		CKEDITOR.replace('noticeContent',
		{
			toolbar :[
             	['Styles','Format','Font','FontSize'],
                ['Bold','Italic','Underline'],
                ['TextColor','BGColor'],
                ['NumberedList','BulletedList','-','Outdent','Indent'],
                ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
                ['Link','Unlink'],
                ['Image','Table'],   
             ]
		});
	};
</script>
</html>