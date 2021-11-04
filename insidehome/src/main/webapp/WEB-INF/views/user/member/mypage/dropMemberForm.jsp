<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">회원 탈퇴</h1>
		<p class="info-title-sub">
			탈퇴 후 일부 정보(이메일, 닉네임)를 제외한 회원정보 및 이용 기록은 모두 삭제되며, 다시 복구할 수 없습니다.
			홈페이지에 작성된 모든 글은 이용약관에 의해 보관되며 이는 삭제가 불가합니다.
			동일한 SNS계정과 이메일을 사용한 재가입은 불가합니다.
		</p>
		<hr>
		<form action="<c:url value="/user/mypage/info/drop.do"/>" method="post">
			<table>
				<tr>
					<td class="find-info-label">사용자 이메일</td>
					<td class="find-info-input"><input class="find-info" type="text" name="email" placeholder="ex) example@test.com" required="required"/></td>
				</tr>
				<tr>
				<tr>
					<td class="find-info-label">비밀번호</td>
					<td class="find-info-input"><input class="find-info" type="password" name="password" placeholder="현재 비밀번호 입력" required="required"/></td>
				</tr>
				<tr>
					<td class="find-info-input"><input class="find-info" type="checkbox" value="true"/> INSIDE.HOME을 탈퇴합니다.</td>
					<td class="find-info-input"></td>
				</tr>
				<tr>
					<td class="find-info-label"></td>
					<td class="find-info-input"><input class="find-info-input" type="submit" value="회원 탈퇴"></td>
					<td class="find-info-input"></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>
