<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 글상세</h1>
	</div>
	<hr>
	<div class="info-inner">
		<div>
			<c:choose>
				<c:when test="${board.boardCode eq 'info'}">
				[ 정보게시판 ]&nbsp;
				</c:when>
				<c:when test="${board.boardCode eq 'who'}">
				[ 익명게시판 ]&nbsp;
				</c:when>
				<c:otherwise>
				[ 공지게시판 ]
				</c:otherwise>
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
						<td><c:out value="${board.writer}" /></td>
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
	<form name="ref-Form" method="post" action="<c:url value="/user/ref/regist.do" />">
		<textarea name="content" cols="100" rows="3" placeholder="댓글 입력"></textarea>
		<button id="refbtn">등록</button>
		<input type="hidden" name="boardNum" value="${board.num}"/>
	</form>
<c:if test="${boardRefs ne null}">
	<div>
	<div class="ref-detail">
			Comments&nbsp;&nbsp;${fn:length(boardRefs)}
		</div>
			<c:forEach var="oneRef" items="${boardRefs}">
				<div style="background: #F6F5F5; padding-left: ${2*oneRef.depth}%; border-bottom: solid 1px black;">
				<form action="<c:url value="/user/ref/update.do" />" method="post">
				<input type="hidden" name="num" value="${oneRef.num}" />
				<input type="hidden" name="boardNum" value="${board.num}" />
				<table>
					<caption>
							<input id="sabtn${oneRef.num}" type="submit" value="저장" disabled/>
							<button id="edbtn${oneRef.num}" type="button" onclick="return btnActive(${oneRef.num})">수정</button>
							<button type="button" onclick="return redelCHK()" value="${oneRef.num+='&boardNum='+=board.num}">삭제</button>
					</caption>
					<thead>
						<tr>
							<td>작성자: ${oneRef.writer}</td>
							<td>
								<fmt:formatDate var="regdate" value="${oneRef.regdate}" pattern="yyyy-MM-dd"/>
									등록일&nbsp;${regdate}
								<c:if test="${oneRef.moddate != null}">
									<fmt:formatDate var="moddate" value="${oneRef.moddate}" pattern="yyyy-MM-dd"/>
									&nbsp;|&nbsp;수정일&nbsp;${moddate}
								</c:if>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="2"><textarea id="refcon${oneRef.num}" name="content" cols="100" rows="3" disabled>${fn:replace(oneRef.content, replaceChar, "<br/>")}</textarea></td>
						</tr>
					</tbody>
				</table>
				</form>
					<form action="<c:url value="/user/ref/register.do" />" id="insert" method="post">
						<input type="hidden" name="boardNum" value="${oneRef.boardNum }" />
						<input type="hidden" name="nickname" value="${oneRef.writer }" />
						<input type="hidden" name="refNum" value="${oneRef.refNum}" />
						<div id="add_reply${oneRef.num}"></div>
					</form>
				</div>
				</c:forEach>
		</div>
	</div>
</c:if>
<script type="text/javascript" src="<c:url value="/resources/js/boardscript.js" />"></script>
<script type="text/javascript">

	var warn = document.querySelector('#warnbtn');
	warn.addEventListener("click", warnClick);
	
	var heart = document.querySelector('#heartbtn');
	heart.addEventListener("click", heartClick);
	
	var bedit = document.querySelector('#boardedit');
	bedit.addEventListener("click", editCHK);
	
	var bdel = document.querySelector('#boarddel');
	bdel.addEventListener("click", delCHK);

	
var result = "<c:out value="${heartNo}"/>";
if(result == 'fail'){
	alert('추천하실 수 없습니다.');
}


/* function editRef(){
	edit.disabled = false;
} */
/* let edit = document.getElementById("refbtn");
ref = edit.addEventListener("click", function(){
	const reply = () => {
		let renum = event.target.value;
		var name = 'add_reply'+renum;
		alert(name);
	    const box = document.getElementById("reply");
	    box.innerHTML = "<textarea rows='3' style='width: 90%; resize: none;' name='content'></textarea> <input type='submit' value='저장'>";
	}
}
	 */
/* const btn = (obj) => {
	   document.getElementById('insert').submit();
	}
	 */
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>