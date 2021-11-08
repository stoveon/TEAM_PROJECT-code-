<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>

<div id="top-btn"></div>
<div class="body-info">
      <div class="info-detail">
         <h1 class="info-title">상품 수정</h1>
      </div>
		<form name="goodsForm" action="<c:url value="/manager/goods/updateGoods.do/${goods.goodsCode}" />" method="post" 
					enctype="multipart/form-data">
			<table>
				<caption>
					<button id="goodsbtn" type="submit" onclick="return checkForm();">상품수정</button>
					<input type="button" onClick="location.href='<c:url value="/manager/goods/list.do" />'" value="수정취소"/>
				</caption>
				<thead>
					<tr>
						<td>상품명</td><td><input style="width: 95%;"  type="text" name="goodsName" value="${goods.goodsName}" /></td>
						<td>가격</td><td><input style="width: 95%; padding: 5px 0 5px 0;" type="number" required="required" name="price" min="0" max="50000" step="100" value="${goods.price}" /></td>
						<td><label><input class="stock-update" type="radio" name="stock" value="0" checked="checked"/> +0</label>
							<label><input class="stock-update" type="radio" name="stock" value="10" /> +10</label>
							<label><input class="stock-update" type="radio" name="stock" value="20" /> +20</label>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="5">
							<textarea style="width: 98%; resize: none;" rows="10" cols="100" name="content">${goods.content}</textarea>
							<input type="hidden" name="goodsCode" value="${goods.goodsCode}" />
						</td>
					</tr>
					<tr>
			
						<td rowspan="2">파일 추가</td>
						<td  colspan="4">
						<div id="fileBox" style="border: none; width: 95%; text-align: left;">
					<c:if test="${!empty goodsImages}">
						<c:forEach items="${goodsImages}" var="fileName">
						<c:set var="saveFile" value="${fileName.imgPath}" />
						<p><input type="checkbox" name="deleteGoodsImage" value="${fileName.saveName}" /><a href="<c:url value="/display?goodsCode=${goods.goodsCode}&saveName=${saveFile}" />" target="_blank"><c:out value="${fileName.saveName}" /></a></p>
						</c:forEach>
					</c:if>
							<input type="file" name="plusGoodsImage" accept=".jpg,.jpeg,.png,.gif" />
							<input style="padding: 5px 30px 5px 30px;" id="addBtn" type="button" value="추가" onClick="add_updateFile();">
						</div>
						</td>
					</tr>
				</tbody>
			</table>
		</form>

</div>


<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js"/>"></script>
<script>
	document.getElementById("addBtn").addEventListener("onclick", add_updateFile);
	document.getElementById("goodsbtn").addEventListener("onclick", checkForm);
</script>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>