<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/WEB-INF/views/user/main/userHeader.jsp"%>


<div class="body-info">
	<div class="info-detail">
		<h1 class="info-title">신고창</h1>
	</div>
	<hr>
	<div class="info-inner">
		<form action="main.do" method="POST">
			<h2 class="title">신고창</h2>
			<input type="hidden" name="닉네임" <%=request.getParameter("nickname")%> />
				<table>
					<thead>
						<tr>
							<td>신고사유</td>
							<td>
								<select id="warntype" name="warntype">
									<option value="none">==선택==</option>
									<option value="혐오">혐오</option>
									<option value="욕설">욕설</option>
									<option value="학대">학대</option>
									<option value="광고">광고</option>
									<option value="음란">음란</option>
								</select>
							</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>신고 상세 사유</td>
							<td>
								<textarea name="warnwhy"
											placeholder="신고 사유를 최소 20자, 최대 300자  입력해주세요." 
											rows="15" cols="70">
								</textarea>
							</td>
						</tr>
					</tbody>
				</table>
			<button type="submit" value="등록" a href="javascript:history.go(1)">신고</button>
		</form>
	</div>
</div>

<%@include file="/WEB-INF/views/user/main/userFooter.jsp"%>