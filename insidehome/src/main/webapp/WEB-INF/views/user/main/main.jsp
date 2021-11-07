<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
   <div class="goods-title2">
   		추천상품
   	  <p class="goods-title2">이런 상품은 어때요?</p>
   </div>
   <hr>
   <div class="info-inner">
		<table>
		<tr>
			<c:forEach items="${mainHeart}" var="heartOne" varStatus="status">
			<c:if test="${status.index != 0 and status.index %5 == 0}">
				<tr></tr>
			</c:if>
			<c:if test="${status.index != 0 and status.index %5 != 0}">
					<td class="goods-box">
						<a href="<c:url value="/goods/detail.do/${heartOne.GOODSCODE}" />">
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
									<b><c:out value="${heartOne.GOODSNAME}"/></b><br>
									<fmt:formatNumber var="price" value="${heartOne.PRICE}" pattern="#,###" />
									<c:out value="${price += ' point'}"/>
								</div>
						</a>
					</td>
			</c:if>
			</c:forEach>
			</tr>
		</table>
	</div>
   <div class="info-detail">
	   <div class="goods-title">
	   		최신상품
    	  <p class="goods-title">새로 등록된 상품입니다 :)</p>
	   </div>
   </div>
   <hr>
   <div class="info-inner">
	<table>
		<tr>
			<c:forEach items="${mainLatest}" var="latestOne" varStatus="status">
			<c:if test="${status.index != 0 and status.index %5 == 0}">
				<tr></tr>
			</c:if>
			<c:if test="${status.index != 0 and status.index %5 != 0}">
					<td class="goods-box">
					<a href="<c:url value="/goods/detail.do/${latestOne.GOODSCODE}" />" title="<c:out value="${lastestOne.GOODSNAME}"/>">
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
								<c:choose>
									<c:when test="${fn:length(latestOne.GOODSNAME) > 12}">
										<c:set var="gname" value="${fn:substring(latestOne.GOODSNAME,0,12)}..."/>
									</c:when>
									<c:otherwise>
										<c:set var="gname" value="${latestOne.GOODSNAME}"/>
									</c:otherwise>
								</c:choose>
								<b><c:out value="${gname }"/></b><br>
								<fmt:formatNumber var="price" value="${latestOne.PRICE}" pattern="#,###" />
								<c:out value="${price += ' point'}"/>
							</div>
					</a>
					</td>
			</c:if>
			</c:forEach>
			</tr>
		</table>
	</div>
</div>

	
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>