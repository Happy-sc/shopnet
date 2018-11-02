<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
  <head>
  	<title>购物车</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/orderLayout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/showCar.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/carManager.js" charset="UTF-8"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/showCar.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div class="order_top">
    	<jsp:include page="/WEB-INF/page/proscenium/order/orderTop.jsp" />
    </div>
    <div class="order_main">
    	<div class="carContent">
    		<div class="title"> 
    			<br><img src="${pageContext.request.contextPath }/images/proscenium/wgmdsp.jpg"/>
    			<span><font color="#FF3300">&gt;&gt;&gt;</font>商品价格和库存请以订单提交时为准</span>
    		</div>
    		<div class="main">
    			<div class="car_title">
    				<ul>
    					<li class="goodsName">商品名称</li>
    					<li class="price">价格(元)</li>
    					<li class="number">商品数量</li>
    					<li class="sum">小计(元)</li>
    					<li class="caozuo">操作</li>
    				</ul>
    			</div>
    			<div class="car_content">
    				<ul>
    					<c:forEach	items="${mapCar}" var="map">
    						<c:set value="${map.value}" var="car"></c:set>
    						<li>
    							<table border="0">
    								<tr>
    									<td width="10%" rowspan="2">
    										<input type="hidden" value="${map.key }" id="carCarId"/>
    										<input type="hidden" value="${car.goodsListing.goodsId }" id="carGoodsId">
    										<input type="hidden" value="showCar" id="carType"/>
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

    										<a href="javascript:void(0);" class="aa" id="shoucang">加入收藏</a>
    									</td>
    								</tr>
    								<tr>
    									<td>颜色:<span>${car.goodsColor }</span>&nbsp;&nbsp;属性:<span>${car.goodsAttr}</span></td>
    									<td align="center">
    										<a href="javascript:void(0);" class="aa" id="shanchu">删除</a>
    									</td>
    								</tr>
    							</table>
    						</li>
    					</c:forEach>
    					<li class="last">
    						<span>您当前金额为:<span class="thisSum">${sum }</span>元</span>
    						<img src="" class="freight"/>
    						<span class="freight"></span>
    					</li>
    				</ul>
    			</div>
    			<div class="car_youhuiquan">
    				<div class="left">
    					<ul>
    						<li><span>使用优惠券</span></li>
    						<li>输入优惠码:<input type="text" />
    							<a href="javascript:void(0);"><img src="${pageContext.request.contextPath }/images/proscenium/shiyong_01.jpg" class="shiyong"></a>
    						</li>
    						<li>
    							<div>
    								<img src="${pageContext.request.contextPath }/images/proscenium/youhuiquanWH.jpg"/>
    								&nbsp;<a href="javascript:void(0);" class="rhsyyhq">如何使用优惠码</a>
    								&nbsp;&nbsp;|&nbsp;
    							</div>
    							<div>
    								<img src="${pageContext.request.contextPath }/images/proscenium/youhuiquanWH.jpg"/>
    								&nbsp;<a href="javascript:void(0);" class="rhsyyjbddyhq">如何使用已经绑定的优惠券</a>
    							</div>
    						</li>
    					</ul>
    				</div>
    				<div class="right">
    					<ul>
    						<li><span class="YHQSUM">商品总额:${sum }</span></li>
    						<li>
    							<select>
    								<option value="0">不使用优惠券</option>
    							</select>
    							<div class="youhuiquan_prompt"></div>
    						</li>
    						
    					</ul>
    				</div>
    			</div>
    			<div class="car_bottom">
    				<div class="left">
    					<a href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action" target="_blank">
    						<img src="${pageContext.request.contextPath }/images/proscenium/jixugouwu_01.jpg"/>
    					</a>
    				</div>
    				<div class="right">
    					<ul>
    						<li>共&nbsp;<span class="number">${carSize}</span>&nbsp;件商品,金额总计(不计运费):<span class="sum">¥${sum }</span></li>
    						<li>运费:<div class="yunfei"></div></li>
    						<li>
    							<a href="${pageContext.request.contextPath}/order/orderAccounts_firmOrder.action">
    								<img src="${pageContext.request.contextPath }/images/proscenium/qujiesuan_11.jpg"/>
    							</a>
    						</li>
    					</ul>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <div class="order_bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/order/orderBottom.jsp" />
    </div>
    
    <div class="rhsyyhqDIV">
    	<div class="content">
    		<div  class="title">
    			<font>使用优惠码说明</font>
    		</div>
    		<div class="main">
    			<ul>
    				<li>&nbsp;如下图:登陆成功后,在文本框中输入优惠码,点击"使用"按钮</li>
    				<li><img src="${pageContext.request.contextPath }/images/proscenium/rhsyyhq_01.jpg"/></li>
    				<li><img src="${pageContext.request.contextPath }/images/proscenium/rhsyyhq_02.jpg"/></li>
    			</ul>
    		</div>
    	</div>
    	<s><i></i></s>
    </div>
    <div class="rhsyyjbddyhqDIV">
    	<div class="content">
    		<div  class="title">
    			<font>使用绑定优惠券说明</font>
    		</div>
    		<div class="main">
    			<ul>
    				<li>&nbsp;如下图:登陆成功后,您账户里面满足条件的优惠券将会出现在下拉框中,<Br/><Br/>
    				&nbsp;可以选择使用。红圈指示的就是该品牌符合使用条件的优惠券ADD8899为<Br/><Br/>
    				&nbsp;优惠码</li>
    				<li><img src="${pageContext.request.contextPath }/images/proscenium/rhsyyjbddyhq_01.jpg"/></li>
    			</ul>
    		</div>
    	</div>
    	<s><i></i></s>
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
