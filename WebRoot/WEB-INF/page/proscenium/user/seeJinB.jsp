<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<title>会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/seeJinB.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/seeJinB.js" charset="UTF-8"></script>
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
    			<div class="jinB_title">
    				<span>我的金币</span>
    			</div>
    			<div class="kypxb">&nbsp;&nbsp;&nbsp;可用金币个数:&nbsp;<font>${user.jinB }</font>&nbsp;个</div>
    			<div class="jinB_content">
    				<div class="title">
						<input type="hidden" id="jinBType" value="${type}"/>
    					<ul>
    						<li id="tab1">金币获取记录</li>
    						<li id="tab2">金币支出记录</li>
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
    								<c:forEach items="${jinBRecords}" var="jb">
    									<tr>
    										<td width="33%">${jb.jinBTime }</td>
    										<td width="33%"><font>${jb.jinBNum }个</font></td>
    										<td width="33%">${jb.jinBStyle }</td>
    									</tr>
    								</c:forEach>
    							</table>
    							<c:choose>
    								<c:when test="${pageSum>1}">
    									<div class="page">
    									<c:choose>
    										<c:when test="${pageSum<5}">
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<c:forEach begin="1" end="${pageSum}" var="p">
   													<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${p}"><span>${p}</span></a>
   												</c:forEach>
   												<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
   											</c:when>
    										<c:otherwise>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${1}"><span>1</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${2}"><span>2</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${3}"><span>3</span></a>
    											...
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${pageSum-1}"><span>${jinBPage-1}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${pageSum}"><span>${jinBPage}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
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
    								<c:forEach items="${jinBRecords}" var="jb">
    									<tr>
    										<td width="33%">${jb.jinBTime }</td>
    										<td width="33%"><font>${jb.jinBNum }个</font></td>
    										<td width="33%">${jb.jinBStyle }</td>
    									</tr>
    								</c:forEach>
    							</table>
    							
    							<c:choose>
    								<c:when test="${jinBPage>1}">
    									<div class="page">
    									<c:choose>
    										<c:when test="${jinBPage<5}">
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<c:forEach begin="1" end="${jinBPage}" var="p">
    												<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${p}"><span>${p}</span></a>
    											</c:forEach>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
    										</c:when>
    										<c:otherwise>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${1}"><span>1</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${2}"><span>2</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${3}"><span>3</span></a>
    											...
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${jinBPage-1}"><span>${jinBPage-1}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${jinBPage}"><span>${jinBPage}</span></a>
    											<a href="${pageContext.request.contextPath }/userCenter/jinB_seeJinB.action?type=jbhqjl&page=${nowPage+1}"><span class="sxyy">下一页</span></a>
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
    					<li>&nbsp;&nbsp;&nbsp;金币使用说明</li>
    					<li><a href="">什么是金币?</a></li>
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
