<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterInfor.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/provincesCity.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/provincesdata.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/userCenterInfor.js" charset="GBK"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js" ></script>
 </head>
  
  <body>
   	<div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;账户信息</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="userInfor_title">
    				<span>账户信息</span>
    			</div>
    			<div class="userInfor_content">
    				<s:form action="userInfor_saveUserInfor.action" namespace="/userCenter" method="POST" id="userCenterForm">
    					<table cellpadding="8" border="0">
    					<tr>
    						<td align="right" width="15%">用&nbsp;户&nbsp;名：</td>
    						<td align="left" width="32%"><input class="userNameText"  type="text" name="users.userName" value="${user.userName}"/></td>
    						<td align="left"></td>
    					</tr>
    					<tr>
    						<td align="right">真实姓名：</td>
    						<td align="left"><input class="text" id="userRealName" type="text" value="${user.userRealName}" name="users.userRealName"/></td>
    						<td align="left"><div id="userRealName_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">性&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
    						<td align="left">
    							<input type="hidden" id="sexValue" value="${user.userSex}"/>
    							<input type="radio" name="users.userSex" id="userSex" value="男">男
    							<input type="radio" name="users.userSex" id="userSex" value="女">女
    						</td>
    						<td align="left"><div id="userSex_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">电子邮箱：</td>
    						<td align="left"><input class="text" type="text" id="emailText" value="${user.userEmail }" readonly="readonly"/></td>
    						<td align="left">
    							<a href=""><span class="updateText">修改</span></a>
    						</td>
    					</tr>
    					<tr>
    						<td align="right">联系电话：</td>
    						<td align="left"><input class="text" type="text" id="telephoneText" value="${user.userTelephone }" readonly="readonly"/></td>
    						<td align="left">
    							<a href=""><span class="updateText">修改</span>
    							</a><div class=""></div>
    						</td>
    					</tr>
    					<tr>
    						<td align="right">出身日期：</td>
    						<td align="left">
    							<input class="text" type="text" id="userBirthday" name="users.userBirthday" onfocus="WdatePicker({isShowWeek:true})" 
    							       value="${user.userBirthday }"/></td>
    						<td align="left"><div id="userBirthday_prompt"></div></td>
    					</tr>
    					<tr>
    						<td align="right">所&nbsp;在&nbsp;地：</td>
    						<td align="left">
    							<div class="address"></div>
    							<input type="hidden" id="province" value="${province}"/>
    							<input type="hidden" id="city" value="${city}"/>
    							<input type="hidden" id="country" value="${country}"/>
    						</td>
    						<td align="left"></td>
    					</tr>
    					<tr>
    						<td></td>
    						<td><input class="text" type="text" name="villageStreet" id="street" value="${village }"></td>
    						<td><div id="address_prompt"></div></td>
    					</tr>
    					<tr>
    						<td><input type="hidden" value="${user.userId }" name="users.userId "/></td>
    						<td><input type="image" src="${pageContext.request.contextPath}/images/proscenium/userCenterSavebtn.jpg"></td>
    						<td></td>
    					</tr>
    				</table>
    				</s:form>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
