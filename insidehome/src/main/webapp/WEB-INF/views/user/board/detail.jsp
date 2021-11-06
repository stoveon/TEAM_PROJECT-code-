<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 글상세</h1>
	</div>
	<hr>
	<div class="info-inner">
		<div>
			<c:choose>
				<c:when test="${board.boardCode eq 'info'}">
				[ 정보 게시판 ]&nbsp;
				</c:when>
				<c:when test="${board.boardCode eq 'who'}">
				[ 익명 게시판 ]&nbsp;
				</c:when>
			</c:choose>
			&nbsp;${board.title}
		</div>
		<table>
			<caption>
				<fmt:formatDate var="regdate" value="${board.regdate}" pattern="yyyy-MM-dd"/>
				<fmt:formatDate var="moddate" value="${board.moddate}" pattern="yyyy-MM-dd"/>
				작성일 <c:out value="${regdate}"/> <c:if test="${board.moddate != null}" >&nbsp;|&nbsp; 수정일 <c:out value="${moddate}"/></c:if><br>
				조회수 <c:out value="${board.hit}"/> &nbsp;|&nbsp; 추천수 <c:out value="${board.heart}"/>
			</caption>
			<thead>
				테이블 머리입니당
				<tr>
					<c:choose>
						<c:when test="${board.boardCode eq 'info'}">
						<td><c:out value="${board.writer}"/></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
<%-- 					<c:if test="${sessionScope.loginInside eq board.writer}" > --%>
					<td><button id="boardedit" value="${board.num}" >[수정]</button></td>
					<td><button id="boarddel" value="${board.num}" >[삭제]</button></td>
<%-- 					</c:if> --%>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="3">${board.content}</td>
				</tr>
				<tr>
					<c:if test="${fn:length(boardImages) == null}">
					<c:choose>
						<c:when test="${empty boardImages}">
							<c:set var="imagePath" value="/resources/img/noGoods.gif" />		
						</c:when>
					</c:choose>
						<td colspan="3"><img id="bnimg" src="<c:url value="${imagePath}" />"></td>
					</c:if>
					
					<c:if test="${fn:length(boardImages) > 0}">
						<c:forEach items="${boardImages}" var="imageOne" varStatus="status">
						<c:if test="${status.index != 0 and status.index %3 == 0}" >
						<tr></tr>
						</c:if>
							<td><img class="byimg" src="<c:url value="/boardDis?saveName=${imageOne.saveName}" />"></td>
						</c:forEach>
					</c:if>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<c:choose>
			<c:when test="${board.boardCode eq 'info'}">
			<c:set var="boardList" value="/board/list.do?boardCode=info" />
			</c:when>
			<c:when test="${board.boardCode eq 'who'}">
			<c:set var="boardList" value="/board/list.do?boardCode=who" />
			</c:when>
		</c:choose>
		<button onclick="location.href='<c:url value="${boardList}" />'">목록</button>
		<c:if test="${sessionScope.loginInside ne board.writer}" >
			<button id="warnbtn" value="${board.num}">[신고]</button>
			<button id="heartbtn" value="${board.num}">[추천]</button>
		</c:if>
	</div>
	<hr>
	<div>
	<form name="refForm">
	<input type="text" name="content" placeholder="댓글 입력"/> <button id="refbtn">등록</button>
	<input type="hidden" name="" value="${board.num}"/>
	</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/boardscript.js" />"></script>
<script type="text/javascript">
	document.getElementById("warnbtn").addEventListener("click", warnClick);
	document.getElementById("heartbtn").addEventListener("click", heartClick);
	document.getElementById("boardedit").addEventListener("click", editCHK);
	document.getElementById("boarddel").addEventListener("click", delCHK);
	
	var result = "<c:out value="${heartNo}"/>";
	if(result == 'fail'){
		alert('추천하실 수 없습니다.');
	}
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>