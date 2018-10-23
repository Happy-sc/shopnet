<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>拍鞋网---找回密码</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/forgetPassword.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/forgetPassword.js" charset="GBK"></script>
  </head>
  
  <body>
  	<div id="top">
  		<div id="top_top">
  			<jsp:include page="/WEB-INF/page/proscenium/index_topT.jsp"></jsp:include>
  		</div>
  		<div id="top_img">
  			<img src="${pageContext.request.contextPath }/images/proscenium/paixie.jpg"/>
  		</div>
  	</div>
  	<div id="main">
  		<div class="title">
  			<font>找回密码</font>
  		</div>
  		<div class="content">
  			<ul>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_11.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_12.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_13.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_14.jpg"/></li>
  			</ul>
  			<form action="${pageContext.request.contextPath }/users/forgetPassword_checkIdentity.action" method="post" id="checkIdentityForm">
  			<table border="0">
  				<tr>
  					<td align="right">账户名:</td>
  					<td><input type="text"  class="yhm" name="userName" value="输入用户名/邮箱"/></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td><div class="error_prompt" id="userName">${userFlag}</div></td>
  				</tr>
  				<tr>
  					<td align="right" >验证码:</td>
  					<td>
  						<input type="text" class="yzm" name="checkCode"/>
  						<img src="${pageContext.request.contextPath}/authImage/authImage_1.action" id="checkCode"/>
  						看不清？<a href="javascript:void(0);" id="hyzyzm">换一张</a>
  					</td>
  				</tr>
  				<tr>
  					<td></td>
  					<td><div class="error_prompt" id="checkCode">${checkCodeFlag}</div></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/xiayibu.jpg" /></td>
  				</tr>
  			</table>
  			</form>
  		</div>
  	</div>
  	<div id="bottom">
  		<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp"></jsp:include>
  	</div>
  </body>
</html>
