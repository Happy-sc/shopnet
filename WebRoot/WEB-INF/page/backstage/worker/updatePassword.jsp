<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/updatePassword.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/updatePassword.js" charset="UTF-8"></script>
  </head>

  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">修改密码</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div id="">
    		<form action="${pageContext.request.contextPath }/workerInfo/workerInfo_updatePassword.action" id="updataPWForm">
    			<table border="0" id="updatePassword" cellpadding="10">
    				<tr>
    					<td align="right" width="15%">旧密码:</td>
    					<td align="left" width="1%">
    						<input type="password" id="oldPassword" class="passwordText" name="oldPassword"/>
    					</td>
    					<td><div id="oldPrompt"></div></td>
    				</tr>
    				<tr>
    					<td align="right">新密码:</td>
    					<td align="left">
    						<input type="password" id="newPassword" class="passwordText" name="newPassword"/>
    					</td>
    					<td width="43%"><div id="newPrompt"></div></td>
    				</tr>
    				<tr>
    					<td align="right">再输一次新密码:</td>
    					<td align="left">
    						<input type="password" id="reNewPassword" class="passwordText"/>
    					</td>
    					<td><div id="reNewPrompt"></div></td>
    				</tr>
    				<tr>
    					<td colspan="3">
    						<div id="errorMessage">
    							${message }
    						</div>
    						<div id="image_btn">
    							<input type="image" id="updatePWS" src="${pageContext.request.contextPath }/images/backstage/updateS_01.jpg"/>
    						</div>
    					</td>
    				</tr>
    			</table>
    		</form>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
