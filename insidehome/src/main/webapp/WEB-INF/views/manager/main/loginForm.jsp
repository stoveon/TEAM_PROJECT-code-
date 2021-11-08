<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="<c:url value="/resources/img/home-icon.ico"/>">
<title>INSIDE.HOME</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="body-info">
	<div class="info-detail">
			<form action="<c:url value="/mgr/login.do"/>" method="post">
			<ul class="first-box">
				<li><img src="<c:url value="/resources/img/inside-logo.png"/>" width="80%"></li>
			</ul>
			<ul class="second-box">
				<li class="login-info-second"><input type="text" name="email" class="login-info-label" placeholder="관리자로그인 아이디"/></li>
				<li class="login-info-second"><input type="password" name="password" class="login-info-label" placeholder="비밀번호"/></li>
				<li class="login-info-second"><input id="save-info2" type="submit" value="관리자로그인"> </li>
			</ul>
		</form>
	</div>
</div>

</body>
</html>