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
<link href="<c:url value="/resources/css/goodsDetail.css" />" rel="stylesheet" />

<div class="detailbox">
	<div class="image-box">
		<c:if test="${empty goodsImages}">
			<c:set var="imagePath" value="/resources/img/noGoods.gif" />
		</c:if>
		<c:if test="${!empty goodsImages}">
			<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImages[0]}" />
		</c:if>
		<img src="<c:url value="${imagePath}" />">
	</div>
	<div class="list-box">
	<div class="list-img">
		<c:forEach items="${goodsImages}" var="imageOne">
		<img src="<c:url value="/display?goodsCode=${goods.goodsCode}&saveName=${imageOne}" />">
		</c:forEach>
	</div>
	</div>
</div>
<div class="detailbox">
	<div class="info-box">
	<ul >
		<li>${goods.goodsName}</li>
		<li>${goods.price}</li>
		<li>${goods.content}</li>
	</ul>
	</div>
	<div class="btn-box">
		<button class="order-btn" onclick="location.href='<c:url value="/goods/order.do/${goods.goodsCode}" />'">
		주문하기</button>
	</div>
</div>
</body>
</html>