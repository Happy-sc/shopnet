<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head> 
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css" /></link>  
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/categoryManager.css" type="text/css" .></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.core.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.mouse.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.button.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.draggable.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.position.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.dialog.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/categoryManager.js" charset="GBK"></script>
  </head>
  
  <body>
   	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">分类管理</div></td>
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
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品分类管理 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="javascript:void(0);">
    				<input type="button" value="" id="addCategotyBtn">
    			</a>
    		</div>
    		<div id="main_content_main">
    			<table id="category" cellSpacing=0 cellPadding=0>
    				<tr>
    					<td align="center" width="15%"><span>分类编号</span></td>
    					<td align="center" width="15%"><span>分类名称</span></td>
    					<td align="center" width="55%"><span>所有款式</span></td>
    					<td align="center" width="15%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="${categorys}" var="c">
    					<tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
    						<td align="center">${c.categoryId}&nbsp;</td>
    						<td align="center">${c.categoryName}&nbsp;</td>
    						<td align="center">${c.styleString}&nbsp;</td>
    						<td align="center">  
    							<a href="javascript:void(0);" class="bjcategory">编辑</a>&nbsp;|
    							<a href="javascript:void(0);" class="sccategory">删除</a>
    						</td>
    					</tr>
    				</c:forEach>
    			</table>
    		</div>
    	</div>
    	
    	<div class="addbjDiv">
    		<form action="" method="POST" id="categoryFrom" target="main">
    			<table id="addCategory" cellpadding="0" cellspacing="0" border="0">
    				<tr>
    					<td width="30%" align="right">分类编号：</td>
    					<td width="40%"><input type="text" id="categoryId" class="addTypeText" name="category.categoryId" readonly="readonly"/></td>
    					<td><input type="hidden" id="categoryType"/></td>
    				</tr>
    				<tr>
    				<td align="right">分类名称：</td>
    				<td ><input type="text" id="categoryName" class="addTypeText" name="category.categoryName"/></td>
    				<td><div id="categoryName_prompt"></div></td>
    				</tr>
    				<tr>
    					<td colspan="3" align="center">
    						<input type="hidden" id="type"/>
    						<input type="hidden" id="thisName"/>
    						<input type="image" src="" id="quzjxg">
    					</td>
    				</tr>
    			</table>
    		</form>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
  </body>
</html>
