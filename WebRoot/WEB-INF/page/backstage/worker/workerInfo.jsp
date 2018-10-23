<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/adminIndex.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/workerInfor.css" type="text/css"></link>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">基本信息</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div id="content">
    		<table border="0" id="workerInfor" cellSpacing=0 cellPadding=0>
    			<tr>
    				<td align="right" width="15%">编&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
    				<td align="left" width="24%" class="hrBorder">&nbsp;${worker.workerId }</td>
    				<td align="right" width="15%">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
    				<td align="left" width="24%" class="hrBorder">&nbsp;${worker.workerName }</td>
    				<td rowspan="4">
    					<div id="main_image">
   							<img alt="头像" src="${worker.workerImage}" width="150px" height="150px">
   						</div>
   					</td>
   				</tr>    				
   				<tr>
    				<td align="right">身&nbsp;份&nbsp;证:</td>
    				<td align="left" class="hrBorder">&nbsp;${worker.workerIdcard}</td>
    				<td align="right">出生日期:</td>
    				<td align="left" class="hrBorder">&nbsp;${worker.workerBirthday}</td>
   				</tr>
  				<tr>
   					<td align="right">联系电话:</td>
    				<td align="left" class="hrBorder">&nbsp;${worker.workerPhone}</td>
    				<td align="right">职&nbsp;&nbsp;&nbsp;&nbsp;务:</td>
    				<td align="left" class="hrBorder">&nbsp;${worker.position.positionName}</td>
    			</tr>
    			<tr>
    				<td align="right" class="addhr1">住&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
    				<td align="left" colspan="3" class="addhr">&nbsp;${worker.workerAddress}</td>
    			</tr>
    		</table>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
