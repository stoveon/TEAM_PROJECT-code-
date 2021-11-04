<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/user/member/common/commHeader.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="body-info">
	<div class="info-detail">
			<form:form action="login.do" commandName="cmd" class="login-info">
			<ul class="first-box">
				<li><img src="<c:url value="/resources/img/inside-logo.png"/>" width="80%"></li>
				<li style="margin-right: 5%;">
					<label class="login-option"><input type="radio" name="loginOption" checked="checked"/>옵션 사용 안함</label>&nbsp;&nbsp; 
					<label class="login-option"><input type="radio" name="loginOption" value="rememberEmail" />이메일 유지</label> &nbsp;&nbsp;
					<label class="login-option"><input type="radio" name="loginOption" value="autoLogin"/>자동로그인</label> &nbsp;	&nbsp;
				</li>
			</ul>
			<ul class="second-box">
				<li class="login-info-second"><form:input path="email" class="login-info-label" placeholder="@를 포함한 이메일 전체 입력"/></li>
				<li class="login-info-second"><form:password path="password" class="login-info-label" placeholder="비밀번호 입력"/></li>
				<li class="login-info-second"><form:errors path="email"/><form:errors path="password"/> </li>				
				<li class="login-info-second"><input id="save-info2" type="submit" value="로그인"> </li>
				<li class="login-info-second" style="text-align: center;">
					<a class="login-other" href="<c:url value="/member/searchEmailForm.do" />">아이디 찾기</a> | 
					<a class="login-other" href="<c:url value="/member/searchPwForm.do" />">비밀번호 찾기</a> | 
					<a class="login-other" href="<c:url value="/inside/registForm.do" />">회원가입</a>
				</li>
			</ul>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>