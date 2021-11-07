<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>


<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">고객문의 내글목록</h1>
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
					<c:foreach items="${list}" var="list">
						<tr>
							<td><a href="/user/question/detail?num=${list.num}"></a></td>
						</tr>
						<tr>
							<td>${list.title}</td>
						</tr>
					</c:foreach>
				</tbody>
			</table>
		</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>