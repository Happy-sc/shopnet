<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
	<title>评论</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/goodsComment.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/index.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/comment.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		您现在的位置:
    		<a href="">首页</a>&nbsp;&gt;&nbsp;
    		<a href="">${goods.brand.brandName }网上专卖店</a>&nbsp;&gt;&nbsp;
    		<a href="">${goods.goodsName }</a>
    	</div>
    	<div class="goodsComment_left">
    		<div class="grade">
    			<div class="content">
    				<table border="0">
    					<tr>
    					<td rowspan="5" width="130px" align="center">
    						<font class="pjz">${sumAvg }</font><font class="fen">分</font><Br/>
    						<font class="myzhzs">满意综合指数</font><br/>
    						<font class="pjrs">(共有${commentSum}人参与评价)</font>
    					</td>
    					<td width="80px" align="right"><font class="gkpf">顾客评分&nbsp;</font></td>
    					<td width="130px">
    						5分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						(${sum_5 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    						4分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						(${sum_4 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    						3分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						(${sum_3 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    						2分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						(${sum_2 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td> 
    					<td>
    						1分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    						(${sum_1 }人)
    					</td>
    				</tr>
    			</table>
    			</div>
    			<div class="share">
    				分享到:
    			</div>
    		</div>
    		<div class="commentContent">
    			<c:forEach items="${comments}" var="c">
    				<div class="comment_content">
    				<table border="0">
    					<tr>
    						<td width="3%"><img src="${pageContext.request.contextPath }/images/proscenium/commentx.jpg"/></td>
    						<td align="left" width="60%">
    							${c.commentContent }
    						</td>
    						<td rowspan="2" width="5%"></td>
    						<td align="right" width="35%">用户名:${c.users.userName }&nbsp;&nbsp;发表于:${c.commentTime }</td>
    					</tr>
    					<tr>
    						<td></td>
    						<td></td>
    						<td align="right">
    							买家评分:
    							<c:forEach begin="1" end="${c.commentGrade}">
    								<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg"/>
    							</c:forEach>	
    							<c:forEach begin="0" end="${5-c.commentGrade}">
    								<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg"/>
    							</c:forEach>
    						</td>
    					</tr>
    				</table>
    				</div>
    			</c:forEach>
    		</div>
    		<div class="page">
    			<c:choose>
    				<c:when test="${pageSum>1}">
    					<c:choose>
    						<c:when test="${pageSum<5}">
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${pageSum-1}"><span class="sxyy">上一页</span></a>
    							<c:forEach begin="1" end="${pageSum}" var="p">
    								<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${p}"><span>${p}</span></a>
    							</c:forEach>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${nowPage+1}"><span class="sxyy">下一页</span></a>
    						</c:when>
    						<c:otherwise>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${nowPage-1}"><span class="sxyy">上一页</span></a>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${1}"><span>1</span></a>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${2}"><span>2</span></a>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${3}"><span>3</span></a>
    							...
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${pageSum-1}"><span>${pageSum-1}</span></a>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${pageSum}"><span>${pageSum}</span></a>
    							<a href="${pageContext.request.contextPath }/userCenter/collect_seeCollection.action?page=${pageSum+1}"><span class="sxyy">下一页</span></a>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
    		</div>
    	</div>
    	
    	<div class="goodsComment_right">
    		<div class="goods">
    			<div class="sccgDIV">
     				<font>收藏成功</font>
     				<a href="javascript:void(0);">&Chi;</a>
    			</div>
   				 <div class="scsbDIV">
    				<font>该商品已经收藏了</font>
    				<a href="javascript:void(0);">&Chi;</a>
   				 </div>
    			<div class="title">
    				&nbsp;&nbsp;商品信息
    			</div>
    			<div class="content">
    				<ul>
    					<li>
    						<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goods.goodsId}" target="_blank">
    							<img src="${goods.goodsImage}" width="180" height="120"/>
    						</a>
    					</li>
    					<li>${goods.goodsName }</li>
    					<li>价格：<font>￥${goods.goodsMarketPrice }</font></li>
    					<li>
    						<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goods.goodsId}" target="_blank">
    							<img src="${pageContext.request.contextPath }/images/proscenium/seeGoods.jpg" />
    						</a>
    						<a href="javascript:void(0);" id="collect">
    							<input type="hidden" value="${goods.goodsId }" id="goodsId"/>
    							<img src="${pageContext.request.contextPath }/images/proscenium/collect.jpg"/>
    						</a>
    					</li>
    				</ul>
    			</div>
    		</div>
    		<div class="pjxz">
    			<div class="title">
    				评价须知
    			</div>
    			<div class="content">
    				<ul>
    					<li>1.请如实对商品进行评价。</li>
    					<li>2.不仅评价商品的好与坏,更重要的是<Br/>&nbsp;&nbsp;阐述自己的观点和理由,以帮助其他<br/>&nbsp;&nbsp;客户判断该商品是否适合自己。</li>
    					<li>3.对此商品进行评价,请点击我要评<br/>&nbsp;&nbsp;价。</li>
    					<li>4.只有购买过此商品的用户才能进行<br/>&nbsp;&nbsp;评价。</li>
    				</ul>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>