<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<script type="text/javascript"
	src="<c:url value="/resources/js/goodsjs.js" />"></script>

<div class="body-info">
	<hr>
	<div class="info-detail" >
		<div class="detail-img-box">
			<div class="detail-main-img">
				<c:choose>
					<c:when test="${empty goodsImages}">
						<c:set var="imagePath" value="/resources/img/noGoods.gif" />
					</c:when>
					<c:otherwise>
						<c:set var="imagePath"
							value="/display?goodsCode=${goods.goodsCode}&saveName=${goodsImages[0]}" />
					</c:otherwise>
				</c:choose>
				<img id="mimg" src="<c:url value="${imagePath}" />">
			</div>

			<c:if test="${fn:length(goodsImages) > 1}">
				<div class="detail-list-img">
					<c:forEach items="${goodsImages}" var="imageOne">
						<div class="detail-list-img-li">
							<a href="javascript:changeMainIma();"><img class="arimg"
								src="<c:url value="/display?goodsCode=${goods.goodsCode}&saveName=${imageOne}" />"></a>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
		<div class="detail-box">
			<div class="detail-info-box">
				<p class="detail-goodsname">
					<b style="font-size: 25px;"><c:out value="${goods.goodsName}" /></b>
					<c:if test="${goods.stock == 0 }">
						<b style="color: red;"> &nbsp;&nbsp;&nbsp; 품절</b>
					</c:if>
				</p>
				<br>
				<fmt:formatNumber var="price" value="${goods.price}" pattern="#,###" />
				<p class="detail-goodsprice" >
					<c:out value="${price} point" />
				</p>
				<br>
				<p class="detail-goodscontent">
					<c:out value="${goods.content}" />
				</p>
				<br>
			</div>
			<c:if test="${goods.stock >0}">
				<div class="detail-btn-box">
					<button class="order-btn" style="width: 95%;"
						onclick="location.href='<c:url value="/user/goods/order.do/${goods.goodsCode}" />'">구매하기</button>
				</div>
			</c:if>
			
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>