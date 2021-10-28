<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<form action="<c:url value="/manager/goods/insertGoods.do" />" method="post" enctype="multipart/form-data"
		 onsubmit="return checkForm()">
	<table>
		<tr><td colspan="2">상품등록</td>
			<td><input class="#" type="submit" value="상품등록" /></td>
			<td><input class="#" type="button" value="등록취소" onClick="location.href='<c:url value="/manager/goods/list.do" />'"/></td>
		</tr>
		<tr>
			<td>상품명</td> 
			<td><input class="#" type="text" name="goodsName" placeholder="상품명 입력"/></td>
			<td>가격</td> 
			<td><input class="#" type="number" name="price" min="0" max="50000" step="100" placeholder="가격 입력"/></td>
		</tr>
		<tr>
			<td colspan="4"><textarea class="#" name="content" cols="100" rows="10" placeholder="상품 설명 입력"></textarea></td>
		</tr>
		<tr>
			<td colspan="4">
				<div id="fileBox">
				<input class="#" type="file" name="saveGoodsImage" accept=".jpg,.jpeg,.png,.gif" />
				<input id="addBtn" type="button" value="추가"/>
				</div>
			</td>
	</table>
</form>

<script src="<c:url value="/resources/js/goodsjs.js" />"></script>
<script>
window.onload = function(){
	document.getElementById("addBtn").onclick=add_insertFile;
}
</script>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>