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
		<h1 class="info-title">QA관리</h1>
	</div>
	<hr>
	<div class="info-inner">
		<table>
			<caption>
				<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/qa/insertForm.do"/>'" value="QA등록">
				<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/ask/list.do"/>'" value="고객문의 관리">
				<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/manager/warning/list.do"/>'" value="신고관리">
			</caption>
			<thead>
				<tr>
					<td class="table-inner"><b>번호</b></td>
					<td class="table-inner"><b>제목</b></td>
					<td class="table-inner"><b>내용</b></td>
				</tr>
			</thead>
			<tbody>
				<c:set var="number" value="1"/>
				<c:forEach items="${qa}" var="info">
					<tr>
						<td>${number}</td>
						<td>
							<a href="<c:url value="/manager/qa/updateForm.do?num=${info.NUM}"/>">
								${info.TITLE}
							</a>
						</td>
						<td>${info.CONTENT}</td>
					</tr>
					<c:set var="number" value="${number+1 }"/>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div style="position: fixed; bottom: 15%; right: 5%;">
		<a href="#top-btn">
			<img src="https://img.icons8.com/ultraviolet/50/000000/circled-chevron-up.png"/>
		</a>
	</div>
</div>



<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>