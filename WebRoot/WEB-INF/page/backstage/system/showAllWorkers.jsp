<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>	
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/WorkerManager.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/workerManager.js" charset="UTF-8"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  
  	<title>显示全部员工信息</title>
 </head>
  
  <body>
    <div id="left">
 
    </div>
    <div id="main">
    	<div id="main_top">
    	
    	</div>
    	<div id="main_content">
    		<div id="main_content_top">
    			全部员工信息
    		</div>
    		<div id="main_content_main">
    			<div id="main_content_allText">
    						<span>
    							<span id="title"><b>提示:</b></span>
    						    	修改员工信息,您只能修改该员工的职务,其他信息一律不能修改.<br/>
    						</span>
    			</div>
    			<s:if test="#request.workers!=null">
    					<table id="content_view"  cellSpacing=0 cellPadding=0>
    					<tr>
    						<td width="7%">
    							<input type="checkbox" >
    							<span>全选</span>
    						</td>
    						<td align="center"><span >编号</span></td>
    						<td align="center"><span>姓名</span></td>
    						<td align="center"><span>身份证号码</span></td>
    						<td align="center"><span>出生日期</span></td>
    						<td align="center"><span>联系电话</span></td>
    						<td align="center"><span>职务</span></td>
    						<td align="center"><span>操作</span></td>
    					</tr>
    					<s:iterator value="#request.workers">
    						<tr id="view_tr" onmousemove="this.bgColor='#9FDAF8'" onmouseout="this.bgColor=''">
    							<td><input type="checkbox" ></td>
    							<td><s:property value="workerId"/></td>
    							<td><s:property value="workerName"/></td>
    							<td><s:property value="workerIdcard"/></td>
    							<td><s:property value="workerBirthday"/></td>
    							<td><s:property value="workerPhone"/></td>
    							<td><s:property value="position.positionName"/></td>
    							<td align="center" width="8%">
    								<a href="${pageContext.request.contextPath }/systemManager/systemWorkerManager_deleteWorker.action?worker.workerId=<s:property value="workerId"/>&pageNo=<s:property value="#request.pageNo"/>">删除</a>|
    								<a href="${pageContext.request.contextPath }/systemManager/systemWorkerManager_deleteWorker.action?worker.workerId=<s:property value="workerId"/>">编辑</a>
    							</td>
    						</tr>
    					</s:iterator>
    					<tr>
    						<td><span >删除</span></td>
    						<td colspan="7" align="right">
    							<a href="${pageContext.request.contextPath }/systemManager/systemWorker_showAllWorkers.action?page=1">【 首   页  】</a>|
    							<a href="${pageContext.request.contextPath }/systemManager/systemWorker_showAllWorkers.action?page=<s:property value="#request.lastPage" />">【上一页】</a>|
    							<a href="${pageContext.request.contextPath }/systemManager/systemWorker_showAllWorkers.action?page=<s:property value="#request.nextPage" />">【下一页】</a>|
    							<a href="${pageContext.request.contextPath }/systemManager/systemWorker_showAllWorkers.action?page=<s:property value="#request.count" />">【尾     页】</a>
    						</td>
    					</tr>
    				</table>
    			</s:if>
    		</div>
    	</div>
    </div>
  </body>
</html>
