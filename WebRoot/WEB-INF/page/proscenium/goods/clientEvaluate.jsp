<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  </head>
  <body>
    <div class="commentMain">
    	<div class="comment_left">
    		<div class="title">
    			<div class="grade">
    				<table border="0" >
    				<tr>
    					<td rowspan="3" width="30%" align="center">
    						<font class="pjz">${sumAvg }</font><Br/>
    						<font class="myzhzs">满意综合指数</font>
    					</td>
    					<td width="20%" align="center"><font class="gkpf">顾客评分</font></td>
    					<td width="50%" align="left">5分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						(${sum_5 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td align="left">
    						4分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						(${sum_4 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td align="left">
    						3分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						(${sum_3 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td></td>
    					<td align="left">
    						2分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						(${sum_2 }人)
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td></td>
    					<td align="left">
    						1分
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    						(${sum_1 }人)
    					</td>
    				</tr>
    			</table>
    			</div>
    			<div class="wypj">
    				<ul>
    					<li>
    						<a href="javascript:void(0);"><img src="${pageContext.request.contextPath }/images/proscenium/wypj.jpg"/ id="wypj"></a>
    					</li>
    					<li>只有购买过此商品的用户才能参与评分</li>
    				</ul>
    			</div>
    		</div>
    		<div class="content">
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
    								<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    							</c:forEach>	
    							<c:forEach begin="0" end="${5-c.commentGrade}"> 
    								<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
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
    							<a href="javascript:void(0);"><span class="sxyy">上一页</span></a>
    							<c:forEach begin="1" end="${pageSum}" var="p">
    								<a href="javascript:void(0);"><span>${p}</span></a>
    							</c:forEach>
    							<a href="javascript:void(0);"><span class="sxyy">下一页</span></a>
    						</c:when>
    						<c:otherwise>
    							<a href="javascript:void(0);"><span class="sxyy">上一页</span></a>
    							<a href="javascript:void(0);"><span>1</span></a>
    							<a href="javascript:void(0);"><span>2</span></a>
    							<a href="javascript:void(0);"><span>3</span></a>
    							...
    							<a href="javascript:void(0);"><span>${pageSum-1}</span></a>
    							<a href="javascript:void(0);"><span>${pageSum}</span></a>
    							<a href="javascript:void(0);"><span class="sxyy">下一页</span></a>
    						</c:otherwise>
    					</c:choose>
    				</c:when>
    			</c:choose>
    		</div>
    	</div>
    	<div class="comment_right">
    		<div class="pxwgntj">
    			<div class="title">
    				给你推荐
    			</div>
    			<div class="content">
    				<c:forEach items="${pxwgntj}" var="p">
    					<ul>
    						<li>
    							<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${p.goodsId}" target="_blank">
    								<img src="${p.goodsImage }" width="60px" height="60px"/>
    							</a>
    						</li>
    						<li>
    							${p.goodsName }<Br/>
    							<font>价格:${p.goodsMarketPrice }</font>
    						</li>
    					</ul>
    				</c:forEach>
    			</div>
    		</div>
    		<div class="tlzrx">
    			<div class="title">
    				同类最热销
    			</div>
    			<div class="content">
    				<c:forEach items="${tlrxsp}" var="t">
    					<ul>
    						<li>
    							<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${t.goodsId}" target="_blank">
    								<img src="${t.goodsImage }" width="60px" height="60px"/>
    							</a>
    						</li>
    						<li>
    							${t.goodsName }<Br/>
    							<font>价格:￥${t.goodsMarketPrice }</font>
    						</li>
    					</ul>
    				</c:forEach>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>
