<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/styleManager.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.core.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.mouse.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.button.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.draggable.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.position.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.dialog.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/styleManager.js" charset="GBK"></script>
 			
  </head>
  
  <body>
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">款式管理</div></td>
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
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品款式管理 
    			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="javascript:void(0);">
    				<input type="button" value="" id="addStyleBtn">
    			</a>
    		</div>
    		<div id="main_content_main">
    			<table id="style" cellpadding="0" cellspacing="0">
    				<tr>
    					<td align="center" width="13%"><span>款式编号</span></td>
    					<td align="center" width="13%"><span>款式名称</span></td>
    					<td align="center" width="13%"><span>所属分类</span></td>
    					<td align="center" width="50%"><span>所有品牌</span></td>
    					<td align="center" width="10%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="${styles}" var="s">
    					<tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
    						<td align="center">${s.styleId}&nbsp;</td>
    						<td align="center">${s.styleName}&nbsp;</td>
    						<td align="center">${s.category.categoryName}&nbsp;</td>
    						<td align="left">${s.brand}&nbsp;</td>
    						<td align="center">
    							<a href="javascript:void(0);" class="bjStyle">编辑</a>&nbsp;|
    							<a href="javascript:void(0);" class="scStyle">删除</a>
    						</td>
    					</tr>
    				</c:forEach>
    				<tr>
    					<td colspan="5" align="right">
    						<div class="fenyeDiv">
    							共${pageSum}页&nbsp;&nbsp;${page}/${pageSum}&nbsp;&nbsp;&nbsp;&nbsp;
    							 <select>
    							 	<c:forEach begin="1" end="${pageSum}" var="i">
    							 		<option value="${i }">第${i }页</option>
    							 	</c:forEach>
    							 </select>&nbsp;&nbsp;&nbsp;&nbsp;
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/styleManager_styleManagerUI.action?page=1" 
    						     	target="_self"">首     页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/styleManager_styleManagerUI.action?page=${page-1}" 
    						    	 target="_self">上一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/styleManager_styleManagerUI.action?page=${page+1}" 
    						     	target="_self">下一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/styleManager_styleManagerUI.action?page=${pageSum}" 
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
  <div class="zjbjStyle">
  	<div class="zjbjContent">
  	<form action="" id="styleForm" method="post">
    	<table cellpadding="5" cellspacing="5" id="zjbjstyle" border="0">
    		<tr>
    			<td align="right" width="35%">款式编号：</td>
    			<td width="30%"><input type="text" id="styleId" name="style.styleId" readonly="readonly"/></td>
    			<td >
    				<div id="styleId_prompt"></div>
    				<input type="hidden" name="page" id="page" value="${page}"/>
    				<input type="hidden" name="type" id="type"/>
    			</td>
    		</tr>
    		<tr>
    			<td align="right">款式名称：</td>
    			<td><input type="text" id="styleName"  name="style.styleName"/></td>
    			<td><div id="styleName_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">所属分类：</td>
    			<td>
					<select id="category" name="categoryId">
						<option value="-1">--请选择--</option>
						<c:forEach items="${categories}" var="c">
							<option value="${c.categoryId}">${c.categoryName}</option>
						</c:forEach>
					</select>
				</td>
    			<td><div id="category_prompt"></div></td>
    		</tr>
    		<tr>
    			<td align="right">拥有品牌：</td>
    			<td>
    				<input type="text" class="addTypeText" id="brand" name="brands" readonly="readonly">
    			</td>
    			<td><div id="brand__prompt"></div></td>
    		</tr>
    		<tr>
    			<td colspan="3">
    				<table width="100%">
    					<c:forEach begin="1" end="${brandRow}" var="i">
    						<tr>
    						<c:choose>
    							<c:when test="${brandRow==i}">
    								<c:forEach begin="1" end="${endBrand}" var="j">
    									<c:set value="${brands[(j-1)+(i-1)*6]}" var="b"></c:set>
    									<td><input class="styleBrands" type="checkbox" value="${b.brandName }">${b.brandName}</td>
    								</c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="6" var="j">
    									<c:set value="${brands[(j-1)+(i-1)*6]}" var="b"></c:set>
    									<td><input class="styleBrands" type="checkbox" value="${b.brandName }">${b.brandName}</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</td>
    		</tr>
    	</table>
    </form>
  	</div>
  	<div class="zjbjBtn">
  		<input type="hidden" id="thisName"/>
  		<input type="image" src="" id="qrzjbj"/>
  	</div>
  </div>
  </body>
</html>
