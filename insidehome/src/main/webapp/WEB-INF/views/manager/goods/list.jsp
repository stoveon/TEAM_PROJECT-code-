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
<form action="/member/goods/heartGoods.do" method="post">
	<table>
		<tr>
			<td>상품관리</td>
			<td>
				<input type="button" value="상품등록" onclick="location.href='<c:url value="/manager/goods/insertGoods.do" />'" />
				<input type="button" value="상품삭제" onclick="location.href='<c:url value="/manager/goods/deleteGoods.do" />'" />
				<input type="submit" value="추천등록" />
				<input type="button" value="추천취소" onclick="location.href='<c:url value="/manager/goods/unHeartGoods.do" />'" />
			</td>
		</tr>
		<tr>
			<th></th><th>추천</th><th>상품명</th><th>등록일자</th><th>판매량</th><th>재고수량</th>
		</tr>
		<tr>
			<c:forEach items="goodsList" var="goodsOne">
				<input type="text" name="goodsCode" value="${goodsOne.goodsCode}">
				<td><input type="checkbox" name="selectHeart" /></td>
				<td>${goodsOne.heart}</td>
				<td><a href="<c:url value="/manager/goods/updateGoods.do" />">${goodsOne.goodsName}</a></td>
				<td>${goodsOne.regdate}</td>
				<td>${sales}</td>
				<td>${goodsOne.stock}</td>
			</c:forEach>
		</tr>
	</table>

</form>
</body>
</html>