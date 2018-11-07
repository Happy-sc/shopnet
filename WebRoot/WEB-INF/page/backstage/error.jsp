<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/SuccessError.css" type="text/css"></link>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">失败提示</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div class="error_main">
     		<div class="title">
    			<span class="eszm">P</span><span class="hzm">AI</span>
   	 			<span  class="eszm">X</span><span class="hzm">IE</span>
    			<span  class="eszm">N</span><span class="hzm">ET</span>
    			<span class="tsym">提示页面</span>
  	 		</div>
   			<div class="hr"></div>
    		<div class="content">
    			<div class="content_top">
    				<span class="error"><b>ERROR—404</b></span>
    			</div>
    			<div class="content_content">
    				<span class="tips">您没有登录,请先登录后操作...</span>
    				<span>点击：</span>
    				<a href="/manager/manager_enterLoginUI.action" target="_top" class="error">登录</a>
    			</div>
    		</div>
    		<div class="hr"></div>
    		<div class="bottom">
    			<a href="">
    				<img src="${pageContext.request.contextPath}/images/backstage/fhsy.jpg" />
    			</a>
   			</div>
     	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
