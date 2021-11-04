<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">이메일 찾기</h1>
		<p class="info-title-sub">
			안전한 비밀번호로 내 정보를 보호하세요!
			* 다른 아이디/사이트에서 사용한 적이 없는 비밀번호가 안전하답니다!
			* 이전에 사용한 적 없는 비밀번호가 안전합니다.
		</p>
		<hr>
		<form:form action="changePw.do" commandName="editCmd">
			<table>
				<tr>
					<td class="find-info-label">사용자 이메일</td>
					<td class="find-info-input"><form:input class="find-info" path="email" placeholder="ex) example@test.com"/></td>
					<td class="find-info-input"><form:errors path="email"/></td>
				</tr>
				<tr>
				<tr>
					<td class="find-info-label">현재 비밀번호</td>
					<td class="find-info-input"><form:password class="find-info" path="password" placeholder="현재 비밀번호 입력"/></td>
					<td class="find-info-input"><form:errors path="password"/></td>
				</tr>
				<tr>
					<td class="find-info-label">새 비밀번호</td>
					<td class="find-info-input"><form:password class="find-info" path="newPassword" placeholder="영문소문자,숫자,특수문자 1개이상  포함 8자리 이상"/></td>
					<td class="find-info-input"><form:errors path="newPassword"/></td>
				</tr>
				<tr>
					<td class="find-info-label">새 비밀번호 확인</td>
					<td class="find-info-input"><form:password class="find-info" path="newPasswordCheck"/></td>
					<td class="find-info-input"><form:errors path="newPasswordCheck"/></td>
				</tr>
				<tr>
					<td class="find-info-label"></td>
					<td class="find-info-input"><input class="find-info-input" type="submit" value="비밀번호 변경"></td>
					<td class="find-info-input"></td>
				</tr>
			</table>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>