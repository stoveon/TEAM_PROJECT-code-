<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form" method="post">
	<table>
		<tr>
			<td>상품관리</td>
			<td>
				<input type="button" value="상품등록" onclick="location.href='<c:url value="/manager/goods/insertGoods.do" />'" />
				<input type="submit" value="상품삭제" onclick="form.action= '<c:url value="/manager/goods/deleteGoods.do" />'" />
				<input type="submit" value="추천등록" onclick="form.action= '<c:url value="/manager/goods/heartUpdate.do?type=recommand" />'" />
				<input type="submit" value="추천취소" onclick="form.action= '<c:url value="/manager/goods/heartUpdate.do?type=cancle" />'" />
			</td>
		</tr>
		<tr>
			<th></th><th>추천</th><th>상품명</th><th>등록일자</th><th>판매량</th><th>재고수량</th>
		</tr>
		<c:forEach items="${goodsList}" var="goodsOne" >
			<tr>
				<td><input type="checkbox" name="selectGoods" value="${goodsOne.GOODSCODE}"/></td>
				<td>
					<c:if test="${goodsOne.HEART eq 'yes'}">
						<c:set var="heart" value="SELECT" />
					</c:if>
					<c:if test="${goodsOne.HEART eq 'no'}">
						<c:set var="heart" value="" />
					</c:if>
					<c:out value="${heart}" />
				</td>
				<td><a href="<c:url value="/manager/goods/updateGoods.do/${goodsOne.GOODSCODE}" />">
				<c:out value="${goodsOne.GOODSNAME}"/></a></td>
				<td>
				<c:out value="${goodsOne.REGDATE}"/></td>
				<td><c:out value="${goodsOne.TOTALCNT}"/></td>
				<td><c:out value="${goodsOne.STOCK}"/></td>
			</tr>
			</c:forEach>
	</table>
</form>
</body>
</html>