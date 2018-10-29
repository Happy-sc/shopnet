<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  	<title>${goods.goodsName }</title>
 	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/layout.css" type="text/css"></link>
  	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/showGoodsDetail.css" type="text/css"></link>
  	  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/proscenium/comment.css" type="text/css"></link>
  	 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/jQueryUI/jquery.ui.all.css" type="text/css"></link>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery-1.7.2.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.core.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.widget.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.mouse.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.button.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.draggable.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.position.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery/jquery.ui.dialog.js"></script>
  	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/goodsDetailInfor.js" charset="GBK"></script>
 	 <script type="text/javascript" src="${pageContext.request.contextPath }/js/proscenium/comment.js" charset="GBK"></script>
 	</head>
  
  <body>
    <div id="top">
    	<jsp:include page="/WEB-INF/page/proscenium/index_top.jsp" />
    </div>
    <div id="main">
    	<div id="goods_detail">
    		<div id="goods_image" >
    			<img src="${goodsColor.goodsImage}" class="goodsImage"/>
    			<a href="javascript:void(0);">
    				<img src="${pageContext.request.contextPath}/images/proscenium/shoucang.jpg" class="shoucang"/>
    			</a>
    			<div class="sccgDIV">
     				<font>收藏成功</font>
     				<a href="javascript:void(0);">&Chi;</a>
    			</div>
   				 <div class="scsbDIV">
    				<font>该商品已经收藏了</font>
    				<a href="javascript:void(0);">&Chi;</a>
   				 </div>
    		</div>
    		<div id="goods_infor">
    			<div id="goods_infor_title">
    				<span id="goodsTitle">${goods.goodsName }</span>
    				<img src="${pageContext.request.contextPath }/images/proscenium/goodsDetail_hr.jpg" width="100%"/>
    			</div>
    			<div id="goods_infor_base">
    				<table id="goodsBase_table" cellpadding="4">
    					<tr>
    						<td width="50px" align="right"><span id="goodsDetailText">价&nbsp;格：</span></td>
    						<td align="left"><span id="goodsDetailSCJ">&yen;${goods.goodsMarketPrice }</span></td>
    					</tr>
    					<tr>
    						<td><span id="goodsDetailText">赠&nbsp;&nbsp;&nbsp;&nbsp;送：</span></td>
    						<td><span id="goodsDetailText">单件送<span style="font-size:14px;color:red;"><fmt:formatNumber type="number" value="${goods.goodsMarketPrice/100}" maxFractionDigits="0"/></span>个金币</span></td>
    					</tr>
    					<tr>
    						<td><span id="goodsDetailText">评&nbsp;&nbsp;&nbsp;&nbsp;论：</span></td>
    						<td>
    							<c:forEach begin="1" end="${sumA}">
    								<img src="${pageContext.request.contextPath }/images/proscenium/dafen_01.jpg" class="pjsxx"/>
    							</c:forEach>
    							<c:forEach begin="1" end="${5-sumA}">
    								<img src="${pageContext.request.contextPath }/images/proscenium/dafen_00.jpg" class="pjsxx"/>
    							</c:forEach>
    							<span style="font-size: 12px;color: #666666">共有(<span style="font-size:14px;color:red;">${sum}</span>)人参与评论</span>
    						</td>
    						
    					</tr>
    					<tr>
    						<td><span id="goodsDetailText">运&nbsp;&nbsp;&nbsp;&nbsp;费：</span></td>
    						<td><span style="font-size: 12px;color: #666666">全场购物满229元免运费</span></td>
    					</tr>
    					<tr>
    						<td><span id="goodsDetailText">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</span></td>
    						<td>
    							<a href="" class="goodsDetail">
    								${goods.brand.brandName}官方旗舰店&gt;&gt;
    							</a>
    						<br></td>
    					</tr>
    				</table>
    			</div>
    			<div id="goods_infor_detail">
    				<table id="goodsDetail_talbe" cellpadding="8" border="0">
    					<tr>
    						<td width="65px" align="right">
    							<input type="hidden" value="${goodsColor.goodsImage}" id="choosedImg">
    							<input type="hidden" value="${goodsColor.goodsColor}" id="choosedColor" />
    							<input type="hidden" value="${goods.goodsId }" id="choosedGoodsId"/>
    							<input type="hidden" id="sfyjysp" />
    							<span id="goodsDetailText">可选颜色：</span>
    						</td>
    						<td align="left">
    							<c:forEach items="${goodsColors}"  var="gc">
    								<a href="${pageContext.request.contextPath}/goods/goods_showGoods?goodsId=${goods.goodsId}&color=${gc.goodsColorId}" target="_self">
    									<img src="${gc.goodsImage}" id="goodsColor" title="${gc.goodsColor}"/>
    								</a>
    							</c:forEach>
    						</td>
    					</tr>
    					<tr id="qxzcm">
    						<td width="65px" align="right"><span id="goodsDetailText">其它选择：</span></td>
    						<td>
    							<c:forEach items="${goodsSizes}" var="gs">
    								<a href="javascript:void(0);"><span class="size">${gs.goodsAttr}</span></a>
    							</c:forEach>
    						</td>
    					</tr>
    					<tr>
    						<td width="65px" align="right"><span id="goodsDetailText">购买数量：</span></td>
    						<td>
    							<a href="javascript:void(0);"><span class="number" id="number_">-</span></a>
    							<input type="text" value="1" style="width: 30px" id="buyNumber"/>
    							<a href="javascript:void(0);"><span class="number" id="number+">+</span></a>
    						</td>
    					</tr>
    					<tr>
    						<td></td>
    						<td>
    							<a href="javascript:void(0);">
    								<img src="${pageContext.request.contextPath}/images/proscenium/goumai_01.jpg"　class="goumai">
    							</a>
    							&nbsp;&nbsp;&nbsp;
    							<a href="javascript:void(0);">
    								<img src="${pageContext.request.contextPath}/images/proscenium/addcar_01.jpg" class="addCar"/>
    							</a>
    						</td>
    					</tr>
    				</table>
    			</div>
    		</div>
    	</div>
    	<div id="goodsDetail_otherInfor">
			<div class="tab">
			<ul>
				<li id="one1" onclick="setTab('one',1,6)" class="now"> 
					商品详情
				</li>
				<li id="one2" onclick="setTab('one',2,6)">
					顾客评价(<font class="commentSum">${sum}</font>)
				</li>
				<li id="one3" onclick="setTab('one',3,6)">
					正品保障
				</li>
				<li id="one4" onclick="setTab('one',4,6)">
					售后服务
				</li>
				<li id="one5" onclick="setTab('one',5,6)">
					支付说明
				</li>
				<li id="one6" onclick="setTab('one',6,6)">
					配送说明
				</li>
			</ul>
		</div>
		
		<div class="list">
			<div id="one_con1">
				<jsp:include page="/WEB-INF/page/proscenium/goods/goodsOtherInfor.jsp" ></jsp:include>
			</div>
			<div id="one_con2" style="display: none;">
				<jsp:include page="/WEB-INF/page/proscenium/goods/clientEvaluate.jsp" ></jsp:include>
			</div>
			<div id="one_con3" style="display: none;">
				<jsp:include page="/WEB-INF/page/proscenium/goods/qualityGuarantee.jsp" ></jsp:include>
			</div>
			<div id="one_con4" style="display: none;">
				<jsp:include page="/WEB-INF/page/proscenium/goods/sellerService.jsp" ></jsp:include>
			</div>
			<div id="one_con5" style="display: none"> 
				<jsp:include page="/WEB-INF/page/proscenium/goods/payExplanation.jsp" ></jsp:include>
			</div>
			<div id="one_con6" style="display: none"> 
				<jsp:include page="/WEB-INF/page/proscenium/goods/deliveryExplanation.jsp" ></jsp:include>
			</div>
		</div>
    	</div>
    </div>
    <div id="bottom">
    	<jsp:include page="/WEB-INF/page/proscenium/index_bottom.jsp" />
    </div>

    <div class="addCarSuccess">
    	<table border="0">
    		<tr>
    			<td colspan="2">
    				<a href="javascript:void(0);">
    					<img src="${pageContext.request.contextPath}/images/proscenium/x_1.jpg"/ class="x">
    				</a>
    			</td>
    		</tr>
    		<tr>
    			<td align="right"><img src="${pageContext.request.contextPath}/images/proscenium/registSuccess.jpg"/></td>
    			<td><span class="successText">商品成功添加到购物车!</span></td>
    		</tr>
    		<tr>
    			<td><br></td>
    			<td>购物车共计<span class="number"></span>件商品,合计:<span class="price">${price}</span>元</td>
    		</tr>
    		<tr>
    			<td><br></td>
    			<td>
    				<a href="${pageContext.request.contextPath}/order/orderCar_showCar.action">
    					<img src="${pageContext.request.contextPath}/images/proscenium/qujiesuan.jpg"/ class="jiesuan">
    				</a>
    				<a href="javascript:void(0);" class="zaikan">
    					再逛逛&gt;&gt;
    				</a>
    			</td>
    		</tr>
    	</table>
    </div>
    <div class="userLogin" title="用户登录">
    	<table cellpadding="0" cellspacing="0" border="0">
    		<tr>
    			<td align="right" width="30%"><font>用户名：</font></td>
    			<td><input type="text" name="userName" class="loginText" id="userName"/></td>
    		</tr>
    		<tr>
    			<td></td>
    			<td><div class="userName_prompt">&nbsp;</div></td>
    		</tr>
    		<tr>
    			<td align="right"><font>密&nbsp;&nbsp;&nbsp;码：</font></td>
    			<td><input type="password" name="password" class="loginText" id="password"></td>
    		</tr>
    		<tr>
    			<td></td>
    			<td><div class="password_prompt">&nbsp;${tips}</div></td>
    		</tr>
    		<tr>
    			<td></td>
    			<td align="right"><a href="${pageContext.request.contextPath}/users/forgetPassword_enterCheckIdentity.action" class="wjmm">忘记密码</a></td>
    		</tr>
    		<tr>
    			<td>
    				<input type="hidden" id="type"/>
    			</td>
    			<td>
    				<a href="javascript:void(0);">
    					<img src="${pageContext.request.contextPath}/images/proscenium/userLogin_01.jpg" class="userLoginGD"/>	
    				</a>
    			</td>
    		</tr>
    		<tr>
    			<td></td>
    			<td>&nbsp;</td>
    		</tr>
    		<tr>
    			<td></td>
    			<td>还没有账号?<a href="${pageContext.request.contextPath}/users/usersRegist_userRegistUI.action" target="_blank" class="ljzc">立即注册</a></td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
