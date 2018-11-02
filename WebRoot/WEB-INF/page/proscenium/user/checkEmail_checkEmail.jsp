<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    		<br><a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;
    			<c:choose>
    				<c:when test="${type=='update'||type=='updateSend'}">
    					修改邮箱
    				</c:when>
    				<c:otherwise>
    					验证邮箱
    				</c:otherwise>
    			</c:choose>
    		</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="checkEmail_title">
    				<span>
					<c:choose>
    					<c:when test="${type=='update'||type=='updateSend'}">
    						修改邮箱
    					</c:when>
    					<c:otherwise>
    						验证邮箱
    					</c:otherwise>
    				</c:choose>
					</span>
    			</div>
    			<div class="checkEmail_content">
    				<div class="content_top">
    					<ul>
    					<c:choose>
    						<c:when test="${type=='update'}">
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_11.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_12.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_13.jpg"/></li>
    						</c:when>
    						<c:when test="${type=='updateSend'}">
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_21.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_22.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/updateEmail_23.jpg"/></li>
    						</c:when>
    						<c:otherwise>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/checkEmail_21.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/checkEmail_22.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/checkEmail_23.jpg"/></li>
    							</c:otherwise>
    					</c:choose>
    						
    					</ul>
    				</div>
    				<div class="content_main">
    					<ul>
    						<li>
    							<span class="sended">已发送邮件至:</span>
    							<span class="email">${email }</span>
    							<span class="pleaseCheck">请立即完成验证,邮箱验证不通过,则验证失败</span>
    						</li>
    						<li>
    							<span class="remind">验证邮箱24小时内有效,请尽快登陆您的邮箱点击验证链接完成验证</span>
    						</li>
    						<li>
    							<a href="${emailURL }" target="_blank">
    								<img src="${pageContext.request.contextPath }/images/proscenium/checkEmailLoadEmail.jpg"/>
    							</a>
    						</li>
    					</ul>
    				</div>
    				<div class="content_bottom">
    					<span class="noAccept">没有收到</span><br/>
    					<span>1.请检查您的垃圾邮箱或广告邮箱，邮件可能被误认为垃圾邮件或广告邮件</span><br/>
    					<span>2.如果垃圾邮箱或广告邮箱中没有，请尝试将chenssy995812509@163.com添加到白名单，并且
    					<c:choose>
    						<c:when test="${type=='update'}">
    							<a href="${pageContext.request.contextPath }/userCenter/safeCenter_updateIdentity.action?password=">
    								<img src="${pageContext.request.contextPath }/images/proscenium/checkEmailRE.jpg"/>
    							</a>
    						</c:when>
    						<c:when test="${type=='updateSend'}">
    							<a href="${pageContext.request.contextPath }/userCenter/safeCenter_updateSendEmail.action?email=${email }">
    								<img src="${pageContext.request.contextPath }/images/proscenium/checkEmailRE.jpg"/>
    							</a>
    						</c:when>
    						<c:otherwise>
    							<a href="${pageContext.request.contextPath }/userCenter/safeCenter_checkEmail.action?email=${email }">
    								<img src="${pageContext.request.contextPath }/images/proscenium/checkEmailRE.jpg"/>
    							</a>
    						</c:otherwise>
    					</c:choose>
    						
    					</span>
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
