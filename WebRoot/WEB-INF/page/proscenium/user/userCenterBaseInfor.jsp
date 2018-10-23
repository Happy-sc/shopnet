<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>

  </head>
  
  <body>
    <div class="baseInfor">
    	<div class="baseInforTop">
    		<span class="username">${user.userName }</span><span>,欢迎您!</span><Br/><Br/>
    		<span>优惠券：<span class="username">sss</span>张</span>
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<span>拍鞋币：<span class="username">${user.paixieB }</span>个</span >
    	</div>
    	<div class="baseInforBottom">
    		<div class="remind">
    			<div class="order_remind">
    				<span>订单提醒：</span>
    				<a href="">待付款订单()</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<a href="">待确认收货()</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<a href="">待评价商品()</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			</div>
    			<div class="other_remind">
    				<span>其他提醒：</span>
    				<a href="">降价商品()</a>
    			</div>
    		</div>
    		<div class="saveLevel">
    			<ul>
    				<li class="saveTitle">
    					<span>账户安全级别:</span>
    					<input type="hidden" value="${i }" id="aqjb"/>
    				</li>
    				<li>
    					<ul>
    						<li class="saveLevel_ruo"><img src="${pageContext.request.contextPath }/images/proscenium/safeLevelruo_02.jpg"/></li>
    						<li class="saveLevel_zhong"><img src="${pageContext.request.contextPath }/images/proscenium/safeLevelzhong_01.jpg" class="aqjbz"/></li>
    						<li class="saveLevel_qiang"><img src="${pageContext.request.contextPath }/images/proscenium/safeLevelqiang_01.jpg" class="aqjbq"/></li>
    					</ul>
    				</li>
    				<li>
    					<ul>
    						<c:if test="${user.isActivate==1}">
    							<li class="check_email"><a href="">修改验证邮箱</a></li>
    						</c:if>
    						<c:if test="${user.isActivate==0}">
    							<li class="check_email"><span>验证邮箱</span></li>
    						</c:if>
    						<li class="check_phone"><span>手机未验证</span></li>
    					</ul>
    				</li>
    			</ul>
    		</div>
    	</div>
    </div>
  </body>
</html>
