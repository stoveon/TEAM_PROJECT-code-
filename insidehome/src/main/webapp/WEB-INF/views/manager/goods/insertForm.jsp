<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>

<div class="body-info">
      <div class="info-detail">
         <h1 class="info-title">상품등록</h1>
      </div>
      <hr>
      <div class="info-inner">
		<form name="goodsForm" action="<c:url value="/manager/goods/insertGoods.do" />" method="post" enctype="multipart/form-data">
			<table>
				<caption>
					<button id="goodsbtn" type="submit" onclick="return checkForm();">상품등록</button>
					<button onClick="location.href='<c:url value="/manager/goods/list.do" />'">등록취소</button>
				</caption>
				<thead>
					<tr>
						<td>상품명</td> 
						<td><input style="width: 95%;" type="text" name="goodsName" placeholder="상품명 입력"/></td>
						<td>가격</td> 
						<td><input style="width: 95%; padding: 5px 0 5px 0;" type="number" name="price" required="required" min="0" max="50000" step="100" placeholder="가격 입력"/></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="4"><textarea style="width: 98%; resize: none;" name="content" rows="10" placeholder="상품 설명 입력"></textarea></td>
					</tr>
					<tr>
						<td rowspan="2">파일 추가</td>
						<td colspan="3">
							<div id="fileBox" style="border: none; width: 95%; text-align: left;">
								<input width="80%" type="file" name="saveGoodsImage" accept=".jpg,.jpeg,.png,.gif" />
								<input style="padding: 5px 30px 5px 30px;" id="addBtn" type="button" value="추가" onClick="add_insertFile();">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/goodsjs.js" />"></script>
<script>
	document.getElementById("addBtn").addEventListener("onclick", add_insertFile);
	document.getElementById("goodsbtn").addEventListener("onclick", checkForm);
</script>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>