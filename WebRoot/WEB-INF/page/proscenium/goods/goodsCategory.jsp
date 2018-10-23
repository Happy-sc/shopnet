<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/goodsCategory.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/goodsCategory.js"></script> 	
  </head>
  
  <body>
    <div class="areaSide">
    <div class="sortImage">
    	<img src="${pageContext.request.contextPath }/images/proscenium/goodsCategoryTitle.jpg"/> 
    	<input type="hidden" id="flcategoryId" value=${category.categoryId } />
    </div>
    <div class="sort">
	 <div id="sortTitle" onclick="showOrHideStyle(1)">
	  		<table width="100%">
	  			<tr>
	  				<td width="90%">
	  					<span>运动鞋</span>
	  				</td>
	  				<td align="right">
	  					<img src="${pageContext.request.contextPath }/images/proscenium/+.jpg" id="sortTitleImage_1" onclick="showOrHideStyle(1)">
	  				</td>
	  			</tr>
	  		</table>
	  </div>
	  
      <ul id="style_1" class="hide">
      		<li class="allshoes"><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001"><strong>所有运动鞋</strong></a></li> 
	         <c:forEach items="${sneakersStyles}" var="s">
	         	<li><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200001&style=${s.styleId}">
	         		<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg">&nbsp;&nbsp;${s.styleName}
	         	</a></li>  
			</c:forEach> 
       </ul>
       
	   <div id="sortTitle" onclick="showOrHideStyle(2)">
	  		<table width="100%">
	  			<tr>
	  				<td>
	  					<span>男鞋</span>
	  				</td>
	  				<td align="right">
	  					<img src="${pageContext.request.contextPath }/images/proscenium/+.jpg" id="sortTitleImage_2" onclick="showOrHideStyle(2)">
	  				</td>
	  			</tr>
	  		</table>
	  </div>
      <ul id="style_2" class="hide">
      	  	<li class="allshoes"><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200002"><strong>所有男鞋</strong></a></li> 
	         <c:forEach items="${menShoesStyles}" var="s">
	         	<li><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200002&style=${s.styleId}">
	         		<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg">&nbsp;&nbsp;${s.styleName}
	         	</a></li>  
			</c:forEach> 
       </ul>
                  
	    <div id="sortTitle" onclick="showOrHideStyle(3)">
	  		<table width="100%">
	  			<tr>
	  				<td>
	  					<span>女鞋</span>
	  				</td>
	  				<td align="right">
	  					<img src="${pageContext.request.contextPath }/images/proscenium/+.jpg" id="sortTitleImage_3" onclick="showOrHideStyle(3)">
	  				</td>
	  			</tr>
	  		</table>
	  </div>
       <ul id="style_3" class="hide">
      	  <li class="allshoes"><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003"><strong>所有女鞋</strong></a></li>
	  	  	 <c:forEach items="${womenShoesStyles}" var="s">
	         	<li><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200003&style=${s.styleId}">
	         		<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg">&nbsp;&nbsp;${s.styleName}
	         	</a></li>  
			</c:forEach> 
       </ul>
            
	     <div id="sortTitle" onclick="showOrHideStyle(4)">
	  		<table width="100%">
	  			<tr>
	  				<td>
	  					<span>童鞋</span>
	  				</td>
	  				<td align="right">
	  					<img src="${pageContext.request.contextPath }/images/proscenium/+.jpg" id="sortTitleImage_4" onclick="showOrHideStyle(4)">
	  				</td>
	  			</tr>
	  		</table>
	  </div>
      	<ul id="style_4" class="hide">
      	  <li class="allshoes"><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200004"><strong>所有童鞋</strong></a></li>
	         <c:forEach items="${childrenShoeStyles}" var="s">
	         	<li><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200004&style=${s.styleId}">
	         		<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg">&nbsp;&nbsp;${s.styleName}
	         	</a></li>  
			</c:forEach> 
        </ul>
        
	    <div id="sortTitle" onclick="showOrHideStyle(5)">
	  		<table width="100%">
	  			<tr>
	  				<td>
	  					<span>户外鞋</span>
	  				</td>
	  				<td align="right">
	  					<img src="${pageContext.request.contextPath }/images/proscenium/+.jpg" id="sortTitleImage_5" onclick="showOrHideStyle(5)">
	  				</td>
	  			</tr>
	  		</table>
	  </div>
      <ul id="style_5" class="hide">
      	  <li class="allshoes"><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200005"><strong>所有户外鞋</strong></a></li>
	         <c:forEach items="${outdoorShoeStyles}" var="s">
	         	<li><a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=200005&style=${s.styleId}">
	         		<img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg">&nbsp;&nbsp;${s.styleName}
	         	</a></li>  
			</c:forEach> 
          </ul>
       </div>
    </div>
  </body>
</html>
