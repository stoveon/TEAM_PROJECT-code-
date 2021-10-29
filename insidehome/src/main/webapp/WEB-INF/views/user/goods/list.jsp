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
<table>
	<tr>
		<td colspan="4">
		상품목록 집밖은 위험해...
		</td>
		<td><select name="type" onchange="selectBoxChange(this.value);">
			<option value="dateDesc" <c:if test="${type eq 'dateDesc'}">selected="selected"</c:if>>최신순</option>
			<option value="priceDesc" <c:if test="${type eq 'priceDesc'}">selected="selected"</c:if>>높은 가격순</option>
			<option value="priceAsc" <c:if test="${type eq 'priceAsc'}">selected="selected"</c:if>>낮은 가격순</option>
			</select>
		</td>
	</tr>
	<tr>
	<c:forEach items="${goodsList}" var="goodsOne" varStatus="status">
	<c:if test="${status.index != 0 and status.index %5 == 0}">
	</tr><tr>
	</c:if>
			<td>
			<div class="goods-box">
				<div class="image-box">
						<c:if test="${goodsOne.SAVENAME == null}">
						<c:set var="imagePath" value="/resources/img/noGoods.gif" />
						</c:if>
						<c:if test="${goodsOne.SAVENAME != null}">
						<c:set var="imagePath" value="/display?goodsCode=${goodsOne.GOODSCODE}&saveName=${goodsOne.SAVENAME}" />
						</c:if>					
						<a href="<c:url value="/goods/detail.do/${goodsOne.GOODSCODE}" />"><img class="image-goods" src="<c:url value="${imagePath}" />" /></a><br>
					</div>
						<a href="<c:url value="/goods/detail.do/${goodsOne.GOODSCODE}" />"><c:out value="${goodsOne.GOODSNAME}"/></a><br>
						<c:out value="${goodsOne.PRICE += ' point'}"/>
					<div class="image-hidd">
						
					</div>
			</div>
			</td>
	</c:forEach>
	</tr>
</table>     
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>