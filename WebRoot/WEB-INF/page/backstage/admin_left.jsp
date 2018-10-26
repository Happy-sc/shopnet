<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/backstage/adminLeft.css" type="text/css"></link>
 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery/jquery-1.7.2.js"></script>
 	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/adminLeft.js"></script>
 </head>
  <body>

  <table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
  <tr>
    <td width="182" valign="top">
    <div id="container">
      <div class="grjbxx">
      	<h1 class="type"><a href="javascript:void(0)">个人基本信息</a></h1>
      	<div class="content"  >
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath }/images/backstage/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM" >
          <li><a href="${pageContext.request.contextPath }/workerInfo/workerInfo_workerInforUI.action" target="main">基本信息</a></li>
          <li><a href="${pageContext.request.contextPath }/workerInfo/workerInfo_updateInfoUI.action" target="main">信息修改</a></li>
          <li><a href="${pageContext.request.contextPath }/workerInfo/workerInfo_updatePasswordUI.action" target="main">密码修改</a></li>
        </ul>
      </div>
      </div>
      <div class="spxxgl">
      	<h1 class="type"><a href="javascript:void(0)">商品信息管理</a></h1>
      	<div class="content" id="hideDiv">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath }/images/backstage/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM">
          <li><a href="${pageContext.request.contextPath }/goodsManager/goodsManager_addGoodsUI.action" target="main">增加商品</a></li>
          <li><a href="" target="main">商品管理</a></li>
          <li><a href="${pageContext.request.contextPath }/goodsManager/categoryManager_categoryManagerUI.action" target="main">分类管理</a></li>
          <li><a href="${pageContext.request.contextPath }/goodsManager/styleManager_styleManagerUI.action" target="main">款式管理</a></li>
          <li><a href="${pageContext.request.contextPath }/goodsManager/brandManager_brandManagerUI.action" target="main">品牌管理</a></li>
        </ul>
      </div>
      </div>
      <div class="ddxxgl">
      	<h1 class="type"><a href="javascript:void(0)">订单信息管理</a></h1>
      <div class="content" id="hideDiv">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath }/images/backstage/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM"  >
		  <li><a href="${pageContext.request.contextPath }/orderManager/orderManager_managerOrder.action" target="main">查&nbsp;询&nbsp;订&nbsp;单</a></li>
          <li><a href="${pageContext.request.contextPath }/orderManager/orderManager_managerOrder.action?type=dfk" target="main">待付款订单</a></li>
          <li><a href="${pageContext.request.contextPath }/orderManager/orderManager_managerOrder.action?type=dfh" target="main">待发货订单</a></li>
          <li><a href="${pageContext.request.contextPath }/orderManager/orderManager_managerOrder.action?type=yfh" target="main">已发货订单</a></li>
          <li><a href="${pageContext.request.contextPath }/orderManager/orderManager_managerOrder.action?type=ysh" target="main">已收货订单</a></li>
        </ul>
      </div>
      </div>
      <div class="xtxxgl">
      <h1 class="type"><a href="javascript:void(0)">系统信息管理</a></h1>
      <div class="content" id="hideDiv">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath }/images/backstage/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MM" >
          <li><a href="${pageContext.request.contextPath }/systemManager/workerManager_workerManagerUI.action" target="main">员工管理</a></li>
          <li><a href="${pageContext.request.contextPath }/systemManager/noticeManager_noticeManagerUI.action" target="main">公告管理</a></li>
        </ul>
      </div>
      </div>
      <div class="xtxxgl">
      <h1 class="type"><a href="javascript:void(0)">版权信息说明</a></h1>
      <div class="content" id="hideDiv">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><img src="${pageContext.request.contextPath }/images/backstage/menu_topline.gif" width="182" height="5" /></td>
          </tr>
        </table>
        <ul class="MMf" >
          <li>XX </li>
		  <li>XX</li>
		  <li>XX</li>
        </ul>
      </div>
      </div>

    </div>
   </td>
  </tr>
</table>
  </body>
</html>
