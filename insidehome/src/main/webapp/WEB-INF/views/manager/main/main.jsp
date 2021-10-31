<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<script>
	function sendChk(){
		if(confirm("발송을  취소하시겠습니까?") == true){
			return form.action='<c:url value="/manager/main/order.do?state=YET&goodsCode=${orderOne.GOODSCODE}" />';
		}else if(confirm("발송이 완료 되었습니까?")){
			return form.action='<c:url value="/manager/main/order.do?state=END&goodsCode=${orderOne.GOODSCODE}" />';
		}else{
			return false;
		}
</script>
<h3>주문관리</h3>
<form>
<table>
	<tr>
		<td>주문일자</td><td>상품명</td><td>사용포인트</td><td>닉네임</td><td>발송여부</td>
	</tr>
	<c:forEach items="${orderList}" var="orderOne">
	<tr>
		<fmt:formatDate value="${orderOne.ORDERDATE}" pattern="yyyy-MM-dd" var="orderDate"/>
		<td>${orderDate}</td>
		<td><a href="<c:url value="/goods/detail.do/${orderOne.GOODSCODE}" />">${orderOne.GOODSNAME}</a></td>
		<fmt:formatNumber value="${orderOne.SALES}" pattern="#,###" var="sales"/>
		<td>${sales}</td>
		<td><a href="#">${orderOne.NICKNAME}</a></td>
		<c:choose>
			<c:when test="${orderOne.SENDSTATE eq 'YET'}">
				<td><button type="submit" onclick="form.action='<c:url value="/manager/main/order.do?state=ING&goodsCode=${orderOne.GOODSCODE}" />'">발송</button></td>
			</c:when>
			<c:when test="${orderOne.SENDSTATE eq 'ING'}">
				<td><button type="submit" onclick="form.action='<c:url value="/manager/main/order.do?state=YET" />'">발송취소</button></td>
			</c:when>		
			<c:when test="${orderOne.SENDSTATE eq 'END'}">
				<td><c:out value="배송완료" /></td>
			</c:when>
		</c:choose>
<%-- 		<c:if test="${orderOne.SENDSTATE eq 'YET'}">
			<td><button type="submit" onclick="form.action='<c:url value="/manager/main/order.do?state=ING&goodsCode=${orderOne.GOODSCODE}" />'">발송</button></td>
		</c:if>
		<c:if test="${orderOne.SENDSTATE eq 'ING'}">
			<td><button type="submit" onclick="form.action='<c:url value="/manager/main/order.do?state=YET" />'">발송취소</button></td>
		</c:if>
		<c:if test="${orderOne.SENDSTATE eq 'END'}">
			<td><c:out value="배송완료" /></td>
		</c:if> --%>
	</tr>
	</c:forEach>
</table>
</form>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>