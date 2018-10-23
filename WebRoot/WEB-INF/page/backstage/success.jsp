<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/SuccessError.css" type="text/css"></link>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">成功提示</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div class="error_main">
     		<div class="title">
    			<span class="sszm">P</span><span class="hzm">AI</span>
   	 			<span  class="sszm">X</span><span class="hzm">IE</span>
    			<span  class="sszm">N</span><span class="hzm">ET</span>
    			<span class="tsym">提示页面</span>
  	 		</div>
   			<div class="hr"></div>
    		<div class="content">
    			<div class="content_top">
    				<span class="success"><b>SUCCESS</b></span>
    			</div>
    			<div class="content_content">
    				<c:if test="${type=='updateInfo'}">
    					<span class="tips">基本信息修改成功!!!</span>
    					<span>点击：</span>
    					<a class="success" href="${pageContext.request.contextPath }/workerInfo/workerInfo_workerInforUI.action">查看个人信息</a>
    				</c:if>
    				<c:if test="${type=='goodsDetail'}">
    					<span class="tips">商品详细信息添加成功!!!</span>
    					<br /><Br /><Br />
    					&gt;&gt;&gt;&gt;&gt;点击:<a class="success" href="${pageContext.request.contextPath }/goodsManager/goodsDetail_addGoodsDetailUI.action">继续添加</a>
    					<br /><br />
    					&gt;&gt;&gt;&gt;&gt;点击:<a class="success" href="${pageContext.request.contextPath }/goodsManager/goodsManager_saveGoods.action">完成</a><br />
    				</c:if>
    				<c:if test="${type=='addGoods'}">
    					<span class="tips">商品息信添加成功!!!</span>
    					<br /><Br /><Br />
    					&gt;&gt;&gt;&gt;&gt;点击:<a class="success" href="${pageContext.request.contextPath }/goodsManager/goodsManager_addGoodsUI.action">继续添加</a>
    					<br /><br />
    					&gt;&gt;&gt;&gt;&gt;点击:<a class="success" href="${pageContext.request.contextPath }/goodsManager/goodsManager_saveGoods.action">返回</a><br />
    				</c:if>
    			</div>
    		</div>
    		<div class="hr"></div>
    		<div class="bottom">
    			<a href="${pageContext.request.contextPath }/manager/manager_toManageMain.action">
    				<img src="${pageContext.request.contextPath}/images/backstage/fhsy.jpg" />
    			</a>
   			</div>
     	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
