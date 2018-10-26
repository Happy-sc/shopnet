<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  	 <title>商品信息管理</title>
  	 
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
  	 
  	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
 	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/goodsManager.css" type="text/css"></link>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js" ></script>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/goodsManager.js" charset="GBK"></script>
 
 </head>
  
  <body>
    <div id="left">
    	
    </div>
    <div id="main">
    	<div id="main_top">
    	
    	</div>
    	<div id="main_content">
    		<div id="main_content_top">
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品信息管理
    		</div>
    		<div id="main_content_main">
    			<s:form>
    				<table id="goodsManagerTable">
    				<tr>
    					<td align="right">商品编号：</td>
    					<td><input type="text" class="searchText"/></td>
    				</tr>
    				<tr>
    					<td align="right">商品名称：</td>
    					<td><input type="text" class="searchText"/></td>
    				</tr>
    				<tr>
    					<td align="right">上市时间：</td>
    					<td><input type="text" class="Wdate" id="minGoodsMarket" class="searchText" name="minGoodsMarket" 
    						       onfocus="WdatePicker({skin:'whyGreen',isShowWeek:true})"/>到
    						<input type="text" class="Wdate" id="maxGoodsMarket" class="searchText" name="maxGoodsMarket" 
    						       onfocus="WdatePicker({skin:'whyGreen',isShowWeek:true})"/>       
    				    </td>
    				</tr>
    				<tr>
    					<td align="right">上架时间：</td>
    					<td><input type="text" class="Wdate" id="mingoodsGrounding" class="searchText" name="mingoodsGrounding" 
    						       onfocus="WdatePicker({skin:'whyGreen',isShowWeek:true})"/>到
    						<input type="text" class="Wdate" id="maxgoodsGrounding" class="searchText" name="maxgoodsGrounding" 
    						       onfocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',skin:'whyGreen',isShowWeek:true})"/>    
    				    </td>
    				</tr>
    				<tr>
    					<td align="right">商品仓库：</td>
    					<td>
    						<select>
    							<option value="-1">--请选择--</option>
    							<s:iterator value="#request.storage">
    								<option value="<s:property value="storageId"/>"><s:property value="storageName"/></option>
    							</s:iterator>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td align="right">是否推荐：</td>
    					<td>
    						<select>
    							<option value="-1">--请选择--</option>
    							<option value="1">是</option>
    							<option value="0">否</option>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td align="right">商品分类：</td>
    					<td>
    						<select id="category" name="category" onchange="categoryStyle();">
    							<option value="-1">--请选择--</option>
    							<s:iterator value="#request.category">
    								<option value="<s:property value="categoryId"/>"><s:property value="categoryName"/></option>
    							</s:iterator>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td align="right">商品款式：</td>
    					<td>
    						<select id="style" name="style" onchange="styleBrand();">
    							<option value="-1">--请选择--</option>
    							<s:iterator value="#request.styles">
    								<option value="<s:property value="styleId"/>"><s:property value="styleName"/></option>
    							</s:iterator>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td align="right">商品品牌：</td>
    					<td>
    						<select id="brand" name="brand">
    							<option value="-1">--请选择--</option>
    							<s:iterator value="#request.brands">
    								<option value="<s:property value=""/>"><s:property value="brandName"/></option>
    							</s:iterator>
    						</select>
    					</td>
    				</tr>
    				<tr>
    					<td align="center" colspan="2"><input type="image" src="${pageContext.request.contextPath }/images/backstage/search.jpg"/></td>
    				</tr>
    			</table>
    			</s:form>
    		</div>
    	</div>
    </div>
  </body>
</html>

