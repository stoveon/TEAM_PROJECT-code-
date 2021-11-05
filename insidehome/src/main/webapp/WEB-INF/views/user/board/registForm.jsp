<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 글작성</h1>
	</div>
	<hr>
	<div class="info-inner">
	<form name="boardForm" action="<c:url value="/user/board/regist.do"/>" method="post" enctype="multipart/form-data">
		<input type="hidden" name="writer" value="${artCmd.writer}" />
		<input type="hidden" name="notify" value="${artCmd.notify}" />
		<table>
			<thead>
				<tr>
					<td>게시판 선택</td>
					<td>
						<select name="boardCode">
							<option value="info" selected="selected">정보 게시판</option>
							<option value="who">익명 게시판</option>
						</select>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2"><input type="text" name="title" placeholder="제목 입력"/></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" cols="100" rows="10" placeholder="내용 입력"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<div id="boardFileBox">
						<input type="file" name="saveBoardImage" accept=".jpg,.jpeg,.png,.gif" />
					<input id="addBtnBoard" type="button" value="추가" >
					</div>
					</td>
				</tr>
				<tr>
					<td><button id="regbtn" type="submit" >등록</button></td>
					<td><button onclick="location.href='javascript:history.back()'" >취소</button></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/boardscript.js" />"></script>
<script>
	let addBtn = document.querySelector("#addBtnBoard");
	addBtn.addEventListener("click", add_inFile);
	
	let reg = document.querySelector("#regbtn");
	reg.addEventListener("click", boardCheckForm);
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>