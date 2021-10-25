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
<<<<<<< HEAD
<script type="text/javascript" src="resources/js/goodsjs"></script>
<form action="<c: url value="/manager/goods/updateGoods.do" />" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
	<table>
		<tr><td>상품 수정</td>
			<td><input type="submit" value="상품수정"/>
			<input type="button" onClick="location.href='<c:url value="/manager/goods/list.do" />'" value="수정취소"/></td>
		</tr>
		<tr>
			<td>상품명</td><td><input id="essential" type="text" name="goodsName" value="${goods.goodsName}" /></td>
			<td>가격</td><td><input type="number" name="price" min="0" max="50000" step="1000" value="${goods.price}" /></td>
			<td><input id="essential" type="radio" name="stock" value="0" /> +0
				<input id="essential" type="radio" name="stock" value="10" /> +10
				<input id="essential" type="radio" name="stock" value="20" /> +20
			</td>
		</tr>
		<tr>
			<td><textarea id="essential" rows="10" cols="100" name="content">${goods.content}</textarea></td>
		</tr>
		<tr><td>파일 추가</td>
		<td id="fileBox">
		<c:forEach items="goodsImages" var="fileName">
		<input type="checkbox" name="deleteFile" value="${fileName}" />${fileName}<br>
		</c:forEach>
		<input type="file" name="plusGoodsImages" accept=".jpg,.jpeg,.png,.gif" />
		<input type="button" value="추가" onClick="add_file()">
		<input type="hidden" name="goodsCode" value="${goods.goodsCode}" />
=======
<form action="<c: url value="/manager/goods/updateGoods" />" method="post" enctype="multipart/form-data">
	<table>
		<tr><td>상품 수정</td>
			<td><input type="submit" value="상품수정"/>
			<input type="button" onClick="location.href='<c:url value="" />'" value="수정취소"/></td>
		</tr>
		<tr>
			<td>상품명</td><td><input type="text" name="goodsName" value="${goodsName}" /></td>
			<td>가격</td><td><input type="number" name="price" value="${price}" /></td>
			<td><input type="radio" name="stock" value="0" /> +0
			<input type="radio" name="stock" value="10" /> +10
			<input type="radio" name="stock" value="20" /> +20
			</td>
		</tr>
		<tr>
			<td><textarea rows="10" cols="100" name="content">${content}</textarea></td>
		</tr>
		<tr><td>파일 추가</td><td>
		<c:forEach items="goodsImage" var="fileName">
		<input type="checkbox" name="deleteFile"/>${fileName}<br>
		</c:forEach>
>>>>>>> refs/remotes/origin/master
		</td>
		</tr>
	</table>
</form>
</body>
</html>