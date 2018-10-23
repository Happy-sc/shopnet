<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  </head>
  
  <body>
    <div id="goods_DetailInfor">
    	<div id="goods_otherinfor">
    		<div id="goods_infor_left">
    			<img  src="${goodsColor.goodsImage}" style="height: 100%">
    		</div>
    		<div id="goods_infor_right">
    			<table id="goods_infor_table" border="0" cellpadding="5" cellspacing="">
    				<tr>
    					<td align="left" colspan="6" class="goods_DetailInfor"><span class="goodsInforTableTitle">商品其他信息</span></td>
    				</tr>
    				<tr>
    					<td align="right" id="goodsInfor_name">货&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
    					<td align="left" >${goods.goodsName }</td>
    					<td align="right" id="goodsInfor_name">品&nbsp;&nbsp;&nbsp;&nbsp;牌：</td>
    					<td>
    						<a href="" class="goodsDetail">
    							${goods.brand.brandName }
    						</a>
    					</td>
    					<td align="right" id="goodsInfor_name">款&nbsp;&nbsp;&nbsp;&nbsp;式：</td>
    					<td>
    						<a href="" class="goodsDetail">
    							${goods.style.styleName }
    						</a>
    					</td>
    				</tr>
    				<tr>
    					<td align="right" id="goodsInfor_name">闭合方式：</td>
    					<td>${goods.goodsBhfs }</td>
    					<td align="right" id="goodsInfor_name">上架时间：</td>
    					<td>${goods.goodsGrounding }</td>
    					<td align="right" id="goodsInfor_name">上市年份：</td>
    					<td>${goods.goodsMarket }</td>
    				</tr>
    				<tr>
    					<td align="right" id="goodsInfor_name">鞋面材质：</td>
    					<td>${goods.goodsXmcz }</td>
    					<td align="right" id="goodsInfor_name">鞋底材质：</td>
    					<td>${goods.goodsXdcz }</td>
    					<td align="right" id="goodsInfor_name">适合季节：</td>
    					<td>${goods.goodsShjj }</td>
    				</tr>
    				<tr>
    					<td align="right">商品颜色：</td>
    					<td>${goodsColor.goodsColor}</td>
    					<td align="right" id="goodsInfor_name">鞋码偏差：</td>
    					<td><span style="color:#FF3300">建议正常码购买</span></td>
    				</tr>
    				<tr>
    				</tr>
    				<tr>
    					<td align="left" colspan="6" class="goods_DetailInfor">
    						<span class="goodsInforTableTitle">以下是实物测量结果 (参考鞋码：41码) </span>
    					</td>
    				</tr>
    				<tr>
    					<td align="right" id="goodsInfor_name">底高(cm)：</td>
    					<td>${goods.goodsHeight }</td>
    					<td align="right" id="goodsInfor_name">鞋长(cm)：</td>
    					<td>${goods.goodsLength }</td>
    					<td align="right" id="goodsInfor_name">重量(g/只)：</td>
    					<td>${goods.goodsWeight }</td>
    				</tr>
    			</table>
    		</div>
    	</div>
    	<div id="goods_sizeTable">
    		<div id="goodsSize_tilte">
    			<span style="font-size:24px;font-weight: bolder;">&nbsp;&nbsp;&nbsp;&nbsp;国际尺码对照表</span><Br/>
    			<span style="font-size:16px;font-weight: bolder;">International Size Comparison Table</span>
    		</div>
    		<div id="goodsSize_man">
    			<table	id="goodsSize_table" cellpadding="0" cellspacing="0">
    				<tr>
    					<td align="center" colspan="8" class="goodsSizeTitle">男鞋尺码对照表</td>
    				</tr>
    				<tr>      
    					<td class="goodsSize_country" width="16%">美码/US</td>
    					<td>5.5</td>
    					<td>6.5</td>
    					<td>7</td>
    					<td>8</td>
    					<td>8.5</td>
    					<td>9.5</td>
    					<td>10</td>
    				</tr>
    				<tr>       
    					<td class="goodsSize_country">英码/UK</td>
    					<td>5</td>
    					<td>6</td>
    					<td>6.5</td>
    					<td>7.5</td>
    					<td>8</td>
    					<td>9</td>
    					<td>9.5</td>
    				</tr>
    				<tr>      
    					<td class="goodsSize_country">法码/EUR</td>
    					<td>39 </td>
    					<td>40</td>
    					<td>41</td>
    					<td>42</td>
    					<td>43</td>
    					<td>44</td>
    					<td>45</td>
    				</tr>
    				<tr>       
    					<td class="goodsSize_country">中国码/CH</td>
    					<td>245</td>
    					<td>250</td>
    					<td>255</td>
    					<td>260</td>
    					<td>265</td>
    					<td>270</td>
    					<td>280</td>
    				</tr>
    			</table>
    		</div>
    		<div id="goodsSize_women">
    			<table	id="goodsSize_table" cellpadding="0" cellspacing="0">
    				<tr>
    					<td align="center" colspan="8" class="goodsSizeTitle">女鞋尺码对照表</td>
    				</tr>
    				<tr>            
    					<td class="goodsSize_country" width="16%">美码/US</td>
    					<td>2.5</td>
    					<td>3.5</td>
    					<td>4.5</td>
    					<td>5</td>
    					<td>5.5</td>
    					<td>6.5</td>
    				</tr>
    				<tr>           
    					<td class="goodsSize_country">英码/UK</td>
    					<td>2</td>
    					<td>3</td>
    					<td>4</td>
    					<td>4.5</td>
    					<td>5</td>
    					<td>6</td>
    				</tr>
    				<tr>            
    					<td class="goodsSize_country">法码/EUR</td>
    					<td>35</td>
    					<td>36</td>
    					<td>37</td>
    					<td>38</td>
    					<td>39</td>
    					<td>40</td>
    				</tr>
    				<tr>      
    					<td class="goodsSize_country">中国码/CH</td>
    					<td>220 </td>
    					<td>230</td>
    					<td>235</td>
    					<td>240</td>
    					<td>245</td>
    					<td>250</td>
    				</tr>
    			</table>
    		</div>
    	</div>
    </div>
  </body>
</html>
