<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
	<title>【<s:property value="#request.category.categoryName"/>品牌大全】</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/showCategoryGoods.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/index.js"></script>
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
    	</div>
    	<div id="categoryRight">
    		<div class="right_location">
    			<a href="${pageContext.request.contextPath}/goods/goods_goodsIndexUI.action" class="position">首页</a>&nbsp;&gt;&nbsp;
    			<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=${category.categoryId }" class="nowPosition">${category.categoryName }</a>
    		</div>
    		<div class="right_brand">
    			<jsp:include page="/WEB-INF/page/proscenium/goods/categoryBrandSize.jsp" />
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
