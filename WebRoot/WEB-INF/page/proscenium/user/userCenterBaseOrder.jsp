<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  
  <body>
    <div class="baseOrder">
    	<div>
    		<img  src="${pageContext.request.contextPath}/images/proscenium/userOrderMonth.jpg">
    	</div>
    	<div class="order_title">
    		<table border="0">
    			<tr>
    				<td align="center" width="30%"><span>订单编号</span></td>
    				<td align="center"><span>收货人</span></td>
    				<td align="center"><span>订单金额</span></td>
    				<td align="center"><span>支付方式</span></td>
    				<td align="center"><span>订单状态</span></td>
    				<td align="center"><span>操作</span></td>
    			</tr>
    		</table>
    	</div>
    	<div class="order_content">
    		<c:choose>
    				<c:when test="${pageSum==0}">
    					<div class="noOrder">
    							您这个月还没有产生订单，马上去<a href="">挑选商品吧</a>!
    					</div>
    				</c:when>
    				<c:otherwise>
    					<c:forEach	items="${orders}" var="map">
    						<c:set value="${map.key}" var="order" />
    						<c:set value="${map.value}" var="goods"/>
    						<div class="myOrder">
    						<div class="orderIdT">
    							<ul>
    								<li class="dyg">&nbsp;订单编号:${order.orderId }</li>
    								<li class="deg">&nbsp;</li>
    								<li class="dsg">下单时间:${order.orderDate }</li>
    							</ul>
    						</div>
    						<div class="orderGB">
    						<table>
    							<tr>
    								<td style="width: 30%">
    									 <c:forEach items="${goods}" var="g" >
    										 <a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsListing.goodsId}" target="_blank">
    										 	<img src="${g.goodsListing.goodsImage }" width="40" height="40" title=""/>
    										</a>
    									 </c:forEach>
    								</td>
    								<td style="width: 13.8%">${order.orderConsignee }</td>
    								<td style="width: 13.8%"><font>￥${order.orderPrice }</font></td>
    								<td style="width: 13.8%">
    									<c:if test="${order.orderPayment ==0}">
    										在线支付
    									</c:if>
    									<c:if test="${order.orderPayment == 1 }">
    										货到付款
    									</c:if>
    									<c:if test="${order.orderPayment == 2 }">
    										线下支付
    									</c:if>
    									&nbsp;
    								</td>
    								<td style="width: 13.8%">
    									${order.orderState.orderStateName }<Br/><br/>
    									<a href="">订单详情</a></td>
    								<td style="width: 13.8%">
    									<c:if test="${(order.orderPayment ==0||order.orderPayment ==2)&&(order.orderState.orderStateId=='500003')}">
    										<a href="">付款</a><br><br>
    									</c:if>
    									<c:if test="${order.orderState.orderStateId!='500002'&&order.orderState.orderStateId!='500005'&&order.orderState.orderStateId!='500006'}">
    										<a href="${pageContext.request.contextPath }/userCenter/order_cancelOrder.action?orderId=${order.orderId}&type=${type }&page=${nowPage }">取消订单</a><br><br>
    									</c:if>
    									<c:if test="${order.orderState.orderStateId!='500001'&&order.orderState.orderStateId!='500003'}">
    										<a href="">再次购买</a>
    									</c:if>
    								</td>
    							</tr>
    							
    						</table>
    					</div>
    				</div>
    			</c:forEach>
    		</c:otherwise>
    	</c:choose>
    </div>
    <div class="page">
    	<c:choose>
    		<c:when test="${pageSum>1}">
    			<c:choose>
    				<c:when test="${pageSum<5}">
    					<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${page-1}&type=${type }"><span class="sxyy">上一页</span></a>
    						<c:forEach begin="1" end="${pageSum}" var="p">
    							<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${p}&type=${type }"><span>${p}</span></a>
    						</c:forEach>
    					<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${page+1}&type=${type }"><span class="sxyy">下一页</span></a>
    				</c:when>
    				<c:otherwise>
    					<a href="${pageContext.request.contextPath }/userCenter/corder_seeOrder.action?page=${nowPage-1}&type=${type }"><span class="sxyy">上一页</span></a>
    					<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${1}&type=${type }"><span>1</span></a>
    					<a href="${pageContext.request.contextPath }/userCenter/order_sseeOrder.action?page=${2}&type=${type }"><span>2</span></a>
    					<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${3}&type=${type }"><span>3</span></a>
    					...
    					<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${pageSum-1}&type=${type }"><span>${pageSum-1}</span></a>
    					<a href="${pageContext.request.contextPath }/userCenter/corder_seeOrder.action?page=${pageSum}&type=${type }"><span>${pageSum}</span></a>
    					<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${page+1}&type=${type }"><span class="sxyy">下一页</span></a>
    				</c:otherwise>
    			</c:choose>
    		</c:when>
    	</c:choose>
    </div>
    </div>
  </body>
</html>
