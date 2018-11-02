<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/seeDiscountCoupon.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/seeDiscountCoupon.js" charset="UTF-8"></script>
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
    			<div class="discount_title">
    				<span>我的优惠券</span>
    			</div>
    			<div class="discount_content">
    				<div class="title">
						<input type="hidden" id="discountType" value="${type }"/>
    					<ul>
    						<li id="tab1" class="now">可用优惠券</li>
    						<li id="tab2">已使用优惠券</li>
    						<li id="tab3">已过期优惠券</li>
    					</ul>
    				</div>
    				<div class="content">
    					<div id="tab1Div">
    						<div class="Ctitle">
    							<ul>
    								<li style="width: 17%">优惠券名称</li>
    								<li style="width: 17%">优惠券号码</li>
    								<li style="width: 30%">使用说明</li>
    								<li style="width: 17%">截止时间</li>
    								<li style="width: 17%">使用状态</li>
    							</ul>
    						</div>
    						<div class="Ccontent">
    						
    						</div>
    					</div>
    					<div id="tab2Div">
    					
    					</div>
    					<div id="tab3Div">
    					
    					</div>
    				</div>
    				<div class="kongbai"></div>
    			</div>
    			<div class="yhqsysm">
    				<div class="title">&nbsp;&nbsp;&nbsp;优惠券使用说明</div>
    				<div class="content">
    					<ul>
    						<li><a href="">如何获得优惠券</a></li>
    						<li><a href="">如何使用优惠券</a></li>
    						<li><a href="">优惠券使用规则</a></li>
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
