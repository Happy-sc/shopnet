<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
  </head>
  
  <body>
    <div class="brandsSpell">
    	<div class="spell">
    		<table cellpadding="5">
    			<tr>
    				<td><img title="全部品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/quanbu_01.jpg"/ id="quanbu"></td>
    				<td><img title="以A开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/A_01.jpg"/ id="A"></td>
    				<td><img title="以B开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/B_01.jpg"/ id="B"></td>
    				<td><img title="以C开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/C_01.jpg"/ id="C"></td>
    				<td><img title="以D开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/D_01.jpg"/ id="D"></td>
    				<td><img title="以E开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/E_01.jpg"/ id="E"></td>
    				<td><img title="以F开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/F_01.jpg"/ id="F"></td>
    				<td><img title="以G开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/G_01.jpg"/ id="G"></td>
    				<td><img title="以H开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/H_01.jpg"/ id="H"></td>
    				<td><img title="以I开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/I_01.jpg"/ id="I"></td>
    				<td><img title="以J开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/J_01.jpg"/ id="J"></td>
    				<td><img title="以K开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/K_01.jpg"/ id="K"></td>
    				<td><img title="以L开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/L_01.jpg"/ id="L"></td>
    				<td><img title="以M开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/M_01.jpg"/ id="M"></td>
    				<td><img title="以N开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/N_01.jpg"/ id="N"></td>
    				
    			</tr>
    			<tr>
    				<td><img title="以O开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/O_01.jpg"/ id="O"></td>
    				<td><img title="以P开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/P_01.jpg"/ id="P"></td>
    				<td><img title="以Q开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/Q_01.jpg"/ id="Q"></td>
    				<td><img title="以R开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/R_01.jpg"/ id="R"></td>
    				<td><img title="以S开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/S_01.jpg"/ id="S"></td>
    				<td><img title="以T开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/T_01.jpg"/ id="T"></td>
    				<td><img title="以U开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/U_01.jpg"/ id="U"></td>
    				<td><img title="以V开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/V_01.jpg"/ id="V"></td>
    				<td><img title="以W开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/W_01.jpg"/ id="W"></td>
    				<td><img title="以X开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/X_01.jpg"/ id="X"></td>
    				<td><img title="以Y开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/Y_01.jpg"/ id="Y"></td>
    				<td><img title="以Z开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/Z_01.jpg"/ id="Z"></td>
    				<td><img title="以0-9开头的品牌" src="${pageContext.request.contextPath }/images/proscenium/brands/0-9_01.jpg"/ id="0-9"></td>
    			</tr>
    		</table>
    	</div>
    	<div class="brands">
    		<div class="brands_A">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/a.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${ABrands_rows}" var="i">
								<tr>
    							<c:choose>
    							<c:when test="${i==ABrands_rows}">
    								<c:forEach begin="1" end="${ABrands_num}" var="j">
    									<c:set var="b" value="${ABrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-ABrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${ABrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_B">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/b.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${BBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==BBrands_rows}">
    								<c:forEach begin="1" end="${BBrands_num}" var="j">
    									<c:set var="b" value="${BBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-BBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${BBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_C">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/c.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${CBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==CBrands_rows}">
    								<c:forEach begin="1" end="${CBrands_num}" var="j">
    									<c:set var="b" value="${CBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li style="text-align: c"> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-CBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${CBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_D">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/d.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${DBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==DBrands_rows}">
    								<c:forEach begin="1" end="${DBrands_num}" var="j">
    									<c:set var="b" value="${DBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-DBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${DBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell} )
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_E">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/e.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${EBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==EBrands_rows}">
    								<c:forEach begin="1" end="${EBrands_num}" var="j">
    									<c:set var="b" value="${EBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-EBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${EBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_F">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/f.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${FBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==BBrands_rows}">
    								<c:forEach begin="1" end="${FBrands_num}" var="j">
    									<c:set var="b" value="${FBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-FBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${FBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_G">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/g.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${GBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==GBrands_rows}">
    								<c:forEach begin="1" end="${GBrands_num}" var="j">
    									<c:set var="b" value="${GBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-GBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${GBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_H">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/h.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${HBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==HBrands_rows}">
    								<c:forEach begin="1" end="${HBrands_num}" var="j">
    									<c:set var="b" value="${HBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left" width="25%">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-HBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${HBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}"> 
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_I">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/i.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${IBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==IBrands_rows}">
    								<c:forEach begin="1" end="${IBrands_num}" var="j">
    									<c:set var="b" value="${IBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-IBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${IBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_J">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/j.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${JBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==JBrands_rows}">
    								<c:forEach begin="1" end="${JBrands_num}" var="j">
    									<c:set var="b" value="${JBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-JBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${JBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_K">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/k.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${KBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==KBrands_rows}">
    								<c:forEach begin="1" end="${KBrands_num}" var="j">
    									<c:set var="b" value="${KBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-KBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${KBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_L">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/l.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${LBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==LBrands_rows}">
    								<c:forEach begin="1" end="${LBrands_num}" var="j">
    									<c:set var="b" value="${LBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-KBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${LBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_M">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/m.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${MBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==BBrands_rows}">
    								<c:forEach begin="1" end="${MBrands_num}" var="j">
    									<c:set var="b" value="${MBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-MBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${MBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_N">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/n.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${NBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==NBrands_rows}">
    								<c:forEach begin="1" end="${NBrands_num}" var="j">
    									<c:set var="b" value="${NBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-NBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${NBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_O">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/o.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${OBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==OBrands_rows}">
    								<c:forEach begin="1" end="${OBrands_num}" var="j">
    									<c:set var="b" value="${OBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-OBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${OBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_P">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/p.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${PBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==PBrands_rows}">
    								<c:forEach begin="1" end="${PBrands_num}" var="j">
    									<c:set var="b" value="${PBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-PBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${PBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_Q">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/q.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${QBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==QBrands_rows}">
    								<c:forEach begin="1" end="${QBrands_num}" var="j">
    									<c:set var="b" value="${QBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-QBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${QBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_R">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/r.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${RBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==RBrands_rows}">
    								<c:forEach begin="1" end="${RBrands_num}" var="j">
    									<c:set var="b" value="${RBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-RBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${RBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_S">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/s.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${SBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==SBrands_rows}">
    								<c:forEach begin="1" end="${SBrands_num}" var="j">
    									<c:set var="b" value="${SBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-SBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${SBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_T">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/t.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${TBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==TBrands_rows}">
    								<c:forEach begin="1" end="${TBrands_num}" var="j">
    									<c:set var="b" value="${TBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-TBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${TBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_U">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/u.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${UBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==UBrands_rows}">
    								<c:forEach begin="1" end="${UBrands_num}" var="j">
    									<c:set var="b" value="${UBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-UBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${UBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_V">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/v.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${VBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==VBrands_rows}">
    								<c:forEach begin="1" end="${VBrands_num}" var="j">
    									<c:set var="b" value="${VBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-VBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${VBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_W">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/w.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${WBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==WBrands_rows}">
    								<c:forEach begin="1" end="${WBrands_num}" var="j">
    									<c:set var="b" value="${WBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-WBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${WBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_X">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/x.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${XBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==XBrands_rows}">
    								<c:forEach begin="1" end="${XBrands_num}" var="j">
    									<c:set var="b" value="${XBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-XBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${XBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_Y">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/y.jpg">
    			</div>
    			<div class="spellBrands">
    			<table>
    					<c:forEach begin="1" end="${YBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==YBrands_rows}">
    								<c:forEach begin="1" end="${YBrands_num}" var="j">
    									<c:set var="b" value="${YBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-YBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${YBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_Z">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/z.jpg">
    			</div>
    			<div class="spellBrands">
    				<table>
    					<c:forEach begin="1" end="${ZBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==ZBrands_rows}">
    								<c:forEach begin="1" end="${ZBrands_num}" var="j">
    									<c:set var="b" value="${ZBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-ZBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${ZBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    		<div class="brands_0-9">
    			<div class="spellBrandsHr"></div>
    			<div class="spellLeft">
    				<img src="${pageContext.request.contextPath }/images/proscenium/brands/0-9.jpg">
    			</div>
    			<div class="spellBrands">
    				<table>
    					<c:forEach begin="1" end="${numBrands_rows}" var="i">
    						<tr>
    							<c:choose>
    							<c:when test="${i==numBrands_rows}">
    								<c:forEach begin="1" end="${numBrands_num}" var="j">
    									<c:set var="b" value="${numBrands[(j-1)+(i-1)*4]}"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell })
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    								<c:forEach begin="1" end="${4-numBrands_num}"><td></td></c:forEach>
    							</c:when>
    							<c:otherwise>
    								<c:forEach begin="1" end="4" var="j">
    									<c:set  value="${numBrands[(j-1)+(i-1)*4]}" var="b"></c:set>
    									<td align="left">
    										<ul class="brandImgUL" title="${b.brandName}">
    											<li><img src="${b.brandImage }"/></li>
    											<li> 
    												<a href="">
    													${b.brandName}(${b.brandSpell})
    												</a>
    											</li>
    										</ul>
    									</td>
    								</c:forEach>
    							</c:otherwise>
    						</c:choose>
    						</tr>
    					</c:forEach>
    				</table>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>
