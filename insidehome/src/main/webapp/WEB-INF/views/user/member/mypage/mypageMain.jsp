<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>


<div class="bodyinfo">
	<div class="info-detail">
		<a class="info-title" href="<c:url value="/user/mypage/info/view.do" />">내 정보 관리
			<img class="explain" title="개인정보 확인" src="<c:url value="/resources/img/icon-infoEdit.png"/>">
		</a>
	</div>				
	<hr>
	<div class="info-detail">
		<table class="mypage-title">
			<thead class="mypage-title">
				<tr>
					<td class="mypage-title"><b>내 글</b></td>
					<td class="mypage-title"><b>내 포인트</b></td>
					<td class="mypage-title"><b>내 주문내역</b></td>
					<td class="mypage-title"><b>내 문의 수</b></td>
					<td class="mypage-title"><b>신고횟수</b>
						<img class="explain" title="신고 5회 접수 시 블랙리스트로 등록되며,&#10;홈페이지 이용이 제한됩니다." src="<c:url value="/resources/img/icon-explain.png"/>">
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="mypage-title-sub"><a class="mypage-title-sub" href="main.do?viewPage=board">${fn:length(articleList)}</a></td>
					<td class="mypage-title-sub"><a class="mypage-title-sub" href="main.do?viewPage=point">${infoCount.POINT }</a></td>
					<td class="mypage-title-sub"><a class="mypage-title-sub" href="main.do?viewPage=order">${orderCount}</a></td>
					<td class="mypage-title-sub"><a class="mypage-title-sub" href="#">${qaCount }</a></td>
					<td class="mypage-title-sub2">${infoCount.WARNCOUNT }</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br><hr ><br>
	<div style="padding-left: 10%; width: 80%;">
		<c:if test="${viewPage eq 'board'}">
			<div class="info-detail">
				<h2 class="info-title">작성 글</h2>
				<form action="main.do?viewPage=board" class="info-search">
					<input class="searchText"  type="text" name="str" placeholder="제목 검색" value="${str}">
					<input type="submit" value="검색">
				</form>
			</div>
			<div class="info-detail">
				<table>
					<tbody>
					<c:if test="${fn:length(articleList) == 0}">
						<tr>
							<td colspan="3" class="sub-none-info">요청 게시글이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:if test="${fn:length(articleList) == 0}">
						<c:forEach items="${articleList}" var="article">
							<tr>
								<td class="sub-date"><fmt:formatDate value="${article.REGDATE}" pattern="yyyy-MM-dd" /></td>
								<td class="sub-type">
									<c:if test="${arcicle.BOARDCODE eq 'info'}">[정보]</c:if>
									<c:if test="${arcicle.BOARDCODE eq 'who'}">[익명]</c:if>
								</td>
								<td class="sub-detail"><a href="/user/board/read.do/${article.NUM} ">${article.TITLE}</a></td>
							</tr>
						</c:forEach>
					</c:if>
					</tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${viewPage eq 'point'}">
			<div class="info-detail">
				<h2 class="info-title">포인트 적립 및 사용 내역</h2>
				<p class="info-title-sub">포인트 변동 내역은 최근 30일간의 내용만 표시됩니다.</p>
			</div>
			<div class="info-detail">
				<table>
					<tbody>
					<c:if test="${fn:length(pointList) == 0}">
						<tr>
							<td colspan="3" class="sub-none-info">최근 30일 간 포인트 변동 내역이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:if test="${fn:length(pointList) != 0}">
						<c:forEach items="${pointList}" var="po">
							<tr>
								<td class="sub-date"><fmt:formatDate value="${po.CHANGEDATE}" pattern="yyyy-MM-dd" /></td>
								<td class="sub-type">
									<c:choose>
										<c:when test="${po.CHANGEWHY eq 'check'}">[출석]</c:when>
										<c:when test="${po.CHANGEWHY eq 'write'}">[글작성]</c:when>
										<c:otherwise>[상품구매] ${po.CHANGEWHY }</c:otherwise>
									</c:choose>
								</td>
								<td class="sub-detail">${po.CHANGEPOINT }</td>
							</tr>
						</c:forEach>
					</c:if>
					</tbody>
				</table>
			</div>
		</c:if>
		<c:if test="${viewPage eq 'order'}">
			<div class="info-detail">
				<h2 class="info-title">주문내역</h2>
				<p class="info-title-sub">내가 주문한 모든 내역을 확인할 수 있습니다.</p>
			</div>
			<div class="info-detail">
				<table>
					<tbody>
					<c:if test="${fn:length(orderList) == 0}">
						<tr>
							<td colspan="3" class="sub-none-info">주문내역이 존재하지 않습니다.</td>
						</tr>
					</c:if>
					<c:if test="${fn:length(orderList) != 0}">
						<c:forEach items="${orderList}" var="order">
							<tr>
								<td class="sub-date"><fmt:formatDate value="${order.ORDERDATE}" pattern="yyyy-MM-dd" /></td>
								<td class="sub-type">
									<c:if test="${order.SENDSTATE eq 'YET'}">[발송 전]</c:if>
									<c:if test="${order.SENDSTATE eq 'END'}">[배송완료]</c:if>
									<c:if test="${order.SENDSTATE eq 'ING'}">[배송중]</c:if>
									 ${order.GOODSNAME }
								</td>
								<td class="sub-detail">
									${order.PRICE}
								</td>
							</tr>
						</c:forEach>
					</c:if>
					</tbody>
				</table>
			</div>	
		</c:if>
	</div>
</div>


<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>
