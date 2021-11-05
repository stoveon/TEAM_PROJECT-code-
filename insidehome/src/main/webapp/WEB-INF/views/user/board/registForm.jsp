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
	<form name="boardForm" method="post" enctype="multipart/form-data">
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
					<td><input type="text" name="title" placeholder="제목 입력"/></td>
				</tr>
				<tr>
					<td>
						<textarea name="content" cols="100" rows="10" placeholder="내용 입력"></textarea>
					</td>
				</tr>
				<tr>
					<td>
					<div id="fileBox">
						<input type="file" name="saveBoardImage" accept=".jpg,.jpeg,.png,.gif" />
					<input id="addBtn" type="button" value="추가" onClick="add_insertFile();">
					</div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="등록" /></td>
					<td><input type="button" value="취소" onclick="<c:url value="/inside/main.do" />" /></td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/boardjs.js" />"></script>
<script>
	document.getElementById("addBtn").addEventListener("click", add_insertFile);
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>