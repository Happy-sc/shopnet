<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
  	<title>拍鞋购物商城_用户注册</title>
   	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userRegist.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/userRegist.js" charset="GBK"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div id="userRegist">
    		<div id="regist_title">
    			<span class="title_text">注册拍鞋商城...</span>
    		</div>
    		<div id="regist_image">
    			<ul>
    				<li id="regist_image_left"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_11.jpg"/></li>
    				<li id="regist_image_mid"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_12.jpg"/></li>
    				<li id="regist_image_right"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_13.jpg"/></li>
    			</ul>
    		</div>
    		<div id="regist_content">
    			<s:form action="usersRegist_userRegist.action" namespace="/users" method="POST" onsubmit="return checkUsers();">
    				<table id="regist_table" border="0">
    				<tr>
    					<td align="right" width="25%">用户名：</td>
    					<td align="left" width="28%">
    						<input type="text" class="regist_input" id="userName" name="users.userName" onblur="userNameBlur()" onfocus="userNameFocus()"/>
    					</td>
    					<td><div id="userName_prompt"></div></td>
    				</tr>
    				<tr>
    					<td align="right">登录密码：</td>
    					<td align="left">
    						<input type="password" class="regist_input" id="password" name="users.userPassword" onblur="passwordBlur()" onfocus="passwordFocus()"/>
    					</td>
    					<td><div id="password_prompt"></div></td>
    				</tr>
    				<tr>
    					<td align="right">确认密码：</td>
    					<td align="left">
    						<input type="password" class="regist_input" id="repassword"  onblur="repasswordBlur()" onfocus="repasswordFocus()"/>
    					</td>
    					<td><div id="repassword_prompt"></div></td>
    				</tr>
    				<tr>
    					<td align="right">验证码：</td>
    					<td align="left">
    						<input type="text" class="regist_input" id="autoImage" onblur="authImageBlur()" onfocus="authImageFocus()"/>
    					</td>
    					<td><div id="authImage_prompt"></div></td>
    				</tr>
    				<tr>
    					<td></td>
    					<td colspan="2" >
    						<img src="${pageContext.request.contextPath}/users/authImage.action" id="authImage"
    							 title="点击更换验证码" onclick="changeImage()">
    						看不清?<a href="javascript:changeImage();">换装图片</a>
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    						<input type="image" src="${pageContext.request.contextPath}/images/proscenium/regist_submit_01.jpg"
    						       id="registSubmit_btn" onmousemove="registSubmit_over()" onmouseout="registSubmit_out()">
    					</td>
    					<td></td>
    				</tr>
    			</table>
    			</s:form>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
