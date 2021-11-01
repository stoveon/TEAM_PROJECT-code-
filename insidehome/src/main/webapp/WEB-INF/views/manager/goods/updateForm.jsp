<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<form action="<c:url value="/manager/goods/updateGoods.do/${goods.goodsCode}" />" method="post" enctype="multipart/form-data" onsubmit="return checkForm();">
	<h3>상품 수정</h3>
	<table>
		<caption>
			<input type="submit" value="상품수정"/>
			<input type="button" onClick="location.href='<c:url value="/manager/goods/list.do" />'" value="수정취소"/>
		</caption>
		<thead>
			<tr>
				<td>상품명</td><td><input id="essential" type="text" name="goodsName" value="${goods.goodsName}" /></td>
				<td>가격</td><td><input type="number" name="price" min="0" max="50000" step="1000" value="${goods.price}" /></td>
				<td><input id="essential" type="radio" name="stock" value="0" /> +0
					<input id="essential" type="radio" name="stock" value="10" /> +10
					<input id="essential" type="radio" name="stock" value="20" /> +20
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="5">
					<textarea id="essential" rows="10" cols="100" name="content">${goods.content}</textarea>
					<input type="hidden" name="goodsCode" value="${goods.goodsCode}" />
				</td>
			</tr>
			<tr>
	
				<td rowspan="2">파일 추가</td>
				<td  colspan="4">
			<c:if test="${!empty goodsImages}">
				<c:forEach items="${goodsImages}" var="fileName">
				<c:set var="saveFile" value="${fileName.imgPath}" />
				<p><input type="checkbox" name="deleteGoodsImage" value="${fileName}" /><a href="<c:url value="/display?goodsCode=${goods.goodsCode}&saveName=${saveFile}" />" target="_blank"><c:out value="${fileName.saveName}" /></a></p>
				</c:forEach>
			</c:if>
				<div id="fileBox">
					<input type="file" name="plusGoodsImage" accept=".jpg,.jpeg,.png,.gif" />
					<input id="addBtn" type="button" value="추가" onClick="add_updateFile()">
				</div>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js"/>"></script>
<script>
window.onload = function(){
		document.getElementById("addBtn").onclick = add_updateFile;

}
</script>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>