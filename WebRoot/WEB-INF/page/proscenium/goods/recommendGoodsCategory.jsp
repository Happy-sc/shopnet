<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  </head>
  
  <body>
	<div id="recommendMain">
		<div class="recommendMain_title">
			<img src="${pageContext.request.contextPath }/images/proscenium/recommendTitle.jpg"/>
		</div>
		<div class="recommendMain_main">
		<s:iterator value="#request.recommandGoods">
			<table class="cateGoodsTable">
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goodsId}" target="_blank">
							<img src="<s:property value="goodsImage"/>" width="80" height="80"/>
						</a> 
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goodsId}" target="_blank">
							<s:property value="goodsName"/>
						</a>
					</td>
				</tr>
			</table>
		</s:iterator>
		</div>
	</div>
  </body>
</html>
