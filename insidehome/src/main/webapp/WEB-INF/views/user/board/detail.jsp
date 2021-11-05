<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 글상세</h1>
	</div>
	<hr>
	<div class="info-inner">
		<!-- 신고에서 boardNum 꼭 넘겨주기! -->
		<table>
			<caption>
			<fmt:formatDate var="regdate" value="${board.regdate}" pattern="yyyy-MM-dd"/>
			<fmt:formatDate var="moddate" value="${board.moddate}" pattern="yyyy-MM-dd"/>
				<p>작성일 <c:out value="${regdate}"/> &nbsp;|&nbsp; 수정일 <c:out value="${moddate}"/>
				조회수 <c:out value="${board.hit}"/> &nbsp;|&nbsp; 추천수 <c:out value="${board.heart}"/>
				</p>
			</caption>
			<thead>
				<tr>
					<c:if test="${board.boardCode eq 'info'}" >
						<td><c:out value="${board.write}"/></td>
					</c:if>
					<td><button id="" >[수정]</button></td>
					<td><button id="" >[삭제]</button></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${board.content}</td>
				</tr>
			</tbody>
		</table>
		<div>
		<img src="<c:out value="/boDisplay" />">
		</div>
	</div>
	<div>
		<button id="" onclick="location.href=''">목록</button>
		<button id="warnbtn" >[신고]</button>
		<button id="heartbtn" >[추천]</button>
	</div>
	<div>
	<form>
	<input type="text" name="content" placeholder="댓글 입력"/><button id="refbtn" onclick="#">등록</button>
	<input type="hidden" name="" value=""/>
	</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>