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
		<table>
			<thead>
				<tr>
					<td style="width: 60%;" bgcolor="#E8F6EF">게시판 선택</td>
					<td align="left" style="padding: 1% 5% 1% 2%; margin-right: 0;" bgcolor="#E8F6EF">
						<select name="boardCode" style="width: 100%;" >
							<c:if test="${artCmd.boardCode eq 'info' }">
								<option value="info" selected="selected">정보 게시판</option>
								<option value="who">익명 게시판</option>
							</c:if>
							<c:if test="${artCmd.boardCode eq 'who' }">
								<option value="info">정보 게시판</option>
								<option value="who"  selected="selected">익명 게시판</option>
							</c:if>

						</select>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2">
						<input style="width: 98%;" type="text" name="title" placeholder="제목 입력"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea style="width: 96%; resize: none; padding: 2%;"  name="content" cols="100" rows="10" placeholder="내용 입력"></textarea>
					</td>
				</tr>
				<tr>
					<td width="50%">
					<div id="boardFileBox" style="border: none; width: 95%; text-align: left;">
						<input type="file" name="saveBoardImage" accept=".jpg,.jpeg,.png,.gif" />
						<input style="padding: 5px 30px 5px 30px;" id="addBtnBoard" type="button" value="추가" >
					</div>
					</td>
					<td width="50%" style="text-align: right;">
						<button style="padding: 5px 30px 5px 30px;"  id="regbtn" type="submit" >등록</button>
						<button style="padding: 5px 30px 5px 30px;"  onclick="location.href='javascript:history.back()'" >취소</button>
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
	addBtn.addEventListener("click", add_inFile);
	
	let reg = document.querySelector("#regbtn");
	reg.addEventListener("click", boardCheckForm);
</script>
<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>