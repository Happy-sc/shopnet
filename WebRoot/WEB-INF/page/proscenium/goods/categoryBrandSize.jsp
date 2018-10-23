<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  
  </head>
  
  <body>
    	<div id="brandSize">
    		<div class="brandHide">
    			<table class="brandSize_table" border="0">
    				<tr>
    					<td width="15%" >
    						<span class="brandSize_textTitle">&nbsp;&nbsp;&nbsp;&nbsp;你已选择：</span>
    						<form action="${pageContext.request.contextPath }/">
    							<input type="hidden" id="category" name="goodsQuery.category" value=${goodsQuery.category }/>
    							<input type="hidden" id="style" name="goodsQuery.style" value=${goodsQuery.style }/>
    							<input type="hidden" id="brand" name="goodsQuery.brand" value=${goodsQuery.brand }/>
    							<input type="hidden" id="order" name="goodsQuery.order" value=${goodsQuery.order }/>
    							<input type="hidden" id="goodsSize" name="goodsQuery.goodsSize" value=${goodsQuery.goodsSize } />
    							<input type="hidden" id="goodsPrice" name="goodsQuery.goodsPrice" value=${goodsQuery.goodsPrice }/>
    						</form>
    					</td>
    					<td>
    						<div id="choosdOption">
    							
    						</div>
    					</td>
    				</tr>
    			</table>
    		</div>
    		<c:if test="${category.categoryId=='000001'||category.categoryId=='000004'||category.categoryId=='000005'}">
    			<div class="category_sex">
    			<table class="brandSize_table" border="0">
    				<tr>
    					<td width="15%" align="center"><span class="brandSize_textTitle">性别：</span></td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="chooseSex('sex')">男性</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="chooseSex('sex')">女性</a>
    					</td>
    					<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
    				</tr>
    			</table>
    			<img src="${pageContext.request.contextPath }/images/proscenium/category_hr.jpg" width="100%"/>
    		</div>
    		</c:if>
    		<div class="category_brand">
    			<table class="brandSize_table" border="0">
    				<tr>
    					<td width="15%" align="center"><span class="brandSize_textTitle">品牌：</span></td>
    					<td colspan="6">
    						<table width="100%">
    							<c:forEach begin="1" end="${brandNumber}" var="i">
    								<tr>
    									<c:forEach begin="1" end="6" var="j">
    										<c:set var="b" value="${brand[(j-1)+(i-1)*6]}"></c:set>
    										<td width="16.7%">
    											<a href="javascript:void(0);" class="a1" onclick="chooseBrand('brand','${b.brandId}')">
    												${b.brandName}
    											</a>
    										</td>
    									</c:forEach>
    								</tr>
    							</c:forEach>
    						</table>
    					</td>
    				</tr>
    			</table>
    			<img src="${pageContext.request.contextPath }/images/proscenium/category_hr.jpg" width="100%"/>
    		</div>
    		<div class="category_price">
    			<table class="brandSize_table" border="0">
    				<tr>
    					<td width="15%" align="center"><span class="brandSize_textTitle">价格：</span></td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">0-99元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">100-199元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">200-299元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">300-399元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">400-599元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">600-799元</a>
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">800-999元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">1000元以上</a>
    					</td>
    					<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
    				</tr>
    			</table>
    			<img src="${pageContext.request.contextPath }/images/proscenium/category_hr.jpg" width="100%"/>
    		</div>
    		<div class="category_size">
    			<table class="brandSize_table" border="0">
    				<tr>
    					<td width="15%" align="center"><span class="brandSize_textTitle">尺码：</span></td>
    					<c:if test="${category.categoryId=='200001'||category.categoryId=='200002'||category.categoryId=='200005'}">
    						<td colspan="6">
    							<table width="100%">
    								<tr>
    									<c:forEach begin="35" end="46"  var="i">
    										<td><div><a href="javascript:void(0);" onclick="chooseSize('size')">${i}</a></div></td>
    									</c:forEach>
    								</tr>
    							</table>
    						</td>
    					</c:if>
    					<c:if test="${category.categoryId=='000003'}">
    						<td colspan="6">
    							<table width="100%">
    								<tr>
    									<c:forEach begin="32" end="43"  var="i">
    										<td><div><a href="javascript:void(0);" onclick="chooseSize('size')">${i}</a></div></td>
    									</c:forEach>
    								</tr>
    							</table>
    						</td>
    					</c:if>
    					<c:if test="${category.categoryId=='200004'}">
    						<td colspan="6">
    							<table width="100%">
    								<tr>
    									<c:forEach begin="12" end="24"  var="i">
    										<td><div><a href="javascript:void(0);" onclick="chooseSize('size')">${i}</a></div></td>
    									</c:forEach>
    								</tr>
    							</table>
    						</td>
    					</c:if>
    				</tr>
    			</table>
    		</div>
    	</div>
  </body>
</html>
