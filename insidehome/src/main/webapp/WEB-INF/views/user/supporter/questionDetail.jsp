<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>


<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">고객문의 상세창 답변확인..?</h1>
	</div>
	<hr>
	<div class="info-inner">
		<form action="questionList.do" method="POST">
			<div class="move">
				<ul>
					<li>
						<input type="button" value="Q&A" onclick="location.href='/user/supporter/qaList'" /> 
						<input type="button" value="고객문의" onclick="location.herf='/user/supporter/questionList'" /> 
						<input type="button" value="내 문의" onclick="location.herf='/user/supporter/questionDetail'" />
					</li>
				</ul>
			</div>
			<h2 class="title">고객문의</h2>
			<table>
				<tbody>
					<c:foreach items="${det}" var="detail">
						<tr>
							<td>${detail.title}</td>
						</tr>
						<tr>
							<td class="Box">${detail.content}</td>
						</tr>
						<c:if test="${not empty detail.answer}">
							<tr>
								<td>${detail.answer}</td>
							</tr>
						</c:if>
					</c:foreach>
				</tbody>
			</table>
			<input type="button" value="목록" a href="/user/question/list.do">
		</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>