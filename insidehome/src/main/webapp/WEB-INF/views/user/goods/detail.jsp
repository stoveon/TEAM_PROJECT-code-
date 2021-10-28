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
<div class="image">
	<c:if test="${empty goodsImages}">
		<c:set var="imagePath" value="/resources/img/noGoods.gif" />
	</c:if>
	<c:if test="${!empty goodsImages}">
		<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${imageOne}" />
	</c:if>
	<c:forEach items="${goodsImages}" var="imageOne">
	<img src="<c:url value="${imagePath}" />">
	</c:forEach>
</div>
<div>
	<ul >
		<li>${goods.goodsName}</li>
		<li>${goods.price}</li>
		<li>${goods.content}</li>
	</ul><br>
	<button onclick="<c:url value="/goods/orderForm.do" />"></button>
</div>
</body>
</html>