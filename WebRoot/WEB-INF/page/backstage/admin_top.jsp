<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/adminIndex.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/adminTop.js" charset="utf-8"></script>
  </head>
  <body leftmargin="0" topmargin="0">
  <table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64">
    	<table height="100%" border="0">
    		<tr height="32">
    			<td rowspan="2" valign="top"><img src="${pageContext.request.contextPath}/images/backstage/adminTopLogo.jpg"/></td>
    			<td valign="bottom"><font color="#FFFFFF" size="3px"><b>购物网站信息管理系统</b></font></td>
    		</tr>
    		<tr>
    			<td valign="top"></td>
    		</tr>
    	</table>
    </td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt"><b>${worker.workerName}</b> 您好,感谢登陆使用购物网信息管理系统！</td>
        <td width="22%"><a href="javascript:void(0);" target="_top" onClick="exitSystem();"><img src="${pageContext.request.contextPath }/images/backstage/out.gif" alt="安全退出" width="46" height="20" border="0"></a></td>
        <td width="4%">&nbsp;</td>
      </tr>
      <tr>
        <td height="19" colspan="3" align="right"><div class="getTime"></div></td>
        </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
