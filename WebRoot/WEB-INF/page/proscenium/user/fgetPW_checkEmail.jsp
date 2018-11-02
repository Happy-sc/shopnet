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
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_21.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_22.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_23.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_24.jpg"/></li>
  			</ul>
  			<ul class="font">
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/safeCenterSuccess.jpg"/></li>
  				<li>验证邮件已经发送,请您<a href="${email }" class="dlyx">登录邮箱</a>完成验证</li>
  				<li><a href="${pageContext.request.contextPath }/users/forgetPassword_checkEmail.action?userName=chenssy"></a></li>
  			</ul>
  		</div>
  	</div>
  	<div id="bottom">
  		<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp"></jsp:include>
  	</div>
  </body>
</html>
