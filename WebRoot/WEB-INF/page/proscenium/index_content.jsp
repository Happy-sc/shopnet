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
    <%--<div id="index_manShoes">--%>
        <%--<div id="index_showTop">--%>
            <%--<div id="index_showTop_top">--%>
                <%--<div id="index_showTop_top_left">--%>
                    <%--<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001" target="_blank">--%>
                        <%--<img  src="${pageContext.request.contextPath }/images/proscenium/index_sneakers.jpg">--%>
                    <%--</a>--%>
                <%--</div>--%>
                <%--<div id="index_showTop_top_right">--%>
                    <%--<c:forEach begin="1" end="4" var="i">--%>
                        <%--<c:set var="ss" value="${sneakersStyles[i]}"></c:set>--%>
                        <%--<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&style=${ss.styleId}" target="_blank" >--%>
                                <%--${ss.styleName }&nbsp;|--%>
                        <%--</a>--%>
                    <%--</c:forEach>--%>
                    <%--<a href="">100-199元</a>&nbsp;|--%>
                    <%--<a href="">200-299员</a>--%>
                    <%--<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001" target="_blank">--%>
                        <%--<img id="allSneakers" src="${pageContext.request.contextPath }/images/proscenium/allSneakers_01.jpg" title="全部运动鞋">--%>
                    <%--</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div id="index_showTop_hr">--%>
                <%--<img  src="${pageContext.request.contextPath }/images/proscenium/goods_hr.jpg" >--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div id="index_showGoods">--%>
            <%--<table cellpadding="0" cellspacing="0" id="indexGoods_table">--%>
                <%--<c:forEach begin="1" end="2" var="i">--%>
                    <%--<tr>--%>
                        <%--<c:forEach begin="1" end="5" var="j">--%>
                            <%--<c:set var="g" value="${sneakers[(j-1)+(i-1)*5]}"></c:set>--%>
                            <%--<td>--%>
                                <%--<table border="0">--%>
                                    <%--<tr>--%>
                                        <%--<td>--%>
                                            <%--<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">--%>
                                                <%--<img  src="${g.goodsImage}" id="goodsImg">--%>
                                            <%--</a>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                    <%--<tr>--%>
                                        <%--<td>--%>
                                            <%--<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">--%>
                                                    <%--${g.goodsName}--%>
                                            <%--</a>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                    <%--<tr>--%>
                                        <%--<td>--%>
                                            <%--<span id="index_marketPrice">&nbsp;&nbsp;<del>&yen;${g.goodsMarketPrice }</del></span>--%>
                                            <%--&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                            <%--<span id="index_paixiePrice">&yen;${g.goodsPaiPrice }</span>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                <%--</table>--%>
                            <%--</td>--%>
                        <%--</c:forEach>--%>
                    <%--</tr>--%>
                <%--</c:forEach>--%>
            <%--</table>--%>
        <%--</div>--%>
    <%--</div>--%>
  </body>
</html>
