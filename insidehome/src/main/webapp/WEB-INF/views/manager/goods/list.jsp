<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<%@include file="/WEB-INF/views/manager/main/mgrHeader.jsp"%>
<script type="text/javascript">
function removeCheck(){
	if(confirm("상품을  삭제하시겠습니까?") == true){
		document.goodsForm.action= '<c:url value="/manager/goods/deleteGoods.do" />'
	}else{
		return false;
	}
}
	var checkDel = "<c:out value="${deleteOk}" />";
	if(checkDel == 'success'){
		alert('상품이 삭제되었습니다.');
	}
	var checkHeart = "<c:out value="${heartFail}" />";
	if(checkHeart == 'fail'){
		alert('잘못 선택하셨습니다.');
	}
</script>
<div class="bodyinfo">
	<form name="goodsForm" method="post">
		<div class="info-detail">
			<h1 class="info-title">상품관리</h1>
		</div>
		<hr>
		<div class="info-inner">
		<table>
			<caption>
				<button style="width: 15%;" type="button" onclick="location.href='<c:url value="/manager/goods/insertGoods.do" />'">상품등록</button>
				<button style="width: 15%;" type="submit" onclick="removeCheck()">상품삭제</button>
				<button style="width: 15%;" type="submit" onclick="form.action= '<c:url value="/manager/goods/heartUpdate.do?type=recommand" />'" >추천등록</button>
				<button style="width: 15%;" type="submit" onclick="form.action= '<c:url value="/manager/goods/heartUpdate.do?type=cancle" />'" >추천취소</button>
			</caption>
			<thead>
				<tr>
					<th></th><th>추천</th><th>상품명</th><th>등록일자</th><th>판매량</th><th>재고수량</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goodsList}" var="goodsOne" >
					<tr style="text-align: center;">
						<td><input type="checkbox" name="selectGoods" value="${goodsOne.GOODSCODE}&${goodsOne.HEART}"/></td>
						<td>
							<c:if test="${goodsOne.HEART eq 'yes'}">
								<c:set var="heart" value="SELECT" />
							</c:if>
							<c:if test="${goodsOne.HEART eq 'no'}">
								<c:set var="heart" value="" />
							</c:if>
							<c:out value="${heart}" />
						</td>
						<td style="text-align: left; padding-left: 2%;"><a href="<c:url value="/manager/goods/updateGoods.do/${goodsOne.GOODSCODE}" />">
						<c:out value="${goodsOne.GOODSNAME}"/></a></td>
						<td>
						<c:out value="${goodsOne.REGDATE}"/></td>
						<td><c:out value="${goodsOne.TOTALCNT}"/></td>
						<td><c:out value="${goodsOne.STOCK}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</form>
</div>
<%@include file="/WEB-INF/views/manager/main/mgrFooter.jsp"%>