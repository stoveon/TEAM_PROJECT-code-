<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image⁄x-icon" href="<c:url value="/resources/img/home-icon.ico"/>">
<title>INSIDE.HOME</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
<header class="comm-head-outer">
	<div class="head-area">
		<ul class="head-list">
			<li class="head-info-label"><a class="head-info-label" href="<c:url value="#"/>">고객센터</a></li>
			<li class="head-info-label"><a class="head-info-label" href="<c:url value="/member/logout.do"/>">로그아웃</a></li>				
		</ul>
	</div>
	<div class="logo-area">
		<h2>
			<a href="<c:url value="/manager/inside/main.do"/>">
				<img class="logo" src="<c:url value="/resources/img/inside-logo.png"/>">
			</a>
		</h2>
	</div>
	<div class="head-service-area">
		<ul class="service-list">
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="#"/>">정보게시판</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="#"/>">익명게시판</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="#"/>">공지사항</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/manager/goods/list.do"/>">상품관리</a></li>
			<li class="service-info-label"><a class="service-info-label" href="<c:url value="/manager/member/list.do"/>">회원정보</a></li>			
			<li class="service-info-label"><a href="<c:url value="#"/>">
				<img class="talk_btn" src="<c:url value="/resources/img/btn_assatalk.png" />">
				</a></li>			
		</ul>
	</div>
</header>

	