<%@ page language="java" pageEncoding="UTF-8" %>
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
        <input type="hidden" id="flcategoryId" value=${category.categoryId }/>
    </div>
    <div class="sort">
        <c:forEach items="${categorys}" var="c" varStatus="status">
            <div id="sortTitle" onclick="showOrHideStyle(${status.index+1})">
                <table width="100%">
                    <tr>
                        <td width="90%">
                            <span>${c.categoryName}</span>
                        </td>
                        <td align="right">
                            <img src="${pageContext.request.contextPath }/images/proscenium/+.jpg" id="sortTitleImage_${status.index+1}" onclick="showOrHideStyle(${status.index+1})">
                        </td>
                    </tr>
                </table>
            </div>
            <ul id="style_${status.index+1}" class="hide">
                <li class="allshoes">
                    <a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=${c.categoryId}"><strong>所有${c.categoryName}</strong></a>
                </li>
                <c:forEach items="${c.styles}" var="s">
                    <li>
                        <a href="${pageContext.request.contextPath}/goods/categoryCoods_showGoodsByCategory.action?categoryId=${c.categoryId}&style=${s.styleId}">
                            <img src="${pageContext.request.contextPath }/images/proscenium/dianhao.jpg">&nbsp;&nbsp;${s.styleName}
                        </a></li>
                </c:forEach>
            </ul>
        </c:forEach>
    </div>
</div>
</body>
</html>
