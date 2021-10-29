<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<table>
	<c:set var="goodsCode" value="${goods.goodsCode}" />
	<c:set var="nickname" value="#닉네임#" />
	<c:set var="sales" value="${goods.price}" />
		<tr>
			<td colspan="2">상품정보</td>
			<td>수량</td>
			<td>금액</td>
		</tr>
		<tr>
			<td><c:if test="${empty goodsImage}">
					<c:set var="imagePath" value="/resources/img/noGoods.gif" />
				</c:if>
				<c:if test="${!empty goodsImage}">
					<c:set var="imagePath" value="/display?goodsCode=${goodsImage.goodsCode}&saveName=${goodsImage.SAVENAME}" />
				</c:if>
				<img src="<c:url value="${imagePath}" />">
			</td>
			<td>${goods.goodsName}</td>
			<td>1</td>
			<td>${goods.price}</td>
		</tr>
	</table>

</div>
	<hr>
<div>
	주문자정보
	<ul>
		<li id="#">이름</li>
		<li id="#">전화번호</li>
		<li id="#">이메일</li>
	</ul>
</div>
	<hr>
<div>
	배송지 정보
	<button onclick="#" value="배송지  수정"></button>
	<ul>
		<li id="#">이름&nbsp;전화번호</li>
		<li id="#">(우편번호)&nbsp;주소&nbsp;상세주소</li>
	</ul>
</div>
	<hr>
<div>
	포인트정보
	<table>
		<tr>
			<td>보유포인트</td><td>##,###</td>
		</tr>
		<tr>
			<td>사용포인트</td><td></td>
		</tr>
		<tr>
		<c:set var="remaindPoint" value="남은 포인트 나온당" />
			<td>잔여포인트</td><td><c:out value="${remaindPoint}" /></td>
		</tr>
	</table>
</div>
<div>
	<button onclick="location.href='<c:url value="/goods/list.do" />'" >취소</button><br>
	<form:form method="post" commandName="goodsSalesVo">
	<button type="submit" onclick="location.href='<c:url value="/goods/order.do" />'" >주문하기</button>
	<form:hidden path="goodsCode" />
	<form:hidden path="nickname" />
	<form:hidden path="sales" />
	</form:form>
</div>
</body>
</html>