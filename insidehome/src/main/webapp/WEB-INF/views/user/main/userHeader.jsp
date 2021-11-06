<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<% Object loginChk = request.getAttribute("loginInside"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="<c:url value="/resources/img/home-icon.ico"/>">
<title>INSIDE.HOME</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
<script type="text/javascript">
	function showIdentify(){
		var url = "${pageContext.request.contextPath}/info/identify.do";
		window.open(url, "Identify", "height=2000, left=1000, top=1000");
	}
</script>
</head>
<body>
<header class="comm-head-outer">
	<div class="head-area">
		<ul class="head-list">
			<li class="head-info-label"><a class="head-info-label" href="<c:url value="#"/>">고객센터</a></li>
			<c:if test="${loginInside != null}">
				<li class="head-info-label"><a class="head-info-label" href="<c:url value="/user/mypage/main.do"/>">[ ${loginInside }MYPAGE ]</a></li>
				<li class="head-info-label"><a class="head-info-label" href="<c:url value="/member/logout.do"/>">로그아웃</a></li>				
			</c:if>
			<c:if test="${loginInside == null }">
				<li class="head-info-label"><a class="head-info-label" href="<c:url value="/inside/registForm.do"/>">회원가입</a></li>
				<li class="head-info-label"> <a class="head-info-label" href="<c:url value="/member/loginForm.do"/>">로그인</a></li>
			</c:if>
		</ul>
	</div>
	<div class="logo-area">
		<h2>
			<a href="<c:url value="/inside/main.do"/>">
				<img class="logo" src="<c:url value="/resources/img/inside-logo.png"/>">
			</a>
		</h2>
	</div>
	<div class="head-service-area">
		<ul class="service-list">
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/board/list.do?boardCode=info"/>">정보게시판</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/board/list.do?boardCode=who"/>">익명게시판</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/board/list.do?notify=notice"/>">공지사항</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/goods/list.do"/>">포인트몰</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/inside/checkForm.do"/>">출석체크</a></li>			
			<li class="service-info-label"><a href="<c:url value="#"/>">
				<img class="talk_btn" src="<c:url value="/resources/img/btn_assatalk.png"/>">
				</a></li>			
		</ul>
	</div>
</header>

	