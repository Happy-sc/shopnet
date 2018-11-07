<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
  	<title>购物车</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/orderLayout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/firmOrder.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/firmOrder.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/checkAddressInput.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/carManager.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/provincesCity.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/provincesdata.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div class="order_top">
    	<jsp:include page="/WEB-INF/page/proscenium/order/orderTop.jsp" />
    </div>
    <div class="order_main">
    	<div class="FO_main">
    		<div class="payStyle">
    			<div class="ps_address">
    				<div class="title">
    					<span>确认收货地址</span>
    					<div class="qr_address"></div>
    					<a href="${pageContext.request.contextPath }/userCenter/userInfor_enterAddressManager.action" target="_blank">管理收货地址</a>
    				</div>
    				<div class="content">
    					<c:choose>
    						<c:when test="${address==null}">
    							<input type="hidden" value="0" id="isAdd"/>
    						</c:when>
    						<c:otherwise>
    							<input type="hidden" value="1" id="isAdd"/>
    						</c:otherwise>
    					</c:choose>
    					
    					<div class="addAddress">
    						<table cellpadding="10" border="0">
    							<tr>
    								<td align="right" width="23%">收货人姓名:</td>
    								<td align="left" width="40%"><input type="text" id="consignee" class="addressText" name="consignee"/></td>
    			    				<td><div class="consignee_prompt"></div></td>
    		    				</tr>
    		    				<tr>
    			    				<td align="right">所在城市:</td>
    			    				<td><div class="city"></div></td>
    			    				<td><div class="city_prompt"></div></td>
    		    				</tr>
    		    				<tr>
    			    				<td align="right">街道地址:</td>
    			    				<td align="left"><input type="text" id="street" class="addressText" name="street"/></td>
    			    				<td><div class="street_prompt"></div></td>
    		    				</tr>
    		    				<tr>
    			    				<td align="right">手机/固话:</td>
    			    				<td align="left"><input type="text" id="telephone" class="addressText" name="addressPhone"/></td>
    			    				<td><div class="phone_prompt"></div></td>
    		    				</tr>
    		    				<tr>
    			    				<td align="right">邮政编码:</td>
    			    				<td align="left"><input type="text" id="postCode" class="addressText" name="postalcode"/></td>
    			    				<td><br></td>
    		    				</tr>
    		    				<tr>
    		    					<td align="right">设为默认地址:</td>
    			    				<td align="left">
    				    				<input type="radio" id="isDefault" name="isDefault" value="1"/>是
    				    				<input type="radio" id="isDefault" name="isDefault" value="0"/>否
    			    				</td>
    			    				<td><br></td>
    		    				</tr>
    		    				<tr>
    			    				<td>
    			    					<input type="hidden" name="addressId" id="addressId" value=""/>
    			    					<input type="hidden" value="firmOrder" id="type" name="type"/>
    			    				</td>
    			    				<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/bcbpedzgwe_01.jpg" id="saveBTN"/></td>
    			    				<td></td>
    		    				</tr>
    	    				</table>
    					</div>
    					<div class="oldAddress">
    						<div class="address">
    							<ul>
    								<li class="detailAddress">${address.addressDetail }</li>
    								<li class="postCode">${address.addressPostalcode}</li>
    								<li class="consignee">${address.consignee}</li>
    								<li class="phone">${address.addressPhone }</li>
    							</ul>
    						</div>
    						<div class="newAddress">
    							<a href="javascript:void(0);">
    								<img src="${pageContext.request.contextPath }/images/proscenium/userNewAddress_01.jpg"/>
    							</a>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="ps_pay">
    				<div class="title">
    					<span>配送与支付</span>
    					<div class="paytype"></div>
    				</div>
    				<div class="content">
    					<ul>
    						<li class="liTitle">
    							<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg"/>配送方式：
    							<ul>
    								<li>系统会根据您填写的地址自动匹配合理的快递公司进行配送,目前不支持自主选择快递公司.</li>
    							</ul>
    						</li>
    						<li class="liTitle">
    							<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg"/>支付方式：
    							<ul>
    								<li>
    									<input type="radio" name="payStyle" id="payStyle" value="0"/><span>在线支付</span>
    									<font>支持支付宝,财付通及绝大数银行借记卡和部分银行信用卡</font>
    								</li>
    								<li>
    									<input type="radio" name="payStyle" id="payStyle" value="1"/><span>货到付款</span>
    									<font>需要15元手续费</font>
    								</li>
    								<li>
    									<input type="radio" name="payStyle" id="payStyle" value="2"/><span>线下支付</span>
    									<font>支持银行转账及邮政汇款</font>	
    								</li>
    							</ul>
    						</li>
    					</ul>
    				</div>
    			</div>
    		</div>	
    		<div class="order">
    			<div class="title">
    				订单信息
    			</div>
    			<div class="content">
    				<div class="car_title">
    					<ul>
    						<li class="goodsName">商品名称</li>
    						<li class="price">拍鞋价(元)</li>
    						<li class="number">商品数量</li>
    						<li class="sum">小计(元)</li>
    						<li class="caozuo">操作</li>
    					</ul>
    				</div>
    				<div class="car_content">
    					<ul>
    					<c:forEach	items="${mapCar}" var="map">
    						<c:set value="${map.value}" var="car"></c:set>
    						<li class="goods">
    							<table border="0">
    								<tr>
    									<td width="10%" rowspan="2">
    										<input type="hidden" value="${map.key }" id="carCarId"/>
    										<input type="hidden" value="${car.goodsListing.goodsId }" id="carGoodsId">
    										<input type="hidden" value="firmOrder" id="carType"/>
    										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${car.goodsListing.goodsId}" target="_blank">
    											<img src="${car.goodsListing.goodsImage}" width="80px" height="60px" title="${car.goodsListing.goodsName }"/>
    										</a>
    									</td>
    									<td width="40%">
    										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${car.goodsListing.goodsId}"
    										    title="${car.goodsListing.goodsName }" target="_blank" class="goods">
    											${car.goodsListing.goodsName }
    										</a>
    									</td>		
    									<td width="12.5%" rowspan="2" align="center">￥${car.goodsListing.goodsMarketPrice }</td>
    									<td width="12.5%" rowspan="2" align="center">
    										<a href="javascript:void(0);"><span class="carNumber">-</span></a>
    										<input type="text" value="${car.goodsNumber}" class="carNum"/>
    										<a href="javascript:void(0);"><span class="carNumber">+</span></a>
    									</td>
    									<td width="12.5%" rowspan="2" align="center">￥${car.goodsNumber*car.goodsListing.goodsMarketPrice }</td>
    									<td width="12.5%" align="center">
    										<a href="javascript:void(0);" class="aa" id="shoucang">
    											加入收藏
    										</a>
    									</td>
    								</tr>
    								<tr>
    									<td>颜色:<span>${car.goodsColor }</span>&nbsp;&nbsp;属性:<span>${car.goodsAttr }</span></td>
    									<td align="center">
    										<a href="javascript:void(0);" class="aa" id="shanchu">
    											删除
    										</a>
    									</td>
    								</tr>
    							</table>
    						</li>
    					</c:forEach>
    					</ul>
    				</div>
    				<div class="car_submit">
    					<div class="infor">
    						<div class="left">
    							<ul>
    								<li>订单补充:</li>
    								<li><textarea class="ddbc">选填,可以告诉我们您对订单的特殊要求</textarea></li>
    							</ul>
    						</div>
    						<div class="right">
    							<ul>
    								<li>优惠：<input readonly="readonly" type="text" value="无"/>&nbsp;<font class="youhui">-&yen;0.0</font></li>
    								<li>总金额(含运费):<font class="zje">&yen;${sum }</font></li>
    								<li>运费:<font class="yf">&yen;${freight }</font></li>
    							</ul>
    						</div>
    					</div>
    					<div class="submit">
    						<div class="infors">
    							<ul>
    								<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实付款：<font class="sfk">&yen;${sum+freight }</font></li>
    								<li>可获得金币：<font class="khdpxb"><fmt:formatNumber type="number" value="${sum/100}" maxFractionDigits="0"/>个</font></li>
    								<li>&nbsp;&nbsp;使用金币：<input type="text" class="sypxb"/><div class="jsypxb">可以使用个数:<font>${user.jinB }</font>个</div></li>
    							</ul>
    						</div>
    						<div class="btn">
    							<div class="order_prompt"></div>
    							<a href="javascript:void(0);">
    								<img src="${pageContext.request.contextPath }/images/proscenium/submitOrder_01.jpg"/>
    							</a>
    						</div>
    					</div>
    				</div>
    				<div style="display: none" class="orderActoin">
    					<form action="${pageContext.request.contextPath }/order/orderAccounts_submitOrder.action" id="orderForm" method="POST">
    						<input type="hidden" id="addressDetail" name="order.orderAddress">
    						<input type="hidden" id="phone" name="order.orderPhone">
    						<input type="hidden" id="consignee" name="order.orderConsignee">
    						<input type="hidden" id="postalcode" name="order.orderPostalcode">
    						<input type="hidden" id="payment" name="order.orderPayment">
    						<input type="hidden" id="sum" name="order.orderPrice">
    						<input type="hidden" id="freight" name="order.orderFreight">
    						<input type="hidden" id="userRequire" name="order.orderUserRequire">
    						<input type="hidden" id="sypxb" name="sypxb">
    					</form>
    				</div>
    			</div>
    		</div>
    	</div>
   	</div>
    <div class="order_bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/order/orderBottom.jsp" />
    </div>
    <div class="shoucang">
     	<font>收藏成功</font>
     	<a href="javascript:void(0);">&Chi;</a>
    </div>
    <div class="yjscl">
    	<font>该商品已经收藏了</font>
    	<a href="javascript:void(0);">&Chi;</a>
    </div>
  </body>
</html>
