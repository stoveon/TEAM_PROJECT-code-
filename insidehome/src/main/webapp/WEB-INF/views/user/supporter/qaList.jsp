<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>
		<script type="text/javascript">
			var bDisplay = true;
			function doDisplay() {
				var con = document.getElementById("toDisplay");
				if (con.style.display == "none") {
					con.style.display = "block";
				} else {
					con.style.display = "none";
				}
			}
		</script>
<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">Q&A</h1>
	</div>
	<hr>
	<div class="info-inner">
		<form action="/user/question/list.do" method="POST">
			<div class="move">
				<ul>
					<li>
						<input type="button" value="Q&A" onclick="location.href='/user/supporter/qaList'" /> 
						<input type="button" value="고객문의" onclick="location.herf='/user/supporter/questionList'" /> 
						<input type="button" value="내 문의" onclick="location.herf='/user/supporter/questionDetail'" />
					</li>
				</ul>
			</div>
			<h2 class="title">Q&A</h2>
			<table>
			<tbody>
				<c:foreach items="${list}" var="all">
					<tr>
						<td colspan="2">${all.title}</td>
					</tr>
					<tr>
						<td><a href="javascript:doDisplay();">보이기/숨기기</a></td>
						<td id="toDisplay">
							<h1>${all.content}</h1>
						</td>
					</tr>
				</c:foreach>
			</tbody>
			</table>
		</form>


	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>