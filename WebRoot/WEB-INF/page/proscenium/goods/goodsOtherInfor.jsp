<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>

<body>
<div id="goods_DetailInfor">
    <div id="goods_otherinfor">
        <div id="goods_infor_left">
            <img src="${goodsColor.goodsImage}" style="height: 100%">
        </div>
        <div id="goods_infor_right">
            <table id="goods_infor_table" border="0" cellpadding="5" cellspacing="">
                <tr>
                    <td align="left" colspan="6" class="goods_DetailInfor"><span
                            class="goodsInforTableTitle">商品其他信息</span></td>
                </tr>
                <tr>
                    <td align="right" id="goodsInfor_name">货&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                    <td align="left">${goods.goodsId }</td>
                    <td align="right" id="goodsInfor_name">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</td>
                    <td>
                        <a href="" class="goodsDetail">
                            ${goods.brand.brandName }
                        </a>
                    </td>
                    <td align="right" id="goodsInfor_name">款&nbsp;&nbsp;&nbsp;&nbsp;式：</td>
                    <td>
                        <a href="" class="goodsDetail">
                            ${goods.style.styleName }
                        </a>
                    </td>
                </tr>
                <tr>
                    <td align="right">商品颜色：</td>
                    <td>${goodsColor.goodsColor}</td>
                    <td align="right" id="goodsInfor_name">上架时间：</td>
                    <td>${goods.goodsGrounding }</td>
                    <td align="right" id="goodsInfor_name">上市年份：</td>
                    <td>${goods.goodsMarket }</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
