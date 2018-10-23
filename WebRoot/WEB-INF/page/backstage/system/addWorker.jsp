<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
     <title>拍鞋购物网站后台管理系统--增加员工信息</title>
	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/WorkerManager.css" type="text/css"></link>
	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/workerManager.js" charset="GBK"></script>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 </head>
  
  <body>  
    <div id="left">
    	
    </div>
    <div id="main">
    	<div id="main_top">
    		
    	</div>
    	<div id="main_content">
    		<div id="main_content_top">
    			增加员工信息
    		</div>
    		<div id="main_content_main">
    			<s:form action="systemWorkerManager_addWorker" namespace="/systemManager" method="post" onsubmit="return checkAddWorker();">
    				<table id="addWorker" border="0">
    					<tr>
    						<td width="20%" align="right">员工编号:</td>
    						<td width="30%">
    							<input type="text" class="addText" name="worker.workerId" id="workerId" onfocus="workerIdFocus();" onblur="workerIdBlur();"/>
    						</td>
    						<td ><div id="workerId_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">员工姓名:</td>
    						<td>
    							<input type="text" class="addText" id="workerName" name="worker.workerName" onfocus="workerNameFocus();" onblur="workerNameBlur();"/>
    						</td>
    						<td><div id="workerName_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">身份证号码:</td>
    						<td>
    							<input type="text" class="addText" id="workerIdCard" name="worker.workerIdcard" onfocus="workerIdCardFocus();" onblur="workerIdCardBlur();"/>
    						</td>
    						<td><div id="workerIdCard_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">员工职务:</td>
    						<td>
    							<select name="worker.position.positionId" id="positionId">
    								<option value="-1">---请选择---</option>
    								<s:iterator value="#request.positions">
    									<option value="<s:property value="positionId"/>"><s:property value="positionName"/></option>
    								</s:iterator>
    							</select>
    						</td>
    						<td><div id="position_prompt"></div></td>
    					</tr>
    					<tr>
    						<td colspan="3" >
    							<div id="addIamge">
    								<input type="image" src="${pageContext.request.contextPath }/images/backstage/add.jpg" >
    							</div>
    						</td>
    					</tr>
    				</table>
    			</s:form>
    		</div>
    	</div>
    </div>
  </body>
</html>
