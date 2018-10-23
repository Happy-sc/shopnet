<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/orderManager.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage/orderManager.js"></script>
  </head>
  	
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">订单详情</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     <div id="main_content">
    		<div id="main_content_top"> 
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			订单详情
    		</div>
    		<div id="main_content_main">
    			<table id="orderDetailJBXX">
    				<tr>
    					<td colspan="4" align="center"><font class="orderTitle">订单基本信息</font></td>
    				</tr>
    				<tr>
    					<td align="right"><span>订单编号：</span></span></td>
    					<td colspan="3">&nbsp;${order.orderId }</td>
    				</tr>
    				<tr>
    					<td width="20%" align="right"><span>订单状态：</span></td>
    					<td width="30%">&nbsp;${order.orderState.orderStateName }</td>
    					<td width="20%" align="right"><span>下单人员：</span></td>
    					<td width="30%">&nbsp;${order.users.userName }</td>
    				</tr>
    				<tr>
    					<td align="right"><span>支出拍鞋币：</span></td>
    					<td>&nbsp;${order.paixieBNum }</td>
    					<td align="right"><span>支付方式：</span></td>
    					<td>&nbsp;
							<c:if test="${order.orderPayment==0}">
    							在线支付
    						</c:if>
    						<c:if test="${order.orderPayment==2}">
    							货到付款
    						</c:if>
    						<c:if test="${order.orderPayment==1}">
    							线下支付
    						</c:if>
						</td>
    				</tr>
    				<tr>
    					<td align="right"><span>总金额：</span></td>
    					<td>&nbsp;${order.orderPrice }</td>
    					<td align="right"><span>运费：</span></td>
    					<td>&nbsp;${order.orderFreight }</td>
    				</tr>
    				<tr>
    					<td align="right"><span>处理员：</span></td>
    					<td>&nbsp;${order.worker.workerName }</td>
    					<td align="right"><span>处理时间：</span></td>
    					<td>&nbsp;${order.orderSend}</td>
    				</tr>
    				<tr>
    					<td align="right"><span>收货人：</span></td>
    					<td>&nbsp;${order.orderConsignee }</td>
    					<td align="right"><span>联系方式：</span></td>
    					<td>&nbsp;${order.orderPhone }</td>
    				</tr>
    				<tr>
    					<td align="right"><span>邮政编号：</span></td>
    					<td>&nbsp;${order.orderPostalcode }</td>
    					<td align="right"><span>下单时间：</span></td>
    					<td>&nbsp;${order.orderDate }</td>
    				</tr>
    				<tr>
    					<td align="right"><span>使用优惠券：</span></td>
    					<td colspan="3"></td>
    				</tr>
    				<tr>
    					<td align="right"><span>收货地址：</span></td>
    					<td colspan="3">&nbsp;${order.orderAddress }</td>
    				</tr>
    				<tr>
    					<td align="right"><span>用户要求：</span></td>
    					<td colspan="3">&nbsp;${order.orderUserRequire }</td>
    				</tr>
    			</table>
    			<table id="orderDetailXXXX">
    				<tr>
    					<td colspan="6" align="center"><font class="orderTitle">订单详细信息</font></td>
    				</tr>
    				<tr>
    					<td align="center" width="20%"><span>商品编号</span></td>
    					<td align="center" width="10%"><span>商品图片</span></td>
    					<td align="center" width="20%"><span>颜色</span></td>
    					<td align="center" width="10%"><span>尺码</span></td>
    					<td align="center" width="6%"><span>单价</span></td>
    					<td align="center" width="6%"><span>数量</span></td>
    					<td align="center" width="10%"><span>是否已收货</span></td>
    					<td align="center" width="15%"><span>收货时间</span></td>
    				</tr>
    				<c:forEach items="${orders}" var="os">
    					<tr>
    						<td align="center">${os.goodsListing.goodsId }</td>
    						<td align="center"><img src="${os.goodsListing.goodsImage }" width="60px" height="60px"/></td>
    						<td align="center">${os.goodsColor }</td>
    						<td align="center">${os.goodsSize }</td>
    						<td align="center">${os.goodsListing.goodsPaiPrice }</td>
    						<td align="center">${os.goodsNumber }</td>
    						<td align="center">
    							<c:if test="${os.isAccept == 0}">
    								未收到
    							</c:if>
    							<c:if test="${os.isAccept == 1}">
    								已收到
    							</c:if>
    						</td>
    						<td align="center">${os.acceptTime }</td>
    					</tr>
    				</c:forEach>
    			</table>
    			<div id="qrImage">
    				<input type="hidden" value="${order.orderId }" id="fhOrderId">
    				<c:if test="${type=='qrfh'}">
    					<a href="javascript:void(0);" class="qrfhA"><img src="${pageContext.request.contextPath }/images/backstage/querenfahuo.jpg" /></a>
    				</c:if>
    				<c:if test="${type=='ckfh'}">
    					<a href="javascript:void(0);" class="qrfhA"><img src="${pageContext.request.contextPath }/images/backstage/fahuo.jpg" /></a>
    				</c:if>
    				&nbsp;&nbsp;&nbsp;
    				<a href="javascript:void(0);" id="fanhui" onclick="window.history.back();"><img src="${pageContext.request.contextPath }/images/backstage/fanhui-1.jpg"/></a>
    			</div>
    		</div>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
