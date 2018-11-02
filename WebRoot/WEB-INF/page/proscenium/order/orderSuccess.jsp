<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
  <head>
  	<title>购物车</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/orderLayout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/orderSuccess.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/orderSuccess.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div class="order_top">
    	<jsp:include page="/WEB-INF/page/proscenium/order/orderTop.jsp" />
    </div>
    <div class="order_main">
 		<c:choose>
 			<c:when test="${flag==0}">
 				<div class="hdfk">
 					<table border="0" cellpadding="10">
 						<tr>
 							<td align="right"><img src="${pageContext.request.contextPath }/images/proscenium/orderSuccess.jpg"/></td>
 							<td><h1>您的订单已经提交!</h1></td>
 						</tr>
 						<tr>
 							<td></td>
 							<td>订单号:<font class="ddh">${orderId }</font></td>
 						</tr>
 						<tr>
 							<td></td>
 							<td>支付金额:<font class="zfje">&yen;${orderPrice }</font>&nbsp;&nbsp;&nbsp;(请您手机保持正常通话状态,我们的客户专员会与您确认此订单)</td>
 						</tr>
 						<tr>
 							<td></td>
 							<td>
 								<a href="">
 									<img src="${pageContext.request.contextPath }/images/proscenium/ckOrder_01.jpg"/></a>
 								&nbsp;&nbsp;
 								<a href="">
 									<img src="${pageContext.request.contextPath }/images/proscenium/jixugouwu_01.jpg"/></a>
 							</td>
 						</tr>
 					</table>
 				</div>
 			</c:when>
 			<c:when test="${flag==1}">
 				<div class="zxfk">
 					<table border="0" cellpadding="10">
 						<tr>
 							<td align="right"><img src="${pageContext.request.contextPath }/images/proscenium/orderSuccess.jpg"/></td>
 							<td><h1>您的订单已经提交,请您尽快完成付款!</h1></td>
 						</tr>
 						<tr>
 							<td></td>
 							<td>订单号:<font class="ddh">${orderId }</font></td>
 						</tr>
 						<tr>
 							<td></td>
 							<td>支付金额:<font class="zfje">&yen;${orderPrice }</font>&nbsp;&nbsp;&nbsp;(请您在<font class="7ggzr">7个工作日</font>完成支付,逾期将自动取消订单)</td>
 						</tr>
 						<tr>
 							<td></td>
 							<td>
 								<table class="zz" cellpadding="0" cellspacing="0">
 									<tr>
 										<td>开户银行</td>
 										<td>开户名称</td>
 										<td>开户账号</td>
 									</tr>
 									<tr>
 										<td class="myxhx">中国工商银行车站路口分行</td>
 										<td class="myxhx">XXX</td>
 										<td class="myxhx">6222 0219 0300 5874 232</td>
 									</tr>
 								</table>
 							</td>
 						</tr>
 						<tr>
 							<td></td>
 							<td><a href="">查看银行转账支付详情&gt;&gt;&gt;&gt;</a></td>
 						</tr>
 					</table>
 				</div>
 			</c:when>
 			<c:when test="${flag==2}">
 				<div class="xxfk">
 				
 				</div>
 			</c:when>
 		</c:choose>
    </div>
    <div class="order_bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/order/orderBottom.jsp" />
    </div>
  </body>
</html>

