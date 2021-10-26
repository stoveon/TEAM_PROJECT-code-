<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상</title>
</head>
<body>
<script src="<%=request.getContextPath() %>/resources/js/goodsjs.js"></script>
<form action="/manager/goods/insertGoods.do" method="post" enctype="multipart/form-data" 
			onsubmit="return checkForm()">
	<table>
		<tr><td colspan="2">상품등록</td>
			<td><input class="#" type="submit" value="상품등록" /></td>
			<td><input class="#" type="button" value="등록취소" onClick="locaion.href='<c:url value="/manager/goods/list.do" />'"/></td>
		</tr>
		<tr>
			<td>상품명</td> 
			<td><input class="#" type="text" name="goodsName" placeholder="상품명 입력"/></td>
			<td>가격</td> 
			<td><input class="#" type="number" min="0" max="50000" step="1000" placeholder="가격 입력"/></td>
		</tr>
		<tr>
			<td colspan="4"><textarea class="#" cols="100" rows="10" placeholder="상품 설명 입력"></textarea></td>
		</tr>
		<tr>
			<td colspan="4">
				<div id="fileBox">
				<input class="#" id="file" type="file" name="saveGoodsImages" accept=".jpg,.jpeg,.png,.gif" />
				<input type="button" value="추가" onClick="add_insert()" />
				</div>
			</td>
	</table>
</form>
</body>
</html>