<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문완료</title>
</head>
<body>
<div style="text-align: center; vertical-align: middle; margin: 0; height: 500px;">
	<img style="padding-top: 50px;" class="banner" src="<c:url value="/resources/img/inside-logo.png"/>">
	<p>	<h2>주문이 완료되었습니다.</h2>
	<h3>저희 인사이드 홈을 이용해주셔서 감사합니다.</h3>
	<h4>빠른 시일 내에 배송해 드리겠습니다.</h4></p>
	<button type="button" onclick="window.close();">닫기</button>
</div>
</body>
</html>