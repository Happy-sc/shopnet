<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  </head>

  <body>
    <div id="index_category">
    	<div id="index_category_left">
    		<jsp:include page="/WEB-INF/page/proscenium/goods/category.jsp" />
    	</div >
    	<div id="index_category_right">
    		<jsp:include page="/WEB-INF/page/proscenium/goods/5Scroll.jsp" />
    	</div>
    </div>
    <div id="index_brand">
   		<jsp:include page="/WEB-INF/page/proscenium/goods/brand.jsp" />
    </div>
    <div id="index_recommend">
    	<jsp:include page="/WEB-INF/page/proscenium/goods/showRecommendGoods.jsp" />
    </div>
     <div id="index_sneaker">
    	<jsp:include page="/WEB-INF/page/proscenium/goods/showSneakers.jsp" />
    </div>
    <div id="index_manShoes">
    	<jsp:include page="/WEB-INF/page/proscenium/goods/showManShoes.jsp" />
    </div>
    <div id="index_womanShoes">
    	<jsp:include page="/WEB-INF/page/proscenium/goods/showWomanShoes.jsp" />
    </div>
    <div id="index_childrenShoes">
    	<jsp:include page="/WEB-INF/page/proscenium/goods/showChildredShoes.jsp" />
    </div>
    <div id="index_outdoorShoes">
    	<jsp:include page="/WEB-INF/page/proscenium/goods/showOutdoorsShoes.jsp" />
    </div>
  </body>
</html>
