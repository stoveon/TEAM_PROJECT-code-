<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 글수정</h1>
	</div>
	<hr>
	<div class="info-inner">
	<form name="boardForm" action="<c:url value="/user/board/update.do/${board.num}"/>" method="post" enctype="multipart/form-data">
		<table>
			<thead>
				<tr>
					<td>게시판 선택</td>
					<td>
						<select name="boardCode">
							<option value="info" <c:if test="${board.boardCode eq 'info'}" >selected="selected"</c:if>>정보 게시판</option>
							<option value="who"<c:if test="${board.boardCode eq 'who'}" >selected="selected"</c:if>>익명 게시판</option>
						</select>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><input type="text" name="title"/ value="${board.title}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" cols="100" rows="10">${board.content}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<div id="boardFileBox">
					<c:if test="${!empty boardImages}">
						<c:forEach items="${boardImages}" var="fileName">
						<p><input type="checkbox" name="deleteBoardImage" value="${fileName.originName}" />
						<a href="<c:url value="/boardDis?saveName=${fileName.saveName}" />" target="_blank">
						<c:out value="${fileName.originName}" /></a></p>
						</c:forEach>
					</c:if>
						<input type="file" name="plusBoardImage" accept=".jpg,.jpeg,.png,.gif" />
					<input id="addBtnBoard" type="button" value="추가" >
					</div>
					</td>
				</tr>
				<tr>
					<td><input id="regbtn" type="submit" value="등록" /></td>
					<td><input type="button" value="취소" onclick="location.href='javascript:history.back()'" /></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/boardscript.js" />"></script>
<script>
	let addBtn = document.querySelector("#addBtnBoard");
	addBtn.addEventListener("click", add_upFile);
	
	let reg = document.querySelector("#regbtn");
	reg.addEventListener("click", boardCheckForm);
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>