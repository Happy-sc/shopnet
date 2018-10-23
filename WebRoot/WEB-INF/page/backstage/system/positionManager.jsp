<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  	<title>拍鞋购物网站后台管理系统---职务管理</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/postionManager.css" type="text/css"></link>
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
    			员工职务管理
    		</div>
    		<div id="main_content_main">
    			<div id="main_content_tips">
    				<span id="title">提示:</span><span>在删除该职务之前，请先给该职务的所有员工分配其他职务....</span>
    			</div>
    			<table id="content_table" cellSpacing=0 cellPadding=0>
    				<tr>
    					<td align="center" width="20%"><span>职务编号</span></td>
    					<td align="center" width="30"><span>职务名称</span></td>
    					<td align="center" width="30%"><span>操作</span></td>
    				</tr>
    				<s:iterator value="#request.positions">
    					<tr onmousemove="this.bgColor='#9FDAF8'" onmouseout="this.bgColor=''">
    						<td align="center"><s:property value="positionId"/></td>
    						<td align="center"><s:property value="positionName"/></td>
    						<td align="center" >
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
