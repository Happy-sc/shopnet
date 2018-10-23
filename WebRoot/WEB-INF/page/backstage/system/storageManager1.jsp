<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  	 <title>拍鞋购物网站后台管理系统--仓库管理</title>
  	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
 	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/storageManager.css" type="text/css"></link></head>
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  <body>
    <div id="left">
    	
    </div>
    <div id="main">
    	<div id="main_top">
    		
    	</div>
    	<div id="main_content">
    		<div id="main_content_top">
    				仓库管理
    			<div id="main_content_top_btn">
    				<a href="${pageContext.request.contextPath }/systemManager/storageManager_addStorageUI.action" ,target="_self">
    					<input type="button" id="add_btn" value=""></a>
    			</div>
    		</div>
    		<div id="main_content_main">
    			<table id="storage" cellpadding="0" cellspacing="0">
    				<tr>
    				    <td align="center" width="15%"><span>仓库编号</span></td>
    					<td align="center" width="15%"><span>仓库名称</span></td>
    					<td align="center" width="15%"><span>管理员</span></td>
    					<td align="center"><span>仓库地址</span></td>
    					<td align="center" width="13%"><span>操作</span></td>
    				</tr >
    				<s:iterator value="#request.storages">
    					<tr onmousemove="this.bgColor='#9FDAF8'" onmouseout="this.bgColor=''">
    						<td align="center"><s:property value="storageId"/></td>
    						<td align="center"><s:property value="storageName"/></td>
    						<td align="center"><s:property value="worker.workerName"/></td>
    						<td align="left"><s:property value="storageAddress"/></td>
    						<td align="center">
    							<a href="">编辑</a>|
    							<a href="">删除</a>
    						</td>
    					</tr>
    				</s:iterator>
    			</table>
    		</div>
    	</div>
    </div>
  </body>
</html>
