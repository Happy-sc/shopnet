<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/proscenium/index_top.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/proscenium/indexTop.js"></script>
  </head>
  <body>
    <div id="top_top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_topT.jsp"></jsp:include>
    </div>
    <div id="top_cneter">
    	<div id="top_center_img">
    		<img src="${pageContext.request.contextPath }/images/proscenium/paixie.jpg"/>
    	</div>
    	<div id="top_center_search">
    		<form action="${pageContext.request.contextPath }/search/searchGoods.action" method="POST">
    		<table >
    			<tr>
    				<td valign="top" id="searchTd">
    					<img  src="${pageContext.request.contextPath }/images/proscenium/search.jpg" id="searchIMG">
    					<input type="text" class="searchContext" name="queryString" value="${queryString }">
    				</td>
    				<td width="20%"><input type="image" src="${pageContext.request.contextPath }/images/proscenium/searchbutton.jpg"/></td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<span id="search">
    						热门搜索:          
    						<a href="">乔丹运动鞋</a>
    						<a href="">休闲皮鞋</a>
    						<a href="">女单</a>
    						<a href="">跑步鞋</a>
    						<a href="">361°运动鞋</a>
    					</span>
    				</td>
    			</tr>
    		</table>
    	</form>
    	</div>
    </div>
    <div id="top_bottom">
    	<span>
    		<a href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action" 
    		   id="top_title" title="首页"><span id="top_title">首页</span></a>&nbsp;|&nbsp;
    		<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001" 
    		   id="top_title" title="运动鞋"><span id="top_title">运动鞋</span></a>&nbsp;|&nbsp;
    		<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200002" 
    		   id="top_title" title="男鞋"><span id="top_title">男鞋</span></a>&nbsp;|&nbsp;
    		<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003" 
    		   id="top_title" title="女鞋"><span id="top_title">女鞋</span></a>&nbsp;|&nbsp;
    		<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200004" 
    		   id="top_title" title="童鞋"><span id="top_title">童鞋</span></a>&nbsp;|&nbsp;
    		<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200005"
    		   id="top_title" title="户外鞋"><span id="top_title">户外鞋</span></a>&nbsp;|
    		<a href="${pageContext.request.contextPath}/goods/brand_getAllBrands.action" target="_blank"
    		   id="top_title" title="品牌"><span id="top_title">品牌</span></a>
    	</span>
    </div>
    <div id="top_hr">
    	<img  src="${pageContext.request.contextPath }/images/proscenium/topHR.jpg">
    </div>
  </body>
</html>
