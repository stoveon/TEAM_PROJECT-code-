<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var goodsName = window.opener.document.getElementById("goodsName").value;
</script>
<body>
<div>
<h3>${goodsName}</h3>을 구매하시겠습니까?
<button type="button" class="addrChange" value="changeOk">주소변경</button>
<button type="button" class="addrChange" value="changeNO">취소</button>
</div>
</body>
</html>