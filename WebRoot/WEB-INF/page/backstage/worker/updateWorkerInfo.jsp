<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/updateWokerInfor.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js" ></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/updateWorkerInfo.js" charset="GBK"></script>
 </head>
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">信息修改</div></td>
      			</tr>
    		</table>
    	</td>
    	<td width="16" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr height="95%">
  	<td valign="middle" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif">&nbsp;</td>
  	<td valign="top" bgcolor="#F7F8F9">
     	<div class="updateInfo">
     	<form action="${pageContext.request.contextPath }/workerInfo/workerInfo_updateInfo.action" id="updateWorkerInfoForm" 
     		  method="POST" enctype="multipart/form-data" target="main">
    		<table id="workerInfor" cellSpacing=0 cellPadding=0>
    			<tr> 
    				<td align="right" width="15%">编&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
    				<td align="left" id="td2" width="24%">
    					<input type="text" id="workerId"  class="workerText" name="worker.workerId"  value="${worker.workerId }" readonly="readonly" />
    				</td>
    				<td align="right" width="15%">姓&nbsp;&nbsp;&nbsp;&nbsp;名:</td>
    				<td align="left"  id="td2" width="24%">
    					<input type="text" id="workerName" class="workerText" name="worker.workerName" value="${worker.workerName }"/>
    				</td>
    				<td rowspan="4" id="td5">
    					<div id="image"><img alt="头像" src="${worker.workerImage }"  ></div>
    					<div id="image_file"><input type="file" id="worker_file" name="workerImage"></div>
    				</td>
    			</tr>
    			<tr>
    				<td align="right">身&nbsp;份&nbsp;证:</td>
    				<td align="left" id="td2">
    				    <input type="text" id="workerIDCard" class="workerText" name="worker.workerIdcard" value="${worker.workerIdcard }"/>
    				</td>
    				<td align="right">出生日期:</td>
    				<td align="left" id="td2">
    					<input type="text" id="workerBirthday" class="Wdate" name="worker.workerBirthday" onfocus="WdatePicker({isShowWeek:true})" value="${worker.workerBirthday }"/>
    				</td>
    			</tr>
    			<tr>
    				<td align="right">联系电话:</td>
    				<td align="left"id="td2" id="td2">
    					<input type="text" id="workerPhone" class="workerText" name="worker.workerPhone" value="${worker.workerPhone }"/>
    				</td>
    				<td align="right">职&nbsp;&nbsp;&nbsp;&nbsp;务:</td>
    				<td align="left" class="hrBorder" id="td2">
    					<input type="text" value="${worker.position.positionName}" readonly="readonly"/>
    				</td>
    			</tr>
    			<tr>
    				<td align="right">住&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
    				<td align="left" colspan="3" id="td2">
    					<input id="workerAddress" class="workerAddress" type="text" name="worker.workerAddress" value="${worker.workerAddress }"/>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="5" align="right" >
    					<div class="errorMessage"></div>
    					<div class="td_btn">
    						<input type="image" class="qrxg" src="${pageContext.request.contextPath }/images/backstage/updateS_01.jpg" >&nbsp;&nbsp;&nbsp;&nbsp;
    					</div>
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
