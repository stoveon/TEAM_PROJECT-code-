<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>

<div class="bodyinfo">
	<div class="info-detail">
		<h1 class="info-title">주문관리</h1>
	</div>
	<hr>
	<div class="info-inner">
	<form name="orderForm" method="post">
		<table>
			<thead>
			<tr>
				<td class="table-inner">주문일자</td>
				<td class="table-inner">상품명</td>
				<td class="table-inner">사용포인트</td>
				<td class="table-inner">닉네임</td>
				<td class="table-inner">발송여부</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${orderList}" var="orderOne">
				<tr style="text-align: center;">
					<fmt:formatDate value="${orderOne.ORDERDATE}" pattern="yyyy-MM-dd"
						var="orderDate" />
					<td>${orderDate}</td>
					<td>${orderOne.GOODSNAME}</td>
					<fmt:formatNumber value="${orderOne.SALES}" pattern="#,###"
						var="sales" />
					<td>${sales}</td>
					<td>${orderOne.NICKNAME}</td>
					<td style="text-align: center; height: 20px;">
						<c:choose>
							<c:when test="${orderOne.SENDSTATE eq 'YET'}">
								<button class="fit-size" type="submit" onclick="form.action= '<c:url value="/manager/main/order.do?state=ING&goodsCode=${orderOne.GOODSCODE}" />'">발송</button>
							</c:when>
							<c:when test="${orderOne.SENDSTATE eq 'ING'}">
								<button class="fit-size" id="salesReturn" type="submit" onclick="sendChk();">발송취소</button>
							</c:when>
							<c:when test="${orderOne.SENDSTATE eq 'END'}">
								<c:out value="배송완료" />
							</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</form>
	</div>
</div>


<script>
window.onload = function(){
	document.getElementById("salesReturn").onclick=function sendChk(){
		if(confirm("발송을  취소하시겠습니까?") == true){
			return form.action='<c:url value="/manager/main/order.do?state=YET&goodsCode=${orderOne.GOODSCODE}" />';
	}
}
</script>


<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>