<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/seePaixieB.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/seePaixieB.js" charset="UTF-8"></script>
 </head>
  
  <body>
   	<div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;我的拍鞋币</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="paixieB_title">
    				<span>我的拍鞋币</span>
    			</div>
    			<div class="kypxb">&nbsp;&nbsp;&nbsp;可用拍鞋币个数:&nbsp;<font>${user.paixieB }</font>&nbsp;个</div>
    			<div class="paixieB_content">
    				<div class="title">
						<input type="hidden" id="paixieBType" value="${type }"/>
    					<ul>
    						<li id="tab1">拍鞋币获取记录</li>
    						<li id="tab2">拍鞋币支出记录</li>
    					</ul>
    				</div>
    				<div class="content">
    					<div id="tab1Div" style="display: none;">
    						<div class="Ctitle">
    							<ul>
    								<li style="width: 33%">获取时间</li>
    								<li style="width: 33%">获得数量</li>
    								<li style="width: 33%">获得方式</li>
    							</ul>
    						</div >
    						<div class="Ccontent">
    							<table border="0">
    								<c:forEach items="${paixieBRecords}" var="pxb">
    									<tr>
    										<td width="33%">${pxb.paixieBTime }</td>
    										<td width="33%"><font>${pxb.paixieBNum }个</font></td>
    										<td width="33%">${pxb.paixieBStyle }</td>
    									</tr>
    								</c:forEach>
    							</table>
    							<c:choose>
    								<c:when test="${pageSum>1}">
    									<div class="page">
    									<c:choose>
    										<c:when test="${pageSum<5}">
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>  
    											<c:forEach begin="1" end="${pageSum}" var="p">
   													<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${p}"><span>${p}</span></a>
   												</c:forEach>
   												<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
   											</c:when>
    										<c:otherwise>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${1}"><span>1</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${2}"><span>2</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${3}"><span>3</span></a>
    											...
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${pageSum-1}"><span>${paixieBPage-1}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${pageSum}"><span>${paixieBPage}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbhqjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
    										</c:otherwise>
    									</c:choose>
    									</div>
    								</c:when>
    							</c:choose>
    						</div>
    					</div>
    					<div id="tab2Div" style="display: none;">
    						<div class="Ctitle">
    							<ul>
    								<li style="width: 33%">支出时间</li>
    								<li style="width: 33%">支出数量</li>
    								<li style="width: 33%">支出用途</li>
    							</ul>
    						</div >
    						<div class="Ccontent">
    							<table border="0">
    								<c:forEach items="${paixieBRecords}" var="pxb">
    									<tr>
    										<td width="33%">${pxb.paixieBTime }</td>
    										<td width="33%"><font>${pxb.paixieBNum }个</font></td>
    										<td width="33%">${pxb.paixieBStyle }</td>
    									</tr>
    								</c:forEach>
    							</table>
    							
    							<c:choose>
    								<c:when test="${paixieBPage>1}">
    									<div class="page">
    									<c:choose>
    										<c:when test="${paixieBPage<5}">
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<c:forEach begin="1" end="${paixieBPage}" var="p">
    												<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${p}"><span>${p}</span></a>
    											</c:forEach>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
    										</c:when>
    										<c:otherwise>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${1}"><span>1</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${2}"><span>2</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${3}"><span>3</span></a>
    											...
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${paixieBPage-1}"><span>${paixieBPage-1}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${paixieBPage}"><span>${paixieBPage}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/paixieB_seePaixieB.action?type=pxbzcjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
    										</c:otherwise>
    									</c:choose>
    									</div>
    								</c:when>
    							</c:choose>
    						</div>
    					</div>
    				</div>
    				<div class="kongbai"></div>
    			</div>
    			<div class="pxbsysm">
    				<ul>
    					<li>&nbsp;&nbsp;&nbsp;拍鞋币使用说明</li>
    					<li><a href="">什么是拍鞋币?</a></li>
    				</ul>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
