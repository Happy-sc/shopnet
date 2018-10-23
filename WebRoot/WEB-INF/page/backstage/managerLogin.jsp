<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0"> 
	
  	<title>购物网站后台管理系统--登录</title>
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/backstage/login.css" type="text/css"></link>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="${pageContext.request.contextPath }/js/backstage/login.js" charset="GBK"></script>
 </head>
  
  <body>
  <s:form action="manager_main.action" namespace="/manager" id="loginForm">
	<table width="100%" height="166" border="0" cellpadding="0" cellspacing="0">
  	<tr>
    <td height="42" valign="top"><table width="100%" height="42" border="0" cellpadding="0" cellspacing="0" class="login_top_bg">
      <tr>
        <td width="1%" height="21">&nbsp;</td>
        <td height="42">&nbsp;</td>
        <td width="17%">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="100%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg">
      <tr>
        <td width="49%" align="right"><table width="91%" height="532" border="0" cellpadding="0" cellspacing="0" class="login_bg2">
            <tr>
              <td height="138" valign="top"><table width="89%" height="427" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="149">&nbsp;</td>
                </tr>
                <tr>
                  <td height="80" align="right" valign="top"><img src="${pageContext.request.contextPath }/images/backstage/logo.png" width="279" height="68"></td>
                </tr>
                <tr>
                  <td height="198" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="50%">&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>1- 购物网上系统后台管理系统...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>2- 如果没有账号,请联系系统管理员...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>3- 初始登录密码为：111111...</p></td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td height="25" colspan="2" class="left_txt"><p>4- 请根据员工操作手册进行操作...</p></td>
                    </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            
        </table></td>
        <td width="1%" >&nbsp;</td>
        <td width="50%" valign="bottom"><table width="100%" height="59" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="4%">&nbsp;</td>
              <td width="96%" height="38"><span class="login_txt_bt">购物网登陆后台管理系统</span></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td height="21"><table cellSpacing="0" cellPadding="0" width="100%" border="0" id="table211" height="328">
                  <tr>
                    <td height="164" colspan="2" align="center"><form name="myform" action="index.html" method="post">
                        <table cellSpacing="0" cellPadding="0" width="100%" border="0" height="143" id="table212">
                          <tr>
                            <td width="13%" height="38" class="top_hui_text" align="center"><span class="login_txt">用户名：&nbsp;&nbsp; </span></td>
                            <td height="38" colspan="2" class="top_hui_text"><input name="worker.workerId" class="editbox4" value="${workerId}" size="20" id="workerId">                            </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" class="top_hui_text" align="center"><span class="login_txt"> 密&nbsp;&nbsp;&nbsp; 码： &nbsp;&nbsp; </span></td>
                            <td height="35" colspan="2" class="top_hui_text"><input class="editbox4" type="password" size="20"  value="${password}" name="worker.workerPassword" id="workerPassword">
                              <img src="${pageContext.request.contextPath }/images/backstage/luck.gif" width="19" height="18" id="luck"> </td>
                          </tr>
                          <tr>
                            <td width="13%" height="35" align="center"><span class="login_txt" >验证码：</span></td>
                            <td height="35" colspan="2" class="top_hui_text">
                            	<input class=wenbenkuang name="verifycode" type=text id="code" maxLength=4 size=10>
                            	<img src="${pageContext.request.contextPath}/authImage/authImage_1.action" id="authImage"/>
                            	<font class="kbq">看不清??<a href="javascript:void(0);" id="xyz">下一张</a></font>
                            </td>
                          </tr>
                          <tr>
                          	<td></td>
                          	<td><div class="loginError">${tips}</div></td>
                          </tr>
                          <tr>
                            <td height="35" >&nbsp;</td>
                            <td width="20%" height="35" ><input name="Submit" type="submit" class="button" id="Submit" value="登 陆"> </td>
                            <td width="67%" class="top_hui_text"><input name="cs" type="button" class="button" id="cs" value="取 消" onClick="showConfirmMsg1()"></td>
                          </tr>
                        </table>
                        <br>
                    </form></td>
                  </tr>
                  <tr>
                    <td width="433" height="164" align="right" valign="bottom"><img src="${pageContext.request.contextPath }/images/backstage/login-wel.gif" width="242" height="138"></td>
                    <td width="57" align="right" valign="bottom">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
          </table>
          </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0" class="login-buttom-bg">
      <tr>
        <td align="center"><span class="login-buttom-txt">Copyright &copy;  </span></td>
      </tr>
    </table></td>
  </tr>
</table>
</s:form>
</body>
</html>
