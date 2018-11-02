<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/noticeManager.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath}/js/backstage/noticeManager.js" charset="UTF-8"></script>
  </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">公告管理</div></td>
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
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系统公告管理 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="javascript:void(0);">
    				<input type="button" value="" id="addNoticeBtn">
    			</a>
    		</div>
    		<div id="main_content_main">
    			<table id="notice" cellSpacing=0 cellPadding=0>
    				<tr>
    					<td align="center" width=30%"><span>公告主题</span></td>
    					<td align="center" width="30%"><span>发布时间</span></td>
    					<td align="center" width="20%"><span>发布人</span></td>
    					<td align="center" width="20%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="${notices}" var="n">
    					<tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
    						<td align="center">${n.noticeTitle}&nbsp;</td>
    						<td align="center">${n.noticeTime}&nbsp;</td>
    						<td align="center">${n.worker.workerName}&nbsp;</td>
    						<td align="center"> 
    							<input type="hidden" value="${n.noticeId}"> 
    							<a href="javascript:void(0);" class="ckNotice">查看</a>&nbsp;|
    							<a href="javascript:void(0);" class="bjNotice">编辑</a>&nbsp;|
    							<a href="javascript:void(0);" class="scNotice">删除</a>
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
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=1" 
    						     	target="_self"">首     页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=${page-1}" 
    						    	 target="_self">上一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=${page+1}" 
    						     	target="_self">下一页</a><span class="fenye1">】</span>
    							<span class="fenye1">【</span><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action?page=${pageSum}" 
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

