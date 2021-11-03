<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>
<body>
<div style="padding: 5% 0 0 0;">
	<div class="info-inner">
		<img class="error" src="<c:url value="/resources/img/404err.png"/>"  />
		<button class="mainpage" onclick="location.href='<c:url value="/inside/main.do"/>'">메인페이지 이동</button>
	</div>
</div>
</body>
</html>