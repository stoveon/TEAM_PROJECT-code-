<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<link href="<c:url value="/resources/css/goodsMain.css" />" rel="stylesheet" />
<div class="main-reg-img">
	<img class="banner" src="<c:url value="/resources/img/main_regDesc.png"/>">
</div>
<div class="main-reg">
	<table>
		<tr>
			<c:forEach items="${mainLatest}" var="latestOne" varStatus="status">
			<c:if test="${status.index != 0 and status.index %5 == 0}">
			</tr><tr>
			</c:if>
					<td>
					<a href="<c:url value="/goods/detail.do/${latestOne.GOODSCODE}" />">
						<div class="goods-box">
							<div class="image-box">
								<c:choose>
									<c:when test="${latestOne.SAVENAME == null}">
										<c:set var="imagePath" value="/resources/img/noGoods.gif" />
									</c:when>
									<c:otherwise>
										<c:set var="imagePath" value="/display?goodsCode=${latestOne.GOODSCODE}&saveName=${latestOne.SAVENAME}" />							
									</c:otherwise>
								</c:choose>			
								<img class="image-goods" src="<c:url value="${imagePath}" />" /><br>
								</div>
								<div class="goods-txt">
									<c:out value="${latestOne.GOODSNAME}"/><br>
									<fmt:formatNumber var="price" value="${latestOne.PRICE}" pattern="#,###" />
									<c:out value="${price += ' point'}"/>
								</div>
								<div class="image-hidd">
									
								</div>
						</div>
					</a>
					</td>
			</c:forEach>
			</tr>
		</table>
</div>
<div class="main-heart-img">
	<img class="banner" src="<c:url value="/resources/img/main_heart.png"/>">
</div>
<div class="main-heart">
		<table>
		<tr>
			<c:forEach items="${mainHeart}" var="heartOne" varStatus="status">
			<c:if test="${status.index != 0 and status.index %5 == 0}">
			</tr><tr>
			</c:if>
					<td>
					<a href="<c:url value="/goods/detail.do/${heartOne.GOODSCODE}" />">
						<div class="goods-box">
							<div class="image-box">
								<c:choose>
									<c:when test="${heartOne.SAVENAME == null}">
										<c:set var="imagePath" value="/resources/img/noGoods.gif" />
									</c:when>
									<c:otherwise>
										<c:set var="imagePath" value="/display?goodsCode=${heartOne.GOODSCODE}&saveName=${heartOne.SAVENAME}" />							
									</c:otherwise>
								</c:choose>			
								<img class="image-goods" src="<c:url value="${imagePath}" />" /><br>
								</div>
								<div class="goods-txt">
									<c:out value="${heartOne.GOODSNAME}"/><br>
									<fmt:formatNumber var="price" value="${heartOne.PRICE}" pattern="#,###" />
									<c:out value="${price += ' point'}"/>
								</div>
								<div class="image-hidd">
									
								</div>
						</div>
					</a>
					</td>
			</c:forEach>
			</tr>
		</table>
</div>


</body>
</html>