<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm" %>
<html>
  <head>
  </head>
  
  <body>
		<div id="categoryGoods">
			<div class="categoryGoods_lable">
				<ul>
					<li class="paixu">
						排序:
					</li>
					<li id="one1" onclick="setLable('one',1,4)" class="now">
						<a href="" class="nowFont">默认推荐</a>
					</li>
					<li id="one2" onclick="setLable('one',2,4)" >
						<a href="">最低价</a>
					</li>
					<li id="one3" onclick="setLable('one',3,4)" >
						<a href="" >最热销</a>
					</li>
					<li id="one4" onclick="setLable('one',4,4)" >
						<a href="" >新品上市</a>
					</li>
				</ul>
			</div>
			<div class="categoryGoods_content">
				<c:choose>
					<c:when test="${rows!=0}">
					<div class="categoryGoods_goods">
					<table cellpadding="0" cellspacing="10" id="categoryGoods_table" >
					<c:forEach begin="1" end="${rows}" var="i">
					<tr><c:choose>
						<c:when test="${i==rows&&lastNumber!=0}">
							<c:forEach begin="1" end="${lastNumber}" var="j">
							<c:set var="g" value="${goods[(j-1)+(i-1)*4]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">
											<img  src="${g.goodsImage}" id="goodsImg" >
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
										市场价：<span class="scj">&yen;<del>${g.goodsMarketPrice }</del></span>
									</td>
								</tr>
							</table></td>
						</c:forEach>
						</c:when>
						<c:otherwise>
						<c:forEach begin="1" end="4" var="j">
							<c:set var="g" value="${goods[(j-1)+(i-1)*4]}"></c:set>
							<td>
							<table border="0">
								<tr>
									<td>
										<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${g.goodsId}" target="_blank">
											<img  src="${g.goodsImage}" id="goodsImg" >
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
										市场价：<span class="scj">&yen;<del>${g.goodsMarketPrice }</del></span>
									</td>
								</tr>
							</table></td>
						</c:forEach></c:otherwise></c:choose>
					</tr>
				</c:forEach>
				</table>
				</div>
				<div class="categoryPage">
					<c:choose>
						<c:when test="${pageSum<=10}">
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&page=${page-1}">
								<span>
									<img src="${pageContext.request.contextPath}/images/proscenium/lastPage.jpg" onmouseover="overPage()" id="22222">上一页
								</span>
							</a>
							<c:forEach begin="1" end="${pageSum}" var="i">
									<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&page=${i}">
										<span id="page">${i}</span>
									</a>
							</c:forEach>
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&page=${page+1}">
								<span>
									下一页<img src="${pageContext.request.contextPath}/images/proscenium/nextPage.jpg"/>
								</span>
							</a>
						</c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&page=${page-1}">
								<span>
									<img src="${pageContext.request.contextPath}/images/proscenium/lastPage.jpg"/>上一页
								</span>
							</a>
							<c:forEach begin="1" end="10" var="i">
									<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=000001&page=${i}">
										<span id="page">${i}</span>
									</a>
							</c:forEach>
							.....
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=000001&page=${pageSum}">
								<span id="page">${pageSum}</span>
							</a>
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=000001&page=${page+1}">
								<span >
									下一页<img src="${pageContext.request.contextPath}/images/proscenium/nextPage.jpg"/>
								</span>
							</a>
						</c:otherwise>
					</c:choose>
					</div>
					</c:when>
					<c:otherwise>
						<span class="goodsTips">对不起,没有该类商品,请重新选择...</span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
  </body>
</html>
