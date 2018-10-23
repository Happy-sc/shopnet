<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/orderManager.css" type="text/css"></link>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage/orderManager.js"></script>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">已发货订单</div></td>
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
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			已发货订单
    		</div>
    		<div id="main_content_main">
    			<table id="dfkTable" cellSpacing=0 cellPadding=0>
    				<tr>
    					<td align="center" width=22%"><span>订单编号</span></td>
    					<td align="center" width="22%"><span>订单时间</span></td>
    					<td align="center" width="15%"><span>用户</span></td>
    					<td align="center" width="15%"><span>处理员</span></td>
    					<td align="center" width="15%"><span>处理时间</span></td>
    					<td align="center" width="10%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="${orders}" var="o">
    					<tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
    						<td align="center">${o.orderId}&nbsp;</td>
    						<td align="center">${o.orderDate}&nbsp;</td>
    						<td align="center">${o.users.userName}&nbsp;</td>
    						<td align="center">${o.worker.workerName}&nbsp;</td>
    						<td align="center">${o.orderSend}&nbsp;</td>
    						<td align="center"> 
    							<input type="hidden" value="${o.orderId}"> 
    							<a href="javascript:void(0);" class="ckOrder">查看</a>&nbsp;
    						</td>
    					</tr>
    				</c:forEach>
    				<tr>
    					<td colspan="6" align="right">
    						<input type="hidden" value="${page }" id="page">
    						<div class="fenyeDiv">
    							共${pageSum}页&nbsp;&nbsp;${page}/${pageSum}&nbsp;&nbsp;&nbsp;&nbsp;
    							 <select>
    							 	<c:forEach begin="1" end="${pageSum}" var="i">
    							 		<option value="${i }">第${i }页</option>
    							 	</c:forEach>
    							 </select>
    							 &nbsp;&nbsp;&nbsp;&nbsp;
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=1&type=${type}" 
    						     	target="_self"">首     页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=${page-1}&type=${type}" 
    						    	 target="_self">上一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=${page+1}&type=${type}" 
    						     	target="_self">下一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=${pageSum}&type=${type}" 
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
