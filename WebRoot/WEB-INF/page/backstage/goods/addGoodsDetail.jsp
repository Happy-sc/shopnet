<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/adminRight.css" type="text/css"></link>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/addGoods.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/goodsManager.js" charset="UTF-8"></script>
  </head>
  
  <body>
   <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    	<td width="17" valign="top" background="${pageContext.request.contextPath }/images/backstage/mail_leftbg.gif"><img src="${pageContext.request.contextPath }/images/backstage/left-top-right.gif" width="17" height="29" /></td>
    	<td valign="top" background="${pageContext.request.contextPath }/images/backstage/content-bg.gif">
    		<table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
     			<tr>
        			<td height="31"><div class="titlebt">商品详情</div></td>
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
    			<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增加商品详细信息 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</div>
    		<div id="main_content_main">
    			<div id="addGoodsDetail">
    			<span>颜色:</span><input type="text" id="color">
    			&nbsp;&nbsp;&nbsp;&nbsp;
    			<span>属性:</span>
					<input type="text" id="attr">
    			&nbsp;&nbsp;&nbsp;&nbsp;
    			<span>数量:</span><input type="text" id="number" name="" >
    			&nbsp;&nbsp;&nbsp;&nbsp;
    			<img src="${pageContext.request.contextPath }/images/backstage/tianjia.jpg" id="TJSPXQ" style="cursor: pointer;" >
    			<div id="error_prompt"></div>
    			</div>
    			
    			<div id="showTable"> 
    				<form action="${pageContext.request.contextPath }/goodsManager/goodsDetail_addGoodsDetail.action" enctype="multipart/form-data" method="post" id="saveGoodsDetail">
    					<table id="goodsDetailTable" cellpadding="0" cellspacing="0">
    					<tr>
    						<td colspan="4">
    							<span>商品图片:</span><input type="file" name="goodsImage" id="goodsImage">
    						</td>
    					</tr>
    					<tr>
    						<td colspan="4"><span>商品编号:</span>
    							<input type="text" name="goodsId" style="width:300px;border:0px;background:#F7F8F9;font-size:14px;color:red;" 
    							       value="${goods.goodsId }" >
    						</td>
    					</tr>
    					<tr>
    						<td align="center" width="40%"><span>颜色</span></td>
    						<td align="center"><span>属性</span></td>
    						<td align="center"><span>数量</span></td>
    						<td align="center"><span>操作</span></td>
    					</tr>
    				</table>
    				<div id="saveBtn"> 
    					<input type="image" src="${pageContext.request.contextPath }/images/backstage/tianjia.jpg"/>
    				</div>
    				</form>
    			</div>
    			<div id="GoodsDetailTips">
    				<span id="tips">提示:</span><Br/>
    				<span>
    					&nbsp;&nbsp;&nbsp;&nbsp;每一次只能增加一种颜色....<br/>
    					&nbsp;&nbsp;&nbsp;&nbsp;如果想添加多种颜色,点击完成后请选择继续添加....<br/>
    					&nbsp;&nbsp;&nbsp;&nbsp;当添加商品完成后,选择完成....
    				</span>
    			</div>
    		</div>
    	</div>
 	</td>
 	<td background="${pageContext.request.contextPath }/images/backstage/mail_rightbg.gif">&nbsp;</td>
  </tr>
</table>
  </body>
</html>
