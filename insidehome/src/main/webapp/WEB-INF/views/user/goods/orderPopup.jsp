<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function getParentText() { 
	document.getElementById("text").value = window.opener.document.getElementById("goodsName").value; 
}
</script>
</head>
<body>
<input type="text" id="orderOk" readonly="readonly"><br>
<button type="button" onclick="window.close();" >확인</button>
</body>
</html>