<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <head>
  	<title>会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/addressManager.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.core.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.widget.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.mouse.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.button.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.draggable.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.position.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.dialog.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/addressManager.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/checkAddressInput.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/provincesCity.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/provincesdata.js" charset="UTF-8"></script>
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
    			<div class="address_title">
    				<span>收货地址</span>
    			</div>
    			<div class="address_content">
    				<div class="addAddress">
    					<a href="javascript:void(0);" >
    						<img src="${pageContext.request.contextPath }/images/proscenium/addNewAddress_01.jpg" id="addNewAddress"/>
    					</a>
    					<span>已有 <span class="number">${addressNumber }</span> 个收货地址，还可以添加 <span class="number">${10-addressNumber}</span> 个收货地址。</span>
    				</div>
    				<div class="showAddress">
    					<table cellpadding="0" cellspacing="0">
    						<tr class="title">
    							<td width="12%"><span>收货人</span></td>
    							<td width="12%"><span>手机/固话</span></td>
    							<td ><span>收获人地址</span></td>
    							<td width="12%"><span>邮政编号</span></td>
    							<td width="12%"><span>设为默认</span></td>
    							<td width="12%"><span>操作</span></td>
    						</tr>
    						<c:choose>
    							<c:when test="${addressNumber==0}">
    								<tr>
    									<td colspan="5" align="center">暂无收获地址</td>
    								</tr>
    							</c:when>
    							<c:otherwise>
    								<c:forEach items="${addresses}" var="a">
    									<tr >
    										<td>${a.consignee}</td>
    										<td>${a.addressPhone }</td>
    										<td>${a.addressDetail }</td>
    										<td>${a.addressPostalcode }</td>
    										<td>
    											<input type="hidden" id="idDefault" value="${a.isDefault}"/>
    											<c:choose>
    												<c:when test="${a.isDefault==1}">
    													<span class="default">默认地址</span>
    												</c:when>
    												<c:otherwise>
    													<a href="${pageContext.request.contextPath }/userCenter/address_setDefaultAddress.action?addressId=${a.addressId}" class="setDefault">设为默认</a>
    												</c:otherwise>
    											</c:choose>
    										</td>
    										<td>
    											<input type="hidden" value="${a.addressId}" id="addressId"/>
    											<a href="javascript:void(0);" class="update">
    												编辑
    											</a>|
    											<a href="javascript:void(0);" class="delete">
    												删除
    											</a>
    										</td>
    									</tr>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
    
    <div class="newAddress" title="新增收货地址" >
    	<form action="${pageContext.request.contextPath }/userCenter/address_addAddress.action" method="post" id="addressForm">
    	<table cellpadding="10" border="0">
    		<tr>
    			<td align="right" width="23%">收货人姓名：</td>
    			<td align="left" width="40%"><input type="text" id="consignee" class="addressText" name="address.consignee"/></td>
    			<td><div class="consignee_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">所在城市：</td>
    			<td><div class="city"></div></td>
    			<td><div class="city_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">街道地址：</td>
    			<td><input type="text" id="street" class="addressText" name="street"/></td>
    			<td><div class="street_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">手机/固话：</td>
    			<td><input type="text" id="telephone" class="addressText" name="address.addressPhone"/></td>
    			<td><div class="phone_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">邮政编码：</td>
    			<td><input type="text" id="postCode" class="addressText" name="address.addressPostalcode"/></td>
    			<td><div class="postCode_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">设为默认地址：</td>
    			<td>
    				<input type="radio" id="isDefault" name="address.isDefault" value="1"/>是
    				<input type="radio" id="isDefault" name="address.isDefault" value="0"/>否
    			</td>
    			<td><div class="isDefaul_prompt"></div></td>
    		</tr>
    		<tr>
    			<td><input type="hidden" name="address.addressId" id="addressId"/></td>
    			<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/saveBtn.jpg" id="saveBTN"/></td>
    			<td></td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
