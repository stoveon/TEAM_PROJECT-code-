<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<table>
		<tr>
			<td colspan="2">상품정보</td>
			<td>수량</td>
			<td>금액</td>
		</tr>
		<tr>
			<td>이미지가 들어가여</td>
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
		<li id="#">${member.name}</li>
		<li id="#">${member.phone}</li>
		<li id="#">${member.email}</li>
	</ul>
</div>
	<hr>
<div>
	배송지 정보
	<button onclick="#" value="배송지  수정"></button>
	<ul>
		<li id="#">${member.name}&nbsp;${mamber.phone}</li>
		<li id="#">(${member.addrNum})&nbsp;${member.addr}&nbsp;${member.addrSub}</li>
	</ul>
</div>
	<hr>
<div>
	포인트정보
	<table>
		<tr>
			<td>보유포인트</td><td>member.point</td>
		</tr>
		<tr>
			<td>사용포인트</td><td></td>
		</tr>
		<tr>
		<c:set var="remaindPoint" value="${member.point-goods.price}" />
			<td>잔여포인트</td><td><c:out value="${remaindPoint}" /></td>
		</tr>
	</table>
</div>
<div>
	<button onclick="<c:url value="/goods/list.do" />" value="취소"></button><br>
	<button onclick="<c:url value="/goods/orgerForm.do" />" value="주문하기"></button>
</div>
</body>
</html>