<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>

<div id="top-btn"></div>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">문의하기</h1>
	</div>
	<hr>
	<div class="info-inner">
	<form action="<c:url value="/user/ask/insert.do" />" method="post">
		<table>
			<tbody>
				<tr>
					<td bgcolor="#E8F6EF">
						<input style="width: 95%; padding: 10px;" type="text" name="title" placeholder="문의 제목" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<textarea style="width: 98%; resize: none; padding: 10px;" rows="5" cols="30"  name="content" placeholder="문의 내용"  required="required"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div align="right" style="margin-top: 15px;">
			<input style="width: 10%;" type="submit" value="등록">
			<input style="width: 10%;" type="button" onclick="location.href='<c:url value="/inside/question.do" />'" value="취소">
		</div>
	</form>
	
	
	
	</div>
	<div style="position: fixed; bottom: 15%; right: 5%;">
		<a href="#top-btn">
			<img src="https://img.icons8.com/ultraviolet/50/000000/circled-chevron-up.png"/>
		</a>
	</div>
</div>



<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>