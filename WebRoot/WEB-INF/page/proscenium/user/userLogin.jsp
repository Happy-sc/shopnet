<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
	<title>拍鞋购物商城_用户登录</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userLogin.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/userLogin.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div id="login">
    		<div id="login_top"><span style="font-size: 14px;font-weight: bold;line-height: 35px;"> &nbsp; 用户登录</span>
    		</div>
    		<div id="login_content">
    			<div id="login_left">
    			<s:form action="usersLogin_userLogin.action" namespace="/users" onsubmit="return checkLogin();">
    				<table id="login_table" border="0">
    				<tr >
    					<td align="right" width="100px">用&nbsp;户&nbsp;名：</td>
    					<td width="260px">
    						<input type="text" class="login_text"  id="userName" value="用户名/邮箱" 
    						       name="userName" onfocus="userNameFocus();" onblur="userNameBlur();"/></td>
    				    <td align="left"><div id="userName_prompt"></div></td>
    				</tr>
    				<tr >
    					<td align="right">登录密码：</td>
    					<td><input type="password" class="login_text" id="password" name="password"/></td>
    					<td align="left">
    						<div id="password_prompt">
    							<a href="${pageContext.request.contextPath}/users/forgetPassword_enterCheckIdentity.action">忘记密码</a>
    						</div>
    					</td>
    				</tr>
    				<tr>
    					<td></td>
    					<td>
    						<input type="checkbox" >记住账户名&nbsp;&nbsp;&nbsp;
    						<input type="checkbox" >自动登录
    					</td>
    				</tr>
    				<tr>
    					<td>
    						<input type="hidden" name="myURL" value="<s:property value="#request.url"/>">
    					</td>
    					<td>
    						<input type="image" src="${pageContext.request.contextPath }/images/proscenium/uers_login.jpg">
    					</td>
    				</tr>
    				<tr>
    					<td><input type="hidden" value="<s:property value="#request.url"/>" name="url"/></td>
    					<td colspan="2" align="center"><div class="error_prompt"><s:property value="#request.tips"/></div></td>
    				</tr>
    			</table>
    			</s:form>
    		</div>
    		<div id="login_right">
    			<table id="right">
    				<tr>
    					<td><span class="right_text">还不是拍鞋用户？</span></td>
    				</tr>
    				<tr>
    					<td><span class="right_text">现在免费注册成为拍鞋用户，便能立刻享受便宜又放心的购物乐趣。</span></td>
    				</tr>
    				<tr>
    					<td align="center"><span class="right_text1">我们诚挚邀请您加入</span></td>
    				</tr>
    				<tr>
    					<td align="center"><span class="right_text1">中国最大品牌鞋销售广场</span></td>
    				</tr>
    				<tr>
    					<td align="center">
    						<a href="${pageContext.request.contextPath}/users/usersRegist_userRegistUI.action">
    							<img src="${pageContext.request.contextPath }/images/proscenium/user_regist_01.jpg" id="login_regist" />
    						</a>
    					</td>
    				</tr>
    			</table>
    		</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>
