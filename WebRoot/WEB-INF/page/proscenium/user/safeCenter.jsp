<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/safeCenter.css" type="text/css"></link>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="safeCenter_title">
    				<span>安全中心</span>
    			</div>
    			<div class="safeCenter_content">
    				<div class="safeCenter_baseInfor">
    					<span>您的基本信息</span>
    					<ul>
    						
    						<li>登&nbsp;陆&nbsp;邮&nbsp;箱：${user.userEmail }&nbsp;&nbsp;&nbsp;&nbsp;
    							<c:choose>
    								<c:when test="${user.isActivate==1}">
    									<span style="font-size: 14px;color: #079117;">已验证</span>
    									<a href="${pageContext.request.contextPath }/userCenter/safeCenter_updateEmailUI.action" class="safeCenter" target="_self">
    										(修改)
    									</a>
    								</c:when>
    								<c:otherwise>
    									
    									<span style="font-size:14px;color:red;">未验证</span>
    									<a href="${pageContext.request.contextPath }/userCenter/safeCenter_enterCheckIdentity.action" class="safeCenter" target="_self">
    										(验证)
    									</a>
    								</c:otherwise>
    							</c:choose>
    						</li>
    						<li>手&nbsp;机&nbsp;号&nbsp;码：
    							<c:choose>
    								<c:when test="${user.userTelephone==null}">
    									<span style="font-size:14px;color:red;">无</span>&nbsp;&nbsp;&nbsp;&nbsp;
    									<a href="" class="safeCenter" target="_self">
    										绑定手机
    									</a>
    								</c:when>
    								<c:otherwise>
    									${user.userTelephone }&nbsp;&nbsp;&nbsp;&nbsp;
    									<a href="" class="safeCenter" target="_self">
    										修改
    									</a>
    								</c:otherwise>
    							</c:choose>
    						</li>
    					</ul>
    				</div>
    				<div class="safeCenter_safeService">
    					<span>您的安全服务</span>
    					<ul>
    						<li>
    							<ul class="safeService_password">
    								<li class="title"><img src="${pageContext.request.contextPath }/images/proscenium/safeCenter_1.jpg"/></li>
    								<li class="left">登&nbsp;陆&nbsp;密&nbsp;码</li>
    								<li class="middle">互联网账号存在被盗风险，建议您定期更改密码以保护账户安全。</li>
    								<li class="right">
    									<a href="${pageContext.request.contextPath }/userCenter/safeCenter_enterPassword.action" target="_self" class="safeCenter">
    										修改
    									</a>
    								</li>
    							</ul>
    						</li>
    						<li>
    							<ul class="safeService_secret">
    								<li class="title">
    									<c:choose>
    										<c:when test="${secret==0}">
    											<img src="${pageContext.request.contextPath }/images/proscenium/safeCenter_0.jpg"/>
    										</c:when>
    										<c:otherwise>
    											<img src="${pageContext.request.contextPath }/images/proscenium/safeCenter_1.jpg"/>
    										</c:otherwise>
    									</c:choose>
    								</li>
    								<li class="left">密&nbsp;保&nbsp;问&nbsp;题</li>
    								<li class="middle">建议您设置一个容易记住，且不容易被他人获取的问题及答案，更有效保障您的密码安全。</li>
    								<li class="right">
    									<a href="${pageContext.request.contextPath }/userCenter/safeCenter_enterScreteSecurity.action" class="safeCenter" target="_self">
    										设置
    									</a>
    								</li>
    							</ul>
    						</li>
    						<li>
    							<ul class="safeService_email">
    								<li class="title">
    									<c:choose>
    										<c:when test="${user.isActivate==1}">
    											<img src="${pageContext.request.contextPath }/images/proscenium/safeCenter_1.jpg"/>
    										</c:when>
    										<c:otherwise>
    											<img src="${pageContext.request.contextPath }/images/proscenium/safeCenter_0.jpg"/>
    										</c:otherwise>
    									</c:choose>
    								</li>
    								<li class="left">验&nbsp;证&nbsp;邮&nbsp;箱</li>
    								<li class="middle">验证后，您可以享受丰富的邮箱服务，如邮箱登陆，邮箱找回密码，订单信息，最新动态等</li>
    								<li class="right">
    									<c:choose>
    										<c:when test="${user.isActivate==1}">
    											<a href="${pageContext.request.contextPath }/userCenter/safeCenter_updateEmailUI.action" class="safeCenter" target="_self">
    												修改
    											</a>
    										</c:when>
    										<c:otherwise>
    											<a href="${pageContext.request.contextPath }/userCenter/safeCenter_enterCheckIdentity.action" class="safeCenter" target="_self">
    												验证
    											</a>
    										</c:otherwise>
    									</c:choose>
    								</li>
    							</ul>
    						</li>
    						<li>
    							<ul class="safeService_telephone">
    								<li class="title"><img src="${pageContext.request.contextPath }/images/proscenium/safeCenter_0.jpg"/></li>
    								<li class="left">手&nbsp;机&nbsp;绑&nbsp;定</li>
    								<li class="middle">绑定手机后，您即可享受淘宝丰富的手机服务，如手机登录、手机找回密码、开通手机动态密码等。</li>
    								<li class="right">
    									<a href="" class="safeCenter">
    										绑定
    									</a>
    								</li>
    							</ul>
    						</li>
    					</ul>
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

