<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div class="body-info">
	<div class="info-detail">
		<c:if test="${findResult != null }">
			<c:if test="${type eq 'email' }">
				<h2>이메일 찾기 결과입니다.</h2>
			</c:if>
			<c:if test="${type eq 'password' }">
				<h2>비밀번호 찾기 결과입니다.</h2>
			</c:if>
		</c:if>
		<c:if test="${findResult == null }">
			<h2>회원정보가 존재하지 않습니다.</h2>		
		</c:if>
	</div>
	<hr>
		<p style="background: #EAEAEA; padding: 2% 0 2% 0; margin: 0 0 0 0; text-align: center;">
			<c:if test="${findResult != null }">
				<c:if test="${type eq 'email' }">
					${findResult }
				</c:if>
				<c:if test="${type eq 'password' }">
					입력하신 이메일로 임시 비밀번호가 발급되었습니다. <br><br>
					로그인 후 반드시 비밀번호를 변경하시기 바랍니다.
				</c:if>
			</c:if>
			<c:if test="${findResult == null }">
				입력하신 정보와 일치하는 회원 정보가 존재하지 않습니다.		
			</c:if>
		</p>
	<div style="text-align: right; margin-top: 2%;">
		<a class="next-find" href="<c:url value="/member/searchEmailForm.do" />">아이디 찾기</a> 
		<a class="next-find" href="<c:url value="/member/searchPwForm.do" />">비밀번호 찾기</a> 
		<a class="next-find" href="<c:url value="/member/loginForm.do" />">로그인</a> 
	</div>
</div>


<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>