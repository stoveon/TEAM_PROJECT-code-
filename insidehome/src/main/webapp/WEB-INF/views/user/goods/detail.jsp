<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div clss="image">
	<img src="">
	<img src="">
	<img src="">
	<img src="">
</div>
<div>
	<ul >
		<li>${goods.goodsName}</li>
		<li>${goods.price}</li>
		<li>${goods.content}</li>
	</ul><br>
	<button onclick="<c:url value="/goods/orderForm.do" />"></button>
</div>
</body>
</html>