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
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_21.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_22.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_23.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_24.jpg"/></li>
  			</ul>
  			<table border="0" id="sendCheckEmail" cellspacing="10">
  				<tr>
  					<td align="right" width="20%">验证身份方式：</td>
  					<td>
  						<select>
  							<option>邮箱</option>
  						</select>
  					</td>
  				</tr>
  				<tr>
  					<td align="right">用户名：</td>
  					<td><font>${cUser.userName }</font></td>
  				</tr>
  				<tr>
  					<td align="right" >邮箱地址：</td>
  					<td><font>${cUser.userEmail }</font></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td>
  						<a href="${pageContext.request.contextPath }/users/forgetPassword_sendCheckEmail.action?userName=${cUser.userName}&email=${cUser.userEmail}">
  							<img src="${pageContext.request.contextPath }/images/proscenium/checkEmailSubmit.jpg"/>
  						</a>
  					</td>
  				</tr>
  			</table>
  		</div>
  	</div>
  	<div id="bottom">
  		<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp"></jsp:include>
  	</div>
  </body>
</html>
