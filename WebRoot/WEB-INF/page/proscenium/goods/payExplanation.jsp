<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  </head>
  
  <body>
    <div id="payExplanationg">
    	<table id="payExplanationg_table" cellpadding="0" cellspacing="0">
    		<tr>
    			<td align="center" class="payExplanationg_title" width="20%">支付方式</td>
    			<td align="center" class="payExplanationg_title">支付说明</td>
    		</tr>
    		<tr>
    			<td align="center">货到付款</td>
    			<td>快递公司送货上门，客户收单验货后，直接将货款交付给配送员的结算方式。
    				（注：目前暂未开通刷卡服务，货到后需要现金支付） </td>
    		</tr>
    		<tr>
    			<td rowspan="2" align="center">在线支付</td>
    			<td>
    				<table id="payExplanationg_zxzf" cellpadding="5" cellspacing="0">
    					<tr>
    						<td width="20%" align="right">第三方支付平台 </td>
    						<td></td>
    					</tr>
    					<tr>
    						<td align="right"><img src="${pageContext.request.contextPath }/images/proscenium/bank/zhb.jpg"/></td>
    						<td>支付宝"简单、安全、快速"的在线支付，同时支持信用卡  查看支付宝支付详情</td>
    					</tr>
    					<tr>
    						<td colspan="2">
    							<img src="${pageContext.request.contextPath }/images/proscenium/goodsDetail_hr.jpg" width="100%" style="border:0px"/>
    						</td>
    					</tr>
    					<tr>
    						<td align="right"><img src="${pageContext.request.contextPath }/images/proscenium/bank/cft.jpg"/></td>
    						<td>财付通"交易免手续费、经济实惠、便捷"，同时支持信用卡  查看财付通支付详情</td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				只要您开通了以下银行的"网上支付"功能，即可进行在线支付。支持信用卡  查看网上支付流程
					<table id="payExplanationg_bank">
						<tr>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zgjsyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zgyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zglyyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zggsyh.jpg"/></td>
						</tr>
						<tr>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/xyyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zsyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/jtyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zxyh.jpg"/></td>
						</tr>
						<tr>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zgyzcxyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zggdyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/gdfzyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/szfzyh.jpg"/></td>
						</tr>
						<tr>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/zgmsyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/shpdfzyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/hxyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/bhyh.jpg"/></td>
						</tr>
						<tr>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/beadyyh.jpg"/></td>
							<td><img src="${pageContext.request.contextPath }/images/proscenium/bank/njyh.jpg"/></td>
							<td></td>
							<td></td>
						</tr>
					</table>
    			</td>
    		</tr>
    		<tr>
    			<td rowspan="2" align="center">线下支付</td>
    			<td>
    				<table id="payExplanationg_xxzf">
    					<tr>
    						<td width="10%" align="center">邮政汇款</td>
    						<td>选择邮政汇款的顾客，请在下单完成后尽快到邮局柜台进行汇款，邮政汇款订单在下单7个工作日后，
    							如未收到汇款，订单将被系统自动取消。查看汇款详情</td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<table id="payExplanationg_xxzf">
    					<tr>
    						<td width="10%" align="center">银行转帐</td>
    						<td>您可以到银行通过"转账"进行支付。（注：您付款成功后请务必及时通知我们，以便我们能及时为您发货。）
    							查看支持汇款的银行及收款账号</td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
