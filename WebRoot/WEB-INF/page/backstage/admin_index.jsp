<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0"> 
		
		<title>购物网站信息管理系统</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/adminIndex.css" type="text/css"></link>
	</head>
	<frameset rows="64,*"  frameborder="NO" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath }/adminIndex/toAdmin_toAdminTop.action" noresize="noresize" frameborder="0" name="topFrame" scrolling="no" marginwidth="0" marginheight="0"/>
 		<frameset cols="185,*"  rows="560,*" id="frame">
			<frame src="${pageContext.request.contextPath }/adminIndex/toAdmin_toAdminLeft.action" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"/>
			<frame src="${pageContext.request.contextPath }/adminIndex/toAdmin_toAdminRight.action" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto"/>
  		</frameset>
  	</frameset>
  <body>
 </body>
</html>
