<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/proscenium/index_top.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/proscenium/indexTop.js"></script>
  	
  </head>
  
  <body>
    <div id="top_top_content">
    	   <div id="top_content_left">
    			<span>你好，欢迎来到购物网</span>
    			<img src="${pageContext.request.contextPath }/images/proscenium/phone.jpg"/>
    			<span id="phone">0731-123456</span>&nbsp;&nbsp;|&nbsp;&nbsp;
    			<input type="hidden" id="topUserName" value="${user.userName }">
    			<c:choose>
    				<c:when test="${user==null}">
    					<a href="${pageContext.request.contextPath}/users/usersRegist_userRegistUI.action">[免费注册]</a>
    					<a href="${pageContext.request.contextPath}/users/usersLogin_userLoginUI.action" id="login">[请登录]</a>
    				</c:when>
    				<c:otherwise>
    					<span class="userName">${user.userName}</span>
    					<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action" target="_blank">
    						[个人中心]
    					</a>
    					<a href="${pageContext.request.contextPath}/users/usersLogin_userExit.action">
    						[安全退出]	
    					</a>
    				</c:otherwise>
    			</c:choose>
    		</div>
    		<div id="top_content_right">
    			<ul>
    				<li id="top_mypaixie">
    					<div class="mypaixie_title">
    						<a href="">&nbsp;&nbsp;我的拍鞋</a>
    						<img  src="${pageContext.request.contextPath }/images/proscenium/xiajiantou.jpg" id="tubiao">
    					</div>      
    					<div class="mypaixie_content" style="display: none">
    						<ul>
    							<li class="_hr">
    								<ul>
    									<li><a href="">&nbsp;我的订单</a></li>
    									<li class="img" id="_topHr"><img src="${pageContext.request.contextPath}/images/proscenium/jiantou.jpg"/></li>
    								</ul>
    							</li>
    							<li class="_hr">
    								<ul>
    									<li><a href="">&nbsp;我的收藏</a></li>
    									<li class="img"><img src="${pageContext.request.contextPath}/images/proscenium/jiantou.jpg"/></li>
    								</ul>
    							</li>
    							<li class="_hr">
    								<ul>
    									<li><a href="">&nbsp;我的拍鞋店</a></li>
    									<li class="img"><img src="${pageContext.request.contextPath}/images/proscenium/jiantou.jpg"/></li>
    								</ul>
    							</li>
    							<li class="_hr">
    								<ul>
    									<li><a href="">&nbsp;我的优惠券</a></li>
    									<li class="img"><img src="${pageContext.request.contextPath}/images/proscenium/jiantou.jpg"/></li>
    								</ul>
    							</li>
    						</ul>
    					</div>
    				</li>
    							
    				<li id="top_mycar" class="Yes">
    					<div class="mycar_title">
    						<img src="${pageContext.request.contextPath }/images/proscenium/shoppingCar.jpg">
    						<a href="${pageContext.request.contextPath }/order/car_showCar.action">购物车<span class="topNumber">0</span>件</a>
    						<img src="${pageContext.request.contextPath }/images/proscenium/xiajiantou.jpg" id="cartubiao">
    					</div>
    			</ul>
    		</div>
   	  </div>
  </body>
</html>
