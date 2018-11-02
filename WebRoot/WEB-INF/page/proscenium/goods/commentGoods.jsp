<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/commentGoods.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/commentGoods.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div id="top">
    	<div id="top_top">
    		<jsp:include page="/WEB-INF/page/proscenium/index_topT.jsp"></jsp:include>
    	</div>
    	<div id="top_main">
    		<ul>
    			<li style="width: 40%">
    				<img src="${pageContext.request.contextPath }/images/proscenium/paixie.jpg"/>
    			</li>
    			<li style="width: 60%">
    			<form action="${pageContext.request.contextPath }/search/searchGoods.action" method="POST">
    			<table style="width: 80%">
    				<tr>
    					<td valign="top" id="searchTd">
    						<img  src="${pageContext.request.contextPath }/images/proscenium/search.jpg" id="searchIMG">
    						<input type="text" class="searchContext" name="queryString" value="${queryString }">
    					</td>
    					<td width="20%"><input type="image" src="${pageContext.request.contextPath }/images/proscenium/searchbutton.jpg"/></td>
    				</tr>
    			</table>
    			</form>
    			</li>
    		</ul>
    	</div>
    </div>
    <div id="main">
  		<div class="comment_title">
  			<ul class="commentUL">
  				<li style="width: 15%;background-color: #FE9900"><span>&nbsp;&nbsp;&nbsp;&nbsp;评价商品</span></li>
  				<li><img src="${pageContext.request.contextPath }/images/proscenium/commentTop.jpg"/></li>
  				<li style="width: 79.65%;background-color: #EDEDED"></li>
  			</ul>
  		</div>
  		<div class="comment_content">
  			<div class="comment_goods">
  				<table>
  					<tr>
  						<Td>
  							<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goods.goodsId}" target="_blank" title="点击查看商品详细信息">
  								<img src="${goods.goodsImage }" width="280px" height="280px"/>
  							</a>
  						</Td>
  					</tr>
  					<tr>
  						<td align="center">
  							<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goods.goodsId}" target="_blank" class="cgoods">
  								${goods.goodsName }
  							</a>
  						</td>
  					</tr>
  				</table>
  			</div>
  			<div class="comment_comment">
  				<form action="${pageContext.request.contextPath}/userCenter/comment_commentGoods.action" method="post" id="commentForm">
  				<table>
  					<tr>
  						<td><span class="daFenText">打分:</span>
  							<c:forEach begin="1" end="5" var="i">
  								<a href="javascript:void(0);" class="dafenA">
  									<img src="${pageContext.request.contextPath }/images/proscenium/dafen_11.jpg" class="daFenImg_${i }" title="${i }"/>
  								</a>
  							</c:forEach>
  							<input type="hidden" id="commentGrade" name="comment.commentGrade" value="0"/>
  							<input type="hidden" name="goodsId" value="${goods.goodsId}"/>
  							<input type="hidden" name="orderDetailId" value="${orderDetailId }"/>
  						</td>
  					</tr>
  					<tr>
  						<td><span class="daFenText">备注:</span>每次商品可以评价多次</td>
  					</tr>
  					<tr>
  						<td>
  							<textarea name="comment.commentContent"></textarea>
  						</td>
  					</tr>
  					<tr align="right">
  						<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/fbpl_01.jpg" id="fbpjImg"/>&nbsp;&nbsp;&nbsp;</td>
  					</tr>
  					<tr>
  						<td>1.请对商品进行如实的评价。</td>
  					</tr>
  					<tr>
  						<td>2.请对您的言行负责，并遵守中华人民共和国有关法律法规,尊重网上道德。</td>
  					</tr>
  					<tr>
  						<td>3.请根据本次的商品进行真实、客观、详细的评价。</td>
  					</tr>
  					<tr>
  						<td>4.您的评价将会是其他会员的参考,也将影响卖家的信誉。</td>
  					</tr>
  				</table>
  				</form>
  			</div>
  		</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>

