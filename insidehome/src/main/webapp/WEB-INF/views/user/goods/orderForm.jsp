<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<link href="<c:url value="/resources/css/goodsDetail.css" />" rel="stylesheet" />

<div class="body-info">
   <div class="goods-title2">
   		상품 주문정보 확인
   </div>
   <hr>
   <div class="info-inner">
		<div class="order-goods-box">
			<table style="border-bottom: 1px solid #D5D5D5;"class="order-goods-tb">
				<c:set var="goodsCode" value="${goods.goodsCode}" />
				<c:set var="nickname" value="${userInfo.nickname }" />
				<c:set var="price" value="${goods.price}" />
				<thead>
					<tr>
						<td colspan="2">상품정보</td>
						<td>수량</td>
						<td>금액</td>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td style="width: 160px; height: 160px; padding: 0;" class="order-goods-tb-img">
							<c:if test="${empty goodsImage}">
								<c:set var="imagePath" value="/resources/img/noGoods.gif" />
							</c:if>
							<c:if test="${!empty goodsImage}">
								<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImage.SAVENAME}" />
							</c:if>
							<img style="width: 150px; height: 150px;" src="<c:url value="${imagePath}" />">
						</td>
						<td align="left" style="padding-left: 30px;" class="order-goods-tb-name"><c:out value="${goods.goodsName}" /></td>
						<td class="order-goods-tb-cnt"><c:out value="1" /></td>
						<td class="order-goods-tb-price"><fmt:formatNumber var="price" value="${goods.price}" pattern="#,###" />
							<c:out value="${price}" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<hr style="margin:10px 0 10px 0; text-align:left;">
		<div align="left" class="order-info-box">
			<ul style="line-height: 170%;">
				<li><b>주문자정보</b></li>
				<li class="order-info-li"><c:out value="${userInfo.name}"/></li>
				<li class="order-info-li"><c:out value="${userInfo.phone1} - ${fn:substring(userInfo.phone2,0,4)} - ${fn:substring(userInfo.phone2,4,8)}"/></li>
			</ul>
		</div>
		<hr style="margin:10px 0 10px 0; text-align:left;">
		<div align="left" class="order-addr-box">
			
			<ul style="line-height: 170%;">
				<li><b>배송지 정보 </b><button id="addrChange" onclick="return addrChange();" >배송지변경</button></li>
				<li  class="order-addr-li"><c:out value="${userInfo.name}"/>&nbsp;
					<c:out value="${userInfo.phone1} - ${fn:substring(userInfo.phone2,0,4)} - ${fn:substring(userInfo.phone2,4,8)}"/>
				</li>
				<li class="order-addr-li">(<c:out value="${userInfo.addrNum }"/>)&nbsp;<c:out value="${userInfo.addr }"/></li>
				<li class="order-addr-li"><c:out value="${userInfo.addrSub }"/></li>
			</ul>
			<div style="height: auto;" class="order-point-box">
				<div style="display: inline-block; float: left; width: 45%;" class="order-point-box-table">
					<ul style="line-height: 170%;" class="order-point-tb">
						<li><b>포인트 정보</b></li>
						<li>
							<td>보유포인트</td>
							<td><fmt:formatNumber var="pocket" value="${point}" pattern="#,###" />
							<c:out value="${pocket}" /></td>
						</li>
						<li class="order-point-tr">
							<td>사용포인트</td><td><c:out value="${price}" /></td>
						</li>
						<li class="order-point-tr">
							<fmt:formatNumber var="resultPo" value="${resultPoint}" pattern="#,###" />
							<td>잔여포인트</td><td><c:out value="${resultPo }"/></td>
						</li>
					</ul>
				</div>
				<div style="margin:10px 0 200px 0; display: inline-block; float: left; width: 45%; margin-top: 50px;"  class="order-btn-box">
					<div class="order-btn-c"><button onclick="location.href='<c:url value="/goods/list.do" />'" >취소</button></div>
					<div class="order-btn-f">
						<form method="post" name="orderForm" action="<c:url value="/goods/order.do" />">
							<button type="submit" id="salesbtn" onclick="return orderCheck();" >주문하기</button>
							<input type="hidden" name="goodsCode"  value="${goodsCode}" />
							<input type="hidden" id="goodsName" name="goodsName"  value="${goods.goodsName}" />
							<input type="hidden" name="nickname"  value="${nickname}" />
							<input type="hidden" name="price"  value="${goods.price}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js" />"></script>
<script type="text/javascript">
	document.ready(function(){
		alert("??");
		document.getElementById("addrChange").addEventListener("click", addrChange);
		document.getElementById("salesbtn").addEventListener("click", orderCheck);
	});
</script>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>

