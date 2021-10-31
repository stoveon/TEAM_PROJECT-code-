<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<link href="<c:url value="/resources/css/goodsDetail.css" />" rel="stylesheet" />
	<div class="image-preview">
	<c:choose>
		<c:when test="${empty goodsImages}">
			<c:set var="imagePath" value="/resources/img/noGoods.gif" />		
		</c:when>
		<c:otherwise>
			<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImages[0]}" />		
		</c:otherwise>
	</c:choose>
<!-- 		<c:if test="${empty goodsImages}">
			<c:set var="imagePath" value="/resources/img/noGoods.gif" />
		</c:if>
		<c:if test="${!empty goodsImages}">
			<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImages[0]}" />
		</c:if> -->
		<img class="mimg" src="<c:url value="${imagePath}" />">
	</div>
	<div class="list-box">
	<div class="list-img">
		<ul>
			<c:forEach items="${goodsImages}" var="imageOne">
				<li><img class="arimg" src="<c:url value="/display?goodsCode=${goods.goodsCode}&saveName=${imageOne}" />"></li>
			</c:forEach>
		</ul>
	</div>
	</div>
<div class="detail-box">
	<div class="info-box">
	<ul >
		<li><c:out value="${goods.goodsName}"/></li>
		<li><c:out value="${goods.price}"/></li>
		<li><c:out value="${goods.content}"/></li>
	</ul>
	</div>
	<div class="btn-box">
		<button class="order-btn" onclick="location.href='<c:url value="/goods/order.do/${goods.goodsCode}" />'">
		주문하기</button>
	</div>
</div>
</body>
</html>
<%--<%@include file="/WEB-INF/views/user/main/userFooter.jsp"--%>