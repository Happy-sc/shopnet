<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterUpdatePW.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/passwordStrength.js" charset="UTF-8"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/userCenterUpdatePW.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;修改密码</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="updatePW_title">
    				<span>修改密码</span>
    			</div>
    			<div class="updatePW_content">
    				<form action="${pageContext.request.contextPath }/userCenter/safeCenter_updatePassword.action" id="updatePW" method="post">
    					<table cellspacing="10" border="0">
    					<tr>
    						<td align="right" width="15%">旧密码：</td>
    						<td align="left" width="32%"><input type="password" class="PWText" name="oldPassword" id="oldPassword"/></td>
    						<td align="left"><div id="oldPW_prompt"><span>*&nbsp;</span>请输入旧密码</div></td>
    					</tr>
    					<tr>
    						<td align="right">新密码：</td>
    						<td align="left"><input type="password" class="PWText" name="newPassword" id="newPassword"/></td>
    						<td align="left"><div id="newPW_prompt"><span>*&nbsp;</span>密码为6-16位数字和字母注册,区分大小写</div></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td>
    							<ul>
    								<li class="strenght_L"><img src="${pageContext.request.contextPath }/images/proscenium/safeLevelruo_01.jpg"/></li>
    								<li class="strenght_M"><img src="${pageContext.request.contextPath }/images/proscenium/safeLevelzhong_01.jpg"/></li>
    								<li class="strenght_H"><img src="${pageContext.request.contextPath }/images/proscenium/safeLevelqiang_01.jpg"/></li>
    							</ul>
    						</td>
    						<td></td>
    					</tr>
    					<tr>
    						<td align="right">重新输入新密码：</td>
    						<td align="left"><input type="password" class="PWText" id="newRePassword"/></td>
    						<td align="left"><div id="newRePW_prompt"><span>*&nbsp;</span>再输入一次新密码</div></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td><input type="image"/ src="${pageContext.request.contextPath }/images/proscenium/userCenterUpdatebtn.jpg"></td>
    						<td><div class="error_prompt">${tips }</div></td>
    					</tr>
    				</table>
    				</form>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
