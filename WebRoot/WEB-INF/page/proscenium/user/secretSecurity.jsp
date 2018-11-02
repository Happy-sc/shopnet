<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<title>拍鞋网---会员管理中心</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/userCenterLayout.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/secretSecutity.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/secretSecurity.js" charset="UTF-8"></script></head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div class="location">
    		<a href="${pageContext.request.contextPath}/userCenter/managerCenter_enterManagerCenter.action?userName=${userName}" target="_self">我的拍鞋</a>
    		<span>&gt;&nbsp;设置密保</span>
    	</div>
    	<div class="content">
    		<div class="content_left">
    			<jsp:include page="/WEB-INF/page/proscenium/user/userCenterNavigation.jsp" />
    		</div>
    		<div class="content_right">
    			<div class="setSecret_title">
    				<span>设置密保</span>
    			</div>
    			<div class="setSecret_content">
    				<form action="${pageContext.request.contextPath }/userCenter/safeCenter_saveScreteSecutity.action" method="post" id="secretForm">
    					<table cellspacing="15">
    						<tr>
    							<td></td>
    							<td><div id="secretTips"></div></td>
    						</tr>
    						<tr>
    							<td width="20%" align="right">
    								<input type="hidden" value="${secret_0.secretId }" name="secretId_01"/>
    								<input type="hidden" value="${secret_0.secretQuestion }" id="question_11"/>
    								问题一
    								</td>
    							<td align="left">
    								<select id="question_01" name="question_01">
    									<option value="">请选择密保问题</option>
    									<option value="您的出生地是?">您的出生地是?</option>
    									<option value="您父亲的姓名是？">您父亲的姓名是？</option>
    									<option value="您父亲的生日是？">您父亲的生日是？</option>
    									<option value="您母亲的姓名是？">您母亲的姓名是？</option>
    									<option value="您母亲的生日是？">您母亲的生日是？</option>
    									<option value="您配偶的姓名是？">您配偶的姓名是？</option>
    									<option value="您配偶的生日是？">您配偶的生日是？</option>
    									<option value="您孩子的姓名是？">您孩子的姓名是？</option>
    									<option value="您小学的学校名称是？">您小学的学校名称是？</option>
    									<option value="您小学班主任的名字是？">您小学班主任的名字是？</option>
    									<option value="您中学的学校名称是？">您中学的学校名称是？</option>
    									<option value="您中学班主任的名字是？">中学班主任的名字是？</option>
    									<option value="您高中的学校名称是？">您高中的学校名称是？</option>
    									<option value="您高中班主任的名字是？">您高中班主任的名字是？</option>
    									<option value="您大学的学号是？">您大学的学号是？</option>
    								</select>
    							</td>
    						</tr>
    						<tr>
    							<td align="right">答案</td>
    							<td><input type="text" id="answer_01" name="answer_01" value="${secret_0.secretAnswer }"/></td>
    						</tr>
    						<tr>
    							<td align="right">
    								<input type="hidden" value="${secret_1.secretId }" name="secretId_02"/>
    								<input type="hidden" value="${secret_1.secretQuestion }" id="question_12"/>
    								问题二
    							</td>
    							<td>
    								<select id="question_02" name="question_02">
    									<option value="">请选择密保问题</option>
    									<option value="您的出生地是?">您的出生地是?</option>
    									<option value="您父亲的姓名是？">您父亲的姓名是？</option>
    									<option value="您父亲的生日是？">您父亲的生日是？</option>
    									<option value="您母亲的姓名是？">您母亲的姓名是？</option>
    									<option value="您母亲的生日是？">您母亲的生日是？</option>
    									<option value="您配偶的姓名是？">您配偶的姓名是？</option>
    									<option value="您配偶的生日是？">您配偶的生日是？</option>
    									<option value="您孩子的姓名是？">您孩子的姓名是？</option>
    									<option value="您小学的学校名称是？">您小学的学校名称是？</option>
    									<option value="您小学班主任的名字是？">您小学班主任的名字是？</option>
    									<option value="您中学的学校名称是？">您中学的学校名称是？</option>
    									<option value="您中学班主任的名字是？">中学班主任的名字是？</option>
    									<option value="您高中的学校名称是？">您高中的学校名称是？</option>
    									<option value="您高中班主任的名字是？">您高中班主任的名字是？</option>
    									<option value="您大学的学号是？">您大学的学号是？</option>
    								</select>
    							</td>
    						</tr>
    						<tr>
    							<td align="right">答案</td>
    							<td><input type="text" id="answer_02" name="answer_02" value="${secret_1.secretAnswer }"/></td>
    						</tr>
    						<tr>
    							<td align="right">
    								<input type="hidden" value="${secret_2.secretId }" name="secretId_03"/>
    								<input type="hidden" value="${secret_2.secretQuestion }" id="question_13"/>
    								问题三
    							</td>
    							<td>
    								<select id="question_03" name="question_03">
    									<option value="">请选择密保问题</option>
    									<option value="您的出生地是?">您的出生地是?</option>
    									<option value="您父亲的姓名是？">您父亲的姓名是？</option>
    									<option value="您父亲的生日是？">您父亲的生日是？</option>
    									<option value="您母亲的姓名是？">您母亲的姓名是？</option>
    									<option value="您母亲的生日是？">您母亲的生日是？</option>
    									<option value="您配偶的姓名是？">您配偶的姓名是？</option>
    									<option value="您配偶的生日是？">您配偶的生日是？</option>
    									<option value="您孩子的姓名是？">您孩子的姓名是？</option>
    									<option value="您小学的学校名称是？">您小学的学校名称是？</option>
    									<option value="您小学班主任的名字是？">您小学班主任的名字是？</option>
    									<option value="您中学的学校名称是？">您中学的学校名称是？</option>
    									<option value="您中学班主任的名字是？">中学班主任的名字是？</option>
    									<option value="您高中的学校名称是？">您高中的学校名称是？</option>
    									<option value="您高中班主任的名字是？">您高中班主任的名字是？</option>
    									<option value="您大学的学号是？">您大学的学号是？</option>
    								</select>
    							</td>
    						</tr>
    						<tr>
    							<td align="right">答案</td>
    							<td><input type="text" id="answer_03" name="answer_03" value="${secret_2.secretAnswer }"/></td>
    						</tr>
    						<tr>
    							<td><input type="hidden" name="userName" value="${user.userName }"/></td>
    							<td><input type="image" src="${pageContext.request.contextPath }/images/proscenium/checkEmailtijiao.jpg"/></td>
    						</tr>
    					</table>
    				</form>
    			</div>
    		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>
  </body>
</html>

