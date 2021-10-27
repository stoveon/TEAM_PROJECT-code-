<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/goodsjs.js"></script>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/goodsjs.js"></script>
<form action="<c:url value="/manager/goods/updateGoods.do/${goods.goodsCode}" />" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
	<table>
		<tr><td colspan="4">상품 수정</td>
			<td colspan="1"><input type="submit" value="상품수정"/>
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
			<td colspan="5">
				<textarea id="essential" rows="10" cols="100" name="content">${goods.content}</textarea>
				<input type="hidden" name="goodsCode" value="${goods.goodsCode}" />
			</td>
		</tr>
		<tr>

			<td rowspan="2">파일 추가</td>
			<td  colspan="3">
			<c:forEach items="${goodsImages}" var="fileName">
			<input type="checkbox" name="deleteGoodsImage" value="${fileName}" /><c:out value="${fileName}" /><br>
			</c:forEach>
			</td>
		</tr>
		<tr><td>
			<div id="fileBox">
				<input type="file" name="plusGoodsImage" accept=".jpg,.jpeg,.png,.gif" />
				<input type="button" value="추가" onClick="add_updateFile()">
			</div>
			</td>
		</tr>
	</table>
</form>
</body>
</html>