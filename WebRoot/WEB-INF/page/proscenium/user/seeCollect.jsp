<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/collect.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/collect.js"></script>
 </head>
  
  <body>
   	<div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;我的收藏</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="collect_title">
    				<span>我的收藏</span>
    			</div>
    			<div class="collect_content">
    				<div class="title">
						<input type="hidden" id="collectType" value="${type }"/>
    					<ul>
    						<li id="tab1">全部商品</li>
    						<li id="tab2">在售商品</li>
    						<li id="tab3">下架商品</li>
    					</ul>
    				</div>
    				<div class="content">
    					<div id="div_tab1">
    					<c:choose>
    						<c:when test="${allPage==0}">
    							<div class="noCollect">没有收藏商品</div>
    						</c:when>
    						<c:otherwise>
    						<ul>
    							<li class="waiwei">
    								<ul class="Ctitle">
    									<li style="width: 16%"><input type="checkbox" class="quanxuan"/>全选&nbsp;&nbsp;&nbsp;<a href="" class="qxsc">取消收藏</a></li>
    									<li style="width: 40%">商品</li>
    									<li style="width: 13%">价格</li>
    									<li style="width: 13%">状态</li>
    									<li style="width: 13%">操作</li>
    								</ul>
    							</li>
    							<c:forEach items="${collect}" var="c">
    								<li class="collect">
    									<table border="0">
    										<tr>
    											<td rowspan="3" width="7%">&nbsp;<input type="checkbox"/></td>
    											<td width="10%" rowspan="3">
    												<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${c.goodsListing.goodsId}" target="_blank">
    													<img src="${c.goodsListing.goodsImage }" width="85" height="55"/>
    												</a>		
    											</td>
    											<td width="40%">
    												<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${c.goodsListing.goodsId}" target="_blank" class="goods">
    													&nbsp;${c.goodsListing.goodsName }
    												</a>
    											</td>
    											<td width="13%"></td>
    											<td width="13%"></td>
    											<td rowspan="2" align="center"><img src="${pageContext.request.contextPath}/images/proscenium/ljgm.jpg"/></td>
    										</tr>
    										<tr>
    											<td>&nbsp;<font class="brand">品牌:</font><a href="" class="brand">${c.goodsListing.brand.brandName }</a></td>
    											<td align="center"><font class="price">￥${c.goodsListing.goodsPaiPrice}</font></td>
    											<td align="center">
    												<c:choose>
    													<c:when test="${c.goodsListing.goodsState==1}">
    														<font class="state">在售</font>
    													</c:when>
    													<c:otherwise>
    														<font class="state">已下线</font>
    													</c:otherwise>
    												</c:choose>
    											</td>
    										</tr>
    										<tr>
    											<td>&nbsp;<font class="time">收藏时间:${c.collectTime }</font></td>
    											<td></td>
    											<td></td>
    											<td align="center">
    												<a href="${pageContext.request.contextPath }/userCenter/collect_cancelCollect.action?collectId=${c.collectId}&type=${type}" class="qxsc">
    													取消收藏
    												</a>
    											</td>
    										</tr>
    									</table>
    								</li>
    							</c:forEach>
    							<li class="page">
    								<ul class="page">
    									<li><input type="checkbox" class="quanxuan"/>全选&nbsp;&nbsp;&nbsp;<a href="" class="qxsc">取消收藏</a></li>
    									<li>
    										<c:choose>
    											<c:when test="${allPage>1}">
    												<c:choose>
    													<c:when test="${allPage<5}">
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${nowPage-1}&type=${type }"><span class="sxyy">上一页</span></a>
    														<c:forEach begin="1" end="${allPage}" var="p">
    															<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${p}&type=${type }"><span>${p}</span></a>
    														</c:forEach>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${nowPage+1}&type=${type }"><span class="sxyy">下一页</span></a>
    													</c:when>
    													<c:otherwise>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${nowPage-1}&type=${type }"><span class="sxyy">上一页</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${1}&type=${type }"><span>1</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${2}&type=${type }"><span>2</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${3}&type=${type }"><span>3</span></a>
    														...
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${allPage-1}&type=${type }"><span>${allPage-1}</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${allPage}&type=${type }"><span>${allPage}</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${nowPage+1}&type=${type }"><span class="sxyy">下一页</span></a>
    													</c:otherwise>
    												</c:choose>
    											</c:when>
    										</c:choose>
    									</li>
    								</ul>
    							</li>
    						</ul>
    						</c:otherwise>
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
