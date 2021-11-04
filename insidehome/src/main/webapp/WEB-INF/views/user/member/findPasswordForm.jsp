<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">비밀번호 찾기</h1>
		<p class="info-title-sub">회원가입 시 입력한 이메일과 전화번호를 입력하여 가입 시 사용한 이메일 주소를 찾을 수 있습니다.</p>
		<hr>
		<form:form action="searchPw.do" commandName="pwCmd">
			<table>
				<tr>
					<td class="find-info-label">이메일 입력 </td>
					<td class="find-info-input"><form:input class="find-info" path="email" placeholder="ex) sample@inside.home"/></td>
					<td class="find-info-input"><form:errors path="email"/></td>
				</tr>
				<tr>
					<td class="find-info-label">전화번호 입력</td>
					<td class="find-info-input"><form:input class="find-info" path="phone" placeholder="'-'를 제외한 전화번호 전체 입력"/></td>
					<td class="find-info-input"><form:errors path="phone"/></td>
				</tr>
				<tr>
					<td class="find-info-label"></td>
					<td class="find-info-input"><input class="find-info-input" type="submit" value="비밀번호 찾기"></td>
					<td class="find-info-input"></td>
				</tr>
			</table>
		</form:form>
	<div>
	</div>
</div>


<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>