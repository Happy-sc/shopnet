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
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">100-499元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">500-999元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">1000-4999元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">5000-9999元</a>
    					</td>
    					<td>
    						<a href="javascript:void(0);" class="a1" onclick="choosePrice('price');">10000元以上</a>
    					</td>
    				</tr>
    			</table>
    			<img src="${pageContext.request.contextPath }/images/proscenium/category_hr.jpg" width="100%"/>
    		</div>
    	</div>
  </body>
</html>
