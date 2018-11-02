<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>拍鞋网---找回密码</title>
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
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_41.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_42.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_43.jpg"/></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/foundPW_44.jpg"/></li>
  			</ul>
  			<ul class="success">
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/safeCenterSuccess.jpg"/></li>
  				<li>
  					<font>新密码设置成功!</font>
  					<br/>请牢记您新设置的密码。
  					<a href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action" " class="dlyx">返回首页</a>&nbsp;&nbsp;&nbsp;
  					<a href="${pageContext.request.contextPath}/users/usersLogin_userLoginUI.action" class="dlyx">登陆</a>
  				</li>
  			</ul>
  		</div>
  	</div>
  	<div id="bottom">
  		<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp"></jsp:include>
  	</div>
  </body>
</html>
