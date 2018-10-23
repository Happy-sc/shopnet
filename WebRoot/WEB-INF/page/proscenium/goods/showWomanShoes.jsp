<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  </head>
  
  <body>
    <div id="index_showTop">
			<div id="index_showTop_top">
				<div id="index_showTop_top_left">
					<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003" target="_blank">
						<img  src="${pageContext.request.contextPath }/images/proscenium/index_womenShoes.jpg">
					</a>
				</div>
				<div id="index_showTop_top_right">
					<c:forEach begin="1" end="4" var="i">
						<c:set var="ss" value="${womenShoesStyles[i]}"></c:set>
						<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003&style=${ss.styleId}" target="_blank">
							${ss.styleName }&nbsp;|
						</a>
					</c:forEach>
					<a href="">100-199元</a>&nbsp;|
					<a href="">200-299员</a>
					<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003" target="_blank">
						<img id="allWomenShoes" src="${pageContext.request.contextPath }/images/proscenium/allWomenShoes_01.jpg"  title="全部女鞋">
					</a>
				</div>
			</div>
			<div id="index_showTop_hr">
				<img  src="${pageContext.request.contextPath }/images/proscenium/goods_hr.jpg" >
			</div>
		</div>
		<div id="index_showGoods">
			<table cellpadding="0" cellspacing="0" id="indexGoods_table">
				<c:forEach begin="1" end="2" var="i">
					<tr>
						<c:forEach begin="1" end="5" var="j">
							<c:set var="g" value="${womenShoes[(j-1)+(i-1)*5]}"></c:set>
							<td>
							<table border="0" id="imageTable">
								<tr>
									<td >
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">
											<img  src="${g.goodsImage}" id="goodsImg">
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">
											${g.goodsName}
										</a>
									</td>
								</tr>
								<tr>
									<td>
										<span id="index_marketPrice"><del>¥${g.goodsMarketPrice }</del></span>
										<span id="index_paixiePrice">¥${g.goodsPaiPrice }</span>
									</td>
								</tr>
							</table>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
			</table>
		</div>
  </body>
</html>
