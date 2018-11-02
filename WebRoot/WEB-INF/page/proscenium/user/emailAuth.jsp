<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
	<title>绑定邮箱</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userRegist.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/userRegist.js" charset="UTF-8"></script>

  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="emailAuth">
    		<div >
    			<div id="regist_title">
    				<span class="title_text">绑定邮箱</span>
    			</div>
    			<div id="regist_image">
    				<ul>
    					<li id="regist_image_left"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_21.jpg"/></li>
    					<li id="regist_image_mid"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_22.jpg"/></li>
    					<li id="regist_image_right"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_23.jpg"/></li>
    				</ul>
    			</div>
    			<div id="email_content">
    				<s:form action="usersRegist_emailAuth.action" namespace="/users" method="post" onsubmit="return checkEmail()">
    					<table border="0" cellpadding="10" >
    						<tr>
    							<td width="20%" align="right"><span>你的电子邮箱:</span></td>
    							<td width="40%"><input type="text" id="email" name="email" onblur="emailBlur()" onfocus="emailFocus()"></td>
    							<td><div id="email_prompt"></div></td>
    						</tr>
    						<tr>
    							<td><input type="hidden" name="userId" value="<s:property value="#request.userId" />" /></td>
    							<td align="center"><input type="image" src="${pageContext.request.contextPath}/images/proscenium/email_submit.jpg" /></td>
    							<td></td>
    						</tr>
    					</table>
    				</s:form>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>