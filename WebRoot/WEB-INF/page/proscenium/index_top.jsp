<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/proscenium/index_top.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/proscenium/indexTop.js" charset="UTF-8"></script>
  </head>
  <body>
    <div id="top_top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_topT.jsp"></jsp:include>
    </div>
    <div id="top_cneter">
    	<div id="top_center_img" style="width: 213px;height: 71px;"></div>
    	<div id="top_center_search">
    		<form action="${pageContext.request.contextPath }/search/searchGoods.action" method="POST">
    		<table >
    			<tr>
    				<td valign="top" id="searchTd">
    					<img  src="${pageContext.request.contextPath }/images/proscenium/search.jpg" id="searchIMG">
    					<input type="text" style="outline:none;" class="searchContext" name="queryString" value="${queryString }">
    				</td>
    				<td width="20%"><input type="image" src="${pageContext.request.contextPath }/images/proscenium/searchbutton.jpg"/></td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<span id="search">
    						热门搜索:          
    						<a href="">针织衫</a>
    						<a href="">手机</a>
    						<a href="">客厅灯</a>
    						<a href="">牛奶</a>
    						<a href="">运动鞋</a>
    					</span>
    				</td>
    			</tr>
    		</table>
    	</form>
    	</div>
    </div>
    <div id="top_bottom">
    	<span>
    		<a href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action" id="top_title" title="首页"><span id="top_title">首页</span></a>&nbsp;|&nbsp;
			<c:forEach items="${categorys}" var="c">
    		<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=${c.categoryId}" id="top_title" title="${c.categoryId}"><span id="top_title">${c.categoryName}</span></a>&nbsp;|&nbsp;
			</c:forEach>
    		<a href="${pageContext.request.contextPath}/goods/brand_getAllBrands.action" id="top_title" title="品牌"><span id="top_title">品牌</span></a>

    	</span>
    </div>
    <div id="top_hr">
    	<img  src="${pageContext.request.contextPath }/images/proscenium/topHR.jpg" width="100%">
    </div>
  </body>
</html>
