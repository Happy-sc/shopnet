<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/seeComment.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/seeComment.js" charset="UTF-8"></script>
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
    			<div class="comment_title">
    				<span>我的评价</span>
    			</div>
    			<div class="comment_content">
    				<div class="title">
						<input type="hidden" id="commentType" value="${type }"/>
    					<ul>
    						<li id="tab1">待评价商品</li>
    						<li id="tab2">已评价商品</li>
    					</ul>
    				</div>
    				<div class="content">
    					<div id="tab1Div" style="display: none;">
    						<div class="Ctitle">
    							<ul>
    								<li style="width: 55%">商品</li>
    								<li style="width: 30%">可获得金币</li>
    								<li style="width: 14%">操作</li>
    							</ul>
    						</div >
    						<div class="Ccontent">
    							<c:choose>
    								<c:when test="${pageSum>0}">
    									<table border="0">
    										<c:forEach items="${orderDetails}" var="od">
    											<tr>
    												<td width="15%">
    													<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${od.goodsListing.goodsId}" target="_blank">
    														<img src="${od.goodsListing.goodsImage }" width="80" height="60" class="dpj"/>
    													</a>
    												</td>
    												<td width="40.5%">
    													&nbsp;${od.goodsListing.goodsName }<br/>
    													&nbsp;价格:<font>￥${od.goodsListing.goodsMarketPrice }</font>
    												</td>
    												<td width="30.5%" align="center"><font><fmt:formatNumber type="number" value="${od.goodsListing.goodsMarketPrice/100}" maxFractionDigits="0"/>个</font></td>
    												<td align="center"><a href="${pageContext.request.contextPath }/userCenter/comment_commentUI.action?orderDetailId=${od.orderDetailId}" class="commentA">评价</a></td>
    											</tr>
    										</c:forEach>
    									</table>
    									<div class="page">
    										<c:choose>
    											<c:when test="${pageSum>0}">
    												<c:choose>
    													<c:when test="${pageSum<=5}">
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${page-1}"><span class="sxyy">上一页</span></a>
    														<c:forEach begin="1" end="${pageSum}" var="p">
    															<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${p}"><span>${p}</span></a>
    														</c:forEach>
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${page+1}"><span class="sxyy">下一页</span></a>
    													</c:when>
    													<c:otherwise>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${page-1}"><span class="sxyy">上一页</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${1}"><span>1</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${2}"><span>2</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${3}"><span>3</span></a>
    														...
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${pageSum-1}"><span>${pageSum-1}</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${pageSum}"><span>${pageSum}</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action?page=${pageSum+1}"><span class="sxyy">下一页</span></a>
   														</c:otherwise>
   													</c:choose>
   												</c:when>
    										</c:choose>
    									</div>
    								</c:when>
    								<c:otherwise>
    									<div class="mypjsp">您目前没有可以评价的商品,您可以查看<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action" class="commentA">"已评价商品"</a></div>
    								</c:otherwise>
    							</c:choose>
    						</div>
    					</div>
    					<div id="tab2Div" style="display: none;">
    						<div class="Ctitle">
    							<ul>
    								<li style="width: 15%">商品</li>
    								<li style="width: 54%">评价</li>
    								<li style="width: 15%">打分</li>
    								<li style="width: 15%">操作</li>
    							</ul>
    						</div >
    						<div class="Ccontent">
    							<c:choose>
    								<c:when test="${pageSum>0}">
    									<table border="0">
    										<c:forEach items="${comments}" var="cs">
    											<tr>
    												<td width="15%" align="center">
    													<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${cs.goodsListing.goodsId}" target="_blank">
    														<img src="${cs.goodsListing.goodsImage }" width="80" height="60"/>
    													</a>
    												</td>
    												<td width="54%">&nbsp;&nbsp;&nbsp;${cs.commentContent }</td>
    												<td width="15%" align="center">
    													<c:forEach begin="1" end="${cs.commentGrade}">
    														<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="df"/>
    													</c:forEach>	
    													<c:forEach begin="1" end="${5-cs.commentGrade}">
    														<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="df"/>
    													</c:forEach>
    												</td>
    												<td align="center">
    													<a href="" class="commentA">追加评价</a>
    												</td>
    											</tr>
    										</c:forEach>
    									</table>
    									<div class="page">
    										<c:choose>
    											<c:when test="${pageSum>0}">
    												<c:choose>
    													<c:when test="${pageSum<=5}">
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${page-1}"><span class="sxyy">上一页</span></a>
    														<c:forEach begin="1" end="${pageSum}" var="p">
    															<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${p}"><span>${p}</span></a>
    														</c:forEach>
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${page+1}"><span class="sxyy">下一页</span></a>
    													</c:when>
    													<c:otherwise>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${page-1}"><span class="sxyy">上一页</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${1}"><span>1</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${2}"><span>2</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${3}"><span>3</span></a>
    														...
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${pageSum-1}"><span>${pageSum-1}</span></a>
    														<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${pageSum}"><span>${pageSum}</span></a>
   															<a href="${pageContext.request.contextPath }/userCenter/comment_seeYpjspComment.action?page=${page+1}"><span class="sxyy">下一页</span></a>
   														</c:otherwise>
   													</c:choose>
   												</c:when>
    										</c:choose>
    									</div>
    								</c:when>
    								<c:otherwise>
    									<div class="mypjsp">您目前没有已经评价的商品,您可以查看<a href="${pageContext.request.contextPath }/userCenter/comment_seeDpjspComment.action" class="commentA">"待评价商品"</a></div>
    								</c:otherwise>
    							</c:choose>
    					</div>
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
