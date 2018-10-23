<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
  	 <title>拍鞋购物网站后台管理系统--增加仓库信息</title> 
  	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
 	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/storageManager.css" type="text/css"></link>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/storageManager.js" charset="GBK"></script></head>
 
  <body>
    <div id="left">
    	
    </div>
    <div id="main">
    	<div id="main_top">
    	
    	</div>
    	<div id="main_content">
    		<div id="main_content_top"> 
    			增加仓库 
    		</div>
    		<div id="main_content_main">
    			<s:form action="storageManager_addStorage" namespace="/systemManager" onsubmit="return checkStorage();">
    				<table id="addStorage" cellpadding="0" cellspacing="0" border="0">
    					<tr>
    						<td align="right" width="20%">仓库编号：</td>
    						<td width="32%"><input type="text" class="addText" id="storageId" name="storage.storageId" 
    						     onfocus="storageIdFocus()" onblur="storageIdBlur();"/></td>
    						<td><div id="storageId_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">仓库名称：</td>
    						<td><input type="text" class="addText" id="storageName" name="storage.storageName" 
    						     onfocus="storageNameFocus()" onblur="storageNameBlur();"/></td>
    						<td><div id="storageName_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">管理员：</td>
    						<td><select>
    								<option value="-1">--请选择--</option>
    								<s:iterator value="#request.worker">
    									<option value="<s:property value="workerId"/>"><s:property value="workerName"/></option>
    								</s:iterator>
    							</select>
    						</td>
    						<td><div id="worker_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">仓库地址：</td>
    						<td><input type="text" class="addText" id="storageAddress" name="storage.storageAddress" 
    						     onfocus="storageAddressFocus()" onblur="storageAddressBlur();"/></td>
    						<td><div id="storageAddress_prompt"></div></td>
    					</tr>
    					<tr>
    						<td colspan="2" align="right">
    							<input type="image" src="${pageContext.request.contextPath }/images/backstage/add.jpg">
    						</td>
    					</tr>
    				</table>
    			</s:form>
    		</div>
    	</div>
    </div>
  </body>
</html>

