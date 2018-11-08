<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  	 <title>商品信息管理</title>
  	 
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">

	  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminRight.css" type="text/css"></link>
	  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
	  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/brandManager.css" type="text/css"></link>
  	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/layout.css" type="text/css"></link>
 	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/goodsManager.css" type="text/css"></link>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js" ></script>
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
					  <td height="31"><div class="titlebt">商品管理</div></td>
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
					  <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  </div>
				  <div id="main_content_main">
					  <table id="brand" cellpadding="0" cellspacing="0">
						  <tr>
							  <td align="center" width="10%"><span>编号</span></td>
							  <td align="center" width="10%"><span>名称</span></td>
							  <td align="center" width="10%"><span>图片</span></td>
							  <td align="center" width="5%"><span>进价</span></td>
							  <td align="center" width="5%"><span>销售价格</span></td>
							  <td align="center" width="10%"><span>上架时间</span></td>
							  <td align="center" width="10%"><span>上市时间</span></td>
							  <td align="center" width="5%"><span>现存量</span></td>
							  <td align="center" width="5%"><span>销售量</span></td>
							  <td align="center" width="5%"><span>推荐</span></td>
							  <td align="center" width="5%"><span>状态</span></td>
							  <td align="center" width="10%"><span>操作</span></td>
						  </tr>
						  <c:forEach items="${goods}" var="g">
							  <tr onmousemove="this.bgColor='#EEF2FB'" onmouseout="this.bgColor=''">
								  <td align="center">${g.goodsId}</td>
								  <td align="center">${g.goodsName}</td>
								  <td align="center">
									  <img src="${g.goodsImage}" class="brandImage"/>
								  </td>
								  <td align="center">${g.goodsBid}</td>
								  <td align="center">${g.goodsMarketPrice}</td>
								  <td align="center">${g.goodsGrounding}</td>
								  <td align="center">${g.goodsMarket}</td>
								  <td align="center">${g.goodsExitNumber}</td>
								  <td align="center">${g.goodsMarketNumber}</td>
								  <td align="center">
									  <c:if test="${g.goodsIsRecommend == 1}">推荐</c:if>
									  <c:if test="${g.goodsIsRecommend == 0}">不推荐</c:if>
								  </td>
								  <td align="center">
										<c:if test="${g.goodsState == 1}">在售</c:if>
										<c:if test="${g.goodsState == 0}">已下架</c:if>
								  </td>
								  <td align="center">
									  <a href="javascript:void(0);" class="bjBrand">编辑</a> |
									  <a href="javascript:void(0);" class="scBrand">删除</a>
								  </td>
							  </tr>
						  </c:forEach>
						  <tr>
							  <td colspan="12" align="right">
								  <div class="fenyeDiv">
									  共${pageSum}页&nbsp;&nbsp;${page}/${pageSum}&nbsp;&nbsp;&nbsp;&nbsp;
									  <select>
										  <c:forEach begin="1" end="${pageSum}" var="i">
											  <option value="${i }">第${i }页</option>
										  </c:forEach>
									  </select>
									  &nbsp;&nbsp;&nbsp;&nbsp;
									  <span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsManager_getGoodsUI.action?page=1" target="_self">首     页</a><span class="fenye1">】</span>
									  <span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsManager_getGoodsUI.action?page=${page-1}" target="_self">上一页</a><span class="fenye1">】</span>
									  <span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsManager_getGoodsUI.action?page=${page+1}" target="_self">下一页</a><span class="fenye1">】</span>
									  <span class="fenye1">【</span><a href="${pageContext.request.contextPath}/goodsManager/goodsManager_getGoodsUI.action?page=${pageSum}" target="_self">尾     页</a><span class="fenye1">】</span>
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
    					<td><input type="text" class="Wdate" id="minGoodsMarket" class="searchText" name="minGoodsMarket" onfocus="WdatePicker({skin:'whyGreen',isShowWeek:true})"/>到
    						<input type="text" class="Wdate" id="maxGoodsMarket" class="searchText" name="maxGoodsMarket" onfocus="WdatePicker({skin:'whyGreen',isShowWeek:true})"/>
    				    </td>
    				</tr>
    				<tr>
    					<td align="right">上架时间：</td>
    					<td><input type="text" class="Wdate" id="mingoodsGrounding" class="searchText" name="mingoodsGrounding" onfocus="WdatePicker({skin:'whyGreen',isShowWeek:true})"/>到
    						<input type="text" class="Wdate" id="maxgoodsGrounding" class="searchText" name="maxgoodsGrounding" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',skin:'whyGreen',isShowWeek:true})"/>
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

