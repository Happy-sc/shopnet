<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">仓库管理</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div id="main_content">
    		<div id="main_content_top"> 
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;仓库管理
    			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="javascript:void(0);">
    				<input type="button" value="" id="addBrandBtn">
    			</a>
    		</div>
    		<div id="main_content_main">
    			<table id="brand" cellpadding="0" cellspacing="0">
    				<tr>
    					<td align="center" width="15%"><span>仓库编号</span></td>
    					<td align="center" width="15%"><span>仓库名称</span></td>
    					<td align="center" width="40%"><span>所在地址</span></td>
    					<td align="center" width="10%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="" var="b">
    					<tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
    						<td align="center">${b.brandId}&nbsp;</td>
    						<td align="center">${b.brandName}&nbsp;</td>
    						<td align="center">${b.brandSpell}&nbsp;</td>
    						<td align="center">${b.styleString}&nbsp;</td>
    						<td align="center">
    							<img src="${b.brandImage}" class="brandImage"/>
    						</td>
    						<td align="center">
    							<a href="javascript:void(0);" class="bjBrand">编辑</a>|
    							<a href="javascript:void(0);" class="scBrand">删除</a>
    						</td>
    					</tr>
    				</c:forEach>
    				<tr>
    					<td colspan="6" align="right">
    						<div class="fenyeDiv">
    							共${pageCount}页&nbsp;&nbsp;${page}/${pageCount}&nbsp;&nbsp;&nbsp;&nbsp;
    							 <select>
    							 	<c:forEach begin="1" end="${pageCount}" var="i">
    							 		<option value="${i }">第${i }页</option>
    							 	</c:forEach>
    							 </select>
    							 &nbsp;&nbsp;&nbsp;&nbsp;
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsStyle_styleMangerUI.action?page=1" 
    						     	target="_self"">首     页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsStyle_styleMangerUI.action?page=${page-1}" 
    						    	 target="_self">上一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsStyle_styleMangerUI.action?page=${page+1}" 
    						     	target="_self">下一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsStyle_styleMangerUI.action?page=${pageCount}" 
    							 	target="_self">尾     页</a><span class="fenye1">】</span>
    							&nbsp;&nbsp;
    						</div>
    					</td>
    				</tr>
    			</table>
    		</div>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>

