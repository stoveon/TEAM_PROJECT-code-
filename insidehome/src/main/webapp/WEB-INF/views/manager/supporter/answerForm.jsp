<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<div id="top-btn"></div>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">고객문의 답변하기</h1>
	</div>
	<hr>
	<div class="info-inner">
	<form action="<c:url value="/manager/ask/answer.do" />" method="post">
		<input type="hidden" value="${qa.num}" name="num">
		<table>
			<thead>
				<tr>
					<td bgcolor="#E8F6EF" align="left" style="padding: 10px;"> Q. ${qa.title }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td bgcolor="#E8F6EF" align="left" style="padding: 10px;"> ${qa.content } </td>
				</tr>
				<tr>
					<td>
						<textarea style="width: 98%; resize: none; padding: 10px; background: " rows="5" name="answer" placeholder="답변입력" >${qa.answer }</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="등록">
		<input type="button" onclick="location.href='<c:url value="/manager/ask/list.do" />'" value="취소">
	</form>
	</div>
	<div style="position: fixed; bottom: 15%; right: 5%;">
		<a href="#top-btn">
			<img src="https://img.icons8.com/ultraviolet/50/000000/circled-chevron-up.png"/>
		</a>
	</div>
</div>

<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>