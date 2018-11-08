<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	</head>

	<body>
		<table id="brands_table" cellpadding="0" cellspacing="0" border="0">
			<c:forEach begin="1" end="${brandsTr}" var="i">
				<tr>
					<c:choose>
                        <c:when test="${i<brandsTr}">
							<c:forEach begin="1" end="8" var="j">
								<c:set var="b" value="${brands[(j-1)+(i-1)*8]}"></c:set>
									<td align="center"><a href=""><img alt="${b.brandName}" src="${b.brandImage}" height="50px" width="75px" border="0"></a></td>
							</c:forEach>
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="1" end="${brandsTd}" var="j">
                                <c:set var="b" value="${brands[(j-1)+(i-1)*8]}"></c:set>
                                <td align="center"><a href=""><img alt="${b.brandName}" src="${b.brandImage}" height="50px" width="75px" border="0"></a></td>
                                <c:if test="${j==brandsTd}">
                                    <td align="center">
                                        <a href="${pageContext.request.contextPath}/goods/brand_getAllBrands.action">
                                            <img alt="更多品牌" src="${pageContext.request.contextPath}/images/proscenium/moreBrand.jpg" height="50px" width="75px" border="0">
                                        </a>
                                    </td>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
