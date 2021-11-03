<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<h3>상품등록</h3>
<form name="goodsForm" action="<c:url value="/manager/goods/insertGoods.do" />" method="post" enctype="multipart/form-data">
	<table>
		<caption>
			<button id="goodsbtn" type="submit" onclick="return checkForm();">상품등록</button>
			<button onClick="location.href='<c:url value="/manager/goods/list.do" />'">등록취소</button>
		</caption>
		<thead>
			<tr>
				<td>상품명</td> 
				<td><input type="text" name="goodsName" placeholder="상품명 입력"/></td>
				<td>가격</td> 
				<td><input type="number" name="price" required="required" min="0" max="50000" step="100" placeholder="가격 입력"/></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4"><textarea name="content" cols="100" rows="10" placeholder="상품 설명 입력"></textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<div id="fileBox">
						<input type="file" name="saveGoodsImage" accept=".jpg,.jpeg,.png,.gif" />
					<input id="addBtn" type="button" value="추가" onClick="add_insertFile()">
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</form>

<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js" />"></script>
<script>
window.onload = function(){
	document.getElementById("addBtn").onclick=add_insertFile;
	document.getElementById("goodsbtn").onclick=checkForm;
}
</script>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>