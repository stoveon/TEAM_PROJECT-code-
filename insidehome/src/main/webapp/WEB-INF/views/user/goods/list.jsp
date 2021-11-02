<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<script type="text/javascript">
var selectBoxChange = function(value){
	var type = value;
	window.location.href="<%=request.getContextPath()%>/goods/list.do?type=" + type;
}

</script>
<link href="<c:url value="/resources/css/goodsMain.css" />" rel="stylesheet" />
<div>
	<img class="banner" src="<c:url value="/resources/img/goods-list.png"/>">
</div>
<div>
	<select name="type" onchange="selectBoxChange(this.value);">
		<option value="dateDesc" <c:if test="${type eq 'dateDesc'}">selected="selected"</c:if>>최신순</option>
		<option value="priceDesc" <c:if test="${type eq 'priceDesc'}">selected="selected"</c:if>>높은 가격순</option>
		<option value="priceAsc" <c:if test="${type eq 'priceAsc'}">selected="selected"</c:if>>낮은 가격순</option>
	</select>
</div>
<table>
	<tbody>
		<tr>
		<c:forEach items="${goodsList}" var="goodsOne" varStatus="status">
		<c:set var="name" value=""/>
		<c:if test="${status.index != 0 and status.index %5 == 0}">
		</tr><tr>
		</c:if>
				<td>
				<a href="<c:url value="/goods/detail.do/${goodsOne.GOODSCODE}" />">
					<div class="goods-box" title="${goodsOne.goodsName}">
						<div class="image-box">
							<c:choose>
								<c:when test="${goodsOne.SAVENAME == null}">
									<c:set var="imagePath" value="/resources/img/noGoods.gif" />
								</c:when>
								<c:otherwise>
									<c:set var="imagePath" value="/display?goodsCode=${goodsOne.GOODSCODE}&saveName=${goodsOne.SAVENAME}" />							
								</c:otherwise>
							</c:choose>			
							<img class="image-goods" src="<c:url value="${imagePath}" />" alt="<c:out value="${goodsOne.GOODSNAME}" />"/><br>
							</div>
							<div class="goods-txt">
								<b><c:out value="${goodsOne.GOODSNAME}"/></b>
								<fmt:formatNumber var="price" value="${goodsOne.PRICE}" pattern="#,###" />
								<c:out value="${price += ' point'}"/>
							</div>
					</div>
				</a>
				</td>
		</c:forEach>
		</tr>
	</tbody>
</table>     
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>