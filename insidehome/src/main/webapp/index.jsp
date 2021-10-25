<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>   
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<img src="resources/img/err.png" height="60%" alt="123"/>
</div>
		<button onclick="location.href='main.inside'">메인페이지 이동</button><br>
		<a href="<c: url value="/manager/goods/list.do" />">상품관리 페이지</a>
</body>
</html>


	
