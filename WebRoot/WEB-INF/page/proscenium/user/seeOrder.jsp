<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/seeOrder.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/myOrder.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/seeOrder.js" charset="UTF-8"></script>
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
    			<div class="order_title">
    				<span>我的订单</span>
    			</div>
    			<div class="order_content">
    				<div class="option">
    					<ul>
    						<li class="select">
    							<select>
    								<option>所有订单</option>
    							</select>
    						</li>
    						<li class="search">
    							<input type="text" class="search"/>
    							<input type="image" src="${pageContext.request.contextPath }/images/proscenium/usearch.jpg"/>
    						</li>
    					</ul>
    				</div>
    				<div class="title">
    					<input type="hidden" id="orderType" value="${type }"/>
    					<ul>
    						<li id="tab1">所有订单</li>
    						<li id="tab2">待付款</li>
    						<li id="tab3">待收货</li>
    					</ul>
    				</div>
    				<div class="content">
    					<div class="content_syhsfk" style="display: none">
    					<div class="tabTitle">
    						<ul>
    							<li style="width: 30%">商品</li>
    							<li style="width: 13.8%">收货人</li>
    							<li style="width: 13.8%">订单金额</li>
    							<li style="width: 13.8%">支付方式</li>
    							<li style="width: 13.8%">订单状态</li>
    							<li style="width: 13.8%">操作</li>
    						</ul>
    					</div>
    					<div id="div_tab1">
    						<c:choose>
    							<c:when test="${pageSum==0}">
    								<div class="noOrder">
    									你还没有产生订单，马上去<a href="">挑选商品吧</a>!
    								</div>
    							</c:when>
    							<c:otherwise>
    							<c:forEach	items="${allOrders}" var="map">
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
    					</div>
    					<div class="content_dsh" style="display: none">
    					<div class="tabTitle">
    						<ul>
    							<li style="width: 30%">商品</li>
    							<li style="width: 13.8%">商品数量</li>
    							<li style="width: 13.8%">商品单价</li>
    							<li style="width: 13.8%">总金额</li>
    							<li style="width: 13.8%">可获得拍鞋币</li>
    							<li style="width: 13.8%">操作</li>
    						</ul>
    					</div>
    					<div id="div_tab1">
    						<c:choose>
    							<c:when test="${pageSum==0}">
    								<div class="noOrder">
    									你还没有产生订单，马上去<a href="">挑选商品吧</a>!
    								</div>
    							</c:when>
    							<c:otherwise>
    								<c:forEach items="${orlist}" var="od">
    								<div class="myOrder">
    								<div class="orderIdT">
    									<ul>
    										<li class="dyg">&nbsp;编号:${od[0].orderDetailId }</li>
    										<li class="deg"><a href="" title="点击查看订单信息">所属订单:${od[1].orderId }</a></li>
    										<li class="dsg">下单时间:${od[1].orderDate }&nbsp;</li>
    									</ul>
    								</div>
    								<div class="orderGB">
    									<table>
    										<tr>
    											<td style="width: 30%">
    										 		<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${od[0].goodsListing.goodsId}" target="_blank">
    										 			<img src="${od[0].goodsListing.goodsImage }" width="40" height="40" title=""/>
    												</a>
    											</td>
    											<td style="width: 14%">${od[0].goodsNumber }</td>
    											<td style="width: 14%"><font>￥${od[0].goodsListing.goodsPaiPrice }</font></td>
    											<td style="width: 14%"><font>￥${od[0].goodsNumber*od[0].goodsListing.goodsPaiPrice }</font></td>
    											<td style="width: 14%"><font><fmt:formatNumber type="number" value="${od[0].goodsNumber*od[0].goodsListing.goodsPaiPrice/100 }" maxFractionDigits="0"/></font></td>
    											<td style="width: 14%">
    												<input type="hidden" value="${od[0].orderDetailId }" id="qrshODId"/>
    												<input type="hidden" value="${od[1].orderId }" id="qrshOId" />
    												<a href="javascript:void(0);" class="qrsh">确认收货</a>
    											</td>
    										</tr>
    									</table>
    								</div>
    								</div>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    					</div>
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
    											<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${nowPage-1}&type=${type }"><span class="sxyy">上一页</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${1}&type=${type }"><span>1</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/order_sseeOrder.action?page=${2}&type=${type }"><span>2</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${3}&type=${type }"><span>3</span></a>
    											...
    											<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${pageSum-1}&type=${type }"><span>${pageSum-1}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${pageSum}&type=${type }"><span>${pageSum}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/order_seeOrder.action?page=${page+1}&type=${type }"><span class="sxyy">下一页</span></a>
    										</c:otherwise>
    									</c:choose>
    								</c:when>
    							</c:choose>
    						</div>
    					<div class="kongbai"></div>
    					
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
