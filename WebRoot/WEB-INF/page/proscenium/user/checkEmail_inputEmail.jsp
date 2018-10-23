<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/checkEmail.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/checkEmail.js" charset="GBK"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;验证邮箱</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="checkEmail_title">
    				<span>验证邮箱</span>
    			</div>
    			<div class="checkEmail_content">
    				<div class="content_top">
    					<ul>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/checkEmail_21.jpg"/></li>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/checkEmail_22.jpg"/></li>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/checkEmail_23.jpg"/></li>
    					</ul>
    				</div>
    				<div class="content_main">
    					<form action="${pageContext.request.contextPath }/email/sendEmail_inputEmail.action" method="post" id="inputMailForm">
    						<table border="0" cellpadding="5">
    							<tr>
    								<td width="23%" align="right">您注册邮箱为：</td>
    								<td width="30%"><div id="registEmail">${user.userEmail }</div></td>
    								<td></td>
    							</tr>
    							<tr>
    								<td align="right">输入验证邮箱:</td>
    								<td ><input type="text" name="email"/></td>
    								<td><div class="email_prompt"></div></td>
    							</tr>
    							<tr>
    								<td></td>
    								<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/checkEmailSubmit.jpg"/></td>
    								<td></td>
    							</tr>
    						</table>
    					</form>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
