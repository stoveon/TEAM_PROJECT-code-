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
	<form name="boardForm" action="<c:url value="/user/board/update.do"/>" method="post" enctype="multipart/form-data">
	<input type="hidden" name="num" value="${board.num}" />
	<input type="hidden" name="notify" value="${board.notify}" />
	<input type="hidden" name="writer" value="${board.writer}" />
		<table>
			<thead>
				<tr>
					<td style="width: 60%;" bgcolor="#E8F6EF">게시판 선택</td>
					<td align="left" style="padding: 1% 5% 1% 2%; margin-right: 0;" bgcolor="#E8F6EF">
						<select name="boardCode">
							<option value="info" <c:if test="${board.boardCode eq 'info'}" >selected="selected"</c:if>>정보 게시판</option>
							<option value="who"<c:if test="${board.boardCode eq 'who'}" >selected="selected"</c:if>>익명 게시판</option>
						</select>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><input style="width: 98%;" type="text" name="title"/ value="${board.title}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea style="width: 96%; resize: none; padding: 2%;"   name="content" cols="100" rows="10">${board.content}</textarea>
					</td>
				</tr>
				<tr>
					<td width="50%">
					<div id="boardFileBox" style="border: none; width: 95%; text-align: left;">
					<c:if test="${!empty boardImages}">
						<c:forEach items="${boardImages}" var="fileName">
						<p><input type="checkbox" name="deleteBoardImage" value="${fileName.saveName}" />
						<a href="<c:url value="/boardDis?saveName=${fileName.saveName}" />" target="_blank">
						<c:out value="${fileName.originName}" /></a></p>
						</c:forEach>
					</c:if>
						<input type="file" name="plusBoardImage" accept=".jpg,.jpeg,.png,.gif" />
						<input style="padding: 5px 30px 5px 30px;" id="addBtnBoard" type="button" value="추가" >
					</div>
					</td>
					<td width="50%" style="text-align: right;">
						<input style="padding: 5px 30px 5px 30px;" id="regbtn" type="submit" value="등록" />
						<input style="padding: 5px 30px 5px 30px;" type="button" value="취소" onclick="location.href='javascript:history.back()'" />
					</td>
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