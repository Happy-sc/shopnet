<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/workerManager.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js" ></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.core.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.mouse.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.button.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.draggable.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.position.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.dialog.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/managerWorker.js" charset="GBK"></script>
  	</head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">员工管理</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div id="main_content_top"> 
    		<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;员工管理 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<a href="javascript:void(0);">
    			<input type="button" value="" id="addWorkerBtn">
    		</a>
    	</div>
    	<div id="main_content_main">
    		<div class="workerSearch">
    			<form id="searchForm" action="../systemManager/workerManager_searchWorker.action">&nbsp;&nbsp;&nbsp;
    				<font class="searhcText">编号：</font><input type="text" id="sWorkerId" name="workerQuery.workerId" class="searchText" value="${query.workerId }"/>&nbsp;&nbsp;&nbsp;&nbsp;
    				<font class="searhcText">身份证：</font><input type="text" id="sIdCard" name="workerQuery.idCard" class="searchText"value="${query.idCard }" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    				<font class="searhcText">职务：</font>
						<select id="sPositionS" name="workerQuery.positionId">
    						<option value="-1">--请选择--</option>
    						<c:forEach items="${positions}" var="p">
    							<option value="${p.positionId}">${p.positionName}</option>
    						</c:forEach>
    					</select>
    				&nbsp;&nbsp;
    				<input type="hidden" value="${page }" id="page" name="workerQuery.page" />
    				<input type="hidden" value="${pageSum }" id="pageCount" />
    				<input type="hidden" value="${query.positionId }" id="sposition" />
    				<input type="image" src="${pageContext.request.contextPath }/images/backstage/search.jpg" value="查询">
    			</form>
    		</div>	
    		<div class="workerContent">
    			<table id="workerTable" cellSpacing=0 cellPadding=0>
    				<tr>
    					<td align="center" width=20%"><span>员工编号</span></td>
    					<td align="center" width="18%"><span>员工姓名</span></td>
    					<td align="center" width="24%"><span>身份证号码</span></td>
    					<td align="center" width="20%"><span>职务</span></td>
    					<td align="center" width="18%"><span>操作</span></td>
    				</tr>
    				<c:forEach items="${workers }" var="w">
    					<tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
    						<td align="center">${w.workerId }&nbsp;</td>
    						<td align="center">${w.workerName }&nbsp;</td>
    						<td align="center">${w.workerIdcard }&nbsp;</td>
    						<td align="center">${w.position.positionName }&nbsp;</td>
    						<td align="center"> 
    							<input type="hidden" value="${w.workerId }"/> 
    							<input type="hidden" value="${w.position.positionId }"/>
    							<input type="hidden" value="${w.entryTime}">
    							<a href="javascript:void(0);" class="ckWorker">查看</a>&nbsp;|
    							<a href="javascript:void(0);" class="bjWorker">编辑</a>&nbsp;|
    							<a href="javascript:void(0);" class="scWorker">删除</a>
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
    							 <span class="fenye1">【</span><a href="javascript:void(0);" class="sy" target="_self"">首     页</a><span class="fenye1">】</span>
    							 <span class="fenye1">【</span><a href="javascript:void(0);" class="syy" target="_self">上一页</a><span class="fenye1">】</span>
    							 <span class="fenye1">【</span><a href="javascript:void(0);" class="xyy" target="_self">下一页</a><span class="fenye1">】</span>
    							 <span class="fenye1">【</span><a href="javascript:void(0);" class="wy" target="_self">尾     页</a><span class="fenye1">】</span>
    							&nbsp;&nbsp;
    						</div>
    					</td>
    				</tr>
    			</table>
    		</div>
    		<div class="tjbjWorker" style="display: none;">
    			<form id="tjbjWorkerForm" method="post">
    				<table id="tjbjTable" cellpadding="5" border="0">
    					<tr>
    						<td width="20%" align="right">员工编号：</td>
    						<td width="40%"><input type="text" name="worker.workerId" id="workerId" class="tjbjText"/></td>
    						<td><div id="wokerId_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">员工姓名：</td>
    						<td><input type="text" name="worker.workerName" id="workerName" class="tjbjText"/></td>
    						<td><div id="workerName_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">身&nbsp;份&nbsp;证：</td>
    						<td><input type="text" name="worker.workerIdcard" id="workerIdCar" class="tjbjText"/></td>
    						<td><div id="workerIdCar_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">员工职务：</td>
    						<td>
    							<select id="position" name="worker.position.positionId">
    								<option value="-1">--请选择--</option>
    								<c:forEach items="${positions}" var="p">
    									<option value="${p.positionId}">${p.positionName}</option>
    								</c:forEach>
    							</select>
    						</td>
    						<td><div id="wokerPosition_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">入职时间：</td>
    						<td><input type="text" name="worker.entryTime" id="entryTime" class="Wdate" onfocus="WdatePicker({isShowWeek:true})"/></td>
    						<td><div id="wokerEntryTime_prompt"></div></td>
    					</tr>
    					<tr>
    						<td colspan="3" align="center"><input type="image" id="tjbjSubmit"/></td>
    					</tr>
    				</table>
    			</form>
    		</div>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
</body>
</html>
	