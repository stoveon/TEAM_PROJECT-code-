<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var selectBoxChange = function(value){
	var type = value;
	window.location.href="<%=request.getContextPath()%>/goods/list.do?type=" + type;
}

</script>
</head>
<body>
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
				<div id="goodsImageResult">
					<img src="/display?goodsCode=${goodsOne.GOODSCODE}&saveName=${goodsOne.SAVENAME}"><br>
					<c:out value="${goodsOne.GOODSNAME}"/><br>
					<c:out value="${goodsOne.PRICE += ' point'}"/>
					<input type="hidden" name="goodsCode" value="${goodsOne.GOODSCODE}" />
				</div>
			</td>
	</c:forEach>
	</tr>
</table>

</body>
</html>