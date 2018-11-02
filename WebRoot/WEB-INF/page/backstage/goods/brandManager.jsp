<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/brandManager.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.core.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.mouse.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.button.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.draggable.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.position.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.dialog.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/brandManager.js" charset="UTF-8"></script>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">欢迎界面</div></td>
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
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品品牌管理 
    			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="javascript:void(0);">
    				<input type="button" value="" id="addBrandBtn">
    			</a>
    		</div>
    		<div id="main_content_main">
    			<table id="brand" cellpadding="0" cellspacing="0">
    				<tr>
    					<td align="center" width="10%"><span>品牌编号</span></td>
    					<td align="center" width="10%"><span>品牌名称</span></td>
    					<td align="center" width="10%"><span>品牌拼音</span></td>
    					<td align="center" width="45%"><span>所有款式</span></td>
    					<td align="center" width="15%"><span>品牌图片</span></td>
    					<td align="center" width="10%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="${brands}" var="b">
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
    							共${pageSum}页&nbsp;&nbsp;${page}/${pageSum}&nbsp;&nbsp;&nbsp;&nbsp;
    							 <select>
    							 	<c:forEach begin="1" end="${pageSum}" var="i">
    							 		<option value="${i }">第${i }页</option>
    							 	</c:forEach>
    							 </select>
    							 &nbsp;&nbsp;&nbsp;&nbsp;
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/brandManager_brandManagerUI.action?page=1" 
    						     	target="_self"">首     页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/brandManager_brandManagerUI.action?page=${page-1}" 
    						    	 target="_self">上一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/brandManager_brandManagerUI.action?page=${page+1}" 
    						     	target="_self">下一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/brandManager_brandManagerUI.action?page=${pageSum}" 
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
	<div class="zjbjBrand">
    	<div class="zjbjContent">
    	<form method="post" enctype="multipart/form-data" id="brandForm">
    		<table cellpadding="5" border="0" id="zjbjTable">
    			<tr>
    				<td width="35%" align="right">品牌编号：</td>
    				<td width="30%"><input type="text" id="brandId" name="brand.brandId" readonly="readonly"/></td>
    				<td>
    					<div id="brandId_prompt"></div>
    					<input type="hidden" id="type" name="type">
    					<input type="hidden" id="page" name="page" value="${page}"/>
    				</td>
    			</tr>
    			<tr>
    				<td align="right">品牌名称：</td>
    				<td><input type="text" id="brandName" name="brand.brandName"/></td>
    				<td><div id="brandName_prompt"></div></td>
    			</tr>
    			<tr>
    				<td align="right">品牌拼音：</td>
    				<td><input type="text" id="brandSpell" name="brand.brandSpell"/></td>
    				<td><div id="brandSpell_prompt"></div></td>
    			</tr>
    			<tr>
    				<td align="right">品牌图片：</td>
    				<td><img src="" id="image" width="50%"></td>
    				<td></td>
    			</tr>
    			<tr>
    				<td></td>
    				<td><input type="file" id="brandImage" name="brandImage"/></td>
    				<td><div id="brandImage_prompt"></div></td>
    			</tr>
    		</table>
    	</form>
    	</div>
    	<div class="zjscBtn">
    		<input type="hidden" id="name1"/>
    		<input type="hidden" id="name3"/>
    		<input type="image" src="" id="zjbjBtn"/>
    	</div>
    </div>
</body>
</html>