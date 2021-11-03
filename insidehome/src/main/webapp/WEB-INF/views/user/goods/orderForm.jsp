<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<link href="<c:url value="/resources/css/goodsDetail.css" />" rel="stylesheet" />
	<span class="order-title">주문/결제</span>
<hr style="margin:10px 0 10px 0; text-align:left; width: 90%;">
	<div class="order-goods-box">
		<table class="order-goods-tb">
		<c:set var="goodsCode" value="${goods.goodsCode}" />
		<c:set var="nickname" value="#닉네임#" />
		<c:set var="price" value="${goods.price}" />
			<thead>
				<tr>
					<td colspan="2">상품정보</td>
					<td>수량</td>
					<td>금액</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="order-goods-tb-img"><c:if test="${empty goodsImage}">
							<c:set var="imagePath" value="/resources/img/noGoods.gif" />
						</c:if>
						<c:if test="${!empty goodsImage}">
							<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImage.SAVENAME}" />
						</c:if>
						<img src="<c:url value="${imagePath}" />">
					</td>
					<td class="order-goods-tb-name"><c:out value="${goods.goodsName}" /></td>
					<td class="order-goods-tb-cnt"><c:out value="1" /></td>
					<td class="order-goods-tb-price"><fmt:formatNumber var="price" value="${goods.price}" pattern="#,###" />
					<c:out value="${price}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
<hr style="margin:10px 0 10px 0; text-align:left; width: 90%;">
	<div class="order-info-box">
		<span class="order-sub-title">주문자정보</span>
		<ul>
			<li class="order-info-li"><c:out value="이름"/></li>
			<li class="order-info-li"><c:out value="전화번호"/></li>
			<li class="order-info-li"><c:out value="이메일"/></li>
		</ul>
	</div>
<hr style="margin:10px 0 10px 0; text-align:left; width: 90%;">
	<div class="order-addr-box">
		<span class="order-sub-title">배송지 정보</span>&nbsp;
		<button id="addrChange" onclick="addrChange();" >배송지변경</button>
		<ul>
			<li  class="order-addr-li"><c:out value="이름"/>&nbsp;<c:out value="전화번호"/></li>
			<li class="order-addr-li">(<c:out value="우편번호"/>)&nbsp;<c:out value="주소"/></li>
			<li class="order-addr-li"><c:out value="상세주소"/></li>
		</ul>
	</div>
<hr style="margin:10px 0 10px 0; text-align:left; width: 90%;">
<div class="order-point-btn-box">
	<div class="order-point-box">
		<div class="order-point-box-title">
			<span class="order-sub-title">포인트정보</span>
		</div>
		<div class="order-point-box-table">
			<table class="order-point-tb">
				<tr>
				<c:set var="remaindPoint" value="${10000+goods.price-goods.price}" />
					<td>보유포인트</td>
					<td><fmt:formatNumber var="pocket" value="${goods.price}" pattern="#,###" />
					<c:out value="${pocket}" /></td>
				</tr>
				<tr class="order-point-tr">
					<td>사용포인트</td><td><c:out value="${price}" /></td>
				</tr>
				<tr class="order-point-tr">
					<td>잔여포인트</td><td><c:out value="${remaindPoint}" /></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="order-btn-box">
		<div class="order-btn-c"><button onclick="location.href='<c:url value="/goods/list.do" />'" >취소</button></div>
		<div class="order-btn-f">
			<form method="post" name="orderForm" action="<c:url value="/goods/order.do" />">
			<button type="submit" id="salesbtn" onclick="return orderCheck();" >주문하기</button>
			<input type="hidden" name="goodsCode"  value="${goods.goodsCode}" />
			<input type="hidden" id="goodsName" name="goodsName"  value="${goods.goodsName}" />
			<input type="hidden" name="nickname"  value="eun_inside" />
			<input type="hidden" name="price"  value="${goods.price}" />
			</form>
		</div>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js" />"></script>
<script type="text/javascript">
	document.getElementById("addrChange").onclick = function(){addrChange()};
	document.getElementById("salesbtn").onclick = function(){orderCheck()};
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>