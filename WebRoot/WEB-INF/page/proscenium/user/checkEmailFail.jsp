<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/checkEmail.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/checkEmail.js" charset="UTF-8"></script>
  </head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="checkEmail_title">
    				<span style="color:#A8101F">验证失败</span>
    			</div>
    			<div class="checkEmail_Fail">
    				<table border="0">
    					<tr>
    						<td rowspan="3" align="right"><img src="${pageContext.request.contextPath}/images/proscenium/safeCenterFail.jpg"/></td>
    						<td><span>抱歉,验证失败,可能原因如下:</span></td>
    					</tr>
    					<tr>
    						<td>1:您的邮箱验证超时,请注意在24小时内进入邮箱点击验证链接。</td>
    					</tr>
    					<tr>
    						<td>2:您已经点击过该链接,此链接已失效。</td>
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
