<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
	<title>品牌大全 - 品牌导航</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/showAllBrands.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/index.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/showAllBrands.js"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="brand_category">
    		<ul>
    			<li class="daquan"><div><img src="${pageContext.request.contextPath }/images/proscenium/brands/daquan_01.jpg"></div></li>
    			<li class="sneaker"><div><img src="${pageContext.request.contextPath }/images/proscenium/brands/sneaker_01.jpg"></div></li>
    			<li class="man"><div><img src="${pageContext.request.contextPath }/images/proscenium/brands/man_01.jpg"></div></li>
    			<li class="woman"><div><img src="${pageContext.request.contextPath }/images/proscenium/brands/woman_01.jpg"></div></li>
    			<li class="children"><div><img src="${pageContext.request.contextPath }/images/proscenium/brands/children_01.jpg"></div></li>
    			<li class="outdoor"><div><img src="${pageContext.request.contextPath }/images/proscenium/brands/outdoor_01.jpg"></div></li>
    		</ul>
    	</div>
    	<div class="brand_main">
    		<div class="daquanBrands" class="show">
    			<jsp:include page="/WEB-INF/page/proscenium/goods/showAllBrandsSpell.jsp" />
    		</div>
    		
    		<div class="sneakerBrands" >
    		<div class="categoryBrandsHr"></div>
    			<div class="categoryBrandsTitle">
    				<span>运动鞋</span>
    			</div>
    			<div class="categoryBrandsMain">
    				<table>
    					<c:forEach begin="1" end="${sneakerBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==sneakerBrands_rows}">
    								<c:forEach begin="1" end="${sneakerBrands_num}" var="j">
    									<c:set var="b" value="${sneakerBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${sneakerBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="manBrands" class="hide">
    			<div class="spellBrandsHr"></div>
    			<div class="categoryBrandsTitle">
    				<span>男鞋</span>
    			</div>
    			<div class="categoryBrandsMain">
    				<table>
    					<c:forEach begin="1" end="${manBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==manBrands_rows}">
    								<c:forEach begin="1" end="${manBrands_num}" var="j">
    									<c:set var="b" value="${manBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${manBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="womanBrands" class="hide">
    		<div class="spellBrandsHr"></div>
    			<div class="categoryBrandsTitle">
    				<span>女鞋</span>
    			</div>
    			<div class="categoryBrandsMain">
    			<table>
    					<c:forEach begin="1" end="${womanBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==womanBrands_rows}">
    								<c:forEach begin="1" end="${womanBrands_num}" var="j">
    									<c:set var="b" value="${womanBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${womanBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="childrenBrands" class="hide">
    		<div class="spellBrandsHr"></div>
    			<div class="categoryBrandsTitle">
    				<span>儿童鞋</span>
    			</div>
    			<div class="categoryBrandsMain">
    			<table>
    					<c:forEach begin="1" end="${childrenBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==childrenBrands_rows}">
    								<c:forEach begin="1" end="${childrenBrands_num}" var="j">
    									<c:set var="b" value="${childrenBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${childrenBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="outdoorBrands" class="hide">
    		<div class="spellBrandsHr"></div>
    			<div class="categoryBrandsTitle">
    				<span>户外鞋</span>
    			</div>
    			<div class="categoryBrandsMain   ">
    			<table>
    					<c:forEach begin="1" end="${outdoorBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==outdoorBrands_rows}">
    								<c:forEach begin="1" end="${outdoorBrands_num}" var="j">
    									<c:set var="b" value="${outdoorBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${outdoorBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    	</div>
    	<div class="brandHr"></div>
    	<div class="brand_tips">
    		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鞋子品牌大全为您提供世界鞋子品牌排名信息,可以了解到比较好的鞋子品牌有哪些,女鞋子品牌
    		有哪些,男生鞋子品牌有哪些,真皮的鞋子品牌哪种好等信息。包括男士鞋子品牌大全,女性鞋子品牌大全,女性鞋子品牌,儿童
    		鞋子品牌,女鞋鞋子品牌等信息。其中国外鞋子品牌大全提供国外鞋子品牌排名信息,如欧美鞋子品牌:美国鞋子品牌,意大利
    		鞋子品牌,韩国鞋子品牌大全,日本鞋子品牌等信息。还有国内鞋子品牌信息如香港鞋子品牌大全,国际鞋子品牌大全,国内运
    		动鞋子品牌,男士休闲鞋子品牌,户外鞋子品牌,板鞋鞋子品牌,运动鞋鞋子品牌,休闲鞋鞋子品牌,时尚鞋子品牌,女鞋子品牌加
    		盟,女鞋子品牌排名以及鞋子品牌图片,鞋子品牌标志,鞋子品牌折扣店,鞋子品牌加盟店等时尚鞋子品牌排行榜信息。</span>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
