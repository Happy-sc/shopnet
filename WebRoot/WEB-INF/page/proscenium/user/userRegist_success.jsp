<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
	<title>注册成功</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userRegist.css" type="text/css"></link>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="registSuccess">
    		<div >
    			<div id="regist_title">
    				<span class="title_text">注册成功</span>
    			</div>
    			<div id="regist_image">
    				<ul>
    					<li id="regist_image_left"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_31.jpg"/></li>
    					<li id="regist_image_mid"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_32.jpg"/></li>
    					<li id="regist_image_right"><img src="${pageContext.request.contextPath}/images/proscenium/userregist_33.jpg"/></li>
    				</ul>
    			</div>
    			<div id="registSuccess">
    				<table cellpadding="5">
    					<tr>
    						<td><img src="${pageContext.request.contextPath}/images/proscenium/registSuccess.jpg"/></td>
    						<td><font class="successText">恭喜您,注册成功!</font>
    							<a class="indexA" href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action">去首页看看</a>
    						</td>
    					</tr>
    					<tr>
    						<td></td>
    						<td>您的账户名为：<span>${user.userName }</span></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td>你的注册邮箱为：<span>${user.userEmail}</span></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td><span style="color:red">为了您账号的安全,请您务必在24小之内完成邮箱验证!</span>
    							<a href="${emailURL}" target="_blank">
    								<img src="${pageContext.request.contextPath }/images/proscenium/checkEmailLoadEmail.jpg"/>
    							</a>
    						</td>
    					</tr>
    				</table>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
