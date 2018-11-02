<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>

  </head>
  
  <body>
    <div class="orderTop_main">
    	<div class="orderTop_right">
    		<ul>
    			<li class="text">
    				<span>欢迎你,${user.userName }</span>
    				<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action" target="_blank">[个人中心]</a>
    				<a href="${pageContext.request.contextPath}/users/usersLogin_userExit.action">[安全退出]</a>
    			</li>
    			<li class="step_left">
    				<ul>
    					<c:choose>
    						<c:when test="${type=='showCar'}">
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/order_13.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/order_12.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/order_11.jpg"/></li>
    						</c:when>
    						<c:when test="${type=='firmOrder'}">
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/order_23.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/order_22.jpg"/></li>
    							<li><img src="${pageContext.request.contextPath }/images/proscenium/order_21.jpg"/></li>
    						</c:when>
    						<c:when test="${type=='successOrder'}">
    						`<li><img src="${pageContext.request.contextPath }/images/proscenium/order_33.jpg"/></li>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/order_32.jpg"/></li>
    						<li><img src="${pageContext.request.contextPath }/images/proscenium/order_31.jpg"/></li>
    						</c:when>
    					</c:choose>
    				</ul>
    			</li>
    		</ul>
    	</div>
    </div>
  </body>
</html>
