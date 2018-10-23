<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  </head>
  
  <body>
    <div class="content_left_main">
    	<ul>
    		<li class="mypaixie">
    			<img src="${pageContext.request.contextPath}/images/proscenium/userCenter_mypaixie.jpg"/>
    		</li>
    		<li>
    			<div class="countManager_title">
    				<span>账户管理</span>
    			</div >
    			<div class="countManager_content">
    				<ul>
    					<li><a href="${pageContext.request.contextPath}/userCenter/userInfor_enterUserInfor.action" target="_self">账户信息</a></li>
    					<li><a href="${pageContext.request.contextPath }/userCenter/userInfor_enterSafeCenter.action" target="_self">安全中心</a></li>
    					<li><a href="${pageContext.request.contextPath }/userCenter/userInfor_enterAddressManager.action" target="_self">收货地址</a></li>
    				</ul>
    			</div>
    		</li>
    		<li>
    			<div class="changeManager_title">
    				<span>交易管理</span>
    			</div>
    			<div class="changeManager_content">
    				<ul>
    					<li><a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?type=all&page=1" target="_self">我的订单</a></li>
    					<li><a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?type=all&page=1" target="_self">我的评价</a></li>
    					<li><a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?type=all&page=1" target="_self">我的收藏</a></li>
    				</ul>
    			</div>
    		</li>
    		<li>
    			<div class="discountManager_title">
    				<span>我的优惠</span>
    			</div>
    			<div class="discountManager_content">
    				<ul>
    					<li><a href="${pageContext.request.contextPath }/userCenter/discountCoupon_seeDiscountCoupon.action?type=kyyhq">我的优惠券</a></li>
    					<li><a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl" target="_self">拍鞋币记录</a></li>
    				</ul>
    			</div>
    		</li>
    	</ul>
    	</div>
    	<div class="paixieunion">
    		<img src="${pageContext.request.contextPath}/images/proscenium/userCenter_union.jpg"/>
    	</div>
  </body>
</html>
