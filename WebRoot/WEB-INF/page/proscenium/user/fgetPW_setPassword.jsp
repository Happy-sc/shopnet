<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>找回密码</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/forgetPassword.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/forgetPassword.js" charset="UTF-8"></script>
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
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_31.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_32.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_33.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_24.jpg"/></li>
  			</ul>
  			<form action="${pageContext.request.contextPath }/users/forgetPassword_setNewPassword.action" method="post">
  			<table border="0" id="setPassword">
  				<tr>
  					<td align="right" width="13%">新登录密码：</td>
  					<td width="30%">
  						<input type="password" name="newPassword"/>
  					</td>
  					<td><div id="newPassword_prompt"></div></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td align="right" >确认新密码：</td>
  					<td><input type="password" name="reNewPassword"/></td>
  					<td><div id="reNewPassword_prompt"></div></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td><input type="hidden" value="${userName}" name="userName"/></td>
  					<td>
  						<input type="image" src="${pageContext.request.contextPath }/images/proscenium/tijiao.jpg"/>
  					</td>
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
