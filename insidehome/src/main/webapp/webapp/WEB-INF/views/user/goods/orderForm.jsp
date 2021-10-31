<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<style type="text/css">
.goods-tb{
	border-collapse: collapse;
	text-align: center;
}
.goods-tb tr, .goods-tb td{
	border: 1px solid black;
}
</style>
<script type="text/javascript">
function orderCheck(){
	if(confirm("상품을  주문하시겠습니까?") == true){
		document.orderForm.action='<c:url value="/goods/order.do" />'
	}else{
		return false;
	}
}
</script>
	<h1>주문/결제</h1>
<hr>
	<div class="goods-box">
		<table class="goods-tb">
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
					<td><c:if test="${empty goodsImage}">
							<c:set var="imagePath" value="/resources/img/noGoods.gif" />
						</c:if>
						<c:if test="${!empty goodsImage}">
							<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImage.SAVENAME}" />
						</c:if>
						<img src="<c:url value="${imagePath}" />">
					</td>
					<td><c:out value="${goods.goodsName}" /></td>
					<td><c:out value="1" /></td>
					<td><fmt:formatNumber var="price" value="${goods.price}" pattern="#,###" />
					<c:out value="${price}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
<hr>
	<div class="info-box">
		<h3>주문자정보</h3>
		<ul>
			<li id="#">이름</li>
			<li id="#">전화번호</li>
			<li id="#">이메일</li>
		</ul>
	</div>
<hr>
	<div class="addr-box">
		<h3>배송지 정보</h3>
		<button onclick="location.href=<c:url value="#"/>" >배송지  수정</button>
		<ul>
			<li id="#">이름&nbsp;전화번호</li>
			<li id="#">(우편번호)&nbsp;주소&nbsp;상세주소</li>
		</ul>
	</div>
<hr>
	<div class="point-box">
		<h3>포인트정보</h3>
		<table class="point-tb">
			<tr>
			<c:set var="remaindPoint" value="${10000+goods.price-goods.price}" />
				<td>보유포인트</td>
				<td><fmt:formatNumber var="pocket" value="${goods.price}" pattern="#,###" />
				<c:out value="${pocket}" /></td>
			</tr>
			<tr style="border-bottom: black;">
				<td>사용포인트</td><td><c:out value="${price}" /></td>
			</tr>
			<tr>

				<td>잔여포인트</td><td><c:out value="${remaindPoint}" /></td>
			</tr>
		</table>
	</div>
	<div class="btn-box">
		<button onclick="location.href='<c:url value="/goods/list.do" />'" >취소</button><br>
		<form method="post" name="orderForm">
		<button type="submit" onclick="orderCheck();" >주문하기</button>
		<input type="hidden" name="goodsCode"  value="${goods.goodsCode}" />
		<input type="hidden" name="nickname"  value="eun_inside" />
		<input type="hidden" name="price"  value="${goods.price}" />
		</form>
	</div>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>