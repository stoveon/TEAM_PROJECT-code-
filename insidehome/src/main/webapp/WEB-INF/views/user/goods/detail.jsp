<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<link href="<c:url value="/resources/css/goodsDetail.css" />" rel="stylesheet" />
<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js" />"></script>
<div class="detail-img-box">
	<div class="detail-main-img">
	<c:choose>
		<c:when test="${empty goodsImages}">
			<c:set var="imagePath" value="/resources/img/noGoods.gif" />		
		</c:when>
		<c:otherwise>
			<c:set var="imagePath" value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImages[0]}" />		
		</c:otherwise>
	</c:choose>
		<img id="mimg" src="<c:url value="${imagePath}" />">
	</div>
	
	<c:if test="${fn:length(goodsImages) > 1}">
		<div class="detail-list-img">
			<c:forEach items="${goodsImages}" var="imageOne">
				<div class="detail-list-img-li">
					<a href="javascript:changeMainIma();"><img class="arimg" src="<c:url value="/display?goodsCode=${goods.goodsCode}&saveName=${imageOne}" />"></a>
				</div>
			</c:forEach>
		</div>
	</c:if>
</div>
<div class="detail-box">
	<div class="detail-info-box">
		<p class="detail-goodsname"><b><c:out value="${goods.goodsName}"/></b></p><br>
			<fmt:formatNumber var="price" value="${goods.price}" pattern="#,###" />
		<p class="detail-goodsprice"><c:out value="${price}"/></p><br>
		<p class="detail-goodscontent"><c:out value="${goods.content}"/></p><br>
	</div>
	<div class="detail-btn-box">
		<button class="order-btn" onclick="location.href='<c:url value="/goods/order.do/${goods.goodsCode}" />'">
		<img class="banner" src="<c:url value="/resources/img/goods-get-btn.png"/>"></button>
	</div>
</div>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>