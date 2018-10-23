<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>拍鞋网--中国最大品牌鞋网上商城</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/showCategoryGoods.css" type="text/css"></link>

  </head>
  
  <body>
	<div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div id="categoryLeft">
    		<div class="left_cateogry"> 
    			<jsp:include page="/WEB-INF/page/proscenium/goods/goodsCategory.jsp" />
    		</div>
    		<div class="left_recommendGoods">
				<jsp:include page="/WEB-INF/page/proscenium/goods/recommendGoodsCategory.jsp" />
    		</div>
    		<div class="left_scanGoods">
    			<jsp:include page="/WEB-INF/page/proscenium/goods/scanedGoods.jsp" />
    		</div>
    	</div>
    	<div id="categoryRight">
    		<div class="right_location">
    			<a href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action" class="position">首页</a>
    			<span class="ssjg">&gt;&nbsp;搜索结果:</span ><span class="cxtj">${queryString }</span>
    		</div>
    		<div class="right_goods">
    			<jsp:include page="/WEB-INF/page/proscenium/goods/categoryGoods.jsp" />
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
