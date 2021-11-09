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
		<h1 class="info-title">QA수정</h1>
	</div>
	<hr>
	<div class="info-inner">
	<form action="<c:url value="/manager/qa/update.do" />" method="post">
		<input type="hidden" value="${qa.NUM}" name="num">
		<table>
			<thead>
				<tr>
					<td bgcolor="#E8F6EF">
						
						<label><input type="radio" value="point" name="askType" <c:if test="${qa.ASKTYPE eq 'point'}">checked="checked"</c:if>>포인트</label>
						<label><input type="radio" value="goods" name="askType"<c:if test="${qa.ASKTYPE eq 'goods'}">checked="checked"</c:if>>상품관련</label>
						<label><input type="radio" value="member" name="askType"<c:if test="${qa.ASKTYPE eq 'member'}">checked="checked"</c:if>>회원정보</label>
						<label><input type="radio" value="question" name="askType"<c:if test="${qa.ASKTYPE eq 'question'}">checked="checked"</c:if>>기타문의</label>
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td bgcolor="#E8F6EF">
						<input style="width: 95%; padding: 10px;" type="text" name="title" value="${qa.TITLE }">
					</td>
				</tr>
				<tr> 
					<td>
						<textarea style="width: 98%; resize: none; padding: 10px;" rows="5" cols="30"  name="content">${qa.CONTENT }</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div align="right" style="margin-top: 15px;">
			<input style="width: 10%;" type="submit" value="수정">
			<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/qa/list.do" />'" value="취소">
		</div>
	</form>
	</div>
	<div style="position: fixed; bottom: 15%; right: 5%;">
		<a href="#top-btn">
			<img src="https://img.icons8.com/ultraviolet/50/000000/circled-chevron-up.png"/>
		</a>
	</div>
</div>



<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>