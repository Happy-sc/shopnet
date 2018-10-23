<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>	
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/indexCategory.css" type="text/css"></link>
	</head>
	<body>
		<div class="indexCategory_title"><span>&nbsp; 商品分类</span></div>
		<ul>
			<li class="indexCategory_sneaker">
				<div class="sneaker_title">
					<table>
						<tr>
							<td align="right" width="30%"><img src="${pageContext.request.contextPath }/images/proscenium/index_categorySneaker_01.jpg"/></td>
							<td align="left" width="30%" class="flmcTd"><span class="categoryTitle">运动鞋</span></td>
							<td align="right" class="xytp"><img src="${pageContext.request.contextPath }/images/proscenium/index_category.jpg"/></td>
						</tr>
						<tr>
							<c:forEach begin="1" end="3" var="i">
								<c:set value="${sneakersStyles[i]}" var="s"></c:set>
								<td align="center">
								<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&style=${s.styleId}">${s.styleName }</a></td>
							</c:forEach>
						</tr>
					</table>
				</div>
				<div class="sneakerDetail">
				<div class="detailLeft">
				<div class="left_style">
					<div class="style_title">
						<span>热卖款式</span>
					</div>
					<div class="style_content">
						<table cellpadding="3">
							<c:forEach begin="0" end="${senakersSum}" var="i">
								<c:set value="${sneakersStyles[2*i]}" var="s1" />
								<c:set value="${sneakersStyles[2*i+1]}" var="s2" />
								<tr>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&style=${s1.styleId}">${s1.styleName }</a></td>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&style=${s2.styleId}">${s2.styleName }</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="left_price">
					<div class="price_title">
						<span>价格区域</span>
					</div>
					<div class="price_content">
						<table cellpadding="3">
							<tr>
								<td><a href="">0-99元</a></td>
								<td><a href="">100-199元</a></td>
							</tr>
							<tr>
								<td><a href="">200-299元</a></td>
								<td><a href="">300-399元</a></td>
							</tr>
							<tr>
								<td><a href="">400-599元</a></td>
								<td><a href="">600-799元</a></td>
							</tr>
							<tr>
								<td><a href="">800-999元</a></td>
								<td><a href="">1000元以上</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			
			<div class="detailRight">
				<div class="brand_title">
					<span>热卖品牌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="">更多</a>
				</div>
				<div class="brand_content">
					<table>
						<c:forEach begin="1" end="5" var="j">
							<c:set value="${sneakerBrands[2*j]}" var="b1"></c:set>
							<c:set value="${sneakerBrands[2*j+1]}" var="b2"></c:set>
							<tr>
								<td><img src="${b1.brandImage}" width="80" height="50"/></td>
								<td><img src="${b2.brandImage}" width="80" height="50"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				</div>
				</div>
			</li >
			
			<li class="indexCategory_woman">
				<div class="woman_title">
					<table>
					<tr>
						<td align="right" width="30%"><img src="${pageContext.request.contextPath }/images/proscenium/index_categoryWoman.jpg"/></td>
						<td align="left" width="30%" class="flmcTd"><span class="categoryTitle">女鞋</span></td>
						<td align="right" class="xytp"><img src="${pageContext.request.contextPath }/images/proscenium/index_category.jpg"/></td>
					</tr>
					<tr>
						<c:forEach begin="1" end="3" var="i">
							<c:set value="${womenShoesStyles[i]}" var="s"></c:set>
							<td align="center">
								<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003&style=${s.styleId}">${s.styleName }</a></td>
						</c:forEach>
					</tr>
					</table>
				</div>
				
				<div class="womanDetail">
				<div class="detailLeft">
				<div class="left_style">
					<div class="style_title">
						<span>热卖款式</span>
					</div>
					<div class="style_content">
						<table cellpadding="3">
							<c:forEach begin="0" end="${womenSum}" var="i">
								<c:set value="${womenShoesStyles[2*i]}" var="s1" />
								<c:set value="${womenShoesStyles[2*i+1]}" var="s2" />
								<tr>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003&style=${s1.styleId}">${s1.styleName }</a></td>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003&style=${s2.styleId}">${s2.styleName }</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="left_price">
					<div class="price_title">
						<span>价格区域</span>
					</div>
					<div class="price_content">
						<table cellpadding="3">
							<tr>
								<td><a href="">0-99元</a></td>
								<td><a href="">100-199元</a></td>
							</tr>
							<tr>
								<td><a href="">200-299元</a></td>
								<td><a href="">300-399元</a></td>
							</tr>
							<tr>
								<td><a href="">400-599元</a></td>
								<td><a href="">600-799元</a></td>
							</tr>
							<tr>
								<td><a href="">800-999元</a></td>
								<td><a href="">1000元以上</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			
			<div class="detailRight">
				<div class="brand_title">
					<span>热卖品牌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="">更多</a>
				</div>
				<div class="brand_content">
					<table>
						<c:forEach begin="1" end="5" var="j">
							<c:set value="${womenBrands[2*j]}" var="b1"></c:set>
							<c:set value="${womenBrands[2*j+1]}" var="b2"></c:set>
							<tr>
								<td><img src="${b1.brandImage}" width="80" height="50"/></td>
								<td><img src="${b2.brandImage}" width="80" height="50"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				</div>
				</div>
			</li>
			
			<li class="indexCategory_man">
				<div class="man_title">
					<table>
					<tr>
						<td align="right" width="30%"><img src="${pageContext.request.contextPath }/images/proscenium/index_categoryMan.jpg"/></td>
						<td align="left" width="30%" class="flmct"><span class="categoryTitle">男鞋</span></td>
						<td align="right" class="xytp"><img src="${pageContext.request.contextPath }/images/proscenium/index_category.jpg"/></td>
					</tr>
					<tr>
						<c:forEach begin="1" end="3" var="i">
							<c:set value="${menShoesStyles[i]}" var="s"></c:set>
							<td align="center">
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200002&style=${s.styleId}">${s.styleName }</a></td>
						</c:forEach>
					</tr>
					</table>
				</div>
				
				<div class="manDetail">
				<div class="detailLeft">
				<div class="left_style">
					<div class="style_title">
						<span>热卖款式</span>
					</div>
					<div class="style_content">
						<table cellpadding="3">
							<c:forEach begin="0" end="${menSum}" var="i">
								<c:set value="${menShoesStyles[2*i]}" var="s1" />
								<c:set value="${menShoesStyles[2*i+1]}" var="s2" />
								<tr>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200002&style=${s1.styleId}">${s1.styleName }</a></td>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200002&style=${s2.styleId}">${s2.styleName }</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="left_price">
					<div class="price_title">
						<span>价格区域</span>
					</div>
					<div class="price_content">
						<table cellpadding="3">
							<tr>
								<td><a href="">0-99元</a></td>
								<td><a href="">100-199元</a></td>
							</tr>
							<tr>
								<td><a href="">200-299元</a></td>
								<td><a href="">300-399元</a></td>
							</tr>
							<tr>
								<td><a href="">400-599元</a></td>
								<td><a href="">600-799元</a></td>
							</tr>
							<tr>
								<td><a href="">800-999元</a></td>
								<td><a href="">1000元以上</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="detailRight">
				<div class="brand_title">
					<span>热卖品牌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="">更多</a>
				</div>
				<div class="brand_content">
					<table>
						<c:forEach begin="1" end="5" var="j">
							<c:set value="${menBrands[2*j]}" var="b1"></c:set>
							<c:set value="${menBrands[2*j+1]}" var="b2"></c:set>
							<tr>
								<td><img src="${b1.brandImage}" width="80" height="50"/></td>
								<td><img src="${b2.brandImage}" width="80" height="50"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			</div>
			</li>
			
			<li class="indexCategory_children">
				<div class="children_title">
					<table>
					<tr>
						<td align="right" width="30%"><img src="${pageContext.request.contextPath }/images/proscenium/index_categoryChildren.jpg"/></td>
						<td align="left" width="30%" class="flmcTd"><span class="categoryTitle">儿童鞋</span></td>
						<td align="right" class="xytp"><img src="${pageContext.request.contextPath }/images/proscenium/index_category.jpg"/></td>
					</tr>
					<tr>
						<c:forEach begin="1" end="3" var="i">
							<c:set value="${childrenShoeStyles[i]}" var="s"></c:set>
							<td align="center">
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200004&style=${s.styleId}">${s.styleName }</a></td>
						</c:forEach>
					</tr>
					</table>
				</div>
				<div class="childrenDetail">
				<div class="detailLeft">
				<div class="left_style">
					<div class="style_title">
						<span>热卖款式</span>
					</div>
					<div class="style_content">
						<table cellpadding="3">
							<c:forEach begin="0" end="${chilidrenSum}" var="i">
								<c:set value="${childrenShoeStyles[2*i]}" var="s1" />
								<c:set value="${childrenShoeStyles[2*i+1]}" var="s2" />
								<tr>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200004&style=${s1.styleId}">${s1.styleName }</a></td>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200004&style=${s2.styleId}">${s2.styleName }</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="left_price">
					<div class="price_title">
						<span>价格区域</span>
					</div>
					<div class="price_content">
						<table cellpadding="3">
							<tr>
								<td><a href="">0-99元</a></td>
								<td><a href="">100-199元</a></td>
							</tr>
							<tr>
								<td><a href="">200-299元</a></td>
								<td><a href="">300-399元</a></td>
							</tr>
							<tr>
								<td><a href="">400-599元</a></td>
								<td><a href="">600-799元</a></td>
							</tr>
							<tr>
								<td><a href="">800-999元</a></td>
								<td><a href="">1000元以上</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="detailRight">
				<div class="brand_title">
					<span>热卖品牌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="">更多</a>
				</div>
				<div class="brand_content">
					<table>
						<c:forEach begin="1" end="5" var="j">
							<c:set value="${childrenBrands[2*j]}" var="b1"></c:set>
							<c:set value="${childrenBrands[2*j+1]}" var="b2"></c:set>
							<tr>
								<td><img src="${b1.brandImage}" width="80" height="50"/></td>
								<td><img src="${b2.brandImage}" width="80" height="50"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			</div>
			</li>
			
			<li class="indexCategory_outdoor">
				<div class="outdoor_title">
					<table>
					<tr>
						<td align="right" width="30%"><img src="${pageContext.request.contextPath }/images/proscenium/index_categoryOutdoor.jpg"/></td>
						<td align="left" width="30%" class="flmcTd"><span class="categoryTitle">户外鞋</span></td>
						<td align="right" class="xytp"><img src="${pageContext.request.contextPath }/images/proscenium/index_category.jpg"/></td>
					</tr>
					<tr>
						<c:forEach begin="1" end="3" var="i">
							<c:set value="${outdoorShoeStyles[i]}" var="s"></c:set>
							<td align="center">
							<a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200005&style=${s.styleId}" >${s.styleName }</a></td>
						</c:forEach>
					</tr>
					</table>
				</div>
				<div class="outdoorDetail">
			<div class="detailLeft">
				<div class="left_style">
					<div class="style_title">
						<span>热卖款式</span>
					</div>
					<div class="style_content">
						<table cellpadding="3">
							<c:forEach begin="0" end="${outdoorSum}" var="i">
								<c:set value="${outdoorShoeStyles[2*i]}" var="s1" />
								<c:set value="${outdoorShoeStyles[2*i+1]}" var="s2" />
								<tr>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200005&style=${s1.styleId}">${s1.styleName }</a></td>
									<td><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200005&style=${s2.styleId}">${s2.styleName }</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div class="left_price">
					<div class="price_title">
						<span>价格区域</span>
					</div>
					<div class="price_content">
						<table cellpadding="3">
							<tr>
								<td><a href="">0-99元</a></td>
								<td><a href="">100-199元</a></td>
							</tr>
							<tr>
								<td><a href="">200-299元</a></td>
								<td><a href="">300-399元</a></td>
							</tr>
							<tr>
								<td><a href="">400-599元</a></td>
								<td><a href="">600-799元</a></td>
							</tr>
							<tr>
								<td><a href="">800-999元</a></td>
								<td><a href="">1000元以上</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="detailRight">
				<div class="brand_title">
					<span>热卖品牌</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="">更多</a>
				</div>
				<div class="brand_content">
					<table>
						<c:forEach begin="1" end="5" var="j">
							<c:set value="${outdoorBrands[2*j]}" var="b1"></c:set>
							<c:set value="${outdoorBrands[2*j+1]}" var="b2"></c:set>
							<tr>
								<td><img src="${b1.brandImage}" width="80" height="50"/></td>
								<td><img src="${b2.brandImage}" width="80" height="50"/></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
			</li>
		</ul>
	</body>
</html>
