<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	</head>
	<body>
		<div id="index_showTop">
			<div class="tab">
			<ul>
				<li id="one1" onmouseover="setTab('one',1,5)" class="now"> 
					热卖商品 
				</li>
				<li id="one2" onmouseover="setTab('one',2,5)">
					推荐商品
				</li>
				<li id="one3" onmouseover="setTab('one',3,5)">
					特价商品
				</li>
				<li id="one4" onmouseover="setTab('one',4,5)">
					新货入驻
				</li>
				<li id="one5" onmouseover="setTab('one',5,5)">
					清仓处理
				</li>
			</ul>
		</div>
		
		<div class="list">
			<div id="one_con1">
				<table cellpadding="0" cellspacing="0" id="recommendGoods_table" border="0">
				<c:forEach begin="1" end="2" var="i">
					<tr>
						<c:forEach begin="1" end="5" var="j">
							<c:set var="g" value="${bestSellerGoods[(j-1)+(i-1)*5]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank"><img  src="${g.goodsImage}" id="goodsImg"></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">${g.goodsName}</a>
									</td>
								</tr>
								<tr>
									<td>
										<span id="index_marketPrice">¥${g.goodsMarketPrice }</span>
									</td>
								</tr>
							</table>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
			</table>
			</div>
			<div id="one_con2" style="display: none;">
				<table cellpadding="0" cellspacing="0" id="recommendGoods_table" border="0">
				<c:forEach begin="1" end="2" var="i">
					<tr>
						<c:forEach begin="1" end="5" var="j">
							<c:set var="g" value="${recommendGoods[(j-1)+(i-1)*5]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank"><img  src="${g.goodsImage}" id="goodsImg"></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">${g.goodsName}</a>
									</td>
								</tr>
								<tr>
									<td>
										<span id="index_marketPrice">¥${g.goodsMarketPrice }</span>
									</td>
								</tr>
							</table>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
			</table>
			</div>
			<div id="one_con3" style="display: none;">
				<table cellpadding="0" cellspacing="0" id="recommendGoods_table" border="0">
				<c:forEach begin="1" end="2" var="i">
					<tr>
						<c:forEach begin="1" end="5" var="j">
							<c:set var="g" value="${specialOfferGoods[(j-1)+(i-1)*5]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank"><img  src="${g.goodsImage}" id="goodsImg"></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">${g.goodsName}</a>
									</td>
								</tr>
								<tr>
									<td>
										<span id="index_marketPrice">¥${g.goodsMarketPrice }</span>
									</td>
								</tr>
							</table>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
			</table>
			</div>
			<div id="one_con4" style="display: none;">
				<table cellpadding="0" cellspacing="0" id="recommendGoods_table" border="0">
				<c:forEach begin="1" end="2" var="i">
					<tr>
						<c:forEach begin="1" end="5" var="j">
							<c:set var="g" value="${newestGoods[(j-1)+(i-1)*5]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank"><img  src="${g.goodsImage}" id="goodsImg"></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">${g.goodsName}</a>
									</td>
								</tr>
								<tr>
									<td>
										<span id="index_marketPrice">¥${g.goodsMarketPrice }</span>
									</td>
								</tr>
							</table>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
			</table>
			</div>
			<div id="one_con5" style="display: none"> 
				<table cellpadding="0" cellspacing="0" id="recommendGoods_table" border="0">
				<c:forEach begin="1" end="2" var="i">
					<tr>
						<c:forEach begin="1" end="5" var="j">
							<c:set var="g" value="${lackGoods[(j-1)+(i-1)*5]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank"><img  src="${g.goodsImage}" id="goodsImg"></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">${g.goodsName}</a>
									</td>
								</tr>
								<tr>
									<td>
										<span id="index_marketPrice">¥${g.goodsMarketPrice }</span>
									</td>
								</tr>
							</table>
							</td>
						</c:forEach>
					</tr>
			</c:forEach>
			</table>
			</div>
		</div>
		</div>
	</body>
</html>
