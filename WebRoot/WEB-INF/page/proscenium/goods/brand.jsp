<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	</head>

	<body>
		<table id="brands_table" cellpadding="0" cellspacing="0" border="0"> 
			<c:forEach begin="1" end="3" var="i">
				<tr>
					<c:choose>
						<c:when test="${i==3}">
							<c:forEach begin="1" end="8" var="j">
							<c:set var="b" value="${brands[(j-1)+(i-1)*9]}"></c:set>
							<td align="center">
								<a href=""><img alt="${b.brandName}" src="${b.brandImage}" height="40px" width="90px" border="0">	</a>				
							</td>
							 <c:if test="${j==8}">
							 	<td align="center">
							 		<a href="${pageContext.request.contextPath}/goods/brand_getAllBrands.action" target="_blank">
							 			<img alt="更多品牌" src="${pageContext.request.contextPath}/images/proscenium/moreBrand.jpg" height="40px" width="90px" border="0">
							 		</a>
							 	</td>
							 </c:if>
						</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach begin="1" end="9" var="j">
								<c:set var="b" value="${brands[(j-1)+(i-1)*9]}"></c:set>
									<td align="center"><a href=""><img alt="${b.brandName}" src="${b.brandImage}" height="40px" width="90px" border="0"></a></td>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
