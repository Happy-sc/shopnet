<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/checkEmail.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/checkEmail.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;修改邮箱</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="checkEmail_title">
    				<span>修改邮箱</span>
    			</div>
    			<div class="checkEmail_content">
    				<div class="content_top">
    					<ul>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_11.jpg"/></li>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_12.jpg"/></li>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_13.jpg"/></li>
    					</ul>
    				</div>
    				<div class="content_main">
    					<form action="${pageContext.request.contextPath }/userCenter/safeCenter_emailIdentity.action" method="post" id="passwordForm">
    						<table border="0" cellpadding="5">
    							<tr>
    								<td width="23%" align="right">已验证邮箱：</td>
    								<td align="left" width="30%"><span class="checkedEmail">${user.userEmail }</span></td>
    								<td></td>
    							</tr>
    							<tr>
    								<td width="23%" align="right">请输入登陆密码：</td>
    								<td align="left" width="30%"><input type="password" name="password"/></td>
    								<td><div class="password_prompt"></div></td>
    							</tr>
    							<tr>
    								<td><br><br></td>
    								<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/sendCheckEmailbtn.jpg"/></td>
    								<td><div style="color:red">${tips }</div></td>
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